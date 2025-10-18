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
* Improve test coverage.
    * Current JaCoCo report: https://splitcells.net/net/splitcells/martins/avots/website/jacoco-aggregate/index.html
    * Currently working on: https://splitcells.net/net/splitcells/martins/avots/website/jacoco-aggregate/dem.api/net.splitcells.dem.resource/FileSystemViaClassResourcesImpl.html
* Execute static code checks.
# Tasks.
* [ ] Run each CI step via just one shell script, as things like `source [...]` and environment variables have unexpected side effects.
    * [x] Remove debugging commands.
* [ ] Consider enforcing a minimal Maven version.
* [ ] Move as much of commands as possible from CI YML file to dedicated project commands,
  so these can be used anywhere and are therefore more standardized.
  For instance, the code coverage report could be uploaded from a developer computer.
    * [x] Build
    * [ ] Build Reports
    * [ ] Upload Reports
* [ ] Do SonarCloud scan in Codeberg and not in GitHub by applying the can just on the main `net.splitcells.network` repo.
    * [x] Sonarcloud integration does not work at network hub repo, as only the `net.splitcells.network` repo is known there.
    * [ ] Move scan from GitHub to Codeberg: `mvn -B clean install org.sonarsource.scanner.maven:sonar-maven-plugin:sonar -Dsonar.projectKey=www-splitcells-net_net.splitcells.network -Dsonar.test.exclusions=src/main/java/** -Dsonar.organization=www-splitcells-net -Dsonar.host.url=https://sonarcloud.io # `-Dsonar.inclusions=src/main/**,bin/*` does not seem to work.`
    * [ ] Disable GitHub based CI, as it has no use after that anymore.
* [ ] Record and upload test runtime performance via network log repo.
* [ ] Record warnings, that should be fixed, like warnings during XSL rendering in the network logs.
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
* [ ] Consider OWASP's dependency-check-maven for checking security vulnerabilities in dependencies.
* [ ] Ensure, that all scripts like Bash scripts are tested as well.
  Consider creating a coverage report for this ,too.
* [ ] Create distinct code coverage reports for unit tests, integration tests and functionality tests.
# Done Task
* [x] Fix push CI.
    * [x] GitHub.
    * [x] Codeberg
    * [x] Enable E-Mail notification on the Codeberg CI.
      -> It is not possible to enable e-mail notifications just for CI.
      Therefore, it is not done, in order to avoid notification spamming regarding [CI requests](https://codeberg.org/Codeberg-e.V./requests/issues) etc. .
* [x] Enable `dominant management` for daily Codeberg workflow, in order to speed it up and lessen resource usage.
  -> This was already the case.
* [x] Execute tests of shell projects in daily CI as well. - This was already the case.
* [x] Enable site goal in daily test, in order to test everything that is part of the Maven build.
* [x] Fix mvn site error.
    * [x] Maybe it is caused by the Maven version 3.8.7-2 in the daily CI,
      as it works on my local PC with maven 3.9.5.
      This [Apache issue](https://issues.apache.org/jira/browse/MSITE-967) implies, that this is the problem.
      -> I could confirm on my PC, that the Maven version is causing the problem.
        * [x] Use [Maven Wrapper](https://maven.apache.org/tools/wrapper/), in order to set up correct Maven version.
* [x] Fix code coverage report.
    * This is done in the daily workflow: https://codeberg.org/splitcells-net/net.splitcells.network.hub/actions
    * [x] Do code coverage only on the main `net.splitcells.network` repo for now, as there is a problem with the distro repo.
      Note why code coverage is done this way.
    * [x] Check by hand if the aggregate test coverage report is correct.
    * [x] Re-enable codecov.io upload via Maven. See [\#30](../deployment/weekly-t30-deploy-tests.md) for current work on that. -> The upload does not work. -> Not it works magically without changing anything.
    * [x] Upload JaCoCo code coverage to website via sftp. Check this at https://splitcells.net/net/splitcells/martins/avots/website/jacoco-aggregate/index.html
    * [x] Do not echo private key for upload.
    * [x] Replace private key for SFTP upload.
    * [x] Clean up SFTP server for static site.
    * [x] Remove codecov upload in GitHub CI.
    * [x] Delete codecov integration.
    * [x] Add to daily Codeberg test a test coverage report generator and upload it to the website.
    * [x] Delete static website and reupload everything, in order to get rid of old and potentially manipulated data.
* [x] Move source code check to daily workflow, as it can otherwise be hard to fix anything in the grammar.
  See the protected keyword problem.
* [x] Skip Javadoc build, when site goal is not target during Maven command, in order to speed up developer builds.
    * [x] Move Javadoc build to site goal.
    * [x] Execute site goal in daily workflow.
    * [o] Is an explicit Javadoc plugin required in the parent POM in this case?
      -> This is not important for now.
      Stating the Maven plugin determines its version.
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