# Make repo process testable and work in parallel.
* Issue number: [\#68](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/68)
* Start Date: 2026-02-10
# Task Description
Repo process should generate one script per call, just like worker execute.
This also makes the process more debuggable.
# Tasks
* [ ] Migrate TODOs from old implementation to new one.
* [ ] Implement net_splitcells_os_state_interface_repo_process_repo_peer_disabled
* [x] Implement current processing.
* [x] Implement children processing.
* [x] Implement peer processing.
* [x] Implement recursion.
* [x] Implement missing repo processing.
* [ ] Implement unknown repo processing.
* [ ] Implement optional parallelism.
* [ ] Pass repos process calls to new implementation via environment variable.