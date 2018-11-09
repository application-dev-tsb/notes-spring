# Spring Cloud Dataflow (Kubernetes Deployment)
Microservice flow control for streaming or long-running jobs.

#### Basically Composed of the following
- [Spring Cloud Dataflow](https://cloud.spring.io/spring-cloud-dataflow/)
- [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/)
- [Spring Cloud Task](https://spring.io/projects/spring-cloud-task)
- [SCDF Kubernetes](https://docs.spring.io/spring-cloud-dataflow-server-kubernetes/docs/current/reference/htmlsingle/#kubernetes-getting-started)

#### Other Technologies Involved
- [Helm](https://github.com/helm/helm)/[Charts](https://github.com/helm/charts): preconfigured Kubernetes resources
- [Skipper](https://github.com/zalando/skipper): routing resources, SPDF leverages this to perform upgrades and rollbacks

## SCDF Deployment Steps
- [ ] Deploy message broker
- [ ] Deploy database
- [ ] Deploy Redis
- [ ] Deploy Skipper
- [ ] Deploy the SCDF Server

## SCDF Deployment Steps (Alternative with Helm)
An alternative way of deploying SCDF using a Helm chart
- [ ] Install Helm
- [ ] Add SCDF incubator

## Deploying Streams and Tasks
- TODO
#### Resources
- [Built-in SCDF Components](https://docs.spring.io/spring-cloud-dataflow-server-kubernetes/docs/current/reference/htmlsingle/#applications)
