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
    * [o] Create world event table, so that conflicting rules like incrementing or decrementing the player's energy can be applied/defined additively.
      Consider doing this via a player with id -1 in the main entities table.
      Alternatively, consider adding a new supply attribute named event type and allow multiple allocations for one demand.
      -> The event type variant is considered, but with single assignments instead of multiple allocations for one demand
    * [x] Decrement players' value by one every time step via constraints. Check this in unit tests. Name the rater PlayerEnergyConsumption.
        * [x] Provide a helper method, that creates a derived table based on column containing lines.
          The derived table, contains all columns of the original table plus the columns of the lines in the line column. 
        * [x] Create ExistenceCostTest.
    * [ ] CURRENT Create general event based attribute update rater.
        * [x] Consider player attribute deletion.
        * [x] Visualize table via Tabulator in order to better analyse results by hand.
        * [x] Render all tables in dev distro.
        * [x] Use [Fancytree](https://github.com/mar10/fancytree), in order to visualize the websites tree layout.
            * [x] Expand license NOTICE.
            * [x] Provide alternative drawing of tree via Fancytree.
              Add a path attribute to a tree, where the server provides a JSON fitting for Fancytree.
                * [x] Test dictionaries inside an array for `Test#toJsonString()`.
            * [x] Improve Fancytree styling. 
            * [x] Improve Fancytree's iframe height.
            * [x] Add links to Fancytree elements.
        * [x] Second time step is missing, when CinService is running in DevDistro.
        * [ ] Check ratings by hand.
            * [x] ValueUpdate may not correctly read value update events.
                * [x] The collector node for the time step constraint nodes does not process incoming lines correctly.
            * [ ] CURRENT Test LookupColumn, as the current implementation is error-prone.
            * [o] There are not value update events, but this is not a problem of the rater.
        * [x] Improve argumentation rendering, in order to better understands augmentations. Currently, somewhat augmentations are very hard to read.
            * [x] Limit the default maximal length of a Tabulator column by a sane value, so that the width of the reasoning column is limited.
            * [x] Render argumentation as a tree in pop up.
            * [x] Avoid empty elements in rendering of argumentation tree. Test this via `TreeTest#testAsXhtmlList()`.
            * [x] Avoid flattening empty tree nodes in argumentation too much, which results in lossing nearly all nesting. This seems to be caused by the bad argumentation tree. Test this via `ConstraintTest#testArgumentation()` and `TreeTest#testAsXhtmlList()`.
            * [x] Correct reasoning tree, as the tree nodes with a not empty name have never children.
              Test this via `ConstraintTest#testArgumentation()`.
                * [x] `Constraint#naturalArgumentation(Line subject, GroupId group)`
                * [x] `Constraint#naturalArgumentation(Line line, GroupId group, Predicate<AllocationRating> allocationSelector)`
                * [x] `ConstraintBasedOnLocalGroupsAI#localNaturalArgumentation(Line, GroupId, Predicate<AllocationRating>)`
                * [x] `ConstraintBasedOnLocalGroupsAI#localNaturalArgumentation(Report)`
                * [x] `ConstraintBasedOnLocalGroupsAI#naturalArgumentation(GroupId)`
                * [x] `Then#LOCAL_NATURAL_ARGUMENTATION`
                * [x] `ForAll#LOCAL_NATURAL_ARGUMENTATION`
                * [o] Remove all namespaces in argumentation as it currently has no use and hinders the merging of argumentation.
                  -> These do not cause a problem for now.
                * [o] Remove empty intermediate tree nodes. -> These do not cause a problem for now.
                * [x] Maybe Java records are not working as one thought? See https://softwaregarden.dev/en/posts/new-java/records/should-write-equals-and-hashcode/
                * [o] Consider simplifying time step rater by implementing it as a group rater instead.
                  -> The rater is not that complicated, when one considers that some part of the code is an alternative time step rater calculation,
                  in order to gain speed-ups.
                * [x] Avoid caching incoming and resulting line groups, as this is prone to errors.
                * [o] Add a test case for creating a no time step group and check if the resulting group is actually a no time step group.#
                  -> There is already such a test.
    * [ ] Ensure constraint compliance via optimizer.
        * [ ] Create guided optimization, instead of a random optimization.
    * [ ] Increment randomly selected players' value by an action every time step via constraints. Check this in unit tests.
    * [ ] Delete players with value of zero via constraints.
* [x] This features demonstrates some severe performance and performance analysis problems.
  This is a good time to do something about it, because this task is so small scale and therefore easy to optimize.
    * [x] Create a base performance view for the game.
        * [x] Test that measures the runtime of a time step.
          -> Runtime performance seems to be good enough.
        * [o] Test the overhead of the optimization.
          Test that measures the difference of runtime for only setting the data of a time step without any concern for the data
          and the runtime for correctly calculating a time step.
          -> Runtime performance seems to be good enough.
        * [o] Test the overhead of the constraint data structure.
          Test that measures the difference of runtime for only setting the data of a time step without any concern for the data
          with and without any constraints being present.
          -> Runtime performance seems to be good enough.
        * [x] Measure modification counters.
    * [o] Optimize runtime performance of allocations and constraint.
      Adding and removing of free supplies is pretty fast,
      but adding free supplies and demands, allocating these and removing these, is multiple magnitudes slower.
      This should only be 1 magnitude slower at most.
      -> The performance seems to be good enough for now.
        * [x] Consider ["Create performance analyser"](../performance-engineering/2023-06-06-create-performance-analyser.md).
        * [x] Draft performance logger of table.
        * [x] Draft performance logger of lookups.
            * [x] Draft for LookupView
        * [o] Draft performance logger of solutions regarding the allocation and removal counter without weighting the values of every allocation.
          -> It is enough to observe the modification counter of the solution table for now.
        * [x] Visualize logging.
            * [x] Histogram of Sum
            * [x] Histogram for Each Object
        * [o] Speed up allocation table by using single table with line updates.
          -> After testing the speed seems to be good enough for now.
            * [o] Implement the speed-up. -> After testing the speed seems to be good enough for now.
            * [o] Test the speed-up of the new implementation. -> After testing the speed seems to be good enough for now.
            * [x] Create a test, that measures the number of value changes of a table versus an allocation table with the same content.
              See DataTest.
            * [x] Create a test, that measures the runtime of a table versus an allocation table with the same content.
                * [o] Create a timing test, in order to avoid flaky tests where correctness is tested. -> This will be done, when needed.
            * [x] Clean up table naming in order to make the naming more consistent to SQL and avoid confusion.
              This is a preparation for the future, in order to avoid developers assuming, that Tables have constant content.
              A new interface like ConstantTable for this will be used.
                * [x] Rename Table to View.
                * [x] Database to Table.
                * [x] Test Gel UI after that.
                * [x] Note the reason for this naming.
        * [o] Speed up constraint nodes by using single table with line updates. -> After testing the speed seems to be good enough for now.
        * [x] Fix the `Discoverable#path` of every table, so that table specific performance analysis gets easier.
            * [x] Define root path, that is used as a direct or indirect parent of all discoverable objects.
              -> The option is called ProgramsDiscoveryPath.
            * [x] All table constructors with discoverable parent, should get the discoverable root of the current program.
            * [x] Fix duplicate and missing discoverable paths of demands and supplies in allocations or solutions,
        * [x] Render sum counters on website server as graphs
        * [x] Avoid duplicate paths of ObjectsRenderer.
        * [x] Make Counter thread safe.
        * [x] Make MetaCounter thread safe.
* [ ] Render the game's current state.
    * [x] Make rendering of game thread safe.
    * [x] Render all table like things on webserver.
        * [x] Correct path of constraint tables. -> This will be done, when the analysis is required.
        * [o] Fix the `Discoverable#path` of every look-ups, so that table specific performance analysis gets easier. -> Look-ups are not rendered yet.
        * [x] Create aspects that creates a thread safe table based mirror for every table like thing,
          This way, the process's databases do not have to made thread safe by default.
          This can also be used, in order to increase the performance, in case only some databases are actively observed.
          Furthermore, this enables one to completely avoid the synchronization overhead for best performance.
  * [x] Render all databases on webserver.
  * [o] Render all lookups on webserver. -> This is not required for now.
  * [x] Render the rating and the argumentation of solutions. Otherwise, it gets hard to evaluate something by hand.
      * [x] Update all solution argumentation, when one updates occurs.
        Otherwise, not all line augmentations are up to date, when these are rendered.
      * [x] Ensure, that the user sees a complete snapshot of the mirror.
      * [x] Enforce, that all things in the table like the argumentation are nicely rendered for the user.
          * [x] Time step description
          * [x] ExistenceCost
              * [x] Create builder interface for RaterBasedOnLineGroup in order to easily extend this interface in the future.
                Use new class LineGroupRater for that and deprecate GroupRater.
                -> Use GroupingRater as a replacement of LineGroupRater.
              * [x] Ensure that all registered additions in the rater get a rating event.
  * [ ] The entity manager has an error.
  * [x] Consider rendering HTML elements on client side via Tabulator via dependency injection,
    in order to get some sort functionality.
  * [ ] Create Tabulator help page, if a fitting table is present, in order describe things like sorting by multiple columns.
    -> See `src/main/resources/html/net/splitcells/website/js/tabulator.md`.
  * [ ] Replace HTML tables by Tabulator tables on the client side via dependency injection.
  * [ ] Create compact tree renderer, that provides an overview of all line processing tables of the constraint tree,
    which in turn is a more compact tree.
    The tree is compact, be only showing the paths to its leafs and where all path elements are links to appropriate paths.
    It also represents the constraint input language more closely.
    Later on in a new task the no-code editor should represent the state of the constraint tree.
* [ ] Add game to live server.
* [ ] Add reporter to the game, that creates new reports on website and social media about the instance running on the live server.
    * [ ] Draw reporter.
    * [ ] Create reporter story.
    * [ ] Add notification on website, if user is on a page of Cin via toastr.
* [ ] Create minimal advertisement.
    * [ ] Create logo for Cin.
    * [ ] Consider subtitle for the first running version: `No Rest for The Guilty`
    * [ ] `cin.stories`
* [ ] Create design documents.
    * [ ] Art style should allow to start with very minimal models and to easily improves these bit by bit,
      in order to minimize the required resources for the art style as the beginning.
      The minimal art version needs to be nice, so that initially the required work is minimized,
      while more complex improvements are pushed as far as possible into the past.
    * [ ] Use blocks for initial 3D models, as its easiest to model and to create textures/color to such.
* [ ] Create objectives documents.
    * [ ] Provide injection framework for injecting optimization problems into other optimization problems,
      in order to model complex problems via unrelated and therefore easier to develop problems.
# Ideas
* [ ] Integrate school scheduling into game,
  where players learn to retrieve life points by using skills,
  that are acquired in school.
* [ ] Consider creating music via programming: https://sonic-pi.net
* [ ] Consider expanding the rater API in such a way, that the rater not only retrieves the metadata
  of the incoming lines, but also a dedicated table containing the underlying lines of the solution,
  so that the program code for the rater gets simpler.
  Currently, complex raters are too hard to implement.
  Also, consider an alternative constraint implementation, in order to avoid giving lookups to raters,
  which complicates things even further.
  There may be a task for this already.