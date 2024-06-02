# Create minimal build with zero dependency except for the standard runtime
This is also the basis for #88.
* [ ] Find out how to properly change licence from `MIT + EPL 2.0` to `GPL 2+ + EPL 2.0`.
    * [ ] According to REUSE.
    * [ ] According to https://www.gnu.org/licenses/license-compatibility.html
* [ ] Use a dedicated folder for projects with no dependencies, except for the standard runtime (Java Runtime). -> Code integrating dependencies should be moved to dedicated projects.
* [ ] Create alternative to JUnit. Do not try to salvage JUnit Test annotation, because it will never be portable (JUnit 4 and 5 have a different basic Test annotation).
    * [x] Consider using only annotation and generic of kara test framework: https://github.com/karatelabs/karate -> Karate does not have their own test annotations and is therefore not viable.
        * [ ] Test IDE support: https://github.com/karatelabs/karate/wiki/IDE-Support
    * [x] Following could be used to integrate other test frameworks like JUnit, PIT and Code coverage: render all Java code to new temporary project. Replace test annotations as needed and execute test framework as needed. -> This is not viable, as it makes it impossible to start test from original Source Code via IDE and one click.
    * [ ] Use meta-annotations in code, that are defined by 2 projects: one project defines the meta-annotations without JUnit and the other define the meta-annotations with JUnit. Link the JUnit version to the project by default, but make it replaceable by the non JUnit version.
* [ ] Create minimal `pom.java.default` and use it for pure projects. Existing `pom.java.default` should depend on this POM. The goal is to have a viable `pom.java.default` without dependencies (i.e. JUnit).
* [ ] Remove XSL dependency.