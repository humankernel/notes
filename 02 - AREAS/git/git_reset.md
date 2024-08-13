# git reset

> [!Info]
> *Move the file from the staged area, but keeps its content
> 
> `reset` is the command we use when we want to move the repository back to a previous `commit`, discarding any changes made after that `commit`.

Step 1: Find the previous `commit`:
![[img_reset_part1.gif]]

Step 2: Move the repository back to that step:
![[img_reset_part2.gif]]


```bash
# unstage a file
git reset [file]

# uncommit every comit since [commit] but keeps the changes localy
git reset [commit]

# discard all the history and moves to [commit]
git reset --hard [commit]
```


> [!Warning] 
> Messing with the `commit` history of a repository can be dangerous. It is usually ok to make these kinds of changes to your own local repository. However, you should avoid making changes that rewrite history to `remote` repositories, especially if others are working with them.


## Undo a Reset

```bash
# search for the original position hash
git reflog

git reset <original-position-commit-hash>
```
