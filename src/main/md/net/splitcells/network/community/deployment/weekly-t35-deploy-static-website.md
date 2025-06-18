# Weekly deploy static website.
* Issue number: [\#35](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/35)
# Service
* Execute `net.splitcells.martins.avots.website.deploy.diff`.
    * Fix warnings during static web server rendering.
# Tasks
* [ ] Consider simplifying the privacy policy, in order to minimize the attack surface.
    * [ ] Do not state too specifically the log content and duration.
    * [ ] Do not state where the server is hosted. Make this only available on request.
      On the other hand, making this available on requests makes this more complicated.
      Either way, document the decision. 
    * [ ] Do not state, that cookies are not used.
    * [ ] `Folgende Nutzungs-Daten werden` -> `Unter anderem folgende Nutzungs-Daten werden`
    * [ ] Explicitly state the legal basis for processing and storage of personal data.
    * [ ] Remove phone number from privacy policy.
    * [ ] Note, that we have at most 1 month to answer privacy policy related requests.
    * [ ] State the relevant law is German law, instead of referring just the law. 
    * [ ] Fix the title of privacy policy.
    * [ ] Do this for the German and English version.
    * [ ] Use the same privacy policy for the static and the live server.
* [ ] Remove telephone number from Impressum and replace it with Matrix chat room.
    * [ ] Create Matrix chat.
    * [ ] Update impressum.
* [ ] Fix README correctly.
* [ ] Do not allow static website deployment with invalid links.
* [ ] Invalid links are incorrectly counted. See https://splitcells.net/net/splitcells/website/server/project/validator/RenderingValidatorForHtmlLinks/build/splitcells-XPS-15-9570.csv.html
* [ ] The websites logo does not work on IPhone.
* [ ] Let all interactive pages be a redirect to the live server instead.
  Use a special domain for that, that is a placeholder and is used for nothing else.
    * [ ] Support pages requiring a login.
    * [ ]
# Completed Tasks
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