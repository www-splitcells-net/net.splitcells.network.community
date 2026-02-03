# Grind starting from March 4th to March 16th
* Start Date: 2024-08-22
* End Date: 2025-06-03
# Task Description
Moving closer to a full synergy between the subprojects.
# Tasks
* [x] [Create a unified backend for editor, which will be the basis for the optimization network.](../features/2024-11-13-t37-solve-sport-lesson-assignment.md)
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
    * [x] Migrate no-code editor.
        * [x] Create new backend.
            * [x] NoCodeEditorLangParser
                * [x] parseNoCodeStrings is not required.
                * [x] Create SolutionDescription.
            * [x] CodeConstraintLangParser
                * [o] testStringParsing -> This tests does not really make sense.
                * [x] testAttributeParsing -> testParsing
                * [x] testConstraintParsing
                * [x] testDatabaseParsing
                * [x] testProblemParsing
                * [x] testProblemParsing2
                * [x] testOptimization
        * [x] Migrate all tests.
        * [x] Use new backend in webserver.
        * [x] Delete old backend.
    * [x] Change package structure by using this pattern; `net.splitcell.gel.ui.editor.[code|no_code]`
    * [x] Create shared SolutionCalculator.
    * [x] Use shared SolutionCalculator.
    * [x] Delete obsolete SolutionCalculators.
    * [x] Delete `net.splitcells.gel.ui.Editor`.
    * [x] Delete SolutionParameters.
    * [o] Move ANTLR parser to `net.splitcells.dem.source`, in order to isolate Java legacy code. -> This is not required right now.
    * [x] Visualize error location. Currently, `*Description.toString()` has no visualization of its content.
    * [x] The visualization of each description should also contain the corresponding fitting user input part.
    * [x] Test unified backend.
* [x] [Port Network worker exection to Java as far as possible.](../compatibility-portability-and-adaptability/2025-02-25-t59-port-shell-project-to-java-and-the-network-worker.md) -> `bin/worker.test.at` was ported to Java.
* [o] [Establish symbiosis strategy.](../cooperation-and-symbiosis/2025-03-01-t60-establish-a-symbiosis-strategy.md) -> This will be done after this grind.
* [x] Import and export input data in Gel editor.
* [x] Fix some of Gel's UI problems at the no-code editor.
    * [x] Sometimes the pop-up is not wide enough for the title.
    * [x] Correctly, delete an element of a function chain and variable definition.
* [x] Explain, what the Splitcells Network is.
* [x] Document why the no-code editor exists. -> See http://splitcells.net/net/splitcells/gel/ui/objectives.html
    * [x] Make features more discoverable.
    * [x] This provides a default UI for features like persistent optimization problems,
      that are stored on the server, or for complex config objects. 
    * [x] No-code is no replacement for code documentation.
    * [x] In the future, this could be used as a basis for interacting with complex objects likes configs via the GUI.
# Ideas
* [x] Make the description language independent of the no-code editor and transform it to general programming language.
    * [o] Abolish Constraint description and add children attribute to FunctionDescription instead.
    * [x] Update Gel UI objectives accordingly.
# Results
Part of the grind worked as expected.
It helped me to learn about how my mind works and gave me the opportunity to do mind experiments.
Unfortunately, the grind was not consistent, which lowered the amount of benefits. 