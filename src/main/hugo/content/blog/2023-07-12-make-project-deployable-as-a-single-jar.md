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
        * [x] FileStructureTransformer CURRENT
          * [x] newInputStream
            * [x] Use temporary folders for filesystem testing.
            * [x] XslTransformer
              * [x] PathBasedUriResolver
    * [x] LayoutUtils 
    * [ ] Projects
      * [ ] Use Projects via FileSystem Options.
        * [X] Provide FileSystem implementation based on resources of class loader.
        * [ ] FileSystemViaClass
        * [ ] ProjectsViaJar
          * [ ] Move this to system project.
        * [ ] Make this alternative via taggable via config.
        * [ ] Provide source file structure inside jar in order to make this file access more similar to access
          to files via git repos.
* [ ] Make website deployable as a dynamic server.
* [ ] Remove the need of private module for website deployment: https://github.com/www-splitcells-net/net.splitcells.network/issues/199
* [ ] Create dedicated deployment project and clean up the dependencies of `net.splitcells.website.server`.