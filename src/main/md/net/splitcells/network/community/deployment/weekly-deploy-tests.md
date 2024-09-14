# Weekly deploy tests.
Tests are executed on servers in order to ensure, that the software works on different CPUs.
The issue number is [\#30](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/30).
# Services
* Check [daily full test on network hub](https://codeberg.org/splitcells-net/net.splitcells.network.hub/actions).
* Execute `net.splitcells.network.deploy.build.sh`.
# Tasks
* [ ] Execute full test via Codeberg every day automatically for all repos.
    * [ ] ***CURRENT*** Create and use a script file for the full test, that can be used by any runner/executor.
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