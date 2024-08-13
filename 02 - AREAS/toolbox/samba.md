# Build a Samba file server



## Install Samba

```shell
sudo apt update
sudo apt upgrade
sudo apt install samba samba-common-bin
```


## Create shared directory

```shell
sudo mkdir /home/pi/shared
```

## Configure Samba

We make a backup of the config file

```shell-session
sudo cp /etc/samba/smb.conf /etc/samba/smb.conf_backup
```

Now let’s edit the Samba configuration file. Enter:

```shell-session
sudo nano /etc/samba/smb.conf
```


## Looking at the configuration file

The Samba configuration file uses the same format as Windows .ini files, with sections surrounded with square brackets. The commands are case-insensitive and ignore white space. Let’s take a closer look at some of the lines in the file…

The location of the shared folder:

```shell-session
path = /home/pi/shared
```

Set this to ‘no’ to turn off the service:

```shell-session
available = yes
```

This is the list of users allowed to log in to the service:

```shell-session
valid users = pi
```

Whether this share is seen in the list of available shares in a net view and in the browse list:

```shell-session
browsable = yes
```

Ensures that users can write to files (the default is no):

```shell-session
writable = yes
```

Take a look at the [Samba.org documentation](https://www.samba.org/samba/docs/current/man-html/smb.conf.5.html) for more information on all the configuration options available in `smb.conf`. Test out the Samba configuration file with `testparm`. Enter the following:

```shell-session
testparm
```

…and you should see a series of ‘Processing section’ tests. At the end it should say ‘Loaded services file OK’. If not, head back to the start of this step and check you have entered the additional setup text correctly.

## Create a password

Before we start the server, you’ll want to set a Samba password. Enter:

```shell
sudo smbpasswd -a <user>
```

Now restart your Samba server:

```shell
sudo service smbd restart
```

## share folder

Create the new directory with the command:

```shell
sudo mkdir /data
```

You’re now ready to create the share.

Back at the `/etc/smb.conf` file, scroll to the bottom and add the following:

```shell
[DATA]
path = /data
valid users = @editors
browsable = yes
writable = yes
read only = no
```


Restart Samba with the command:

```shell
sudo systemctl restart smbd
```
