# Ensure local unique discoverability
# Task
Every net.splitcells.dem.object.Discoverable needs to unique,
as otherwise this will only cause server issues.
Do this by adding a manager attribute to Discoverable,
that manages all complex actions.
Make the whole discovery tree traversable via the root node.