# Setup Claude Code
* Issue number: \#73
* Start Date: 2026-09-08
# Task Description
Use Claude Code to write JavaDoc, proofread text and generate tests.
Spend at most 20 Euros per month for this, but try free model first,
in order to evaluate the workflow.
# Service Tasks
* Ensure that `Help improve Claude` is disabled.
# Tasks
* [ ] Learn via complete material how to use Claude Code.
    * [x] https://claude.com/resources/articles/skills-explained
* [ ] Find good tasks for first test.
    * [ ] Creating unit tests.
    * [ ] Improve texts like the ones in the Symbiosis Project.
    * [ ] Log real live server error logs in private network log repo and let it analyze by Claude Code.
    * [ ] Consider searching performance problems with Claude Code.
    * [ ] Check if changelogs are complete according to git commits. 
* [ ] Document setup.
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
    * [ ] Create code guidelines and let AI check these against code.
* [ ] Consider using local hardware.
    * [ ] Maybe wait for https://chatjimmy.ai/ hardware for consumers.
    * [ ] Check if local AMD card could be used.
# Done Tasks
* [x] Setup Claude account and app. -> In order to use Claude Code a subscription is needed.
* [x] Try out free version first. -> Coding is not possible with the free version.