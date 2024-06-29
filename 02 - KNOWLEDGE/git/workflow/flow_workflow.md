# Git Flow


> [!Branches]
> - `main` - branch for releases only
> - `develop` - branch in which we will be working 
> 	- source: main
> 	- merge: release
> - `feature` 
> 	- source: develop
> 	- merge: develop
> - `release` - branch for release
> 	- source: develop
> 	- merge: main & develop
> - `hotfix` - 
> 	- source: main
> 	- merge: main & develop


Its a Branching Workflow for `git` #git


## Develop and main branches
![[01 How it works.svg]]


Instead of a single `main` branch, this workflow uses two branches

- `main` branch stores the official release history, 
- `develop` branch serves as an integration branch for features


The first step is to complement the default `main` with a `develop` branch

```shell
git branch develop
git push -u origin develop
```


## Feature branches

Each new feature should reside in its own branch, which can be [pushed to the central repository](https://www.atlassian.com/git/tutorials/syncing/git-push) for backup/collaboration`

feature` branches use `develop` as their parent branch

When a feature is complete, it gets [merged back into develop](https://www.atlassian.com/git/tutorials/using-branches/git-merge). Features should never interact directly with `main`.

![[02 Feature branches.svg]]

### Creating a feature branch

```shell
git checkout develop
git checkout -b feature_branch
```

### Finishing a feature branch

When you’re done with the development work on the feature, the next step is to merge the `feature_branch` into `develop`

```shell
git checkout develop
git merge feature_branch
git branch -d feature_branch
```


## Release branches

![[03 Release branches.svg]]

Once `develop` has acquired enough features for a release (or a predetermined release date is approaching), you fork a `release` branch off of `develop`

> [!Note]
> Creating this branch starts the next release cycle, so no new features can be added after this point—only bug fixes, documentation generation, and other release-oriented tasks should go in this branch


Once it's ready to ship, the `release` branch gets merged into `main` and tagged with a version number. In addition, it should be merged back into `develop`, which may have progressed since the release was initiated

### Creating a `release` branch

```shell
git checkout develop
git checkout -b release/0.1.0
```

Once the release is ready to ship, it will get merged it into `main` and `develop`, then the `release` branch will be **deleted**

It’s important to merge back into `develop` because critical updates may have been added to the `release` branch and they need to be accessible to new features

### Finish `release` branch

```shell
git checkout main
git merge release/0.1.0
```


## Hotfix branches

![[04 Hotfix branches.svg]]

Maintenance or `“hotfix”` branches are used to quickly patch production releases

This is the only branch that should fork directly off of `main`

As soon as the fix is complete, it should be merged into both `main` and `develop` (or the current `release` branch) and `main` should be tagged with an updated version number

### Creating a `hotfix` branch

```shell
git checkout main
git checkout -b hotfix_branch
```

### Finishing a `hotfix` branch

Similar to finishing a `release` branch, a `hotfix` branch gets merged into both `main` and `develop

```shell
git checkout main
git merge hotfix_branch

git checkout develop
git merge hotfix_branch

git branch -D hotfix_branch
```


## Example

```shell
git checkout main
git checkout -b develop
git checkout -b feature_branch
# work happens on feature branch
git checkout develop
git merge feature_branch
git checkout main
git merge develop
git branch -d feature_branch
```

1. `main` branch is created
2. `develop` branch is created and we jump there
3. `feature` branch is created and we jump there
	1. we work on the feature 
4. jump to `develp`
5. merge with `feature`
6. jump to `main`
7. merge with `develop`
8. delete the `feature` branch

### Hotfix example

```shell
git checkout main
git checkout -b hotfix_branch
# work is done commits are added to the hotfix_branch
git checkout develop
git merge hotfix_branch
git checkout main
git merge hotfix_branch
```

1. `main` branch is created
2. `hotfix` branch is created and we jump there
	1. we work on hotfix
4. jump to `develp`
5. merge with `hotfix`
6. jump to `main`
5. merge with `hotfix`


## The overall flow of `Gitflow` is:

1. A `develop` branch is created from `main`
2. A `release` branch is created from `develop`
3. `Feature` branches are created from `develop`
4. When a `feature` is complete it is merged into the `develop` branch
5. When the `release` branch is done it is merged into `develop` and `main`
6. If an issue in `main` is detected a `hotfix` branch is created from `main`
7. Once the `hotfix` is complete it is merged to both `develop` and `main`