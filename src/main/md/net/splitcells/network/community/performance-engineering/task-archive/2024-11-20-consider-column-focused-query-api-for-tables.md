# Consider column focused query API for tables

The current lookup API is only good for looking up lines based on the value of one attribute.
Lookups of lines based on the values of multiple attributes has not good performance characteristics and
makes it hard to implement a none caching version of it, because of an API.

Consider providing query methods for tables,
that take a set of attributes with its corresponding filters and returns the matching lines.
It should be easy to create an implementation based on the existing lookup API and
an implementation that does not cache anything.

Consider Java's value records in order to define the signature of such methods,
that are a bit more performant than a version, that takes a full object as an argument.