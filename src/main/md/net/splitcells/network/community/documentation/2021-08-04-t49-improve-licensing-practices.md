# Improve licensing practices

* Issue number: [\#49](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/49)

# Task Description
We want all license metadata to be present and to be correct.
We also need full accounting for it.
# Tasks

* [ ] Improve licensing info on deployed website.
    * [ ] Create a license overview page, that links to all license relevant documents
      and also lists the license of all available pages.
        * [x] Start with empty page. -> LicensePageExtension provides this at http://localhost:8443/net/splitcells/website/license-page.html
        * [x] Create and use a website server config, that contains a list of all license pages.
          The new option is located at `net.splitcells.website.server.Config#licensePages`
        * [x] Add name/description to every license page.
        * [o] Create a static Cell methods, that lists all relevant license resources.
          Use these methods in the static website server construction functions.
          -> For now it is ok, to use website server config. 
        * [x] Note that user content is not affected by this.
        * [x] Link relevant existing pages.
            * [x] Fix all links. 
            * [x] net.splitcells.network
            * [x] net.splitcells.network.system
            * [x] net.splitcells.martins.avots.distro -> Does not have relevant license files.
            * [x] net.splitcells.martins.avots.website -> Does not have relevant license files.
        * [x] Add license overview page to menu.
    * [ ] List license of every page centrally.
        * [x] Create empty page for listing all files. -> ResourceLicensingExtension
        * [ ] `net.splitcells.maven.plugin.resource.list` has also to create and bundle a directory containing the metadata into the jar.
          The directory contains a file tree, where any file corresponds to a resource managed by the resource list.
          The file format is a UTF-8 encoded property file.
            * [x] Create meta data files.
            * [x] Read license metadata in the file headers.
            * [x] Read copyright text metadata in the file headers.
            * [ ] Read `REUSE.toml` for list files without license metadata.
                * [x] Double check results in jars by hand.
                * [x] Correctly, filter paths of parent `REUSE.toml`, that are not part of the current project.
                * [ ] Parse actual license data for each path `REUSE.toml`.
                * [ ] Support `**` in the REUSE paths.
            * [ ] Merge results of `REUSE.toml` parsing and individual file parsing.
            * [ ] Process binary files with MetaData class.
        * [ ] Provide license metadata for page via `ProjectsRenderer#metaData(String)`.
          Use this to list the licensing of every file.
            * [ ] Only provide access to metadata, to which the user has access to.
    * [ ] Show license of every page on every page.
    * [x] Link to `NOTICE.md` and `LICENSE.md`.
    * [x] `net/splitcells/network/legal/Developer_Certificate_of_Origin.v1.1.txt` is not correctly rendered.
* [ ] Images are licensed under the `CC BY-SA 4.0`.
    * [ ] Update licensing guidelines.
    * [ ] Consider add licensing metadata in images itself. See German court cases (to be refound),
      why no license metadata in `CC BY-SA 4.0` can be a problem for other distributors.
    * [ ] Consider https://creativecommons.org/licenses/by-sa/4.0/deed.en
* [x] Ensure, that every repo has proper licensing data. -> This is done via the daily CI workflow at Codeberg.
* [ ] Simplify Java's license header, in order to simplify Java files and make them shorter.
  Document that the Linux kernel uses the same format and that such a header is REUSE compliant as well.
* [ ] Add denial notice of EU's copyright exception regarding machine learning.
* [ ] Add REUSE files to license pages.
* [ ] Remove big license header from Java code as this only wastes resources.
* [ ] Check and/or generate license NOTICE file, in order to ensure its correctness.
# Done Tasks
* [x] `test.everything` should verify license data as well. -> This is done via `repos.test.sh` instead.
* [x] https://www.it-cisq.org/software-bill-of-materials/index.htm
* [x] Use https://reuse.software/ in order to check licensing in source code.
    * [x] Use tmp branch for this experiment.
    * [x] https://reuse.software/tutorial/
        * [x] `reuse init`
        * [x] `~/.local/bin/reuse lint`
    * [x] Check this in daily CI for all repos. Just create the workflow for now. The actual license info will be fixed via the weekly test deployments task.
        * [x] Create command `bin/repos.license.check` in order to check this.
        * [x] Make license processes completely independent of GPL3 code, by providing a default license check implementation, that does nothing and inject REUSE dynamically into the process instead.
        * [x] Install OSI in CI.
            * [x] Test this in `worker.execute` first.
                * [x] `cd projects/net.splitcells.os.state.interface && ./bin/install`
                * [x] Create a general shell environment setup command.
                  -> This is done inside `bin/worker.bootstrap`.
                  A real general command is not needed for now.
                    * [x] Create a project command that list all default command repositories managed by the hub repo and
                      install these with this command via the shell project. -> The project command is `bin/net.splitcells.shell.projects.peers.for.commands`.
                    * [x] Create a project command that list all command repositories, that are present in the current repository. -> `net.splitcells.shell.repo.subs`
                    * [x] Use new project commands, in order to install all command repos.
                    * [x] Install OSI first.
                      Then use `command.repository.register`, in order to easily use `command.repository.register`.
                      After that, reinstall OSI, in order to have all repos installed.
            * [x] Create general license test command. -> This command is named `repos.license.check`.
            * [x] Add this test to Codeberg's CI.
        * [x] Maybe this is part of the worker bootstrapping? -> Yes, this is integrated into `bin/worker.bootstrap`.
    * [x] The reuse-tool is licensed under the GPL-3. Is that a problem?
    * [x] Register main repo at: https://api.reuse.software/register
* [x] Create licensing guidelines.
    * [x] Create documentation stating all licence checks, that should be done.
    * [x] Add REUSE to licensing guidelines.
* [x] Document/link licensing overview in README. -> This is not relevant for now.
* [x] Add Reuse to project file system standard and document, that its LICENSES folder is exceptional.
* [x] When rendering CommonMark files, the licence info at the start of the file should be moved to the end of the file.