# Ensure local unique discoverability
* Issue number: [\#56](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/56)
# Task Description
Every net.splitcells.dem.object.Discoverable needs a unique path,
as otherwise this will only cause website server issues during request routing.
Do this by adding a manager attribute to every Discoverable,
that manages all complex actions and Discoverable constructions.
Make the whole discovery tree traversable via the root node.
# Tasks
* [x] Create Discovery interface as a manager for each Discoverable.
* [x] Implement Discovery interface.
* [x] Document interface.
* [x] Test Discovery implementation.
* [x] Use `Dem#process` specific Discovery option, that is the root of all Discoveries.
* [x] Make Discovery tree traversable.
* [x] Optionally check unique Discoverable paths via Discoveries provided by Discoverable.
  Every Discoverable with a none empty Discovery, has a unique discoverable path.
* [o] Create a renderer for Discovery elements. See `DiscoveryRenderer`.
  -> Add the required functionality to ObjectsMediaRendererI instead of DiscoveryRenderer,
  as this whole thing is just about the paths.
  DiscoveryRenderer is deleted.
    * [o] Implement DiscoveryRendererImpl like ObjectsMediaRendererI.
    * [o] Test it with one element as a proof of concept.
    * [o] Enable DiscoveryRendererImpl on website server.
* [ ] Add optional Rendering via Discovery ObjectsMediaRendererI
  * [ ] Check if Discovery is present and use its path instead.
  * [ ] Unit test ObjectsMediaRendererI.
* [ ] Migrate all API usage to the optional check method.
* [ ] Make optional check method mandatory.
* [ ] Convert the unique Discoverable paths check, with an enforcement.
* [ ] Remove Discoverable construction without enforcement.
* [ ] Update Network objectives at `projects/net.splitcells.network/src/main/xml/net/splitcells/network/objectives.xml`,
  as this becomes the main Java implementation regarding the semantic inventory system.
* [ ] Enforce via an extra check, that the Discovery is a tree.
* [ ] Update Network subproject objectives regarding the status of this: net/splitcells/network/objectives.xml