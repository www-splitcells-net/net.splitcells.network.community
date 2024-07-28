# Weekly deploy static website.
* [ ] Full and differential deployment does not always seem to update already uploaded files
  See https://splitcells.net/net/splitcells/network/community/blog/articles/2024-04-14-assertj-considered-unfit.html
  It seems to affect HTML pages, but not files like `*.js` (see `https://splitcells.net/net/splitcells/gel/ui/no/code/editor/lib.js`).
    * [ ] The reason seams to be, that `bin/serve.to.folder` does not server most HTML documents,
      that are based on XML or CommonMark documents.