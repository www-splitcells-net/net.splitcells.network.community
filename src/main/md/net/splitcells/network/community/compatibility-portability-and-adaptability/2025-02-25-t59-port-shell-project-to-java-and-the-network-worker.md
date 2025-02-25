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
* [ ] Update software stack guidelines.
    * [ ] Deprecate Python 3 and reason this.
* [ ] Final tasks
    * [ ] Check runtime of command execution regarding Java's start time.