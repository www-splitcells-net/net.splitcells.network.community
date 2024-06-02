# Create performance analyser
There is now a performance problem class,
that is caused by a large network of databases,
that are interlinked with each other.

The effect often is,
that one element changes, and this causes a lot of changes in other tables.
This can be created with a number of APIs:
* [ ] Using lookups with predicates, that are dynamically created.
* [ ] Implementing ratings in such a way, that every line rating in a group is updated, even though just 1 really changed.

It would be nice to have an option,
that enables code, that helps to find performance problems:
* [ ] Create statistics for databases, columns and lookups in general.
* [ ] Create statistics for constraint calculations. Determining the number of rating events per new allocation or deallocation, on average, would probably help in a lot of cases.
* [ ] Render results on web server.