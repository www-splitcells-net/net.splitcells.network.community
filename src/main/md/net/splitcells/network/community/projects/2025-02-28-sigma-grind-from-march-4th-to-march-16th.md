# Sigma Grind starting from March 4th to March 16th
Moving closer to a full synergy between the subprojects.
# Tasks
* [ ] [Create a unified backend for editor, which will be the basis for the optimization network.](../features/2024-11-13-t37-solve-sport-lesson-assignment.md)
  This makes it easier to introduce a new grammar while supporting the existing input code and with minimized code duplication.
    * [x] Migrate code editor.
        * [x] Create new backend.
            * [x] Constraint
                * [x] Support nested constraints.
                * [x] Add constraints at solutionDescription parsing.
            * [x] Migrate all tests.
                * [x] testOutputFormat
                * [x] testParseProblem
                * [x] testParseProblemWithForAllCombinationsOf
                * [x] testInvalidDemandAttribute
                * [x] testInvalidSupplyAttribute
        * [x] Use new backend in webserver.
        * [x] Delete old backend.
    * [ ] Migrate no-code editor.
        * [ ] Create new backend.
            * [ ] NoCodeEditorLangParser
                * [x] parseNoCodeStrings is not required.
                * [x] Create SolutionDescription.
            * [ ] CodeConstraintLangParser
                * [o] testStringParsing -> This tests does not really make sense.
                * [ ] testAttributeParsing -> testParsing
                * [ ] testConstraintParsing
                * [ ] testDatabaseParsing
                * [ ] testProblemParsing
                * [ ] testProblemParsing2
                * [ ] testOptimization
        * [ ] Migrate all tests.
        * [ ] Use new backend in webserver.
        * [ ] Delete old backend.
    * [ ] Change package structure by using this pattern; `net.splitcell.gel.ui.editor.[code|no_code]`
    * [ ] Delete `net.splitcells.gel.ui.Editor`.
    * [ ] Delete SolutionParameters.
    * [ ] Move ANTLR parser to `net.splitcells.dem.source`, in order to isolate Java legacy code.
    * [ ] Visualize error location. Currently, `*Description.toString()` has no visualization of its content.
      The visualization of each description should correspond with the fitting user input part.
    * [ ] Test unified backend.
* [ ] [Port Network worker exection to Java.](../compatibility-portability-and-adaptability/2025-02-25-t59-port-shell-project-to-java-and-the-network-worker.md)
    * [ ] Try to get the deployment to the live server working via a Java based Network worker execution.
    * [ ] Create unit tests for the Java based Network worker execution.
* [ ] [Establish symbiosis strategy.](../cooperation-and-symbiosis/2025-03-01-establish-symbiosis-strategy.md)
    * [ ] Integrate symbiosis project into objectives, even though the status of symbiosis is questionable.
* [ ] [Consider compatibility with git-repo-manager.](../cooperation-and-symbiosis/2022-10-25-consider-compatibility-with-git-repo-manager.md)
* [ ] Import and export input data in Gel editor.
* [ ] Fix Gel UI's no-code editor.
    * [ ] Sometimes the pop-up is not wide enough for the title.
* [ ] Explain, what the Splitcells Network is.
* [ ] Document why the no-code editor exists.
    * [ ] Make features more discoverable.
    * [ ] This provides a default UI for features like persistent optimization problems,
      that are stored on the server and 
    * [ ] No-code is no replacement for documentation.
    * [ ] The no-code editor is probably not really needed for now.
      When the editor was created, it was seen as a way to minimize amount of doc and
      to provide a tool for the user to learn and explor the software by experimenting.
    * [ ] Multiple frontends make ensure, that the backend is really independent of the frontend.
      Thereby, the backend does not rely on ANTLR.
    * [ ] Most likely initially creating no-code editor was an error,
      but now, that there is a working one it does not make sense to delete it for now.
    * [ ] In the future, this could be used as a basis for interacting with complex objects likes configs via the GUI.
* [ ] Document stable API plan via `net.splitcells.network.system.stable`.
* [ ] Make Community Block easier to find via front menu.