# Process project status badges weekly

* The issue number is [\#32](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/32).

# Service

* Process status badges.
* Minimize number of issues
* Ensure that test coverage only rises. Currently, at: https://app.codecov.io/gh/www-splitcells-net/net.splitcells.network/tree/master/projects%2Fnet.splitcells.dem%2Fsrc%2Fmain%2Fjava%2Fnet%2Fsplitcells%2Fdem%2Fexecution

# Tasks

* [ ] Use https://github.com/spotbugs/spotbugs-maven-plugin
* [ ] Use https://maven.apache.org/plugins/maven-pmd-plugin/examples/usingRuleSets.html
* [ ] Find a way for SoundCloud etc. to ignore certain things via an annotation and comment.
  I think, FindBug has something like that.
  * [ ] Create guidelines for handling code scanning like how to handle default rules and its false positives.

# Note on SoundCloud

Consider disabling rules, if these cause problems in some cases,
as removing too many rules is better than the other way.
Rules that cause problems sometimes from experience seem to typically require a lot of time with limited benefits.
If all problems/warnings are solved one can consider to re-enable and solve these one at a time.