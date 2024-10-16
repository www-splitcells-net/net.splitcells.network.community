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
* [ ] [Add game to live distro via Cell API.](../compatibility-portability-and-adaptability/2024-08-06-establish-cell-api.md)
* [ ] Create minimal game. 
    * [x] Create timeline.
    * [ ] Provide supplies.
    * [ ] Allocate values randomly.
    * [ ] Delete players with value of zero.
    * [ ] Decrement players' value by one every time step.
    * [ ] Increment select players' value by an action every time step.
* [ ] Render the game's current state.
  * [ ] Make rendering of game thread safe.
* [ ] Add game to live server.
* [ ] Add reporter to the game, that creates new reports on website and social media about the instance running on the live server.
* [ ] Create minimal advertisement.
    * [ ] Create logo for Cin.
    * [ ] Consider subtitle for the first running version: `No Rest for The Guilty`