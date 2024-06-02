# Migrate from SourceHut to Codeberg.
* [Codeberg issue](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/1)
# Actual Tasks
* [x] Move the issue description to community repo.
* [x] Upload repos.
* [x] Add Codemirror to server inventory for automatic uploads.
* [ ] Enable Codemirror CI.
* [x] Setup profile image.
* [x] Setup organization image.
* [x] Migrate from GitHub as default remote to Codeberg.
    * [x] Use Codeberg for live server deployment.
* [x] Move tickets from SourceHut to Codeberg.
    * [x] Consider moving tickets into community repo in order to archive these.
* [x] Move GitHub projects to Codeberg.
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