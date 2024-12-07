# Implement constraints without assignments
# Task Description
Assignments and allocations are very resource heavy,
as for every assignment line there are 7 correspond tables required.
Implement the constraint basis with just one table,
in order to speed up the constraints.
# Tasks
* [ ] Create a copy of the existing constraint implementation,
  where everything is placed in one file.
* [ ] Replace assignment table with ordinary table.
* [ ] Create simple test case, to measure difference in table modification count.
* [ ] Create simple test case, in order to compare runtime differences.
* [ ] Keep both implementations, as this ensures, that the constraint implementation keeps being replaceable.
