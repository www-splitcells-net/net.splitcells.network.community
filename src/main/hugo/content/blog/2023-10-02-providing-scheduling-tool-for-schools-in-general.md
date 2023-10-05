---
title: Provide scheduling tool for schools in general.
date: 2023-07-12
author: Mārtiņš Avots
tags: [feature, active]
---
* Ticket: https://github.com/www-splitcells-net/net.splitcells.network/issues/252

# Tasks
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
    * [ ] Provide front menu, that present main application.
        * [ ] Create config to define menu items.
        * [ ] Render front menu.
    * [ ] Provide way to upload problem data.
    * [ ] Provide way to download solution.
    * [ ] Provide editor to define constraints.
* [ ] Provide application downloads.
# Tasks to be planned
* [ ] User should be able to define part of the solution.
# Ideas
* [ ] Find teacher/school for testing?
* [ ] Consider making program runnable in Browser via Javascript.
    * [ ] https://github.com/mirkosertic/Bytecoder
* [ ] Consider htmx for complex UI in the future: https://htmx.org/