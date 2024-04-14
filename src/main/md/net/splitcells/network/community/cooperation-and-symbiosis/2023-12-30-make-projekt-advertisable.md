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
* [ ] Encrypt communication to server with certificate from Let's encrypt.
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
    * [ ] Solve the problem completely.
    * [ ] Create a demo button, where the visualization of a faulty solution is demonstrated.
    * [ ] Correct file name of `school-course-scheduling-problem.txt` according to its content.
    * [x] Re enable `SolutionCalculatorTest#testDemonstrationExample()`.
      Consider `ColloquiumPlanningTest` for inspirations.
* [ ] Implement school course scheduling.
* [ ] Implement sport lesson assignments.