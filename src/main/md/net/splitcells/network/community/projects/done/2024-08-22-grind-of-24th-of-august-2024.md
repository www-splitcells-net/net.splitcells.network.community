# Grind of 24th of August 2024
* Start Date: 2024-08-24
* End Date: 2024-08-27
# Possible Tasks to be Done
* [x] Improve user experience regarding the application's responsiveness by introducing multithreading to webserver and constraint tree.
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
# Result Diary
Only multithreading was implemented.
Conceptually, the framework multithreading and the code is as easy as imagined.
Actually using the framework in aspects seemed to be as easy in the beginning and the code stayed simple throughout this grind.
Unfortunately, the error analysis required a tremendous amount of time.
The fixes where easy every time, but they required a lot of analysis work.

2 errors found in Cin's TimeSteps and LonelinessTest caused by the multithreading were not fixed.
Its analysis took too much time and the problem happens in only some scenarios during testing.
These tests were disabled, because these test currently deprecated functionality.
It is also suspected, that there is a general and not multithreaded related error in the Rater implementations.
It may be the case, that in some allocation order the Rater implementation do not work.
This will be fixed, when the Cin project is restarted.
See `2022-12-21-1-create-game-based-on-optimization-networks.md`.

Furthermore, multithreading worsens the optimizers' performance.
The webserver on the other hand now supports multiple editor users at once,
while any number of them submit optimization problems.

Multithreading the optimizer also causes problems on the live server.
Therefore, it was disabled by default.
Cin's TimeSteps and LonelinessTest were renabled.
The constraints multithreading is at least executed during `DatabaseTest#testMultiThreadedQueryInitialization`,
so its not dead code.
The webservers multithreading stays enabled in live server.