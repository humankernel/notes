# ssh connection with git 
#ssh


## Requirements

- openssh
- keychain

```sh
sudo pacman -S openssh keychain
```


## Steps 

```bash
export GH_SSH_PRIVATE="$HOME/.ssh/id_ed25519"                    
export GH_SSH_PUBLIC="${GH_SSH_PRIVATE}.pub"
 
# generate a new SSH key
ssh-keygen -t ed25519 \
    -C "$USER" \
    -f $GH_SSH_PRIVATE

# for validate it was correct
eval "$(ssh-agent -s)"

# to validate that the key is visible to ssh-agent
ssh-add -L

# add 
ssh-add $GH_SSH_PRIVATE

# copy public key to github
cat $GH_SSH_PUBLIC
```


[Github SSH Config](https://github.com/settings/ssh)

![[Pasted image 20230724104136.webp]]

## Test the connection with GitHub 

```shell
ssh -T git@github.com
```

## Troubleshooting

![[Pasted image 20230724103215.webp]]

```shell
chmod 600 [id_rsa]
```


this is how permissions has to look like

![[Pasted image 20230724104908.webp]]


