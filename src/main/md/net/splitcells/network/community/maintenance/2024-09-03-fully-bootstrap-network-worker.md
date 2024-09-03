# Fully bootstrap Network Worker
* Issue number: [\#41](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/41)
# Task Description
The Network Worker was envisioned to be a software,
that provides an easy integration UI of the operating system, software environment, the source code repos,
its builds and running software.
The first goal of this is to make it easy for the software developer,
to run task on the source code repos for development and deployment purposes.

Currently, this goal is persuaded and achieved in limited amounts,
which causes problems setting up and maintaining deployments and increases the time required for each
developer interaction.
The goal of this task is to increase the effectiveness and UI efficiency of the network worker,
in order to easy and maintain DevOps.

The main task for this is to ensure,
that the main focus is laid on the concept of the global virtual network path system (GVNPS) in the Network Workers Shell UI.
This path system should be used during most developer tasks in order
to bootstrap the Network Worker and to easy DevOps 
# Tasks
* [ ] Document new focus of global virtual path system.
* [ ] Define default project commands.
    * [ ] build
    * [ ] repo.diff
    * [ ] repo.commit.all
    * [ ] repo.commit.all.generic
    * [ ] repo.push.at.all
* [ ] Establish and use the global virtual network path system in shell.
    * [ ] Provide project command to install OSI to an ignored local folder in the source code repos,
      in order to not pollute the user home's bin folder via OSI installation.
    * [ ] Use local installation during build and deployment of `net.splitcells.martins.avots.distro` as a proof of concept.
# Ideas
* [ ] Create build command based on `mvn clean install` of `net.splitcells.network.hub`.
* [ ] Use GVNPS for test servers as well.
* [ ] Integrate local folder and user home's bin based OSI installation into webserver.