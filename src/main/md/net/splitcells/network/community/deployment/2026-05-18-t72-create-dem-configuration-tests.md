# Create Dem configuration tests.
# Task Description
Create a Dem configuration string serialization, in order to test the configuration results in build tests.
This way incorrectly refactored or migrated Dem configuration are not deployed to production.
This happened among others during the migration to the Cell API. 
# Tasks
* [x] Create Dem configuration serialization.
    * [x] Add optional serialization method to Option API.
    * [x] Add serialization for Cells. This is the test subject.
    * [x] Make serialization deterministic by defining an option order.
    * [x] Implement minimal test with one Option.
    * [x] Implement optional serialization for all Options, where it makes sense. Currently working on CinServiceInitTest.
    * [x] Implement optional serialization for all OptionImpls, where it makes sense. Currently working on X.
    * [x] Require all Options to implement the optional serialization, so none is overlooked.
* [x] Test SystemCell.
* [ ] Create a nice diff, if the test fails like git.
* [ ] Test LiveCryptoSetupCell.
* [ ] Test LiveDistroCell.
* [ ] Note this functionality in changelog.
* [ ] Document this feature and its idea in `Dem#testSerializeConfiguration`'s JavaDoc.