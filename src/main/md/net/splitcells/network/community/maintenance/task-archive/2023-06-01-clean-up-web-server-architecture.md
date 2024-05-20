# Clean up web server architecture.
The web server's architecture is too domain specific,
as it takes too much into account how the rendering is done.
This creates problems from time to time, when new features are implemented.

There is an old idea how to fix it:
the renderer interface should represent a file system,
where one can request a file given a path and the required file format. The root renderer should contain a set of sub renderers of the same interface. Some renderers provide just bare files, and others can only transform files based on requesting the bare files from other renderers.
In effect, the renderer interface would work a little bit like XSL.

Every time, a new problem raised, and the architecture had to be changed for the new feature, the architecture was changed as little as possible and as much as possible in the direction mentioned above.

It's time to make the transformation complete.
* [ ] Make `ProjectRendererExtension` and `ProjectRenderer` the same.
* [ ] Migrate `ProjectsRendererExtension` classes to `ProjectsRenderer` and delete the old interface.
* [ ] `ProjectRenderer` interface should not contain any basic rendering utilities.
* [ ] Create new interface:
    * [ ] `render(path, format, rootRenderer)`
    * [ ] `projectPaths(format)`
    * [ ] `relevantProjectPaths(format)`
* [ ] Deprecate old interface.
* [ ] Implement new interface.
* [ ] Delete old interface implementations.