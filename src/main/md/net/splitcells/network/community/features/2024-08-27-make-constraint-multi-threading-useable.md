# Make constraint multi-threading usable
* Issue number: [\#39](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/39)
# Task Description
Currently, the multi-threading decreases the runtime performance by 100% percent is disabled,
except for one test.

The basis for the constraint multi-threading was created [here](../projects/2024-08-22-sigma-grind-of-24th-of-august-2024.md).
# Tasks
* [ ] First complete [this ticket](2024-05-31-create-no-code-gel-editor.md).
* [ ] Try improving multi-threading of constraint nodes by grouping additions and removals together.
    * [ ] Do not reset rating cache too often
    * [ ] Ensure calling rating at end of group or implicitly.
        * [ ] How to ensure the constraint node is synchronized to its parents, too?
    * [ ] Document, that only test multi-threading in integration and fuzzy tests. Basic concurrency tests should be done in normal tests.
    * [ ] Create integration test for multi-threading.
    * [ ] Consider grouping adding and removing allocations together for greater runtime performance.