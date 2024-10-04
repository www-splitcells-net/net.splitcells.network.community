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
* [x] Improve user experience regarding the application's responsiveness, by supporting multiple web server users at once.
    * [x] Implement basic multi threading injection framework.
        * [x] Note, that multi threading is achieved while avoiding amount of thread safe code.
          Therefore, multiple instances of ProjectsRendererI are used,
          even though most of that code is probably thread safe.
          Code that is thread safe, because everything is read only is fine though.
    * [x] [Make webserver thread safe](./2024-08-27-make-copies-of-the-webserver-thread-safe.md), in order to support multiple users at once on public server.
    * [x] Document, that one of the goals of the threading injection framework,
      is to minimize the amount of code written specifically for multi-threading.
    * [x] Support multiple users at once via multi threading injection.
    * [o] Ensure, that logs are working in threads, too.
      Currently, it does not seem to be the case and therefore `Throwable#printStackTrace()` is used as a workaround. -> This cannot be replicated anymore.
    * [x] Use multiple threads for calculation of the ratings via the constraint nodes.
      -> The performance get worse with constraint multithreading.
    * [o] Use dedicated workers for lookup tables. -> This is not relevant to this issue.
    * [x] Continuously and automatically run test user in live distro, in order to test if server can endure many optimization runs.
        * [x] Determine web address via Dem config and not via a constant. -> This is already available via ServerConfig.
        * [x] Use dynamic web address determination at HtmlClientImpl, too.
        * [x] Create general live tester, where testers are registered in Dem.
          The tester should be disabled by default and is intended for stress testing the server.
        * [x] CURRENT Create optimization test.
            * [x] Make playwright work on server.
            * [x] Execute optimization test via playwright.
                * [x] The browser cannot connect to server.
                  This seems to be a firewall/network issue, as `apt install netutils-ping && ping splitcells.net` does not work as well in the container.
                  This ping works outside the container and on the server.
                  So, this is a podman issue.
                    * [x] The problem is the same as https://github.com/containers/podman/discussions/22778
                    * [x] The problem can be tested in the shell of the container via `curl live.splitcells.net`.
                * [x] `Xml#parse` has a race condition.
        * [x] Execute exactly 1 test at any given time. Provide option to execute exactly n tests at any given time.
          -> Now the number of simultaneously executed tests is half the CPU cores.
        * [x] Assign more RAM to container. -> Podman's container already get all available RAM.
        * [x] Move live test to optional system settings, in order to make live tests an optional standard functionality, that is easy to set up initially.
        * [x] Abort live server build with error, if Podman execution aborts with an error.
        * [x] Log all Service starts generically.
    * [x] Check CPU and RAM usage.
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