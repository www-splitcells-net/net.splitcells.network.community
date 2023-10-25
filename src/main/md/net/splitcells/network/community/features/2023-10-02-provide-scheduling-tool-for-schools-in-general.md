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
* [ ] Provide generic editor.
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
    * [ ] Provide editor to define constraints.
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
        * [ ] Upload data via HTML form.
            * [x] Extend webserver.
            * [ ] Provide form for uploading an optimization problem.
                * [ ] Give visual feedback for click.
                * [x] Respond to form with JSON document. CURRENT
                    * [x] BinaryProcessor should use single byte array for request and response,
                        because putting multiple binary arrays into one string and extracting the byte arrays from that string is easy via base64. 
                * [ ] Show current status.
                * [ ] Add result link to solution chapter.
                * [ ] Create processor, that parses and solves given problem.
                * [ ] Create processor, that provides calculated solutions for a limited time. 
                    By using a processor an ID can be used to identify the solution to be retrieved without
                    showing the id in the webserver layout.
                    This makes it possible to hide or isolate output created by different users.
                * [ ] Create mini framework for forms.
            * [x] Clean up HTTP server.
    * [ ] Provide way to upload problem data.
    * [ ] Test complete optimization on simplest parsed problem, without webserver.
    * [ ] Provide way to download solution.
* [ ] Improve logging system.
    * [ ] Log all requests in detail.
    * [ ] Ensure, that logs are present in application.
* [ ] Provide application downloads.
* [ ] Deploy application as server.
* [ ] Support a school scheduling problem as a presentable example with a link to a preload.
## Tasks to be planned
* [ ] User should be able to define part of the solution.
## Ideas
* [ ] Find teacher/school for testing?
* [ ] Consider making program runnable in Browser via Javascript.
    * [ ] https://github.com/mirkosertic/Bytecoder
* [ ] Consider htmx for complex UI in the future: https://htmx.org/