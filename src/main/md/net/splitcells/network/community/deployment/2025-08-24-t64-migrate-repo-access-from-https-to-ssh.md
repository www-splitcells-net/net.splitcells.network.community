# Migrate repo access from HTTPS to SSH
* Issue number: [\#51](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/64)
* Start Date: 2025-08-25
# Task Description
Currently, CI and deployment workflows are getting 429 error codes via HTTPS.
[This is because Codeberg is now more aggressively rejection HTTP request](https://fosstodon.org/@Codeberg@social.anoxinon.de/115074265802390489),
because of excessive network requests.
SSH is not blocked, because it is restricted to Codeberg users.
# Tasks
* [x] Codeberg CI via `continuous-integration.yml`.
* [x] Daily Workflow via `daily-test.yml`.
* [ ] `net.splitcells.martins.avots.distro.deploy.remote`
    * [ ] Sometimes git pulls are rejected by the Codeberg server. The reason for that is unkown.
        * [x] Avoid multiple pulls of all repos during one deployment run.
        * [ ] https://codeberg.org/Codeberg-CI/feedback/issues/271
        * [ ] Reuse SSH connections.
        * [ ] Support parallel pulling for speed up, via an environment flag.
# Reuse SSH connections via `~/.ssh/config`.
````
Host codeberg.org
  HostName codeberg.org
  User git
  Port 22
  # Reuse SSH connection
  ControlMaster auto
  ControlPath ~/.ssh/control-%r@%h:%p
  ControlPersist 10m
````