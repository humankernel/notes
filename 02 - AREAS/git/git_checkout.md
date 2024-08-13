# git checkout

> [!Info]
> Move between different( **files** | **commit** | **branches**)
> 
> originaly used for both creating and switching branches, as well as restoring changes from a certain commit




```bash
# discard changes in a specific file and restore it to its last committed state.
git checkout [file]

# move to past commit
git checkout [commit hash]

# create and move to branch 
# same as git branch [branch] a then git checkout [branch])
git checkout -b [branch-name]

# move to another branch
git checkout [branch]
# better to use switch instead
git switch [branch]
```


## checkout vs switch , restore

`git switch` - switch between branches
`git restore` - undoing changes from a commit
`git checkout` - more advanced options

