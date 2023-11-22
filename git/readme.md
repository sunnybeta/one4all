# Git

<img src='https://git-scm.com/images/logos/downloads/Git-Icon-1788C.svg'>

## Commands

*The following is a list of my favourite commands.*

### Initialization

Initializes the current directory with a `.git` folder:

```bash
git init .
```

Add files for tracking:

```bash
git add .
```

### Branch

Create a new branch with a name and checkout the branch

```bash
git checkout -b my-new-branch
```

Switch branch

```bash
git checkout my-new-branch
```


### Remote URL

Add the URL of the remote repository.

```bash
git remote add origin git@github.com:sunnybeta/one4all
```

Remove the remote URL

```bash
git remote remove origin
```

View the remote URL

```bash
git remote -v
```

### Status

View the status of the current branch, how many files are tracked and manage changes.

```bash
git status
```

### Stash

Put your current changes into a stash to reuse later

```bash
git stash
```

Redo the last stash

```bash
git stash apply
```

### Unstage

Remove files from being tracked

```bash
git reset filename
```

### Undo

If you made a wrong commit, hit the following. Git needed an undo command and this is it.

```bash
git reset HEAD~
```

### Prune

Gets rid of deleted branches from remote repository in local:

```bash
git fetch --prune
```

### Set Upstream

Push the current code in *<branch>* and create it remotely:

```bash
git push -u origin <branch>
```


## Merge Flow

```bash
git add .
git commit -m "feat: this is a commit message"
git push
```

In case of conflicts:

```bash
git pull master
git checkout my-awesome-branch
git merge dev
# Fix conflicts
git push
```


## Rebase Flow

```bash
git add .
git checkout master
git pull
git checkout my-awesome-branch
git rebase master
# Fix conflicts
git checkout master
git rebase my-awesome-branch
git push
```

