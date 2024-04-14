----
* SPDX-License-Identifier: EPL-2.0 OR GPL-2.0-or-later
* SPDX-FileCopyrightText: Contributors To The `net.splitcells.*` Projects
----
# AssertJ considered unfit
AssertJ is well-know in the Java world for providing fluent assertions.
It is an easy and understandable way to write assertions:
````
[...]
import static org.assertj.core.api.Assertions.assertThat;
[...]
assertThat(demands).as("A problem without demands cannot be optimized").isEmpty();
[...]
````
Using AssertJ directly is deprecated in the core implementations and APIs of the project,
as all direct usage of external APIs in such code is deprecated.
Nevertheless, this is not the only reason why AssertJ is not preferred.

First of all, Java does not have extension methods,
which makes it harder to combine assertion methods from different assertion classes for a common type to be checked.
If one needs a new assertion method,
one has to [implement](https://www.baeldung.com/assertj-custom-assertion)
a new assertion class with an appropriate factory method.
If multiple of such classes exist, the right one has to be imported for each check.
Alternatively, one can implement an assertion class,
that includes all other assertion classes.

Furthermore, using the API is not comfortable inside an IDE.
First, one has to write `assertThat([actual])`,
then import that statement,
which is often not done automatically.
If the import statement was added automatically,
you hope, that the `assertThat` from AssertJ and not JUnit was imported.

# Alternative to AssertJ

The following shows, how a list can be checked in AssertJ:
````
[...]
import static org.assertj.core.api.Assertions.assertThat;
[...]
assertThat(demands).as("A problem without demands cannot be optimized").isEmpty();
[...]
````
In the Network project test code is considered to be part of the production code.
Additionally, the project has its wrapper APIs for everything,
so assertion methods can be added to the API directly and without any hassle.

This allows one, to avoid imports and to harvest the IDEs auto complete functionality a lot lazier.
Replacing the backend of the assertion API also becomes easier.
````
[...]
demands.requireEmpty("A problem without demands cannot be optimized");
[...]
````