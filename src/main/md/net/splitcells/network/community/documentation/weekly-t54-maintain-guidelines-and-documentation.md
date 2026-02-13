# Maintain guidelines and documentation

* Issue number: [\#54](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/54)

# Task Description
# Service Tasks
* Check documentation and their links.
    * The starting point of the guidelines is:
    * https://splitcells.net/net/splitcells/network/guidelines/index.html
    * http://localhost:8443/net/splitcells/network/guidelines/index.html
    * Update the project's [history page](https://splitcells.net/net/splitcells/network/history/index.html).
    * Start of documentation: https://github.com/www-splitcells-net/net.splitcells.network
    * Consider Documentation from point of a user
    * Consider Documentation from point of a developer
    * Consider Documentation from point of a product owner.
    * Consider mobile vs desktop view.
* Give Chat AI a piece of documentation and ask what is described by it. Also, ask what is incorrect. This may help to find errors or problems with text.
# Tasks
* [ ] Make News more practible.
    * [x] Show community blog entries as such and not as project proposals.
    * [ ] Render weekly projects as such and not as project proposals.
    * [ ] Only show explicitly started projects.
    * [ ] Show project completions and cancellations.
* [ ] The level of chapter titles in documents should be easier to recognize.
* [ ] Link to https://passo.uno/what-is-a-documentation-engineer/ in documentation guidelines as inspiration.
* [ ] Check validity of all XML files.
* [ ] Import theoretic formulas regarding assignment problem definition from personal master thesis.
* [ ] Make code viewer nice.
* [ ] Reduce background shadows for images, in order to reduce noise. 
* [ ] Create/improve styling guidelines.
* [ ] Consider a paper shadow effect for chapter titles.
* [ ] Make hyperlinks in flowing text sans serif, in order to mark their limited interactivity.
* [ ] Create more whitespace in README in main list between the emojis and their respective text.
* [ ] On mobile view every content column should be separated more distinctly.
* [ ] On mobile view every content column, should have a complete menu bar.
  See meta column for a negative example.
* [ ] Remove graphical noise from flowing text, like too strong, big or many shadows.
    * [ ] Consider making a styling guideline, where this is noted.
* [ ] Consider creating a book out of the project's documentation.
* [ ] Create a short developer manifesto.
* [ ] Create a short documentation and writing manifesto.
* [ ] Every document in the Network Community should be linked by another document in Network project.
  In other words, the Community documents should be considered to be part of the documentation.
* [ ] Consider creating a newsletter that bundles blog, social media posts and interesting info like releases of other optimization software, that contain something interesting regarding optimization.
    * [ ] Add newsletter to global changelog.
* [ ] Note in programming guidelines, that implicit error handling is preferred to explicit one.
* [ ] Every project should also have a joke title.
    * [ ] Jokes are useful as they provide a way to look at something, from a different perspective.
      The more the emotional reaction, the more interesting/useful the perspective is.
      This is also a motivation and advertisement tactic.
    * [ ] Maybe jokes should be injected, instead of added directly to the content?
    * [ ] `It works on my Kubernetes.`
* [ ] Consider creating a joke page about this project.
    * [ ] The first implementations are so inefficient, that you don't see anything happening, when anything is executed! xD See Gel v2 & v3, the first lookup implementation and Cin
    * [ ] Create jokes via a chatbot, where the prompt asks to write a joke regarding a random piece of text in this project like a project's description.
* [ ] Consider checking commits according to the guidlines via AI.
* [ ] Place link for running the software in Hub Readme. The doc for running the software and not just building has to be created as well.
# Done Tasks
* [o] Do not show project proposals in news, as this just clutters things too much for none technical users.
  * [o] Project proposal parsing was removed completely, because it was horribly wrong.
    Even blog articles have a project proposal entry.
    Readd project proposal parsing.
  * [x] Make nicer project proposal prefix.
  * [x] Make nicer project start prefix.
  * [x] Make nicer project end prefix.
* [x] Correct the copyright text in `REUSE.toml` of the `net.splitcells.website.content.binaries` repo.
* [x] Check the copyright text in `REUSE.toml` of all repos. -> I just checked the `net.spitcells.network` repo.
* [x] Consolidate https://splitcells.net/net/splitcells/gel/history/index.html into https://splitcells.net/net/splitcells/network/history/index.html.
* [x] Project news are missing in the global changelog.
* [x] Add padding to the left of lists, in order to avoid clipping.