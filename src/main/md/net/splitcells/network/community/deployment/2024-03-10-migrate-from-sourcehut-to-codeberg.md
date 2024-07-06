# Migrate from SourceHut to Codeberg.
* [Codeberg issue](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/1)
# Actual Tasks
* [x] Move the issue description to community repo.
* [x] Upload repos.
* [x] Add Codemirror to server inventory for automatic uploads.
* [x] Enable CI for Forgejo.
    * [x] https://forgejo.org/docs/next/admin/actions/#forgejo-runner
    * [x] Ensure, that runner services still run after logoff.
    * [x] Ensure, that runner services automatically starts after server reboot.
    * [x] Create minimal CI example.
* [x] Setup profile image.
* [x] Setup organization image.
* [x] Migrate from GitHub as default remote to Codeberg.
    * [x] Use Codeberg for live server deployment.
* [x] Move tickets from SourceHut to Codeberg.
    * [x] Consider moving tickets into community repo in order to archive these.
* [x] Move issues from GitHub to Codeberg.
* [x] Move GitHub projects to Codeberg.
* [x] Move all CI actions from GitHub to Codeberg.
* [ ] Delete projects on Codeberg as they have no actual use.
  Use just one project for tasks managed exclusively on Codeberg,
  because their things like images can be attached easily to the issues.
# Documentation
* [x] Move infrastructure doc to network hub repo, as this repo holds the project's inventory of public things like git repos.
    * [x] Adjust code.
    * [x] Deploy change and check deployment results.
        * [x] Static website
        * [x] Live server
* [x] Note, that Codeberg is used for developers that are part of the project or honorable users. -> Codeberg is the main repo and issue host.
* [x] Note that persistent issues are not normally done via Codeberg and co. Instead, the community repo is used instead. Codeberg and co is only used for discussions and attachments in this context.
* [ ] Coordinate all issue numbering in community repo. -> Document alls issue number prefixes and their meaning.
* [ ] Create guidelines for community project and ensure, that community project is main entry point for the project's developers.
* [x] Create documentation on why multiple git hosters are used. -> GitHub is the backup system.
* [ ] Blog the migration was done and why paid GitLab hosting was not done instead.
* [ ] Deprecate GitLab by disabling pushes to it.