# Regularly backup personal user files
## Service
* Test restore via backups.
* Backup personal data.
* Simple and portable commands:
```
chezmoi re-add
chezmoi cd
git add -A
git commit -m "<Commit message>"
exit
chezmoi apply
```
* OSI commands.
```
chezmoi re-add
chezmoi cd
git add -A
repo.commit.all
exit
chezmoi apply
```
## Tasks
* [ ] Move this to a private repo, as this is specific to the author.
* [ ] Create full offline backup.
    * [ ] Consider using https://github.com/rustic-rs/rustic
    * [ ] Consider using restic.
        * [ ] https://github.com/garethgeorge/backrest
        * [ ] https://github.com/rubiojr/awesome-restic
    * [ ] Parchive 
* [x] `~/.gnupg`
