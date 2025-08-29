# Process project status badges weekly
* The issue number is [\#32](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/32).
# Task Description
Here automated tests are maintained and their results processed.

All workflows should be green for most of the time.
If a new automated workflow is being created, add it to the status badges only,
when it is green most of the time.
Alternatively, these should be executed by hand,
as otherwise it is hard to judge the status,
when it is stating failure all the time.
This does not apply for statuses, that show progress.
# Service
* Process status badges.
    * Improve test coverage: currently working on `net.splitcells.dem.api`.
* Execute static code checks.
# Tasks.
* [ ] Fix code coverage.
    * This is done in the daily workflow: https://codeberg.org/splitcells-net/net.splitcells.network.hub/actions
    * [x] Do code coverage only on the main `net.splitcells.network` repo for now, as there is a problem with the distro repo.
      Note why code coverage is done this way.
    * [x] Check by hand if the aggregate test coverage report is correct.
    * [x] Re-enable codecov.io upload via Maven. See [\#30](../deployment/weekly-t30-deploy-tests.md) for current work on that. -> The upload does not work. -> Not it works magically without changing anything.
    * [ ] Upload JaCoCo code coverage to website via sftp.
    * [ ] Remove codecov upload in GitHub CI.
    * [ ] Delete codecov integration.
    * [ ] Add to daily Codeberg test a test coverage report generator and upload it to the website.
    * [ ] Move as much of commands as possible from CI YML file to dedicated project commands, so these can be used anywhere.
      For instance, the code coverage report could be uploaded from a developer computer.
* [ ] Enable site goal in daily test, in order to test everything that is part of the Maven build.
* [ ] Do Sonar[]()Cloud scan in Codeberg and not in GitHub by applying the can just on the main `net.splitcells.network` repo.
* [ ] Let Tester test capability tests as well. 
* [ ] Use https://github.com/CodeIntelligenceTesting/jazzer to test website server.
    * [ ] Use fuzzy miner on tables, allocations and lookups, as nesting these can have and had subtle errors.
* [ ] Use https://github.com/spotbugs/spotbugs-maven-plugin
* [ ] [Search for security bugs via SpotBugs.](https://spotbugs.readthedocs.io/en/latest/maven.html)
* [ ] Use https://maven.apache.org/plugins/maven-pmd-plugin/examples/usingRuleSets.html
* [ ] Use https://checkstyle.sourceforge.io/
* [ ] https://spotbugs.github.io/
* [ ] https://dependencytrack.org/
* [ ] Establish test for all project commands (`bin/*`).
* [ ] Consider asking AI to find bugs for inspiration.
  Maybe there is an easy way to generate kind of complex queries for AI based source code,
  so that AI can think about, what is happening in the code?
  It would be interesting, how this would work for code without external dependencies.
  Could the AI analyse the semantics?
* [ ] Maybe just safe somewhere interesting frameworks, as using too many will just create problems:
    * https://github.com/cmu-pasta/mu2
    * https://github.com/rohanpadhye/JQF
* [ ] Consider [JSpecify](https://jspecify.dev/).
* [ ] Daily test Maven site goal. 
# Done Task
* [x] Make `net.splitcells.network.repos.license.check` successful and add it to the daily CI.
  Images are licensed under `CC BY-SA 4.0`. The appropriate guidelines and metadata will be handled [here](../documentation/2021-08-04-improve-licensing-practices.md).
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