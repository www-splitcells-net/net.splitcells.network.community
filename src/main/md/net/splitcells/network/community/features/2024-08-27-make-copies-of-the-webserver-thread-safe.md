# Make copies of the webserver thread safe
* Issue number: [\#38](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/38)
# Task Description
If multiple ProjectsRenderer are created and each used by a dedicated thread,
then these ProjectsRenderers still have problems with each other's thread.

The basis for the webserver thread safety was created [here](../projects/2024-08-22-sigma-grind-of-24th-of-august-2024.md).
# Tasks
* [ ] First complete [this ticket](2024-05-31-create-no-code-gel-editor.md).
* [ ] Multithreaded webserver sometimes has random errors, when optimization problems are submitted via the editors.
    * [ ] The Whole XML class needs to be removed, as it is not thread safe.
    * [ ] Try improving the multithreaded webserver by trying an experimental handler fix for the multipart-bodies of forms:
      Use end handler and body handler by nesting these.
    * [] Only expect multipart, if the request is not read yet: * `if (!routingContext.request().isEnded()) { routingContext.request().setExpectMultipart(true);}`