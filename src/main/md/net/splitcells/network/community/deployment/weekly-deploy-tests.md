# Weekly deploy tests.
Tests are executed on servers in order to ensure, that the software works on different CPUs.
* [ ] Add `worker.` prefix to deploy commands, as the related commands are part of the Network Worker.
    * [ ] `deploy.build.at`
    * [ ] `deploy.test.extensively.at`
* [ ] Execute tests in docker in order to avoid OS problems.
* [ ] Add test commands to `net.splitcells.martins.avots.distro` as this currently only relates to tests execute by Martins Avots. 