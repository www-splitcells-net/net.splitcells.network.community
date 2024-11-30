# Create dynamic lookup optimization.
# Task Description
The basic idea is, that the lookups created by tables are in fact lookup managers,
that decide what kind of lookup implementation is used.
The decision is based on the fly statistics regarding the access patterns.
There should be 2 major implementations:
the first one is the existing one, that caches and synchronizes everything.
The second one would be a new one, that caches  and synchronizes nothing.

The manager should create a report, that states by how much the performance
is estimated to be improved.
# Tasks
* [ ] Compare runtime of any possible usage.
    * [ ] Existing implementation.
    * [ ] Recalculating lookup.
    * [ ] Lookup manager
* [ ] Add to performance guidelines the idea,
  that automatic reports with an automatic interpretation is better
  than raw data most of the time,
  because analysing raw data of performance counter is often not cost efficient.