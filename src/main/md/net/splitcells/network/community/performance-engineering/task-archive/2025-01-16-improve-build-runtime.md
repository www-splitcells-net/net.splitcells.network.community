# Improve Maven build runtime.
* Issue number: [\#58](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/58)
# Tasks
* [ ] Create extended build, that is executed daily by CI.
* [ ] Test without testCompile during normal build and with testCompile during extended build.
    * [ ] Execute test without surefire.
* [ ] Build javadoc by default only in extended build.
* [ ] Check source code by default only in extended build.
* [ ] ANTLR parsing is slow. Note that there are ANTLR profilers.