# Solve sport lesson assignment
# Description
Exemplary solve the sport lesson assignment problem from Martins Avot's master thesis,
in order to extend the programs modelling and optimization capabilities.
Thereby make the project usable as a service by multiple users at once,
as a platform supporting many different optimization problems out of hand seems to be crippled,
if the service can only be used by on user at once.
# Tasks
* [ ] Complete the issue ["Create no-code gel editor"](./2024-05-31-create-no-code-gel-editor.md) first.
* [ ] Clean up and finalize tasks of this project.
* [ ] Extend Gel language, in order to model optimization problems consisting of multiple optimization problems.
    * [ ] Use domain object based parser as backend for editor and no-code editor, in order to simplify parsing.
        * [ ] Remove direct dependency to ANTLR4 at parser and any other code.
        * [ ] Consider moving parsing code to dedicated project, in order to isolate ANTLR4 and grammar dependencies.
* [ ] Implement multi threading via multi threading injection.