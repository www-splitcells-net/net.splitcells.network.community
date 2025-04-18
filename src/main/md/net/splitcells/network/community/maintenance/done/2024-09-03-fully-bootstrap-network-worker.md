# Fully bootstrap Network Worker
* Issue number: [\#41](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/41)
# Task Description
The Network Worker was envisioned to be a software,
that provides an easy integration UI of the operating system, software environment, the source code repos,
its builds and running software.
The first goal of this is to make it easy for the software developer,
to run tasks on the source code repos for development and deployment purposes.

Currently, this goal is persuaded and achieved in limited amounts,
which causes problems setting up and maintaining deployments and increases the time required for each
developer interaction.
The goal of this task is to increase the effectiveness and UI efficiency of the network worker,
in order to easy and maintain DevOps.

The main task for this is to ensure,
that the main focus is laid on the concept of the global virtual network path system (GVNPS) in the Network Workers Shell UI.
This path system should be used during most developer tasks in order
to bootstrap the Network Worker and to ease DevOps. 
# Tasks
* [x] Document new focus on global virtual path system.
* [x] Add global virtual path system to main goals.
* [o] Unify project and repo projects. -> The split is ok, as a project is something different from a repo.
    * [x] Rename `net.splitcells.project.files.standard` to `net.splitcells.project`, in order to simplify the naming.
    * [x] Consider renaming `net.splitcells.os.state.interface` to `net.splitcells.shell`.
      -> The rename was done.
* [x] Define default project commands.
    * [x] Expand `command.managed.install.project.commands.py` so it can install default project commands. 
    * [x] build
    * [x] Rename existing `repo.*` to `repos.*`, because it should be easy to understand,
      if something is done on one repo, or if its children are processed as well.
    * [x] Define `*.shell` that creates a shell with the current directory as the project folder.
    * [x] repo.gui
* [o] Establish and use the global virtual network path system in shell. -> There is no urgent need for that for now.
    * [o] Provide project command to install OSI to an ignored local folder in the source code repos,
      in order to not pollute the user home's bin folder via the OSI installation.
    * [o] Use this for local installation during build and deployment of `net.splitcells.martins.avots.distro` as a proof of concept.
* [o] Consider that all worker commands of the network core, should be basically links to commands inside the worker project.
  If not consider documenting this in the worker doc.
  -> This will be done, if there are multiple worker implementations.
* [x] Create network worker bootstrapper.
    * [x] Create command `worker.bootstrap`, that downloads all repos and make it executable via `worker.execute`.
    * [x] Do not mount documents folder of host, in order to be more independent of host by default.
    * [x] Provide container image at Codeberg in order to have a simple boostrap command for remote servers.
      -> Publishing to Codeberg is not useful, because generating images for all architectures cannot be done on one computer.
    * [x] Create command to boostrap the image.
    * [o] Create command in order to execute additional commands after downloading all repos. -> There is no need for that.
    * [x] Create command to execute such bootstrapping on a remote server and ensure, that the execution is isolated via i.e. podman.
    * [x] Clean up all commands inside bin at root of network repo.
      Alternatively, add the command to the [weekly test deployment task](../deployment/weekly-deploy-tests.md).
# Ideas
* [x] Create build command based on `mvn clean install` of `net.splitcells.network.hub`.
  -> This is already done in the daily Forgejo task of `net.splitcells.network.hub`.
* [o] Use GVNPS for test servers as well. -> This does not seem to make sense.
* [x] Integrate local folder and user home's bin based OSI installation into webserver.
* [x] Clean up project paths.
    * [o] Document that project paths mainly indicate jurisdiction.
    * [x] Rename `net.splitcells.sep` to `net.splitcells.gel.manager`.