# Release software to Maven Central repositories

# Task Description
This makes sure, that the Java code is releasable via Maven at any time.

# Tasks
- [x] Create guidelines/checklist for Maven Central public release.
- [ ] https://ozkanpakdil.github.io/maven/2024/03/10/publish-central-maven.html
- [ ] Make it easy to update plugins by setting the version in the parent via properties: https://stackoverflow.com/questions/34032262/maven-versions-plugin-updating-plugins
- [ ] Release to GitHub repo first for initial testing.
    - [x] https://stackoverflow.com/questions/53637262/setting-the-developerconnection-for-the-maven-release-plugin-from-the-command-li/54250791#54250791
    - [ ] https://axelfontaine.com/blog/dead-burried.html
    - [x] Make snapshot deployments:
        - [x] `mci && mvn deploy -Drepo-github-enable=1`
        - [x] [Ensure GitHub authentication works.](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-apache-maven-registry)
        - [x] Document Maven repo on GitHub as an alternative to Maven Central, which would especially suitable for snapshot builds.
        - [x] Test and document using snapshot builds as a dependency. Use a dedicated settings file with environment variables for this (see https://stackoverflow.com/questions/31251259/how-to-pass-maven-settings-via-environmental-vars and https://stackoverflow.com/questions/25277866/maven-command-line-how-to-point-to-a-specific-settings-xml-for-a-single-command).
        - [x] Use temporary m2 folder for testing.
        - [x] Use all projects as Snapshot dependencies for system project, which in turn can be used as a full GitHub test.
        - [x] #190
    - [x] Create release script. -> `bin/build.with.github.snapshots`
```
mci
mvn release:prepare -Drepo-github-enable=1
mvn release:perform -Drepo-github-enable=1
```
- [ ] Create release guidelines.
    - [ ] https://dzone.com/articles/how-to-create-and-release-a-jar-to-maven-central
        - [ ] https://maven.apache.org/repository/guide-central-repository-upload.html
            - [x] Create sources.
            - [x] Create Javadoc.
            - [x] Deploy sources.
            - [x] Deploy Javadoc.
            - [x] Provide checksums.
            - [x] Sing files with GPG/PGP.
                - [x] Document singing process.
            - [x] name
            - [x] description
            - [x] URL
            - [x] License
            - [x] Developer Information
            - [x] SCM Information
- [ ] Release to Maven Central.
    - [ ] https://central.sonatype.org/publish/publish-guide/
    - [ ] https://medium.com/geekculture/how-to-publish-artifacts-on-maven-central-24342fd286cd
- [x] Create Minimum POM information
- [x] Add PGP signing: https://central.sonatype.org/publish/requirements/#provide-files-checksums
- [ ] Public Maven-Release is not required right now. When to do it? -> Do it, when the first version is published via FlatHub. See #195
- [ ] Create guidelines how to do formal releases. Maybe do a release every half year, with the date as the real version number?
- [ ] Make release artifact as small as possible, by minimizing the resources imported.
  This means, that a release to Maven central, would be a minimal release.