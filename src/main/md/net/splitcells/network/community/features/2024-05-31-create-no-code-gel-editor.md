# Create no-code gel editor.
* Provide a no-code editor for gel,
  in order to ease the documentation of the programming language
  by avoiding or minimizing documentation regarding the language's syntax.
* [\#24](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/24) is the issue.
# Tasks
* [x] Create HTML data mockup.
* [x] Create backend language based on mockup.
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
    * [x] Test parsing of no-code constraints. Currently, it is assumed to be working.
* [x] Process optimization request based on new language.
* [x] Extend language tree in front end with language actions.
    * [x] Create HTML mockup of language actions via Javascript.
    * [x] Delete language actions from GUI, when optimization problem is submitted.
    * [x] Implement language actions as Javascript code.
        * [x] Create help actions.
            * [x] For Function calls
            * [x] For variable references
            * [x] For variable access
            * [x] For literals
        * [x] Rename variable. 
        * [x] Choose different function call.
        * [x] Change function call argument.
        * [x] Remove function call.
        * [x] Remove variable.
        * [x] Set variable value.
            * [x] Literal Value
            * [x] Function call chain.
            * [x] Variable reference.
        * [x] Append function call to function call in chain.
        * [x] Create new top level elements.
            * [x] Create base for that: Adding new things to the current no-code, will be done via new options for available at the menu's of the top level elements. 
            * [x] Add new variable access to top level.
            * [x] Add new variable definition to top level.
                * [x] Setting variable value does not work correctly. The wrapper element is missing in this case.
            * [x] Use [dragula](https://bevacqua.github.io/dragula/) in order to modify order of the top level elements.
        * [x] Limit function names, that can be chosen for new function calls.
            * [x] Object access
        * [x] Automatically adjust arguments of currently changed or created function calls.
            * [x] Add undefined argument elements.
            * [x] Add variable argument menu.
            * [x] Update undefined argument elements.
            * [x] Update variable argument menu.
            * [x] Implement undefined argument actions.
                * [x] Set as function call.
                * [x] Set as literal.
                * [x] Set as variable reference.
            * [x] Implement variable argument actions.
                * [x] Set as function call.
                * [x] Set as literal.
                * [x] Set as variable reference.
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
* [x] Import no-code code.
* [x] Export no-code code.
* [x] Remove code from `no-code-editor.js`, that is already present in `editor.js`.
  -> For now this is not needed, as
* [x] Ensure, that user cannot create invalid code. -> It's currently good enough.
    * [x] When a variable is renamed, every reference to it, needs to be renamed as well.
    * [x] Allow only certain variable names. -> Not needed right now.
* [x] Visually mark no-code editor as interactable by the user.
    * [x] Text area styling via inward shadow for no-code editor area
* [x] Clean up the code of this project.
    * [x] Move editor specific CSS styling to dedicated css files inside the `gel.ui` project.
    * [x] Determine location new AST nodes or pop-ups via empty placeholder spans with the dedicated css class `net-splitcells-no-code-insert-target`,
      that are placed in advance,
      instead of determining the location, when the nodes or pop-ups are created.
      For onclick attributes one can pass `document.getElementsByClassName([...])` etc. as arguments. 
      The main goal is to avoid tree navigation via calls like `element.parentNode.parentNode` and
      to make GUI code simpler.
        * [x] `net_splitcells_gel_ui_editor_no_code_generic_enhance`: add css class `net-splitcells-no-code-update-subject` to currently selected element with menu opened.
        * [x] `net_splitcells_gel_ui_editor_no_code_pop_ups_close`
            * [x] Remove empty spans with `net-splitcells-no-code-insert-target` css class.
            * [x] Remove css class `net-splitcells-no-code-update-subject` from any element. 
        * [x] Use `net-splitcells-no-code-insert-target` for creating or updating an element.
            * [x] `net_splitcells_gel_ui_editor_no_code_var_arg_add_function_call`
            * [x] `net_splitcells_gel_ui_editor_no_code_function_call_append_pop_up`
            * [x] `net_splitcells_gel_ui_editor_no_code_function_call_append`
            * [x] `net_splitcells_gel_ui_editor_no_code_function_call_set`
            * [x] `net_splitcells_gel_ui_editor_no_code_help_via_dynamic_name`
        * [x] Use `net-splitcells-no-code-menu-update-target` for new pop-ups.
            * [x] `net_splitcells_gel_ui_editor_no_code_literal_set_pop_up`
            * [x] `net_splitcells_gel_ui_editor_no_code_variable_references_set_pop_up`
            * [x] `net_splitcells_gel_ui_editor_no_code_variable_definition_rename_pop_up`
            * [x] `net_splitcells_gel_ui_editor_no_code_function_call_set_pop_up`
            * [x] `net_splitcells_gel_ui_editor_no_code_function_call_append_pop_up`
        * [x] Var arg methods should use the same code for adding things as the rest.
            * [x] `net_splitcells_gel_ui_editor_no_code_var_arg_add_function_call`
            * [x] `net_splitcells_gel_ui_editor_no_code_var_arg_add_literal`
            * [x] `net_splitcells_gel_ui_editor_no_code_var_arg_add_variable_reference`
            * [x] `net_splitcells_gel_ui_editor_no_code_var_arg_enhance_help_show`
        * [x] Implement undefined methods. Undefined methods should use the same code for adding things as the rest.
        * [x] Document the new process.
            * [x] `net-splitcells-no-code-insert-target`
            * [x] `net-splitcells-no-code-update-subject`
            * [x] Note that this makes the menu independent of its position and therefore more portable and adaptable.
    * [x] Fix `net_splitcells_gel_ui_editor_no_code_function_call_add_arguments` as it deletes new function calls.
    * [x] Create documentation over overhaul architecture in `no-code-editor.js`.
        * [x] Every function accessing HTML elements relative to each other should be generic code.
          All other code should not have access HTML elements relative in order to keep it simple.
    * [x] Adjust functions and variables names starting with `net_splitcells_gel_ui` inside of `no-code-editor.js`.
    * [x] Add privacy notification.
    * [x] Import editor specific css via XML document and not via global import.
      -> This is not relevant, because this Gel UI's css is a general no-code styling fitting for the webserver.
* [x] Make solution formatting work.
* [x] Test some no-code editor GUI action via Selenium. -> Only new UI functionality will be tested,
  as the rest works for now and in order to safe resources.
    * [x] Move jQuery into `website.content.default`, in order to have simple tests via core repos.
      Add jQuery artifact via the [org.webjars.jquery](https://central.sonatype.com/artifact/org.webjars/jquery) Maven dependency.
        * [x] Remove jQuery from `webiste.content.binaries`.
        * [x] Only import required js files in Gel's UI, so that the tests work. -> This is not needed yet.
        * [x] Add jQuery as a Maven project resource to `website.content.default`,
          in order to have a complete resource list file.
    * [x] Isolate Selenium dependency via simple browser API, that supports simple actions.
        * [x] Make MVP in Gel's UI for no-code editor.
        * [x] Move MVP in Dem, in order to make it generally usable.
            * [x] Decide if Playwright replaces Selenium, as it seems to work better.
              Document the reasoning.
              -> It was decided to use Playwright for now, because Playwright automatically downloads the browser engine,
              that fits to the host, instead of using the hosts browser engine.
            * [x] Remove MVP from Gel's UI and clean up Gel's UI.
            * [x] Make MVP executable inside tests by starting a webserver during the tests.
              Keep in mind, that the browser API needs to know, how to access server.
                * [x] Minimal web server config, that can be used for testing.
                  Use Cell API and WebsiteServerCell for test config.
        * [x] Fix Selenium logging by configuring SLF4J. Currently, a NOP logger is active.
          Therefore, nothing is logged. -> This is not relevant anymore, as Playwright is used instead of Selenium.
        * [x] Try out HtmlUnit as browser in test framework. -> This is not relevant anymore, as Playwright is used instead of Selenium.
            * [x] The problem with that is, that some JavaScript frameworks need to be disabled for this to work.
              -> This is not relevant anymore, as Playwright is used instead of Selenium.
        * [x] Test Firefox if available on Linux
        * [x] Test Chrome if available on Linux -> Will be done, when this gets relevant.
        * [x] If integration tests are active, at least for one browser or HTML/Javascript engine the tests have to be run,
          as otherwise one cannot be sure, that at least the basic GUI logic works.
          -> Playwright does not have such a problem.
    * [x] Test GUI actions.
* [x] Disable integration tests during default build, in order to speed up builds for developers.
* [x] Fix solution formatting. Currently, the solution is not formatted, even so it is configured as such by default.
    * [x] Create a test for formatting parameters.
* [x] Test if constraint parsing is really working.
    * [x] Constraints are not parsed. 
    * [x] Test in general if constraints are parsed at NoCodeProblemParserTest.
    * [x] Test in more detail at NoCodeQueryParser. -> This is not important for now.
* [x] In no-code editor, the list of available functions etc. should be queried from webserver and not be coded into the front end.
  This information should be queried directly from `net.splitcells.gel.constraint.Query`,
  in order to avoid to code the same list at multiple locations.
  -> This is not attempted for now,
  because there are a lot of conditions and cases, that each require a different function list.
  As the no-code editor is not massively used, this feature is too costly and has not enough benefits for now.
* [x] The editor is not uploading the current no-code to the server.
  Instead only, the initial no-code is submitted, even when the user changed the no-code in the editor.
* [x] jQuery is not available at live server.
    * [x] Fix the issue.
    * [x] FileSystemViaClassResourcesImpl should reject file read requests for files, that are not in the resource list.
      In other words. there should be a validation during the read access.
  * [x] Provide performance flag, in order to disable this behaviour and warn, when it is not enabled.
  * [x] Add double-entry bookkeeping to programming guidelines.
  * [x] Create Maven support doc regarding the reason for this bug.
  * [x] Blog about double-entry bookkeeping and IT.
      * [x] Use declarative programming as an example, where this is most important.
      * [x] Use FileSystemViaClassResourcesImpl as an example. -> Make blog article shorter and don't use this example.
* [x] Write documentation for all Help actions.
    * [x] `function-call/attribute.xml`
    * [x] `function-call/database.xml`
    * [x] `function-call/forEach.xml`
    * [x] `function-call/then.xml`
    * [x] `function-call/forAllCombinationsOf.xml`
    * [x] `function-call/minimalDistance.xml`
    * [x] `function-call/hasSize`
    * [x] `function-call/solution`
    * [x] `function-call/columnAttributesForOutputFormat.xml`
    * [x] `function-call/rowAttributesForOutputFormat.xml`
    * [x] `general/literal.xml`
    * [x] `general/undefined.xml`
    * [x] `general/variable-arguments.xml`
    * [x] `general/variable-definition.xml`
    * [x] `general/variable-reference.xml`
    * [x] Create dedicated help document for variable accesses.
    * [x] Provide deletion action for variable accesses.
    * [x] Opening the solution tab does not work anymore.
    * [x] Fix tree styling: http://localhost:8443/net/splitcells/gel/ui/no/code/editor/help/function-call/attribute.html
      -> Nested lists are used instead. Den tree (den-ast) styling is now deprecated in its current form.
        * [o] Create alternative rendering based on existing path context rendering.
        * [o] Deprecate `den.xsl` and find and fix usages, that do not work with the alternative rendering.
        * [o] Remove obsolete and deprecated `den.xsl` code.
* [x] Document why no-code editor was created.
    * [x] No need for syntax documentation for simple functions.
    * [x] Uninformed user can experiment with language and thereby learn it better,
      without having to fix syntax errors.
      Instead by clicking on an element, the program can explain itself,
      what can be done with the clicked thing.
    * [x] No-code is a way to interact with complex things in the software.
* [x] Clean up errors.
    * [o] Exporting definition does not work in mobile for live server. -> This seems to be a Firefox specific error on iphone, which doesn't seem to be the fault of the webserver.
    * [x] Exporting solution does not work in mobile for live server.
    * [X] Renaming a variable, breaks the `Calculate solution.
        * [X] Do not search attribute by its name, but by its variable name, when it is used via variable reference.
            * [x] Correctly pass variables to database creation.
            * [x] Correctly pass and use variables for query parser.
                * [x] Define general variable resolver. - > The variable resolver is the state of the editor. It represents the editor in the backend.
                * [o] Use editor state in code editor as well, as this is needed for the query parser as well there.
                  -> The text editor works differently: variable and attribute name are the same there and therefore this is not a problem there.
        * [x] Fix handling of multipart body downloading of server from client.
          There are currently too many errors.
            * [o] Consider usages of `config.isSingleThreaded()`.
            * [x] `routingContext.response().setChunked(true);` does not seem to cause the problem. -> This was confirmed.
            * [o] Consider using a `MultipartBodyHandler`.
            * [o] Consider using `setMergeFormAttributes`.
            * [o] Simplify webserver.
            * [x] Use handler instead of blockingHandler for the route. -> This fixed the problem.
    * [x] Errors are not sent to client. -> These were caused by OutOfMemoryError exception, because of lexer tokens rules, that match a zero length string.
    * [x] No-code editor does not work currently on live server. -> Updating (with the fixes of `Clean up errors.`) and redeploying the software solved this issue.
    * [x] Test all no-code editor functions again by hand. -> Only some functions were tested. Fine-tuning will be done in `2024-08-06-make-no-code-editor-viable.md`.
* [ ] Closing tasks
    * [x] For both editors link to assignment and constraint model explanation.
    * [o] Create a general no-code editor doc like https://splitcells.net/net/splitcells/gel/test/functionality/n-queen-problem.html
    * [x] Create a general code editor doc, which mainly says, that everything works like no-code editor except with a slightly different syntax.
      -> Both editors state, that they work like each other.
    * [x] Link general doc from no-code editor and Gel introduction doc.
    * [x] Add no-code editor as main program on the live server's front menu. 
    * [ ] Write final evaluation.
        * [x] The no-code editor works, but is not ready for real world use.
        * [x] No-code seems to have limited alternative capabilities for logical code compared to normal code.
        * [o] No-code is only partially an alternative to language documentation. -> This kind of seems not to be true.
        * [x] No-code has a potential as a base framework for generally stateful things like configuration and forms etc.,
          which is already known in real world. See games, website and document editors.
          No-code basically is more in the direction of a WYSIWYG.
        * [ ] ***CURRENT*** Mark article as done via file path.
    * [ ] Create no-code editor demo video.
    * [x] Advertise code editor as the tough love edition.
# Ideas
* [ ] Create optimization platform, where users can persist and work on problems, solutions and data.
    * [ ] Do this task, when the issue ["Solve school course scheduling problem"](2021-03-07-solve-school-course-scheduling-problem.md) is being worked on,
      as it seems to be a fitting feature for that issue.
    * [ ] Expand reformatted solution output. 
    * [ ] Add argumentation via pop-up to reformatted solution output: https://tabulator.info/docs/6.2/menu#cell-context 
    * [ ] Color cells based on their ratings: https://tabulator.info/docs/6.2/format
    * [ ] Output parsed constraint tree in editors, in order to be able to double-check the results, of defining the constraints.
* [ ] Consider using own table implementation for front end, in order to be able to annotate data to table.
  Argumentation data would be such an example, where data is only marked with table cell background color and
  made visible by a click of the user on the respective cell.