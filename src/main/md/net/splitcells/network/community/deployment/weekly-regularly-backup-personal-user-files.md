# Regularly backup personal user files
## Service
* Simple commands:
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
* [x] `~/.gnupg`
