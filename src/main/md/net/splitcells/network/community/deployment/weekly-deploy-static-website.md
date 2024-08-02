# Weekly deploy static website.
* Issue number: [\#35](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/35)
# Service
* Execute `net.splitcells.martins.avots.website.deploy.diff`.
# Tasks
# Completed Tasks
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