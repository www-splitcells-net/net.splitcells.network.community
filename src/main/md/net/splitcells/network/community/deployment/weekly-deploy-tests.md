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
    * [x] Create new worker command, in order to simply execute such tests via one command. See [here](../maintenance/done/2024-09-03-fully-bootstrap-network-worker.md).
      -> `worker.bootstrap.remote.at` is this command.
    * [ ] Add flags to `bin/worker.execute` as an alternative to `--command` and `--class-for-execution`,
      that cds into to the bootstrapped repos on remote and executes a project command of `net.splitcells.network` inside a container.
      This makes it easier, to create an individual test command per test server.
      This is important for the RISCV server, that has a lot less resources.
        * [x] Draft new flag, by creating the appropriate `--comand`.
          -> ` bin/worker.execute  --name 'net.splitcells.network.worker' --command 'sh -c "cd ~/.local/state/net.splitcells.repos/public/net.splitcells.network && bin/worker.bootstrap"' --execute-via-ssh-at 'martins-avots@live.splitcells.net' --verbose true --use-host-documents true`
          -> A dedicated flag is not needed for that, as nothing special needs to done.
        * [x] Use only 1 meta repo for bootstrapping. Currently `~/.local/state/net.splitcells.repos/public` and `~/.local/state/net.splitcells.network.worker/.local/state/net.splitcells.repos/public/` is used.
        * [ ] Create flag as an alternative to --command, that bootstraps network worker repos and represents a remote server initialization.
          See `Remote Initialization Draft.
            * [ ] Make this work with Raspberry Pi.
                * [ ] Expand storage of Raspberry Pi via USB drive and use it for a new user's home.
                * [x] Clean storage of existing storage drive and check it via `df -h`.
                    * [x] `rm -rf Documents/projects/`
            * [ ] Use this command, in order to set up and update live server repos. 
        * [ ] Execute project command.
    * [ ] Create test command for network worker.
    * [ ] Enable this for all servers.
        * `net.splitcells.martins.avots.riscv.login`
        * `net.splitcells.martins.avots.raspberry.v2.login`
        * Live Server
        * Daily Codeberg workflow.
* [ ] `test.everything` should verify the validity of the git data as well.
  Create a general repo check command for that as well.
    * [ ] Use `./bin/build.part.with.python`.
    * [ ] Use this in daily Codeberg workflow.
* [ ] Enable benchmark tests.
* [ ] Add live server as normal test server.
* [ ] Enable all runtime checks during tests like `StaticFlags.ENFORCING_UNIT_CONSISTENCY_KEY`.
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
* [ ] Execute integration tests.
* [ ] Delete Maven caches every month.
* [ ] Ensure that all `./bin/*` commands are tested as well.
* [ ] Execute tests in public CI via general test command.
  The CI hoster specific setup, like repo cloning should stay in CI hoster specific config files.
  This is CI hoster specific and not worth generalizing,
  as there are problems like cloning repos hoster independently is complex,
  when one wants to avoid that all CI hosters clone the repos from the same git hoster.
# Done Tasks
* [x] Fix RISCV test server.
    * [x] Reset test server.
* [o] Only upload test coverage in daily Codeberg test. -> No test coverage is done via Codecov.
    * [o] ***CURRENT*** Consider `export test_codecov=1`. -> Codecov will not be used anymore, because Codecov does not support reports across repos, which makes it hard to do this via hub repo.
    * [x] Disable test coverage report in CI.
# Remote Execution Draft
````
bin/worker.execute \
	--name=net.splitcells.network.worker \
	--executable-path='bin/worker.bootstrap' \
	--publish-execution-image=true

bin/worker.execute \
    --name=net.splitcells.network.worker \
    --executable-path='bin/worker.bootstrap' \
    --cpu-architecture=riscv64
````
# Remote Initialization Draft
```
# Create main boostrapping repo.
  ssh -t splitcells@raspberrypi-v2.local 'test -d ~/.local/state/net.splitcells.network.worker/.local/state/net.splitcells.repos/public/net.splitcells.network || mkdir -p ~/.local/state/net.splitcells.network.worker/.local/state/net.splitcells.repos/public/ && cd ~/.local/state/net.splitcells.network.worker/.local/state/net.splitcells.repos/public/ && git clone https://codeberg.org/splitcells-net/net.splitcells.network.git'
# Update bootstrapping step. This is not needed most of the time.
  ssh -t splitcells@raspberrypi-v2.local 'cd ~/.local/state/net.splitcells.network.worker/.local/state/net.splitcells.repos/public/net.splitcells.network && bin/worker.bootstrap'
# Update network worker's repos.
  ssh -t splitcells@raspberrypi-v2.local 'cd ~/.local/state/net.splitcells.network.worker/.local/state/net.splitcells.repos/public/net.splitcells.network && bin/worker.bootstrap.container'
# Build software via network worker.
  ssh -t splitcells@raspberrypi-v2.local 'cd ~/.local/state/net.splitcells.network.worker/.local/state/net.splitcells.repos/public/net.splitcells.network && bin/worker.repo.build'
```