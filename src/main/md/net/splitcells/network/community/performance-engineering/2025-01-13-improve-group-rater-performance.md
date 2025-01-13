# Improve group rater performance.
* Issue number: [\#57](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/57)
# Task Description
It is suspected, that TimeSteps and LineGroupRater cause most of the runtime performance issues,
by recalculating the rating of the complete group when one line changes.
This in turn seem to trigger an exponential amount rating recalculations at the child constraints
in relation to the group size and the constraint tree depth,
especially when LineGroupRaters are nested in the constraint group.