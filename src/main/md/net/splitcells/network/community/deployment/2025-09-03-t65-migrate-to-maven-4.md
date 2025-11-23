# Migrate to Maven 4
* Issue number: [\#65](https://codeberg.org/splitcells-net/net.splitcells.network.community/issues/65)
# Tasks
* [ ] Maven 4 is not fully released yet: https://maven.apache.org/docs/history.html
* [ ] Ask Maven community, why [are internal BOMs discouraged](https://maven.apache.org/whatsnewinmaven4.html)?
  Especially the classifier argumentation seems like circular reasoning.
    * [x] Online research was enough, to find the true reason for not recommending internal BOMs.
        * [x] https://maven.apache.org/whatsnewinmaven4.html#New_packaging_type.3A_bom
        * [x] https://issues.apache.org/jira/browse/MNG-8009
        * [x] https://github.com/apache/maven/issues/10841
    * [o] Document reasoning why BOMs are not used internally in a multi-module project.
      -> This is already documented.
    * [ ] Note, that I am not using something that is not considered a BOM in the Maven community,
      even though it is a BOM of external dependencies for me.
      My BOM is just another parent POM from the perspective of the Maven community. 
* [ ] Use [Maven Wrapper](https://maven.apache.org/tools/wrapper/), in order to easily migrate to Maven 4 and
  to make the build more stable and independent of the OS.