# Ensure that the website design is accessible and good
* Issue number: [\#43](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/43)
# Task Description
Improve the design, accessibility and usability of the software.

Starting with [2025](https://www.golem.de/news/barrierefreiheit-deutsche-webseiten-sind-versetzungsgefaehrdet-2409-188655.html)
public website should be barrierefrei.
Although, this law does not seem to apply to `splitcells.net`,
this is an opportunity to consider this aspect.
# Service Tasks
* Check warnings and errors in the browser.
# Tasks
* [ ] The meta menu bar does not feel like the start of a new distinct part of the website in mobile view. -> A bigger white structural bar is used, in order to separate parts more distinctly. Check if this looks good on phone.
* [ ] Buttons should be less bold than titles.
* [ ] The parent pages are not correct. See http://localhost:8443/net/splitcells/network/guidelines/inherently-broken-and-rotten-by-design.html .
* [ ] All rendered READMEs have the same content on the website.
* [ ] Not all READMEs are visible in the parent pages. See http://localhost:8443/net/splitcells/network/hub/README.html .
* [ ] In web layout add link from primary column to secondary column.
* [ ] Improve styling of low priority buttons of chapters. 
* [ ] Consider using pastel color palette for none black and white colors.
* [ ] Consider add paper folding or origami as CSS style for background, as decoration.
* [ ] Consider using pure e4 without RCP as GUI instead of JavaFX,
  as this uses the operating system's browser,
  which is better than JavaFX's embedded Chromium.
  The Chromium has some strange icons and other differences.
  These are not game breakers, but make things more ugly.
* [ ] Force CSS reload, as users otherwise get old styling from the browser.
* [ ] Consider a more distinct look of link buttons and action buttons:
  The first one get additional drawn edges at the bottom left and top right.
  The second one get additional drawn edges at the top left and bottom right.
# Completed Tasks
* [x] Errors are present at the client side Javascript code. See http://localhost:8443/net/splitcells/network/guidelines/inherently-broken-and-rotten-by-design.html .
  -> The client side errors could not be found anymore.
* [x] Make rendering of TODOs prettier. -> The TODOs are now rendered more compactly, which make them look prettier.
  Thereby, it was noticed, that lists are incorrectly nested.
  This problem was not fixed.
* [x] Make white bold structural guidelines less thick, as these distract a bit too much.
* [x] Prefer using always darkest black color as text color,
  in order to improve contrast.
  -> The lower priority font colors where made more black and therefore readable.
