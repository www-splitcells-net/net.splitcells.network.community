# Make project advertisable
[\#c11](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/11) is the issue.
## Goal
The goal is, to create some advertisement material and to do some polishing work.
## Tasks
* [ ] Announce project publicly.
    * [x] Make static website and live server more advertisable.
        * [x] Remove `Local Instances` sub menu.
        * [x] Fix rendering of graphs (i.e. `https://splitcells.net/net/splitcells/website/server/project/validator/RenderingValidatorForHtmlLinks/build/splitcells-XPS-15-9570.csv.html`).
        * [x] Fix link at main logo: `https://splitcells.net/net/splitcells/network/hubREADME.html`
        * [x] Fix main menu: `https://splitcells.net/net/splitcells/website/main-menu.html`
        * [x] Fix licensing on live server: `http://live.splitcells.net/net/splitcells/martins/avots/distro/legal/licensing.html`
        * [x] Redeploy website.
    * [ ] Create demonstration video for web server.
    * [ ] Create demo video for local users.
    * [ ] Talk to current main contact person.
* [ ] Adjust the project, so that it can be used for school related scheduling by normal users.
    It is important, that the software can be explained and introduced easily to German teachers,
    that can speak and read English.
    Keep in mind, that every German document still needs an international English version as well.
    * [x] Create internationalization standard for documentations, based on file suffixes.
      -> There is currently no effective way to enforce this or to use such a convention and therefore it is not documented.
      If, for instance, there is a need for internationalization of the website's menu as well,
      such a file suffix could be introduced, in order to determine, which language should be used for the menu rendering.
    * [x] Create document describing objectives regarding school scheduling. -> The document is located at `src/main/md/net/splitcells/network/community/projects/2024-04-06-school-organization-project.de.md` of this repo.
        * [x] German version
        * [x] English version
        * [x] Links to these from `About this site` at personal website.
        * [x] Shrink project goals back to initial goals of the past.
    * [ ] Create help page for editor.
        * [ ] Create documentation guidelines.
            * [ ] Each document is specific to certain groups.
            * [ ] All documentation structure is centered around most uninformed user.
        * [ ] Create a second document describing the currently implemented problems and problems soon to be implemented.
        * [ ] Consider using a chat bot like support system, in order to avoid clutter in editor.
          Maybe a general project/art concept like a `net.splitcells.network.support` might be useful here.
          Consider it the main thing, representing the project for users like a virtual assistant.
    * [x] Make it easier for uniformed visitors to understand and use the website's features on the static personal website.
        * [x] https://splitcells.net/net/splitcells/martins/avots/website/info/about-this-site.html
        * [x] Make a better description and title for the changelog.
        * [x] Mark Network documentation as developer documentation.
          -> Change this to `Splitcells Network Documentation` in order to avoid clutter.
* [ ] Consider talking to schools directly.
* [ ] Encrypt communication to server with certificate from Let's encrypt in order to avoid browser warning and
  in order to secure data sent to the server by the users.
    * [x] Use https://github.com/shred/acme4j
    * [x] Enable SSL.
    * [x] Reuse certificates across restarts.
    * [x] Add ACME-Client to webserver as an extension dynamically.
      Until now, all extensions were defined in the main implementation without a method to add new extensions publicly.
    * [ ] Persist certificates and user keys.
        * [x] Create portable file storage concept.
        * [ ] Implement portable file storage concept.
        * [ ] Check validity of stored certificates on startup.
    * [x] Log ACME protocol progress for easier debugging.
        * [x] Improve CommonMark log for properties for normal users.
        * [x] Use compressed logging on server, so that one line represents one log message.
        * [x] Do not show stacktrace if an invalid path is requested from webserver.
        * [x] Only log once, if a path outside of `/net/splitcells/**` is requested at the webserver.
          -> This will be done, if there is a real need. For now this is just a nice to have.
        * [x] Correct rolling log file path.
        * [x] Ensure that time based rolling is working. -> This is not important for now.
        * [x] Create shell command to easily download logs from server over SSH.
          -> `ssh.download.file --remote-file-address martins-avots@live.splitcells.net:.local/state/net.splitcells.martins.avots.distro/.local/net.splitcells.martins.avots.distro.LiveDistro/logs/execution-current.txt --target-file=./execution-current.txt`
        * [x] Ensure that `waiting for` messages are logged. Also log that the number of status checks are logged as well.
        * [x] Server is probably not waiting long enough for Let'sEncrypt to do its challenge.
    * [x] Make domain and contact email configurable.
    * [x] Make ACME-Server configurable.
    * [x] Use standard SSL port 443 in order to easy usage via browser.
      -> The live server now forwards port 8080 to 443 and the program was extend to redirect HTTP calls to HTTPS.
    * [x] Use self signed certificate for bootstrap step.
* [ ] Transform the editor to a lightweight IDE, so that users intuitively understand, what this tool tries to provide.
    * [ ] Add actions to menu, in order to save space.
    * [ ] Show menu in mobile view.
    * [ ] Create a editor with tabs for input and results.
    * [ ] Create a console for output messages.
    * [ ] Make row and column definition of output table configurable. 
    * [ ] The default example problem (colloquium problem) should return a timetable.
    * [ ] Move documentation to secondary column.
    * [ ] Show secondary column of editor by default, but still provide a fullscreen view.
      In other words, show the secondary column of the editor and simultaneously avoid wasting space by the background.
## Considerations
* [ ] Regulary test editor or other UI functionality.
* [ ] Error message are not good for some inputs
    * [ ] Problem definition is incorrect.
    * [ ] Demand data is incorrect.
    * [ ] Supply data is incorrect.
* [ ] Support file downloads in GUI for results.
    * [x] Create isDownloadingViaHtmlElement option.
    * [ ] If isDownloadingViaHtmlElement is enabled, client side downloads are encoded via base64 and stored in a dedicated hidden HTML element.
      Don't forget to store the download's default file name.
    * [ ] JavaFX side scans currently opened document for the dedicated element periodically.
      Anytime a download is found an appropriate file safe dialog is offered and after that,
      the dedicated elements' content are deleted.
    * [x] Introduce GUI user config in distro and use this for JavaFX distro. -> That already did exist, but a better name was needed. The user config was renamed to local user config, in order to indicate that the user itself runs the software.
## Ideas
* [ ] Improve menu and logo links.
  Navigating to the front page is quite hard, when one is knees deep on the website.
* [ ] Create web platform, where user can upload their data privately, in order to have one place to work on their problems on different user devices.
* [ ] Allow the user to persist his projects.
* [ ] Enable the user to define parts of the solution manually.
* [ ] Improve handling of colloquium planning problem.
    * [ ] Create real GUI worthy a program being used by users.
      Currently, the editor's GUI is more like a form,
      because in its current state it is more a proof of concept than a real GUI.
        * [ ] Transform editor to a classic IDE with tabs for each major input data.
          Use current error text box as console.
            * [ ] Do not donate messages in first text box an error message by default.
              Maybe color the text box in the error case instead.
              Coloring is important in order to get the users attention.
        * [ ] Limit size of text editor regardless of its content.
        * [ ] Limit size of Tabulator tables regardless of its content. Use paging.
        * [ ] Create and implement the concept of page commands. These need to be visible on mobile view as well.
    * [ ] Solve the problem completely.
    * [ ] Create a demo button, where the visualization of a faulty solution is demonstrated.
    * [ ] Correct file name of `school-course-scheduling-problem.txt` according to its content.
    * [x] Re enable `SolutionCalculatorTest#testDemonstrationExample()`.
      Consider `ColloquiumPlanningTest` for inspirations.
    * [ ] Always make main and front menu accessible.
    * [ ] Document the concept of front menu in front menu document.
      It is important to understand, why the distinction between front and main menu exists.
    * [ ] Document the concept of main menu in main menu document.
* [ ] Implement school course scheduling.
* [ ] Implement sport lesson assignments.