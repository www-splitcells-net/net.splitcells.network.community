# Make constraint multi-threading usable
* Issue number: [\#39](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/39)
# Task Description
Currently, the multi-threading decreases the runtime performance by 100% percent.
Therefore, it is disabled for now, except for one test.

The basis for the constraint multi-threading was created [here](../projects/2024-08-22-sigma-grind-of-24th-of-august-2024.md).
# Tasks
* [ ] Log warning about experimental feature via Dem, when ConstraintMultiThreading is true.
* [ ] Every thread should have a name, so these are easier to understand in the debugger.
* [ ] First complete [this ticket](2024-05-31-create-no-code-gel-editor.md).
* [ ] Try improving multi-threading of constraint nodes by grouping additions and removals together.
    * [ ] Do not reset rating cache too often
    * [ ] Ensure calling `Constraint#rating` implicitly at end of line group update.
        * [ ] How to ensure the constraint node is synchronized to its parents, too?
* [ ] Create integration test for multi-threading.
    * [ ] Document, that only test multi-threading in integration and fuzzy tests. Basic concurrency tests should be done in normal tests.
* [ ] Improve constraint performance, by only using dedicated thread for constraint nodes,
  that have more than 2 children.
* [ ] Consider analysis, that states which thread worked at which constraint node.
* [ ] Make editor working faster via multi-threading.
    * [ ] Prevent lock up of edtior via multi-threading.