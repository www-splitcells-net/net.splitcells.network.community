# Migrate local app to SWT without OSGI
* Issue number: [\#63](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/63)
# Task Description
JavaFX bundles its own Chromium browser, which could be an issue,
as it is older and does seem to be different to common browsers regarding icons and co.
The can create unique problems and issues with the OS integration.

SWT provides a way to embed the systems browser, which should do the trick.

Keep in mind
# Tasks
* [ ] Create a proof of concept browser application.
* [ ] Build runnable application.
    * [ ] Linux
    * [ ] Windows