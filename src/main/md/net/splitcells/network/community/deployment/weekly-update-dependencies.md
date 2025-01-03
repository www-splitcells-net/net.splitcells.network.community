# Weekly update dependencies
* Issue number: [\#10](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/10)
# Task Description
Ensure, that the dependencies of all program code (i.e. Java) is up to date.
# Service
* Update `net.splitcells.network.bom`.
    * `mvn versions:update-parent`
    * `mvn versions:use-next-releases`
* Monthly update `net.splitcells.network.distro.java.acme`.
# Tasks
* [ ] Retry splitting bom project into a bom base and a bom log project, as it may be easier, than one thinks.
  An optional build check could check, if the update did its job completely in the bom log 
  therefore completely fix the code duplication issue.
    * [ ] Enable optional build check via `mci -Dare-dependencies-up-to-date=true`.
    * [ ] Split bom project.
    * [ ] Test the split.
    * [ ] Update README.
* [ ] Create profile, that updates dependencies.
* [ ] Create automatic command via `https://www.mojohaus.org/versions/versions-maven-plugin/index.html`,
  with a very specific commit message, that can be used, in order to easily filter such commits.
# Done Tasks
* [x] Note why `net.splitcells.network.bom` is not split into `net.splitcells.network.bom` and `net.splitcells.network.bom.base`.
  * [x] Hard to update BOM of BOM automatically and without human error.
  * [x] The BOM repo has not that many dependencies yet and therefore not that many commits.
* [o] Split `net.splitcells.network.bom` into `net.splitcells.network.bom` and `net.splitcells.network.bom.base`.
  The latter only has commits regarding, why a dependency is used or not.
  The former is only used to update the versions of the latter and
  thereby avoid mixing processing data and real source code.
  -> Split is not done, as it makes things harder and the split is not needed for now.