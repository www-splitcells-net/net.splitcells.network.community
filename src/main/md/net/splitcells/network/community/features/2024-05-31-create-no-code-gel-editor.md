# Create no-code gel editor
* Provide a no-code editor for gel,
  in order to ease the documentation of the programming language
  by avoiding or minimizing documentation regarding the language's syntax.
* [\#c24](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/24) is the issue.
# Tasks
* [x] Create HTML data mockup.
* [ ] Create backend language based on mockup.
    * [ ] Adjust original language,
      so that attributes are declared like variables and used as arguments
      for the constructor calls of demand and supply databases.
    * [x] Make `school-course-scheduling-problem.xml` complete.
    * [x] Make `submit optimization` working. CURRENT
        * [x] Fix syntax error.
        * [x] Make `NoCodeProblemParser` complete.
        * [x] Optimize example data.
    * [ ] Test parsing of no-code constraints. Currently, it is assumed to be working.
* [ ] Process optimization request based on new language.
* [ ] Extend language tree in front end with language actions.
    * [ ] Create HTML data mockup.
    * [ ] Implement language actions as Javascript code.
* [ ] Clean up visual design of no-code editor.