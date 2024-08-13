# OwnCloud


> [!Info] Images Required
> - owncloud/server
> - mariadb
> - redis


## `.env` file

| Setting Name               | Description                  | Example          |
| -------------------------- | ---------------------------- | ---------------- |
| `OWNCLOUD_VERSION`         | The ownCloud version         | `latest`         |
| `OWNCLOUD_DOMAIN`          | The ownCloud domain          | `localhost:8080` |
| `OWNCLOUD_TRUSTED_DOMAINS` | The ownCloud trusted domains | `localhost`      |
| `ADMIN_USERNAME`           | The admin username           | `admin`          |
| `ADMIN_PASSWORD`           | The admin user’s password    | `admin`          |
| `HTTP_PORT`                | The HTTP port to bind to     | `8080`           |


```bash
sudo nano .env

# Copy
OWNCLOUD_VERSION=latest
OWNCLOUD_DOMAIN=localhost
OWNCLOUD_TRUSTED_DOMAINS=localhost
ADMIN_USERNAME=admin
ADMIN_PASSWORD=admin
HTTP_PORT=80
HTTPS_PORT=443
```


## `docker-compose.yaml`


The following instructions assume you install locally. For remote access, the value of [OWNCLOUD_DOMAIN](https://doc.owncloud.com/server/next/admin_manual/configuration/server/config_sample_php_parameters.html#override-cli-url) and [OWNCLOUD_TRUSTED_DOMAINS](https://doc.owncloud.com/server/next/admin_manual/configuration/server/config_sample_php_parameters.html#define-list-of-trusted-domains-that-users-can-log-into) must be adapted.


```yaml
version: "3"

volumes:
  files:
    driver: local
  mysql:
    driver: local
  redis:
    driver: local

services:
  owncloud:
    image: owncloud/server:${OWNCLOUD_VERSION}
    container_name: owncloud_server
    restart: always
    ports:
      - ${HTTP_PORT}:8080
    depends_on:
      - mariadb
      - redis
    environment:
      - OWNCLOUD_DOMAIN=${OWNCLOUD_DOMAIN}
      - OWNCLOUD_TRUSTED_DOMAINS=${OWNCLOUD_TRUSTED_DOMAINS}
      - OWNCLOUD_DB_TYPE=mysql
      - OWNCLOUD_DB_NAME=owncloud
      - OWNCLOUD_DB_USERNAME=owncloud
      - OWNCLOUD_DB_PASSWORD=owncloud
      - OWNCLOUD_DB_HOST=mariadb
      - OWNCLOUD_ADMIN_USERNAME=${ADMIN_USERNAME}
      - OWNCLOUD_ADMIN_PASSWORD=${ADMIN_PASSWORD}
      - OWNCLOUD_MYSQL_UTF8MB4=true
      - OWNCLOUD_REDIS_ENABLED=true
      - OWNCLOUD_REDIS_HOST=redis
    healthcheck:
      test: ["CMD", "/usr/bin/healthcheck"]
      interval: 30s
      timeout: 10s
      retries: 5
    volumes:
      - files:/mnt/data

  mariadb:
    image: mariadb:latest # minimum required ownCloud version is 10.9
    container_name: owncloud_mariadb
    restart: always
    environment:
      - MYSQL_ROOT_PASSWORD=owncloud
      - MYSQL_USER=owncloud
      - MYSQL_PASSWORD=owncloud
      - MYSQL_DATABASE=owncloud
    command: ["--max-allowed-packet=128M", "--innodb-log-file-size=64M"]
    healthcheck:
      test: ["CMD", "mysqladmin", "ping", "-u", "root", "--password=owncloud"]
      interval: 10s
      timeout: 5s
      retries: 5
    volumes:
      - mysql:/var/lib/mysql

  redis:
    image: redis:6
    container_name: owncloud_redis
    restart: always
    command: ["--databases", "1"]
    healthcheck:
      test: ["CMD", "redis-cli", "ping"]
      interval: 10s
      timeout: 5s
      retries: 5
    volumes:
      - redis:/data
```