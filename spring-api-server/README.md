# API Server Practice

## Mongo
- install mongo
- run: mongod
- https://spring.io/guides/gs/accessing-data-mongodb/

## REST
```
curl -X POST -d '{"firstName": "Saruman", "lastName": "the evil one"}' localhost:8080/customers -u greg:turnquist -H "Content-Type: application/json"
```