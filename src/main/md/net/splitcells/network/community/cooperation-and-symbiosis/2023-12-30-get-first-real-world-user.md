# Get first real world user
[\#284](https://github.com/www-splitcells-net/net.splitcells.network/issues/284) is the GitHub issue.
## Goal
Mārtiņš Avots wants to have a first real word user of the software,
but before this can be accomplish,
some things have to be adjusted in the project.
## Tasks
* [ ] Adjust the project, so that it can be used for school related scheduling by normal users.
    It is important, that the software can be explained and introduced easily to German teachers,
    that can speak and read English.
    Keep in mind, that every German document still needs an international English version as well.
    * [ ] Create internationalization standard for documentations, based on file suffixes.
    * [ ] Create document describing objectives regarding school scheduling.
        * [ ] Make current objectives document a set of documents.
        * [ ] Add school scheduling as an additional sub goal, that is used in order to have real world experience.
    * [ ] Create help page for editor.
        * [ ] Create a second document describing the currently implemented problems and problems soon to be implemented.
    * [ ] Make it easier for uniformed visitors to understand and use the website's features on the static personal website.
          * [ ] https://splitcells.net/net/splitcells/martins/avots/website/info/about-this-site.html
          * [ ] Make a better description and title for the changelog.
          * [ ] Mark Network documentation as developer documentation.
* [ ] Announce project publicly.
    * [ ] Create demonstration video for web server.
    * [ ] Create demo video for local users.
* [ ] Talk to current main contact person.
* [ ] Consider talking to schools directly.
## Considerations
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
* [ ] Create web platform, where user can upload their data privately, in order to have one place to work on their problems on different user devices.