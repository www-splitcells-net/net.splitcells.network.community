# Establish Cell API
* Issue number: [\#42](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/42)
# Task Description
Only the `net.splitcells.dem.environment.Cell` API should be used,
in order to manage and combine `Dem#process` and `Dem#serve` configurations.

This way, configs are handled declaratively.
This simplifies and partially avoids handling dependencies between configs and
prioritizes creating useful defaults for complex configs,
in order to lessen the need for custom configs.

At the end, this avoids creating complex configurations by chaining multiple config functions by hand.
Lately, this has proven to be not working and
created severe configuration costs.

This is needed for [the issue "Publish public website source code"](task-archive/9999-2021-03-21-publish-public-website-source-code.md).
# Tasks
* [ ] Extract Cell API tasks from [the issue "Create game based on optimization networks"](../features/task-archive/2022-12-21-1-create-game-based-on-optimization-networks.md).
    * [o] Isolate Cin `Dem#process` from currently main `Dem#process`, in order to isolate data. -> The service option CinSerive was used instead.
        * [o] Create `net.splitcells.network.connect`.
            * [o] Its main purposes is to connect multiple `Dem#process`. 
            * [o] Provides single point of entry for HTTP requests. -> This was done via ObjectsRenderer instead.
    * [ ] Define service builder interface in order to run and coordinate multiple Dem processes.
        * [o] Move this task to dedicated ticket, as this is a big task, with its own distinct goals.
          Link from this ticket to this new ticket instead.
        * [x] Discourage starting program via Dem process with a given runnable,
          because such a program definition is not declarative and therefore combining multiple services or module into
          one is harder.
          -> This is not needed because `Dem#process` and `Dem#serve` are both equally valid use cases..
            * [x] Deprecate such `Dem#process` and create a copy with a longer name, in order to discourage its use.
              Note, that such a method is needed for non-service things,
              like executing a test. -> `Dem#process` is needed in order to calculate something with a given config. So
              it is not deprecated.
        * [ ] Enable all services etc. of a module via one single point of entry like a method,
          where no extra arguments are required for the service to be working with a sane configuration.
          Maybe a general module class/interface is needed.
            * [x] Create entrypoint base. -> The interface `net.splitcells.dem.environment.Cell` is the basis for this.
            * [x] Make entrypoint base an option as well, as it is otherwise hard to declare dependencies between
              instances of such entry points.
            * [x] Provide file system via cells by default.
            * [x] Provide configurations for all modules and thereby understand all requirements.
                * [x] New properties should be not be added to interface directly,
                  but should be added via the `Cell#accept` dynamically.
                  For one, we want to avoid bloating the Cell interface.
                  Furthermore, a mechanism is required whereby the values of the new properties can be replaced.
                  For instance, a filesystem associated with a cell is a file system based on class resources by
                  default.
                  When a developer wants to edit the data of the filesystem, it would be efficient,
                  if the developer could edit the source files and test the edit without an application restart. -> This
                  is documented.
                * [x] Provide a FileSystemView for every Cell by default.
                * [x] Create Cell version of WebsiteViaJar. -> It is called `net.splitcells.network.system.SystemCell`.
                    * [x] ServerService does not start correctly.
                        * [x] Does not open port.
                          `server.listen();` has no effect, although the server config seems to be correct.
                          -> This was caused by a hidden error.
                    * [x] Add all configs and resources to SystemCell.
                * [x] Deprecate original WebsiteViaJar.
            * [X] Visualize cell dependencies, as otherwise, there will problems of understanding in the future.
              This was also the case for handling configs via config functions.
                * [o] Provide way for cells to optionally declare their option dependencies. The dependency order will
                  not be enforced yet. -> It is enough for now, that the init system records the dependencies, as it will not be enforced by now. 
                * [X] Visualize dependencies between cells as graph like `https://splitcells.net/net/splitcells/network/overview.html`,
                  but dynamically.
                    * [x] Create dependency recorder option.
                      -> It is named DependencyRecording.
                    * [x] Render dependency recorder option.
                    * [x] Record `Configuration#withConfigValue`.
                    * [X] Record `Environment#withCell`.
                    * [x] Record `Configuration#withInitedOption`. Is this really needed or is this covered via `Configuration#withConfigValue`? --> Yes
                    * [x] Add `mermaid.min.js` to website instead of linking it at an external CDN server.
            * [ ] CURRENT Create Cell based launcher at `net.splitcells.martins.avots.distro.LiveDistroCell` and
              when it works remove `net.splitcells.martins.avots.distro.LiveDistro`.
                * [X] First move all `Distro*` code into `*Cell` classes, so that cell `Distro*` do not exist and provide non-static wrappers,
                  so that these can be used in the Consumer of `Environment#withCell(Class, Consumer)`.
                    * [x] `net.splitcells.network.system.WebsiteViaJar` -> `net.splitcells.network.system.SystemCell`
                    * [x] `net.splitcells.network.distro.Distro` -> `net.splitcells.network.distro.DistroCell`
                    * [x] `net.splitcells.network.distro.java.Distro` -> `net.splitcells.network.distro.java.DistroCell`
                    * [x] `net.splitcells.martins.avots.distro.Distro` -> `net.splitcells.martins.avots.distro.DistroCell`
                    * [o] `net.splitcells.martins.avots.website` -> This will be done with the [publish website source code](task-archive/9999-2021-03-21-publish-public-website-source-code.md) project.
                    * [x] GelEnv
                    * [x] GelDev
                    * [X] `net.splitcells.martins.avots.distro.DevDistroCell` -> `net.splitcells.martins.avots.distro.DevDistroCell`
                    * [x] `net.splitcells.martins.avots.distro.LiveDistro` -> `net.splitcells.martins.avots.distro.LiveDistroCell`
                * [ ] Store Cells in Dem config and thereby make it possible to call its member methods.
                  This way, one can convert the static config methods to members of cells and prevent static config chaining which caused a lot of hard to understand complexity.
                * [ ] Replace main methods based on static methods with cell based main methods and test these.
                    * [x] `net.splitcells.network.system.SystemCell`
                    * [x] `net.splitcells.network.distro.DistroCell.`
                    * [x] `net.splitcells.network.distro.java.DistroCell`
                    * [x] `net.splitcells.martins.avots.distro.DistroCell`
                    * [x] `net.splitcells.martins.avots.distro.DevDistroCell` See `DevDistroCell#cellBasedMain`.
                        * [x] Make cellBasedMain run.
                        * [x] Add all configs from main method to cellBasedMain as well.
                    * [ ] `net.splitcells.martins.avots.distro.LiveDistroCell` and LiveDistro.
                        * [ ] Create dedicated Cell to initialize crypto named LiveCryptoSetupCell
                        * [ ] The new method first executes LiveCryptoSetupCell and then serves LiveDistroCell.
                    * [ ] `net.splitcells.martins.avots.website`
              * [ ] Remove static methods inside cells for process configuration.
                  * [ ] `net.splitcells.network.system.SystemCell`
                  * [ ] `net.splitcells.network.distro.DistroCell.`
                  * [ ] `net.splitcells.network.distro.java.DistroCell`
                  * [ ] `net.splitcells.martins.avots.distro.DistroCell`
              * [ ] Deploy on live server.
              * [ ] Ensure, that the dependency recorder is really recording Cell dependencies.
    * [ ] Create launcher class for execution or configuration of the game.
        * [ ] Create proof of concept launcher class at `net.splitcells.network.distro.DistroCell`, in order to ease the
          start.
        * [ ] Create proof of concept launcher class at `net.splitcells.martins.avots.distro`, in order to ease the
          start. -> The class CinDevDistro is used for that.
        * [ ] Only use web server as resource option.
            * [ ] See `GelDev#configureForWebserver`.
        * [ ] Clean up existing configs.
            * [ ] What is `net.splitcells.website.Projects` used for?
            * [ ] Consider `net.splitcells.cin.WorldService`, which contains former working code.
            * [ ] Consider `net.splitcells.martins.avots.distro.DevDistroCell`, which contains currently working code.
        * [ ] Use GelDev as basis.
        * [ ] Do not block web server start via game.
* [ ] Remove configuration code of any other way.
* [ ] Webserver instance should be contained inside `Dem#value` as a service and
  by default be limited to given set of instances.
  Otherwise, webserver instances cannot be configured, created and run declaratively.
  This makes working with these essential resources unnecessary hard.
  For instance, replacing or adapting the webserver becomes harder.
* [ ] Document that cells are better, than simple config function,
  as cells allow for better control of config application functions,
  whereas simple config functions without helper functions do not allow for such.