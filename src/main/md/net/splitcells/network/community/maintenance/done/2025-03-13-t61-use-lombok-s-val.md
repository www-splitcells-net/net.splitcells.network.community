# Use Lombok's new val implementation.
* Issue number: [\#61](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/61)
* Start Date: 2025-03-24
* End Date: 2025-04-06
# Task Description
Lombok's new val implementation might now be performant,
as it translates val to `final var` since version 1.18.22.
Before that, the bad performance of val prohibited its usage.
# Tasks
* [x] Use Lombok's new val implementation.
* [x] Note, that the reason for allowing Lombok's val again is `NEW in Lombok 1.18.22: val gets replaced with final var.` on its website.
  -> This is noted in the Base Bom instead.
* [x] Consider additional usage of Lombok.
    * [x] Use any Lombok annotation via intermedia annotations just like for JUnit and co.
      -> This is not useful, because such can be easily replaced via search and replace.
    * [x] Consider using `@Getter` and `@Setter`.
    * [x] Consider using `@EqualsAndHashCode` and `@Data`.
    * [x] Note that `@ExtensionMethod` could have been used as an alternative to custom wrapper interfaces.
    * [x] Consider using `@Delegate`.
      -> According to `@Delegate` this implementation has major limitations and may even be removed in the future.
      Therefore, this feature is not used.
* [ ] Create Java code guidelines.
    * [ ] Note that using Java like the majority is preferred by default.
    * [ ] Note getter and setter definition in this project in contrast to majorities public consent.
* [ ] Add Lombok guidelines to Java guidelines.
