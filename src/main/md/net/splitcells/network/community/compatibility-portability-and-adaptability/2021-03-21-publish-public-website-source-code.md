# Publish public website source code
- [ ] Make this ticket nice and note the difference to https://github.com/www-splitcells-net/net.splitcells.network/issues/199
- [ ] This repo is used in order to publish the website's source code: https://github.com/www-splitcells-net/net.splitcells.martins.avots.distro

In #14 the server code is published.
Now the layout and some other basic stuff is missing,
in order to render the public version of the website.

- [x] Layout
- [x] Style
- [x] Declare licensing info to `net.splitcells.network.media`.
    - [x] Choose preferred licence of the files. Consider the special situation of images in this context. Maybe create a dedicated repo for binary files? -> Use EPL 2.0 for now, because some parts of network subproject explicitly link to files in this repo. EPL 2.0 can be used for software documentation. Thereby, EPL 2.0 is the easiest licence, because in this case no new licence is added to the projects.
* [x] RenderingValidatorForHtmlLinks shows many invalid links.
  `net.splitcells.martins.avots.distro` does not have such many errors. -> This was mainly caused by the file `search.html` in the detailed menu. The link was removed.
- [ ] Create public repo for personal site.
    - [ ] Choose licence for its texts.
    - [ ] Choose licence for its images and consider the consequences (i.e. in Germany).
- [ ] Move all documents of personal website to a new public repo.
    - [ ] Analyse the licences of all website resources located in public repos, in order to prevent surprises.
    - [ ] Require licence information on all files.
    - [ ] Personal text will remain in private repo for now, but it needs to be checked, that there are no other resources there,
      in order to prevent deploying resources with incompatible licences.
- [ ] Generate licence information overview for all website documents dynamically.
    - [ ] Create an error, if a file does not have licence info.
# Completed Tasks
- [x] Make it possible to render a minimal website with just `net.splitcells.network` repo. -> This is not important for this ticket.
    - [ ] Parameterize image location via an XML file provided at environment of `layout.xsl`'s execution.
    - [x] Allow rendering without background images.
        - [x] This site is rendered at `https://localhost:8447/net/splitcells/website/bare-minimal/*`
          and controlled via `generation.style` variable in the `layout.xsl`.
        - [x] `generation.style` variable was problem in error. Maybe this should be removed again? -> Do not use `generation.style` for now.
            - [ ] Every menu's content needs to be determined via documents at certain locations, instead of hard coding this into the layout, in order to avoid duplicate layouts. Do this via files provided to the XSL transformer, instead of adding this information to every document, because this is currently the easiest way and migration to other better ways should be easy enough.
- [x] Make `bare-minimal` version viable. -> This is not important for this ticket.
    - [ ] Test website with document `https://localhost:8447/net/splitcells/website/bare-minimal/net/splitcells/website/empty.html`
    - [ ] Most files are missing.
    - [ ] Create build with zero linking errors.
    - [ ] Create link to this version in default layout for easier testing.
    - [ ] Provide way to define alternative main index page.
    - [ ] Create manual for rendering minimal website.
# Future Ideas
- [ ] Create a dynamic page, that has links to all relevant website versions. This could be done, by creating an aspect for projects renderers.