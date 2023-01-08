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
    * [ ] Gamification
    * [ ] Alternative or counterpart to test recursion:
    create meaning full tests by combining test problems and thereby creating bigger and
    more complex problems and test data.
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
    * [ ] Create dynamic 3D world viewer (currently only Git repo worlds are rendered).
    * [ ] Make game usable on Steam Deck.
        * [ ] Integrate controller via Web Gamepad API, which makes should make it possible to move the camera through the world.
        * [ ] Make it possible to switch between views of 3D world, tables and constraints.
        * [ ] Make game easily installable on Steam Deck via Flatpak: #195
    * [ ] Clean up GUI and make it usable and somewhat nice.
* [ ] Implement game of life.
    * [ ] Run game.
    * [x] Visualize state.
    * [ ] Make it easy to move camera anywhere in state visualization, in order to traverse big worlds.
    * [ ] Implement constraints.
        * [x] Support multiple outgoing groups for one line of incoming group in constraint node.
        * [x] Create timeSteps rater.
            * [x] Make timeSteps without overlapping groups, because this is not supported. Instead, one can use the instances of timeSteps raters, where one represents start times with even values and one represents start times with odd values. This makes the initial implementation easier, because Gel does not support raters with overlapping groups yet.
            * [x] Test time step group content and not just number of groups.
            * [x] Test with random allocations. -> Not needed for now, I hope.
            * [x] Check why linear initialization has non-linear supply and demand selection.
            * [x] During addition and removal, rating events should be calculated by the rater.
        * [ ] positionCluster CURRENT
           * [x] Test negative coordinates.
           * [ ] Implement overlapping position groups.
        * [ ] isAlive
        * [ ] oneliness
        * [ ] dies
        * [ ] survives
        * [ ] goodCompany
        * [ ] crowded
        * [ ] isDead
        * [ ] reviavlCondition
        * [ ] becomesAlive
        * [ ] unchanged
    * [ ] Check constraints via tests.
    * [ ] Check constraints via test run.
    * [ ] Load state from cin log repo.
    * [ ] Save state to cin log repo.
* [ ] Implement game of life with 2 players.
* [ ] Implement game of life with 2 players, where each player has choices and wants to maximize its liveness.
* [x] Find a name: crisis network = cin
    * [ ] Document reasoning for name.
* [ ] Run private server with public world result state.
# Ideas For Future Tickets
* [ ] Create constraint renderer.
* [ ] Create constraint editor.
* [ ] Create table editor.
* [ ] Create automatic game instance reporter for local execution and social media advertisement.
* [ ] Large moving entities with large and diverse capabilities and with supply chain requirements (i.e. something like vehicles, aircraft or aircraft carrier).
* [ ] Make this a blockchain game and thereby trigger people.
* [ ] Run public server.
* [ ] Create a world presenter.
    * [ ] https://www.theatrejs.com/
* [ ] Visualize optimization and table network overview.