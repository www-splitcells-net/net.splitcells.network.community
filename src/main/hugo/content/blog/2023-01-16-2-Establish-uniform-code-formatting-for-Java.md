---
title: Establish uniform code formatting for Java.
date: 2023-01-16
author: Mārtiņš Avots
tags: [maintenance]
---

* [ ] Consider [Google's style guide](https://google.github.io/styleguide/javaguide.html)
* [ ] Document Google's style guide [source code](https://github.com/google/styleguide).
  * [ ] Consider [fmt-maven-plugin](https://github.com/spotify/fmt-maven-plugin) for auto formatter via build.
    * [ ] Is it possible to only format
* [ ] Special symbols should be on the left side in general,
  instead of the right side, if one side has to be chosen,
  which means that the special symbol in such a case is not in the middle of the text.
  Thereby, the overhaul structure and the structure's meaning is readable
  by just looking at the left side of the code.
  The only exception to this rule are curly brackets and semicolons.
  One of the main reasons for the curly brackets exception is the fact,
  that curly brackets are often specially auto formatted in IDEs,
  which creates alignment issues.
* [ ] Use spaces instead of tabs.
  Tabs are better for semantics, as in this case one character has one meaning.
  On the other hand, spaces are more portable,
  as tabs have often a special meaning on keyboards (i.e. changing currently selected input field)
  and are easier to transport across input fields.
  Furthermore, spaces allow aligning code vertically.