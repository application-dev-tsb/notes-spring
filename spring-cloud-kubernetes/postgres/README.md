# Postgres on Kubernetes

- for demo purposes
```
# -P, to expose the ports
# --rm, to remove the container after termination

docker run -P --rm \
-e POSTGRES_DB='postgresdb' \
-e POSTGRES_USER='postgresadmin' \
-e POSTGRES_PASSWORD='postgrespassword123' \
--name=postgres \
postgres:10.4 
```
- check the forwarded port
```
docker port postgres
```
- connect
```
psql postgresql://postgresadmin:postgrespassword123@localhost:32775/postgresdb
```

#### Resources
- [Deploy Postgres on Kubernetes](https://severalnines.com/blog/using-kubernetes-deploy-postgresql)