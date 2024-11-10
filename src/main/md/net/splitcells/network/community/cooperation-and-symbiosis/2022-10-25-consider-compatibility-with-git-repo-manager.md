# Consider compatibility with git-repo-manager
* Issue number: [\#53](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/53)
# Task Description
Make repos process compatible to git-repo-manager and consider using it as a gui for meta repos,
where repos process is mainly used for creating configs for tools and meta repos coordination like backups and synchronization.
Offer git-repo-manager cooperation so these tools are compatible with each other,
both understand the same simplistic file format for repo inventory files.
# Tasks
* [ ] Clean up this issue.
* [ ] Clean up existing repos process doc.
* [ ] https://github.com/Krasjet/grm
* [ ] Define different focus of git-repo-manager and repos process.
* [x] Move file containing all child repos to bin folder, in order to simplify file layout.
* [ ] Add projects files standard to project list on website:
    * [ ] https://splitcells.net/net/splitcells/project/files/standard/repo/repo.process.html
    * [ ] https://splitcells.net/net/splitcells/martins/avots/website/projects/index.html
    * [ ] Consider adding a generic project overview capability to website server.
    * [ ] Add guidelines to this new project regarding backward compatibility: first deprecate with warning, then disable by default and then remove the feature.
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

* [ ] Create good documentation for `repo.process`.
    * [ ] There should be one main document, that provides overview of all documents and main goals of repo process.
        * [ ] Main goal is to provide the simplest most portable config format, repo structure and workflows.
          It has to be as easy as possible to make this compatible to other software (in worst case via config file generation).
    * [x] Local Path Context is not working for CommonMark files in OS state interface repo. Strangely, the problem only appears at this repo.
    * [x] Create strategy for help text and documentation page. Maybe descriptions should always be CommonMark format.
      Execute command for documentation, but with an environment variable being set, which disables any effects. -> Use dedicated help commands. This may also enable documentation injection in the future. Such commands are placed in `src/doc/[source language]`. -> Use normal documentation files in this case instead, because it is
    * [x] Link to relevant blog article: https://splitcells-net.srht.site/blog/2022-01-10-a-case-for-repo-process/
    * [x] Improve `--help` documentation.
    * [x] Make `repo.process --help` available on the website instead of help message. Later, this document can be made available to the `repo.process` command. This is not relevant for now, because of the low number of users.
    * [ ] Explain where repo info is stored and what the format is.
        * [x] Simplify `subs.json` as it is too complex at the moment.
        * [ ] Document `sub-repo-names`.
        * [ ] Implement and document `peer-repo-names`.
    * [ ] Use monospace fonts for code blocks, in order to better represent repo structure. Document why monospace font is used.
* [ ] Make git-repo-manager compatible to repo process.
    * [ ] https://toml.io/en/
* [x] Create git-repo-manager config via `repo.process`.
    * `repo.process --command='grm repos find local $(pwd) --format yaml' > ../config.yml`
    * Remove all occurrences of `trees:` except the first one in the resulting `../config.yml`, in order to make it correct.
    * This may have become obsolete, because of https://github.com/hakoerber/git-repo-manager/issues/49 , https://github.com/hakoerber/git-repo-manager/pull/53
* [ ] Consider git-repo-manager an alternative to `repo.process` and document results.
  Document the difference between the 2 and under which condition `repo.process` might become obsolete.
    * [ ] How to add new remote for all repos.
    * [ ] Generate config via repo process and do git actions via GRM.
    * [ ] Repo process is more portable, because of Python and fewer dependencies.
* [ ] Contact maintainer (seems to be German) and inform him about the compatibility provided by repo process.
    * [ ] Propose a forge integration via a local executable, that generates the config.
      This can be helpful for integration with other software, because in this case even simple shells scripts could be used.
      This can also be used for repos, that list all available repos.
      : https://hakoerber.github.io/git-repo-manager/forge_integration.html
* [ ] Important repo process improvements, that I noticed in general during the comparison with git-repo-manager.
    * [ ] Store sub repo info in more simple files.
    * [ ] Improve peer repo handling.
    * [ ] Always require $peerRepo and $supRepo inside remote URLs, except when a special flag is given.
    * [ ] Cloning from GitHub and co was not tested and does not work: `repo.clone git@github.com:www-splitcells-net/net.splitcells.network.git`. This is also the case for `repo.clone.into.current` etc..
# Done Tasks
* [x] Document right management: Adding and removing such repos manually just takes time.
# Tasks for future
* [ ] Provide dry mode.