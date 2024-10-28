# Improve runtime performance of `History#resetTo`
The performance of `History#resetTo` is horrible.
This was found out via `SupplySelector#hillClimber` during the implementation of the school course scheduling.

* [x] Create `HistoryTest#test_reset_to_beginning_runtime` and tag as `TestTypes.BENCHMARK_RUNTIME`. -> 1.000 allocations can be reset in about 1-2 seconds, whereas 10.000 are reset in about 45 seconds.
* [x] Don't execute `TestTypes.BENCHMARK_RUNTIME` during default build.
* [x] How to execute `TestTypes.BENCHMARK_RUNTIME`?  -> via profiles and groups settings.
* [x] Create test execution commands.
* [x] Look at runtime logged at network log. -> Not relevant for now.
* [ ] Fix scaling issue found via test_reset_to_beginning_runtime.
    * Test via `mvn clean install -DexcludedGroups="experimental_test" -Dtest.group=benchmarking_runtime`.
    * [x] Implement cache for lines (not rawLines) in LookupTable, so that `LookupTable#line` is reasonably fast. -> Is already implemented and present in a strange way.
    * [x] Recheck via profiler, if missing rawLines cache really causes the issue. -> Cause for runtime was dominated by natural argumentation inside history.
    * [ ] Make incremental rating calculations, in the sense, that the group's rating is stored in the constraint node and then updated via differences as opposed to new rating values. This should improve performance, if there is a big incoming constraint group.
* [ ] Maybe use table instead of allocations for history content in order to minimize the number of tables, that are required for a history table.
* [ ] On personal ~5 year old Dell XPS laptop, a history build and reset of 10k with constant constraint takes about 2 minutes and 40 seconds in IDE (`HistoryTest#test_rest_to_beginning_runtime`).
    * [ ] Most of the runtime was caused by extensive runtime checks. Use the correct command for the test: `mvn clean install -Dnet.splitcells.dem.environment.config.StaticFlags.ENFORCING_UNIT_CONSISTENCY=false -Dtest.groups=benchmarking_runtime
      `
        * [ ] Create a way change the static flag for the duration of the test.
    * [ ] Find most costly locations via sampler.
        * [x] A lot of the runtime comes from linear initialization, which needs a new ordered line stream for each allocation.
          ![image](https://user-images.githubusercontent.com/119068338/232309639-198d581d-705e-41c0-88e8-f0b1c2e225d3.png)
