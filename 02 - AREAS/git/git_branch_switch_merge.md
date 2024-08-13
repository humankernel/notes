# branch | switch | merge

> [!Info]
> `branch` - list all branches  
> `switch` - jump to another branch
> `merge` - merge another branch with the current

## create a `branch`
```bash
# create a new branch
git branch [branch-name]

# move current branch to new one
git branch -m [branch-name]
```


## `switch` between branches

```bash
# jump 
git switch [branch]
```


## `merge` branches

```bash
git merge [branch]
```


> [!Warning] Merging conflict
> When you got a merge conflict:
> 1. First solve that conflict by choose one solution  
> 2. stage that file `git add <that_file>` 
> 3. commit that change `git commit -m ""`
> 4. merge again `git merge <branch>`
>    
> you can use `git diff <another-branch>` to watch for conflicts


## delete a `branch`

```bash
git branch -d <branch-to-delete>
```

