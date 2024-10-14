# Weekly deploy tests.
Tests are executed on servers in order to ensure, that the software works on different CPUs.
The issue number is [\#30](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/30).
# Services
* Check [daily full test on network hub](https://codeberg.org/splitcells-net/net.splitcells.network.hub/actions).
* Execute `net.splitcells.network.deploy.build.sh`.
* Maintain test servers.
    * `net.splitcells.martins.avots.riscv.login`
    * `net.splitcells.martins.avots.raspberry.v2.login`
    * Live Server
# Tasks
* [ ] Create command, in order to deploy tests on every test server.
    * [ ] Create new worker command, in order to simply execute such tests via one command. See [here](../maintenance/2024-09-03-fully-bootstrap-network-worker.md).
    * [ ] Enable this for all servers.
        * `net.splitcells.martins.avots.riscv.login`
        * `net.splitcells.martins.avots.raspberry.v2.login`
        * Live Server
* [ ] Add live server as normal test server.
* [ ] Fix RISCV test server.
    * [ ] Reset test server.
    * [ ] Try configuring fan control: https://www.youtube.com/watch?v=_JNxsbqLX5c
* [ ] Create aggregate code coverage report via jacoco and adding it to the static website via a dedicated jacoco log repo.
    * [x] Create aggregate report.
    * [ ] Add all projects to aggregate report.
    * [ ] Ensure, that code coverage across projects is considered in the aggregate report.
    * [ ] `jacoco.overall.exec` is probably not needed as `report-aggregate` already does the job.
    * [ ] Remove codecov badge from hub project and deregister from codecov.
* [ ] Execute full test via Codeberg every day automatically for all repos.
    * [ ] Create and use a script file for the full test, that can be used by any runner/executor.
        * [ ] Create commands for pulling all repos.
            * [x] Ensure that SSH is working for that.
            * [ ] Clean up pull commands.
        * [ ] Create commands for building all repos.
        * [ ] Place all commands into one file.
    * [ ] Test that code complies with custom Java subset grammar.
    * [ ] Execute integration test.
    * [ ] Test all CSV pages and also their charts.
* [ ] Automatically run tests on test servers.
    * [ ] Pull and push from Codeberg in order to simplify fully automatic test deployments.
        * [ ] Pull all repos.
        * [ ] Push `net.splitcells.network.log`.
    * [ ] Run test service as a podman user service daily.
    * [ ] Run on test server via own Podmand service, instead of via runners, because the logs are public in Codeberg.
      These public logs could cause leaks of private SSH keys for Codeberg.
* [ ] Add `worker.` prefix to deploy commands, as the related commands are part of the Network Worker.
    * [ ] `deploy.build.at`
    * [ ] `deploy.test.extensively.at`
    * [ ] Use `worker.execute` command in order to run all commands inside container and thereby to ease updates of host OS.
* [ ] Execute tests in Docker/Podman in order to avoid OS problems.
* [ ] Add test commands to `net.splitcells.martins.avots.distro` as this currently only relates to tests execute by Martins Avots.
# Done Tasks
* [o] Only upload test coverage in daily Codeberg test. -> No test coverage is done via Codecov.
    * [o] ***CURRENT*** Consider `export test_codecov=1`. -> Codecov will not be used anymore, because Codecov does not support reports across repos, which makes it hard to do this via hub repo.
    * [x] Disable test coverage report in CI.