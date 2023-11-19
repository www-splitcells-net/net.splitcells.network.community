# Splitcells Network Projects
## Overview And Status
* [splitcells.net Status](https://splitcells.net/net/splitcells/network/status.html)
## Standard Projects
Projects that are being worked cyclically, and probably will never be finished.
* Accessibility: Improve accessibility:
  * Description: We want to use the software, guys. RIGHT?! Right? right? ... ehh
  * [Host Link](https://github.com/orgs/www-splitcells-net/projects/5)
  * Review advertisement, introductions and info linked by README,
    because that is the primary material for newcomers.
* Compatibility, portability and adaptability:
  * Description: Make code easy portable, translatable and adaptable to other languages and environments.
  * [Host Link](https://github.com/orgs/www-splitcells-net/projects/4)
* Cooperation and symbiosis:
  * Description: Tit for tat
  * [Host Link](https://github.com/orgs/www-splitcells-net/projects/8)
  * Migrate inactive tickets into source code repository,
    so that they each one acts as trigger at one fitting position.
* Document project:
  * Description: Nobody reads this xD
  * [Host Link](https://github.com/orgs/www-splitcells-net/projects/9)
* Features: Removal, Addition and Improvements
  * Description: To the moon!
  * [Host Link](https://github.com/orgs/www-splitcells-net/projects/7)
* Maintenance project:
  * Description: Improve quality and fix bugs.
  * [Host Link](https://github.com/orgs/www-splitcells-net/projects/3)
* Deployment project
  * [Host Link](https://github.com/orgs/www-splitcells-net/projects/10/views/1)
* Performance Engineering 
  * Description: We have a need for speed.
  * [Host Link](https://github.com/orgs/www-splitcells-net/projects/6)
* Webserver Development
  * [Host Link](https://todo.sr.ht/~splitcells-net/net.splitcells.network?search=label%3A%22active%22)
## Notes
* This is a ticket system in the form of a blog.
* Previously, Hugo was used, but Hugo requires a special subset of CommonMark format.
    A simplified and therefore easily portable folder structure is preferred.
    Most notably, links between documents cannot be correct in the source code and in the rendered website.
* Generally speaking all tickets should be reachable via this blog.
* This blog is only used for complex or important tickets, that may create lasting requirements.
  It may also be used for tickets, were its reasoning is important or complex and therefore needs to be documented,
  but does not make sense to be placed inside the source code repo.
  Other tickets are linked from this blog.
* A dedicated Git repo is used in order to avoid problems caused by polluting other repos.
  As this repo is about any ticket related to network projects,
  this also avoids commits to other Git repos,
  which contains tickets unrelated to the other Git repos.
* Git-bug is not used,
  because it is not possible to read and edit its content via git and text editors.
  Instead, the program git-bug itself is required.
  Git-bug could be used in the future in order to mirror tickets to another platform.