# Support databases based on primitives
# Task Description
The current way of having databases with complex attributes and columns greatly reduces performance,
that creates more and more problems over time.
Instead, we should support table/columns with fast and widely supported primitives like int and float.

Complex attributes could still be supported by using primitive values,
that represent complex objects.
We would still have table methods,
that provide access to complex values and would provide additional access methods for the primitives.
This way a hard migration can be avoided.

This could be done in such a way,
that the developer of the API does not even see this distinction directly without looking into the details.
The table would internally map each complex object to a primitive of a certain table.

In order to better the performance in such cases as well,
the rater and constraint implementations would also have to be adjusted.
Also, the databases could support the concept of flattening an object,
by creating a new column for each relevant object field.
# Tasks