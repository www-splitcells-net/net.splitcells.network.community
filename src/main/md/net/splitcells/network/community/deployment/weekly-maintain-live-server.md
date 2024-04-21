# Weekly maintain live server.
* Issue: https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/8
## Service
* The server is publicly available at http://live.splitcells.net
* Update server.
    * Restart server, in order to ensure, that every process uses the newest packages.
* Update deployed software. 
* Improve deployment and its processes.
## Open Tasks
* [ ] Automatically restart server after update installation.
    * [ ] Deploy server software as systemd user service.
        * [x] Create user service.
        * [x] Make user service reachable via network.
        * [x] Start user service on server start automatically.
        * [ ] Build image during build command and execute image during execute command.
          Currently, the build command builds the Java part and the execute command builds the container image.
            * [ ] Merge `worker.execute.*` commands into one `worker.execute` command.
                * [ ] `worker.execute` is command with file storage.
                    * [ ] Use more descriptive names for `$1` amd `$2`.
                * [ ] `worker.program` is command without file storage.
                * [ ] `worker.service` is command to execute command in detached mode.
            * [ ] Create `worker.build` command, in order to prepare the execution by creating the files needed for the execution.
            * [ ] Create flag for `worker.execute` command, in order to execute program based on files created via `worker.build`.
* [ ] Make default file storage locations more sane regarding Linux home folder standard.
    * [ ] Migrate files on live server accordingly.
* [ ] Manage upgrading major OS versions.
## Done Tasks
* [x] Make unattended-upgrades work.
* [x] Do not require `loginctl enable-linger` in order to run Podman container without ssh session,
  in order to ensure, that all programs of ssh sessions are closed.
  -> The container is now run via a systemd user service and therefore `loginctl enable-linger` is not needed anymore.
* [x] Create double checking for every config step. -> Check description is present in config script.