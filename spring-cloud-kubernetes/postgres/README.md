# Postgres on Kubernetes

## Deploy to Kubernetes
```
kubectl create -f postgres-configmap.yaml 
kubectl create -f postgres-volume.yaml 
kubectl create -f postgres-deployment.yaml 
kubectl create -f postgres-service.yaml 
kubectl create -f postgres-ingress.yaml 
```

## Run Postgres Locally
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