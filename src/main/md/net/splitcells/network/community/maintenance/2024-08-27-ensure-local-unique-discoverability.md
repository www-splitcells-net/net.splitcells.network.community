# Ensure local unique discoverability
# Task Description
Every net.splitcells.dem.object.Discoverable needs a unique path,
as otherwise this will only cause website server issues during request routing.
Do this by adding a manager attribute to every Discoverable,
that manages all complex actions and Discoverable constructions.
Make the whole discovery tree traversable via the root node.
# Tasks
* [ ] Create Discovery class as a manager for each Discoverable.
* [ ] Make Discovery tree traversable.
* [ ] Optionally enforce unique Discoverable paths via Discoveries during the Discoverable construction.
* [ ] Migrate all API usage to the optional enforcement method.
* [ ] Make optional enforcement method mandatory.
* [ ] Remove Discoverable construction without enforcement.
* [ ] Use `Dem#process` specific Discovery option, that is the root of all Discoveries.