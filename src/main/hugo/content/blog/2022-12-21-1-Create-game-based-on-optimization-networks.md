---
title: Create game based on optimization networks.
date: 2022-12-21
author: Mārtiņš Avots
tags: [feature, feature_active, active]
---

The original GitHub issue id is `#170`.

# Context
The initial idea for the optimization framework long ago was
to create a modeller for complex optimization systems or complex systems in general,
so one could study these.
The idea was to take theories and thesis,
and to test under which conditions these worked or failed.

The first intention was to model economic systems,
to execute such systems given financial data
and to test theories based on such executions.

Such a framework was named `State Network Execution, Analyzis and Optimization` early on.
Later it was renamed to `State Network Optimization` and is now often referred to as Sep (`net.splitcels.sep`).
In its current state it basically connects and coordinates multiple optimization problems with each other,
in order to create more complex systems.

Another issue facing the project,
was the fact, that there was not one big thing being worked to,
but instead there were many little independent features being worked on.
Each of them, like the school course scheduling, are interesting,
but because of their limited complexity,
it is hard to understand,
how good the optimization framework would work with really big structures.

So, I searched for a mechanism,
where small independent systems could be developed independently,
in order to focus on certain features,
but which provided a way to merge all such small independents into one big structure.

It occurred, that such structure basically is a world,
where on can place and connect things.
Games are inherently suitable for this and have the advantage of being advertizable.

# Tasks
* [ ] Document goals of this game.
  * [ ] Use gamification as a source for motivation.
    * [ ] Alternative or counterpart to test recursion:
      create meaning full tests by combining test problems and thereby creating bigger and
      more complex problems and test data.
    * [ ] The goal is to create optimization algorithm based on reconstruction and deconstruction cycle.
      This is the reason why the game consists of a reconstruction step, that is basically a city building game,
      and a deconstruction step, that is basically a war game.
    * [ ] Reason why the game is called crisis network: bringing optimization systems to their limits and beyond,
      in order to learn from it, is a crisis for such optimization system as undesirable states are thereby reached.
* [x] Create a very simple renderer for it.
* [x] Provide unsecured local website for testing.
  -> Not needed.
  Adjustments to the standard website deployment, create a #client good enough for testing.
* [ ] Create GUI for web server, where one can access and interact with all tables.
    * [x] Create very simple initial HTML renderer for table.
    * [x] Create complete page renderer for table.
    * [x] Add `objectsRenderer` with an example to website in order to ensure it works.
        * [x] Adjust base path to `net/splitcells/cin/instance/testing/`.
    * [x] Register renderer to all tables via Dem aspects and object paths.
    * [x] Make it easy to activate this aspect via Dem config.
    * [ ] Add project files in `src/main/html` to path context and make thereby the fullscreen version of renderer discoverable on the website.
    * [x] Provide config for the web server project, where every feature is enabled. This general workflow/app thing would be good in the future for all projects. This could be done via workflow or app classes like the class Dem.  -> This is not needed for now.
        * [x] Document this in general Java project guidelines.  -> This is not needed for now.
    * [x] Fix layout issue. Otherwise it is hard to find the correct paths via GUI: https://todo.sr.ht/~splitcells-net/net.splitcells.network/108
    * [x] Create dynamic 3D world viewer (currently only Git repo worlds are rendered).
    * [ ] Make game usable on Steam Deck.
        * [ ] Integrate controller via Web Gamepad API, which makes should make it possible to move the camera through the world.
        * [ ] Make it possible to switch between views of 3D world, tables and constraints.
        * [ ] Make game easily installable on Steam Deck via Flatpak: #195
    * [ ] Clean up GUI and make it usable and somewhat nice.
* [ ] Implement game of life.
    * [ ] Run game.
    * [x] Visualize state via file.
    * [ ] Make it easy to move camera anywhere in state visualization, in order to traverse big worlds.
    * [ ] Implement constraints.
        * [x] Support multiple outgoing groups for one line of incoming group in constraint node.
        * [x] Create timeSteps rater.
            * [x] Make timeSteps without overlapping groups, because this is not supported. Instead, one can use the instances of timeSteps raters, where one represents start times with even values and one represents start times with odd values. This makes the initial implementation easier, because Gel does not support raters with overlapping groups yet.
            * [x] Test time step group content and not just number of groups.
            * [x] Test with random allocations. -> Not needed for now, I hope.
            * [x] Check why linear initialization has non-linear supply and demand selection.
            * [x] During addition and removal, rating events should be calculated by the rater.
        * [x] positionCluster
           * [x] Test negative coordinates.
           * [x] Implement overlapping position groups.
           * [x] Ensure that center position is the groups name.
           * [x] Add constraint to problem.
        * [x] isAlive
          * [x] Implement line removal.
          * [x] Only add cost to center position.
        * [x] loneliness
          * [x] Implement meta data for GroupId.
          * [x] Set cluster position's center position in meta data.
          * [x] Addition of center position.
          * [x] Create rater base class, that allows a slower but simplified rater implementation.
            Use this base class for the loneliness implementation. ->
            This is done via GroupRouter.
        * [x] dies
        * [x] goodCompany
        * [x] survives
        * [x] crowded
        * [x] revivalCondition
        * [x] becomesAlive
    * [x] Check constraints via tests.
    * [x] Visualize state of running instance.
      * [x] Render state at any time.
      * [x] Does not work in Firefox.
    * [x] Check constraints via test run.
      * [x] All GroupdIds should be created based on parent GroupIds, except the root ones.
        Thereby, creating duplicate GroupId descriptions is avoided.
      * [x] `The following is required, but not true: path: [conway-s-game-of-life, Propagation, ForAll, 6, Propagation, ForAll, 0, Propagation, ForAll, isDead, ForAll, .lines, allocations/linesProcessing, linesProcessing, demands-free], line.index(): 0`
        * This happens because an allocation is removed multiple times.
        * This is not caused by changing the time step GroupId from `no-time-step-group` to a time step group.
        * [x] This is maybe caused by `PlayerValuePersistenceClassifier`s rating update code,
          where for every line update, all line ratings are updated, regardless,
          if the rating of already present lines is changing or not.
      * [x] Improve runtime performance, because the calculation of the next state given a current state with about 200 hundred variables
        takes 2 minutes via the linear initialization.
        -> It is enough for now to set `StaticFlags#ENFORCING_UNIT_CONSISTENCY` to false.
      * [x] Require all Raters to have an implementation of toSimpleDescription.
      * [x] Require all Raters based on rater factories to have an explicitly programmed description,
        in order to always have useful reports.
      * [x] Create solver able to calculate the next state.
      * [x] Improve performance by setting `Table.GET_LINE_VIA_STREAM` to true.
        * [x] Fix errors caused by this.
      * [x] Add constraint to disallow changes to values, that are not of the next time.
        There are multiple possible solutions. 
        * [x] TemplateAdherence -> Is not relevant for now.
        * [x] CommitmentAdherence
          * [x] Use this as the basis for proposal algorithm inside constraint based repair.
            * [x] Implement proposal API for constraint nodes.
            * [x] Implement IsDead and IsAlive correctly.
              * [x] Implement `IsAlive#testAliveWithMultiple`.
              * [x] Implement IsAlive like IsDead. 
              * [x] Time step determination does not seem to be working.
            * [x] Position clustering does not seem to be working.
              * [x] `no-time-step-group` should not be propagated by constraint nodes to its children.
            * [x] `World#hasGoodCompany` does not seem to be working correctly.#
            * [x] `World#revivalCondition` does not seem to be working correctly.
    * [ ] Apply all tests for this only onto complete world instance.
      * [ ] Document the reasoning in guidelines for optimization programming.
    * [ ] Support problem instances with more than 1 time step in a loop.
     * [x] Update renderer in such a way, that it updates the viewed time to the latest one automatically.
     * [ ] There is probably a problem with time steps.
       * [ ] Improve runtime performance, because it the runtime is too extreme.
         * [ ] Remove constraint nodes in order to check, what causes the issue.
         * [ ] Implement a faster database implementation, which speed up is based on line based value storage,
           instead of column based value storage, which in turn can avoid copying values,
           when lines are transferred from one database to a another one. CURRENT
           * [ ] Line based value storage -> LineWithValues
           * [ ] Column access values via list of lines shared by database to all of its columns.
             Therefore, columns are read only.
           * [ ] DatabaseTest should test all database implementations.
           * [ ] Speed up LookupTable.
           * [ ] Speed up LookupI.
           * [ ] Speed up LookupColumn.
         * [ ] Speed up constraint nodes by improving free or used demand and supply handling.
         * [x] Implement faster allocations database for faster constraint nodes. -> This is not needed, because the bulk of slowness is not caused by the slow allocations implementation.  
           * [x] Rename Allocations to Assignments.
           * [x] Provide Allocations interface for assignments, where only one assignment per demand and supply is allowed.
           * [x] Provide fast Allocations interface implementation as an alternative to Assignments implementation. -> This not needed for now.
         * [x] Improve lookup via `Line#value`.
           * [x] Provide faster alternative to `Database#add`, where the target database header needs to be an exact prefix of the line's header.
           * [x] Improve performance of `Allocations#remove`.
           * [x] Improve performance of `Allocations#allocate`.
         * [ ] Ensure, that `StaticFlags#logStaticFlags` is always executed and printed.
         * [ ] Set `INLINE_STANDARD_FACTORIES` to true.
         * [ ] Reimplement the constraint of the problem, so that the result creates is faster.
       * [ ] The constraint init seems to be ignored.
       * [ ] A error was found: `at net.splitcells.gel.data.table.Table.toCSV(Table.java:209)`
    * [ ] Load state from cin log repo.
    * [ ] Save state to cin log repo.
* [x] Make layout of Gel's game data nice.
* [x] Create easy to use debug view of state via web server, that is active by default in dev-Config.
  -> The standard layout view `http://localhost:8448/net/splitcells/website/layout.html` is good enough.
  * [x] `Cin.configure(env);`
  * This is provided via `GelDev#process` and the port 8448 is used for this by default.
  * [x] Fix layout refresh error.
  * [x] Create tree view of layout.
* [ ] Implement game of life with 2 players.
* [ ] Implement game of life with 2 players, where each player has choices and wants to maximize its liveness.
* [x] Find a name: crisis network = cin
    * [ ] Document reasoning for name.
* [ ] Run private server with public world result state.
* [ ] Serve all JavaScript dependencies locally.
  * [ ] Consider https://vitejs.dev/ 
* [x] Make it easy to execute software in IDE with ENFORCING_UNIT_CONSISTENCY_KEY set to false,
  in order to have reasonable runtime performance.
* [x] Make web server for debugging more mature.
  Currently, it takes a long time to start and the code is an hack.
* Write article explaining and demonstrating this.
# Ideas For Future Tickets
* [ ] Create constraint renderer.
* [ ] Create constraint editor.
* [ ] Create table editor.
* [ ] Create automatic game instance reporter for local execution and social media advertisement.
* [ ] Large moving entities with large and diverse capabilities and with supply chain requirements (i.e. something like vehicles, aircraft or aircraft carrier).
* [ ] Make this a blockchain game and thereby trigger people.
* [ ] Run public server.
    * [ ] Create service infrastructure in order to run webserver in the background via a nice and sustainable API.
* [x] Create a world presenter.
    * [x] https://www.theatrejs.com/
* [ ] Visualize optimization and table network overview.