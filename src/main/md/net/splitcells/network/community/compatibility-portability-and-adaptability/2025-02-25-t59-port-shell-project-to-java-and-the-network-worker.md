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
* [ ] Port 'net.splitcells.network's Worker commands to Java.
    * [ ] Create Java alternative.
         * [x] Port `bin/worker.test.at` to Java.
         * [ ] Port `bin/worker.execute` to Java.
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
           * [ ] Make testAtRemote work locally via `.splitcells.martins.avots.distro/bin/test`, but only make client side based on Java.
               * [x] Adjust Volume paths.
               * [x] Make `NetworkWorkerTest#testTestAtRemote()` generate multi line scripts, as these are otherwise hard to support, read and understand.
               * [ ] Store execution script in target folder just like the Dockerfile and program script.
               * [ ] Note why distinction between default user config and instance config is being done.
                   * [ ] Development and running should be possible on one user, in order to simplify administration. Do not require OS administration for simple development task.
                   * [ ] Remote user config, remote test config and local user are inherently different configs.
               * [ ] Use different `net.splitcell.shell` config folder on developer computer. See NET_SPLITCELLS_SHELL_CONFIG_FOLDER.
               * [ ] Escape single quotes.
               * [ ] Note that only `worker.bootstrap` is allowed to be a bash script. `worker.bootstrap` needs to be a portable as possible with as minimal and small OS dependencies as possible.
               * [ ] Create a complete reset command of network worker, so that everything can be tested.
           * [ ] Make testAtRemote work remotely on Raspberry Pi via `.splitcells.martins.avots.distro/bin/test`.
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
               * [x] Remote bootstrapping should be done via Java port as well, but the bootstrap script itself stays a shell script.
               * [x] Build software.
               * [x] Execute tests.
               * [ ] Stabilize Java port regarding script and dockerfile generation.
               * [x] Commit test results to network log.
               * [ ] Push network log. -> The commits are pulled by the test triggerer instead, so that access tokens do not have to be stored on each test server for Codeberg.
           * [ ] Execute remote test without requiring continues connection during the test.
             Currently, a connection abort stops the remote test as well.
             This feature was present in the past before the Network Worker existed.
           * [ ] Check syntactical completeness of initial Python to Java port.
           * [ ] Create Dockerfile.
           * [ ] Create unit tests for the Java based Network worker execution.
           * [ ] Synchronize Playwright version in POM and Dockerfile.
    * [ ] Make it possible to switch between Java and Python version via environment variable, when calling this commands as project commands from a shell.
        * [ ] Make WorkerExecutionMain working.
        * [ ] Try to get the deployment to the live server working via a Java based Network worker execution.
    * [ ] Deploy live distro via Java version.
    * [ ] Remove the Python code, when the migration worked for the live distro.
        * [ ] Remove special flag for live distro. See `* [ ] Implement this in Python port via a new flag for that, in order not break the live server deployment.`.
* [ ] Port `repo.process`.
    * [ ] Add flag, in order to parallelize tasks like pulling and pushing.
* [ ] Port `net.splitcells.shell` related projects to Java/Maven.
    * [ ] Port `net.splitcells.shell` to Java.
        * [ ] Create Java alternative.
        * [ ] Make it possible to switch between Java and Python version via environment variable.
        * [ ] Test whether the Java version is working.
            * [ ] Personal laptop.
            * [ ] Raspberry Pi
            * [ ] Live server.
    * [ ] Port `net.splitcells.shell.lib` to Java/Maven.
    * [ ] Port `net.splitcells.shell.lib.gpl.v2` to Java/Maven.
    * [ ] Port `net.splitcells.shell.lib.gpl.v3` to Java/Maven.
    * [ ] Port `net.splitcells.project` to Java/Maven.
    * [ ] Test everything together.
* [ ] Remove Python versions of `net.splitcells.shell` related code.
* [ ] Make `net.splitcells.shell` related projects usable from webserver via UserCommandProjectRendererExtension.
* [ ] Port static website deployment to Java as well, in order to speed up the upload via parallelism.
* [ ] Execute worker commands at current repo by default and only switch to `~/.local/state/net.splitcells.network.worker` via an explicit flag.
    * [ ] Ensure, that this is the case for all worker commands.
* [ ] Final tasks
    * [ ] Check runtime of command execution regarding Java's start time.
    * [ ] Update software stack guidelines.
        * [ ] Remove Python 3 and reason this.
    * [ ] Note overhaul changes in changelog.
    * [ ] Copy appropriate parts of the task description to the project's documentation.
    * [ ] Add this task description to the project's documentation.