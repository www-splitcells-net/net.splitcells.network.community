# Consider compatibility with git-repo-manager.
* Issue number: [\#53](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/53)
# Task Description
Make repos process compatible to git-repo-manager and consider using it as a gui for meta repos,
where repos process is mainly used for creating configs for tools and meta repos coordination like backups and synchronization.
Offer git-repo-manager cooperation so these tools are compatible with each other,
both understand the same simplistic file format for repo inventory files.
# Old Acceptance Note
Instead of creating a very loose cooperation,
it was decided to just make repo process advertisable and to advertise it.
A cooperation would currently cost too many resources,
as the results of this task would not be essential to the projects main goal.
Furthermore, repo process is probably not that important for other developers.
# Tasks
# Done Tasks
* [x] Clean up existing repos process doc.
    * [x] Proofread the doc.
        * [x] `projects/net.splitcells.project/src/main/md/net/splitcells/project/repo/repos.process.md`
            * [x] Note that the implementation of this software was completely incorrectly done.
        * [x] `projects/net.splitcells.project/src/main/md/net/splitcells/project/repo/repos.process.examples.md`
        * [x] `projects/net.splitcells.project/src/main/md/net/splitcells/project/repo/repos.process.help.md`
    * [x] Rename all appearances of `net.splitcells.osi.*` with `net.splitcells.project.*`
        * [x] `net.splitcells.osi.repos.children` -> `net.splitcells.repos.children`
        * [x] `net.splitcells.osi.repos.peers` -> `net.splitcells.shell.repos.peers`
            * [x] Support old and new naming first.
            * [x] Remove old name usage.
        * [x] `net.splitcells.osi.repos.hosts`
            * [x] Support old and new naming first.
            * [x] Remove old name usage.
    * [x] Define different focus of git-repo-manager and repos process. -> That is already present.
    * [x] Advertise repo process on README, as I think, that such functionality is essential for distributed software development.
        * [x] The shell's README is not rendered correctly: https://splitcells.net/net/splitcells/shell/README.html
            * [x] Provide top level MDs like the README as a normal resource under `src/main/md/[artifact id + groupid]/*`
              This way a dedicated extension for READMEs is not required.
            * [x] Fix top level file rendering, when the local file system is used via DevCellDistro.
            * [x] Remove dedicated extensions for all top level files
* [x] Move file containing all child repos to bin folder, in order to simplify file layout.
* [x] Source: https://github.com/hakoerber/git-repo-manager
* [x] Build and test GRM: Create setup instructions for Ubuntu:
    * [x] https://hakoerber.github.io/git-repo-manager/developing.html
```
sudo apt install --no-install-recommends python3 docker.io docker-compose black shellcheck
sudo apt install rustup # cargo and rustc should not be installed as otherwise the nightly toolchain cannot be used via rustup.
cd Documents/projects/
git clone git@github.com:hakoerber/git-repo-manager.git
cd git-repo-manager
rustup toolchain install nightly
cargo +nightly install git-repo-manager
```
* [x] How to use nightly cargo build, as otherwise build does not work?
  For more information about this error, try `rustc --explain E0554`.
  error: could not compile `git-repo-manager` due to 2 previous errors
```

error[E0554]: `#![feature]` may not be used on the stable release channel
 --> src/lib.rs:1:12
  |
1 | #![feature(io_error_more)]
  |            ^^^^^^^^^^^^^

error[E0554]: `#![feature]` may not be used on the stable release channel
 --> src/lib.rs:2:12
  |
2 | #![feature(const_option_ext)]
  |            ^^^^^^^^^^^^^^^^

```
* [x] Document right management: Adding and removing such repos manually just takes time.
* [x] https://github.com/Krasjet/grm
* [o] Create good documentation for `repo.process`.
    * [o] There should be one main document, that provides overview of all documents and main goals of repo process.
        * [o] Main goal is to provide the simplest most portable config format, repo structure and workflows.
          It has to be as easy as possible to make this compatible to other software (in worst case via config file generation).
    * [x] Local Path Context is not working for CommonMark files in OS state interface repo. Strangely, the problem only appears at this repo.
    * [x] Create strategy for help text and documentation page. Maybe descriptions should always be CommonMark format.
      Execute command for documentation, but with an environment variable being set, which disables any effects. -> Use dedicated help commands. This may also enable documentation injection in the future. Such commands are placed in `src/doc/[source language]`. -> Use normal documentation files in this case instead, because it is
    * [x] Link to relevant blog article: https://splitcells-net.srht.site/blog/2022-01-10-a-case-for-repo-process/
    * [x] Improve `--help` documentation.
    * [x] Make `repo.process --help` available on the website instead of help message. Later, this document can be made available to the `repo.process` command. This is not relevant for now, because of the low number of users.
    * [o] Explain where repo info is stored and what the format is.
        * [x] Simplify `subs.json` as it is too complex at the moment.
        * [o] Document `sub-repo-names`.
        * [o] Implement and document `peer-repo-names`.
    * [o] Use monospace fonts for code blocks, in order to better represent repo structure. Document why monospace font is used.
* [o] Make git-repo-manager compatible to repo process.
    * [o] https://toml.io/en/
* [x] Create git-repo-manager config via `repo.process`.
    * `repo.process --command='grm repos find local $(pwd) --format yaml' > ../config.yml`
    * Remove all occurrences of `trees:` except the first one in the resulting `../config.yml`, in order to make it correct.
    * This may have become obsolete, because of https://github.com/hakoerber/git-repo-manager/issues/49 , https://github.com/hakoerber/git-repo-manager/pull/53
* [o] Consider git-repo-manager an alternative to `repo.process` and document results.
  Document the difference between the 2 and under which condition `repo.process` might become obsolete.
    * [o] How to add new remote for all repos.
    * [o] Generate config via repo process and do git actions via GRM.
    * [o] Repo process is more portable, because of Python and fewer dependencies.
* [o] Contact maintainer (seems to be German) and inform him about the compatibility provided by repo process.
    * [o] Propose a forge integration via a local executable, that generates the config.
      This can be helpful for integration with other software, because in this case even simple shells scripts could be used.
      This can also be used for repos, that list all available repos.
      : https://hakoerber.github.io/git-repo-manager/forge_integration.html
* [o] Important repo process improvements, that I noticed in general during the comparison with git-repo-manager.
    * [o] Store sub repo info in more simple files.
    * [o] Improve peer repo handling.
    * [o] Always require $peerRepo and $supRepo inside remote URLs, except when a special flag is given.
    * [o] Cloning from GitHub and co was not tested and does not work: `repo.clone git@github.com:www-splitcells-net/net.splitcells.network.git`. This is also the case for `repo.clone.into.current` etc..