# qbittorrent

> [!Info] Images Required
> - linuxserver/qbittorrent


## `docker-compose.yaml`

```yaml
---
version: "2.1"
services:
  qbittorrent:
    image: linuxserver/qbittorrent:latest
    container_name: qbittorrent
    environment:
      - PUID=1000
      - PGID=1000
      - TZ=Etc/UTC
      - WEBUI_PORT=8090 
    volumes:
      - /config:/config
      - /:/downloads
    ports:
      - 8090:8090
      - 6881:6881
      - 6881:6881/udp
    restart: unless-stopped
```