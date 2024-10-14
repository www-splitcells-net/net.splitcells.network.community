# Bootstrap game based on optimization networks
* Issue number: [\#51](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/51)
# Task Description
# Tasks
* [ ] Consider subtitle for the first running version: `No Rest for The Guilty`
* [ ] Create the overarching story for the game, that defines the direction of this project.
    * [ ] Provide a space where one can input anything related to optimization and improves these if possible.
      For instance, optimizers could be stored and used in order to create better optimizers.
      Furthermore, one could inject a optimization problem and reward into this system in order to get it solved.
    * [ ] The space also provides a world, where injected/inputs are represented.
      This world is the game's main level.
    * [ ] Optimizers in this space require resources in order to be executed.
      The resources are earned by optimizing the world.
      The reward is provided by the space's meta optimizer.
      The space deletes the world's meta optimizers, that do not earn enough.
    * [ ] Meta optimizers optimize optimizers. Their rater, that the meta optimizers optimize,
      weighs the rating of the individual optimizers differently and thereby creates an in and out group mechanic.
    * [ ] Meta optimizers are fighting each other, in order to get enough rewards by the space.
      The space provides a changing amount of rewards each turn.
      When there is not enough reward provided by the space, the meta optimizers have to try to kill the each others optimizers.
    * [ ] The space provides a changing amount of rewards each turn, in order to optimize the meta optimizers.
      During each cycle there are 2 spaces.
      At the end of each cycle, the space with the best meta optimizer survives.
      The other space is deleted.
      The clone of the best meta optimizer becomes the space's new meta optimizer and a new clone of the space is created.
      The cycle start again.
* [ ] Add game to live distro via Cell API.
* [ ] Create minimal game.
* [ ] Add reporter to the game, that creates new reports on website and social media about the instance running on the live server.
* [ ] Create logo for Cin.