# Splitcells Network Community
## Goals
This project stores, organizes and develops tasks and ideas for the Splitcells Network.
## Details
This is done via JavaDoc (in order to easily support automatic refactoring) or CommonMark.
The project [Identity Generator on Codeberg](https://codeberg.org/splitcells-net/net.splitcells.network.community/projects/10112)
is used in order to generate unique issue ids. 
## Overview And Status
* [splitcells.net Status](https://splitcells.net/net/splitcells/network/status.html)
## Standard Projects
Projects that are being worked cyclically, and probably will never be finished:
* Accessibility and Design: Improve accessibility:
  * Description: We want to use the software, guys. RIGHT?! Right? right? ... ehh
  * Review advertisement, introductions and info linked by README,
    because that is the primary material for newcomers.
  * [Link](src/main/md/net/splitcells/network/community/accessibility-and-design/index.md)
* Blog
  * Description: Speaking to the void about the development process.
  * [Link](./src/main/md/net/splitcells/network/community/blog/index.md)
* Community Guidelines
  * Description: We comment on guidelines and things happening.
  * [Link](./src/main/md/net/splitcells/network/community/guidelines/index.md)
* Compatibility, portability and adaptability:
    * Description: Make code easy portable, translatable and adaptable to other languages and environments.
    * [Link](./src/main/md/net/splitcells/network/community/compatibility-portability-and-adaptability/index.md)
* Cooperation and symbiosis:
    * Description: Tit for tat
    * [Link](./src/main/md/net/splitcells/network/community/cooperation-and-symbiosis/index.md)
* Deployment project
  * Description: Administer deployments
  * [Link](./src/main/md/net/splitcells/network/community/deployment/index.md)
* Developer Support
  * Description: Your issues need images? Here is the place for that, but only for developers of this project and not users.
  * [Host Link](https://codeberg.org/splitcells-net/net.splitcells.network.community/projects/8592)
* Documentation project:
    * Description: Nobody reads this xD
    * [Link](./src/main/md/net/splitcells/network/community/documentation/index.md)
* Features:
    * Description: To the moon!
    * [Link](./src/main/md/net/splitcells/network/community/features/index.md)
* Maintenance project:
    * Description: Improve quality and fix bugs.
    * [Link](./src/main/md/net/splitcells/network/community/maintenance/index.md)
* Major Projects
  * Description: This is an archive of readable descriptions of some major projects,
    that can be used as advertisement for specific groups.
  * [Link](./src/main/md/net/splitcells/network/community/projects/index.md)
* Performance Engineering
  * Description: We have a need for speed.
  * [Link](./src/main/md/net/splitcells/network/community/performance-engineering/index.md)
* Security
  * Description: What could go possibly wrong?
  * [Link](./src/main/md/net/splitcells/network/community/security/index.md)
* The Symbiosis Project
## Notes
* In order to mark tasks in `task-archives` with a high priority,
  add `9999-` as the file name prefix.
  Do this with at most 1 task, as otherwise there will be a creep towards many such tasks.
  Change the documents date in its file name back to its original,
  when the task is started.
* `very low priority` means, that the related thing is currently not being worked on, on a regular basis.
  So, it is also highly likely, that the related project is not up to date.
  In other words, there is no person regularly working on the related thing.
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
  (i.e. issues on those hosts support image attachments, or it is useful for other users.).
# Format for Tasks
* The file name format is `[YYYY-MM-DD|daily|weekly|...]-t[ticket number]-[ticket name].md`.
  The ticket number is placed in the file name, because it is faster to look up the ticket number that way,
  than to look into the file.
  Often, the file is already opened as it is being worked on, but viewed in a way, that the ticket number is not visible.
  This causes a significant amount of scrolling.
* The `Start Date: YYYY-MM-DD`, `End Date: YYYY-MM-DD` and date in the filename are interpreted in the notification parser of the website server,
  in order show these in the notification queue.
  See https://splitcells.net/net/splitcells/website/notifications.html such a queue.
* File content format:
```
# Weekly deploy static website.

* Issue number: [\#51](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/[Issue Number])
* Start Date: 2025-04-05
* End Date: 2025-04-06

# Task Description
# Service Tasks
[This is a list of tasks, that are executed cyclicly.]
# Acceptance Note
[States how the project ended.]
# Tasks
[Open and Closed Tasks]

* [ ] Task to be done.
* [x] Completed task. -> Conclusion
* [o] Task not to be done, as it was rejected. Such a task may not be deleted for documentation purposes.
  Things like `* [o]` can create some rendering issues, where renderers do not support different item types in a list,
  but this will be always a problem.
  Furtheremore, the not supported rendering of check boxes still looks mostly ok.
  Using `[o]` has the benefit, that one does not need to note on all such tasks explicitly, that they were not done.
  -> Optional Reason for rejection.

# Done Tasks
[Tasks that are done and stored for documentation purposes.
This is optional, so that one can easily see only the open tasks.]
# Future Ideas
[List followup tasks to this ticket here.
 Mark these tasks as done, when tasks are made based on these ideas.
 Mark such tasks as rejected, when tasks are not made based on these ideas.]
```
# Considerations
Rename `net.splitcells.network.community` to `net.splitcells.community` as this is a community project for the Splitcells project and
not just the Splitcells Network project.