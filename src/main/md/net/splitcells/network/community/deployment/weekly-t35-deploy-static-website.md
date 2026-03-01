# Weekly deploy static website.
* Issue number: [\#35](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/35)
# Service
* Test public availability without confirmation by room members and phone notifications of Matrix room for legal contacts via the account `test-mavo:matrix.org`: https://matrix.to/#/#net.splitcells.martins.avots.webiste.legal:matrix.org
* Execute `net.splitcells.martins.avots.website.deploy.diff`.
    * Fix warnings during static web server rendering.
    * Check via browser, if there are client side errors.
    * Check via browser, if really no cookies are set.
# Tasks
* [ ] Let all interactive pages be a redirect to the live server instead.
  Use a special domain for that, that is a placeholder and is used for nothing else.
    * [ ] Create a config to enable this functionality on static website. This functionality is disabled by default.
    * [ ] Enable this config in the website project.
    * [ ] Implement new config interpretation.
* [ ] Do not allow static website deployment with invalid links.
* [ ] Disallow any XSL warnings and errors by default.
    * [ ] Remove all XSL warnings and errors.
* [ ] [Deploy static website via daily Codeberg CI](../maintenance/weekly-t32-process-project-status-weekly.md).
  First [Publish public website source code](../compatibility-portability-and-adaptability/9999-2021-03-21-publish-public-website-source-code.md) has to be done.
    * [ ] Enable Javadoc rendering. It was disabled, as it takes a lot of time on the local computer.
* [ ] The websites logo does not work on iPhone.
# Done Tasks
* [o] Invalid links are incorrectly counted. See https://splitcells.net/net/splitcells/website/server/project/validator/RenderingValidatorForHtmlLinks/build/splitcells-XPS-15-9570.csv.html
  -> This count is not stored anymore.
* [x] GitHub's SVGs in the README attempt to set cookies. This should not even be attempted.
  -> This seems to be fixed in Firefox, as this message does not appear anymore.
  Furthermore, this seems to be a security issue in Firefox and not of the website: https://insert-script.blogspot.com/2016/12/firefox-svg-cross-domain-cookie.html
* [x] Remove telephone number from Impressum and replace it with Matrix chat room.
    * [x] Create Matrix chat.
    * [x] Update impressum.
* [x] `https://splitcells.net/net/splitcells/website/css/basic.css` is not updated.
  -> For whatever reason the `basic.css` is not updated during the website depoyment.
* [x] Consider simplifying the privacy policy, in order to minimize the attack surface.
    * [x] Adjust the liver server privacy policy.
        * [x] Do not state too specifically the log content and duration. -> The duration is relevant.
        * [x] Do not state where the server is hosted. Make this only available on request.
          On the other hand, making this available on requests makes this more complicated.
          Either way, document the decision. -> Always stating this in the privacy policy is the easiest.
        * [x] Do not state, that cookies are not used.
        * [o] `Folgende Nutzungs-Daten werden` -> `Unter anderem folgende Nutzungs-Daten werden`
          -> `Unter anderem` implies, that something is missing in the privacy policy.
        * [x] Explicitly state the legal basis for processing and storage of personal data.
        * [x] Remove phone number from privacy policy.
            * [x] Create matrix channel. -> The invitation link is https://matrix.to/#/#net.splitcells.martins.avots.webiste.legal:matrix.org
            * [x] Test invitation link with an additional Matrix account.
            * [x] Test phone notifications with 2nd Matrix test account.
            * [x] Link matrix channel in privacy policy and impressum, but recheck if this is legally ok.
            * [x] Remove personal phone number from git history of `net.splitcells.martins.avots.distro`.
              Add the commands to the git guidelines as these could be useful in the future as well.
            * [x] Note why call is not enough:
                * [x] https://www.ferner-alsdorf.de/impressumspflicht-haendler-muss-auf-anfragen-innerhalb-von-60-minuten-antworten/
                * [x] https://codeberg.org/Codeberg/org/src/branch/main/Imprint.md
                * [x] https://www.danisch.de/assets/pages/impressum.html
                * [o] This is not a commercial website/server. -> Does not seem to be relevant.
                * [x] Phone also does not guarantee 24/7 availability at any moment, for example because of too many calls.
        * [x] Note, that we have at most 1 month to answer privacy policy related requests.
        * [x] State the relevant law is German law, instead of referring just the law.
          -> This is already done by linking to `Art. 13 der Datenschutz-Grundverordnung` at the start of each privacy policy.
          This is fine, as long no policies for different countries exist.
        * [x] Fix the title of privacy policy.
        * [x] Do this for the German and English version.
* [y] Use the same legal documents for the static and the live server.
    * [x] Privacy policy
    * [x] Impressum
    * [x] Licensing
    * [x] Delete static website specific documents, as these are obsolete.
* [x] The status `The number of invalid links is historically improving.` seems to be incorrect. -> This was only a problem in `net.splitcells.martins.avots.distro`.
* [x] Fix the warning: `Expecting at most 1 meta data entries but found 2 instead: [Optional[index.html], Optional[index.html]]`
    * [x] Fix warning instances.
    * [x] Make this an error.
    * [x] Ensure, that big part of website rendering is tested at daily Codeberg CI via SystemCellTest.
      -> Integration tests do not seem to be executed, which is needed.
      -> The integration test is enabled in Codeberg CI.
* [x] The upload is not being done via `net.splitcells.martins.avots.website.deploy.diff`
  The reason is unknown.
    * [x] It seems to that `./bin/serve.to.folder` does not write files to `cd ~/connections/net.splitcells.upload` anymore.
      This seems to be caused by `mvn exec:java -Dexec.mainClass='net.splitcells.website.martins.avots.StaticFileServer'`.
        * [x] `System.err` is not flushed and can hide the printed stack trace, because of the system exit right after the stack trace print.
          Unfortunately, there does not seem to be a exception and therefore stack trace being present.
        * [o] Debug `RenderingValidatorForHtmlLinks#endReport` -> This was caused by the runner inside HostUtilizationRecorder,
          where an exception in this thread caused a none zero exit code.
* [x] Invalid-Link-Counter page, has old history file: `https://splitcells.net/net/splitcells/website/server/project/validator/RenderingValidatorForHtmlLinks/build/splitcells-XPS-15-9570.csv.html`
  * [x] Check the last CSV entry is new enough. Otherwise, create a status warning exactly for this.
* [x] Speed up `RenderingValidatorForHtmlLinks` by caching `ProjectsRenderer#projectsPaths()`. -> The cache already exists.
  * [o] Refresh cache, when invalid links was found and recheck.
  * [o] Check valid links, by rendering it internally.
* [x] Full and differential deployment does not always seem to update already uploaded files
  See https://splitcells.net/net/splitcells/network/community/blog/articles/2024-04-14-assertj-considered-unfit.html
  It seems to affect HTML pages, but not files like `*.js` (see `https://splitcells.net/net/splitcells/gel/ui/no/code/editor/lib.js`).
  The reason seams to be, that `bin/serve.to.folder` does not server most HTML documents,
  that are based on XML or CommonMark documents.
  -> The reason for that was a file name, that started with a whitespace, which was rejected by the server.
  This caused `bin/serve.to.folder` fail and thereby the rest of `bin/deploy.diff` to upload incomplete data,
  because the Java program's return code was always 0.
  This was adjusted, so that `net.splitcells.website.martins.avots.StaticFileServer` exits with the return code 1,
  if the server aborted serving the files to the folder.