# Weekly update dependencies
* Issue number: [\#10](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/10)
# Task Description
Ensure, that the dependencies of all program code (i.e. Java) is up to date.
# Service
* Update `net.splitcells.network.bom`.
* Monthly update `net.splitcells.network.distro.java.acme`.
# Tasks
* [ ] Note why `net.splitcells.network.bom` is not split into `net.splitcells.network.bom` and `net.splitcells.network.bom.base`.
    * [ ] Hard to update BOM of BOM automatically and without human error.
    * [ ] The BOM repo has not that many dependencies yet and therefore not that many commits.
* [ ] Create automatic command via `https://www.mojohaus.org/versions/versions-maven-plugin/index.html`.
# Done Tasks
* [o] Split `net.splitcells.network.bom` into `net.splitcells.network.bom` and `net.splitcells.network.bom.base`.
  The latter only has commits regarding, why a dependency is used or not.
  The former is only used to update the versions of the latter and
  thereby avoid mixing processing data and real source code.
  -> Split is not done, as it makes things harder and the split is not needed for now.