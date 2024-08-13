 # fetch | push | pull

> [!Info]
> `fetch` - download all the history
> `push` - load every commit from the local branch to remote
> `pull` - download and merge the changes from remote to local


```bash
#
git fetch [bookmark]

#
git push [alias] [branch]

# if local its called master and remote is called main
git push origin master:main

# 
git pull
```


## Add a remote 

```shell
# set the remote origin
git remote add origin [url]

# example
git remote add origin git@github.com:rivasjoaquin02/hello-git.git
```


## Push

```shell
# only first time to sync main with origin
git push -u origin main
```


## Fetch

Watch for remote changes

```shell
git fetch
```



## Pull

Get the remote changes

```shell
# first time
git pull origin main
```

![[Pasted image 20230724114058.webp]]


set default strategy 

```shell
git config pull.rebase false
git pull
```

![[Pasted image 20230724114251.webp]]


