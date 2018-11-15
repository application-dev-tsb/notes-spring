# Postgres on Kubernetes

## Deploy to Kubernetes
```
# config
kubectl create -f postgres-configmap.yaml 

# disk
kubectl create -f postgres-volume.yaml 
kubectl get pv
kubectl get pvc

# pod
kubectl create -f postgres-deployment.yaml 
kubectl get deployments
kubectl describe deployments/postgres
kubectl describe pod postgres

kubectl create -f postgres-service.yaml 
kubectl create -f postgres-ingress.yaml 
```
- revert; stuff aint free
```
kubectl delete service postgres 
kubectl delete deployment postgres
kubectl delete configmap postgres-config
kubectl delete persistentvolumeclaim postgres-pv-claim
kubectl delete persistentvolume postgres-pv-volume
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