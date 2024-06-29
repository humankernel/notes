[Backup/Restore a dockerized PostgreSQL database - Stack Overflow](https://stackoverflow.com/questions/24718706/backup-restore-a-dockerized-postgresql-database)
[How to generate a Postgresql Dump from a Docker container? - Stack Overflow](https://stackoverflow.com/questions/30171063/how-to-generate-a-postgresql-dump-from-a-docker-container)
[How to dump & restore a PostgreSQL database from a docker container (davejansen.com)](https://davejansen.com/how-to-dump-and-restore-a-postgresql-database-from-a-docker-container/)

## docker compose

```yaml
version: '3.8'
services:
  db:
    container_name: pg_container
    image: postgres:alpine
    restart: always
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: 1234
      POSTGRES_DB: test_db
    volumes:
      - ./share:/share:rw
    ports:
      - "5432:5432"
  pgadmin:
    container_name: pgadmin4_container
    image: dpage/pgadmin4
    restart: always
    environment:
      PGADMIN_DEFAULT_EMAIL: admin@admin.com
      PGADMIN_DEFAULT_PASSWORD: 1234 
    ports:
      - "5050:80"

```

```bash
docker compose up -d 
```


## Backup your databases 

```bash
docker exec -t your-db-container pg_dumpall -c -U postgres > dump_`date +%Y-%m-%d"_"%H_%M_%S`.sql
```

Creates filename like `dump_2023-12-25_09_15_26.sql`

If you want a smaller file size, use gzip:

```sql
docker exec -t your-db-container pg_dumpall -c -U postgres | gzip > dump_`date +%Y-%m-%d"_"%H_%M_%S`.sql.gz
```

## Restore your databases

```sql
cat your_dump.sql | docker exec -i your-db-container psql -U postgres
```