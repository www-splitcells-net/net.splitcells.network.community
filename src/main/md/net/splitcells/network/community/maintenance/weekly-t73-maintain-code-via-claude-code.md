# Maintain Code via Claude Code
* Issue number: \#73
* Start Date: 2026-09-08
# Task Description
Ensure that the Claude code setup works and maintain the code with it. 
# Service Tasks
* Ensure that `Help improve Claude` is disabled.
* `bin/maintain.via.claude.code.sh`
* Check subscription usage: https://claude.ai/new#settings/usage
# Tasks
* [ ] Learn via complete material how to use Claude Code.
    * [x] https://claude.com/resources/articles/skills-explained
    * [x] https://resources.anthropic.com/hubfs/The-Complete-Guide-to-Building-Skill-for-Claude.pdf
* [ ] Find good tasks for first test.
    * [ ] Creating unit tests, in order to improve code coverage.
        * [ ] Use JaCoCo reports to guide AI.
            * [ ] Create unique names for all jacoco.exec files.
            * [ ] During CI copy these exec file into one folder and upload this to the static website
            * [ ] Download these files and use it via the AI.
    * [x] Check if changelogs are complete according to git commits.
    * [x] Improve texts like the ones in the Symbiosis Project. -> Use this only for the `net.splitcells.network` repo for now.
    * [o] Log real live server error logs in private network log repo and let it analyze by Claude Code. -> There are not enough use cases for that, right now.
    * [ ] Check a random source code file for inconsistency and other problems.
    * [x] Create a single command for all tasks. -> maintain.via.claude.code.sh
    * [ ] Wait between tasks, until there are no uncommited changes. 
    * [] Consider creating weekly CI workflows for that. Let these create pull requests.
        * [x] Set this up as a manual workflow, that is executed via a bash script on the local machine.
        * [o] Create PR requests in Codeberg for each task, if anything was done. -> Pull request management would not save time for now.
        * [o] Use one persistent session, in order to save on token usage. In order to do that, the sessions files of `~/.claude/sessions` have to be stored.
          -> This does not save tokens really. Prompt caching also does not work, as this relates to a weekly workflow.
        * [o] Do this in a new weekly CI workflow. -> Pull request management would not save time for now.
        * [o] Consider logging token usage per run and creating a graph for that, in order to control cost. -> There is not enough usage for now.
        * [ ] Execute tasks in weekly workflows, so you do not have to wait on them locally, which also blocks local development.
* [ ] Execute workflow in container, in order to manage permissions.
* [ ] Document Claude Code setup.
    * [ ] Always use Community Project as context.
    * [ ] Create prompt templates -> Use skills instead. Maybe no skills are needed for now. I create a default one and will add things to it, that the AI had problems with.
        * [ ] Make a skill for cleaning up the code.
        * [ ] Has the given class multiple methods, that basically do the same?
        * [ ] Ask if source code corresponds to the projects guidelines or public guidelines.
        * [ ] Ask if code has bugs.
        * [ ] Ask if code inspire new ideas.
        * [ ] Add this project's code guidelines as a context.
        * [ ] Add this project's top root convention documents like `BUILD.md`.
        * [ ] Make skill usable by human as well.
        * [ ] How to ensure, that skills are used during a Claude session?
        * [ ] Check if code is intuitive.
        * [ ] Check for a source code file, if anything is wrong with it.
        * [ ] Create a skill for each service task.
    * [ ] Create code guidelines and let AI check these against code.
* [ ] Consider searching performance problems with Claude Code.
* [ ] Consider using local hardware.
    * [ ] Maybe wait for https://chatjimmy.ai/ hardware for consumers.
    * [ ] Check if local AMD card could be used.
# Done Tasks
* [x] Setup Claude account and app. -> In order to use Claude Code a subscription is needed.
* [x] Try out free version first. -> Coding is not possible with the free version.