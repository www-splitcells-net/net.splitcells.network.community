# Improve licensing practices

* Issue number: [\#49](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/49)

# Task Description
We want all license metadata to be present and to be correct.
We also need full accounting for it.
# Tasks

* [x] https://www.it-cisq.org/software-bill-of-materials/index.htm
* [ ] Use https://reuse.software/ in order to check licensing in source code.
    * [x] Use tmp branch for this experiment.
    * [x] https://reuse.software/tutorial/
        * [x] `reuse init`
        * [x] `~/.local/bin/reuse lint`
    * [ ] Check this in daily CI for all repos. Just create the workflow for now. The actual license info will be fixed via the weekly test deployments task.
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