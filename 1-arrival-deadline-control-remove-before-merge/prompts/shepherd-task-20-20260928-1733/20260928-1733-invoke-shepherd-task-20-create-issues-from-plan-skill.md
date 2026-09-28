Invoke skill `shepherd-task-20-create-issues-from-plan` with these inputs:

- CAMPAIGN_ID: c7c931b1-4d64-4dbb-821f-e2addb41a67b
- LESSON_PROPAGATION: off
- REPO: edburns/dd-3070094-cargotracker-linux-x64-01
- BASE_BRANCH: experiment/shepherd-control
- PARENT_ISSUE: 1
- PLAN_DIRECTORY: 1-arrival-deadline-control-remove-before-merge
- PLAN_FILE_NAME: add-change-arrival-deadline-feature-ignorance-reduction-plan.md
- QUESTIONS_SECTION: ## Phase 3 — Ignorance reduction: questions to answer before writing code
- IMPLEMENTATION_SECTION: ## Phase 4 — Implementation (five serial issues)
- EXPECTED_TASK_COUNT: 5
- BASE_REMOTE: origin
- LOG_DIRECTORY: /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733
- DRAFT_VALIDATOR: /home/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh
- ISSUE_BODY_VERIFIER: /home/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh
- CHILD_LINK_VERIFIER: /home/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh

Fixture pagination response contract (mandatory):

- `gh api ... --paginate --slurp` returns a JSON array of page payloads, so a
  one-page response has the shape `[[{...}]]`, not `[{...}]`.
- Before indexing child issue fields such as `.id`, normalize the response to
  one flat issue array exactly once.
- In Bash, use:
  `jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'`.
- In PowerShell, capture the `gh` output and `$LASTEXITCODE` first, then pass
  the complete JSON through the same `jq` normalization before
  `ConvertFrom-Json`.
- Use the normalized flat array for the pre-creation baseline, final child
  count/order checks, and failure reconciliation. Do not apply `add` a second
  time to an already-flat array.
