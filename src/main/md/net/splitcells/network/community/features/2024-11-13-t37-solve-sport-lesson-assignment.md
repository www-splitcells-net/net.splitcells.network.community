# Solve sport lesson assignment
* Issue number: [\#37](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/37)
# Task Description
Exemplary solve the sport lesson assignment problem from Martins Avots's master thesis,
in order to extend the programs modelling, optimization capabilities and usability.

Thereby make the project usable as a service by multiple users at once.
A platform supporting many different optimization problems out of hand seems to be crippled,
if the service can only be used by one user at once.
Furthermore, in order to prepare the webserver for ["Solve school course scheduling problem"](2021-03-07-solve-school-course-scheduling-problem.md),
basic support for authentication and authorization is to be added to the server.
For testing purposes the authentication and authorization system is used,
to only provide server CPU and RAM usage in real time to the administrator of the server.
# Tasks
* [ ] Support complex problem definitions via editor, that are composed of multiple ones,
  so that the sport lesson assignment can be defined in the editor.
    * [x] Create a name for the language and document it. -> It's named Geal.
    * [ ] Extend Gel language, in order to model optimization problems consisting of multiple optimization problems.
        * [x] Define new grammar.
            * [x] Do not avoid dot for function call chains, in order to make it possible to consistently format code.
            * [x] Do not allow empty round braces for function calls.
            * [x] Create public Grammar documentation file. This will be later completed, when the editor is finalized
              and thereby the standard library is known.
        * [ ] Use a domain object based parser and editor as backend for editor and no-code editor, in order to simplify parsing. In other words, create an editor backend, that is shared by the code and no-code editor frontend.
            * [ ] Create dedicated Gel editor project, that replaces the Sep project.
                * [x] Create Gel editor project.
                * [ ] Create new domain language in order to simplify it, as the first 1 has too much complexity without any benefits.
                    * [x] Create domain objects.
                    * [ ] Create parser and integrate into editor.
                        * [ ] Test pure AST interpretation by example.
                            * [ ] Actually parse constraints.
                                * [ ] Implement recursion.
                                * [ ] Ensure, that constraint call recursion's last element returns the subject and not the first one,
                                  as this makes more sense.
                                    * [ ] Make constraint variable definition correct to this correct way of piping function call chain results. 
                                * [ ] Ensure, that the runners' subject is set correctly.
                            * [x] Make duplicate variable check complete.
                            * [x] Remove code duplicate in central parser.
                        * [ ] Test AST parsing and AST interpretation by example.
                * [x] Deprecate existing language.
            * [x] Remove direct dependency to ANTLR4 at parser and any other code.
                * [x] Use list based FunctionCallChainDescription for constraint definitions, instead of creating a special case for constraints. 
            * [o] Consider moving parsing code to dedicated project, in order to isolate ANTLR4 and grammar dependencies. -> Isolation via Java Legacy class should be enough.
            * [ ] Allow using sum types in this project's Java subset, in order to provide access to a set of values, where only one of them at one time is actually set. Use this only for that.
                * [x] Extend ANTLR grammar.
                * [ ] Comment the reason for allowing sum types.
            * [o] Delete `net.splitcells.gel.ui.Editor`. -> This class is migrated instead.
            * [x] Use unified namespace for attribute names across SolutionEditors, in order to simplify user input.
            * [ ] Implement proper user friendly error handling.
    * [ ] Add example of sport lesson assignment as an editor page to the webserver.
    * [ ] Document and attempt backwards compatibility for this language only. Note the relation to the stable system API.
* [ ] Support LSP in editor via [Eclipse LSP4J](https://github.com/eclipse-lsp4j/lsp4j), [LSPs](https://github.com/qualified/lsps) and CodeMirror.
* [ ] Document code editor.
    * [ ] Create a simple grammatic overview images.
        * [ ] 1 for Abstract Syntax
        * [ ] 1 for Optimization Problem Definition
    * [ ] New approach to error handling.
        * [ ] Problem with classical error handling.
        * [ ] Limit line length via dedicated methods referenced,
          which is better than aspect oriented style because of required code duplication caused by data selection. 
* [ ] Check sport lesson assignment model.
* [ ] Check test data.
* [ ] Solve sport lesson assignment.
* [ ] Make it easier to understand the solution.
    * [ ] Add comments via optimizers to allocations, so that the user knows why a certain allocation was created by the optimizer. Consider adding this to the history table or as meta column to the solution table. 
    * [ ] Store and show positive reason, why a certain supply has not a cost.
      In other words, show all longest constraint paths, where the respective allocation was propagated to a then constraint node.
* [ ] Allow users to define a partial solution, that is the basis for the given problem.
  The optimizer is not allowed to change the allocations given by the user.
* [ ] Note overhaul changes in changelog.
* [ ] Delete old Gel editor domain language.
* [ ] Deprecate Sep project.
    * [ ] Move Sep code into editor project.
    * [ ] Migrate sep usage to editor.
    * [ ] Remove Sep code.
* [ ] Note in doc, that the code editor does not work great on mobile and that the no-code editor was great there.
  If mobile support becomes required, then an additional no-code editor might be worth it.
    * [ ] It seems, that codemirror 6 has better mobile view.
    * [ ] A no-code editor would be interesting for something interactive like crisis network (Cin),
      where a program also represents a GUI for interacting with the world.
# Done Tasks
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
        * [x] Create optimization test.
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
* [x] Add first administrative GUI in webserver.
    * [x] Create blocked page.
    * [x] Authenticate
    * [x] Authorize
    * [x] Persist authentication info of the users.
    * [x] Authorize based on persisted authorization data of the users.
        * [x] Simplify config file structure and make more consistent.
            * [x] Place ACME files inside config folder. -> This was already the case. There were just some old files on the server, that created the impressions, that ACME files were stored inconsistently.
            * [x] Each user should have a password file. The user file should not contain the password, but be a folder, so that additional attributes can be placed there.
        * [x] Make file structure more consistent. Currently, some files are place in the top level. -> These were just some stray files on the live server.
        * [x] Read user from vertx.
            * [x] Ensure, that every handled user is created by the main Authentication. -> The solution calculators are ignored regarding this for now.
                * [x] Implement Vertx independent Authenticator.
                * [x] Test Vertx independent Authenticator.
                * [x] Use independent Authenticator in Vertx and the UserSession to the user attributes map of Vertx.
                * [x] Strongly limit allowed symbols username and password severely.
                  -> Only the username was limited for now, as an urgent need for limiting the user's password is not know.
            * [x] Ensure, that every user object is created with proper user input. Do not look up user objects just by names.
              Ensure that proper authentication was provided by the user.
            * [x] Convert user object to user session object.
            * [x] Provide a RAII based cycle for user sessions.
              An access control object can ensure this, by providing a method, that takes a login and user session consumer,
              in order to execute a piece of code with login specified user session.
            * [x] use RAII based user session life cycle for server.
            * [x] Limit the amount of parallel user session, in order to detect life cycle problems of user sessions.
              -> Document this as a task, at the access control object source code.
        * [x] Read roles of user from config.
        * [x] Create base class for all currently present authenticators,
          in order to have standardized runtime checks for authenticators
    * [x] Do not render administrator documents on static rendering or render administrator pages with the lowest privilege.
        * [x] Renderers have to support a rights concept.
        * [o] View log files in website only for administrator. -> Viewing logs via web UI is not required for now.
    * [x] Create default user profile page, were the user sees links to user specific pages.
      May do this, by showing all paths, that only a specific user has access to?
    * [x] Provide access to CPU and RAM utilization, if the user session has the appropriate role for that.
    * [o] CPU utilization is not visible in the layout anymore.
      The reason for that is, that ProjectsRendererExtension do not support project paths listening via a user session.
      -> It is enough, that this page is visible in the users profile.
        * [o] Extend interface.
        * [o] Add implementation for CPU utilization extension.
    * [o] Fix styling for `You do not have the rights to access this page.` page. -> It is good enough for now.
    * [x] Document this in the web server's changelog.
    * [o] Create login page. -> The browser's default login page is enough for now.
    * [o] Link to login page from `You do not have the rights to access this page.` page. -> The browser's default login prompt is enough for now.
    * [x] The following extensions needed appropriate protection as well.
        * [x] `net.splitcells.website.server.projects.extension.impls.TestExtension`
        * [x] `net.splitcells.website.server.projects.extension.status.HostMemoryUtilizationExtension`
        * [x] Enable and secure `net.splitcells.website.server.projects.extension.impls.DemConfigExtension`, which is currently disabled.
    * [o] Create picture depicting an architectural overview of the security system.
      -> The authentication, authorization and access control API seems to be good enough.
    * [x] Deploy this feature to production.
# Done Tasks
* [o] Blog why the Cin project is now a low priority feature project.
* [o] Complete the issue ["Create no-code gel editor"](../2024-05-31-create-no-code-gel-editor.md) first. -> The no-code editor is obsolete and deleted.