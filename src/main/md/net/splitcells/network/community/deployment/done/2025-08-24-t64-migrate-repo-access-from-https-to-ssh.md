# Migrate repo access from HTTPS to SSH
* Issue number: [\#51](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/64)
* Start Date: 2025-08-24
* Start Date: 2025-08-26
* Codeberg CI Issue: https://codeberg.org/Codeberg-CI/feedback/issues/271
# Task Description
Currently, CI and deployment workflows are getting 429 error codes via HTTPS.
[This is because Codeberg is now more aggressively rejection HTTP request](https://fosstodon.org/@Codeberg@social.anoxinon.de/115074265802390489),
because of excessive network requests.
SSH is not blocked, because it is restricted to Codeberg users.
# Tasks
* [x] Codeberg CI via `continuous-integration.yml`.
* [x] Daily Workflow via `daily-test.yml`.
* [x] `net.splitcells.martins.avots.distro.deploy.remote`
    * [x] Sometimes git pulls are rejected by the Codeberg server. The reason for that is unkown.
        * [x] Avoid multiple pulls of all repos during one deployment run.
        * [o] https://codeberg.org/Codeberg-CI/feedback/issues/271 -> This issue is going to be completed outside this project
        * [o] Create optional standardized setup (i.e. `set -x`) commands for any script.
          -> Setting up SSH reuse is done via `bin/user.ssh.setup` instead, which is executed during bootstrapping.
        * [x] Reuse SSH connections via a flag, that is disabled by default, in order to not change the user's config.
        * [x] Support parallel pulling for speed up, via an environment flag.
          -> Pulls are always done in parallel. The pull rejections are fixed by enabling SSH connection reuse instead.
# Reuse SSH connections via `~/.ssh/config`.
````
Host *
  # Reuse SSH connection
  ControlMaster auto
  ControlPath ~/.ssh/connection-%r@%h-%p
  ControlPersist 10m
````