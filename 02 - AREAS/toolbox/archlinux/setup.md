
>[!Info] Rice
>wm: `hyprland`
>bar: `waybar`
>shell: `fish + starship`
>launcher: `rofi`
>audio: `pipewire`
>terminal: `alacritty`
>wallpapers: `hyprpaper`
>notification daemon: `dunst`: 
>auth agent: `polkit-gnome`: 
>brightness: `light`✍️✍

## [[hyprland]]

## Waybar

```sh
sudo pacman -S waybar

# copy the default config
cp /etc/xdg/waybar/config ~/.config/waybar

# autostart waybar
vim ~/.config/hypr/hyprland.conf

# hyprland.conf
exec-once: waybar
```

## Logout Menu

[ArtsyMacaw/wlogout: A wayland based logout menu (github.com)](https://github.com/ArtsyMacaw/wlogout)
```sh
yay -S wlogout

# add a bind to hyprland.conf
bind = , wlogout
```

## Screen Locking

```sh
sudo pacman -S swaylock swayidle 

# add to hyprland.conf
exec-once = swayidle -w timeout 150 'swaylock -f' timeout 200 'hyprctl dispatch dpms off' resume 'hyprctl dispatch dpms on'
```

## Starship

```sh
sudo pacman -S fish starship

# append in ~/.config/fish/config.fish
starship init fish | source

starship preset nerd-font-symbols -o ~/.config/starship.toml
```

## Automatically Mounting
[Other | Hyprland Wiki](https://wiki.hyprland.org/Useful-Utilities/Other/#automatically-mounting-using-udiskie)

USB Mass storage devices, like thumb drives, mobile phones, digital cameras, etc. do not mount automatically to the file system.

```sh
sudo pacman -S udiskie

# add 
exec-once = udiskie
```

## Wallpaper

Swww
```sh
yay -S swww

# modify hyprland.conf and add
exec-once = swww init
```

 Hyprpaper
```sh
sudo pacman -S hyprpaper

# create a .config/hypr/hyprpaper.conf and copy
preload = ~/wallpaper-path/wallpaper.jpg
wallpaper = ,~/wallpaper-path/wallpaper.jpg

# modify hyprland.conf and add
exec-once = hyprpaper
```

## Hyprland Desktop Portal
[Hyprland Desktop Portal | Hyprland Wiki](https://wiki.hyprland.org/Useful-Utilities/Hyprland-desktop-portal/)

```sh
pacman -S xdg-desktop-portal-hyprland
```

## Authentication Agent

```sh
sudo pacman -S polkit-gnome

# write this in hyprland.conf
exec-once=/usr/lib/polkit-gnome-agent-1
```

## Qt Wayland Support

Install `qt5-wayland` and `qt6-wayland`.

## Fonts

- ttf-cascadia-code-nerd
- fonts-font-awesome

```sh
sudo pacman -S ttf-cascadia-code-nerd fonts-font-awesome

# caching fonts
fc-cache
```

## Apps

> [!pkgs]
> package manager:
> 	- `flatpak`
> 	- `yay` 
> 
> social
> 	- telegram
> 	- whatsapp
> 
> todo
> 
> fileboot
> 
> backups
> 	- `timeshift`:
> 	  
> file manager
> 	- `thunar`
> 	- `ranger`
> 	- `spacedrive`
> 
> downloader
> 	- fragments
> 	- jdownloader
> 	- qbittorrent
> 	  
> images
> 	- `imv`
> 
> pdf's
> 	- komikku (comics)
> 	- `mupdf`
> 	- `zathura`
> 	  
> browser
> 	- `chromium`: 
> 	- `edge`
> 
> notes
> 	- `obsidian`
> 
> network
> 	- `windscribe-v2-bin`
> 	
> compression
> 	- `xarchiver` 
> 	- `p7zip`
> 	- unzip
>     
>  android
> 	 - gvfs
> 	 - gvfs-mtp
> 	 - thunar-volman
> 	   
>  video
> 	 - mpv
> 	 - mpd
> 	   
> audio
> 	- amberol [aur]
> wps
> 
> newsflash
> gnome-logs
> adw-gtk-theme (aur)
> gnome-themes-extra (for adwaita:dark)

## Enhanced Terminal Utils

> [!pkgs]
> - ls: `exa` 
> - task manager: `btop`
> - wifi-menu: `netctl`
> - info: `neofetch`
> - Fuzzy Finder: `fzf`

## DEV

- vscode
- idea
- datagrip
- clion
- devdocs


### Docker | Podman
```sh
# docker
sudo pacman -S docker docker-compose
sudo groupadd docker
sudo usermod -aG docker $USER


sudo pacman -S podman
yay -S pods
# to be able to pull from docker.io with podman
# add "docker.io" to line unqualified-search-registries
# in file /etc/containers/registries.conf

```

### Bun & Node
```sh
curl -fsSL https://bun.sh/install | bash 
sudo pacman -S nodejs

# docker 
docker pull oven/bun
docker run --rm --init --ulimit memlock=-1:-1 oven/bun

# pnpm
sudo pacman -S pnpm
```

### Java
```sh
sudo pacman -S jdk-openjdk
```



> [!Faq]- Issue while trying to open some apps
> 
> ```sh
> sudo pacman -S timeshift
> sudo -E timeshift-gtk
> ```
