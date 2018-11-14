# Postgres on Kubernetes

- for demo purposes
```
docker run \
-e POSTGRES_DB='postgresdb' \
-e POSTGRES_USER='postgresadmin' \
-e POSTGRES_PASSWORD='postgrespassword123' \
-p 5432:5432 \
postgres:10.4 
```
```
psql postgresql://postgresadmin:postgrespassword123@localhost:5432/postgresdb
```

#### Resources
- [Deploy Postgres on Kubernetes](https://severalnines.com/blog/using-kubernetes-deploy-postgresql)