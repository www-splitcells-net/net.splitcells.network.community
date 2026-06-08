# Ensure unambiguous rendering.
* Issue number: [\#69](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/69)
* Start Date: 2026-02-16
# Task Description
The website server allows some ambiguous rendering.
For instance, it accepts, that multiple renderers may want to render a given page and picks just one.
All these errors should cause a program exit in the future, when the static site is deployed.
First these have to be fixed via log reports, in order to not initially break the deployment.
# Tasks
* [ ] Create report with errors regarding this problem.
    * [x] Extend LogMessage with tags.
    * [x] Adjust LoggerRouter for the tags.
    * [x] Use default Logger in LoggerRouter.
    * [ ] Use generic logger factor in LoggerRouter.
    * [ ] Detect errors via RenderingValidatorForHtmlLinks.
    * [ ] Write errors regarding this into the network log repo.
    * [ ] Remove Discoverable from LogMessage, as the message itself is not discoverable by this path as multiple messages has this path.
* [ ] Log relevant errors to network log via daily CI.
* [ ] Weekly fix errors.
* [ ] If all errors are fixed, require the absence of the errors in the daily CI.
* [ ] Fail deployment of static website, if such error occur.
* [ ] Fail distro build, if such error occur.
# Done Tasks
* [x] Remove status page regarding the links: http://localhost:8443/net/splitcells/network/status.html
  * [x] Remove link from status page.
  * [x] Do not store count during static website rendering.
  * [x] Remove RenderingValidatorForHtmlLinks chart.
