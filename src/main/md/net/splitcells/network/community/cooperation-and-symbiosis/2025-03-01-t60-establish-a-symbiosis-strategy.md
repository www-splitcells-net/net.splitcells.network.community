# Establish a symbiosis strategy.
* Issue number: [\#60](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/60)
# Task Description
* [x] Let the front menu lead the user to interesting things more clearly. 
    * [x] Make the global changelog more generally usable. -> This new system is called notification queue.
        * [x] Make notifications page available in the website's layout. This seems to be a bug.
        * [x] Add tags to notifications. This way a single notification queue definition can be used,
          while allow different queues in the UI for different users.
        * [x] Render date of notification.
        * [x] Avoid duplicate date rendering for change log items.
        * [o] Integrate Codeberg issues into the changelog. -> This is costly and should only be done, when it gets relevant.
        * [x] Integrate the blog into the changelog.
            * [x] Parse date of blog article. 
        * [x] The notification class itself should do the top level list item parsing in the notification list,
          instead of the CommonMark parser.
          Thereby, the base list formatting has not to be implemented for each notification source.
        * [x] Add projects and tasks of community repo to the notifications queue.
        * [x] Use new notification system for global changelog as well.
        * [x] Use new notification system for a dedicated user oriented news page. -> See `http://localhost:8443/net/splitcells/website/news.html`.
        * [x] Improve notification queue runtime performance. A profiling needs to be done, in order to find out the cause.
        * [x] Link to source for each notification.
        * [x] Render correct changelog for a given changelog URL. This is not related to the new notification system.
        * [x] For each project create potentially multiple notifications.
            * [x] Proposal of Project -> This is the date at the start of the file name.
            * [x] Start of Project
            * [x] End of Project
    * [x] Add news link to front menu.
    * [x] `https://splitcells.net/net/splitcells/website/notifications.html` is not statically deployed.
    * [o] Improve notifications styling. -> It is good enough for now.
    * [o] Use animation in order to advertise important things. -> Do not use animations for advertisement, but it could be used for interactive elements in general.
        * [o] Create a border outline animation, that flashes the orange color.
          The orange color is already used, in order to mark activity. See `--background-color-activity: #ff9900;`.
        * [o] Note, that in the future, maybe a glass reflection like animation could be used.
        * [o] Consider using a typewriter effect for advertisement. -> This was added as a todo to the `basic.css`, in order to use the typewriter for interactive elements in the future.
    * [x] Outline interactive or most important things via round corners.
      Do this to the main cards of the front menu.
    * [x] In Desktop view replace menu header link with front menu link, as multiple but different menu links are irritating otherwise.
* [x] Document stable API plan via `net.splitcells.network.system.stable`.
* [o] Make community blog easier to find via front menu.
  -> The blog is visible via the meta column of the front menu.
  Furthermore, the notifications and news also contain the blog articles.
* [x] Clean up community blog. -> I only looked and correct only some of them, but I think these are good enough.
* [x] Update licensing etc. strategy: https://www.cs.auckland.ac.nz/~pgut001/pubs/oss_development.pdf
    * [x] Sleepycat for dual licensing ->
      This is rejected, as a weak copy-left license is required for the open source version, because of the dependencies.
      Also, strictly speaking, the core code could support dependency free code.
      Extension do not have to be under strong copy-left licenses, when there is a permissively licensed API,
      where the implementation is strongly copyrighted, but this defeats the purpose of a strong copy-left license.
      Furthermore, such dual licensing does not work, if there is no overarching organization,
      when there is more than one contributor.
      Contributor also become harder this way, as a contributor agreement between the organization and the contributor would be needed as well.
    * [x] Open core concept is preferred for commercial licensing.
    * [x] Add objective to guidelines, that the software is usable and reliable.
    * [x] Present oneself as a reliable person.
        * [o] Create general social media strategy -> The current strategy is good enough and will be adapted, when needed, instead.
        * [x] Refocus in school problem. -> This is only a decision.
    * [x] Consider linking to this in guidelines as inspiration: https://www.cs.auckland.ac.nz/~pgut001/pubs/oss_development.pdf
    * [o] Define support strategy. -> For now an explicit strategy is not required, as there are no support requests. This will be created, when a real need arises for this.
        * [x] Add support page to website and app. -> This is done via the Hub's README.
        * [x] Provide way for users to request support. -> The link for support in the README is enough.
        * [o] No support guarantee etc. 
    * [x] Signed Windows executables becomes more relevant that way.
      -> Consider this only, when such relevant user are present.
      Note this and add this info to the download link for the GUI.
    * [x] Distribute Linux executables as well. -> This is already provided at the download page.
    * [x] Make versioning more relevant for advertisement and signalling to users of software changes.
      Consider semantic versioning and year versioning. -> This is not useful for now, as there are no users. Add a task to do this, at the download page, so it is considered, when there are actual users.
        * [x] Create project timeline/releases, but without release artifacts.
    * [x] Advertise the free availability of the online service and downloads.
* [x] Delete Mac version of App, as it is not working.
* [ ] Update `BUILD.md`.
    * [x] Make it easy to set up development via 1 clone and 1 command in an IDE.
    * [x] Consolidate bin and binr folder.
      -> Do not do this as the advantage of a dedicated folder for such, is the fact, that IDE usable commands are not hidden along not IDE usable commands in the bin folder.
      -> Commands should check, if they are executed in the bin folder or in the project folder and act accordingly.
    * [x] Build software on Steam Deck, in order to check this. -> Building the software on a unprepared computer, is good enough for testing purposes.
    * [ ] Fix README links and their respective docs to build instructions.
* [x] Link to Codeberg in README.
* [x] Improve Hub Readme.
* [x] Consider creating pseudo none developer news. -> Social media is enough for that, right now.
* [o] Integrate symbiosis project into objectives, even though the status of symbiosis is questionable. -> A TODO was added to the objectives, but this project is not mature enough.
* [x] Deprecate no-code editor and create no-code editor comment document.
    * [x] No-code and code is not so different, when logic is modelled.
    * [x] Refocus of efforts and thereby liquidations of features.
    * [x] In the future start with LSP servers and similar before considering no-code.
    * [x] Updating code from the server side is possible on code editors as well.
    * [x] Remove backend code.
    * [x] Add TODO to code editor for LSP support via [Eclipse LSP4J](https://github.com/eclipse-lsp4j/lsp4j), [LSPs](https://github.com/qualified/lsps) and CodeMirror.
      -> This was added to [2024-11-13-t37-solve-sport-lesson-assignment.md](../features/2024-11-13-t37-solve-sport-lesson-assignment.md).
    * [x] Document focus of network project on providing an IDE for optimizations in the network's objectives.
* [x] Finish guidelines: net/splitcells/network/guidelines/inherently-broken-and-rotten-by-design.xml
* [ ] Publish guidelines on static website and tweet about it.
* [x] Update `About This Site`.
    * [x] Master Thesis
    * [x] After Master Thesis
    * [x] Hetzner Deployment
    * [x] Symbiosis
* [ ] Blog about pause of Cin and new focus.
    * [x] Feature set restriction in the past was not strict enough.
    * [x] Cancel the school project and reason its cancellation. Also, update Network objectives accordingly.
    * [x] Comment on no-code editor deprecation.
    * [ ] Focus on minimal not strictly required features like a code editor AND a no-code editor aka. lean development.
      The aim is to create an optimization IDE.
    * [ ] This is the result about thinking, what I would have done, if I would have less time i.e. RISCV server vs RISCV framework laptop.
      I noticed, that I am kind of wasting time.
    * [ ] The weekly support tasks are ok, even though there are too many active ones.
    * [ ] Clean up history document and link to this blog entry.
    * [ ] Link to about this sie from history document.
* [ ] Add true goal to main objectives: The project's relationship to the public is unclear,
  but stays an unresolved issue.
# Done Tasks
* [x] Add project advertisement text in secondary column of front menu.
    * [x] Put there a shortened version of the README.
    * [x] Improve the project description in the README.
    * [x] Replace meta titles of secondary column with the title of the shortened README.
    * [x] Add note to both README like files, that if one needs to be edited both should be edited.
* [x] Update the [Project Structure Overview](https://splitcells.net/net/splitcells/network/overview.html).