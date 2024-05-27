# Migrate from SourceHut to Codeberg.

# Actual Tasks
* [ ] Move the issue description to community repo.
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
* [ ] Move infrastructure doc to network hub repo, as this repo holds the project's inventory of public things like git repos.
    * [x] Adjust code.
    * [ ] Deploy change and check deployment results.
        * [ ] Static website
        * [ ] Live server
* [ ] Note, that Codeberg is used for developers that are part of the project or honorable users.
* [ ] Note that persistent issues are not normally done via Codeberg and co. Instead, the community repo is used instead. Codeberg and co is only used for discussions and attachments in this context.
* [ ] Coordinate all issue numbering in community repo. -> Document alls issue number prefixes and their meaning.
* [ ] Create guidelines for community project and ensure, that community project is main entry point for the project's developers.
* [ ] Note, that GitHub is used for external users.
* [ ] Create documentation on why multiple git hosters are used.
* [ ] Blog the migration was done and why paid GitLab hosting was not done instead.
* [ ] Deprecate GitLab by disabling pushes to it.