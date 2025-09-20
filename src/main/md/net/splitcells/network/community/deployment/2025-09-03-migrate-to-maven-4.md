# Migrate to Maven 4
# Tasks
* [ ] Ask Maven community, why [are internal BOMs discouraged](https://maven.apache.org/whatsnewinmaven4.html)?
  Especially the classifier argumentation seems like circular reasoning.
    * [ ] Online research was enough, to find the true reason for not recommending internal BOMs.
        * [ ] https://maven.apache.org/whatsnewinmaven4.html#New_packaging_type.3A_bom
        * [ ] https://issues.apache.org/jira/browse/MNG-8009
        * [ ] https://github.com/apache/maven/issues/10841
    * [ ] Document reasoning why BOMs are not used internally in a multi-module project.
    * [ ] Note, that I am not using something that is not considered a BOM in the Maven community,
      even though it is a BOM of external dependencies for me.
      My BOM is just another parent POM from the perspective of the Maven community. 
* [ ] Use [Maven Wrapper](https://maven.apache.org/tools/wrapper/), in order to easily migrate to Maven 4 and
  to make the build more stable and independent of the OS.