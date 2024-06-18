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
* [ ] Extend language tree in front end with language actions.
    * [x] Create HTML mockup of language actions via Javascript.
    * [ ] Delete language actions from GUI, when optimization problem is submitted.
    * [ ] Implement language actions as Javascript code.
        * [x] Create help actions.
            * [x] For Function calls
            * [x] For variable references
            * [x] For variable access
            * [x] For literals
        * [x] Rename variable. 
        * [ ] Choose different function call.
        * [x] Change function call argument.
        * [x] Remove function call.
        * [x] Remove variable.
        * [x] Set variable value.
            * [x] Literal Value
            * [x] Function call chain.
            * [x] Variable reference.
        * [x] Append function call to function call in chain.
        * [ ] Create new things.
            * [ ] Add object access via function call.
            * [ ] Create variable.
                * [ ] Set literal as the variables value.
                * [ ] Set function call as the variables value.
        * [x] Limit function names, that can be chosen for new function calls.
            * [x] Object access
        * [ ] Automatically adjust arguments of currently changed or created function calls.
            * [x] Add undefined argument elements.
            * [x] Add variable argument menu.
            * [x] Update undefined argument elements.
            * [x] Update variable argument menu.
            * [ ] Implement undefined argument actions. CURRENT
            * [ ] Implement variable argument actions.
        * [x] Make NoCodeSolutionCalculator work with new HTML code as the problem definition.
    * [x] Create fragment rendering for webserver, where document is rendered without any layout.
      -> This is not relevant for now, because it is a minor detail and also provides the advantage of making the help navigable.
    * [x] Make action menu closeable.
    * [x] Implement generic help functionality.
        * [x] Make help pop-up closeable.
        * [x] Do not open multiple help pop-ups.
        * [x] Render help text via iframes for proof of concept.
        * [x] Use fragment rendering to render help text, instead of using iframes, in order to have less visual noise in help text.
          -> This is not relevant for now, because it is a minor detail and also provides the advantage of making the help navigable.
* [x] Clean up visual design of no-code editor.
    * [x] Remove whitespace between span elements via Javascript, in order to remove margins between these. -> Currently, the whitespace actually looks kind of good.
    * [x] Use AST elements as menu buttons directly, instead of create a dedicated menu button for each AST element.
        * [x] net_splitcells_gel_ui_editor_no_code_variable_definition_names_enhance 
        * [x] net_splitcells_gel_ui_editor_no_code_function_calls_enhance
        * [x] net_splitcells_gel_ui_editor_no_code_variable_references_enhance
        * [x] net_splitcells_gel_ui_editor_no_code_variable_access_enhance
        * [x] net_splitcells_gel_ui_editor_no_code_literal_help_show
        * [x] net_splitcells_gel_ui_editor_no_code_literal_set_pop_up
        * [x] net_splitcells_gel_ui_editor_no_code_variable_definition_rename_pop_up
        * [x] net_splitcells_gel_ui_editor_no_code_variable_definition_help_show
        * [x] net_splitcells_gel_ui_editor_no_code_help_via_dynamic_name
    * [x] Consider remove round corners for default actions, as color gradiant seems to be enough, for marking something as an interactable thing. 
      In this case, the gradient probably needs more contrast.
      -> The roundness of all round corners was reduced, which make the round corners less extreme and makes it more natural to use such excessively.
    * [x] When menu is opened, mark the currently selected thing.
      Thereby, it is clear on second look, what object the actions of the menu would act upon.
        * [x] Variable actions
        * [x] Function actions
        * [x] Literal actions
* [x] Make it possible for the user to store a problem definition. -> This is the `Export no-code code.` functionality.
* [ ] Import no-code code.
* [ ] Export no-code code.
* [x] Remove code from `no-code-editor.js`, that is already present in `editor.js`.
  -> For now this is not needed, as
* [ ] Write documentation for all Help actions.
* [ ] In no-code editor, the list of available functions etc. should be queried from webserver and not be coded into the front end.
  This information should be queried directly from `net.splitcells.gel.constraint.Query`,
  in order to avoid to code the same list at multiple locations.
* [ ] Ensure, that user cannot create invalid code.
    * [ ] When a variable is renamed, every reference to it, needs to be renamed as well.
    * [ ] Allow only certain variable names.
* [ ] Visually mark no-code editor as interactable by the user.
    * [ ] Text area styling via inward shadow for no-code editor area
* [ ] Clean up the code of this project.
    * [ ] Move editor specific CSS styling to dedicated css files inside the `gel.ui` project.
  * [x] Clean up `no-code-editor.js`.
* [ ] Closing tasks
    * [ ] Create a general no-code doc like https://splitcells.net/net/splitcells/gel/test/functionality/n-queen-problem.html
    * [ ] Link general doc from no-code editor and Gel introduction doc.
    * [ ] Advertise no-code editor as main editor on live server.
    * [ ] Create no-code editor demo video.