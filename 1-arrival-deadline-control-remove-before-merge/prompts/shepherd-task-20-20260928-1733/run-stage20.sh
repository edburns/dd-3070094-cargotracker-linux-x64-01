#!/usr/bin/env bash

set -euo pipefail

REPO='edburns/dd-3070094-cargotracker-linux-x64-01'
PARENT_ISSUE='1'
EXPECTED_TASK_COUNT='5'
LESSON_PROPAGATION='off'
LOG_DIRECTORY='/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733'
DRAFT_VALIDATOR='/home/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh'
ISSUE_BODY_VERIFIER='/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'
CHILD_LINK_VERIFIER='/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh'
BODY_DIRECTORY="$LOG_DIRECTORY/issue-bodies"
LEDGER="$LOG_DIRECTORY/creation-ledger.json"
RESULT="$LOG_DIRECTORY/stage-20-result.json"
PRE_CREATION_CHILDREN="$LOG_DIRECTORY/pre-creation-children.json"
FINAL_CHILDREN="$LOG_DIRECTORY/final-children.json"

atomic_write() {
  local destination="$1"
  local content="$2"
  local temporary

  temporary="$(mktemp "${destination}.tmp.XXXXXX")" || return 1

  if ! printf '%s\n' "$content" > "$temporary"; then
    rm -f "$temporary"
    return 1
  fi

  if ! mv "$temporary" "$destination"; then
    rm -f "$temporary"
    return 1
  fi
}

update_ledger_flag() {
  local number="$1" field="$2" value="$3" updated
  updated="$(
    jq \
      --argjson number "$number" \
      --arg field "$field" \
      --argjson value "$value" \
      'map(if .number == $number then .[$field] = $value else . end)' \
      "$LEDGER"
  )" || return 1
  atomic_write "$LEDGER" "$updated"
}

normalize_children() {
  jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'
}

reconcile_and_fail() {
  local operation="$1"
  local error="$2"
  local children_output normalized reconciled failed_result

  if children_output="$(gh api "repos/$REPO/issues/$PARENT_ISSUE/sub_issues" --paginate --slurp 2>&1)"; then
    if normalized="$(printf '%s' "$children_output" | normalize_children 2>/dev/null)"; then
      reconciled="$(
        jq \
          --argjson child_ids "$(printf '%s' "$normalized" | jq '[.[].id]')" \
          'map(.id as $id | .linked = ($child_ids | index($id) != null))' \
          "$LEDGER"
      )"
      atomic_write "$LEDGER" "$reconciled"
    else
      error="$error; reconciliation response could not be normalized"
    fi
  else
    error="$error; reconciliation query failed: $children_output"
  fi

  failed_result="$(
    jq -n \
      --arg operation_error "$operation: $error" \
      '{
        schemaVersion: 1,
        status: "failed",
        ledgerFile: "creation-ledger.json",
        operationError: $operation_error
      }'
  )"
  atomic_write "$RESULT" "$failed_result"

  printf 'Stage 20 failed during %s: %s\n' "$operation" "$error" >&2
  if jq -e 'length == 0' "$LEDGER" >/dev/null; then
    printf 'No issues were created; no cleanup is required.\n' >&2
  else
    jq -r '.[] | "issue #\(.number) | \(.title) | \(.url) | \(.bodyFile) | body_verified=\(.body_verified) | linked=\(.linked)"' "$LEDGER" >&2
    jq -r --arg repo "$REPO" '.[] | "gh issue delete \(.number) --repo \"\($repo)\" --yes"' "$LEDGER" >&2
    printf 'The operation did not complete and no automatic rollback was performed. Delete every issue in the ledger before invoking stage 20 again.\n' >&2
  fi
  exit 1
}

"$DRAFT_VALIDATOR" "$BODY_DIRECTORY" "$EXPECTED_TASK_COUNT" "$LESSON_PROPAGATION"

atomic_write "$LEDGER" '[]'
atomic_write "$RESULT" \
  '{"schemaVersion":1,"status":"in_progress","ledgerFile":"creation-ledger.json","operationError":null}'
jq -e 'type == "array" and length == 0' "$LEDGER" >/dev/null
jq -e \
  '.schemaVersion == 1 and
   .status == "in_progress" and
   .ledgerFile == "creation-ledger.json" and
   .operationError == null' \
  "$RESULT" >/dev/null

if ! baseline_output="$(gh api "repos/$REPO/issues/$PARENT_ISSUE/sub_issues" --paginate --slurp 2>&1)"; then
  reconcile_and_fail 'pre-creation child query' "$baseline_output"
fi
if ! baseline="$(printf '%s' "$baseline_output" | normalize_children 2>&1)"; then
  reconcile_and_fail 'pre-creation child normalization' "$baseline"
fi
atomic_write "$PRE_CREATION_CHILDREN" "$baseline"
jq -e 'type == "array"' "$PRE_CREATION_CHILDREN" >/dev/null ||
  reconcile_and_fail 'pre-creation child snapshot validation' 'normalized snapshot is not an array'

subsections=(
  '4.1 — Issue 1: Add the application-layer deadline change operation'
  '4.2 — Issue 2: Expose deadline changes through the booking facade'
  '4.3 — Issue 3: Implement the deadline editor backing model'
  '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'
  '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'
)
titles=(
  '4.1: Add the application-layer deadline change operation'
  '4.2: Expose deadline changes through the booking facade'
  '4.3: Implement the deadline editor backing model'
  '4.4: Implement the PrimeFaces deadline dialog'
  '4.5: Integrate deadline editing into the Administration dashboard'
)
body_files=(
  "$BODY_DIRECTORY/01-4.1-body.md"
  "$BODY_DIRECTORY/02-4.2-body.md"
  "$BODY_DIRECTORY/03-4.3-body.md"
  "$BODY_DIRECTORY/04-4.4-body.md"
  "$BODY_DIRECTORY/05-4.5-body.md"
)

for index in "${!titles[@]}"; do
  title="${titles[$index]}"
  body_file="${body_files[$index]}"
  subsection="${subsections[$index]}"

  if ! create_json="$(
    gh api "repos/$REPO/issues" \
      -X POST \
      -f title="$title" \
      -F "body=@$body_file" \
      --jq '{id,number,node_id,html_url,title}' 2>&1
  )"; then
    reconcile_and_fail "create issue for $subsection" "$create_json"
  fi

  if ! id="$(printf '%s' "$create_json" | jq -er '.id')" ||
     ! number="$(printf '%s' "$create_json" | jq -er '.number')" ||
     ! url="$(printf '%s' "$create_json" | jq -er '.html_url')"; then
    reconcile_and_fail "parse created issue for $subsection" "$create_json"
  fi

  relative_body_file="issue-bodies/$(basename "$body_file")"
  if ! updated="$(
    jq \
      --arg implementationSubsection "$subsection" \
      --arg bodyFile "$relative_body_file" \
      --argjson id "$id" \
      --argjson number "$number" \
      --arg title "$title" \
      --arg url "$url" \
      '. + [{
        implementationSubsection: $implementationSubsection,
        bodyFile: $bodyFile,
        id: $id,
        number: $number,
        title: $title,
        url: $url,
        body_verified: false,
        linked: false
      }]' \
      "$LEDGER"
  )" || ! atomic_write "$LEDGER" "$updated"; then
    reconcile_and_fail "persist creation ledger for issue #$number" 'ledger update failed'
  fi

  if ! issue_json="$(
    "$ISSUE_BODY_VERIFIER" \
      "$REPO" \
      "$number" \
      "$body_file" \
      6 \
      5 \
      "$LOG_DIRECTORY/issue-$number-body-verification-failure.json" 2>&1
  )"; then
    reconcile_and_fail "verify body for issue #$number" "$issue_json"
  fi
  update_ledger_flag "$number" body_verified true ||
    reconcile_and_fail "persist body verification for issue #$number" 'ledger update failed'

  linked=false
  link_error=''
  for attempt in 1 2 3; do
    if link_output="$(
      printf '{"sub_issue_id": %s}' "$id" |
        gh api "repos/$REPO/issues/$PARENT_ISSUE/sub_issues" -X POST --input - 2>&1
    )"; then
      linked=true
      break
    fi
    link_error="$link_output"
    sleep "$attempt"
  done
  if [[ "$linked" != true ]]; then
    reconcile_and_fail "link issue #$number to parent #$PARENT_ISSUE" "$link_error"
  fi
  update_ledger_flag "$number" linked true ||
    reconcile_and_fail "persist linkage for issue #$number" 'ledger update failed'
done

if ! final_output="$(gh api "repos/$REPO/issues/$PARENT_ISSUE/sub_issues" --paginate --slurp 2>&1)"; then
  reconcile_and_fail 'final child query' "$final_output"
fi
if ! final="$(printf '%s' "$final_output" | normalize_children 2>&1)"; then
  reconcile_and_fail 'final child normalization' "$final"
fi
atomic_write "$FINAL_CHILDREN" "$final"

if ! link_verification="$(
  "$CHILD_LINK_VERIFIER" \
    "$PRE_CREATION_CHILDREN" \
    "$FINAL_CHILDREN" \
    "$LEDGER" 2>&1
)"; then
  reconcile_and_fail 'child-link postcondition verification' "$link_verification"
fi

while IFS=$'\t' read -r number relative_body_file; do
  body_file="$LOG_DIRECTORY/$relative_body_file"
  if ! issue_json="$(
    "$ISSUE_BODY_VERIFIER" \
      "$REPO" \
      "$number" \
      "$body_file" \
      6 \
      5 \
      "$LOG_DIRECTORY/issue-$number-final-body-verification-failure.json" 2>&1
  )"; then
    reconcile_and_fail "final body verification for issue #$number" "$issue_json"
  fi
  if ! printf '%s' "$issue_json" |
    jq -e '.state == "open" and (.assignees | type == "array" and length == 0)' >/dev/null; then
    reconcile_and_fail "state/assignee verification for issue #$number" 'issue must be open and unassigned'
  fi
done < <(jq -r '.[] | [.number, .bodyFile] | @tsv' "$LEDGER")

atomic_write "$RESULT" \
  '{"schemaVersion":1,"status":"complete","ledgerFile":"creation-ledger.json","operationError":null}'
jq -e \
  '.schemaVersion == 1 and
   .status == "complete" and
   .ledgerFile == "creation-ledger.json" and
   .operationError == null' \
  "$RESULT" >/dev/null

jq -c '.' "$LEDGER"
