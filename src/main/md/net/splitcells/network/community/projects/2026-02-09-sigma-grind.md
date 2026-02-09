# Sigma Grind of 2026.02.09
* [ ] Maintenance cycle.
* [ ] Get all cluster tests running and the results pushed to the network log.
* [ ] Support repo synchronization with on command.
  Currently, 2 commands `net.splitcells.network.bom.repo.pull` and `repo.push.at.all` are required,
  as dependencies can be updated.
* [ ] Start `repos.process.2`, which does its execution by generating shell scripts.
  This makes tests easier in the future.
  Define environment variable for `repos.process`, in order to delicate the calls to it to the new `repos.process.2`.
  When everything is ready the old implementation is replaced by the new one.
* [ ] Work on [sport lesson assignment](../../features/2024-11-13-t37-solve-sport-lesson-assignment.md).