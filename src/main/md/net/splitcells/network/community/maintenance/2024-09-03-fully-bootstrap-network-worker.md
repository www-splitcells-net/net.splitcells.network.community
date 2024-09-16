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
* [ ] Document new focus on global virtual path system.
* [ ] Add global virtual path system to main goals.
* [ ] Unify project and repo projects.
    * [ ] ***CURRENT*** Install every repository as a project repository and do not use dedicated file for that.
    * [ ] Rename `net.splitcells.project.files.standard` to `net.splitcells.project.standard`, in order to simplify the naming.
    * [ ] Consider renaming `net.splitcells.os.state.interface` to `net.splitcells.os.interface`.
    * [ ] `net.splitcells.project.standard` should be the base for `net.splitcells.os.interface`.
    * [ ] State in `net.splitcells.project.standard` to keep it minimal, except for abstract
      info transfer commands like `project.render` and `repo.repair`.
        * [ ] Consider removing `project.render.as.net.splitcells.website.py`.
          Is it still used?
          Can it be replaced by `project.render.py`?
* [ ] Define default project commands.
    * [x] Expand `command.managed.install.project.commands.py` so it can install default project commands. 
    * [x] build
    * [ ] Rename existing `repo.*` to `repos.*`, because it should be easy to understand,
      if something is done on one repo, or if its children are processed as well.
    * [ ] Define `shell` that creates a shell with the current directory at the project folder.
    * [ ] repo.diff
    * [ ] repo.commit.all
    * [ ] repo.commit.all.generic
    * [ ] repo.push.at.all
    * [x] repo.gui
* [ ] Establish and use the global virtual network path system in shell.
    * [ ] Provide project command to install OSI to an ignored local folder in the source code repos,
      in order to not pollute the user home's bin folder via the OSI installation.
    * [ ] Use this for local installation during build and deployment of `net.splitcells.martins.avots.distro` as a proof of concept.
* [ ] Consider that all worker commands of the network core, should be basically links to commands inside the worker project.
  If not consider documenting this in the worker doc.
# Ideas
* [ ] Create build command based on `mvn clean install` of `net.splitcells.network.hub`.
* [ ] Use GVNPS for test servers as well.
* [ ] Integrate local folder and user home's bin based OSI installation into webserver.
* [ ] Clean up project paths.
    * [ ] Document that project paths mainly indicate jurisdiction.
    * [ ] Rename `net.splitcells.gel.*` to `net.splitcells.allocator.*`.
    * [ ] Rename `net.splitcells.sep` to `net.splitcells.allocator.manager`.
    * [ ] Rename `net.splitcells.dependency.manager` to `net.splitcells.dependency.manager`.
    * [ ] Rename `net.splitcells.dependency.bom` to `net.splitcells.dependency.bom`.