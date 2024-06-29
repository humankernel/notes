## Creating your own dotfiles

```shell
# create a bare git repo for the dotfiles
git init --bare $HOME/.dotfiles

# alias the command to "config"
alias config='/usr/bin/git --git-dir=$HOME/.cfg/ --work-tree=$HOME'

#
config config --local status.showUntrackedFiles no

# adding the aliast to the .bashrc
echo "alias config='/usr/bin/git --git-dir=$HOME/.cfg/ --work-tree=$HOME'" >> $HOME/.bashrc
```



```shell
# set the alias
alias config='/usr/bin/git --git-dir=$HOME/.dotfiles/ --work-tree=$HOME'

# add the future .dotfiles folder to .gitignore
echo ".dotfiles" >> .gitignore

# clone the repo in a bare repo
git clone --bare https://github.com/rivasjoaquin02/dotfiles.git $HOME/.dotfiles

# define the alias (again?)
alias config='/usr/bin/git --git-dir=$HOME/.dotfiles/ --work-tree=$HOME'

# sync with your dotfiles (this could throw an error)
config checkout

# set showUntrackedFiles -> no
config config --local status.showUntrackedFiles no
```

