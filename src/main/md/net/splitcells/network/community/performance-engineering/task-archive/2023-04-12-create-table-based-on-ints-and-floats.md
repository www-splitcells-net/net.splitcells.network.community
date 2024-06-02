# Create table based on ints and floats
* [ ] Improve runtime performance by using and support primitives. ints and floats are used, as these seem to be the most optimal on Java: https://stackoverflow.com/questions/19844048/why-is-long-slower-than-int-in-x64-java
    * [ ] Extend table interface with direct and zero overhead support for primitive values.
    * [ ]  An optimization problem should be solvable by just relying on the interface for primitive values. This requires, that each subsystem, optionally, may only rely on primitive value interfaces of other sub system. Is this doable? Let's try out.
* [ ] Test if this is really faster, than using complex types.
* [ ]  Consider using JMH for advanced benchmarking: https://openjdk.org/projects/code-tools/jmh/