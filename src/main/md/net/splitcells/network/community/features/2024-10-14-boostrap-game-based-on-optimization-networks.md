# Bootstrap game based on optimization networks
* Issue number: [\#51](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/51)
# Task Description
It was [attempted](task-archive/2022-12-21-1-create-game-based-on-optimization-networks.md) to create a game,
but it failed for now, because of performance problems caused by modelling space-time as an optimization problem.
This task will be resumed later.

It came to my mind, that bootstrapping the game with a 3-dimensional world is not strictly needed.
So, instead of starting with a 3-dimensional world,
we bootstrap the game development by starting with a minimal entity manager and some really simple game rules.
Thereby, we still model the time of the game as an optimization problem,
that is an interesting feature for the future,
while still being able to quickly create a minimal running game.

The reason for the bootstrapping,
is the fact, that is a lot easier to work on something,
that works already,
than to tinker on something, that cannot be run at all.
In order to keep it simple, there is no user input for the bootstrapped game.
# Tasks
* [o] [Add game to live distro via Cell API.](../compatibility-portability-and-adaptability/2024-08-06-establish-cell-api.md) -> This is not needed for now.
* [ ] Create minimal game. 
    * [x] Create timeline.
    * [x] Allocate demands by creating appropriate supply objects randomly on the fly, instead of pre creating supply objects.
    * [x] Create time step raters as base for further raters. -> The existing one was undeprecated.
    * [ ] Decrement players' value by one every time step  via constraints. Check this in unit tests.
    * [ ] Increment select players' value by an action every time step  via constraints. Check this in unit tests.
    * [ ] Delete players with value of zero via constraints. Check this in unit tests.
    * [ ] Create guided optimization, instead of a random optimization.
* [ ] This features demonstrates some severe performance and performance analysis problems.
  This is a good time to do something about it, because this task is so small scale and therefore easy to optimize. 
    * [ ] Optimize runtime performance of allocations and constraint.
      Adding and removing of free supplies is pretty fast,
      but adding free supplies and demands, allocating these and removing these, is multiple magnitudes slower.
      This should only be 1 magnitude slower at most.
        * [x] Consider ["Create performance analyser"](../performance-engineering/2023-06-06-create-performance-analyser.md).
        * [x] Draft performance logger of database.
        * [ ] Draft performance logger of lookups.
        * [o] Draft performance logger of solutions regarding the allocation and removal counter without weighting the values of every allocation.
          -> It is enough to observe the modification counter of the solution database.
        * [x] Visualize logging.
            * [x] Histogram of Sum
            * [x] Histogram for Each Object
        * [ ] Speed up allocation database by using single database with line updates.
            * [ ] Create a test, that measures the number of value changes of a database versus an allocation database with the same content.
            * [ ] Create a test, that measures the runtime of a database versus an allocation database with the same content.
        * [ ] Speed up constraint nodes by using single database with line updates.
        * [x] Fix the `Discoverable#path` of every table, so that database specific performance analysis gets easier.
            * [x] Define root path, that is used as a direct or indirect parent of all discoverable objects.
              -> The option is called ProgramsDiscoveryPath.
            * [x] All database constructors with discoverable parent, should get the discoverable root of the current program.
            * [x] Fix duplicate and missing discoverable paths of demands and supplies in allocations or solutions,
        * [ ] Fix the `Discoverable#path` of every look-ups, so that database specific performance analysis gets easier.
        * [x] Render sum counters on website server as graphs
        * [x] Avoid duplicate paths of ObjectsRenderer.
        * [x] Make Counter thread safe.
        * [x] Make MetaCounter thread safe.
        * [ ] Render all table like things on webserver, so these can be observed and performance can be analysed better.
          This way one knows how many table like things are created and how much these are used.
            * [ ] Create aspects that creates a thread safe database based mirror for every table like thing,
              This way, the process's databases do not have to made thread safe by default.
              This can also be used, in order to increase the performance, in case only some databases are actively observed.
              Furthermore, this enables one to completely avoid the synchronization overhead for best performance.
            * [ ] Render all databases on webserver.
            * [ ] Render all lookups on webserver.
* [ ] Render the game's current state.
    * [x] Make rendering of game thread safe.
* [ ] Add game to live server.
* [ ] Add reporter to the game, that creates new reports on website and social media about the instance running on the live server.
* [ ] Create minimal advertisement.
    * [ ] Create logo for Cin.
    * [ ] Consider subtitle for the first running version: `No Rest for The Guilty`
