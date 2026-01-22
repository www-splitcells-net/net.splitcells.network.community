# Solve sport lesson assignment
* Issue number: [\#37](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/37)
# Task Description
Exemplary solve the sport lesson assignment problem from Martins Avots's master thesis,
in order to extend the programs modelling, optimization capabilities and usability.

Thereby make the project usable as a service by multiple users at once.
A platform supporting many different optimization problems out of hand seems to be crippled,
if the service can only be used by one user at once.
Furthermore, in order to prepare the webserver for ["Solve school course scheduling problem"](2021-03-07-solve-school-course-scheduling-problem.md),
basic support for authentication and authorization is to be added to the server.
For testing purposes the authentication and authorization system is used,
to only provide server CPU and RAM usage in real time to the administrator of the server.
# Tasks
* [ ] Create test data.
    * [ ] Create unit test for test data.
* [ ] Check and correct the problem definition
    * [ ] `. then(hasMinimumSize(1))` is not correct, as it can never be triggered by definition.
        * [ ] Disallow hasMinimumSize with an argument < 2 in general.
    * [ ] Create constraint for isSecondaryChoice. 
* [ ] Support complex problems with the default optimization.
    * [ ] Move default optimization to the editor itself.
    * [ ] Extend default optimization method.
* [ ] Solve sport lesson assignment.
* [ ] Make it easier to understand the solution.
    * [ ] Add comments via optimizers to allocations, so that the user knows why a certain allocation was created by the optimizer. Consider adding this to the history table or as meta column to the solution table. 
    * [ ] Store and show positive reason, why a certain supply has not a cost.
      In other words, show all longest constraint paths, where the respective allocation was propagated to a then constraint node.
    * [ ] Color allocations according to their respective ratings.
* [ ] Allow users to define a partial solution, that is the basis for the given problem.
  The optimizer is not allowed to change the allocations given by the user.
* [ ] Note overhaul changes in changelog.
* [ ] Delete old Gel editor domain language.
* [ ] Deprecate Sep project.
    * [ ] Move Sep code into editor project.
    * [ ] Migrate sep usage to editor.
    * [ ] Remove Sep code.
* [ ] Note in doc, that the code editor does not work great on mobile and that the no-code editor was great there.
  If mobile support becomes required, then an additional no-code editor might be worth it.
    * [ ] It seems, that codemirror 6 has better mobile view.
    * [ ] A no-code editor would be interesting for something interactive like crisis network (Cin),
      where a program also represents a GUI for interacting with the world.
* [ ] Note that initial no-code editor was a feature creep.
* [ ] Use monospace fonts, in order to have consistent nice formatting in the code editor's default example.
  Currently, some span styles are overwritten by the `basic.css`.
    * [ ] Try adjusting this via a CodeMirror config: https://discuss.codemirror.net/t/changing-the-font-size-of-cm6/2935/5
* [ ] Test EditorProcessor via none integration test, that uses less infrastructure.
* [ ] Preserver no-code editor UI code,
  as this may actually be useful in the future for interactive problems or as a general programming language based form UI.
* [ ] Consolidate `net.splitcells.gel.editor.lang`.
* [ ] User session management has to be done via `Dem#config` which also basically deprecates AccessControl.
* [ ] Improve news feed of live server.
* [ ] Create help command in editor, in order to access function call doc without closing the current editor and thereby loosing its content.
* [ ] Move ColloquiumPlanningTest of `net.splitcells.gel.ext` to editor project.
    * [ ] Used editor for testing. 
    * [ ] Use Geal code for testing.
* [ ] Ensure that all constraint types and raters are usable in the Geal.
    * [ ] Decide and note on relationship between Query and Editor.
* [ ] Add background box to section titles in menu.
* [ ] Improve styling of news.
* [ ] Consider making distinction between hard and soft constraints.
* [ ] Add link to editor at `Introduction to the Generic Allocator`.
* [ ] Delete data fields, that do not exist anymore, because i.e. the argument of a importCsvData call was changed.
* [ ] Add to `Constraint Rating Report` the info, if the solution is complete or not.
# Done Tasks
* [x] Establish modifier syntax.
    * [x] Extend grammar for simple modifiers.
    * [x] In modifier chains avoid brackets for the innermost function call arguments.
    * [x] Remove bracketless arguments and explain the removal.
    * [x] Support and test this new syntax via the runners.
        * [x] Test the grammar with the same example of https://live.splitcells.net/net/splitcells/gel/editor/geal/index.html
          Inline the example in the document via a link to a resource and not via inlining the example in the document.
          This way a grammar test can exactly test the same example.
        * [x] Function call
        * [x] Integer
        * [x] String
        * [x] Support bracketless arguments for modifier chains, if the last function call has exactly one argument.
    * [x] Adjust examples to new modifier syntax.
    * [x] Document new syntax in grammar doc.
* [x] Make sport lesson assignment an additional GUI editor example.
    * [x] Make it easy to try out colloquium and sport planning example by creating an example select menu in the editor.
        * [x] Generate problem specific buttons only via client side Javascript code and do not use XSL anymore for that.
            * [x] Place field buttons before example sub menu.
            * [x] Create `*.csv` buttons via Javascript and not XSL.
            * [x] Renaming the argument of `importCsvData('[...]')` breaks the editor at the backend.
        * [x] Add button for sport course example loading.
            * [x] Transform linear vertical menu to a vertical tree menu.
            * [x] Delete all fields.
            * [x] Delete all field buttons.
            * [x] Request example problem.
            * [x] Rename `net-splitcells-websiter-server-form-update` to `net-splitcells-website-server-form-update`.
            * [x] Load example data.
                * [x] Defining editor update messages.
                    * [o] Create a new base table API for Dem, in order to provide a way to conveniently use data oriented programming.
                      -> The new base table API is not required yet.
                * [x] Providing examples via update messages. -> See ColloquiumExample.
                    * [x] Create and use a form update domain object, in order to simplify code and make it more statically type safe. -> FormUpdate
                * [x] Implement this for colloquium example.
                * [x] Implement this for sport course example.
                * [x] Move EditorProcessor form update constants to FormUpdate of the website server.
        * [x] Add button for colloquium planning example.
        * [x] Generate problem specific form fields via client side Javascript instead of XSL as well.
        * [x] Create sub menu for the problem fields.
        * [x] Add additional button for the definition field at the top level of the menu.
    * [x] Load test data for both examples.
        * [x] ColloquiumExample
        * [x] SportCourseExample
        * [x] Select CSV data fields, does not color these like the other buttons.
    * [x] Load initial editor data like it is done for the example's menu.
        * [x] Remove ColloquiumPlanningSuppliesTestData.
        * [x] Remove ColloquiumPlanningDemandsTestData.
    * [x] Initialize all editor data fields. Currently, an initial `Calculate solution` is required for all fields to be visible in the GUI.
* [x] Create sport lesson assignment model.
    * [x] Create SportsCoursePlanningTest.
        * [x] Create not rater.
        * [x] Add not rater to editor.
        * [x] Add equals rater.
    * [o] Ensure that Editor and Query provides the same constraint types. -> This is not required.
    * [o] Ensure that Editor and Query provides the same raters. -> This is not required.
    * [x] Rename forAllCombinationsOf to forEach, as it has no advantages to have different names for such similar functions.
    * [o] `forEach(not(equals(assignedSport, 'Dummy Course')))` should work with the Query's constraint visiting functionality and
      thereby avoid creating a new constraint node for every `forEach(not(equals(assignedSport, 'Dummy Course')))`.
      -> Performance in this regard is not relevant for now.
* [o] Calculate solution, when the editor is opened, so that the example tables are loaded.
  This action makes the editor feel more interactive to new visitors and also makes the example fully loaded.
  -> That's probably a bad idea, as it creates a lot of resource usage and it also blocks some further user action.
* [x] Remove old code editor. Do not forget its Javascript code.
* [x] Create and use async loaded background image for website, in order to signal a higher quality to the user.
  -> The high quality is small enough, so that async loading is not required.
* [x] Make testRatingReport complete.
* [x] Document code editor.
    * [x] Parse function calls and generate function documentation via FunctionCallRecording.
        * [x] Use FunctionCallRecording.
            * [x] AttributeCallRunner
            * [x] ForAllCombsCallRunner
            * [x] ForEachCallRunner
            * [x] HasMinimalDistanceOfCallRunner
            * [x] HasSizeCallRunner
            * [x] ImportCsvDataRunner
            * [x] OutputFormatCallRunner
            * [x] ResolutionRunner
            * [x] SolutionCallRunner
            * [x] TableCallRunner
            * [x] ThenCallRunner
        * [x] Generate documentation via FunctionCallRecording and EditorFunctionCalls.
            * [x] Add the processed functionCall to the FunctionCallRecord, so it's easier to generate the documentation.
            * [x] Created dedicated FunctionCallRecord parsers.
              This enables one to generate a function call documentation without an example
              , which avoids one to write dedicated code to generate its documentation (which can be forgotten)
              , when a new function call is defined.
            * [x] Generate documentation via FunctionCallDoc.
                * [x] functionCallRunnerParser have to know their variation id.
                * [x] Improve ordering of factory arguments. -> The lambda is now the last argument, which is easier to read.
                * [x] Implement FunctionCallRecord's recording method.
                    * [x] requireArgumentCount
                    * [x] requireArgumentMinimalCount
                    * [x] parseArgumentAsType
                    * [x] parseArgumentAsType
                    * [x] parseArgumentAsStringDesc
                    * [x] failBecauseOfInvalidType
                    * [x] parseQuerySubject
                    * [x] parseSubject
                    * [x] parseAttributeArguments
                    * [x] parseAttributeArguments
                    * [x] parseAttributeArgument
                    * [x] parseAttributeArgument
                    * [x] parseArgument
                    * [x] requireSubjectAbsence
            * [x] Render documentation on website server.
            * [x] Make documentation rendering nice.
                * [x] Primarily sort function calls by name.
                * [x] Secondary sort function calls by variation id.
                * [x] Better structure parameter properties.
                * [x] Better style parameter properties.
                    * [x] Rename subject to receiver, as this is the commonly known terminology of OOP.
                    * [x] Do not show variation id, if there is only one variation.
                    * [x] Use word parameter, where argument does not fit.
                    * [x] Rename `Parameter Rules` to `Receiver Constraints`.
                    * [x] Move exact argument comment to parameter list.
                    * [x] Improve list name styling by using a dedicated div for the name.
        * [x] Render description.
        * [x] Make styling of subchapter more distinct to the styling of the main chapters.
        * [x] Add comments to arguments and function documentation.
            * [x] AttributeCallRunner
            * [x] ForAllCombsCallRunner
            * [x] ForEachCallRunner
            * [x] HasMinimalDistanceOfCallRunner
            * [x] HasSizeCallRunner
            * [x] ImportCsvDataRunner
            * [x] OutputFormatCallRunner
            * [x] SolutionCallRunner
            * [x] TableCallRunner
            * [x] ThenCallRunner
        * [x] Define parameter name.
        * [x] Render parameter name.
    * [x] Create simple exemplary source code.
        * [x] 1 for grammar
        * [x] 1 for Optimization Problem Definition
    * [o] Add exemplary source code to function call doc.
      -> The Geal introduction gets the exemplary source code and the intro just links to the function call doc.
    * [x] New approach to error handling. -> The new NeedsCheck API is already documented.
    * [x] Create function call doc introduction.
        * [x] State, that the goal of the source code is to define solution tables for the optimizer.
    * [x] Integrate documentation into the editor.
* [x] The constraint requiring days between colloquium tests is missing.
* [x] Consider making NameDesc a FunctionCallDesc with only one argument, which simplifies the grammar and its parsing.
* [x] Support complex problem definitions via editor, that are composed of multiple ones,
  so that the sport lesson assignment can be defined in the editor.
    * [x] Create a name for the language and document it. -> It's named Geal.
    * [x] Extend Gel language, in order to model optimization problems consisting of multiple optimization problems.
        * [x] Define new grammar.
            * [x] Do not avoid dot for function call chains, in order to make it possible to consistently format code.
            * [x] Do not allow empty round braces for function calls.
            * [x] Create public Grammar documentation file. This will be later completed, when the editor is finalized
              and thereby the standard library is known.
        * [x] Use a domain object based parser and editor as backend for editor and no-code editor, in order to simplify parsing. In other words, create an editor backend, that is shared by the code and no-code editor frontend.
            * [x] Create dedicated Gel editor project, that replaces the Sep project.
                * [x] Create Gel editor project.
                * [x] Create new domain language in order to simplify it, as the first 1 has too much complexity without any benefits.
                    * [x] Create domain objects.
                    * [x] Create parser and integrate into editor.
                        * [x] Test pure AST interpretation by example.
                            * [x] Actually parse constraints.
                                * [x] Implement recursion.
                                * [x] Ensure, that constraint call recursion's last element returns the subject and not the first one,
                                  as this makes more sense.
                                    * [o] Make constraint variable definition correct to this correct way of piping function call chain results. -> No constraint variables are used anymore.
                                    * [x] Apply constraints to solutions by function call chains directly starting at the solution variable,
                                      instead of using a dedicated constraint function and variable.
                                        * [x] Use the query interface.
                                        * [x] Make FunctionCallMetaExecutor less mutable and use FunctionCallRunner constructor functions.
                                        * [x] Make `FunctionCallRunner#execute` not require additional function calls, as otherwise it can hard to understand, what is required for `FunctionCallRunner#execute`.
                                    * [x] Avoid `BaseCallRunnerParser#support` by implementing the `BaseCallRunnerParser#execute` just like other execute methods for runners.
                                        * [x] Migrate every BaseCallRunnerParser to FunctionCallExecutor.
                                        * [x] Delete BaseCallRunner.
                                    * [x] Make function call arguments function call chains, in order to support everything as a function argument.
                                    * [x] Delete `constraint` function.
                                * [x] Ensure, that the runners' subject is set correctly.
                            * [x] Make duplicate variable check complete.
                            * [x] Remove code duplicate in central parser.
                        * [x] Test AST parsing and AST interpretation by example. CURRENT
                          -> Test this at `EditorTest#testGealParsing`.
                            * [x] Remove concept of name expressions, as it is already covered by function calls without arguments and the parser is already mixing up these two.
                              The distinction has currently no practical use and introducing names later on will probably be easier,
                              than to remove these, if names turn out to be a dead end (which it already seems).
                            * [x] Reenable tests.
                * [x] Deprecate existing language.
                * [x] Port SolutionEditor to the new Editor.
            * [x] Remove direct dependency to ANTLR4 at parser and any other code.
                * [x] Use list based FunctionCallChainDescription for constraint definitions, instead of creating a special case for constraints.
            * [o] Consider moving parsing code to dedicated project, in order to isolate ANTLR4 and grammar dependencies. -> Isolation via Java Legacy class should be enough.
            * [x] Allow using sum types in this project's Java subset, in order to provide access to a set of values, where only one of them at one time is actually set. Use this only for that.
                * [x] Extend ANTLR grammar.
                * [o] Comment the reason for allowing sum types.
            * [o] Delete `net.splitcells.gel.ui.Editor`. -> This class is migrated instead.
            * [x] Use unified namespace for attribute names across SolutionEditors, in order to simplify user input.
            * [x] Create input data interface for editor.
            * [x] Create new UI for code editor.
                * [x] Do not use QueryMode. Use one method in order to do most things in the editor like calculating the solution or opening tabs for all data in the problem definition.
                * [x] Determine data inputs for user by submitting the editor's form.
                  The server answers with the new form's input values.
                  Some of the inputs represent the new form's fields, that need to be added to the form.
                    * [x] The server responses to the editor form's submission with all editor's data entries as new input fields.
                    * [x] net_splitcells_webserver_form_submit adds the new fields to the frontend's editor form.
                * [x] Show problem definition.
                * [x] Show all tables.
                * [x] Show all solutions.
                * [x] Determine and show  all input and output fields.
                    * [x] Input and output field are not transferred from client to server. It does not seem to work correctly.
                        * [x] Correctly, fill up input text areas.
                        * [x] Enable input text area adaption via CodeMirror.
                    * [x] Show all inputs and outputs in editor based on a field to content type mapping, that is returned by the server for an optimization requests in the GUI.
                        * [x] Remove new `.csv` fields. -> This is just a consequence, that the default example contains a CSV import. This is OK.
                        * [x] Add content type mapping to response.
                        * [x] Interpret content type mapping in browser.
                        * [x] Support table fields and not just text fields.
                        * [x] Initialize empty CSV import files.
                    * [x] Show all tables and solutions as interactive HTML tables.
                    * [x] Ensure, that data inputs are not deleted after calculation a solution.
                    * [x] Add tab buttons in the page menu, so that these are fitting more compactly on screen,
                      as there these are arranged vertically.
                        * [x] Align button text to the left.
                        * [x] Align dynamically created button text to the left.
                        * [x] Add definition button by default.
                        * [x] Color definition button, when it is selected.
                        * [x] Correctly color definition button, when CSV tabs are selected.
                        * [x] Correctly color definition button, when editor is initialized.
                        * [x] Is an ID needed for every input field in `sew.xsd`?
                          Can name and id be consolidated?
                          -> Yes, it can, because for every input field an ID can be generated by concatenating the form id and the input field's name.
                            * [x] Make net_splitcells_webserver_form_tab_select work with tab content id created by form id + input id + `tab-content`.
                            * [x] Use form id + input name in order to select and manipulate form data.
                                * [x] Adjust initial tab content.
                                * [x] Adjust initial tab buttons.
                                * [x] Adjust dynamic tab content.
                                * [x] Adjust dynamic tab buttons.
                                * [x] Adjust net_splitcells_webserver_form_tab_select.
                                * [x] Adjust net_splitcells_webserver_form_submit.
                                    * [x] Ensure that all tables are visible.
                                        * [x] Make all tables based on text/csv by default.
                                        * [x] Provide rendering type data by server to client.
                                        * [x] Use rendering type data to determine the type of rendering on client.
                                        * [x] Show data of new tables. Currently, the data of dynamically created tables like the solution is empty.
                                    * [x] Ensure, that newly created form inputs are correctly sent the next time to the server.
                                        * [x] When the CSV data is changed on client, the demands and supplies table are empty after form submission.
                                * [x] Adjust `component.standard.xsl` by inlining the input field templates.
                                    * [x] content
                                    * [x] buttons
                                    * [x] Simplify tab content Javascript in HTML by moving this to a dedicated Javascript file.
                                * [x] Adjust `component.editor.xsl`.
                            * [x] New inputs after submissions are sometimes empty.
                            * [x] Do not use text-area ID in XSL.
                            * [x] Correctly create dynamic buttons.
                            * [x] Mark initial main tab button as select at start.
                            * [o] Tab buttons should select content by ID and not CSS,
                              as there can be only element per tab content. -> There could be multiple representations of a form input.
                              This is already the case, when one considers blank textareas and their respective editors as distinct representations.
                    * [x] Remove old horizontal tab buttons.
                    * [x] Implement optimization for colloquium planning example.
            * [x] Implement solution formating.
            * [x] Implement proper user friendly error handling.
                * [x] Create central error handling guidelines or documentation via central interface, that handles everything error.
                    * [x] Consider always requiring a user.
                      -> Yes, there should be always a user stored via a Dem config as this disallows arbitrary user switching in code.
                      Furthermore, most code does not require any authentication context, but may be used in an authentication context.
                      See file system for example.
                      It is not acceptable, for every code to explicitly pass an authentication context,
                      even though it is not required most of the time.
                      This needs to be documented.
                    * [x] Just support try catch of user errors for now, as this will be enough for a long time.
                * [o] Use user session in dem, in order to store all errors. -> Try and catch will be used instead.
                * [x] Use multiple types of messages like errors and warnings. -> We are using LogLevels for that.
                * [o] Define the subject of errors. -> This will be done implicitly via the content of the error message and its stack trace instead.
                * [o] Handle this like logging, but with a special address. -> Try and catch will be used instead.
                * [x] Document why explicit error message handling is bad. -> This is done via describing the goal of the need API.
                * [x] Create new CommonMark field for errors.
                    * [x] Render all messages of need exceptions
                    * [x] Render all stack traces at the end of the errors field.
                    * [x] Render all none need exceptions at the end of the errors field.
                      This is needed, as support will be harder.
                        * [x] Create a generic implicit error handler for any kind of error report system. -> The Needs Check API does the job.
                        * [o] ExecException -> Can be handled via code processing Throwables.
                        * [x] Throwable
                    * [x] Create error title.
                    * [x] Only concat multiple CommonMark documents with a specialized method,
                      in order to ensure proper line endings.
                    * [x] Avoid empty lines between list elements in CommonMark.
                    * [x] Correct lines before and after a heading.
                * [x] Go through all UI code, check everything and create user-friendly errors.
                    * [x] `EditorProcessor#process`
                    * [x] `Editor#interpret`
                        * [x] `public Editor interpret(SourceUnit sourceUnit)`
                        * [x] `SourceUnitParser`
                            * [x] `GealAntlrUtils`
                            * [x] ExpressionParser
                            * [x] FunctionCallChainParser
                            * [x] FunctionCallParser
                            * [x] StatementParser
                            * [x] VariableDefinitionParser
                    * [x] Runners
                        * [x] AttributeCallRunner
                        * [x] ForAllCombsCallRunner
                        * [x] ForEachCallRunner
                        * [x] FunctionCallExecutor
                        * [x] FunctionCallMetaExecutor
                        * [x] FunctionCallRun
                        * [x] FunctionCallRunner
                        * [x] HasSizeCallRunner
                        * [x] ImportCsvDataRunner
                        * [x] OutputFormatCallRunner
                        * [x] SolutionCallRunner
                        * [x] TableCallRunner
                        * [x] ThenCallRunner
                        * [x] VariableResolutionRunner
                    * [x] `Editor#*`
                        * [o] Create need version of lookupTableLikeName, in order to know what is causing the lookup.
                          -> Making the return type an Optional makes it easier to handle errors.
                        * [x] `Editor#resolve`
                    * [x] Do not render error messages as XML, because the error field contains a CommonMark document and not an XML document.
                      -> Do not use ExecutionException and return a TreesException for `ExecutionException#executionException(Tree)`
                      and migrate this static constructor to TreesException class.
                        * [x] Deprecate and remove TreesException in favor of ExecutionException.
                          For this ExecutionException needs to provide tree based error messages.
                          For compatibility reasons, if no tree message was provided for the ExecutionExceptions construction,
                          provide a tree based on the string based message.
                    * [x] Source code quotations are not rendered as well in the error messages.
                    * [x] Prevent variables with names, that can already be resolved.
                      See solution for example. -> It is enough, when new variables are shadowing every function of the standard library with the same name and no parameters.
                    * [x] Runners should never resolve variables manually, but use the functionCallMetaExecutor instead.
                      Otherwise, the argument parsing of function call is not fully implemented.
                        * [x] AttributeCallRunner
                        * [x] ForAllCombsCallRunner
                        * [x] ForEachCallRunner
                        * [x] FunctionCallExecutor
                        * [x] FunctionCallMetaExecutor
                        * [x] FunctionCallRun
                        * [x] FunctionCallRunner
                        * [x] HasSizeCallRunner
                        * [x] ImportCsvDataRunner
                        * [x] OutputFormatCallRunner
                        * [x] SolutionCallRunner
                        * [x] TableCallRunner
                        * [x] ThenCallRunner
                        * [x] VariableResolutionRunner
                * [x] Support problem definitions without a solution. -> This is already supported.
            * [x] Render rating as a CommonMark field.
                * [x] Create a CommonMark template, that provides a chapter for the rating.
                * [x] Use `Rating#descriptionForUser` as the chapter's content.
            * [x] Render argumentation as part of the rating CommonMark field.
                * [x] Create a CommonMark template, that provides a chapter for the rating.
                * [x] Use `Constraint#naturalArgumentation` as the chapter's content.
                * [X] The tree provided by `Constraint#naturalArgumentation` needs to be simplified.
                  Create a test for that, as testing manually takes too much time.
                * [x] Add causing values to argumentation. -> This was done for the ForAll raters. For that the rest it will be done, when need and for some it is already present.
                * [x] Drop the special GEL name space, as it has no actual use and makes things more complex.
                  Keep in mind natural argumentation is not about creating an argumentation schema, also it would be possible.
                  Natural argumentation is flowing text for user, but nothing else except for Internationalization and there is not even an attempt to support that yet.
                * [x] Re-enable `Constraint#testArgumentation`, when the `Constraint#naturalArgumentation` is simplified.
            * [x] Render argumentation as part of the solution table.
            * [x] Check for duplicate attributes in tables and solutions.
    * [o] Make first char of vertical tab button upper case in the GUI. -> This does not make for variables, as this would make them incorrect.
    * [x] Delete obsolete SolutionEditor and the corresponding users.
        * [x] Delete `Query#constraintResult`.
        * [x] Delete `Query#parseConstraint`.
    * [x] Add Geal editor to main page of live server.
* [x] Improve user experience regarding the application's responsiveness, by supporting multiple web server users at once.
    * [x] Implement basic multi threading injection framework.
        * [x] Note, that multi threading is achieved while avoiding amount of thread safe code.
          Therefore, multiple instances of ProjectsRendererI are used,
          even though most of that code is probably thread safe.
          Code that is thread safe, because everything is read only is fine though.
    * [x] [Make webserver thread safe](./2024-08-27-make-copies-of-the-webserver-thread-safe.md), in order to support multiple users at once on public server.
    * [x] Document, that one of the goals of the threading injection framework,
      is to minimize the amount of code written specifically for multi-threading.
    * [x] Support multiple users at once via multi threading injection.
    * [o] Ensure, that logs are working in threads, too.
      Currently, it does not seem to be the case and therefore `Throwable#printStackTrace()` is used as a workaround. -> This cannot be replicated anymore.
    * [x] Use multiple threads for calculation of the ratings via the constraint nodes.
      -> The performance get worse with constraint multithreading.
    * [o] Use dedicated workers for lookup tables. -> This is not relevant to this issue.
    * [x] Continuously and automatically run test user in live distro, in order to test if server can endure many optimization runs.
        * [x] Determine web address via Dem config and not via a constant. -> This is already available via ServerConfig.
        * [x] Use dynamic web address determination at HtmlClientImpl, too.
        * [x] Create general live tester, where testers are registered in Dem.
          The tester should be disabled by default and is intended for stress testing the server.
        * [x] Create optimization test.
            * [x] Make playwright work on server.
            * [x] Execute optimization test via playwright.
                * [x] The browser cannot connect to server.
                  This seems to be a firewall/network issue, as `apt install netutils-ping && ping splitcells.net` does not work as well in the container.
                  This ping works outside the container and on the server.
                  So, this is a podman issue.
                    * [x] The problem is the same as https://github.com/containers/podman/discussions/22778
                    * [x] The problem can be tested in the shell of the container via `curl live.splitcells.net`.
                * [x] `Xml#parse` has a race condition.
        * [x] Execute exactly 1 test at any given time. Provide option to execute exactly n tests at any given time.
          -> Now the number of simultaneously executed tests is half the CPU cores.
        * [x] Assign more RAM to container. -> Podman's container already get all available RAM.
        * [x] Move live test to optional system settings, in order to make live tests an optional standard functionality, that is easy to set up initially.
        * [x] Abort live server build with error, if Podman execution aborts with an error.
        * [x] Log all Service starts generically.
    * [x] Check CPU and RAM usage.
* [x] Add first administrative GUI in webserver.
    * [x] Create blocked page.
    * [x] Authenticate
    * [x] Authorize
    * [x] Persist authentication info of the users.
    * [x] Authorize based on persisted authorization data of the users.
        * [x] Simplify config file structure and make more consistent.
            * [x] Place ACME files inside config folder. -> This was already the case. There were just some old files on the server, that created the impressions, that ACME files were stored inconsistently.
            * [x] Each user should have a password file. The user file should not contain the password, but be a folder, so that additional attributes can be placed there.
        * [x] Make file structure more consistent. Currently, some files are place in the top level. -> These were just some stray files on the live server.
        * [x] Read user from vertx.
            * [x] Ensure, that every handled user is created by the main Authentication. -> The solution calculators are ignored regarding this for now.
                * [x] Implement Vertx independent Authenticator.
                * [x] Test Vertx independent Authenticator.
                * [x] Use independent Authenticator in Vertx and the UserSession to the user attributes map of Vertx.
                * [x] Strongly limit allowed symbols username and password severely.
                  -> Only the username was limited for now, as an urgent need for limiting the user's password is not know.
            * [x] Ensure, that every user object is created with proper user input. Do not look up user objects just by names.
              Ensure that proper authentication was provided by the user.
            * [x] Convert user object to user session object.
            * [x] Provide a RAII based cycle for user sessions.
              An access control object can ensure this, by providing a method, that takes a login and user session consumer,
              in order to execute a piece of code with login specified user session.
            * [x] use RAII based user session life cycle for server.
            * [x] Limit the amount of parallel user session, in order to detect life cycle problems of user sessions.
              -> Document this as a task, at the access control object source code.
        * [x] Read roles of user from config.
        * [x] Create base class for all currently present authenticators,
          in order to have standardized runtime checks for authenticators
    * [x] Do not render administrator documents on static rendering or render administrator pages with the lowest privilege.
        * [x] Renderers have to support a rights concept.
        * [o] View log files in website only for administrator. -> Viewing logs via web UI is not required for now.
    * [x] Create default user profile page, were the user sees links to user specific pages.
      May do this, by showing all paths, that only a specific user has access to?
    * [x] Provide access to CPU and RAM utilization, if the user session has the appropriate role for that.
    * [o] CPU utilization is not visible in the layout anymore.
      The reason for that is, that ProjectsRendererExtension do not support project paths listening via a user session.
      -> It is enough, that this page is visible in the users profile.
        * [o] Extend interface.
        * [o] Add implementation for CPU utilization extension.
    * [o] Fix styling for `You do not have the rights to access this page.` page. -> It is good enough for now.
    * [x] Document this in the web server's changelog.
    * [o] Create login page. -> The browser's default login page is enough for now.
    * [o] Link to login page from `You do not have the rights to access this page.` page. -> The browser's default login prompt is enough for now.
    * [x] The following extensions needed appropriate protection as well.
        * [x] `net.splitcells.website.server.projects.extension.impls.TestExtension`
        * [x] `net.splitcells.website.server.projects.extension.status.HostMemoryUtilizationExtension`
        * [x] Enable and secure `net.splitcells.website.server.projects.extension.impls.DemConfigExtension`, which is currently disabled.
    * [o] Create picture depicting an architectural overview of the security system.
      -> The authentication, authorization and access control API seems to be good enough.
    * [x] Deploy this feature to production.
* [o] Blog why the Cin project is now a low priority feature project.
* [o] Complete the issue ["Create no-code gel editor"](../2024-05-31-create-no-code-gel-editor.md) first. -> The no-code editor is obsolete and deleted.
# Future Ideas
* [ ] Support LSP in editor via [Eclipse LSP4J](https://github.com/eclipse-lsp4j/lsp4j), [LSPs](https://github.com/qualified/lsps) and CodeMirror.