# Weekly update dependencies
* Issue number: [\#10](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/10)
# Task Description
Ensure, that the dependencies of all program code (i.e. Java) is up to date.
# Service
* Update `net.splitcells.network.bom` via `bin/repos.dependencies.update` (this is done via the daily CI atm).
* Check for new Java versions: https://www.java.com/releases/ and https://jdk.java.net/
* Check for new Maven versions: https://maven.apache.org/docs/history.html
# Tasks
* [ ] [Migrate to Java 25](https://openjdk.org/projects/jdk/25/)
* [ ] [Migrate to Maven 4](./2025-09-03-t65-migrate-to-maven-4.md)
* [ ] Add automatic dependency updates for distro repo as well. 
# Done Tasks
* [x] Note why automatic update is only updating by one version increment for each dependency.
* [x] Create automatic command via `https://www.mojohaus.org/versions/versions-maven-plugin/index.html` and create a daily workflow for that.
  That daily workflow updates the dependencies, does an extensive test and if everything was successfully,
  the dependency update is pushed to the public Codeberg server.
  Maybe this could be done during the already [existing daily workflow](../maintenance/weekly-t32-process-project-status-weekly.md).
    * [x] Test update in daily workflow.
    * [x] Commit update in BOM after update test.
    * [x] Push commit to Codeberg.
* [o] Rename `net.splitcells.network.bom` to `net.splitcells.dem.bom`, in order to correctly show subproject interdependencies.
  with a very specific commit message, that can be used, in order to easily filter such commits.
  -> This does not need to be done, as there are dependencies for the whole project and not just `net.splitcells.dem`.
* [x] Keep Playwright version in network BOM and network execute in syn,
  by parsing the BOM's version in the network execute command,
  in order to set the version in the POM template.
    * [x] Make Playwright version a template parameter.
    * [x] Test generated Playwright version.
    * [x] Parse Playwright dependency from BOM repo.
    * [x] Parse Playwright version from BOM repo.
    * [o] Disable Playwright parsing during tests, so these do not have to be changed all the time.
      -> The resulting POM for the container is compared to a regex instead.
    * [x] Insert parsed Playwright into container POM.
    * [x] Test parsed Playwright version.
    * [x] Test inserted Playwright version by replacing the default version during test.
* [x] Retry splitting bom project into a bom base and a bom log project, as it may be easier, than one thinks.
  An optional build check could check, if the update did its job completely in the bom log
  therefore completely fix the code duplication issue.
    * [x] Create `net.splitcells.network.bom.base` project as a duplicate of `net.splitcells.network.bom`.
    * [x] Transform `net.splitcells.network.bom` into the bom log repo, that updates `net.splitcells.network.bom.base`
      and has `net.splitcells.network.bom.base` as a dependency.
    * [x] Test the split.
    * [x] Update README.
    * [x] Remove Eclipse dependencies, as Eclipse is not suitable for this project.
* [x] Create command for all weekly tasks, that can be automated or semi-automated. -> `repos.dependencies.update` is used for now.
  * [x] Check dependency update status via `mci -Dare-dependencies-up-to-date=true`. -> `test.extensive` is used for that.
* [x] Note why `net.splitcells.network.bom` is not split into `net.splitcells.network.bom` and `net.splitcells.network.bom.base`.
  * [x] Hard to update BOM of BOM automatically and without human error.
  * [x] The BOM repo has not that many dependencies yet and therefore not that many commits.
* [o] Split `net.splitcells.network.bom` into `net.splitcells.network.bom` and `net.splitcells.network.bom.base`.
  The latter only has commits regarding, why a dependency is used or not.
  The former is only used to update the versions of the latter and
  thereby avoid mixing processing data and real source code.
  -> Split is not done, as it makes things harder and the split is not needed for now.