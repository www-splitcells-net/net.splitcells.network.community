# Solve sport lesson assignment
* Issue number: [\#37](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/37)
# Task Description
Exemplary solve the sport lesson assignment problem from Martins Avots's master thesis,
in order to extend the programs modelling and optimization capabilities.

Thereby make the project usable as a service by multiple users at once.
A platform supporting many different optimization problems out of hand seems to be crippled,
if the service can only be used by one user at once.
Furthermore, in order to prepare the webserver for ["Solve school course scheduling problem"](task-archive/2021-03-07-solve-school-course-scheduling-problem.md),
basic support for authentication and authorization is to be added to the server.
For testing purposes the authentication and authorization system is used,
to only provide server CPU and RAM usage in real time to the administrator of the server.
To make the administration GUI useful an update command of the webserver itself is to be implemented.
# Tasks
* [ ] Complete the issue ["Create no-code gel editor"](./2024-05-31-create-no-code-gel-editor.md) first.
* [ ] Improve user experience regarding the application's responsiveness.
    * [x] Implement basic multi threading injection framework.
        * [x] Note, that multi threading is achieved while avoiding amount of thread safe code.
          Therefore, multiple instances of ProjectsRendererI are used,
          even though most of that code is probably thread safe.
          Code that is thread safe, because everything is read only is fine though.
    * [x] [Make webserver thread safe](./2024-08-27-make-copies-of-the-webserver-thread-safe.md), in order to support multiple users at once on public server.
    * [ ] ***CURRENT*** Document, that one of the goals of the threading injection framework,
      is to minimize the amount of code written specifically for multi-threading.
    * [x] Support multiple users at once via multi threading injection.
    * [ ] Ensure, that logs are working in threads, too.
      Currently, it does not seem to be the case and therefore `Throwable#printStackTrace()` is used as a workaround.
    * [x] Use multiple threads for calculation of the ratings via the constraint nodes.
      -> The performance get worse with constraint multithreading.
    * [ ] Use dedicated workers for lookup tables.
    * [ ] Continuously and automatically run test user in live distro, in order to test if server can endure many optimization runs.
    * [ ] Check CPU and RAM usage.
    * [ ] Related code improvements.
        * [ ] Webserver instance should be contained inside `Dem#value` as a service and
          by default be limited to given set of instances.
          Otherwise, webserver instances cannot be configured, created and run declaratively.
          This makes working with these essential resources unnecessary hard.
          For instance, replacing or adapting the webserver becomes harder.
* [ ] Add first administrative GUI in webserver.
    * [ ] Authorize
    * [ ] Authenticate
    * [ ] Persist authorization and authentication info of the users.
    * [ ] View log files in website only for administrator.
    * [ ] Do not render administrator documents on static rendering or render administrator pages with the lowest privilege.
    * [ ] Create default user profile page, were the user sees links to user specific pages.
      For the administrator links to the CPU and RAM usage pages could be provided.
    * [ ] Provide update command.
        * [ ] Create OSI command in order to deploy live server via 1 command from development computer.
        * [ ] Provide update command via webserver and authorization.
            * [ ] Build server in same container, as the webserver is running, in order to keep the deployment simple.
            * [ ] Build server via Java based Network Worker.
            * [ ] Clean up Java based Network Worker and create a basic architecture for it.
* [ ] Support complex problem definitions via editor, that are composed of multiple ones,
  so that the sport lesson assignment can be defined in the editor.
    * [ ] Extend Gel language, in order to model optimization problems consisting of multiple optimization problems.
        * [ ] Use domain object based parser as backend for editor and no-code editor, in order to simplify parsing.
            * [ ] Remove direct dependency to ANTLR4 at parser and any other code.
            * [ ] Consider moving parsing code to dedicated project, in order to isolate ANTLR4 and grammar dependencies.
            * [ ] Use Java sum type in order to simplify handling of domain object, if needed.
              This requires sum types to be added to the allowed Java grammar. 
    * [ ] Add example of sport lesson assignment as an editor page to webserver.
* [ ] Check sport lesson assignment model.
* [ ] Check test data.
* [ ] Solve sport lesson assignment.
* [ ] Make it easier to understand the solution.
    * [ ] Store and show positive reason, why a certain supply was assigned as certain value.
    * [ ] Render ratings in formatted output as well via pop-ups.
      Consider using own table framework, for easier adaptability in this context.