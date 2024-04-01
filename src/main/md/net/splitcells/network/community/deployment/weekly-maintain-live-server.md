# Weekly maintain live server.
* Issue: https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/8
## Service
* The server is publicly available at http://live.splitcells.net:8080
* Update server.
    * Restart server, in order to ensure, that every process uses the newest packages.
* Update deployed software.
    * `cd Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network.distro/` 
    * `bin/build.on.server.via.podman` 
* Improve deployment and its processes.
## Tasks
* [x] Make unattended-upgrades work.
* [ ] Automatically restart server after update installation.
    * [ ] Deploy server software as systemd user service.
        * [x] Create user service.
        * [x] Make user service reachable via network.
        * [x] Start user service on server start automatically.
        * [ ] Build image during build command and execute image during execute command.
          Currently, the build command builds the Java part and the execute command builds the container image.
* [ ] Do not require `loginctl enable-linger` in order to run Podman container without ssh session,
  in order to ensure, that all programs of ssh sessions are closed.
* [x] Create double checking for every config step. -> Check description is present in config script.
* [ ] Manage upgrading major OS versions.