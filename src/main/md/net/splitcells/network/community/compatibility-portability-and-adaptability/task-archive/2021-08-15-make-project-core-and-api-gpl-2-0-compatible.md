# Make project core and API GPL 2.0+ compatible
The underlying idea behind this, is to change the code from MIT + EPL 2.0 to EPL 2.0 + GPL v2+.
The MIT licence was chosen for this very step in the beginning,
in case, external contributors join the project before the licence transition.

This should only be done for code,
that has only GPL compatible dependencies.

The easiest way to start doing this, is to create subprojects with no external dependencies projects.
These can be moved to their dedicated projects folder and represent projects
where there is full source control.
Such projects will be called core and API projects.
Projects integrating external code are called extension projects.

All external dependencies could be then imported via dependency injection into the pure projects.
Note, that pure projects have to be working without dependency injection as well,
although limited functionality is acceptable.

- [ ] #159 needs to be done, in order to be able to split non GPL 2.0 compliant code from the rest.