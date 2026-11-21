# Maintain Code via AI
* Issue number: \#73
* Start Date: 2026-09-08
# Task Description
Ensure that the Claude code setup works and maintain the code with it.
Data between tools, workflows an AI is shared via `net.splitcells.network.log` and `net.splitcells.network.community`.
# Service Tasks
* Ensure that `Help improve Claude` is disabled.
* `bin/maintain.via.claude.code.sh`
* Check subscription usage: https://claude.ai/new#settings/usage
# Tasks
* [ ] Find good tasks for first test.
    * [ ] Creating unit tests, in order to improve code coverage.
        * [ ] Use JaCoCo reports to guide AI.
            * [x] Create unique names for all jacoco.exec files.
            * [ ] During CI copy these exec file into one folder and upload this to network.log
            * [ ] Download these files and use it via the AI.
    * [x] Generalize command naming of `ai.maintain.project.sh` and `ai.prompt.sh`, as its arguments are not agent specific.
    * [x] Ask AI how it likes the design/architecture of the software.
    * [x] Search for security vulnerabilities in source code.
    * [x] Check if changelogs are complete according to git commits.
    * [x] Improve texts like the ones in the Symbiosis Project. -> Use this only for the `net.splitcells.network` repo for now.
    * [o] Log real live server error logs in private network log repo and let it analyze by Claude Code. -> There are not enough use cases for that, right now.
    * [ ] Check a random source code file for inconsistency and other problems.
    * [x] Create a single command for all tasks. -> maintain.via.claude.code.sh
    * [ ] Ask if source code corresponds to the projects guidelines or public guidelines.
    * [ ] Ask if code has bugs.
    * [ ] Ask if code inspire new ideas.
    * [ ] Check if code is intuitive.
    * [x] Wait between tasks, until there are no uncommited changes. 
    * [ ] Consider creating weekly CI workflows for that. Let these create pull requests.
        * [x] Set this up as a manual workflow, that is executed via a bash script on the local machine.
        * [o] Create PR requests in Codeberg for each task, if anything was done. -> Pull request management would not save time for now.
        * [o] Use one persistent session, in order to save on token usage. In order to do that, the sessions files of `~/.claude/sessions` have to be stored.
          -> This does not save tokens really. Prompt caching also does not work, as this relates to a weekly workflow.
        * [o] Do this in a new weekly CI workflow. -> Pull request management would not save time for now.
        * [o] Consider logging token usage per run and creating a graph for that, in order to control cost. -> There is not enough usage for now.
        * [ ] Execute tasks in weekly workflows, so you do not have to wait on them locally, which also blocks local development.
        * [ ] How to ensure, that Claude Code does not copy secrets?
        * [ ] How to best trigger/organize work? That's what agents are probably for. Are there any programs for this, that can be used for workflows?
          Consider integrating this into `ai.prompt.sh`.
* [ ] Use net.splitcells.network.community repo.
* [ ] Execute workflow in container, in order to manage permissions for local executions?
* [ ] Execute AI workflows on local computer in parallel in a separate copy of the repos, if needed.
* [ ] Consider searching performance problems with Claude Code.
* [ ] Consider using local hardware.
    * [ ] Maybe wait for https://chatjimmy.ai/ hardware for consumers.
    * [ ] Check if local AMD card could be used.
# Done Tasks
* [x] Create an AI community where `net.splitcells.network.log` and `net.splitcells.network.community` is the main exchange between these. -> This is done for now, by requiring the AI to create issues for each task in that repo.
* [x] Learn via complete material how to use Claude Code.
    * [x] https://claude.com/resources/articles/skills-explained
    * [x] https://resources.anthropic.com/hubfs/The-Complete-Guide-to-Building-Skill-for-Claude.pdf
* [x] Setup Claude account and app. -> In order to use Claude Code a subscription is needed.
* [x] Try out free version first. -> Coding is not possible with the free version.