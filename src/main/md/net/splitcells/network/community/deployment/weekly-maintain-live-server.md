# Weekly maintain live server.
* Issue number: [\#8](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/8)
## Service
* The server is publicly available at http://live.splitcells.net
* Update server.
    * Restart server, in order to ensure, that every process uses the newest packages.
    * Upgrade major version of OS when available.
    * Update deployed software
* Improve deployment and its processes.
* Test security
* Test legalities and privacy policy. 
## Open Tasks
* [ ] Correct deployment via worker on live server. Currently, it is completely broken as the file paths have changed.
* [ ] Avoid logging to stdout and stderr, in order to have a clean systemd log.
* [ ] Pull source code from Codeberg instead of GitHub.
* [ ] Update certificates for ACME automatically, in order to avoid these expiring during production.
* [ ] Create and user generic `worker.execute` command, in order to make things portable regarding the infrastructure.
    * [ ] Deploy server software as systemd user service.
        * [x] Create user service.
        * [x] Make user service reachable via network.
        * [x] Start user service on server start automatically.
        * [ ] Build image during build command and execute image during execute command with `net.splitcells.network/bin/worker.execute`,
          instead of  `net.splitcells.network.worker/bin/worker.execute`.
          Currently, the build command builds the Java part and the execute command builds the container image.
            * [x] Merge `worker.execute.*` commands into one `worker.execute` command.
                * [x] `worker.execute` is command with file storage.
                    * [x] Use more descriptive names for `$1` amd `$2`.
                * [x] `worker.program` is command without file storage.
                * [x] `worker.service` is command to execute command in detached mode.
            * [ ] Add parameter to `worker.execute` in order to build a project at the current folder in a standardized way.
                * [ ] Consolidate `worker.repo.build`.
            * [ ] Create flag for `worker.execute` command, in order to execute program based on files created via `worker.build`.
            * [ ] Create flag in order to execute program as a persisten service.
    * [ ] Delete obsolete `net.splitcells.network.worker` repo.
    * [ ] Use this command for existing test deployment commands as well.
      This tests whether this new command is portable or not. 
        * [ ] `deploy.build.at`
        * [ ] `deploy.test.extensively.at`
    * [ ] Build everything via `mvn clean install` at `net.splitcells.network.hub`.
* [ ] Automatically and continuously check, if the SSL certificate for HTTPS is still valid
  and replace it automatically.
* [ ] Execute the complete test suite on live server periodically and commit result data to network log.
* [ ] Automatically restart server after update installation.
* [ ] `apt upgrade` packages are seemingly not installed by unattended-upgrades.
  This is required for Linux kernel updates. 
* [ ] Make default file storage locations more sane regarding Linux home folder standard.
    * [ ] Migrate files on live server accordingly.
* [ ] Manage upgrading major OS versions.
* [ ] The corresponding systemd service should only store logs up to 7 days.
* [ ] Make private setup script public, in order to have a basis for default setup script for a server.
* [ ] Run Forgejo Runner via Podman in order to not require root rights for Forgejo Runner: https://code.forgejo.org/forgejo/runner/src/branch/main/scripts/systemd.md
* [ ] Execute runtime profiling for long-running instances and store these,
  in order to improve day to day performance via [Grafana and Pyroscope](https://grafana.com/docs/pyroscope/latest/get-started/).
* [ ] Do not log already logged message, in order to simplify logs on live server.
* [ ] Do not output logs to standard output by default,
  in order to have minimal OS logs.
* [ ] Consider to migrate from Podman to Kubernetes, in order to support the most common deployment technology.
  Also, supporting Kubernetes implicitly supports Podman and Docker as well regarding the container images.
* [ ] When there is not enough memory and podman restart the pod,
  the old pod cannot be killed.
  But a new pod is executed, which leads to a broken podman instance.
  -> Consider docker swarm or even micro k8s.
* [ ] Consider creating double book-keeping for config files, in order to check ones, that are not used.
  Abort the software, when such an unused file is found.
* [ ] Create backup of files.
* [ ] Do disaster recovery tests.
* [ ] Avoiding sharing document files in `worker.execute` by default.
## Done Tasks
* [x] Automatic upgrade does not always work. There is sometimes a difference between unattended-upgrades
  (with apt-daily and apt-daily-upgrade) and `apt update && apt upgrade --yes`.
    * [o] Create own automatic restart service, if this gets too complicated. It already cost too many hours.
      Also keep in mind that unattended-upgrades config is very complex and therefore already an argument in itself to replace it with simple custom command.
      Especially, when the debug log is so bad, because one does not see the concrete APT/dpkg actions in the log.
      If this is done, document this reasoning.
      -> The unattended-upgrades usage is fixed, so this is not needed for now.
    * [x] Check if unattended-upgrades is working with some fixes.
        * [ ] If this works, persist fixes in private git repo.
        * [x] Try solving the problem via Origins-Pattern of `"origin=*";` and `"o=*";`.
        * [x] Expand `/etc/apt/apt.conf.d/20auto-upgrades` with `APT::Periodic::Enable "1";`.
        * [x] Expand `/etc/apt/apt.conf.d/50unattended-upgrades` with `Unattended-Upgrade::SyslogEnable "true";Unattended-Upgrade::SyslogFacility "daemon";Unattended-Upgrade::Verbose "true";`.
        * [x] Expand `/etc/apt/apt.conf.d/50unattended-upgrades` with `Unattended-Upgrade::Debug "false";`.
* [x] Make unattended-upgrades work.
* [x] Do not require `loginctl enable-linger` in order to run Podman container without ssh session,
  in order to ensure, that all programs of ssh sessions are closed.
  -> The container is now run via a systemd user service and therefore `loginctl enable-linger` is not needed anymore.
* [x] Create double checking for every config step. -> Check description is present in config script.