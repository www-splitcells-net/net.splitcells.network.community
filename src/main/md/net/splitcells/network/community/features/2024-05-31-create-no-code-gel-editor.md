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
    * [x] Create HTML mockup of language actions via Javascript.
    * [ ] Implement language actions as Javascript code.
        * [ ] Create help actions.
            * [x] For Function calls
            * [x] For variable references
            * [ ] For object access
            * [ ] For literals
        * [x] Rename variable. 
        * [ ] Choose different function call.
        * [ ] Change function call argument.
        * [ ] Remove function call.
        * [ ] Remove variable.
        * [ ] Set variable value.
            * [ ] Literal Value
            * [ ] Function call chain
            * [ ] Variable reference.
        * [ ] Add function call to function call chain.
        * [ ] Create new things.
            * [ ] Add object access via function call.
            * [ ] Create variable.
        * [ ] Limit function names, that can be chosen for new function calls.
            * [ ] Object access
            * [ ] Function call chains
            * [ ] Function call arguments
    * [x] Create fragment rendering for webserver, where document is rendered without any layout.
      -> This is not relevant for now, because it is a minor detail and also provides the advantage of making the help navigable.
    * [x] Make action menu closeable.
    * [x] Implement generic help functionality.
        * [x] Make help pop-up closeable.
        * [x] Do not open multiple help pop-ups.
        * [x] Render help text via iframes for proof of concept.
        * [x] Use fragment rendering to render help text, instead of using iframes, in order to have less visual noise in help text.
          -> This is not relevant for now, because it is a minor detail and also provides the advantage of making the help navigable.
* [ ] Clean up visual design of no-code editor.
* [ ] Make it possible for the user to store a problem definition.
* [ ] Import no-code code.
* [ ] Export no-code code.
* [ ] Remove code from `no-code-editor.js`, that is already present in `editor.js`.
* [ ] Write documentation for all Help actions.
* [ ] In no-code editor, the list of available functions etc. should be queried from webserver and not be coded into the front end.
  This information should be queried directly from `net.splitcells.gel.constraint.Query`,
  in order to avoid to code the same list at multiple locations.
* [ ] Clean up `no-code-editor.js`.