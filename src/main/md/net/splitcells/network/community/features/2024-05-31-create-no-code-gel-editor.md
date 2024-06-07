# Create no-code gel editor
* Provide a no-code editor for gel,
  in order to ease the documentation of the programming language
  by avoiding or minimizing documentation regarding the language's syntax.
* [\#c24](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/24) is the issue.
# Tasks
* [x] Create HTML data mockup.
* [ ] Create backend language based on mockup.
    * [x] Adjust original language,
      so that attributes are declared like variables and used as arguments
      for the constructor calls of demand and supply databases.
      -> There is no imminent need for the code editor
      and therefore that original language has currently no priority.
    * [x] Make `school-course-scheduling-problem.xml` complete.
    * [x] Make `submit optimization` working.
        * [x] Fix syntax error.
        * [x] Make `NoCodeProblemParser` complete.
        * [x] Optimize example data.
    * [ ] Test parsing of no-code constraints. Currently, it is assumed to be working.
* [ ] Process optimization request based on new language.
* [ ] Extend language tree in front end with language actions. CURRENT
    * [ ] Create HTML mockup of language actions via Javascript.
    * [ ] Implement language actions as Javascript code.
    * [ ] Create fragment rendering for webserver, where document is rendered without any layout.
    * [ ] Implement generic help functionality.
        * [ ] Make help pop up closeable.
        * [ ] Do not open multiple help pop-ups.
        * [x] Render help text via iframes for proof of concept.
      * [ ] Use fragment rendering to render help text, instead of using iframes.
* [ ] Clean up visual design of no-code editor.