# Forking Workflow


> [!Info]
> The main advantage of the Forking Workflow is that contributions can be integrated without the need for everybody to push to a single central repository. Developers push to their own server-side repositories, and only the project maintainer can push to the official repository. This allows the maintainer to accept commits from any developer without giving them write access to the official codebase.


1. A developer 'forks' an 'official' server-side repository. This creates their own server-side copy.
2. The new server-side copy is cloned to their local system.
3. A Git remote path for the 'official' repository is added to the local clone.
4. **A new local feature branch is created.**
5. The developer makes changes on the new branch.
6. New commits are created for the changes.
7. **The branch gets pushed to the developer's own server-side copy**.
8. **The developer opens a pull request from the new branch to the 'official' repository.**
9. The pull request gets approved for merge and is merged into the original server-side repository


To integrate the feature into the official codebase
1. the maintainer pulls the contributor’s changes into their local repository
2. checks to make sure it doesn’t break the project, 
3. merges it into their local `main` branch
4. then pushes the `main` branch to the official repository on the server. 


## Fork a repository

![[Pasted image 20230724185041.webp]]


## Clone your fork

```shell
git clone https://user@bitbucket.org/user/repo.git
```


## Adding a remote

> [!Note]
> Whereas other Git workflows use a single origin remote that points to the central repository, the Forking Workflow requires two remotes
> 
> one for the official repository, 
> and one for the developer’s personal server-side repository. 

A common convention is to use origin as the remote for your forked repository (this will be created automatically when you run `git clone`) and upstream for the official repository.

```shell
git remote add upstream https://bitbucket.org/maintainer/repo
```


## Working in a branch: making & pushing changes

In the developer's local copy of the forked repository they can edit code, commit changes, and create branches just like in other Git workflows:

```shell
git checkout -b some-feature # Edit some code git commit -a -m "Add first draft of some feature"
```

```shell
git pull upstream main
```

## Making a Pull Request

![[05.svg]]


Upload the feature to your personal server-side repository

```shell
git push origin feature-branch
```

