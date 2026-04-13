# Do not leak ssh keys etc. in Forgejo workflows.
* The issue number is \#32.
* Start Date: 2026-04-13
* End Date: 2026-04-13
# Description
The daily workflow leaks the private SSH key.
This was caused by a refactoring of the workflow.
This needs to be immediately fixed and the keys need to be immediately replaced.
# Tasks
* [x] Disable SSH keys.
    * [x] ssh-codeberg-worker
    * [x] ssh-ci
* [ ] Use a technique, that prevents this problem in the future.
    * [x] Has Forgejo something build-in for that?
      Otherwise, create a dedicated command, in order to handle this more carefully. -> There is no dedicated feature to write secrets to runner instance without accidentally printing it.
    * [x] `set +x && [commands doing something with secrets]` seems to be the best way to deal it.
      This way should also be safe regarding workflow refactorings as anything, that handles secrets ensures itself this way,
      that nothing is printed.
    * [x] Adjust daily CI.
    * [x] Adjust push based CI.
    * [x] Note this in the Bash guidelines.
* [x] Recreate SSH keys.
    * [x] ssh-codeberg-worker
    * [x] ssh-ci
* [x] Test everything:
    * [x] Live server deployment.
    * [x] Daily CI
    * [x] Push based CI
* [x] During this I noticed, that Codeberg's runner are active in my workflows, which should not be the case: https://codeberg.org/Codeberg-e.V./requests/issues/1729
  -> Codeberg's runners are not really active according to Codeberg's team.