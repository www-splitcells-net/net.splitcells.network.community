---
title: Make the project deployable as a single jar.
date: 2023-07-12
author: Mārtiņš Avots
tags: [accessibility, active]
---
* [ ] Add support for jar based filesystem to webserver,
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
          * [x] `maven.execute net.splitcells.system.WebsiteViaJar`
          * [x] Use dedicated resource folder in jar.
          * [x] Add all projects via new file system API.
            * [x] Split network project into root project and file project.
        * [x] Provide source file structure inside jar in order to make this file access more similar to access
          to files via git repos. CURRENT
  * [ ] Make it taggable to use local file system, instead of the jar based file system.
* [ ] Make website deployable as a dynamic server.
* [ ] **CURRENT** Remove the need of private module for website deployment: https://github.com/www-splitcells-net/net.splitcells.network/issues/199
* [ ] Create dedicated deployment project and clean up the dependencies of `net.splitcells.website.server`.