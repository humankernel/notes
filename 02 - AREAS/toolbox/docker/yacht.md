
# Yacht

> [!Info] Images Required
> - selfhostedpro/yacht

## run

```bash
docker volume create yacht

docker run -d -p 8000:8000 -v /var/run/docker.sock:/var/run/docker.sock -v yacht:/config selfhostedpro/yacht

```


After that you can access Yacht on port 8000 on your server in a web browser.

_If you're using Yacht alongside portainer you'll want to change the 8000 on the left of the `:` to 8001, then it will be available on that port on your host._

Once you're at the login page you can login with the username `admin@yacht.local` and the password `pass`.

