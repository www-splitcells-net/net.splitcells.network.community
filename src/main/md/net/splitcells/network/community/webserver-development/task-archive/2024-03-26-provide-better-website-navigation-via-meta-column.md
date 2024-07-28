# Provide better website navigation via meta column
Currently, the website badly conveys to the user,
that a page is related to other pages.
The user should feel, at any point, that there is more content regarding the current thing,
that the user is looking at.

* [Codeberg issue](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/12)
* [ ] Move the content's of this issue to the community repo.
* [ ] Document this goal inside the default website layout.
* [ ] Better visually hint at possibility of page navigation via meta column through design.
    * [ ] Provide tree, that is a merge of `Parent Pages` and `Relevant Context Path`. It's important, that for each element in the tree, the item start with the file/folder name without its file suffix. Name this new chapter `Relevate pages to the current page` (RPCP).
        * [ ] Add item in tree for current page. Use a name prefix for the item that hints at this meaning.
        * [ ] Highlight current page item with higher priority colors.
        * [ ] Highlight the current page item with a UTF-8 arrow prefix pointing to the item's text.
        * [ ] Parent pages elements should be parents of the highlighted current page item. The structure is therefore equal to common file managers, that have a tree view.
        * [ ] Link to the new tree from the Meta column's header, so that navigation part of the column can be reached via memorable interaction.
        * [ ] Link to the new tree from the main column's header, when the Meta column is below the content column.
          This makes it easier to use this tree in mobile view as well.
* [ ] Top links at the menu column should point to the front menu just like the icon button at main column's header.
* [ ] Provide more compact content in meta column by reducing the paddings and margins of chapters in the meta column.
* [x] Always show a way to navigate to somewhere like the root of the website. The navigation page should never be empty.
* [x] Consider documents with a name of a folder at the same document as parent pages as well.
* [ ] Rename `Local Path Context` to `Relevate resources to the current page`.
* [ ] Make Menu link button in main column an action button, in order to signal, that this button does not lead to a different page.