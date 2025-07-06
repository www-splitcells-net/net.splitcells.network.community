# Create file browser for meta column.
* Description: Currently, the website badly conveys to the user,
  that a page is related to other pages.
  The user should feel, at any point, that there is more content regarding the current thing,
  that the user is looking at.
  Create a page representing a file browser,
  that can be embedded into the meta column of a page.
* Issue number [\#33](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/33).
# Tasks
* [x] Logo links at the menu column should point to the front menu just like the icon button at main column's header.
* [ ] Create central file browser page, that shows all files of document.
    * [ ] There is now the base technology for that at `localhost:8443/net/splitcells/website/layout/tree.html`, but it needs improvement.
        * [ ] Styling
        * [ ] Expand certain paths that are important,
          in order to improve the initial overview without the user's interaction.
            * [ ] Dem service paths
            * [ ] Dem program representatives.
    * [ ] Keep in mind, that something like that already exists: https://splitcells.net/net/splitcells/website/layout.html 
    * [ ] Make all items collapsable.
* [ ] Embed file browser into meta column.
    * [ ] Only unfold path to current folder in the file browser. 
* [ ] Document goals of the file browser.
* [ ] Provide more compact content in meta column by reducing the paddings and margins of chapters in the meta column.
* [x] Always show a way to navigate to somewhere like the root of the website. The navigation page should never be empty.
* [x] Consider documents with a name of a folder at the same document as parent pages as well.
* [ ] Make Menu link button in main column an action button, in order to signal, that this button does not lead to a different page.
* [x] Add explore button at window menu, that is only visible in minimal/mobile view.
  This button links to the file browser in the meta column.
  This conveys to the user, that there are more interesting things available.
  -> The element id `net-splitcells-website-file-browser` is used for that.
* [ ] Fix big query of `@media (max-width: 54em) {` in `layout.default.css`.
  The small one works.
* [ ] Sort children of a folder by the fact if it is a file or folder first and than by name,
  in order to easy navigation.
# Old Tasks
* [ ] Better visually hint at possibility of page navigation via meta column through design.
    * [ ] Provide tree, that is a merge of `Parent Pages` and `Relevant Context Path`. It's important, that for each element in the tree, the item start with the file/folder name without its file suffix. Name this new chapter `Relevate pages to the current page` (RPCP).
        * [ ] Add item in tree for current page. Use a name prefix for the item that hints at this meaning.
        * [ ] Highlight current page item with higher priority colors.
        * [ ] Highlight the current page item with a UTF-8 arrow prefix pointing to the item's text.
        * [ ] Parent pages elements should be parents of the highlighted current page item. The structure is therefore equal to common file managers, that have a tree view.
        * [ ] Link to the new tree from the Meta column's header, so that navigation part of the column can be reached via memorable interaction.
        * [ ] Link to the new tree from the main column's header, when the Meta column is below the content column.
          This makes it easier to use this tree in mobile view as well.