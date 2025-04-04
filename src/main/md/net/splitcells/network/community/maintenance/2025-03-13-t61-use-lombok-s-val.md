# Use Lombok's new val implementation.
* Issue number: [\#61](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/61)
# Task Description
Lombok's new val implementation might now be performant,
as it val is translated to `final var` since version 1.18.22.
Before that, the bad performance of val prohibited its usage.
# Tasks
* [x] Use Lombok's new val implementation.
* [x] Note, that the reason for allowing Lombok's val again is `NEW in Lombok 1.18.22: val gets replaced with final var.` on its website.
  -> This is noted in the Base Bom instead.
* [ ] Consider additional usage of Lombok.
    * [ ] Use any Lombok annotation via intermedia annotations just like for JUnit and co.
    * [x] Consider using `@Getter` and `@Setter`.
    * [ ] Consider using `@EqualsAndHashCode` and `@Data`.
    * [ ] Note that `@ExtensionMethod` could have been used as an alternative to custom wrapper interfaces.
    * [ ] Consider using `@Delegate`.
* [ ] Create Java code guidelines.
    * [ ] Note that using Java like the majority is preferred by default.
    * [ ] Note getter and setter definition in this project in contrast to majorities public consent.
* [ ] Add Lombok guidelines to Java guidelines.
