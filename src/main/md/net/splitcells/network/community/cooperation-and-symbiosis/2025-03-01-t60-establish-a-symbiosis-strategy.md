# Establish a symbiosis strategy.
* Issue number: [\#60](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/60)
# Task Description
* [ ] Make the global changelog more generally usable. -> This new system is called notification queue.
    * [ ] Create a global changelog with tags for each message.
    * [x] Render date of notification.
    * [x] Avoid duplicate date rendering for change log items.
    * [o] Integrate Codeberg issues into the changelog. -> This is costly and should only be done, when it gets relevant.
    * [x] Integrate the blog into the changelog.
        * [x] Parse date of blog article. 
    * [x] The notification class itself should do the top level list item parsing in the notification list,
      instead of the CommonMark parser.
      Thereby, the base list formatting has not to be implemented for each notification source.
    * [ ] Add notifications link to the menu.
    * [ ] Add tags to notifications. This way a single notification queue definition can be used,
      while allow different queues in the UI for different users.
    * [ ] Use new notification system for global changelog as well.
    * [ ] Improve notification queue runtime performance.
    * [ ] Link to source for each notification.
    * [ ] Add projects and task of community repo to the notifications queue.
* [ ] Document stable API plan via `net.splitcells.network.system.stable`.
* [ ] Make community blog easier to find via front menu.
* [ ] Clean up community blog.
* [ ] Blog about pause of Cin and new focus.
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
* [ ] Force CSS reload, as users otherwise get old styling from the browser. 
# Done Tasks
* [x] Add project advertisement text in secondary column of front menu.
    * [x] Put there a shortened version of the README.
    * [x] Improve the project description in the README.
    * [x] Replace meta titles of secondary column with the title of the shortened README.
    * [x] Add note to both README like files, that if one needs to be edited both should be edited.
* [x] Update the [Project Structure Overview](https://splitcells.net/net/splitcells/network/overview.html).