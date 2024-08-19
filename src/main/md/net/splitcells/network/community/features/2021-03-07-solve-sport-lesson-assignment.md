# Solve sport lesson assignment
# Task Description
Exemplary solve the sport lesson assignment problem from Martins Avot's master thesis,
in order to extend the programs modelling and optimization capabilities.
Thereby make the project usable as a service by multiple users at once,
as a platform supporting many different optimization problems out of hand seems to be crippled,
if the service can only be used by one user at once.
# Tasks
* [ ] Complete the issue ["Create no-code gel editor"](./2024-05-31-create-no-code-gel-editor.md) first.
* [ ] Check sport lesson assignment model.
* [ ] Check test data.
* [ ] Solve sport lesson assignment.
* [ ] Support complex problem definitions via editor, that are composed of multiple ones,
  so that the sport lesson assignment can be defined in the editor.
    * [ ] Extend Gel language, in order to model optimization problems consisting of multiple optimization problems.
        * [ ] Use domain object based parser as backend for editor and no-code editor, in order to simplify parsing.
            * [ ] Remove direct dependency to ANTLR4 at parser and any other code.
            * [ ] Consider moving parsing code to dedicated project, in order to isolate ANTLR4 and grammar dependencies.
    * [ ] Add example of sport lesson assignment as an editor page to webserver. 
* [ ] Improve user experience regarding the application's responsiveness.
    * [ ] Implement basic multi threading injection framework.
    * [ ] Support multiple users at once via multi threading injection.
    * [ ] Use multiple threads for calculation of the ratings via the constraint nodes.
    * [ ] Use dedicated workers for lookup tables.
    * [ ] Continuously and automatically run test user in live distro, in order to test if server can endure many optimization runs.
    * [ ] Check CPU and RAM usage.