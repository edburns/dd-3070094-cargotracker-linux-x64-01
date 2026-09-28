# Copilot CLI Session

> [!NOTE]
> - **Session ID:** `0b2dc987-a6da-4c58-a411-add9e6c594fb`  
> - **Started:** 9/28/2026, 5:33:50 PM  
> - **Duration:** 2m 56s  
> - **Exported:** 9/28/2026, 5:36:47 PM  

---

<sub>4s</sub>

### User

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

---

<sub>5s</sub>

### `skill`

**shepherd-task-20-create-issues-from-plan**

<details>
<summary>Arguments</summary>

```json
{
  "skill": "shepherd-task-20-create-issues-from-plan"
}
```

</details>

```
Skill "shepherd-task-20-create-issues-from-plan" loaded successfully. Follow the instructions in the skill context.
```


---

<sub>9s</sub>

### Copilot

I’m validating the campaign inputs, plan structure, repository state, and draft conventions before any GitHub mutation.

---

<sub>18s</sub>

### `view`

**view the file at /home/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/01-1682-java-tool-ergonomics.md.**

/home/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/01-1682-java-tool-ergonomics.md (lines 1--1)

<details>
<summary>15 lines</summary>

```
# Example 01: 1682-java-tool-ergonomics-prompts-remove-before-merge

Read `copilot-sdk/1682-java-tool-ergonomics-prompts-remove-before-merge/dd-3018003-ignorance-reduction-for-implementation-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 3 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating issues of type **Task** as children of Epic https://github.com/github/copilot-sdk/issues/1682 . These issues correspond to the sub-sections in `## Phase 4 — Implementation (the build order)`.

I want you to use `gh` to create issues as sub-issues of 1682.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Set the type to **Task**.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `upstream`: `edburns/1682-java-tool-ergonomics`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `1682-java-tool-ergonomics-prompts-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 4 — Implementation (the build order)` have essential details for each corresponding **Task**, I want you to carefully consider if there are additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>18s</sub>

### `view`

**view the file at /home/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/02-1810-java-tool-as-lambda.md.**

/home/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/02-1810-java-tool-as-lambda.md (lines 1--1)

<details>
<summary>12 lines</summary>

```
# Example 02: 1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge

Carefully read the plan `copilot-sdk/1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`.

We have completed Phases 1 - 3. We are now on Phase 4.

For each sub item in Phase 4, file a child issue of Feature #1810.

Use `gh` to look at Epic #1682 and its child issues for the standard of verbosity and concreteness for issue descriptions.

The issue should be assignable to a coding agent and there must be sufficient detail in the description for the agent to proceed to completion.

Pull out the specific relevant content from Phase 3 as it applies to this current issue in Phase 4.

Tell the agent to take `edburns/1810-java-tool-ergonomics-tool-as-lambda` as the base branch. When I assign the issue to the coding agent, I will set this as the base branch.

Tell the agent to read `1810-java-tool-ergonomics-tool-as-lambda-remove-before-merge/1810-ignorance-reduction-for-implementation-plan.md`, which is present on the branch, for context.

Tell the agent which sub-item within Phase 4 they are solving.

Tell the agent that each issue will be assigned, resolved and merged to the base branch in the order in which they appear in the plan.

No work is to start until I assign each issue to the coding agent, in turn.
```

</details>


---

<sub>18s</sub>

### `view`

**view the file at /home/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/03-dd-3017826-java-real-estate-demo.md.**

/home/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/03-dd-3017826-java-real-estate-demo.md (lines 1--1)

<details>
<summary>14 lines</summary>

```
# Example 03: dd-3017826-java-real-estate-demo-remove-before-merge

Read `dd-3017826-java-real-estate-demo-remove-before-merge\dd-3017826-java-real-estate-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/2 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #2.

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/2-build-out-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `dd-3017826-java-real-estate-demo-remove-before-merge`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there are additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>18s</sub>

### `view`

**view the file at /home/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/04-28-python-agent-demo.md.**

/home/edburns/.copilot/skills/shepherd-task-20-create-issues-from-plan/examples/04-28-python-agent-demo.md (lines 1--1)

<details>
<summary>16 lines</summary>

```
# Example 04: 28-python-agent-demo-remove-before-merge

Read `28-python-agent-demo-remove-before-merge/28-python-agent-demo-ignorance-reduction-plan.md` (the plan) to get the context.

✅✅Pay very close attention to each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`. These pertain to the implementation tasks in Phase 3. ✅✅✅ Include relevant spike findings as self-contained prose in the issue description; do not direct the agent to spike directories or source files.

In this session, we are creating sub-issues as children of https://github.com/edburns/Build26-BRK206-your-agent-anywhere-multiclient-multidevice-with-github-copilot-sdk/issues/28 . These issues correspond to the sub-sections in `## Phase 3 — Implementation (build order)`.

I want you to use `gh` to create issues as sub-issues of #28

- I will dispatch these issues by assigning them to an agent. Leave them unassigned for now.

- The description you put in the issues you create is the specification for the work the agent assigned to the issue must do. Therefore, you need to be very specific and targeted when writing the description.

- Again, ✅✅For each **Resolution:** to the questions in `Phase 2 — Ignorance reduction: questions to answer before writing code`, include the relevant Resolution values in the issue description. These pertain to the implementation tasks in Phase 3. ✅✅✅ State relevant spike findings directly in the issue body with enough detail to implement them without reading spike code.

- For tasks dealing with the UI, make sure to refer to the relevant screengrabs, but only ones within `28-python-agent-demo-remove-before-merge/`.

- Each issue will be worked on and resolved in serial. You can assume:
  - All issues will operate in this topic branch of `origin`: `edburns/28-python-agent-demo`.

  - The assignee agent has access to the topic branch and, most importantly, to the prompts in the directory `28-python-agent-demo-remove-before-merge/`, which includes the plan. Therefore, you can instruct the agent to access the plan by reference, you don't need to reference it by value directly in the issue.

- The sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue.

- Instruct the agent to read the entire plan before working.

- Instruct the agent to carefully re-read the relevant sections of the plan. ❌❌You can't just say, "read the relevant sections of the plan". ✅✅In the description of the issue, list exactly what sections of the plan apply to this particular issue.
- Though the sub-sections of `## Phase 3 — Implementation (build order)` have essential details for each corresponding sub-issue, I want you to carefully consider if there are additional gating tests you can add so that as the agent proceeds from one task to the next, the likelihood of rework is reduced.
```

</details>


---

<sub>18s</sub>

### `glob`

**1-arrival-deadline-control-remove-before-merge/****

"1-arrival-deadline-control-remove-before-merge/**"

<details>
<summary>10 matches</summary>

```
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/.stage20-before.1873120
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/campaign-lessons.md
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/shepherd-campaign.json
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/.stage20-after.1873120
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/shepherd-test-experiment.json
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/20260928-1733-invoke-shepherd-task-20-create-issues-from-plan-skill.md
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/20260928-1733-invoke-shepherd-task-20-create-issues-from-plan-skill.sh
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/create-issues-otel-20260928-1733.jsonl
/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/create-issues-session-20260928-1733.jsonl
```

</details>


---

<sub>18s</sub>

### `bash`

**Validate repository and invocation inputs**

$ set -euo pipefail
printf '%s\n' '--- repo ---'
git remote -v
git branch --show-current
git branch --list 'experiment/shepherd-control'
git remote get-url origin
printf '%s\n' '--- default branch / repo / parent ---'
gh api repos/edburns/dd-3070094-cargotracker-linux-x64-01 --jq '{default_branch,owner:.owner|{login,type}}'
gh api repos/edburns/dd-3070094-cargotracker-linux-x64-01/issues/1 --jq '{number,state,title,repository_url}'
printf '%s\n' '--- paths ---'
test -d '/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733'
test -w '/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733'
for f in '/home/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh' '/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh' '/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh'; do test -x "$f"; printf '%s executable\n' "$f"; done

<details>
<summary>14 lines</summary>

```
--- repo ---
origin	git@github.com:edburns/dd-3070094-cargotracker-linux-x64-01.git (fetch)
origin	git@github.com:edburns/dd-3070094-cargotracker-linux-x64-01.git (push)
experiment/shepherd-control
* experiment/shepherd-control
git@github.com:edburns/dd-3070094-cargotracker-linux-x64-01.git
--- default branch / repo / parent ---
{"default_branch":"20260902-2104Z-commit-e7b651f-liberty","owner":{"login":"edburns","type":"User"}}
{"number":1,"repository_url":"https://api.github.com/repos/edburns/dd-3070094-cargotracker-linux-x64-01","state":"open","title":"[Campaign][off] Cargo Tracker arrival-deadline control"}
--- paths ---
/home/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh executable
/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh executable
/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh executable
<shellId: 0 completed with exit code 0>
```

</details>


---

<sub>18s</sub>

### `sql`

**Track stage twenty work**

<details>
<summary>Arguments</summary>

```json
{
  "description": "Track stage twenty work",
  "query": "INSERT OR REPLACE INTO todos (id,title,description,status) VALUES ('stage20-preflight','Validating stage 20 inputs','Validate repository, parent, plan, campaign manifest, scripts, issue type, examples, and existing children','in_progress'),('stage20-drafts','Drafting implementation issues','Build traceability map and persist five complete issue body specifications','pending'),('stage20-create','Creating ordered child issues','Validate drafts, initialize artifacts, create, verify, and link each issue serially','pending'),('stage20-postconditions','Verifying stage 20 postconditions','Verify child linkage, issue bodies, state, assignees, type, and finalize result','pending'); INSERT OR IGNORE INTO todo_deps (todo_id,depends_on) VALUES ('stage20-drafts','stage20-preflight'),('stage20-create','stage20-drafts'),('stage20-postconditions','stage20-create')"
}
```

</details>

<details>
<summary>5 lines</summary>

```
Executed 2 statement(s):

1. INSERT
   4 row(s) inserted. Last inserted row ID: 4.

2. INSERT
   3 row(s) inserted. Last inserted row ID: 3.
```

</details>


---

<sub>26s</sub>

### `bash`

**Read first plan section from branch**

$ set -euo pipefail
git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md' | sed -n '1,260p'

<details>
<summary>200 lines</summary>

````
# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)

Human DRI: Ed Burns
Starting commit: `9b9f311b2a3a2854bdac947593950d9edb6bca7d` (`Make the system ready for implementation`)
Working directory: repository root of the current campaign worktree
Runtime baseline: Java 17, Java EE 7 (`javax.*`), Open Liberty 26.0.0.8, PrimeFaces 8.0
Baseline run instructions: `README.md`
Baseline preparation: fixed source branch and immutable SHA validated by the campaign fixture
Historical issue: `eclipse-ee4j/cargotracker#64`

Related directories and files:

- `src/main/java/org/eclipse/cargotracker/application/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/`
- `src/main/webapp/admin/dialogs/`
- `src/main/webapp/admin/tables/listNotRouted.xhtml`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

---

## Goal

Add an Administration dashboard operation that lets a shipping administrator
change the arrival deadline of a cargo listed in the **Not Routed Cargo** table.
The operation must preserve Cargo Tracker's layered architecture:

1. The application service owns the domain mutation.
2. The booking facade shields the web layer from domain types.
3. A JSF backing bean loads and submits the editable date.
4. A PrimeFaces dynamic dialog presents the editor.
5. The existing Not Routed Cargo table opens the dialog and refreshes after a
   successful update.

### User-visible acceptance behavior

Using the stable sample cargo `DEF789`:

1. Start the application with Java 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Open `http://localhost:8080/cargo-tracker/`.
3. Select **Administration**.
4. Find `DEF789` in the **Not Routed Cargo** table.
5. The Deadline cell displays its date together with an edit icon.
6. Hovering over the deadline displays:
   `Click to change cargo arrival deadline date.`
7. Selecting the deadline opens a modal dialog titled **Change Deadline**.
8. The dialog displays the cargo's origin and destination as read-only
   context.
9. The date editor is initialized to the cargo's current arrival deadline.
10. Selecting a different date and pressing **Update** closes the dialog and
    refreshes the Administration view.
11. The new date is shown in the Not Routed Cargo table.
12. Reloading the page continues to show the new date for the lifetime of the
    running in-memory sample application.
13. Pressing **Cancel** closes the dialog without changing the deadline.

### Domain acceptance behavior

Changing the deadline must:

- locate the cargo by `TrackingId`;
- preserve its existing origin;
- preserve its existing destination;
- replace only the arrival deadline in its `RouteSpecification`;
- apply the specification through `Cargo.specifyNewRoute(...)`;
- preserve the currently assigned itinerary rather than silently discarding
  it;
- allow the domain model to recalculate routing status and delivery-derived
  values against the new route specification;
- persist the changed cargo through `CargoRepository.store(...)`.

### Hard scope constraints

- Begin from commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d`.
- Preserve Java EE 7 and the `javax.*` namespace.
- Preserve the Java 7 source/target level used by this historical codebase.
- Run the application on JDK 17 using the existing Open Liberty profile.
- Do not migrate the application to Jakarta EE 8+, Jakarta EE 9+, Spring, or a
  different UI framework.
- Do not replace the in-memory Derby configuration or the Open Liberty runtime.
- Do not redesign unrelated cargo booking, routing, destination editing,
  messaging, batch, REST, or persistence behavior.
- Do not copy commits or files from feature-bearing branches. This plan is the
  implementation specification.
- Implement the five build issues below in order. Each issue must be complete
  and gated before the next issue begins.

---

## Completed phases

### Phase 1 ✅ — Establish a runnable feature-absent baseline

- Commit `9b9f311b2a3a2854bdac947593950d9edb6bca7d` is based on the historical
  feature-absent commit and contains only the compatibility work needed to run
  the sample on JDK 17 and Open Liberty.
- `./mvnw clean package -Popenliberty liberty:run` starts the application.
- The home page and Administration flows return HTTP 200.
- JSF view metadata is placed at `UIViewRoot` scope for MyFaces compatibility.
- The internal routing REST client works without a Jersey/MOXy classloading
  conflict.
- The scheduled batch job has the local authorization it needs.

### Phase 2 ✅ — Verify the before and after user experience

- Before implementation, `DEF789` appears in the Not Routed Cargo table with a
  plain-text deadline and no edit operation.
- The neighboring Destination column demonstrates the existing PrimeFaces
  dynamic-dialog interaction pattern.
- The desired after behavior has been manually exercised: open the deadline
  editor, choose a new date, update, refresh the table, and observe the
  persisted value.
- The historical architectural boundaries and affected files have been
  identified.

---

## Phase 3 — Ignorance reduction: questions to answer before writing code

Resolve these questions before production implementation begins. The
recommendations intentionally define the desired design closely enough that an
implementing agent should not need to invent a different architecture.

### 3.1 — Which cargos expose the edit operation?

**Question:** Should deadline editing be exposed for all cargos or only for
cargos displayed in the Not Routed Cargo table?

The requested feature originates in the Administration dashboard's Not Routed
Cargo table. Other tables represent routed, misrouted, claimed, or otherwise
progressed cargo. Adding the affordance to every table would expand the feature
and require additional business rules about changing deadlines after handling
has begun.

| Option | UI scope | Trade-off |
|--------|----------|-----------|
| A | Not Routed Cargo table only | Matches the requested feature and the established destination-edit affordance. |
| B | Every Administration cargo table | Broader capability, but introduces lifecycle and authorization questions outside the request. |
| C | Cargo details page only | Avoids table complexity but does not meet the requested dashboard interaction. |

The application-service operation itself does not need to encode a UI-table
restriction. It should accept a tracking ID and apply the domain mutation to
the located cargo. The presentation layer determines where the operation is
offered.

**Recommendation:** Option A. Add the edit affordance only to
`src/main/webapp/admin/tables/listNotRouted.xhtml`. Keep the application
operation generally usable for a valid cargo.

**Resolution:**

Select Option A. Expose the edit affordance only in
`src/main/webapp/admin/tables/listNotRouted.xhtml`. The application and facade
operations remain generally callable for any cargo that can be found by
tracking ID; they do not encode knowledge of dashboard table membership.

### 3.2 — What is the exact domain mutation?

**Question:** Should the feature mutate the existing `RouteSpecification`, add
a setter to `Cargo`, or replace the specification using the existing domain
operation?

`RouteSpecification` is a value object describing origin, destination, and
arrival deadline. The existing `changeDestination(...)` implementation already
establishes the correct pattern: create a replacement specification, call
`Cargo.specifyNewRoute(...)`, and store the aggregate.

Proposed application-service shape:

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

Proposed implementation:

```java
Cargo cargo = cargoRepository.find(trackingId);
RouteSpecification specification = new RouteSpecification(
        cargo.getOrigin(),
        cargo.getRouteSpecification().getDestination(),
        deadline);

cargo.specifyNewRoute(specification);
cargoRepository.store(cargo);
```

Calling `specifyNewRoute(...)` is significant. It lets the aggregate recalculate
delivery and routing status relative to the new specification. Direct field
mutation or a persistence-only update would bypass that behavior.

**Recommendation:** Replace the `RouteSpecification` through
`Cargo.specifyNewRoute(...)`. Preserve origin, destination, and itinerary.
Persist using the existing repository. Do not add a deadline setter to the
domain model.

**Resolution:**

Use the same aggregate-update pattern as `changeDestination(...)`. Add
`BookingService.changeDeadline(TrackingId, Date)` and implement it by loading
the cargo, constructing a new `RouteSpecification` from the existing origin,
existing destination, and supplied deadline, calling
`cargo.specifyNewRoute(...)`, and storing the cargo through
`cargoRepository.store(...)`. Do not add mutable deadline setters to the domain
objects.

### 3.3 — What should happen to an existing itinerary and delivery state?

**Question:** When a routed cargo's deadline changes, should its itinerary be
cleared, retained, or recomputed?

Although the UI initially exposes the feature only for unrouted cargo, the
application operation should have deterministic domain behavior if invoked for
a routed cargo. The existing `changeDestination(...)` behavior preserves the
assigned itinerary and lets `Cargo.specifyNewRoute(...)` recalculate whether
that itinerary still satisfies the new specification.

The core application test should deliberately invoke the operation after:

1. booking a cargo;
2. requesting route candidates;
3. assigning an itinerary;
4. changing its destination;
5. changing its deadline.

This sequence verifies that the feature uses the aggregate correctly rather
than assuming the cargo always has an empty itinerary.

**Recommendation:** Preserve the itinerary. Let the domain model recompute
routing and delivery-derived state. Assert all unaffected fields explicitly in
`BookingServiceTest`.

**Resolution:**

Retain the existing itinerary. Do not clear, replace, or reroute it as part of
the deadline change. `Cargo.specifyNewRoute(...)` recalculates the delivery
snapshot and routing status against the replacement specification. In the
established sequential application test, the assigned itinerary remains
unchanged and the cargo remains `MISROUTED` after the deadline changes.

### 3.4 — What type crosses the facade boundary?

**Question:** Should the booking facade accept a `Date`, a formatted string, or
a newly introduced request DTO?

The existing facade already uses `java.util.Date` for
`bookNewCargo(...)`. Introducing another representation for this one operation
would create unnecessary conversion code and depart from the historical
application style.

Proposed facade shape:

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```
<shellId: 2 completed with exit code 0>
````

</details>


---

<sub>26s</sub>

### `bash`

**Read remaining plan from branch**

$ set -euo pipefail
git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md' | sed -n '261,620p'

<details>
<summary>267 lines</summary>

````
The implementation converts only the identifier:

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

**Recommendation:** Use `String` for the tracking ID and `java.util.Date` for
the deadline. Do not expose `TrackingId`, `Cargo`, or `RouteSpecification` to
the JSF layer and do not introduce a new DTO solely for this command.

**Resolution:**

Add `void changeDeadline(String trackingId, Date arrivalDeadline)` to
`BookingServiceFacade`. `DefaultBookingServiceFacade` converts the string to
`new TrackingId(trackingId)` and passes the same `Date` to
`BookingService.changeDeadline(...)`. No new command DTO or formatted-string
service parameter is introduced.

### 3.5 — How is the DTO's formatted deadline converted for editing?

**Question:** `CargoRoute` exposes its deadline as formatted strings, while
`p:datePicker` binds naturally to `java.util.Date`. How should the backing bean
initialize the editor?

At the starting commit:

- `CargoRoute.getArrivalDeadline()` returns
  `MM/dd/yyyy hh:mm a z`.
- `CargoRoute.getArrivalDeadlineDate()` returns only the date component.
- The table displays `getArrivalDeadlineDate()`.

Options:

| Option | Approach | Trade-off |
|--------|----------|-----------|
| A | Parse `cargo.getArrivalDeadlineDate()` with `MM/dd/yyyy` | Small, localized change; preserves the existing DTO contract. |
| B | Add a `Date` property to `CargoRoute` | Cleaner typing, but broadens a DTO used throughout the application. |
| C | Reload the domain object in the backing bean | Violates the facade boundary. |

The formatter/parser must be created per operation or per view bean; do not add
a shared mutable `SimpleDateFormat`.

**Recommendation:** Option A. Load `CargoRoute` through
`BookingServiceFacade.loadCargoForRouting(trackingId)` and parse
`cargo.getArrivalDeadlineDate()` using `new SimpleDateFormat("MM/dd/yyyy")`.
Surface an explicit failure if the existing DTO value cannot be parsed; do not
silently submit a null date.

**Resolution:**

Use Option A and keep date conversion inside the view-scoped editor bean. The
existing implementation loads the `CargoRoute`, creates
`new SimpleDateFormat("MM/dd/yyyy")`, and parses the leading date portion of
`cargo.getArrivalDeadline()`. Because that value begins with `MM/dd/yyyy`,
`SimpleDateFormat.parse(...)` obtains the same date that
`getArrivalDeadlineDate()` displays. A per-load formatter is used, so no shared
mutable formatter is added.

### 3.6 — Which JSF bean scopes and interaction pattern should be used?

**Question:** Should deadline editing introduce a new navigation page, use an
inline editor, or mirror the existing Change Destination dynamic-dialog
pattern?

The baseline already contains:

- `ChangeDestination`, a CDI `@Named` and JSF `@ViewScoped` editor bean;
- `ChangeDestinationDialog`, a session-scoped JSF managed bean that opens and
  closes a PrimeFaces dynamic dialog;
- `changeDestination.xhtml`, a dialog view;
- a `dialogReturn` Ajax listener that refreshes `tableNotRouted`.

Using the same pattern minimizes changes and provides a consistent user
experience.

Proposed bean names:

```text
changeArrivalDeadlineDate
changeArrivalDeadlineDateDialog
```

**Recommendation:** Add a serializable CDI `@Named @ViewScoped`
`ChangeArrivalDeadlineDate` editor and a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped`
launcher. Mirror the existing destination-dialog lifecycle rather than
introducing a new navigation or inline-edit framework.

**Resolution:**

Mirror the existing Change Destination interaction. Implement
`ChangeArrivalDeadlineDate` as a serializable CDI `@Named @ViewScoped` bean and
`ChangeArrivalDeadlineDateDialog` as a serializable
`@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped` bean.
Use a PrimeFaces dynamic dialog rather than navigation to a full page or inline
cell editing.

### 3.7 — What is the dynamic-dialog contract?

**Question:** What path, request parameters, dimensions, and close result should
the PrimeFaces dialog use?

The launcher needs one parameter, `trackingId`, supplied as a
`Map<String, List<String>>`. The dialog metadata binds the parameter and invokes
the editor bean's `load()` action.

Proposed launcher contract:

```java
PrimeFaces.current().dialog().openDynamic(
        "/admin/dialogs/changeArrivalDeadlineDate.xhtml",
        options,
        params);
```

Required options:

| Option | Value |
|--------|-------|
| `modal` | `true` |
| `draggable` | `true` |
| `resizable` | `false` |
| `contentWidth` | `410` |
| `contentHeight` | `280` |

Required completion behavior:

- successful update: `closeDynamic("DONE")`;
- cancel: `closeDynamic("")`;
- caller listens for `dialogReturn` and updates `tableNotRouted`.

Because Open Liberty uses MyFaces, `<f:metadata>` must be a direct child of the
view root, before `<h:head>` and `<h:body>`. It must not be nested inside
`<h:body>`.

**Recommendation:** Use the contract above and preserve the metadata placement
required by the prepared baseline.

**Resolution:**

Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with a single
`trackingId` request parameter and these options: modal and draggable are
`true`, resizable is `false`, content width is `410`, and content height is
`280`. Successful submission closes with `"DONE"`; cancellation closes with
the empty string. The caller handles `dialogReturn` and updates
`tableNotRouted`. Place the dialog's `<f:metadata>` directly under the root
`<html>` element, before `<h:head>` and `<h:body>`, so the known MyFaces
`UIViewRoot` requirement is satisfied.

### 3.8 — What date validation is required?

**Question:** Must the new deadline be non-null, in the future, after the
current date, or after itinerary completion?

The requested feature is an administrative correction to an existing arrival
deadline. No new domain policy about future dates is part of the request.
Inventing such a rule could reject dates accepted by existing cargo booking or
`RouteSpecification` behavior.

The UI must nevertheless prevent a null submission because the operation
requires a concrete replacement deadline.

**Recommendation:** Require a date value in the JSF form and display a normal
Faces validation message when it is absent. Do not add a new minimum-date,
future-date, or itinerary-date business rule. Continue to rely on the existing
domain model for its established invariants.

**Resolution:**

Require a non-null date selection, but add no new chronological business rule.
In particular, do not require the replacement deadline to be after today,
after the old deadline, or after every itinerary leg. Pass the selected
`java.util.Date` to the existing domain construction path and let the current
`RouteSpecification` invariants apply.

### 3.9 — How will the feature be tested on the prepared historical baseline?

**Question:** Which automated and runtime tests are mandatory, given that the
historical JUnit/Arquillian suite is configured for a remote Payara 4
container, while the prepared production baseline runs on JDK 17/Open Liberty?

The starting POM deliberately leaves `skipTests=true`. The Open Liberty profile
builds and compiles all test sources but does not provide a Liberty Arquillian
adapter. Modernizing the entire integration-test runtime is outside this
feature's scope.

The feature still needs layered evidence:

1. Extend `BookingServiceTest` with the domain/application assertions that
   specify the deadline mutation.
2. Ensure all test sources compile as part of
   `./mvnw clean package -Popenliberty`.
3. Add focused JUnit tests for facade and backing-bean delegation where they
   can run without a container, using hand-written fakes rather than adding a
   mocking framework.
4. Perform mandatory end-to-end verification against the running Open Liberty
   application.
5. Preserve the existing Payara Arquillian test path; do not delete, disable,
   or rewrite it to manufacture a passing result.

**Spike needed:** Before Issue 1 implementation, run the starting commit's
standard Open Liberty package command and record whether tests are compiled but
skipped. Confirm the new `BookingServiceTest` method can be added without
expanding the runtime modernization scope.

**Recommendation:** Treat the JDK 17/Open Liberty build plus HTTP/UI acceptance
as the mandatory executable gate. Keep the historical Arquillian test as a
precise application-layer specification and run it only when its documented
Payara environment is available.

**Resolution:**

Extend the existing sequential Arquillian `BookingServiceTest` with
`testChangeDeadline()` after `testChangeDestination()`. The test changes the
deadline by one month, reloads the cargo through JPA, and asserts the complete
set of preserved and recalculated domain state described above. The prepared
Open Liberty build compiles this test but retains the historical default
`skipTests=true`; executing that Arquillian suite still requires its documented
remote Payara environment. Therefore the mandatory executable gates are the
JDK 17 Open Liberty package/start command, direct HTTP checks, and the complete
`DEF789` browser acceptance flow. No Arquillian-runtime modernization or new
mocking dependency is part of this feature.

---

## Phase 4 — Implementation (five serial issues)

Implement these issues in order. Each issue should be a separate commit. Do not
start an issue until the previous issue's gating criteria are satisfied.

### 4.1 — Issue 1: Add the application-layer deadline change operation

**What to build**

Add the core use case to the application layer. This issue must contain no JSF
or PrimeFaces changes.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`
- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

**Required API**

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

**Required implementation behavior**

1. Load the cargo using `cargoRepository.find(trackingId)`.
2. Obtain the current destination from
   `cargo.getRouteSpecification().getDestination()`.
3. Construct a replacement `RouteSpecification` from:
   - `cargo.getOrigin()`;
   - the current destination;
   - the new deadline.
4. Apply it using `cargo.specifyNewRoute(routeSpecification)`.
5. Persist using `cargoRepository.store(cargo)`.
6. Log the tracking ID and new deadline at `Level.INFO`, following the style of
   `changeDestination(...)`.

Do not:

- add a setter to `Cargo` or `RouteSpecification`;
- modify the origin or destination;
- clear or replace the itinerary directly;
- update persistence entities behind the aggregate's back.

**Tests to write first**

Append a sequential `testChangeDeadline()` case to `BookingServiceTest` after
`testChangeDestination()`. Build a new deadline one month after the test's
original `deadline`, invoke the service, reload the cargo with
`Cargo.findByTrackingId`, and assert:

- origin remains Chicago;
- destination remains Helsinki;
- stored deadline is the same calendar day as the requested new deadline;
- assigned itinerary remains unchanged;
- transport status remains `NOT_RECEIVED`;
- last known location remains `Location.UNKNOWN`;
- current voyage remains `Voyage.NONE`;
- cargo is not marked misdirected;
- estimated time of arrival is `Delivery.ETA_UNKOWN`;
- next expected activity is `Delivery.NO_ACTIVITY`;
- cargo is not unloaded at destination;
- routing status reflects the domain model's recalculation and remains
  `MISROUTED` for the established test sequence.

**Gating criteria**

- The test source compiles.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- No web, facade, REST, Liberty, or persistence configuration files change in
  this issue.

### 4.2 — Issue 2: Expose deadline changes through the booking facade

**What to build**

Expose the use case to presentation clients without leaking domain identifier
types into the web layer.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`

**Optional focused test file**

- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`

**Required API**

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

**Required implementation**

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

The facade must not:

- load and mutate `Cargo` itself;
- call `CargoRepository.store(...)`;
- parse a formatted date;
- introduce JSF or PrimeFaces types.

**Tests**

Where a container-free test is added, use a hand-written `BookingService` fake
or spy and prove that:

- the same `Date` object/value reaches the application service;
- the tracking-ID string is converted to an equivalent `TrackingId`;
- the facade delegates exactly once;
- no repository work is duplicated in the facade.

Do not add Mockito or another dependency solely for this test.

**Gating criteria**

- Existing facade consumers still compile.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- The application-layer test added in Issue 1 remains unchanged and compiling.

### 4.3 — Issue 3: Implement the deadline editor backing model

**What to build**

Add the view-scoped backing bean that loads a cargo's current deadline and
<shellId: 4 completed with exit code 0>
````

</details>


---

<sub>26s</sub>

### `bash`

**Read campaign metadata and headings**

$ set -euo pipefail
printf '%s\n' '--- manifest ---'
git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/shepherd-campaign.json'
printf '%s\n' '--- lessons existence ---'
git cat-file -e 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/campaign-lessons.md'
printf '%s\n' '--- headings ---'
git show 'experiment/shepherd-control:1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md' | grep -n '^#'

<details>
<summary>46 lines</summary>

```
--- manifest ---
{
  "schemaVersion": 1,
  "campaignId": "c7c931b1-4d64-4dbb-821f-e2addb41a67b",
  "campaignIssueNumber": 1,
  "campaignShortname": "arrival-deadline-control",
  "repository": "edburns/dd-3070094-cargotracker-linux-x64-01",
  "baseBranch": "experiment/shepherd-control",
  "lessonPropagation": "off",
  "campaignMetadataDirectory": "1-arrival-deadline-control-remove-before-merge",
  "lessonsFile": "campaign-lessons.md",
  "createdBy": {
    "shepherdTaskVersion": "1.0.5",
    "stageOutcomeProtocolVersion": 1
  },
  "createdAt": "2026-09-28T17:33:47Z"
}
--- lessons existence ---
--- headings ---
1:# Implementation plan: Change Arrival Deadline Date (`eclipse-ee4j/cargotracker#64`)
22:## Goal
35:### User-visible acceptance behavior
62:### Domain acceptance behavior
77:### Hard scope constraints
95:## Completed phases
97:### Phase 1 ✅ — Establish a runnable feature-absent baseline
109:### Phase 2 ✅ — Verify the before and after user experience
123:## Phase 3 — Ignorance reduction: questions to answer before writing code
129:### 3.1 — Which cargos expose the edit operation?
162:### 3.2 — What is the exact domain mutation?
211:### 3.3 — What should happen to an existing itinerary and delivery state?
245:### 3.4 — What type crosses the facade boundary?
281:### 3.5 — How is the DTO's formatted deadline converted for editing?
321:### 3.6 — Which JSF bean scopes and interaction pattern should be used?
360:### 3.7 — What is the dynamic-dialog contract?
412:### 3.8 — What date validation is required?
438:### 3.9 — How will the feature be tested on the prepared historical baseline?
488:## Phase 4 — Implementation (five serial issues)
493:### 4.1 — Issue 1: Add the application-layer deadline change operation
561:### 4.2 — Issue 2: Expose deadline changes through the booking facade
616:### 4.3 — Issue 3: Implement the deadline editor backing model
695:### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog
792:### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard
876:## Phase 5 — Documentation and implementation handoff
895:## Cross-cutting concerns
<shellId: 3 completed with exit code 0>
```

</details>


---

<sub>26s</sub>

### `bash`

**Capture normalized existing children**

$ set -euo pipefail
raw="$(gh api 'repos/edburns/dd-3070094-cargotracker-linux-x64-01/issues/1/sub_issues' --paginate --slurp)"
printf '%s' "$raw" | jq 'if length == 0 then [] elif all(.[]; type == "array") then add else . end'

```
[]
<shellId: 1 completed with exit code 0>
```


---

<sub>33s</sub>

### `view`

**view the file at /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md.**

/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md (lines 488-620)

<details>
<summary>94 lines</summary>

````
## Phase 4 — Implementation (five serial issues)

Implement these issues in order. Each issue should be a separate commit. Do not
start an issue until the previous issue's gating criteria are satisfied.

### 4.1 — Issue 1: Add the application-layer deadline change operation

**What to build**

Add the core use case to the application layer. This issue must contain no JSF
or PrimeFaces changes.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`
- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`
- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`

**Required API**

```java
void changeDeadline(TrackingId trackingId, Date deadline);
```

**Required implementation behavior**

1. Load the cargo using `cargoRepository.find(trackingId)`.
2. Obtain the current destination from
   `cargo.getRouteSpecification().getDestination()`.
3. Construct a replacement `RouteSpecification` from:
   - `cargo.getOrigin()`;
   - the current destination;
   - the new deadline.
4. Apply it using `cargo.specifyNewRoute(routeSpecification)`.
5. Persist using `cargoRepository.store(cargo)`.
6. Log the tracking ID and new deadline at `Level.INFO`, following the style of
   `changeDestination(...)`.

Do not:

- add a setter to `Cargo` or `RouteSpecification`;
- modify the origin or destination;
- clear or replace the itinerary directly;
- update persistence entities behind the aggregate's back.

**Tests to write first**

Append a sequential `testChangeDeadline()` case to `BookingServiceTest` after
`testChangeDestination()`. Build a new deadline one month after the test's
original `deadline`, invoke the service, reload the cargo with
`Cargo.findByTrackingId`, and assert:

- origin remains Chicago;
- destination remains Helsinki;
- stored deadline is the same calendar day as the requested new deadline;
- assigned itinerary remains unchanged;
- transport status remains `NOT_RECEIVED`;
- last known location remains `Location.UNKNOWN`;
- current voyage remains `Voyage.NONE`;
- cargo is not marked misdirected;
- estimated time of arrival is `Delivery.ETA_UNKOWN`;
- next expected activity is `Delivery.NO_ACTIVITY`;
- cargo is not unloaded at destination;
- routing status reflects the domain model's recalculation and remains
  `MISROUTED` for the established test sequence.

**Gating criteria**

- The test source compiles.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- No web, facade, REST, Liberty, or persistence configuration files change in
  this issue.

### 4.2 — Issue 2: Expose deadline changes through the booking facade

**What to build**

Expose the use case to presentation clients without leaking domain identifier
types into the web layer.

**Files to modify**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`
- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`

**Optional focused test file**

- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`

**Required API**

```java
void changeDeadline(String trackingId, Date arrivalDeadline);
```

**Required implementation**

```java
bookingService.changeDeadline(
        new TrackingId(trackingId),
        arrivalDeadline);
```

The facade must not:

- load and mutate `Cargo` itself;
- call `CargoRepository.store(...)`;
- parse a formatted date;
- introduce JSF or PrimeFaces types.

**Tests**

Where a container-free test is added, use a hand-written `BookingService` fake
or spy and prove that:

- the same `Date` object/value reaches the application service;
- the tracking-ID string is converted to an equivalent `TrackingId`;
- the facade delegates exactly once;
- no repository work is duplicated in the facade.

Do not add Mockito or another dependency solely for this test.

**Gating criteria**

- Existing facade consumers still compile.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.
- The application-layer test added in Issue 1 remains unchanged and compiling.

### 4.3 — Issue 3: Implement the deadline editor backing model

**What to build**

Add the view-scoped backing bean that loads a cargo's current deadline and
````

</details>


---

<sub>33s</sub>

### `view`

**view the file at /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md.**

/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md (lines 616-790)

<details>
<summary>125 lines</summary>

````
### 4.3 — Issue 3: Implement the deadline editor backing model

**What to build**

Add the view-scoped backing bean that loads a cargo's current deadline and
submits a replacement deadline through the booking facade. Do not add the
dialog launcher or XHTML in this issue.

**File to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`

**Required bean shape**

```java
@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {
    private static final long serialVersionUID = 1L;

    private String trackingId;
    private CargoRoute cargo;
    private Date arrivalDeadlineDate;

    @Inject
    private BookingServiceFacade bookingServiceFacade;
}
```

Required properties and methods:

- `getTrackingId()` / `setTrackingId(String)`
- `getCargo()`
- `getArrivalDeadlineDate()` / `setArrivalDeadlineDate(Date)`
- `load()`
- `changeArrivalDeadline()`

**Load behavior**

1. Call `bookingServiceFacade.loadCargoForRouting(trackingId)`.
2. Store the returned `CargoRoute`.
3. Parse `cargo.getArrivalDeadlineDate()` using `MM/dd/yyyy`.
4. Store the resulting `Date` in `arrivalDeadlineDate`.
5. Do not query a repository or domain object directly.
6. Do not ignore a parsing failure or merely print its stack trace. Surface a
   clear application/view error consistent with existing JSF behavior.

**Submit behavior**

1. Refuse a null date through JSF validation or explicit bean validation.
2. Call
   `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`.
3. Close the dynamic dialog with:

   ```java
   PrimeFaces.current().dialog().closeDynamic("DONE");
   ```

4. Do not close the dialog if the facade call fails.

**Tests to write**

Add a container-free JUnit test if practical, using a hand-written fake facade,
that proves:

- `load()` requests the correct tracking ID;
- `load()` converts an `MM/dd/yyyy` DTO date into the editable `Date`;
- `changeArrivalDeadline()` delegates the selected date and tracking ID;
- a malformed DTO deadline is surfaced rather than converted to null;
- a null selected date is rejected.

Do not add a mocking framework solely for these tests.

**Gating criteria**

- The bean is serializable and uses the established CDI/JSF annotations.
- The bean references only facade DTOs, not domain model classes.
- `./mvnw clean package -Popenliberty` succeeds on JDK 17.

### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog

**What to build**

Add the session-scoped dialog launcher and the dynamic dialog view. The dialog
must work when addressed directly with a `trackingId` query parameter, but it
is not yet linked from the dashboard in this issue.

**Files to create**

- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`
- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`

**Launcher requirements**

Use:

```java
@ManagedBean(name = "changeArrivalDeadlineDateDialog")
@SessionScoped
```

Implement:

- `showDialog(String trackingId)`
- `handleReturn(SelectEvent event)`
- `cancel()`

`showDialog(...)` must:

- set the options documented in Question 3.7;
- pass `trackingId` as a dynamic-dialog request parameter;
- open `/admin/dialogs/changeArrivalDeadlineDate.xhtml`.

`cancel()` must close the dialog without invoking the facade.

**XHTML requirements**

The page title must be:

```xhtml
<title>Change Deadline</title>
```

Place metadata directly beneath the root `<html>` element and before
`<h:head>`:

```xhtml
<f:metadata>
    <f:viewParam name="trackingId"
                 value="#{changeArrivalDeadlineDate.trackingId}"/>
    <f:viewAction action="#{changeArrivalDeadlineDate.load}"/>
</f:metadata>
```

The form must display:

- `Origin:` and `changeArrivalDeadlineDate.cargo.originName`;
- `Destination:` and
  `changeArrivalDeadlineDate.cargo.finalDestinationName`;
- `Deadline:` and a `p:datePicker` bound to
  `changeArrivalDeadlineDate.arrivalDeadlineDate`;
- **Cancel**, invoking
  `changeArrivalDeadlineDateDialog.cancel()`;
- **Update**, invoking
  `changeArrivalDeadlineDate.changeArrivalDeadline()`.

The date picker must require a value. The Update action must reload or refresh
the calling Administration view after a successful dialog close, following the
existing destination-dialog behavior.

**Runtime tests**

With the application running, request:

```text
http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789
```

Verify:

- HTTP 200;
- title is **Change Deadline**;
- origin and destination render;
- the existing deadline is selected;
- no `TagException`, `Parent UIComponent`, `FacesException`, or server error is
  present;
- Cancel does not change the persisted deadline;
- Update changes the deadline.

**Gating criteria**

- `./mvnw clean package -Popenliberty liberty:run` succeeds on JDK 17.
- Direct dialog loading and both actions work.
- Destination editing continues to work.
- Stop Liberty cleanly before completing the issue.
````

</details>


---

<sub>33s</sub>

### `view`

**view the file at /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md.**

/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md (lines 792-940)

<details>
<summary>92 lines</summary>

````
### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard

**What to build**

Replace the plain deadline text in the Not Routed Cargo table with the
PrimeFaces command-link affordance that opens the completed dialog and refreshes
the table after return.

**File to modify**

- `src/main/webapp/admin/tables/listNotRouted.xhtml`

**Required UI shape**

Within the existing Deadline column, add a `p:commandLink` that:

- calls
  `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;
- retains the displayed
  `cargoNotRouted.arrivalDeadlineDate`;
- adds the existing Font Awesome edit icon style;
- uses a stable component ID such as `arrivalDeadlineToUpdate`;
- listens for `dialogReturn`;
- invokes
  `changeArrivalDeadlineDateDialog.handleReturn`;
- updates `tableNotRouted`;
- provides the tooltip:
  `Click to change cargo arrival deadline date.`

Follow the adjacent Destination column's established structure and styling. Do
not alter tracking-ID routing or destination editing.

**End-to-end acceptance test**

1. Start from a clean build on JDK 17:

   ```bash
   ./mvnw clean package -Popenliberty liberty:run
   ```

2. Confirm the home page returns HTTP 200.
3. Open Administration and locate `DEF789`.
4. Record the original deadline.
5. Confirm the deadline now has an edit icon and tooltip.
6. Open the deadline dialog.
7. Confirm origin and destination identify the same cargo.
8. Choose a visibly different date.
9. Press **Update**.
10. Confirm the dialog closes and the Not Routed Cargo table refreshes.
11. Confirm the table shows the selected date.
12. Reload the browser and confirm the selected date remains.
13. Reopen the dialog and confirm the editor initializes to the changed date.
14. Press **Cancel** and confirm no additional change occurs.
15. Verify the Destination edit dialog still opens.
16. Verify selecting `DEF789` for routing still loads without an error page.

**Log acceptance**

The final run must contain none of:

- `<f:metadata> Parent UIComponent`;
- `TagException`;
- `VerifyError`;
- `FacesException`;
- `CWWKZ0002E` or `CWWKZ0003E`;
- recurring batch authorization failures;
- new FFDC files attributable to this feature.

Transient JMS activation-order warnings are acceptable only if all message
endpoints subsequently activate, as established by the prepared baseline.

**Final regression and scope checks**

- `./mvnw clean package -Popenliberty` succeeds.
- The existing test sources and the new deadline test compile.
- No Java EE namespace migration occurred.
- No Open Liberty, Derby, Jackson, JSF metadata, batch authorization, or REST
  compatibility fix from the starting commit was reverted.
- The feature affects only the intended application, facade, web, dialog,
  table, and test surfaces.
- Stop Liberty cleanly.

---

## Phase 5 — Documentation and implementation handoff

- Update `README.md` only if user-facing Administration capabilities are
  enumerated there; add one concise sentence that administrators can change an
  unrouted cargo's arrival deadline.
- Record the exact JDK 17 run command in the final issue or pull-request
  description:

  ```bash
  ./mvnw clean package -Popenliberty liberty:run
  ```

- Include `DEF789` and the before/after deadline values in the acceptance
  evidence.
- State explicitly that data is in-memory and resets when the application is
  rebuilt/restarted.

---

## Cross-cutting concerns

| Concern | Required handling |
|---------|--------------------|
| Domain-driven design | Mutate the aggregate through `Cargo.specifyNewRoute(...)`; do not bypass it with persistence-level field updates. |
| Layering | Web bean → booking facade → booking service → cargo repository. |
| Date handling | Use `java.util.Date` at service/facade boundaries and `MM/dd/yyyy` for the date-only editor representation. |
| Time zones | Acceptance compares the calendar date displayed by the application; do not introduce a new timezone policy in this feature. |
| Error handling | Do not silently swallow parse, lookup, validation, or persistence failures. A failed update must not look successful. |
| JSF compatibility | Keep `<f:metadata>` at view-root scope for MyFaces. |
| Bean lifecycle | Editor is CDI `@ViewScoped`; dynamic-dialog launcher mirrors the existing session-scoped JSF managed bean. |
| Accessibility | Preserve visible labels; the date editor must have an associated label and validation feedback. |
| Backward compatibility | Existing destination editing, routing, tracking, REST, messaging, batch, and startup behavior must remain intact. |
| Test discipline | Add tests before production code where practical; every issue must preserve all prior gates. |
| Experiment integrity | Implement from this specification starting at `9b9f311b2a3a2854bdac947593950d9edb6bca7d`; do not cherry-pick or inspect feature-bearing commits. |
````

</details>


---

<sub>33s</sub>

### `bash`

**Verify exact headings and task count**

$ set -euo pipefail
plan='1-arrival-deadline-control-remove-before-merge/add-change-arrival-deadline-feature-ignorance-reduction-plan.md'
q='## Phase 3 — Ignorance reduction: questions to answer before writing code'
i='## Phase 4 — Implementation (five serial issues)'
text="$(git show "experiment/shepherd-control:$plan")"
printf '%s\n' "$text" | grep -Fxc "$q"
printf '%s\n' "$text" | grep -Fxc "$i"
printf '%s\n' "$text" | awk 'BEGIN{in_impl=0;c=0} /^## Phase 4 — Implementation \(five serial issues\)$/{in_impl=1;next} /^## /{if(in_impl)exit} in_impl && /^### /{c++} END{print c}'

```
1
1
5
<shellId: 5 completed with exit code 0>
```


---

<sub>33s</sub>

### `bash`

**Prepare writable issue body directory**

$ set -euo pipefail
mkdir -p '/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies'
test -w '/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies'

```

<shellId: 6 completed with exit code 0>
```


---

<sub>37s</sub>

### Copilot

Preflight passed: the base branch is non-default, parent #1 is open, the repository owner is a user (so children will be untyped), all nine gating questions have substantive resolutions, and the implementation section contains exactly five direct tasks. I’m now persisting the traceable issue specifications and validating them before creation.

---

<sub>38s</sub>

### `view`

**view the file at /home/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh.**

/home/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh (lines 1--1)

<details>
<summary>65 lines</summary>

```
#!/usr/bin/env bash
# shepherd-task-version: 1.0.5

set -euo pipefail

[[ $# -eq 3 ]] || {
    echo "Usage: $0 <body-directory> <expected-count> <off|campaign>" >&2
    exit 1
}

body_directory="$1"
expected_count="$2"
lesson_propagation="$3"

[[ -d "$body_directory" ]] || {
    echo "Stage-20 body directory does not exist: $body_directory" >&2
    exit 1
}
[[ "$expected_count" =~ ^[1-9][0-9]*$ ]] || {
    echo "Expected count must be a positive integer." >&2
    exit 1
}
[[ "$lesson_propagation" == "off" || "$lesson_propagation" == "campaign" ]] || {
    echo "Lesson propagation must be off or campaign." >&2
    exit 1
}

body_files=()
for body_file in "$body_directory"/*-body.md; do
    [[ -f "$body_file" ]] || continue
    [[ "$body_file" != *-observed-body.md ]] || continue
    body_files+=("$body_file")
done
[[ ${#body_files[@]} -eq $expected_count ]] || {
    echo "Expected $expected_count persisted stage-20 body files; found ${#body_files[@]}." >&2
    exit 1
}

required_headings=(
    '## Campaign context and required reading'
    '## Branch and execution order'
    '## Implement'
    '## Completion gates'
    '## Out of scope'
)

for body_file in "${body_files[@]}"; do
    [[ -s "$body_file" && "$(awk 'END { print NR }' "$body_file")" -gt 1 ]] || {
        echo "Persisted issue body must contain physical Markdown lines: $body_file" >&2
        exit 1
    }
    first_nonblank="$(awk 'NF { print; exit }' "$body_file")"
    [[ "$first_nonblank" =~ ^##[[:space:]]+[^[:space:]] ]] || {
        echo "Persisted issue body must begin with a level-two heading: $body_file" >&2
        exit 1
    }
    for heading in "${required_headings[@]}"; do
        grep -Fqx -- "$heading" "$body_file" || {
            echo "Persisted issue body is missing the physical heading '$heading': $body_file" >&2
            exit 1
        }
    done
    if [[ "$lesson_propagation" == "campaign" ]]; then
        grep -Fqx -- '## Campaign lessons (REQUIRED)' "$body_file" || {
            echo "Treatment issue body is missing its campaign-lessons heading: $body_file" >&2
            exit 1
        }
    elif grep -Fqx -- '## Campaign lessons (REQUIRED)' "$body_file"; then
        echo "Control issue body unexpectedly contains a campaign-lessons heading: $body_file" >&2
        exit 1
    fi
done
```

</details>


---

<sub>38s</sub>

### `view`

**view the file at /home/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh.**

/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh (lines 1--1)

<details>
<summary>30 lines</summary>

```
#!/usr/bin/env bash
# shepherd-task-version: 1.0.5

set -euo pipefail

if [[ $# -ne 3 ]]; then
    echo "Usage: $0 <PRE_CREATION_CHILDREN_JSON> <FINAL_CHILDREN_JSON> <CREATION_LEDGER_JSON>" >&2
    exit 2
fi

for command_name in jq; do
    command -v "$command_name" >/dev/null 2>&1 || {
        echo "Error: Required command '$command_name' was not found." >&2
        exit 1
    }
done

script_dir="$(cd "$(dirname "$0")" && pwd)"
filter_path="$script_dir/verify-stage20-child-links.jq"
[[ -f "$filter_path" ]] || {
    echo "Error: Stage-20 child-link verification filter was not found: $filter_path" >&2
    exit 1
}

for input_path in "$@"; do
    [[ -f "$input_path" ]] || {
        echo "Error: Stage-20 child-link verification input was not found: $input_path" >&2
        exit 1
    }
done

jq -n \
    --slurpfile baseline "$1" \
    --slurpfile final "$2" \
    --slurpfile ledger "$3" \
    -f "$filter_path"
```

</details>


---

<sub>38s</sub>

### `view`

**view the file at /home/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh.**

/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh (lines 1--1)

<details>
<summary>131 lines</summary>

```
#!/usr/bin/env bash
# shepherd-task-version: 1.0.5
set -euo pipefail

fail() {
    printf 'verify-github-issue-body: %s\n' "$*" >&2
    exit 1
}

[[ $# -ge 3 && $# -le 6 ]] ||
    fail "usage: $0 OWNER/REPO ISSUE_NUMBER EXPECTED_BODY_PATH [MAX_ATTEMPTS] [DELAY_SECONDS] [DIAGNOSTIC_PATH]"

repository="$1"
issue_number="$2"
expected_body_path="$3"
max_attempts="${4:-6}"
delay_seconds="${5:-5}"
diagnostic_path="${6:-}"
gh_command="${GH_COMMAND:-gh}"

[[ "$repository" =~ ^[A-Za-z0-9_.-]+/[A-Za-z0-9_.-]+$ ]] ||
    fail "invalid repository: $repository"
[[ "$issue_number" =~ ^[1-9][0-9]*$ ]] ||
    fail "invalid issue number: $issue_number"
[[ "$max_attempts" =~ ^[1-9][0-9]*$ ]] ||
    fail "MAX_ATTEMPTS must be a positive integer"
[[ "$delay_seconds" =~ ^[0-9]+$ ]] ||
    fail "DELAY_SECONDS must be a non-negative integer"
[[ -f "$expected_body_path" ]] ||
    fail "expected issue body file not found: $expected_body_path"

temp_directory="$(mktemp -d)"
trap 'rm -rf "$temp_directory"' EXIT
response_path="$temp_directory/response.json"
actual_path="$temp_directory/actual.txt"
actual_normalized="$temp_directory/actual-normalized.txt"
expected_normalized="$temp_directory/expected-normalized.txt"

normalize_file() {
    jq -b -Rsj 'gsub("\r\n|\r"; "\n")' "$1" >"$2"
}

equivalent_files() {
    local actual="$1"
    local expected="$2"
    local candidate="$temp_directory/candidate.txt"

    cmp -s -- "$actual" "$expected" && return 0
    cp "$actual" "$candidate"
    printf '\n' >>"$candidate"
    cmp -s -- "$candidate" "$expected" && return 0
    cp "$expected" "$candidate"
    printf '\n' >>"$candidate"
    cmp -s -- "$actual" "$candidate"
}

sha256_file() {
    if command -v sha256sum >/dev/null 2>&1; then
        sha256sum "$1" | awk '{print $1}'
    else
        shasum -a 256 "$1" | awk '{print $1}'
    fi
}

write_diagnostic() {
    local reason="$1"
    local attempts="$2"
    [[ -n "$diagnostic_path" ]] || return 0

    mkdir -p "$(dirname "$diagnostic_path")"
    local expected_length actual_length expected_hash actual_hash first_offset
    expected_length="$(wc -c <"$expected_normalized" | tr -d ' ')"
    actual_length="$(wc -c <"$actual_normalized" | tr -d ' ')"
    expected_hash="$(sha256_file "$expected_normalized")"
    actual_hash="$(sha256_file "$actual_normalized")"
    first_offset="$( (cmp -l -- "$actual_normalized" "$expected_normalized" 2>/dev/null || true) | awk 'NR == 1 { print $1 - 1 }')"
    [[ -n "$first_offset" ]] || first_offset="null"

    jq -n \
        --arg repository "$repository" \
        --argjson issueNumber "$issue_number" \
        --arg endpoint "repos/$repository/issues/$issue_number" \
        --argjson attempts "$attempts" \
        --arg observedAt "$(date -u +%Y-%m-%dT%H:%M:%SZ)" \
        --arg reason "$reason" \
        --argjson expectedLength "$expected_length" \
        --argjson actualLength "$actual_length" \
        --arg expectedSha256 "$expected_hash" \
        --arg actualSha256 "$actual_hash" \
        --argjson firstDifferenceOffset "$first_offset" \
        '{
            schemaVersion: 1,
            repository: $repository,
            issueNumber: $issueNumber,
            endpoint: $endpoint,
            attempts: $attempts,
            observedAt: $observedAt,
            reason: $reason,
            expectedLength: $expectedLength,
            actualLength: $actualLength,
            expectedSha256: $expectedSha256,
            actualSha256: $actualSha256,
            firstDifferenceOffset: $firstDifferenceOffset
        }' >"$diagnostic_path"
}

normalize_file "$expected_body_path" "$expected_normalized"
last_reason=""

for ((attempt = 1; attempt <= max_attempts; attempt++)); do
    set +e
    "$gh_command" api "repos/$repository/issues/$issue_number" >"$response_path" 2>"$temp_directory/error.txt"
    exit_code=$?
    set -e

    if [[ $exit_code -ne 0 ]]; then
        last_reason="GitHub REST request failed with exit code $exit_code."
        error_message="$(cat "$temp_directory/error.txt")"
        authentication_error_pattern='HTTP[[:space:]]+(401|403)|[Aa]uthentication|[Nn][Oo][Tt][[:space:]]authorized|[Rr]esource[[:space:]]not[[:space:]]accessible'
        if [[ "$error_message" =~ $authentication_error_pattern ]]; then
            : >"$actual_normalized"
            write_diagnostic "$last_reason" "$attempt"
            fail "unable to fetch issue #$issue_number from $repository: $error_message"
        fi
    elif ! jq -e 'type == "object" and has("body")' "$response_path" >/dev/null 2>&1; then
        last_reason="GitHub REST response was invalid JSON."
    else
        jq -b -j '.body // ""' "$response_path" >"$actual_path"
        normalize_file "$actual_path" "$actual_normalized"
        if equivalent_files "$actual_normalized" "$expected_normalized"; then
            cat "$response_path"
            exit 0
        fi
        last_reason="GitHub issue body differs from the persisted draft."
    fi

    if [[ $attempt -lt $max_attempts ]]; then
        printf 'verify-github-issue-body: %s Retrying issue #%s body verification (%s/%s).\n' \
            "$last_reason" "$issue_number" "$attempt" "$max_attempts" >&2
        ((delay_seconds > 0)) && sleep "$delay_seconds"
    fi
done

[[ -f "$actual_normalized" ]] || : >"$actual_normalized"
write_diagnostic "$last_reason" "$max_attempts"
diagnostic_suffix=""
[[ -z "$diagnostic_path" ]] || diagnostic_suffix=" Diagnostic: $diagnostic_path"
fail "issue #$issue_number body verification failed after $max_attempts attempts. $last_reason$diagnostic_suffix"
```

</details>


---

<sub>1m 36s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

````json
"*** Begin Patch\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/01-4.1-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then re-read these exact sections:\n+\n+- `## Goal`\n+- `### Domain acceptance behavior`\n+- `### Hard scope constraints`\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.3 — What should happen to an existing itinerary and delivery state?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.1 — Issue 1: Add the application-layer deadline change operation`\n+- `## Cross-cutting concerns`\n+\n+The resolved design is concrete:\n+\n+- Add `BookingService.changeDeadline(TrackingId, Date)`.\n+- Load the aggregate, replace its `RouteSpecification` using its existing origin and destination plus the supplied deadline, apply the replacement through `Cargo.specifyNewRoute(...)`, and store it through `CargoRepository`.\n+- Preserve the assigned itinerary. Let the aggregate recalculate routing and delivery-derived state. In the established sequential test, the cargo remains `MISROUTED`.\n+- Require a concrete deadline at the presentation boundary later, but do not invent a future-date, after-old-deadline, or itinerary-date rule.\n+- Extend the historical sequential Arquillian specification, while treating the JDK 17 Open Liberty build as the executable gate; do not modernize Arquillian.\n+\n+Research established that the prepared historical baseline builds on JDK 17 with Open Liberty while retaining `skipTests=true`: test sources compile, but the remote Payara Arquillian suite does not execute without its documented container. Preserve that test path and do not manufacture a passing result by disabling or rewriting it.\n+\n+## Branch and execution order\n+\n+Work from `origin` branch `experiment/shepherd-control`; target the task PR to that branch. This is implementation subsection `4.1`, the first of five serial issues. Tasks are assigned, completed, and merged serially in plan order. Do not begin until this issue is assigned. Do not implement any later subsection in this issue.\n+\n+## Implement\n+\n+Modify only:\n+\n+- `src/main/java/org/eclipse/cargotracker/application/BookingService.java`\n+- `src/main/java/org/eclipse/cargotracker/application/internal/DefaultBookingService.java`\n+- `src/test/java/org/eclipse/cargotracker/application/BookingServiceTest.java`\n+\n+Add this application-service API:\n+\n+```java\n+void changeDeadline(TrackingId trackingId, Date deadline);\n+```\n+\n+Implement it in `DefaultBookingService` by:\n+\n+1. Loading the cargo with `cargoRepository.find(trackingId)`.\n+2. Reading the current destination from `cargo.getRouteSpecification().getDestination()`.\n+3. Constructing a replacement `RouteSpecification` from `cargo.getOrigin()`, the current destination, and `deadline`.\n+4. Calling `cargo.specifyNewRoute(routeSpecification)`.\n+5. Calling `cargoRepository.store(cargo)`.\n+6. Logging the tracking ID and new deadline at `Level.INFO`, following the existing `changeDestination(...)` style.\n+\n+Write the test first. Append sequential `testChangeDeadline()` immediately after `testChangeDestination()` in `BookingServiceTest`. Create a deadline one month after the test's original `deadline`, invoke the new operation, reload through `Cargo.findByTrackingId`, and assert:\n+\n+- origin is still Chicago;\n+- destination is still Helsinki;\n+- the stored deadline is the same calendar day as requested;\n+- the assigned itinerary is unchanged;\n+- transport status remains `NOT_RECEIVED`;\n+- last known location remains `Location.UNKNOWN`;\n+- current voyage remains `Voyage.NONE`;\n+- the cargo is not misdirected;\n+- ETA remains `Delivery.ETA_UNKOWN`;\n+- next expected activity remains `Delivery.NO_ACTIVITY`;\n+- the cargo is not unloaded at destination;\n+- routing status remains `MISROUTED` for the established sequence.\n+\n+Add discriminating assertions that the repository-visible aggregate contains the replacement specification while retaining the same itinerary, rather than merely checking that the service method returns.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- The new test source compiles in the Open Liberty package build.\n+- The full preservation and recalculation assertion set above is present.\n+- Existing tests and production sources continue to compile.\n+- The diff contains no web, facade, REST, Liberty, dependency, or persistence-configuration changes.\n+\n+## Out of scope\n+\n+- JSF, PrimeFaces, facade, dialog, or dashboard work.\n+- Adding setters to `Cargo` or `RouteSpecification`.\n+- Changing origin or destination.\n+- Clearing, replacing, or rerouting the itinerary directly.\n+- Updating persistence entities behind the aggregate.\n+- Adding chronological business rules.\n+- Migrating `javax.*`, Java EE, Java source level, Open Liberty, Derby, or the historical Arquillian runtime.\n+- Inspecting or copying feature-bearing commits or spike source code.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/02-4.2-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then re-read these exact sections:\n+\n+- `## Goal`\n+- `### Domain acceptance behavior`\n+- `### Hard scope constraints`\n+- `### 3.2 — What is the exact domain mutation?`\n+- `### 3.3 — What should happen to an existing itinerary and delivery state?`\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.2 — Issue 2: Expose deadline changes through the booking facade`\n+- `## Cross-cutting concerns`\n+\n+The resolved facade contract is `void changeDeadline(String trackingId, Date arrivalDeadline)`. The facade converts the string to `new TrackingId(trackingId)` and passes the same `Date` to the application service. It must not expose domain identifiers to JSF, introduce a command DTO, or accept a formatted string. The application layer created in the preceding issue remains responsible for replacing the route specification, preserving the itinerary, recalculating domain state, and persisting the aggregate.\n+\n+Research established that the project should retain its existing dependencies and historical test setup. A focused container-free test may use a hand-written fake or spy; no mocking framework or Arquillian modernization is justified.\n+\n+## Branch and execution order\n+\n+Work from `origin` branch `experiment/shepherd-control`; target the task PR to that branch. This is implementation subsection `4.2`, the second of five serial issues. It depends on subsection `4.1` being merged. Tasks are assigned, completed, and merged serially in plan order. Do not begin until this issue is assigned and the preceding issue is present on the base branch. Do not implement later subsections.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/BookingServiceFacade.java`\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacade.java`\n+\n+Optionally add:\n+\n+- `src/test/java/org/eclipse/cargotracker/interfaces/booking/facade/internal/DefaultBookingServiceFacadeTest.java`\n+\n+Add this facade API:\n+\n+```java\n+void changeDeadline(String trackingId, Date arrivalDeadline);\n+```\n+\n+Implement the adapter exactly at the layer boundary:\n+\n+```java\n+bookingService.changeDeadline(\n+        new TrackingId(trackingId),\n+        arrivalDeadline);\n+```\n+\n+Keep all domain mutation and persistence in `BookingService`. If a focused test is practical with the repository's current test setup, use a hand-written fake or spy and prove:\n+\n+- the tracking-ID string becomes an equivalent `TrackingId`;\n+- the same selected `Date` object/value reaches `BookingService`;\n+- delegation occurs exactly once;\n+- the facade performs no cargo load, repository store, date formatting, or domain mutation.\n+\n+Retain the public facade's established imports and Java 7-compatible style. Add no JSF or PrimeFaces dependencies to this layer.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- Existing facade consumers compile without adaptation beyond the new additive method.\n+- The Issue 1 application API and application-layer test remain unchanged and compiling.\n+- Any focused test uses only existing test dependencies and distinguishes correct identifier/date forwarding from duplicated facade logic.\n+- The diff is limited to the facade API, facade implementation, and optional focused facade test.\n+\n+## Out of scope\n+\n+- Loading or mutating `Cargo` in the facade.\n+- Calling `CargoRepository.store(...)` from the facade.\n+- Parsing or formatting dates.\n+- Introducing a request DTO, JSF type, PrimeFaces type, backing bean, dialog, or table change.\n+- Altering the application service behavior delivered by subsection `4.1`.\n+- Adding Mockito or another dependency solely for this feature.\n+- Migrating Java EE, `javax.*`, Java source level, Open Liberty, Derby, or Arquillian.\n+- Inspecting or copying feature-bearing commits or spike source code.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/03-4.3-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then re-read these exact sections:\n+\n+- `## Goal`\n+- `### User-visible acceptance behavior`\n+- `### Hard scope constraints`\n+- `### 3.4 — What type crosses the facade boundary?`\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.3 — Issue 3: Implement the deadline editor backing model`\n+- `## Cross-cutting concerns`\n+\n+The resolved design keeps conversion in a serializable CDI `@Named @ViewScoped` editor bean. Load `CargoRoute` through `BookingServiceFacade.loadCargoForRouting(trackingId)`, create a per-load `SimpleDateFormat(\"MM/dd/yyyy\")`, and parse the DTO date. The existing full deadline starts with the same date that `getArrivalDeadlineDate()` displays; use the date-only DTO representation specified by the plan and never add a shared mutable formatter. A malformed value must surface explicitly rather than becoming null.\n+\n+The editor passes its `String` tracking ID and selected `java.util.Date` to the facade. A non-null date is required, but no future-date, after-old-deadline, or itinerary-date rule is allowed. The interaction mirrors the existing Change Destination flow; this issue creates only the editor model, not the session-scoped launcher or XHTML.\n+\n+Research established that container-free tests should use hand-written fakes with existing dependencies. The Open Liberty package build on JDK 17 is mandatory; historical remote Payara Arquillian modernization is not part of this work.\n+\n+## Branch and execution order\n+\n+Work from `origin` branch `experiment/shepherd-control`; target the task PR to that branch. This is implementation subsection `4.3`, the third of five serial issues. It depends on subsections `4.1` and `4.2` being merged. Tasks are assigned, completed, and merged serially in plan order. Do not begin until this issue is assigned and both predecessors are on the base branch. Do not implement the launcher, XHTML, or dashboard integration.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDate.java`\n+\n+Implement this serializable shape using the repository's established imports:\n+\n+```java\n+@Named\n+@ViewScoped\n+public class ChangeArrivalDeadlineDate implements Serializable {\n+    private static final long serialVersionUID = 1L;\n+\n+    private String trackingId;\n+    private CargoRoute cargo;\n+    private Date arrivalDeadlineDate;\n+\n+    @Inject\n+    private BookingServiceFacade bookingServiceFacade;\n+}\n+```\n+\n+Provide:\n+\n+- `getTrackingId()` and `setTrackingId(String)`;\n+- `getCargo()`;\n+- `getArrivalDeadlineDate()` and `setArrivalDeadlineDate(Date)`;\n+- `load()`;\n+- `changeArrivalDeadline()`.\n+\n+`load()` must request the correct cargo from the facade, store the returned `CargoRoute`, parse its `MM/dd/yyyy` date with a formatter created for that load, and set the editable `Date`. Do not query repositories or domain objects. Convert parse failure into a clear application/view failure consistent with nearby web beans; do not swallow, print, or silently substitute null.\n+\n+`changeArrivalDeadline()` must reject a null selected date, call `bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate)`, and only after successful delegation call:\n+\n+```java\n+PrimeFaces.current().dialog().closeDynamic(\"DONE\");\n+```\n+\n+Add a container-free test if practical with the current test harness and a hand-written fake facade. Cover the exact tracking ID used by `load()`, conversion of an `MM/dd/yyyy` DTO date, exact tracking ID/date delegation on submit, explicit malformed-date failure, and null-date rejection. Ensure a failing facade call cannot produce the success close path.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17.\n+- The bean is serializable, CDI `@Named`, and JSF `@ViewScoped`.\n+- It depends only on facade contracts and DTOs, not domain model or repository classes.\n+- Parsing uses no shared mutable `SimpleDateFormat`.\n+- Malformed and null values fail explicitly; update failure does not look successful.\n+- Existing destination editing and all prior issue sources continue to compile.\n+\n+## Out of scope\n+\n+- Session-scoped dialog launcher or XHTML.\n+- Dashboard/table integration.\n+- Domain or repository access from the web bean.\n+- A new DTO or formatted-string facade API.\n+- New chronological business rules.\n+- Swallowing parse, validation, lookup, or persistence errors.\n+- Adding a mocking framework or modernizing Arquillian.\n+- Migrating Java EE, `javax.*`, PrimeFaces, Open Liberty, Derby, or Java source level.\n+- Inspecting or copying feature-bearing commits or spike source code.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/04-4.4-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then re-read these exact sections:\n+\n+- `## Goal`\n+- `### User-visible acceptance behavior`\n+- `### Hard scope constraints`\n+- `### Phase 2 ✅ — Verify the before and after user experience`\n+- `### 3.5 — How is the DTO's formatted deadline converted for editing?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.4 — Issue 4: Implement the PrimeFaces deadline dialog`\n+- `## Cross-cutting concerns`\n+\n+The resolved interaction mirrors Change Destination: a serializable JSF managed `@SessionScoped` launcher opens a PrimeFaces dynamic dialog, while the preceding issue's CDI `@ViewScoped` editor owns load and submit. Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with one `trackingId` request parameter. Options are `modal=true`, `draggable=true`, `resizable=false`, `contentWidth=410`, and `contentHeight=280`. Success closes with `\"DONE\"`; cancel closes with `\"\"`.\n+\n+Research on the prepared Open Liberty/MyFaces baseline established a strict compatibility constraint: `<f:metadata>` must be a direct child of the root `<html>` and must precede `<h:head>` and `<h:body>`. Nesting it in the body causes MyFaces view-root/component errors. Implement the production view from this finding; do not read or copy spike code.\n+\n+The deadline is a required `java.util.Date`, with no additional chronological policy. The editor uses the DTO's `MM/dd/yyyy` date representation. Visible labels and validation feedback are required.\n+\n+## Branch and execution order\n+\n+Work from `origin` branch `experiment/shepherd-control`; target the task PR to that branch. This is implementation subsection `4.4`, the fourth of five serial issues. It depends on subsections `4.1` through `4.3` being merged. Tasks are assigned, completed, and merged serially in plan order. Do not begin until assigned and all predecessors are on the base branch. This issue makes the dialog directly usable but does not link it from the dashboard.\n+\n+## Implement\n+\n+Create:\n+\n+- `src/main/java/org/eclipse/cargotracker/interfaces/booking/web/ChangeArrivalDeadlineDateDialog.java`\n+- `src/main/webapp/admin/dialogs/changeArrivalDeadlineDate.xhtml`\n+\n+Implement the launcher with:\n+\n+```java\n+@ManagedBean(name = \"changeArrivalDeadlineDateDialog\")\n+@SessionScoped\n+```\n+\n+It must be serializable and provide `showDialog(String trackingId)`, `handleReturn(SelectEvent event)`, and `cancel()`. `showDialog(...)` supplies the exact options above, places `trackingId` in a `Map<String, List<String>>`, and opens `/admin/dialogs/changeArrivalDeadlineDate.xhtml`. `cancel()` closes with the empty string and must not invoke the facade. Keep return handling compatible with the existing destination-dialog refresh flow.\n+\n+The XHTML title is `Change Deadline`. Immediately beneath root `<html>` and before `<h:head>`, include:\n+\n+```xhtml\n+<f:metadata>\n+    <f:viewParam name=\"trackingId\"\n+                 value=\"#{changeArrivalDeadlineDate.trackingId}\"/>\n+    <f:viewAction action=\"#{changeArrivalDeadlineDate.load}\"/>\n+</f:metadata>\n+```\n+\n+Add a form that displays read-only `Origin:` with `changeArrivalDeadlineDate.cargo.originName`, read-only `Destination:` with `changeArrivalDeadlineDate.cargo.finalDestinationName`, and a visibly labeled `Deadline:` `p:datePicker` bound to `changeArrivalDeadlineDate.arrivalDeadlineDate`. Make the date required and render normal Faces validation feedback. Add Cancel bound to `changeArrivalDeadlineDateDialog.cancel()` and Update bound to `changeArrivalDeadlineDate.changeArrivalDeadline()`.\n+\n+Validate the direct URL:\n+\n+`http://localhost:8080/cargo-tracker/admin/dialogs/changeArrivalDeadlineDate.xhtml?trackingId=DEF789`\n+\n+Prove HTTP 200, the correct title and cargo context, initialization to the existing deadline, update persistence, and cancel preservation. Also check that destination editing still works.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty liberty:run` starts successfully on JDK 17.\n+- Direct dialog loading for `DEF789` returns HTTP 200 and renders title, origin, destination, and selected deadline.\n+- Update changes the deadline; Cancel does not.\n+- The server log contains no `TagException`, `Parent UIComponent`, `FacesException`, or feature-attributable server error.\n+- Destination editing remains functional.\n+- Liberty is stopped cleanly before completion.\n+- The diff contains only the launcher, dialog view, and any directly necessary focused tests.\n+\n+## Out of scope\n+\n+- Editing `listNotRouted.xhtml` or any other dashboard table.\n+- Offering the operation outside Not Routed Cargo.\n+- Domain, application-service, or facade redesign.\n+- Inline editing or full-page navigation.\n+- Moving metadata into `<h:body>`.\n+- New chronological rules or timezone policy.\n+- Dependency/framework upgrades, Java EE or `javax.*` migration, Derby/runtime replacement, or Arquillian modernization.\n+- Inspecting or copying feature-bearing commits or spike source code.\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/05-4.5-body.md\n+## Campaign context and required reading\n+\n+On the `experiment/shepherd-control` branch, the directory `1-arrival-deadline-control-remove-before-merge` contains the plan (`add-change-arrival-deadline-feature-ignorance-reduction-plan.md`) and supporting resources (diagrams, decision records). Spike subdirectories are research artifacts — read the plan's Resolution sections for findings, not the spike source code.\n+\n+Read the entire plan before working. Then re-read these exact sections:\n+\n+- `## Goal`\n+- `### User-visible acceptance behavior`\n+- `### Domain acceptance behavior`\n+- `### Hard scope constraints`\n+- `### Phase 2 ✅ — Verify the before and after user experience`\n+- `### 3.1 — Which cargos expose the edit operation?`\n+- `### 3.6 — Which JSF bean scopes and interaction pattern should be used?`\n+- `### 3.7 — What is the dynamic-dialog contract?`\n+- `### 3.8 — What date validation is required?`\n+- `### 3.9 — How will the feature be tested on the prepared historical baseline?`\n+- `### 4.5 — Issue 5: Integrate deadline editing into the Administration dashboard`\n+- `## Phase 5 — Documentation and implementation handoff`\n+- `## Cross-cutting concerns`\n+\n+The resolved UI scope is only `src/main/webapp/admin/tables/listNotRouted.xhtml`; do not expose deadline editing in other cargo tables. The application and facade remain generally callable and must not learn dashboard membership. Mirror the adjacent Destination command-link pattern and the completed dynamic-dialog lifecycle. On success the dialog returns `\"DONE\"`; the caller handles `dialogReturn` and updates `tableNotRouted`. Cancel returns an empty string and changes nothing.\n+\n+Research established that the prepared JDK 17/Open Liberty baseline compiles tests but retains historical `skipTests=true`, so final confidence requires the clean package/start command, HTTP checks, and the complete `DEF789` browser flow. MyFaces requires the already-delivered dialog metadata to remain at view-root scope. Data is in-memory and persists only for the life of the running sample.\n+\n+## Branch and execution order\n+\n+Work from `origin` branch `experiment/shepherd-control`; target the task PR to that branch. This is implementation subsection `4.5`, the fifth and final serial issue. It depends on subsections `4.1` through `4.4` being merged. Tasks are assigned, completed, and merged serially in plan order. Do not begin until assigned and all predecessors are on the base branch.\n+\n+## Implement\n+\n+Modify:\n+\n+- `src/main/webapp/admin/tables/listNotRouted.xhtml`\n+\n+Within the existing Deadline column, replace the plain text with a `p:commandLink` that:\n+\n+- calls `changeArrivalDeadlineDateDialog.showDialog(cargoNotRouted.trackingId)`;\n+- continues to display `cargoNotRouted.arrivalDeadlineDate`;\n+- uses the existing Font Awesome edit-icon style;\n+- has a stable ID such as `arrivalDeadlineToUpdate`;\n+- contains a `dialogReturn` listener invoking `changeArrivalDeadlineDateDialog.handleReturn`;\n+- updates `tableNotRouted`;\n+- exposes the exact tooltip `Click to change cargo arrival deadline date.`\n+\n+Follow the neighboring Destination column's structure and styling without changing destination editing, tracking-ID routing, or table semantics.\n+\n+Run the complete acceptance flow with stable sample cargo `DEF789`: record the original deadline; verify the edit icon and tooltip; open the dialog; verify origin and destination; choose a visibly different date; update; verify close and table refresh; reload and verify persistence; reopen and verify initialization to the changed value; cancel and verify no further change. Then verify the Destination dialog still opens and selecting `DEF789` for routing does not produce an error page.\n+\n+Check final logs for the absence of `<f:metadata> Parent UIComponent`, `TagException`, `VerifyError`, `FacesException`, `CWWKZ0002E`, `CWWKZ0003E`, recurring batch authorization failures, and new feature-attributable FFDC files. Transient JMS activation-order warnings are acceptable only if all endpoints subsequently activate.\n+\n+Update `README.md` only if it already enumerates user-facing Administration capabilities; if so, add one concise sentence about changing an unrouted cargo's arrival deadline. Record `./mvnw clean package -Popenliberty liberty:run`, `DEF789`, before/after values, and the in-memory reset behavior in PR acceptance evidence.\n+\n+## Completion gates\n+\n+- `./mvnw clean package -Popenliberty` succeeds on JDK 17 and all test sources compile.\n+- `./mvnw clean package -Popenliberty liberty:run` starts the application and the home page returns HTTP 200.\n+- Every step of the `DEF789` end-to-end flow above passes, including reload, reopen, cancel, destination-dialog regression, and routing regression.\n+- Final logs satisfy the explicit exclusion list above.\n+- No Java EE namespace migration or regression to Open Liberty, Derby, Jackson, JSF metadata, batch authorization, REST, messaging, or startup behavior occurs.\n+- Liberty is stopped cleanly.\n+\n+## Out of scope\n+\n+- Deadline edit affordances in routed, misrouted, claimed, details, or other cargo views.\n+- Changing tracking-ID routing or destination editing.\n+- Additional date business rules or timezone policy.\n+- Domain, application-service, facade, bean, or dialog redesign beyond fixes required for the final integration.\n+- Unrelated README or documentation expansion.\n+- Dependency/framework upgrades, `javax.*` migration, Derby/runtime replacement, or Arquillian modernization.\n+- Inspecting or copying feature-bearing commits or spike source code.\n*** End Patch\n"
````

</details>

```
Added 5 file(s): /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/01-4.1-body.md, /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/02-4.2-body.md, /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/03-4.3-body.md, /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/04-4.4-body.md, /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies/05-4.5-body.md
```


---

<sub>2m 10s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

```json
"*** Begin Patch\n*** Add File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/run-stage20.sh\n+#!/usr/bin/env bash\n+\n+set -euo pipefail\n+\n+REPO='edburns/dd-3070094-cargotracker-linux-x64-01'\n+PARENT_ISSUE='1'\n+EXPECTED_TASK_COUNT='5'\n+LESSON_PROPAGATION='off'\n+LOG_DIRECTORY='/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733'\n+DRAFT_VALIDATOR='/home/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh'\n+ISSUE_BODY_VERIFIER='/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-github-issue-body.sh'\n+CHILD_LINK_VERIFIER='/home/edburns/.copilot/plugins/shepherd-task/scripts/verify-stage20-child-links.sh'\n+BODY_DIRECTORY=\"$LOG_DIRECTORY/issue-bodies\"\n+LEDGER=\"$LOG_DIRECTORY/creation-ledger.json\"\n+RESULT=\"$LOG_DIRECTORY/stage-20-result.json\"\n+PRE_CREATION_CHILDREN=\"$LOG_DIRECTORY/pre-creation-children.json\"\n+FINAL_CHILDREN=\"$LOG_DIRECTORY/final-children.json\"\n+\n+atomic_write() {\n+  local destination=\"$1\"\n+  local content=\"$2\"\n+  local temporary\n+\n+  temporary=\"$(mktemp \"${destination}.tmp.XXXXXX\")\" || return 1\n+\n+  if ! printf '%s\\n' \"$content\" > \"$temporary\"; then\n+    rm -f \"$temporary\"\n+    return 1\n+  fi\n+\n+  if ! mv \"$temporary\" \"$destination\"; then\n+    rm -f \"$temporary\"\n+    return 1\n+  fi\n+}\n+\n+update_ledger_flag() {\n+  local number=\"$1\" field=\"$2\" value=\"$3\" updated\n+  updated=\"$(\n+    jq \\\n+      --argjson number \"$number\" \\\n+      --arg field \"$field\" \\\n+      --argjson value \"$value\" \\\n+      'map(if .number == $number then .[$field] = $value else . end)' \\\n+      \"$LEDGER\"\n+  )\" || return 1\n+  atomic_write \"$LEDGER\" \"$updated\"\n+}\n+\n+normalize_children() {\n+  jq 'if length == 0 then [] elif all(.[]; type == \"array\") then add else . end'\n+}\n+\n+reconcile_and_fail() {\n+  local operation=\"$1\"\n+  local error=\"$2\"\n+  local children_output normalized reconciled failed_result\n+\n+  if children_output=\"$(gh api \"repos/$REPO/issues/$PARENT_ISSUE/sub_issues\" --paginate --slurp 2>&1)\"; then\n+    if normalized=\"$(printf '%s' \"$children_output\" | normalize_children 2>/dev/null)\"; then\n+      reconciled=\"$(\n+        jq \\\n+          --argjson children \"$normalized\" \\\n+          'map(.linked = ([ $children[] | select(.id == .id) ] | length > 0))' \\\n+          \"$LEDGER\"\n+      )\"\n+      # The jq scope above cannot compare both objects reliably; use IDs explicitly.\n+      reconciled=\"$(\n+        jq \\\n+          --argjson child_ids \"$(printf '%s' \"$normalized\" | jq '[.[].id]')\" \\\n+          'map(.linked = ($child_ids | index(.id) != null))' \\\n+          \"$LEDGER\"\n+      )\"\n+      atomic_write \"$LEDGER\" \"$reconciled\"\n+    else\n+      error=\"$error; reconciliation response could not be normalized\"\n+    fi\n+  else\n+    error=\"$error; reconciliation query failed: $children_output\"\n+  fi\n+\n+  failed_result=\"$(\n+    jq -n \\\n+      --arg operation_error \"$operation: $error\" \\\n+      '{\n+        schemaVersion: 1,\n+        status: \"failed\",\n+        ledgerFile: \"creation-ledger.json\",\n+        operationError: $operation_error\n+      }'\n+  )\"\n+  atomic_write \"$RESULT\" \"$failed_result\"\n+\n+  printf 'Stage 20 failed during %s: %s\\n' \"$operation\" \"$error\" >&2\n+  if jq -e 'length == 0' \"$LEDGER\" >/dev/null; then\n+    printf 'No issues were created; no cleanup is required.\\n' >&2\n+  else\n+    jq -r '.[] | \"issue #\\(.number) | \\(.title) | \\(.url) | \\(.bodyFile) | body_verified=\\(.body_verified) | linked=\\(.linked)\"' \"$LEDGER\" >&2\n+    jq -r --arg repo \"$REPO\" '.[] | \"gh issue delete \\(.number) --repo \\\"\\($repo)\\\" --yes\"' \"$LEDGER\" >&2\n+    printf 'The operation did not complete and no automatic rollback was performed. Delete every issue in the ledger before invoking stage 20 again.\\n' >&2\n+  fi\n+  exit 1\n+}\n+\n+\"$DRAFT_VALIDATOR\" \"$BODY_DIRECTORY\" \"$EXPECTED_TASK_COUNT\" \"$LESSON_PROPAGATION\"\n+\n+atomic_write \"$LEDGER\" '[]'\n+atomic_write \"$RESULT\" \\\n+  '{\"schemaVersion\":1,\"status\":\"in_progress\",\"ledgerFile\":\"creation-ledger.json\",\"operationError\":null}'\n+jq -e 'type == \"array\" and length == 0' \"$LEDGER\" >/dev/null\n+jq -e \\\n+  '.schemaVersion == 1 and\n+   .status == \"in_progress\" and\n+   .ledgerFile == \"creation-ledger.json\" and\n+   .operationError == null' \\\n+  \"$RESULT\" >/dev/null\n+\n+if ! baseline_output=\"$(gh api \"repos/$REPO/issues/$PARENT_ISSUE/sub_issues\" --paginate --slurp 2>&1)\"; then\n+  reconcile_and_fail 'pre-creation child query' \"$baseline_output\"\n+fi\n+if ! baseline=\"$(printf '%s' \"$baseline_output\" | normalize_children 2>&1)\"; then\n+  reconcile_and_fail 'pre-creation child normalization' \"$baseline\"\n+fi\n+atomic_write \"$PRE_CREATION_CHILDREN\" \"$baseline\"\n+jq -e 'type == \"array\"' \"$PRE_CREATION_CHILDREN\" >/dev/null ||\n+  reconcile_and_fail 'pre-creation child snapshot validation' 'normalized snapshot is not an array'\n+\n+subsections=(\n+  '4.1 — Issue 1: Add the application-layer deadline change operation'\n+  '4.2 — Issue 2: Expose deadline changes through the booking facade'\n+  '4.3 — Issue 3: Implement the deadline editor backing model'\n+  '4.4 — Issue 4: Implement the PrimeFaces deadline dialog'\n+  '4.5 — Issue 5: Integrate deadline editing into the Administration dashboard'\n+)\n+titles=(\n+  '4.1: Add the application-layer deadline change operation'\n+  '4.2: Expose deadline changes through the booking facade'\n+  '4.3: Implement the deadline editor backing model'\n+  '4.4: Implement the PrimeFaces deadline dialog'\n+  '4.5: Integrate deadline editing into the Administration dashboard'\n+)\n+body_files=(\n+  \"$BODY_DIRECTORY/01-4.1-body.md\"\n+  \"$BODY_DIRECTORY/02-4.2-body.md\"\n+  \"$BODY_DIRECTORY/03-4.3-body.md\"\n+  \"$BODY_DIRECTORY/04-4.4-body.md\"\n+  \"$BODY_DIRECTORY/05-4.5-body.md\"\n+)\n+\n+for index in \"${!titles[@]}\"; do\n+  title=\"${titles[$index]}\"\n+  body_file=\"${body_files[$index]}\"\n+  subsection=\"${subsections[$index]}\"\n+\n+  if ! create_json=\"$(\n+    gh api \"repos/$REPO/issues\" \\\n+      -X POST \\\n+      -f title=\"$title\" \\\n+      -F \"body=@$body_file\" \\\n+      --jq '{id,number,node_id,html_url,title}' 2>&1\n+  )\"; then\n+    reconcile_and_fail \"create issue for $subsection\" \"$create_json\"\n+  fi\n+\n+  if ! id=\"$(printf '%s' \"$create_json\" | jq -er '.id')\" ||\n+     ! number=\"$(printf '%s' \"$create_json\" | jq -er '.number')\" ||\n+     ! url=\"$(printf '%s' \"$create_json\" | jq -er '.html_url')\"; then\n+    reconcile_and_fail \"parse created issue for $subsection\" \"$create_json\"\n+  fi\n+\n+  relative_body_file=\"issue-bodies/$(basename \"$body_file\")\"\n+  if ! updated=\"$(\n+    jq \\\n+      --arg implementationSubsection \"$subsection\" \\\n+      --arg bodyFile \"$relative_body_file\" \\\n+      --argjson id \"$id\" \\\n+      --argjson number \"$number\" \\\n+      --arg title \"$title\" \\\n+      --arg url \"$url\" \\\n+      '. + [{\n+        implementationSubsection: $implementationSubsection,\n+        bodyFile: $bodyFile,\n+        id: $id,\n+        number: $number,\n+        title: $title,\n+        url: $url,\n+        body_verified: false,\n+        linked: false\n+      }]' \\\n+      \"$LEDGER\"\n+  )\" || ! atomic_write \"$LEDGER\" \"$updated\"; then\n+    reconcile_and_fail \"persist creation ledger for issue #$number\" 'ledger update failed'\n+  fi\n+\n+  if ! issue_json=\"$(\n+    \"$ISSUE_BODY_VERIFIER\" \\\n+      \"$REPO\" \\\n+      \"$number\" \\\n+      \"$body_file\" \\\n+      6 \\\n+      5 \\\n+      \"$LOG_DIRECTORY/issue-$number-body-verification-failure.json\" 2>&1\n+  )\"; then\n+    reconcile_and_fail \"verify body for issue #$number\" \"$issue_json\"\n+  fi\n+  update_ledger_flag \"$number\" body_verified true ||\n+    reconcile_and_fail \"persist body verification for issue #$number\" 'ledger update failed'\n+\n+  linked=false\n+  link_error=''\n+  for attempt in 1 2 3; do\n+    if link_output=\"$(\n+      printf '{\"sub_issue_id\": %s}' \"$id\" |\n+        gh api \"repos/$REPO/issues/$PARENT_ISSUE/sub_issues\" -X POST --input - 2>&1\n+    )\"; then\n+      linked=true\n+      break\n+    fi\n+    link_error=\"$link_output\"\n+    sleep \"$attempt\"\n+  done\n+  if [[ \"$linked\" != true ]]; then\n+    reconcile_and_fail \"link issue #$number to parent #$PARENT_ISSUE\" \"$link_error\"\n+  fi\n+  update_ledger_flag \"$number\" linked true ||\n+    reconcile_and_fail \"persist linkage for issue #$number\" 'ledger update failed'\n+done\n+\n+if ! final_output=\"$(gh api \"repos/$REPO/issues/$PARENT_ISSUE/sub_issues\" --paginate --slurp 2>&1)\"; then\n+  reconcile_and_fail 'final child query' \"$final_output\"\n+fi\n+if ! final=\"$(printf '%s' \"$final_output\" | normalize_children 2>&1)\"; then\n+  reconcile_and_fail 'final child normalization' \"$final\"\n+fi\n+atomic_write \"$FINAL_CHILDREN\" \"$final\"\n+\n+if ! link_verification=\"$(\n+  \"$CHILD_LINK_VERIFIER\" \\\n+    \"$PRE_CREATION_CHILDREN\" \\\n+    \"$FINAL_CHILDREN\" \\\n+    \"$LEDGER\" 2>&1\n+)\"; then\n+  reconcile_and_fail 'child-link postcondition verification' \"$link_verification\"\n+fi\n+\n+while IFS=$'\\t' read -r number relative_body_file; do\n+  body_file=\"$LOG_DIRECTORY/$relative_body_file\"\n+  if ! issue_json=\"$(\n+    \"$ISSUE_BODY_VERIFIER\" \\\n+      \"$REPO\" \\\n+      \"$number\" \\\n+      \"$body_file\" \\\n+      6 \\\n+      5 \\\n+      \"$LOG_DIRECTORY/issue-$number-final-body-verification-failure.json\" 2>&1\n+  )\"; then\n+    reconcile_and_fail \"final body verification for issue #$number\" \"$issue_json\"\n+  fi\n+  if ! printf '%s' \"$issue_json\" |\n+    jq -e '.state == \"open\" and (.assignees | type == \"array\" and length == 0)' >/dev/null; then\n+    reconcile_and_fail \"state/assignee verification for issue #$number\" 'issue must be open and unassigned'\n+  fi\n+done < <(jq -r '.[] | [.number, .bodyFile] | @tsv' \"$LEDGER\")\n+\n+atomic_write \"$RESULT\" \\\n+  '{\"schemaVersion\":1,\"status\":\"complete\",\"ledgerFile\":\"creation-ledger.json\",\"operationError\":null}'\n+jq -e \\\n+  '.schemaVersion == 1 and\n+   .status == \"complete\" and\n+   .ledgerFile == \"creation-ledger.json\" and\n+   .operationError == null' \\\n+  \"$RESULT\" >/dev/null\n+\n+jq -c '.' \"$LEDGER\"\n*** End Patch\n"
```

</details>

```
Added 1 file(s): /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/run-stage20.sh
```


---

<sub>2m 15s</sub>

### `apply_patch`

<details>
<summary>Arguments</summary>

```json
"*** Begin Patch\n*** Update File: 1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/run-stage20.sh\n@@\n   if children_output=\"$(gh api \"repos/$REPO/issues/$PARENT_ISSUE/sub_issues\" --paginate --slurp 2>&1)\"; then\n     if normalized=\"$(printf '%s' \"$children_output\" | normalize_children 2>/dev/null)\"; then\n-      reconciled=\"$(\n-        jq \\\n-          --argjson children \"$normalized\" \\\n-          'map(.linked = ([ $children[] | select(.id == .id) ] | length > 0))' \\\n-          \"$LEDGER\"\n-      )\"\n-      # The jq scope above cannot compare both objects reliably; use IDs explicitly.\n       reconciled=\"$(\n         jq \\\n           --argjson child_ids \"$(printf '%s' \"$normalized\" | jq '[.[].id]')\" \\\n-          'map(.linked = ($child_ids | index(.id) != null))' \\\n+          'map(.id as $id | .linked = ($child_ids | index($id) != null))' \\\n           \"$LEDGER\"\n       )\"\n*** End Patch\n"
```

</details>

```
Modified 1 file(s): /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/run-stage20.sh
```


---

<sub>2m 17s</sub>

### `bash`

**Validate orchestration and issue drafts**

$ set -euo pipefail
bash -n '1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/run-stage20.sh'
'/home/edburns/.copilot/plugins/shepherd-task/scripts/validate-stage20-drafts.sh' '1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/issue-bodies' 5 off

```

<shellId: 7 completed with exit code 0>
```


---

<sub>2m 17s</sub>

### `sql`

**Advance draft todo**

<details>
<summary>Arguments</summary>

```json
{
  "description": "Advance draft todo",
  "query": "UPDATE todos SET status='done', updated_at=CURRENT_TIMESTAMP WHERE id='stage20-preflight'; UPDATE todos SET status='in_progress', updated_at=CURRENT_TIMESTAMP WHERE id='stage20-drafts'"
}
```

</details>

<details>
<summary>5 lines</summary>

```
Executed 2 statement(s):

1. UPDATE
   1 row(s) updated.

2. UPDATE
   1 row(s) updated.
```

</details>


---

<sub>2m 19s</sub>

### Copilot

All five persisted drafts passed the required structural validator. The next operation creates, body-verifies, and links each unassigned child serially, then runs the authoritative child-link and final issue postcondition checks.

---

<sub>2m 34s</sub>

### `bash`

**Create and verify ordered child issues**

$ set -euo pipefail
bash '1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/run-stage20.sh'

```
[{"implementationSubsection":"4.1 — Issue 1: Add the application-layer deadline change operation","bodyFile":"issue-bodies/01-4.1-body.md","id":5618728795,"number":2,"title":"4.1: Add the application-layer deadline change operation","url":"https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/2","body_verified":true,"linked":true},{"implementationSubsection":"4.2 — Issue 2: Expose deadline changes through the booking facade","bodyFile":"issue-bodies/02-4.2-body.md","id":5618729192,"number":3,"title":"4.2: Expose deadline changes through the booking facade","url":"https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/3","body_verified":true,"linked":true},{"implementationSubsection":"4.3 — Issue 3: Implement the deadline editor backing model","bodyFile":"issue-bodies/03-4.3-body.md","id":5618729553,"number":4,"title":"4.3: Implement the deadline editor backing model","url":"https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/4","body_verified":true,"linked":true},{"implementationSubsection":"4.4 — Issue 4: Implement the PrimeFaces deadline dialog","bodyFile":"issue-bodies/04-4.4-body.md","id":5618729912,"number":5,"title":"4.4: Implement the PrimeFaces deadline dialog","url":"https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/5","body_verified":true,"linked":true},{"implementationSubsection":"4.5 — Issue 5: Integrate deadline editing into the Administration dashboard","bodyFile":"issue-bodies/05-4.5-body.md","id":5618730270,"number":6,"title":"4.5: Integrate deadline editing into the Administration dashboard","url":"https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/6","body_verified":true,"linked":true}]
<shellId: 8 completed with exit code 0>
```


---

<sub>2m 39s</sub>

### `view`

**view the file at /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/stage-20-result.json.**

/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/stage-20-result.json (lines 1--1)

```
{"schemaVersion":1,"status":"complete","ledgerFile":"creation-ledger.json","operationError":null}

```


---

<sub>2m 39s</sub>

### `view`

**view the file at /home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/creation-ledger.json.**

/home/edburns/workareas/dd-3070094-cargotracker-linux-x64-01-shepherd-control/1-arrival-deadline-control-remove-before-merge/prompts/shepherd-task-20-20260928-1733/creation-ledger.json (lines 1--1)

<details>
<summary>52 lines</summary>

```
[
  {
    "implementationSubsection": "4.1 — Issue 1: Add the application-layer deadline change operation",
    "bodyFile": "issue-bodies/01-4.1-body.md",
    "id": 5618728795,
    "number": 2,
    "title": "4.1: Add the application-layer deadline change operation",
    "url": "https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/2",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.2 — Issue 2: Expose deadline changes through the booking facade",
    "bodyFile": "issue-bodies/02-4.2-body.md",
    "id": 5618729192,
    "number": 3,
    "title": "4.2: Expose deadline changes through the booking facade",
    "url": "https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/3",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.3 — Issue 3: Implement the deadline editor backing model",
    "bodyFile": "issue-bodies/03-4.3-body.md",
    "id": 5618729553,
    "number": 4,
    "title": "4.3: Implement the deadline editor backing model",
    "url": "https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/4",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.4 — Issue 4: Implement the PrimeFaces deadline dialog",
    "bodyFile": "issue-bodies/04-4.4-body.md",
    "id": 5618729912,
    "number": 5,
    "title": "4.4: Implement the PrimeFaces deadline dialog",
    "url": "https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/5",
    "body_verified": true,
    "linked": true
  },
  {
    "implementationSubsection": "4.5 — Issue 5: Integrate deadline editing into the Administration dashboard",
    "bodyFile": "issue-bodies/05-4.5-body.md",
    "id": 5618730270,
    "number": 6,
    "title": "4.5: Integrate deadline editing into the Administration dashboard",
    "url": "https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/6",
    "body_verified": true,
    "linked": true
  }
]
```

</details>


---

<sub>2m 39s</sub>

### `rg`

**shepherd-task-25-given-list**

"shepherd-task-25-given-list" (~/.copilot/plugins/shepherd-task)

<details>
<summary>112 matches</summary>

```
[grep content: 94 matches across 51 file(s) under /home/edburns/.copilot/plugins/shepherd-task]

README.md (8 match(es)):
  33: - one or more `shepherd-task-25-given-list` runs.
  54: | 25         |                                                    | `shepherd-task-25-given-list`                     | Runs selected child issues serially, invokes `shepherd-task` separately for each issue to perform stages 30 and 40, and always invokes stage 50 |
  256: ./plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh \
  264: .\plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1 `
  295: - [Figure 01 — stage 25 given-list batch orchestration](figure-01-shepherd-task-25-given-list.md)
  449: `shepherd-task-25-given-list-run.json`:
  542:     ├── shepherd-task-25-given-list-run.json
  627: | `scripts/shepherd-task-25-given-list.*` | Run stage 25: create a run and dispatch issues serially |

figure (2 match(es)):
  01- shepherd-task-25-given-list.md:3:Stage 25 (`shepherd-task-25-given-list`) owns one serial run. It validates the durable campaign
  01- shepherd-task-25-given-list.md:12:    participant GL as Stage 25: shepherd-task-25-given-list
making-of.md:248: `shepherd-task-25-given-list-run.json`. The run begins as `running` and is

workshop.md (3 match(es)):
  215: & 'C:\Users\edburns\.copilot\plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1' `
  229: /Users/edburns/.copilot/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh 2\,3 1-math-control-remove-before-merge
  241: By the time you have invoked `shepherd-task-25-given-list` the work proceeds in an entirely human hands-off manner. See `awesome-copilot-01/plugins/shepherd-task/README.md` Sections **Stage 30 readiness boundary** through **Workflow approval helper** and **Post-mortem behavior**.
test/lesson-propagation-default-contract.sh:9: STAGE25="$SCRIPTS_DIR/shepherd-task-25-given-list.sh"

test/lesson-propagation-default-contract.ps1 (4 match(es)):
  9: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'
  160:         (Join-Path $harnessDirectory 'shepherd-task-25-given-list.ps1'),
  196:             Join-Path $harnessDirectory 'shepherd-task-25-given-list.ps1'
  214:         Join-Path $runDirectories[0].FullName 'shepherd-task-25-given-list-run.json'
test/cargotracker-add-change-arrival-deadline-feature/10-cargotracker-fixture-contract.sh:137: [[ "$(grep -Fc 'shepherd-task-25-given-list.sh' "$driver")" -eq 1 ]] ||
test/cargotracker-add-change-arrival-deadline-feature/07-driver-encoding-contract.sh:52:     'shepherd-task-25-given-list.sh'
test/cargotracker-add-change-arrival-deadline-feature/06-stage40-review-contract.sh:10: STAGE25="$REPO_ROOT/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh"

test/simple-math/20260924 (10 match(es)):
  2032- job-logs.txt:43:[shepherd] Planned invocation of shepherd-task-25-given-list.sh:
  2032- job-logs.txt:44:  /home/edburns/.copilot/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh <TASK_ISSUE_LIST> 4-math-control-remove-before-merge
  2032- job-logs.txt:52:[shepherd] Actual invocation of shepherd-task-25-given-list.sh:
  2032- job-logs.txt:53:  /home/edburns/.copilot/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh 5\,6 4-math-control-remove-before-merge
  2015- job-logs.txt:43:[shepherd] Planned invocation of shepherd-task-25-given-list.sh:
  2015- job-logs.txt:44:  /home/edburns/.copilot/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh <TASK_ISSUE_LIST> 1-math-control-remove-before-merge
  1746- job-logs.txt:43:[shepherd] Planned invocation of shepherd-task-25-given-list.sh:
  1746- job-logs.txt:44:  /home/edburns/.copilot/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh <TASK_ISSUE_LIST> 1-math-control-remove-before-merge
  1746- job-logs.txt:52:[shepherd] Actual invocation of shepherd-task-25-given-list.sh:
  1746- job-logs.txt:53:  /home/edburns/.copilot/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh 2\,3 1-math-control-remove-before-merge

skills/shepherd-task (3 match(es)):
  50- create-post-mortem/SKILL.md:13:This skill is designed to be invoked from `shepherd-task-25-given-list.ps1` / `shepherd-task-25-given-list.sh` in a `finally` / `trap EXIT` path so it runs for **all outcomes**, not only after success.
  50- create-post-mortem/SKILL.md:60:2. If `shepherd-task-25-given-list-run.json` exists, verify its campaign ID,
  20- create-issues-from-plan/SKILL.md:384:2. Comma-separated child issue numbers for `shepherd-task-25-given-list`.

test/cargotracker-add-change-arrival-deadline-feature/run-campaign.ps1 (2 match(es)):
  341:                 $manifestPath = Join-Path $_.FullName 'shepherd-task-25-given-list-run.json'
  473:         'scripts\shepherd-task-25-given-list.ps1'
test/simple-math/07-driver-encoding-contract.sh:46:     'shepherd-task-25-given-list.sh'
test/cargotracker-add-change-arrival-deadline-feature-treatment-control/06-stage40-review-contract.sh:10: STAGE25="$REPO_ROOT/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh"
test/simple-math/08-psncpps-contract.ps1:13: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'
test/simple-math/06-stage40-review-contract.sh:10: STAGE25="$REPO_ROOT/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh"

scripts/shepherd-task (5 match(es)):
  25- given-list.sh:6:#   ./shepherd-task-25-given-list.sh <TASK_ISSUES> <CAMPAIGN_METADATA_DIRECTORY>
  25- given-list.sh:80:RUN_MANIFEST="$LOG_DIR_FULL/shepherd-task-25-given-list-run.json"
  25- given-list.sh:116:echo "Logging shepherd-task-25-given-list run to: $LOG_DIR_FULL"
  25- given-list.ps1:65:$runManifestPath = Join-Path $logDirFull 'shepherd-task-25-given-list-run.json'
  25- given-list.ps1:117:    Write-Host "Logging shepherd-task-25-given-list run to: $logDirFull"

test/simple-math/run-campaign.ps1 (2 match(es)):
  340:                 $manifestPath = Join-Path $_.FullName 'shepherd-task-25-given-list-run.json'
  469:         'scripts\shepherd-task-25-given-list.ps1'

test/simple-math/run-campaign.sh (2 match(es)):
  202:         local manifest="$directory/shepherd-task-25-given-list-run.json"
  338:     local stage25_script="$shepherd_plugin/scripts/shepherd-task-25-given-list.sh"

test/cargotracker-add-change-arrival-deadline-feature-treatment-control/README.md (2 match(es)):
  305: & "$ShepherdPlugin\scripts\shepherd-task-25-given-list.ps1" `
  310: & "$ShepherdPlugin\scripts\shepherd-task-25-given-list.ps1" `
test/simple-math/06-stage40-review-contract.ps1:14: $stage25Path = Join-Path $repoRoot 'plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1'
test/simple-math/10-simple-math-fixture-contract.sh:81: [[ "$(grep -Fc 'scripts/shepherd-task-25-given-list.sh' "$driver")" -eq 1 ]] ||

test/simple-math/20260928 (4 match(es)):
  0112- job-logs.txt:43:[shepherd] Planned invocation of shepherd-task-25-given-list.sh:
  0112- job-logs.txt:44:  /home/edburns/.copilot/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh <TASK_ISSUE_LIST> 1-math-control-remove-before-merge
  0112- job-logs.txt:52:[shepherd] Actual invocation of shepherd-task-25-given-list.sh:
  0112- job-logs.txt:53:  /home/edburns/.copilot/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh 2\,3 1-math-control-remove-before-merge
test/simple-math/08-psncpps-contract.sh:17: stage25="$scripts_directory/shepherd-task-25-given-list.sh"
test/cargotracker-add-change-arrival-deadline-feature/07-driver-encoding-contract.ps1:296:         'shepherd-task-25-given-list.ps1',
test/cargotracker-add-change-arrival-deadline-feature/02-create-issues.sh:226:     "$scripts_directory/shepherd-task-25-given-list.sh" \
scripts/shepherd-task-monitor.sh:9: # Run this in a SEPARATE terminal while shepherd-task-25-given-list.sh is running.
test/cargotracker-add-change-arrival-deadline-feature-treatment-control/08-psncpps-contract.ps1:13: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'
test/cargotracker-add-change-arrival-deadline-feature/02-create-issues.ps1:264:     (Join-Path $PSScriptRoot '..' '..' 'scripts' 'shepherd-task-25-given-list.ps1')
scripts/shepherd-task-monitor.ps1:10:     Run this in a SEPARATE terminal while shepherd-task-25-given-list.ps1 is running.
test/simple-math/10-simple-math-fixture-contract.ps1:136:     "scripts\\shepherd-task-25-given-list\.ps1"

test/simple-math-treatment-control/20260831-run-treatment-control-experiment.ps1 (3 match(es)):
  151:                 $manifestPath = Join-Path $_.FullName 'shepherd-task-25-given-list-run.json'
  501:         -Path (Join-Path $ShepherdPlugin 'scripts\shepherd-task-25-given-list.ps1') `
  511:         -Path (Join-Path $ShepherdPlugin 'scripts\shepherd-task-25-given-list.ps1') `
test/simple-math/07-driver-encoding-contract.ps1:296:         'shepherd-task-25-given-list.ps1',
test/cargotracker-add-change-arrival-deadline-feature-treatment-control/02-create-issues.ps1:255:     (Join-Path $PSScriptRoot '..' '..' 'scripts' 'shepherd-task-25-given-list.ps1')
scripts/shepherd-task.ps1:22:     Existing shepherd-task-25-given-list run directory.
test/cargotracker-add-change-arrival-deadline-feature/10-cargotracker-fixture-contract.ps1:207:     "scripts\\shepherd-task-25-given-list\.ps1"
test/simple-math/02-create-issues.ps1:265:     (Join-Path $PSScriptRoot '..' '..' 'scripts' 'shepherd-task-25-given-list.ps1')

test/simple-math-treatment-control/README.md (2 match(es)):
  411: & "$ShepherdPlugin/scripts/shepherd-task-25-given-list.ps1" `
  420: & "$ShepherdPlugin/scripts/shepherd-task-25-given-list.ps1" `
test/simple-math-treatment-control/02-create-issues.ps1:256:     (Join-Path $PSScriptRoot '..' '..' 'scripts' 'shepherd-task-25-given-list.ps1')
test/simple-math-treatment-control/06-stage40-review-contract.ps1:14: $stage25Path = Join-Path $repoRoot 'plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1'
test/cargotracker-add-change-arrival-deadline-feature/08-psncpps-contract.ps1:13: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'
test/simple-math-treatment-control/08-psncpps-contract.ps1:13: $stage25 = Join-Path $scriptsDirectory 'shepherd-task-25-given-list.ps1'
test/cargotracker-add-change-arrival-deadline-feature/06-stage40-review-contract.ps1:14: $stage25Path = Join-Path $repoRoot 'plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1'
test/cargotracker-add-change-arrival-deadline-feature-treatment-control/06-stage40-review-contract.ps1:14: $stage25Path = Join-Path $repoRoot 'plugins\shepherd-task\scripts\shepherd-task-25-given-list.ps1'
test/simple-math-treatment-control/06-stage40-review-contract.sh:10: STAGE25="$REPO_ROOT/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh"

test/cargotracker-add-change-arrival-deadline-feature/run-campaign.sh (2 match(es)):
  190:         local manifest="$directory/shepherd-task-25-given-list-run.json"
  336: stage25_script="$shepherd_plugin/scripts/shepherd-task-25-given-list.sh"
test/simple-math/02-create-issues.sh:27: stage25="$scripts_directory/shepherd-task-25-given-list.sh"
test/version-lineup-contract.sh:98: grep -Fq 'stageOutcomeProtocolVersion:' "$plugin_root/scripts/shepherd-task-25-given-list.sh"
test/cargotracker-add-change-arrival-deadline-feature/08-psncpps-contract.sh:8: stage25="$scripts_directory/shepherd-task-25-given-list.sh"

test/cargotracker-add-change-arrival-deadline-feature-treatment-control/202609023-1638Z-run-treatment-control-experiment-resumeable.ps1 (3 match(es)):
  180:             'shepherd-task-25-given-list-run.json'
  395:         'shepherd-task-25-given-list-run.json'
  436:                 'scripts\shepherd-task-25-given-list.ps1') `

test/cargotracker-add-change-arrival-deadline-feature-treatment-control/20260902-run-treatment-control-experiment.ps1 (3 match(es)):
  149:                 $manifestPath = Join-Path $_.FullName 'shepherd-task-25-given-list-run.json'
  502:         -Path (Join-Path $ShepherdPlugin 'scripts\shepherd-task-25-given-list.ps1') `
  512:         -Path (Join-Path $ShepherdPlugin 'scripts\shepherd-task-25-given-list.ps1') `
```

</details>


---

<sub>2m 39s</sub>

### `sql`

**Complete stage twenty todos**

<details>
<summary>Arguments</summary>

```json
{
  "description": "Complete stage twenty todos",
  "query": "UPDATE todos SET status='done', updated_at=CURRENT_TIMESTAMP WHERE id IN ('stage20-drafts','stage20-create','stage20-postconditions'); SELECT id,status FROM todos ORDER BY created_at,id"
}
```

</details>

<details>
<summary>11 lines</summary>

```
Executed 2 statement(s):

1. UPDATE
   3 row(s) updated.

2. SELECT
   4 row(s) returned:
   
   | id | status |
   | --- | --- |
   | stage20-create | done |
   | stage20-drafts | done |
   | stage20-postconditions | done |
   | stage20-preflight | done |
```

</details>


---

<sub>2m 47s</sub>

### Copilot

Created and verified five ordered, unassigned child issues under #1. Repository-owned issue types are unavailable because the owner is a user account, so issues were created **without an issue type**.

| Subsection | Issue | Title | URL |
|---|---:|---|---|
| 4.1 | #2 | Add the application-layer deadline change operation | https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/2 |
| 4.2 | #3 | Expose deadline changes through the booking facade | https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/3 |
| 4.3 | #4 | Implement the deadline editor backing model | https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/4 |
| 4.4 | #5 | Implement the PrimeFaces deadline dialog | https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/5 |
| 4.5 | #6 | Integrate deadline editing into the Administration dashboard | https://github.com/edburns/dd-3070094-cargotracker-linux-x64-01/issues/6 |

**Ordered child list:** `2,3,4,5,6`

**Suggested stage 25 invocation:**
```bash
/home/edburns/.copilot/plugins/shepherd-task/scripts/shepherd-task-25-given-list.sh \
  2,3,4,5,6 \
  1-arrival-deadline-control-remove-before-merge
```

**Parsed blocking resolutions:**

- **3.1 — Which cargos expose the edit operation?**

  > Select Option A. Expose the edit affordance only in `src/main/webapp/admin/tables/listNotRouted.xhtml`. The application and facade operations remain generally callable for any cargo that can be found by tracking ID; they do not encode knowledge of dashboard table membership.

- **3.2 — What is the exact domain mutation?**

  > Use the same aggregate-update pattern as `changeDestination(...)`. Add `BookingService.changeDeadline(TrackingId, Date)` and implement it by loading the cargo, constructing a new `RouteSpecification` from the existing origin, existing destination, and supplied deadline, calling `cargo.specifyNewRoute(...)`, and storing the cargo through `cargoRepository.store(...)`. Do not add mutable deadline setters to the domain objects.

- **3.3 — What should happen to an existing itinerary and delivery state?**

  > Retain the existing itinerary. Do not clear, replace, or reroute it as part of the deadline change. `Cargo.specifyNewRoute(...)` recalculates the delivery snapshot and routing status against the replacement specification. In the established sequential application test, the assigned itinerary remains unchanged and the cargo remains `MISROUTED` after the deadline changes.

- **3.4 — What type crosses the facade boundary?**

  > Add `void changeDeadline(String trackingId, Date arrivalDeadline)` to `BookingServiceFacade`. `DefaultBookingServiceFacade` converts the string to `new TrackingId(trackingId)` and passes the same `Date` to `BookingService.changeDeadline(...)`. No new command DTO or formatted-string service parameter is introduced.

- **3.5 — How is the DTO’s formatted deadline converted for editing?**

  > Use Option A and keep date conversion inside the view-scoped editor bean. The existing implementation loads the `CargoRoute`, creates `new SimpleDateFormat("MM/dd/yyyy")`, and parses the leading date portion of `cargo.getArrivalDeadline()`. Because that value begins with `MM/dd/yyyy`, `SimpleDateFormat.parse(...)` obtains the same date that `getArrivalDeadlineDate()` displays. A per-load formatter is used, so no shared mutable formatter is added.

- **3.6 — Which JSF bean scopes and interaction pattern should be used?**

  > Mirror the existing Change Destination interaction. Implement `ChangeArrivalDeadlineDate` as a serializable CDI `@Named @ViewScoped` bean and `ChangeArrivalDeadlineDateDialog` as a serializable `@ManagedBean(name = "changeArrivalDeadlineDateDialog") @SessionScoped` bean. Use a PrimeFaces dynamic dialog rather than navigation to a full page or inline cell editing.

- **3.7 — What is the dynamic-dialog contract?**

  > Open `/admin/dialogs/changeArrivalDeadlineDate.xhtml` with a single `trackingId` request parameter and these options: modal and draggable are `true`, resizable is `false`, content width is `410`, and content height is `280`. Successful submission closes with `"DONE"`; cancellation closes with the empty string. The caller handles `dialogReturn` and updates `tableNotRouted`. Place the dialog’s `<f:metadata>` directly under the root `<html>` element, before `<h:head>` and `<h:body>`, so the known MyFaces `UIViewRoot` requirement is satisfied.

- **3.8 — What date validation is required?**

  > Require a non-null date selection, but add no new chronological business rule. In particular, do not require the replacement deadline to be after today, after the old deadline, or after every itinerary leg. Pass the selected `java.util.Date` to the existing domain construction path and let the current `RouteSpecification` invariants apply.

- **3.9 — How will the feature be tested on the prepared historical baseline?**

  > Extend the existing sequential Arquillian `BookingServiceTest` with `testChangeDeadline()` after `testChangeDestination()`. The test changes the deadline by one month, reloads the cargo through JPA, and asserts the complete set of preserved and recalculated domain state described above. The prepared Open Liberty build compiles this test but retains the historical default `skipTests=true`; executing that Arquillian suite still requires its documented remote Payara environment. Therefore the mandatory executable gates are the JDK 17 Open Liberty package/start command, direct HTTP checks, and the complete `DEF789` browser acceptance flow. No Arquillian-runtime modernization or new mocking dependency is part of this feature.

---

<sub>Generated by [GitHub Copilot CLI](https://github.com/features/copilot/cli)</sub>
