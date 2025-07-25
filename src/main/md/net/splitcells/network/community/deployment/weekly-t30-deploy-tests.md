# Weekly deploy tests.
* The issue number is [\#30](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/30).
# Task Description
Here manual or semiautomated tests are maintained and their results processed.
Some tests are executed on servers in order to ensure, that the software works on different CPUs or computer types.
# Services
* Check [daily full test on network hub](https://codeberg.org/splitcells-net/net.splitcells.network.hub/actions).
* Execute `net.splitcells.network.deploy.build.sh`.
* Maintain test servers.
    * `net.splitcells.martins.avots.riscv.login`
    * `net.splitcells.martins.avots.raspberry.v2.login`
    * Live Server
# Tasks
* [ ] Create command, in order to deploy tests on every test server.
    * [x] Create new worker command, in order to simply deploy bootstrapping via one command. See [here](../maintenance/done/2024-09-03-fully-bootstrap-network-worker.md).
      -> `worker.bootstrap.remote.at` is this command.
    * [x] Add flags to `bin/worker.execute` as an alternative to `--command` and `--class-for-execution`,
      that cds into to the bootstrapped repos on remote and executes a project command of `net.splitcells.network` inside a container.
      This makes it easier, to create an individual test command per test server.
      This is important for the RISCV server, that has a lot less resources.
        * [x] Draft new flag, by creating the appropriate `--comand`.
          -> ` bin/worker.execute  --name 'net.splitcells.network.worker' --command 'sh -c "cd ~/.local/state/net.splitcells.repos/public/net.splitcells.network && bin/worker.bootstrap"' --execute-via-ssh-at 'martins-avots@live.splitcells.net' --verbose true --use-host-documents true`
          -> A dedicated flag is not needed for that, as nothing special needs to be done.
        * [x] Use only 1 meta repo for bootstrapping. Currently `~/.local/state/net.splitcells.repos/public` and `~/.local/state/net.splitcells.network.worker/.local/state/net.splitcells.repos/public/` is used.
        * [x] Create flag as an alternative to --command, that bootstraps network worker repos and represents a remote server initialization.
          See `Remote Initialization Draft`. -> The dedicated `worker.service.cycle.trigger.at` command with just 1 argument was created instead. 
            * [x] Move boostrap step into `worker.bootstrap.remote.at` 
            * [x] Make this work with Raspberry Pi.
                * [x] Expand storage of Raspberry Pi via USB drive and use it for a new user's home.
                * [x] Clean storage of existing storage drive and check it via `df -h`.
                    * [x] `rm -rf Documents/projects/`
                * [x] Fix and document slow podman speed because of overlay on: https://github.com/containers/podman/discussions/21111
                * [x] Try speeding up the build by using docker. -> It is not an issue of Podman. The Raspberry PI is generally slower than in the past. I think it is because of the 2 USB sticks. Before that, the PI was a lot faster on 1 USB stick.
            * [x] Use this command, in order to set up and update live server repos.
            * [x] Delete unused containers: `podman system prune --all --yes`
            * [x] Deploy command as systemd one time task, where one does not wait on command exit.
              See `Old deploy.build.at` as a template, that was used in the past.
              Alternatively consider using `systemd-run --user [command]`, which may be easier to use, as the `Old deploy.build.at` template.
              Systemd-run may not require cleaning up failed builds.
    * [ ] CURRENT Create test command for network worker. 
        * [o] Delete network worker files, so that test command tests the bootstrap completely.
          -> This is not important for now. A corresponding TODO was added to the `worker.execute` script.
            * [o] command.repositories.install
            * [o] m2
            * [o] repos
        * [ ] Use new Network Worker Execute command for that.
        * [ ] Push test results to public network log repo.
            * [ ] Test this with local computer via `net.splitcells.network.worker.test.trigger.remote.at splitcells@splitcells-XPS-15-9570`.
              at `/home/splitcells/.local/state/net.splitcells.network.worker/.local/state/net.splitcells.network.worker/`.
                * [ ] Launch tests on other computer via `repos.test`.
                * [ ] Test result pulling.
                * [x] The shell project needs to be able to install itself to an alternative location.
                  Do this via an environment variable, as propagating such a value every would be hard.
                  Otherwise, such a test creates problems with already present shell installation. 
                    * [x] `command.managed.install.project.commands.py`
                    * [x] `command.managed.install.py`
                    * [x] Create a shell command to determine the path, where the shell project is installed.
                    * [x] `user.bin.configure.sh`
                    * [x] `user.command.delete.sh`
                    * [x] `user.command.disable.sh`
                    * [x] `user.command.install.sh`
                    * [x] `user.commands.install.sh`
                    * [x] `command.managed.environment.configure.sh`
                    * [x] `command.managed.execute.command.sh`
                    * [x] `command.managed.export.bin.sh`
                    * [x] `command.repositories.install.sh`
                    * [x] `command.repositories.setup.sh`
                    * [x] Define alternative config folder `~/.config/net.splitcells.shell`, in order to not mix worker config with the developer's computer config.
                        * [x] Define an environment variable, that points to the config folder.
                          -> It is called `NET_SPLITCELLS_SHELL_CONFIG_FOLDER`.
                        * [x] `command.repositories.update.sh`
                        * [x] `command.repositories.setup.sh`
                        * [x] `command.repository.register.sh`
                        * [o] Set up this environment variable during remote execution, by checking the presence of a config file intended for remote execution.
                          -> This is not required for the Network Worker Execution, as everything is executed in containers.
                            * [o] Support this in `worker.bootstrap`.
                            * [o] Support this in `worker.execute`.
                        * [o] Document why this is done. -> There is no useful Shell Project documentation for now, so this aspect is not important.
                    * [x] Remove any usage of `net.splitcells.shell.commands.disabled`. 
            * [ ] Store test results to network log repo.
            * [ ] Commit test results.
            * [ ] Push test results to Codeberg.
    * [ ] Enable this for all servers.
        * [ ] `net.splitcells.martins.avots.riscv.login` via `net.splitcells.network.worker.service.cycle.trigger.at ubuntu@riscv.local`
            * [x] On RISCV this requires `--security-opt=seccomp=unconfined` for Podman.
              -> Create a flag for worker execute, that add flags to the command defined in the file `~/.config/net.splitcells.network.worker/execute.podman.flags`.
              Use this flag in all worker executions of `net.splitcells.network.worker.service.cycle.trigger.at`.
            * [x] Optionally, avoid Playwright. -> Playwright is not installed by `network.worker` by default and can be enabled via `--use-playwright`.
              This is done, because Playwright is an OS dependency in this can always create problems.
              In RISCV this does not seem to work, for instance.
            * [ ] `net.splitcells.network.worker.service.cycle.trigger.at` should optionally avoid Playwright if configured.
              Determine this with a user config at `~/.config/net.splitcells.network.worker/playwright.supported` and act accordingly.
        * [ ] `net.splitcells.martins.avots.raspberry.v2.login` via `net.splitcells.network.worker.service.cycle.trigger.at network-worker@raspberrypi-v2.local`
            * [ ] Fix error with `worker.repos.test.trigger.remote.at`. See `journalctl -f` for the error message.
        * [ ] Live Server via `net.splitcells.network.worker.service.cycle.trigger.at ssh martins-avots@live.splitcells.net`
        * [ ] Daily Codeberg workflow.
        * [ ] Create a weekly execution script, that execute all tests of all reachable servers.
* [ ] `worker.test.at` (everything up until `test.everything` is tested via splitcells@raspberrypi-v2.local).
    * [ ] Ensure, that every test command writes test results into Network Log.
      See `test.extensively.via.network.worker` and consider Maven integration.
* [ ] Use ExtensiveTester on capable platforms.
* [ ] Upload Maven artifacts to Codeberg during daily workflow and update `Public Dependency Repository` of the document `DEVELOPMENT.md` accordingly.
* [ ] `test.everything` should verify the validity of the git data as well.
  Create a general repo check command for that as well.
    * [ ] Use `./bin/build.part.with.python`.
    * [ ] Use this in daily Codeberg workflow.
* [ ] Enable SonarCloud in Codeberg CI.
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
* [ ] Update test servers semi-automatically.
# Done Tasks
* [x] Warning in logs: `Corrupted STDOUT by directly writing to native stream in forked JVM 1. See FAQ web page and the dump file /home/splitcells/Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network/projects/net.splitcells.gel.ui/target/surefire-reports/2025-01-19T21-43-07_716-jvmRun1.dumpstream`
  -> This is caused by Playwright, which can be seen in the dumpstream. It causes performance problems, but nothing can be done, except for updating playwright to a more stable version.
* [x] Fix RISCV test server.
    * [x] Reset test server.
* [o] Only upload test coverage in daily Codeberg test. -> No test coverage is done via Codecov.
    * [o] Consider `export test_codecov=1`. -> Codecov will not be used anymore, because Codecov does not support reports across repos, which makes it hard to do this via hub repo.
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
net.splitcells.network.worker.bootstrap.remote.at network-worker@raspberrypi-v2.local
net.splitcells.network.worker.repos.test.trigger.remote.at network-worker@raspberrypi-v2.local
```
# Old deploy.build.at
```
#!/usr/bin/env python3
"""
SPDX-License-Identifier: EPL-2.0 OR GPL-2.0-or-later
SPDX-FileCopyrightText: Contributors To The `net.splitcells.*` Projects

Deploys a build of this repository to a server,
retrieves execution data and integrates these into the network log.

TODO Use user services (`~/.config/systemd/user/*`) in order to avoid root privileges for deployment on the target server.
"""

__author__ = "Mārtiņš Avots"
__authors__ = ["and other"]
__copyright__ = "Copyright 2022"
__license__ = "EPL-2.0 OR GPL-2.0-or-later"

import argparse
import subprocess
import logging
from os import environ

if __name__ == '__main__':
	if environ.get('log_level') == 'debug':
		logging.basicConfig(level=logging.DEBUG)
	argsParser = argparse.ArgumentParser(
		description="""Deploys the build process to a different server via a push mechanism.
This is useful, when the server is not always online or does not have access to a server hosting the repos.

Steps required on the target computer to set this up:
* The computer deploying the build process needs ssh access to the target server.
* Upload all repositories to the target server.
  This can be done via sshfs mounts or by cloning the repos from some other servers to the target server.
* Install all required software on the target server.
  This is usually Python 3 and Java 21.
* Configure git via `git config --global user.email && git config --global user.name`.
* Make sure that `~/.profile` exists and is executable.
  The file is allowed to be empty.
  Edit `~/.profile` and add required settings for the server (i.e. extending the PATH).

`journalctl --follow --unit build` can be used, in order to follow the log of the service in real time.
`systemctl status build` can be used, in order to check the state of the deployment.
Use `cat ~/Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network.log/target/test.via.network.worker.log` in order to view the build logs written to a file.

The main reason for ". ~/bin/net.splitcells.os.state.interface.commands.managed/command.managed.export.bin" is the fact,
that back then commands provided by the export where used by "./bin/test.via.network.worker".

TODO Execute Build in pod instead. See "live.splitcells.net".
""")
	argsParser.add_argument('--target-server', dest='targetServer', type = str, required = True)
	argsParser.add_argument('--user', type = str, required = True)
	argsParser.add_argument('--build-command', dest='buildCommand', type = str, required = False, default = './bin/test.via.network.worker')
	parsedArgs = argsParser.parse_args()
	buildScript = """
		git push {0}:/home/{1}/Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network master:net-splitcells-martins-avots-connection
		cd ../net.splitcells.network.bom
		git push {0}:/home/{1}/Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network.bom master:net-splitcells-martins-avots-connection
		cd ../net.splitcells.network
		ssh -t {0} sudo systemctl reset-failed # Ensure, that service instance of previous run is not present, in case the previous run failed.
		ssh -t {0} systemctl is-active build || ssh -t {0} sudo systemd-run --uid={1} --unit=build --working-directory='/home/{1}/Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network.bom' 'sh -c "git merge net-splitcells-martins-avots-connection && cd ../net.splitcells.network && git merge net-splitcells-martins-avots-connection && . ~/.profile && . ~/bin/net.splitcells.os.state.interface.commands.managed/command.managed.export.bin && {2}"'
		cd ../net.splitcells.network.log/
		if git ls-remote --heads {0}:/home/{1}/Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network.log master; then
			git pull --ff {0}:/home/{1}/Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network.log master
		else
			git pull --ff {0}:/home/{1}/Documents/projects/net.splitcells.martins.avots.support.system/public/net.splitcells.network.log main
		fi
		""".format(parsedArgs.targetServer, parsedArgs.user, parsedArgs.buildCommand)
	logging.debug('Executing: ' + buildScript)
	returnCode = subprocess.call(buildScript, shell='True')
	if returnCode != 0:
		exit(1)
```