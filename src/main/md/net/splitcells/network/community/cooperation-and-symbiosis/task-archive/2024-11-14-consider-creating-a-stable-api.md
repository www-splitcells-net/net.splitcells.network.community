# Consider creating a stable API.
# Task Description
Currently, a stable internal API is not justifiable,
because of the changing features and performance issues.
## Option 1
Create a new project called `net.splitcells.stability`, that contains the stable API.
User needing a stable API are only allowed to use this project directly.
By creating a dedicated API just for stability,
one can ensure an stable API, while allowing big changes in the background.

This API project would provide all of its functionality via a fluent API,
that start always with the same function call. 
This way, the supported usages of the API can be controlled very strictly
by strictly defining the life cycle of each action in the fluent API.

A big advantage of this is,
that later on a different strategy can be chosen and relatively easily migrated to later on.
## Option 2
Provide a dedicated API package for each project and control,
which things are truly public via annotations and other means.