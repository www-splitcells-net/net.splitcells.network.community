# Maintain live server weekly
* The server is publicly available at http://live.splitcells.net:8080
* Update server.
    * Restart server, in order to ensure, that every process uses the newest packages.
* Update deployed software.
* Improve deployment and its processes.
* [ ] Do not require `loginctl enable-linger` in order to run Podman container without ssh session,
  in order to ensure, that all programs of ssh sessions are closed..