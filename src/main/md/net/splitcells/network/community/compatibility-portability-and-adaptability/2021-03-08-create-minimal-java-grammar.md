# Create minimal Java grammar for this project in order to make code less complex
- The issue numbers are `#26` and `#10`.
    - [This is the current online ticket.](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/26)
    - [This is the original issue.](https://github.com/www-splitcells-net/net.splitcells.network/issues/10)
- [ ] Recheck this ticket and clean it up.
- [ ] Avoid grammar check if JavaLegacyArtifact is present, because it destroys the error messages of ANTLR4.
- [ ] Check grammar for all repos.
    - [ ] Create equivalent to repo process, but for projects.
    - [ ] Create `net.splitcells.project.process` project, in order to process such projects.
    - [ ] Move `net.splitcells.project.files.standard` content into `net.splitcells.project.process` and 
      delete original.
      This way a generic project exists for such things and
      improves the existing project name, which is too long.
- [x] Create alternative implementations for all `Domable#toDom` instances.
- [x] Fix grammar error, that causes ANTLR4 to not show, what the grammar error. -> Found a workaround: The rule `(.)*? Keysymbol_at Keyword_JavaLegacyArtifact (.)*? EOF` breaks every error message. Disabling this rule for a file in question creates normal error messages.
    - [x] Print out lexer's tokens result on error. Maybe that is enough? https://stackoverflow.com/questions/70701595/is-there-a-way-to-extract-tokens-in-order-with-antlr
    - [x] Maybe try out ANTLR4 UI first.
- [ ] Remove usage of `org.w3c, because of the problems associated with this lib.
    - [ ] Remove usage of `Domable#toDom` except inside `Domable#toDom` implementations.
        - [ ] `toDom` is used in order to implement `toDom` like functions like `Constraint#graph`.
        - [ ] Remove other `toDom` usage.
            - [x] Update `Rater#argumentation(GroupId, Table)`.
                - [x] Test whether `Rater#argumentation(GroupId, Table)` is used at all.
                  -> No it is not really used. So We can replace the method in one go or commit.
                  We could even delete it with no issue, but it may have a need, that is forgotten, so we just convert it instead.
                  `Rater#argumentation(GroupId, Table)` does not have anything to do with `Constraint#naturalArgumentation()` and co.
                - [x] Create test for argumentation. -> Is not needed
                - [x] Remove `Rater#argumentation(GroupId, Table)` from Rater interface.
                - [x] Convert all `Rater#argumentation(GroupId, Table)` overrides to normal methods, that use Perspective instead.
            - [x] Update `Solution#createAnalysis`.
                - [x] Convert `Constraint#toDom()`
                    - [x] Remove method usage.
                - [x] Convert `Constraint#graph()`
            - [ ] Convert `SolutionView#toFodsTableAnalysis` via `toFodsTableAnalysis2`.
                - [ ] Convert `SolutionView#toLinesFodsAnalysis` via `toLinesFodsAnalysis2`. CURRENT
                    - [ ] Ensure, that header is written correctly. See [example](#FODS-Header).
                    - [ ] Render some Perspective properties as XML properties.
                        - [ ] Encode the fact, that something is an attribute in the NameSpace.
                          Add the attribute `isXmlAttribute`.
                          In order to support some values in an XML namespace
                        - [ ] style-name
                        - [ ] XML_ATTRIBUTE
                        - [ ] FODS_STYLE
                            - [ ] name
                            - [ ] family 
                            - [ ] parent-style-name
                        - [ ] FODS_FO
                            - [ ] background-color
                            - [ ] color
                        - [ ] FODS_OFFICE  mimetype
                        - [ ] FODS_TABLE name
                - [ ] Convert `fodsStyling` via `fodsStyling2`.
                - [ ] Convert `fodsStyling_style` via `fodsStyling_style2`.
                - [ ] Convert `attributesOfFodsAnalysis` via `attributesOfFodsAnalysis2`.
          - [ ] Convert `History#toFods()`
            - [ ] Update `History#toAnalysisFods`.
                - [ ] Create a test for this.
            - [ ] Update `ProjectsRendererI#createLayout`.
                - [ ] Create a test for this.
          - [ ] Convert `Solution#ViewtoFodsTableAnalysis`
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

# Quotes
## FODS-Header
```
<?xml version="1.0" encoding="UTF-8"?>
<office:document xmlns:office="urn:oasis:names:tc:opendocument:xmlns:office:1.0"
                 xmlns:fo="urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0"
                 xmlns:style="urn:oasis:names:tc:opendocument:xmlns:style:1.0"
                 office:mimetype="application/vnd.oasis.opendocument.spreadsheet">
```