---
title: Make the project deployable as a single jar.
date: 2023-07-12
author: Mārtiņš Avots
tags: [accessibility, active]
---
* [ ] Add support for jar based filesystem to webserver,
  instead of the files being available on the hosts filesystem.
    * [ ] ProjectsRendererExtension
    * [ ] ProjectRenderer
      * [ ] ProjectRenderer#projectRenderer
      * [ ] ProjectRendererI#renderer and transformer
        * [x] FileStructureTransformer CURRENT
          * [x] newInputStream
            * [x] Use temporary folders for filesystem testing.
            * [x] XslTransformer
              * [x] PathBasedUriResolver
    * [ ] LayoutUtils 
* [ ] Make website deployable as a dynamic server.
* [ ] Remove the need of private module for website deployment: https://github.com/www-splitcells-net/net.splitcells.network/issues/199