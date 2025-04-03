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
* [ ] Document stable API plan via `net.splitcells.network.system.stable`.
* [ ] Make community blog easier to find via front menu.
* [ ] Clean up community blog.
* [ ] Update licensing etc. strategy: https://www.cs.auckland.ac.nz/~pgut001/pubs/oss_development.pdf
    * [ ] Sleepycat for dual licensing -> This is kind of already the case in a weaker form, but just not with strong copyleft license and problematic if other developers join.
      This can also be supported later with injected modules, that are strong copyleft or commercially available.
    * [ ] Open Core
    * [ ] Promise and advertise the project's reliability to its users.
    * [ ] Add objective to guidelines, that the software is usable.
    * [ ] Present oneself as a person reliable.
        * [ ] Update social media profile image.
        * [ ] Create genera social media strategy
        * [ ] “Software Craftsmanship: The New Imperative” by Pete McBreen
        * [ ] Refocus in school problem?
    * [ ] Consider linking to in guidelines: https://www.cs.auckland.ac.nz/~pgut001/pubs/oss_development.pdf
    * [ ] Add advertisement and documentation to real users on website.
    * [ ] Define support strategy.
        * [ ] Add support page to website and app.
    * [ ] Provide way for users to request support.
    * [ ] Signed Windows executables becomes more relevant that way.
    * [ ] Distribute Linux executables as well.
    * [ ] Make versioning more relevant for advertisement and signalling to users of software changes.
      Consider semantic versioning and year versioning.
    * [ ] Advertise the free availability of the online service and downloads.
    * [ ] Focus more on overhaul development roadmap and goals.
        * [ ] Cin: simulate all aspects of schools
* [ ] Delete Mac version of App, as it is not working.
* [x] Improve Hub Readme.
* [ ] Consider creating pseudo none developer news.
* [ ] Integrate symbiosis project into objectives, even though the status of symbiosis is questionable.
* [ ] Finish guidelines: net/splitcells/network/guidelines/inherently-broken-and-rotten-by-design.xml
* [ ] Update `About This Site`.
* [ ] Blog about pause of Cin and new focus.
    * [ ] Cancel the school project and reason its cancellation. Also, update Network objectives accordingly.
* [ ] Use drawn faces, as art on website more. Document in guidelines why and how.
* [ ] Add true goal to main objectives: many people can work together.
* [ ] Start the public version of the support system idea.
# Done Tasks
* [x] Add project advertisement text in secondary column of front menu.
    * [x] Put there a shortened version of the README.
    * [x] Improve the project description in the README.
    * [x] Replace meta titles of secondary column with the title of the shortened README.
    * [x] Add note to both README like files, that if one needs to be edited both should be edited.
* [x] Update the [Project Structure Overview](https://splitcells.net/net/splitcells/network/overview.html).