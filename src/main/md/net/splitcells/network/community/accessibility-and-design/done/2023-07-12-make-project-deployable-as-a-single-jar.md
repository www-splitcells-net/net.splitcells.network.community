# Make the project deployable as a single jar.
* Start Date: 2023-07-12
* End Date: 2024-05-08
* [x] Add support for jar based filesystem to webserver,
  instead of the files being available on the hosts filesystem.
    * [x] ProjectsRendererExtension
    * [x] ProjectRenderer
      * [x] ProjectRenderer#projectRenderer
      * [x] ProjectRendererI#renderer and transformer
        * [x] FileStructureTransformer
          * [x] newInputStream
            * [x] Use temporary folders for filesystem testing.
            * [x] XslTransformer
              * [x] PathBasedUriResolver
    * [x] LayoutUtils 
    * [x] Projects
      * [x] Use Projects via FileSystem Options.
        * [x] Provide FileSystem implementation based on resources of class loader.
        * [x] FileSystemViaClass
        * [x] ProjectsViaJar
          * [x] Move this to system project.
          * [x] `maven.execute net.splitcells.network.distro.Distro`
            * [x] Does not work via shell, but works via IDE.
            * [x] `src/main/**/*` are not loaded. There is probably a file walk error.
          * [x] Use dedicated resource folder in jar.
          * [x] Add all projects via new file system API.
            * [x] Split network project into root project and file project.
        * [x] Provide source file structure inside jar in order to make this file access more similar to access
          to files via git repos. CURRENT
  * [x] Make personal website runnable again.
  * [x] Make it possible to run server a fat jar.
* [x] Make website deployable as a dynamic server.
* [x] Remove the need of private module for website deployment: https://github.com/www-splitcells-net/net.splitcells.network/issues/199