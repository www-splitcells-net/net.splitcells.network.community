# Port Shell project to Java and the Network Worker
* Issue number: [\#59](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/59)
# Task Description
Until now, it was assumed, that Sh and Python 3 are required for bootstrapping the project and
that Java and Maven would be the main software stack.
Sh would be used for simple tasks and Python for complex ones,
that had none trivial control flow for instance.
Sh and Python 3 are chosen for bootstrapping on local and remote systems,
as most Linux distros have these right out of the box.

I noticed, that Python 3 and Java/Maven have kind of the same amount of operating system dependencies.
From an abstract installation point of view, it should not make a large difference,
also in practice installing the newest Java version in Linux is sometimes harder than for Python,
as some Distros provide the latest Java version relatively late in their main software repos.
On the other hand, it seems to be easier to manage Java dependencies in Java/Maven, than in Python,
especially as I have a lot of experience in Java/Maven.
This creates the first doubts, that Python is required for bootstrapping the project.

Furthermore, the commands in order to build the project with Maven are actually very simple and
can be easily handled via Sh.
Initial cloning and later pulling of the git repos are already done via Sh in the Network Hub in a `repo.process` compatible way.
Bootstrapping the software on a local server is therefore easy with just sh, git, Java and Maven.
Bootstrapping the software on a remote server, would be easy as well,
as the current Python code just generates appropriate Dockerfiles, scripts and SSH commands.
This can easily be done in Java and Maven as well.

This means, that Python 3 itself does not provide much bootstrapping functionality,
but adds another language, which creates complexity.
Also, it is planned to port a big part of the Python based Shell and Network Worker project into the equivalent Java projects as well,
as things like repo synchronization via `repo.process` are useful via a GUI or for automated workflows in production.

Providing commands to the local shell, can be easily done with Java as well.
Instead of copying the commands to the appropriate bin folder for the installation of the Shell project,
the Java version could generate commands for the appropriate bin folder.
These sh commands would call Java with the jar located in the fitting subfolder of `.m2` with a fixed Shell project specific Java class as the main entry point.
The command to be executed by such a wrapper script and the parameters passed to the requested command,
would just be passed further down to the Java call.
The Java jar would contain all Java and Shell etc. files.

If Java's startup time is too slow for every shell call from the bin folder,
one could start the Java jar as a background daemon to which the command calls are dispatched.
The project Mvnd does the same for Maven.

Therefore, it is decided to port the main Sh and Python parts of the Shell and Network Worker projects into Java and
integrate it into the rest of the Java projects.
When the new code supports the full functionality of the main Sh and Python parts,
these parts are to be replaced by appropriate Sh commands delegating their tasks to the Java parts.

This makes the following possible:
* Provide the full Shell and Network Worker functionality in production for the main Java modules (i.e. UI and Network Log synchronization).
* Avoid code duplication and reduce code complexity.
* Simplify dependencies.
* Makes it possible to use the Java/Maven coding and deployment experience for this functionality as well.
  Therefore, this avoids learning everything about Python coding and deployment.
  Especially, changing functionality backwards compatible is alot easier with the statically typed Java than the dynamically typed Python.
* Simplify writing tests for such functions, which sometime got broken for the Python parts as tests are harder to write and execute for these.
* Make it easier to generate simple setup scripts for servers without requiring a full Shell project installation on the target server.
# Tasks
* [x] Python is important for complex scripts and therefore Python should not be deprecated.
  If Python is not deprecated, there is no need for a Java implementation of worker execute and
    * [x] Update this project accordingly.
    * [x] Undo deprecation of Python.
    * [x] Document, when Python implementation of network worker and repo process should be replaced by a Java implementation.
      Note, that in this case the implementation should be fully replaced, in order to avoid duplicate implementations.
    * [x] Document why Python is not desired by that much in this project and why it was not removed from this project.
* [ ] Clean up worker execution.
    * [ ] Move Java improvements to Python.
        * [ ] Create `worker.execute.py` and prepare it as the new worker execution version.
            * [x] Port code.
                * [x] Port CLI argument parsing.
                * [x] Port remote execute code.
                * [x] Port local execute code.
                * [x] Port extended CLI argument parsing.
                * [x] Standardize variable naming.
                * [x] Use more portable parameter substitution via `${variable-name}` in worker execution via the substitute method of Python.
                * [x] Only use multi line strings for templating.
                * [x] Check that only one of the required is actually present and not multiple ones.
            * [ ] Create unit test like in Java version.
                * [ ] Disable test logs, when the command is executed normally.
                * [ ] Use hyphens for all argument names in remote execution script.
            * [x] Add self test to worker execute, that is executed for each worker execute call.
              This makes sure, that any code change to the worker execution does not break it.
            * [ ] Implement `--is-daemon`, in order to simplify liver server deployment on fresh server.
            * [ ] Make flat folder true by default and after that, remove this flag and the implementation for false.
        * [ ] Replace existing `worker.execute` with `worker.execute.py`.
        * [ ] Make flat-folder true by default.
        * [ ] Deploy on live server.
    * [ ] Clean up Java based Network Worker.
* [o] Port 'net.splitcells.network's Worker commands to Java.
    * [o] Create Java alternative.
         * [x] Port `bin/worker.test.at` to Java.
         * [o] Port `bin/worker.execute` to Java.
           * [x] Port Python code without tests as a preparation.
               * [x] `--command`
               * [x] `--execute-via-ssh-at`
               * [x] `--executable-path`
               * [x] `--class-for-execution`
               * [x] `--cpu-architecture`
               * [x] `--use-host-documents`
               * [x] `--publish-execution-image`
               * [x] `--verbose`
               * [x] `--only-build-image`
               * [x] `--only-execute-image`
               * [x] `--dry-run`
               * [x] `--use-playwright`
               * [x] `--auto-configure-cpu-architecture-explicitly`
               * [x] `.config/net.splitcells.network.worker/execute.podman.flags` 
           * [x] Make testAtRemote work locally via `.splitcells.martins.avots.distro/bin/test`, but only make client side based on Java.
               * [x] Adjust Volume paths.
               * [x] Make `NetworkWorkerTest#testTestAtRemote()` generate multi line scripts, as these are otherwise hard to support, read and understand.
               * [o] Store execution script in target folder just like the Dockerfile and program script. -> Logging is enough for now.
               * [x] Note why distinction between default user config and instance config is being done.
                   * [x] Development and running should be possible on one user, in order to simplify administration. Do not require OS administration for simple development task.
                   * [x] Remote user config, remote test config and local user are inherently different configs.
               * [o] Use different `net.splitcell.shell` config folder on developer computer. See NET_SPLITCELLS_SHELL_CONFIG_FOLDER. -> Everything is done in the container, so this is not needed.
               * [x] Note that only `worker.bootstrap` is allowed to be a bash script. `worker.bootstrap` needs to be a portable as possible with as minimal and small OS dependencies as possible. -> Shell, git, Java and Maven is required.
               * [x] Create a complete reset command of network worker, so that everything can be tested.
                   * [x] Git
                   * [x] Delete .m2 via `rm -rf ~/.local/state/net.splitcells.network.worker/.m2/repository/net/splitcells/`
                     -> This is only done during the build.
               * [x] Correct initial Network Log pull.
           * [x] Make testAtRemote work remotely on Raspberry Pi via `.splitcells.martins.avots.distro/bin/test`.
               * [x] Do not nest user folders via Podman aka `./.local/state/net.splitcells.martins.avots.distro/.local/state/net.splitcells.martins.avots.distro.LiveDistro/logs/`,
                 in order to simplify folder structure and thereby the administration.
                   * [x] Implement this in the Java port.
                   * [x] Implement this in Python port via a new flag for that, in order not break the live server deployment.
                   * [x] Also note, how namespaces could be done in such a scenario, in order to isolate groups of execution names more explicitly from each other.
                     This can be used, in order to isolate publicly accessible and privately accessible programs from each other at the same user, just like for meta repos.
                   * [x] Output shell execution in correct order. Currently, some logs like `Cloning into 'net.splitcells.network.distro'...` is logged later,
                     than it is actually happening in relation to other log files.
                   * [x] The repos are still always cloned.
                       * [x] The volumes of the Dockefile are still not updated.
                   * [x] Ensure that `.m2` is persisted.
               * [x] Speed up volume mounting on Podman just like it is done on the live server.
               * [x] Reset repo by default, in order to avoid pull conflicts or exit if pull does not work.
               * [x] Build software.
               * [x] Execute tests.
               * [x] Commit test results to network log.
               * [x] Push network log. -> The commits are pulled by the test triggerer instead, so that access tokens do not have to be stored on each test server for Codeberg.
               * [x] Fix the test's hostname written into the Network Log. It is currently incorrect, as it is the hostname of the Podman container, which is a random string. This needs to be parsed from the network worker arguments.
               * [x] Improve logging by stating why something is executed.
               * [x] Remote bootstrapping should be done via the Java port as well, but the bootstrap script itself stays a shell script.
               * [x] Move bootstrapping execution into container, in order to minimize initial server requirements.
                 -> The bootstrapping was already executed inside a container, the initial bootstrapping just needs to be moved into the Java prot.
                 See `Remote bootstrapping should be done via the Java port as well, but the bootstrap script itself stays a shell script.`.
               * [x] Stabilize Java port regarding script and dockerfile generation.
                   * [x] Do not use muteable variables.
                   * [x] Generate one execution script, if possible, order to simplify execution.
                   * [x] Split local and remote execution into 2 distinct scripts.
           * [o] Execute remote test without requiring continues connection during the test.
             Currently, a connection abort stops the remote test as well.
             This feature was present in the past before the Network Worker existed and was used to execute long-running tasks on slow computers during the night.
               * [o] Use old implementation as a help for that. See `deploy.build.at`. -> Create an ordinary user service instead, as this does not require root rights.
               * [o] Create a temporary user service for the one time task.
                 Choose its name, so that every new service has a unique name like `[execution-name]-[date]`.
                 This avoids, that an execution with an error, does not block the next execution.
               * [o] Look up, how to delete services, that exited with an error.
           * [o] Check syntactical completeness of initial Python to Java port.
           * [o] Create Dockerfile.
           * [o] Create unit tests for the Java based Network worker execution.
           * [o] Synchronize Playwright version in POM and Dockerfile.
    * [o] Persist bin folder.
    * [o] Do not pass arguments in remote execution scripts, that rely on default values in order to improve the script overview.
    * [o] Provide a way in order to bootstrap and test as one command instead of 2.
    * [o] Create a script to deploy command on every computer.
    * [o] Make it possible to switch between Java and Python version via environment variable, when calling this commands as project commands from a shell.
        * [o] Make WorkerExecutionMain working.
        * [o] Try to get the deployment to the live server working via a Java based Network worker execution.
    * [o] Deploy live distro via Java version.
    * [o] Remove the Python code, when the migration worked for the live distro.
        * [o] Remove special flag for live distro. See `* [ ] Implement this in Python port via a new flag for that, in order not break the live server deployment.`. 
* [o] Port `repo.process`.
    * [o] Add flag, in order to parallelize tasks like pulling and pushing.
* [o] Port `net.splitcells.shell` related projects to Java/Maven.
    * [o] Port `net.splitcells.shell` to Java.
        * [o] Create Java alternative.
        * [o] Make it possible to switch between Java and Python version via environment variable.
        * [o] Test whether the Java version is working.
            * [o] Personal laptop.
            * [o] Raspberry Pi
            * [o] Live server.
    * [o] Port `net.splitcells.shell.lib` to Java/Maven.
    * [o] Port `net.splitcells.shell.lib.gpl.v2` to Java/Maven.
    * [o] Port `net.splitcells.shell.lib.gpl.v3` to Java/Maven.
    * [o] Port `net.splitcells.project` to Java/Maven.
    * [o] Test everything together.
* [o] Remove Python versions of `net.splitcells.shell` related code.
* [o] Make `net.splitcells.shell` related projects usable from webserver via UserCommandProjectRendererExtension.
* [o] Port static website deployment to Java as well, in order to speed up the upload via parallelism.
* [o] Execute worker commands at current repo by default and only switch to `~/.local/state/net.splitcells.network.worker` via an explicit flag.
    * [o] Ensure, that this is the case for all worker commands.
* [o] Final tasks
    * [o] Check runtime of command execution regarding Java's start time.
    * [o] Update software stack guidelines.
        * [o] Remove Python 3 and reason this.
    * [o] Note overhaul changes in changelog.
    * [o] Copy appropriate parts of the task description to the project's documentation.
    * [o] Add this task description to the project's documentation.
# deploy.build.at
````
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
````