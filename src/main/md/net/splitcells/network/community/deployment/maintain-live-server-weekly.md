# Maintain live server weekly
## Service
* The server is publicly available at http://live.splitcells.net:8080
* Update server.
    * Restart server, in order to ensure, that every process uses the newest packages.
* Update deployed software.
    * `cd Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network.distro/` 
    * `bin/build.on.server.via.podman` 
* Improve deployment and its processes.
## Tasks
* [ ] Make unattended-upgrades work.
* [ ] Do not require `loginctl enable-linger` in order to run Podman container without ssh session,
  in order to ensure, that all programs of ssh sessions are closed..
* [ ] Create double checking for every config step.
* [ ] Manage upgrading major OS versions.