# Sigma Grind of 24th of August 2024
> Time to break the mind into pieces as much as possible.

* [ ] Improve user experience regarding the application's responsiveness by introducing multithreading to webserver and constraint tree.
* [ ] Create a new single backend for the problem definition language with a new editor and deprecate existing editors.
  This backend focuses on being independent of the parsers and language grammars.
  It is the new general backend and base language for every editor.
* [ ] Support complex problem definitions via the new backend and editor.
    * [ ] Model sport lesson assignment in new editor.
* [ ] Create experimental persistence framework for table data based on Gel,
  in order test its future viability as a base persistence layer for data processing on scale.
  Use this for user authentication in the webserver.
  Use H2 and a simple subscription model for now.
  In later projects advanced persistence backends via SQL code generation will be used.
* [ ] Create overview of Splitcells Network Worker architecture and its storage types,
  that allows use everything as one.
    * [ ] OSI
    * [ ] Filesystems
    * [ ] Tables
    * [ ] Network Worker
    * [ ] Network Worker bootstrapping
    * [ ] Network Bootstrapper
    * [ ] Java
    * [ ] Python 3 and Bash
    * [ ] Worker commands.
    * [ ] Webserver deployment.
    * [ ] Create ticket for getting to this architecture.
    * [ ] Codeberg
    * [ ] Offline backups
* [ ] Complete no-code editor ticket.