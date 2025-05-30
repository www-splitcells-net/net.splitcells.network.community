# Provide scheduling tool for schools in general.
* Goal: The goal is to provide a minimum viable product, that demonstrates,
     how such a tool would look and work like.
* Ticket: https://github.com/www-splitcells-net/net.splitcells.network/issues/252
* Start Date: 2023-10-05
* End Date: 2024-03-24
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
            * [x] Make grammar an abstract tree grammar, in order to use this as the basis for tree framework.
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
* [x] Support a colloquium planning problem as a presentable example with a link to a preload.
    * [x] Create infrastructure for generic constraint type and rating function parsing, as otherwise, this will not scale well in the future.
        * [x] Add a method to Query interface, that creates a constraint given a constraint type name and a list of rating functions.
            Such a method can be useful for parsers in order to construct constraint trees.
  * [x] Explicitly handle parsing errors via a result object, instead of using exceptions.
      * [x] Create and use result class.
      * [x] User result class for ProblemParser.
      * [x] User result class for SolutionCalculator.
      * [x] Fix JSON for form update, when errors are present.
      * [x] Fix `forEach` constraint.
      * [x] Show error messages for SolutionCalculator.
      * [x] Make a distinction between internal consistency error for errors with technical details, execution error for generic errors and user explainable errors. 
      * [x] Show error in editor form.
      * [x] Show syntax errors.
    * [x] Switch constraint parser to infrastructure for generic constraint generation.
        * [x] Create and use rater parser.
  * [x] Use result for RaterParser, in order to have nicer error messages.
  * [x] Explain to user invalidly entered constraint types.
  * [x] Create endpoint providing problem description, so it can be used in tests without code duplication.
  * [x] Test default school course scheduling problem.
  * [x] Solve example problem.
  * [x] Automatically test default school course scheduling problem.
  * [x] Output rating and reasoning.
* [x] Clean up application.
    * [x] Make new editor maximized by default for better usage. Do this for telemetry too.
    * [x] Ensure that the browser does not load page from internet.
        * This is observed for the links at the README. Replace `splitcells.net` with localhost and port.
        * [x] Always check the current browser URL and replace the domain, if pattern is known.
        * [x] Always check the current browser URL and replace the complete URL, if pattern is unknown.
    * [x] Provide telemetry data on UI.
* [x] Use Electron instead of Eclipse, because Eclipse has many issues. -> JavaFX is a better choice.
* [x] Deploy correct distribution.
    * [x] Create framework to build a custom distribution, in order to avoid writing duplicate build scripts with inconsistencies.
        * [x] Rename existing network worker project, in order to reflect its focus on Java.
        * [x] Create dedicated network worker repo.
        * [x] Move all generic commands of distro project to network worker.
        * [x] Process `build.on.server.via.podman`
        * [x] Rename `execute.via.podman` to `execute` in order to support any tool used for executing tasks.
    * [x] Use new framework to build correct distribution.
* [x] Use JavaFX instead of Eclipse, because Eclipse has many issues.
    * Electron is a worse alternative than JavaFX, because it avoids an additional stack.
    * [x] Add dependencies
    * [x] Extend license notice
    * [x] Synchronize URL bar and currently opened page.
    * [x] Implement reset button.
    * [x] Implement refresh button.
    * [x] Implement load URL button.
    * [x] Implement go back in history button.
    * [x] Implement go forward in history button. -> Could not get it working. On the first look it's a bug in JavaFx.
    * [x] Avoid privacy pop up in editor.
    * [x] Add main page to menu.
    * [x] Document how to enable JavaFX via JVM parameters: `--module-path "projects/net.splitcells.network.distro.javafx/target/lib" --add-modules javafx.controls,javafx.web`
* [x] Provide application downloads.
    * [x] Create app for Linux.
        * [x] Create zip containing runnable program at `net.splitcells.network.distro.javafx`.
            * [x] Bundle JavaFX files in dedicated folder and enable JavaFX modules.
            * [x] Bundle Jars of app in dedicated folder.
            * [x] Bundle JRE.
            * [x] Provide shell script for starting program.
            * [x] Test application.
                * [x] Avoid privacy pop up. -> Building everything again, fixed the problem.
                * [x] Bundling jre automatically does not work.
            * [x] Make share project generic to the application version or type.
            * [x] Add share project to distro.
            * [x] Deploy the zipped app to static website.
            * [x] Deploy the zipped app to live server.
        * [x] Create share project to optionally provide the runnable applications as a download.
        * [x] Add share project to static public server distro, so that users can easily download the software.
          -> The download URL is `http://localhost:8443/net/splitcells/network/distro/downloads/net.splitcells.network.distro.javafx-0.0.1-SNAPSHOT-linux-zip.zip`.
        * [x] Fix live server build.
    * [x] Create app for Windows.
        * [x] Use bat files as launchers on Windows.
        * [x] Fix application on Windows.
            * [x] Fix path errors in file system and website server.
                * [x] Make `FileSystemViaClassResourcesTest` in IDE on Windows working. It works in Bash with Maven on Windows.
                * [x] Make `WebsiteViaJarTest#testServingWebsiteToFolder()` working on Windows.
                    * [x] Make website layout OS independent.
            * [x] Add app icon for main window.
            * [x] Fix the refresh button.
            * [x] Fix page shown at `http://localhost:8443/net/splitcells/network/hub/README.html`.
            * [x] Fix `launcher.bat`. Everything else of the app zip seems to work, as the following command works in Git Bash on Windows: `java --module-path './javafx-lib' --add-modules javafx.controls,javafx.web -cp './deployable-jars/*' net.splitcells.network.distro.javafx.JavaFxGuiLauncher`
            * [x] Do start application as big as the computer display.
            * [x] Avoid oversized footer in web view.
            * [x] App build on Linux misses some jars for Windows.
    * [x] Remove untested tag on download page for Windows version.
    * [x] Create app for Mac.
    * [x] Clean up upload cache for static website, so it does not cause storage problems.
    * [x] Create download page.
        * [x] Mark Mac version as untested.
    * [x] Redeploy software and server.
* [x] Deploy default distro application on public server.
    * [x] Implement privacy warning pop up, only for server.
    * [x] Create weekly deployment task.
    * [x] Create application builder.
        * [x] Cache m2.
        * [x] Avoid building RCP application, in order to avoid build error.
        * [x] Create dedicated location for build container data.
        * [x] Fix `Cross-Origin Request Blocked` error at live server. -> Cannot find the error anymore.
        * [x] Create live server configuration specific to deployment.
            * [x] Create working config.
            * [x] Add privacy policy.
            * [x] Adjust privacy policy to upload functionality.
                * [x] Provide English version.
                * [x] Provide German version.
                * [x] Content adjustment
                    * [x] Disallow upload of private data. -> Not done, as this is not useful.
                    * [x] No logs or uploaded data is stored permanently. It is immediately deleted after processing.
                    * [x] Error logs are only stored for 7 days.
                    * [x] Server is hosted at Hetzner and note its privacy policy: https://www.hetzner.com/de/legal/privacy-policy
                    * [x] Check Hetzner's log tools available to Hetzner customers.
                * [x] Adjust pop-up for editor.
                    * [x] Make it's content configurable by creating API in XSL in order to access any file system data.
                        * [x] Use PathBasedUriResolver's configFiles API and adapt it to a general state API.
                            * [x] Use `/net.splitcells.website.server/` as base.
                            * [x] Use `/net.splitcells.website.server/source-code/` for source code.
                                * [x] Register ProjectsRendererI to ProjectRendererI, so that source code fs is available to user.
                            * [x] Use `/net.splitcells.website.server/configuration/` for future external configurations. -> This is not needed yet.
                            * [x] Use union file system view. -> This is not needed yet,
                              because no external configuration is provided via file system API to XSL rendering.
                              Nevertheless, the union file system view is implemented.
                            * [x] Load default content from default content path of notification.
                            * [x] Load adjusted content from adjusted content path.
                    * [x] Provide mechanism to define default global privacy policy notification. -> Not needed right now.
                    * [x] Provide mechanism to customize privacy policy notification for a page. -> Not needed right now.
                    * [x] Use `<content-of>net/splitcells/website/server/legal/privacy-policy/upload-for-processing-notification</content-of>` in editor.
            * [x] Add Impressum.
        * [x] Error is not shown when empty form is submitted.
        * [x] Fix build error.
    * [x] Deploy latest version.
* [x] Add link to live server on personal website.
* [x] Use port 80 for HTTP of live server.
* [x] Add missing points of this ticket to the changelogs.
  -> That is not that important, given the inconsistency of the changelogs completeness.
  Keep in mind, that there is only one developer working on this right now and there are no users of the software.
* [x] Clean up private static website.
    * [x] Newsfeed -> Technical Newsfeed
    * [x] Fix apostrophe symbol at Newsfeed description.
    * [x] Clean up article `About this site`.
    * [x] Indicate that list of downloads is a list of downloads.
## Tasks to be planned in other tickets
* [x] User should be able to define part of the solution. -> An ticket was created: https://github.com/www-splitcells-net/net.splitcells.network/issues/287
## Ideas
* [x] `ProjectsRendererI#build` should not write to local file system. -> Created TODO inside ProjectsRendererI's source code.
* [x] Find teacher/school for testing -> An issue was created for this: https://github.com/www-splitcells-net/net.splitcells.network/issues/284
* [x] Consider making program runnable in Browser via Javascript. -> An issue was created for this: https://github.com/www-splitcells-net/net.splitcells.network/issues/288
* [x] Consider htmx for complex UI in the future: https://htmx.org/ -> This is not relevant for now.
* [x] Cache projectPath of ProjectsRendererI. -> This is not relevant for now.