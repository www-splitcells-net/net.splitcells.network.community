# Improve licensing practices

* Issue number: [\#49](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/49)

# Task Description
We want all license metadata to be present and to be correct.
We also need full accounting for it.
# Tasks

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
* [ ] Improve licensing info on deployed website.
    * [ ] Licensing of images
    * [ ] List license of every page centrally.
    * [ ] Show license of every page on every page.
    * [x] Link to `NOTICE.md` and `LICENSE.md`.
* [ ] Ensure, that every repo has proper licensing data.
* [ ] `test.everything` should verify license data as well.
* [ ] Simplify Java's license header, in order to simplify Java files and make them shorter.
  Document that the Linux kernel uses the same format and that such a header is REUSE compliant as well.