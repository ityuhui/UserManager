# UserManager

## Prepare Database

```bash
cd ./db
docker compose -f ./postgres.yml up
```

Visit:
<http://xxxx:8080>

## Execute

Specify password for db in application.properties

```bash
sh ./startup.sh
```

## Test with curl

### Post

```bash
curl localhost:8060/api/v1/user -X POST -H "Content-Type: application/json" -d '{ "name": "usera", "email": "usera@163.com" }'

curl localhost:8060/api/v1/user/100 -X DELETE

curl localhost:8060/api/v1/user/100?name=userb -X PUT -H "Content-Type: application/json"

curl localhost:8060/api/v1/user/100 -X PUT -H "Content-Type: application/json" -d '{ "name": "userb" }'

```
