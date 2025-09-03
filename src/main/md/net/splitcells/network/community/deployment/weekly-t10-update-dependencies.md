# Weekly update dependencies
* Issue number: [\#10](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/10)
# Task Description
Ensure, that the dependencies of all program code (i.e. Java) is up to date.
# Service
* Update `net.splitcells.network.bom` via `net.splitcells.network.shell` and `bin/repos.dependencies.update`.
* Monthly update `net.splitcells.network.distro.java.acme`.
* Update Java
* Update Maven
# Tasks
* [ ] Keep Playwright version in network BOM and network execute in syn,
  by parsing the BOM's version in the network execute command,
  in order to set the version in the POM template.
    * [x] Make Playwright version a template parameter.
    * [x] Test generated Playwright version.
    * [x] Parse Playwright dependency from BOM repo.
    * [x] Parse Playwright version from BOM repo.
    * [ ] Insert parsed Playwright into container POM.
    * [ ] Test parsed Playwright version.
    * [ ] Test inserted Playwright version by replacing the default version during test.
* [ ] Create profile, that updates dependencies.
* [ ] Create automatic command via `https://www.mojohaus.org/versions/versions-maven-plugin/index.html`,
* [ ] Rename `net.splitcells.network.bom` to `net.splitcells.dem.bom`, in order to correctly show subproject interdependencies.
  with a very specific commit message, that can be used, in order to easily filter such commits.
# Done Tasks
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