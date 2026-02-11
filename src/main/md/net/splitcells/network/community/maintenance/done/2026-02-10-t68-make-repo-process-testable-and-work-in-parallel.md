# Make repo process testable and work in parallel.
* Issue number: [\#68](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/68)
* Start Date: 2026-02-10
* End Date: 2026-02-12
# Task Description
Repo process should generate one script per call, just like worker execute.
This also makes the process more debuggable.
# Tasks
* [x] Migrate TODOs from old implementation to new one.
* [o] Implement net_splitcells_os_state_interface_repo_process_repo_peer_disabled -> This is not needed, as it is not used and because the --ignore-peer-repos is properly propagated.
* [x] Implement current processing.
* [x] Implement children processing.
* [x] Implement peer processing.
* [x] Implement recursion.
* [x] Implement missing repo processing.
* [x] Implement unknown repo processing.
* [x] Implement optional parallelism.
* [x] Implement --ignore-peer-repos.
* [x] Pass repos process calls to new implementation via environment variable.
* [x] Make child repo naming consistent in script. See sub vs child repo.
* [x] Deprecate old repo process and add task for the future to replace delete the old process.
  Thereby, the migration would be finished.
  -> It's done the other way around: v2 is used by default and only a special flag enables v1.
  This way v2 is tested as much as possible via normal usage.
  The v1 integration in v2 has an end date:
  if the 2026.03.12 is reached, any execution of v2 will fail and
  require the removal of v1 and its integration in v2 from source code.
* [x] Format multi line string example, to not mix up code indentation.
* [x] Log each processed repo in generated script.
* [x] Test high nesting level like on developer computer.
* [x] Make repos.push.at.all work.