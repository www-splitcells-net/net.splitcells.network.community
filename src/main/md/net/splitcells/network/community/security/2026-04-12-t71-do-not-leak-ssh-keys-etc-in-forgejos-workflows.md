# Do not leak ssh keys etc. in Forgejo workflows.

* The issue number is \#32.
# Description
The daily workflow leaks the private SSH key.
This was caused by a refactoring of the workflow.
This needs to be immediately fixed and the keys need to be immediately replaced.
# Tasks
* [x] Disable SSH keys.
    * [x] ssh-codeberg-worker
    * [x] ssh-ci
* [ ] Hotfix CI workflows.
* [ ] Use a technique, that prevents this problem in the future.
    * [ ] Has Forgejo something build-in for that?
      Otherwise, create a dedicated command, in order to handle this more carefully.
* [ ] Recreate SSH keys.
    * [ ] ssh-codeberg-worker
    * [ ] ssh-ci
* [ ] Test everything:
    * [ ] Live server deployment.
    * [ ] Laptop
    * [ ] Daily CI
    * [ ] Push based CI
    * [ ] Raspberry Pi
* [ ] During this I noticed, that Codeberg's runner are active in my workflows, which should not be the case: https://codeberg.org/Codeberg-e.V./requests/issues/1729