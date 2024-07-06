# Splitcells Network Projects
## Overview And Status
* [splitcells.net Status](https://splitcells.net/net/splitcells/network/status.html)
## Standard Projects
Projects that are being worked cyclically, and probably will never be finished.
* Accessibility: Improve accessibility:
  * Description: We want to use the software, guys. RIGHT?! Right? right? ... ehh
  * Review advertisement, introductions and info linked by README,
    because that is the primary material for newcomers.
* Compatibility, portability and adaptability:
  * Description: Make code easy portable, translatable and adaptable to other languages and environments.
* Cooperation and symbiosis:
  * Description: Tit for tat
* Document project:
  * Description: Nobody reads this xD
* Features:
  * Description: To the moon!
* Maintenance project:
  * Description: Improve quality and fix bugs.
* Deployment project
  * Description: Administer deployments
* Performance Engineering 
  * Description: We have a need for speed.
* Webserver Development
    * Description: Organizing and presenting data is the foundation of a good day
    * [Host Link](https://codeberg.org/splitcells-net/net.splitcells.network.community/projects/8592)
## Notes
* This is a ticket system in the form of a blog.
  Previously, Hugo was used, but Hugo requires a special subset of CommonMark format.
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
* Migrate inactive tickets into a source code repository,
  so that each one acts as trigger at one fitting position.
  In other words, those inactive tickets get relevant, when the corresponding source code is being worked on.
  Alternatively, put such issues in the JavaDoc of this repo,
  as this Java project can link to any source code thing in the Splitcells projects.
  This way the source code repos are not bloated with comments and tasks.
* Use only project construct on hosters like Codeberg or GitHub,
  if there is a current need for that
  (i.e. issues on those hosts support image attachments or it is useful for other users.).