# Process project status badges weekly

* The issue number is [\#32](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/32).

# Service

* Process status badges.
* Minimize number of issues
* Ensure that test coverage only rises. Currently, at: https://app.codecov.io/gh/www-splitcells-net/net.splitcells.network/tree/master/projects%2Fnet.splitcells.dem%2Fsrc%2Fmain%2Fjava%2Fnet%2Fsplitcells%2Fdem%2Fexecution
* Execute static code checks.

# Tasks

* [ ] Use https://github.com/spotbugs/spotbugs-maven-plugin
* [ ] Use https://maven.apache.org/plugins/maven-pmd-plugin/examples/usingRuleSets.html
* [ ] Use https://checkstyle.sourceforge.io/
* [ ] https://spotbugs.github.io/
* [ ] Consider asking AI to find bugs. Maybe there is an easy way to generate kind of complex queries for AI based source code,
  so that AI can think about, what is happening in the code?
  It would be interesting, how this would work for code without external dependencies.
  Could the AI analyse the semantics?

# Done Task

* [x] Find a way for SoundCloud etc. to ignore certain things via an annotation and comment.
  I think, FindBug has something like that.
  * [x] Create guidelines for handling code scanning like how to handle default rules and its false positives.

# Note on SoundCloud and other static code analyzers

Consider disabling rules, if these cause problems in some cases,
as removing too many rules is better than the other way.
Rules that cause problems sometimes from experience seem to typically require a lot of time with limited benefits.
If all problems/warnings are solved one can consider to re-enable and solve these one at a time.

Adding code scanner specific annotations,
so that certain problems are ignored is acceptable,
as long as these are only located at the signature of things.
For now, these are not acceptable inside method bodies for instance,
as these can hinder readability quite a lot.
Before writing these notes, adding code scanner specific annotations to the source code was not acceptable,
in order to keep a more clean version control history of the source code.