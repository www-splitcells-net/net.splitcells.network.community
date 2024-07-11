# Weekly deploy tests.
Tests are executed on servers in order to ensure, that the software works on different CPUs.
# Services
* [ ] Check daily full test.
# Tasks
* [ ] Execute full test via Codeberg every day automatically for all repos.
    * [ ] Create and use a script file for the full test, that can be used by any runner/executor.
    * [ ] Test that code complies with custom Java subset grammar.
    * [ ] Execute integration test.
    * [ ] Test all CSV pages and also their charts.
* [ ] Add `worker.` prefix to deploy commands, as the related commands are part of the Network Worker.
    * [ ] `deploy.build.at`
    * [ ] `deploy.test.extensively.at`
    * [ ] Use `worker.execute` command in order to run all commands inside container and thereby to ease updates of host OS.
* [ ] Execute tests in docker in order to avoid OS problems.
* [ ] Add test commands to `net.splitcells.martins.avots.distro` as this currently only relates to tests execute by Martins Avots. 