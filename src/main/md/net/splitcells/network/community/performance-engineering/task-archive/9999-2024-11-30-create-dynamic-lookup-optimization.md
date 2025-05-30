# Create dynamic lookup optimization.
* Issue number: [\#55](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/55)
# Task Description
The basic idea is, that the lookups created by tables should in fact be lookup managers,
that decide what kind of lookup implementation is used.
The decision is based on the fly statistics regarding the access patterns.
There should be 2 major implementations:
the first one is the existing one, that caches and synchronizes everything.
The second one would be a new one, that caches and synchronizes nothing.

The manager should create a report, that states by how much the performance
is estimated to be improved.
# Tasks
* [ ] Add to the main objectives a general performance objective,
  where every static or dynamic optimization manager needs a runtime checks,
  that measure their effectiveness.
  Managers without such runtime checks should not be allowed.
* [x] Rename lookup methods to persisted lookup methods,
  in order to indicate, that these stay up to date.
* [x] Create lookup method, that does not guarantee synchronization,
  that is only used to look up a value once.
  Implement it with the synchronized lookup method first.
* [x] Implement an alternative lookup method with a temporary lookup table.
* [x] Use temporary lookup were possible.
  Find the relevant places via the commit c24999.
* [x] The general performance is currently very bad for the 
  colloquium problem example in `gel.ui`.
  Fix it.
* [x] Create an alternative lookup method, that chooses the other implementations
  based on statistics.
    * [o] Too many LookupManager are created, where only one value is ever looked up.
      -> This seems to be caused by LookupColumn, that contain LookupManager,
      which in turn contains LookupColumns.
      -> The LookupManager count seems not to be big enough for now, for it to be relevant.
    * [x] Fix LookupManager errors in live distro.
    * [x] Create tests for LookupManager.
    * [x] Create manual performance test in live DevDistro with disabled runtime checks.
      -> The runtime performance is good enough for now, when runtime checks are disabled.
* [ ] Create performance report. -> The report is provided at `http://localhost:8443/net/splitcells/system/performance-report.html`.
    * [ ] Number of tables
    * [ ] Number of table reads
    * [ ] Number of table writes
    * [ ] Number of lookup managers
    * [ ] Number of strategy changes in lookup manager
    * [x] Number of lookup manager writes based on table modification counters.
    * [ ] Number of lookup manager reads
    * [ ] Number of persisted lookups in lookup manager and their read and write counts.
    * [ ] Number of cached lookups in lookup manager and their read and write counts.
    * [ ] Number of assignment tables and their read and write count.
    * [ ] Number of assignment tables writes in relation to the number of table and lookup writes.
      The same for reads as well.
    * [ ] Number writes for assignment tables of a solution in relation to the number of table and lookup writes.
      The same for reads as well.
* [ ] Compare benchmarks of any possible usage.
    * [ ] Existing implementation.
    * [ ] Recalculating lookup.
    * [ ] Lookup manager
* [ ] Add to performance guidelines the idea,
  that automatic reports with an automatic interpretation is better
  than raw data most of the time,
  because analysing raw data of performance counter is often not cost-efficient.