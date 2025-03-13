# Use Lombok's new val implementation.
Lombok's new val implementation might now be performant,
as it val is translated to `final var` since version 1.18.22.
Before that, the bad performance of val prohibited its usage.
# Tasks
* [ ] Use Lombok's new val implementation.
* [ ] Update Lombok guidelines.
    * [ ] Note, that the reason for allowing Lombok's val again is `NEW in Lombok 1.18.22: val gets replaced with final var.` on its website.
* [ ] Use any Lombok annotation via intermedia annotations just like for JUnit and co.
* [ ] Consider using `@Getter` and `@Setter`.
* [ ] Consider using `@EqualsAndHashCode`.
* [ ] Consider using `@ToString`.
* [ ] Note that `@ExtensionMethod` could have been used as an alternative to custom wrapper interfaces.