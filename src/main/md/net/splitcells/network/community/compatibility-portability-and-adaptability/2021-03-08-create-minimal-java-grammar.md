# Create minimal Java grammar for this project in order to make code less complex
- [x] Create alternative implementations for all `Domable#toDom` instances.
- [x] Fix grammar error, that causes ANTLR4 to not show, what the grammar error. -> Found a workaround: The rule `(.)*? Keysymbol_at Keyword_JavaLegacyArtifact (.)*? EOF` breaks every error message. Disabling this rule for a file in question creates normal error messages.
    - [x] Print out lexer's tokens result on error. Maybe that is enough? https://stackoverflow.com/questions/70701595/is-there-a-way-to-extract-tokens-in-order-with-antlr
    - [x] Maybe try out ANTLR4 UI first.
- [ ] Remove usage of `org.w3c, because of the problems associated with this lib.
    - [ ] Remove usage of `Domable#toDom` except inside `Domable#toDom` implementations.
        - [ ] `toDom` is used in order to implement `toDom` like functions like `Constraint#graph`.
        - [ ] Remove other `toDom` usage.
            - [ ] Update `Rater#argumentation`.
                - [ ] Create test for argumentation.
                - [ ] Create alternative argumentation implementation.
                - [ ] Use alternative implementation.
                - [ ] Remove original implementation.
            - [ ] Update `Solution#createAnalysis`.
            - [ ] Update `SolutionView#createAnalysis`.
            - [ ] Update `SolutionView#toLinesFodsAnalysis`.
            - [ ] Update `History#toAnalysisFods`.
            - [ ] Update `ProjectsRendererI#createLayout`.
    - [ ] Remove `Domable#toDom` instances.
# Sub Tasks
For this to work, the source code also have to comply with the grammar, when this issue is done.
- [x] Ensure that Dem complies with new custom Java grammar.
- [ ] Make grammar clean, so it's straight forward to process for translations and to understand.
- [x] Detailed Javadoc grammar. -> task is migrated into repo and will be done later.
- [x] Review grammar.
- [x] Disable checks for bootstrap code. -> In the grammar it is called legacy code.
- [x] Split up Dem into core and merger.
- [x] Add grammar check to CI build. -> Source code check was added to capabilities check.
- [x] Fix usage fragments. Currently, they often do not work and require Tokens for matches and the respective Regex do not work.
- [x] Use mixed grammar, which makes it possible to used fragment tokens more effectively (currently these are broken). -> Split up grammars are better, because lexer work in ANTLR more like validator if one ignores string patterns.
- [x] Remove explicit whitespace matches.
- [x] Document how to do non combined grammar.
- [x] Document how to do combined grammar. -> Not needed.
- [x] Use upper case for Keywords in Lexer.
- [x] Use constants in parser instead of tokens, in order to make these 2 more independent of each other. -> This does not have a real advantage.
- [x] Reformat grammar source code.
- [x] Create core project for Dem in order to test interface and implementation splitting.
- [x] Test speed up via using faster alternatives for data structures: Maps, Sets, Lists -> What is this?
- [x] Only allow foreign code import like the Java standard library in Java legacy code with some exceptions to the Java standard library like `java.util.List`. Currently, only Java standard library imports are blocked.
- [x] Let all source code comply with this Java subset grammar.
# Tasks For Future Tickets
- [ ] Translate code to dlang with working tests in order to be sure, that everything is handled by the grammar: https://tomassetti.me/how-to-write-a-transpiler/
- [ ] Remove direct usage of Path (because resolve method allows resolving absolute paths), Files (because changing the backend does not seem to be viable) and similar in the future.
- [ ] Make main part GPL compliant and only extensions non GPL compliant: https://github.com/www-splitcells-net/net.splitcells.network/issues/88
    - [ ] Note on planned future license change.

- [ ] Create basis for Translation. Use JavaParser for translation only instead of the Java grammer,
  in order to support some standard Java things/classes/method via name resolution
  without creating own wrapper interfaces and objects.