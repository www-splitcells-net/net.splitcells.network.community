# Weekly deploy static website.
* Issue number: [\#67](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/67)
# Task Description
Currently, in Maven projects for resources the folders md, resources and xml used.
This was introduced, as it was seen as the Maven kind of way,
to organize resource files,
but in most other public projects this is not done that way.
Even projects like the Mavens [site plugin](https://github.com/apache/maven-site-plugin/tree/master/src/main/resources)
is doing it that way.

Furthermore, it gets complicated when multiple documents of different formats with the same topic are handled,
as this leads to a situation,
where one has to switch between such folders in the IDE all the time.
This wastes a lot of time.
Therefore, the md and xml folders will be abandoned in Maven projects.
# Tasks
* [ ] Even Maven projects mix file types in such folders. See https://github.com/apache/maven-resolver/tree/master/src/site
