# How to handle git branches?
```
You asked to pull from the remote 'origin', but did not specify a branch. Because this is not the default configured remote for your current branch, you must specify a branch on the command line.
```
* [ ] I think the best would be to set this during the initial creation of the repo and during `repo.copy`. -> No, enforce usage of master branch on local and remote. Later, an option via a config file will be provided in order to use the main branch instead. Note, that in this case the current local branch name should be checked as well.
* [ ] Pull and push all branches.
    * [ ] How to delete branches? -> No deletion for the time being, but we need to document this and also need to document possible future deletion process.