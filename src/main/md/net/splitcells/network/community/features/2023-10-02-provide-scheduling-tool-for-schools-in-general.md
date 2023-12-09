# Provide scheduling tool for schools in general.
* Goal: The goal is to provide a minimum viable product, that demonstrates,
     how such a tool would look and work like.
* Ticket: https://github.com/www-splitcells-net/net.splitcells.network/issues/252
## Tasks
* [x] Provide runnable application with GUI.
    * [x] Place MathJax files into dedicated repo, because it is too big.
    * [x] https://github.com/www-splitcells-net/net.splitcells.network/issues/249
    * [x] https://github.com/www-splitcells-net/net.splitcells.network/issues/199
    * [x] Clean up all links via `renderingValidator` of the `ProjectsRendererI`. -> The result is good enough for now.
    * [x] Provide function to execute tests via the GUI.
    * [x] Provide page listing all commands.
        * [x] Register all commands. -> This is done via an index page manually for now.
    * [x] Add `NOTICE.md` etc. files to website.
    * [x] Provide closeable GUI window via [flatlaf](https://www.formdev.com/flatlaf/).
* [x] Provide distro builds.
    * [x] Create Windows executable via launch4j. -> Use an Eclipse RCP application instead.
        * [x] Sign resulting Windows exe. -> Not relevant anymore.
    * [x] Use Eclipse RCP instead
        * [x] Document reasons for using Eclipse RCP:
            * [x] trustable and unbranded signed executable.
            * [x] Can bundle JRE via build and provide an application with all required dependencies.
            * [x] Provides builds for different OSs
            * [x] Has a fitting license
            * [x] Alternatives have a lot lower download rate and launch4j-
        * [x] Provide help text with a short description and license info reference. -> Locally hosted website in application window is enough for that right now.
        * [x] Provide splash screen with loading info. -> This is not important for now. 
        * [x] Correctly manage lifetime of backend program.
        * [x] Bundle application with an JRE.
            * [x] Fix the fact, that new dependencies are not downlaoded from sites in target platform, and
                therefore not found.
                * [x] Maybe caused by the fact, that the new dependency is not attempted to downloaded at all. -> This isnot the case.
                    * [x] Maybe this dependency needs to be donwloaded via a custom feature module. -> This is not the case.
                * [x] Maybe the incorrect plugin or feature id is used. -> This is not the case.
                * [x] Incorrect target platform is used, because the incorrect id was used. This error was found, by deleting the local `.m2` repo.
        * [x] Document Eclipse RCP in license notice.
        * [x] Bundle server with application.
        * [x] Provide application icon.
    * [x] Support Flatpak via jreleaser.
        * -> Do this only, when there are normal releases for the software.
        * -> This will be done via the following issue: https://github.com/www-splitcells-net/net.splitcells.network/issues/195
        * [x] https://docs.flathub.org/docs/for-app-authors/requirements/
* [x] Provide generic editor.
    * [x] Provide front menu, that present main application.
        * [x] Create config to define menu items.
        * [x] Render front menu.
            * [x] Title 
            * [x] Image
            * [x] Link
            * [x] Description
        * [x] Define default front page.
        * [x] Reset front page for personal site.
        * [x] Create dedicated UI project for Gel.
        * [x] Add front menu item for editor.
    * [x] Provide editor to define constraints.
        * [x] Create grammar.
            * [x] Define demand attributes
            * [x] Define supply attributes
            * [x] Define constraints.
        * [x] Parse problem definition.
            * [x] Parse demand attributes.
            * [x] Parse supply attributes.
            * [x] Parse constraints' root.
            * [x] Parse complete constraint definition.
            * [x] Make grammar an abstract perspective grammar, in order to use this as the basis for perspective framework.
            * [x] Parse multiple constraint paths.
        * [x] Upload data via HTML form.
            * [x] Extend webserver.
            * [x] Provide form for uploading an optimization problem.
                * [x] Give visual feedback for click.
                * [x] Respond to form with JSON document.
                    * [x] BinaryProcessor should use single byte array for request and response,
                        because putting multiple binary arrays into one string and extracting the byte arrays from that string is easy via base64.
                        -> BinaryProcessor was renamed to Processor and is generic.
                        The Processor used for the webserver now retrieves a single wrapped Perspective and
                        returns a single wrapped Perspective.
                * [x] Show current status.
                * [x] Block submit button, if already active.
                * [x] Minimize chapter content and add buttons to chapter titles in order to hide and show its content.
                    Otherwise, the content of the form can be irritating because of the big text areas.
                * [x] Create processor, that parses and solves given problem.
                * [x] Create mini framework for forms.
                    * [x] Upload data via Tabulator. -> Will be done later, when the feature is useful.
                    * [x] Download data via Tabulator.
                    * [x] Make button more visible as such. Differentiating between links/task resulting in a different page
                        and the same page.
                        * [x] Create website styling guidelines.
                            * [x] Buttons linking to other pages.
                            * [x] Buttons for actions on current page.
                * [x] Test webserver's processor.
            * [x] Clean up HTTP server.
    * [x] Provide way to upload problem data.
    * [x] Test complete optimization on simplest parsed problem, without webserver.
    * [x] Provide way to download solution.
* [x] Redeploy website as last deployment was kaputt.
* [x] Fix loading of class resources located inside nested jars.
    * [x] Try using Spring's PathMatchingResourcePatternResolver. -> This tool does not work as intended.
        * [x] Find error via trace logging. -> PathMatchingResourcePatternResolver does not support pattern matching for resource paths with Equinox class loaders. 
            * Test command: `java -Dnet.splitcells.dem.resource.FileSystemViaClassResourcesAndSpring.IS_TRACING=true -jar target/network.distro-0.0.1-SNAPSHOT-spring-boot.jar
              ` -> Works with spring-boot jar. 
    * [x] Create custom Maven plugin in order to create a list of all resources and to store this file inside the jars.
         FileSystemViaClassResourcesImpl can read this file in order to list all resources.
         A custom Maven plugin is ok, because building a project based on the Splitcells Network already needs custom parents and boms.
    * [x] Consider using resource list file inside FileSystemViaClassResources.
* [x] Speed up resource loading in RCP application.
    * [x] Provide read method that optionally returns byte content of file in order to not do file check and read separately.
    * [x] Speed up isFile and isDirectory via internal cache.
        * [x] Annotate resource list generated via plugin with info, if the path is file or folder.
* [x] Provide line numbering for text areas in form.
    * [x] Add CodeMirror to NOTICE file.
    * [x] Synchronize CodeMirror editor with textarea during end of form submission in both directions.
* [x] Improve logging system.
    * [x] Log all requests in detail, in order to make it easier to support users by making user actions more traceable.
    * [x] Ensure, that logs are present in application. -> The logs are stored at `./net.splitcells.network.distro.log`.
    * [x] Log as CommonMark document, so that logs look nice on websites like GitHub.
        Do this by creating an alternative implementation of Domsole based on the default impl, which is Pdsui.
    * [x] Fix strange log framework class naming.
        The naming is strange, because there is a bigger concept/idea behind that framework.
        In this concept, the log is the basis for an interactive user interface.
        This is obsolete, because such a concept is compatible with a log framework.
* [x] Provide good error messages.
    * [x] Expand code guidelines regarding error messages.
        * [x] Pojos and other static types are not needed,
            as stability regarding the error message format is not guaranteed in order to make error reporting
            easy to create and adjust.
    * [x] Use alternative to Optionals. -> This will be done, when there is a greater need.
    * [x] Support error reports. -> This will be done, when there is a greater need.
* [ ] Support a school scheduling problem as a presentable example with a link to a preload.
    * [x] Create infrastructure for generic constraint type and rating function parsing, as otherwise, this will not scale well in the future.
        * [x] Add a method to Query interface, that creates a constraint given a constraint type name and a list of rating functions.
            Such a method can be useful for parsers in order to construct constraint trees.
  * [ ] Explicitly handle parsing errors via a result object, instead of using exceptions.
      * [x] Create and use result class. CURRENT
      * [x] User result class for ProblemParser.
      * [ ] User result class for SolutionCalculator.
      * [ ] Create error messages for SolutionCalculator.
      * [ ] Make a distinction between internal consistency error for errors with technical details, execution error for generic errors and user explainable errors. 
      * [ ] Show error in editor form.
    * [ ] Switch constraint parser to infrastructure for generic constraint generation.
        * [ ] Create and use rater parser.
        * [ ] Create and use attribute parser.
* [ ] Provide application downloads.
* [ ] Deploy application on public server.
## Tasks to be planned in other tickets
* [ ] User should be able to define part of the solution.
* [ ] Use JQuery instead of own functions.
## Ideas
* [ ] `ProjectsRendererI#build` should not write to local file system.
* [ ] Find teacher/school for testing? There is currently a problem with the contact person.
* [ ] Consider making program runnable in Browser via Javascript.
    * [ ] https://github.com/mirkosertic/Bytecoder
* [ ] Consider htmx for complex UI in the future: https://htmx.org/
* [ ] Cache projectPath of ProjectsRendererI.