# Document compatibility guidelines
# Tasks
* [ ] Create dedicated compatibility guidelines.
* [ ] Link to dedicated compatibility guidelines in `CONTRIBUTING.md`, instead of describing the guidelines there.
* [ ] The compatibility's goal is to enhance the number of users **and/or** the number of contributors.
* [ ] Any backward compatibility is a cost, that should be paid by the backward compatibility benefactor.
    * [ ] Benefactor should pay for backward compatibility and non-benefactor contributors should at least not get actively knowingly in the way.
    * [ ]
* [ ] Backward compatibility currently, and probably until end of 2025 will have no benefit for the project
* [ ] If backward compatibility is necessary, note the preferred strategy.
  where the dedicated project `net.splitcells.network.system.api.stable` is created.
  It will contain the API, that is officially supported in a backward compatible manner via one big fluent interface.
  Projects with backward compatibility requirements are only allowed to explicitly use this Network API.