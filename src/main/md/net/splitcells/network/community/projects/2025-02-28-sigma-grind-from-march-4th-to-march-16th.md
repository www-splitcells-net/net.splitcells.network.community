# Sigma Grind starting from March 4th to March 16th
Moving closer to a full synergy between the subprojects.
# Tasks
* [ ] [Create a unified backend for editor, which will be the basis for the optimization network.](../features/2024-11-13-t37-solve-sport-lesson-assignment.md)
  This makes it easier to introduce a new grammar while supporting the existing input code and with minimized code duplication.
    * [ ] Migrate code editor.
        * [ ] Constraint
            * [ ] Support nested constraints.
            * [ ] Add constraints at solutionDescription parsing.
    * [ ] Migrate no-code editor.
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