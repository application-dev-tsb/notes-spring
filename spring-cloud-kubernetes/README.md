# Spring Boot and Kubernetes
Here we are going to use create a simple microservice application that uses the spring-cloud and kubernetes

The following dependencies will be used:

| Technology              | Spring Standard               | Kubernetes Replacement  |
|-------------------------|-------------------------------|-------------------------|
| Service Discovery       | Eureka, Zookeeper             | Kubernetes Discovery    |
| Configuration           | Cloud Config                  | Kubernetes Config       |
| Circuit Breaker         | Hystrix, Turbine              | n/a                     |
| Routing/Load Balancing  | Zuul, Ribbon, Feign, Gateway  | n/a                     |
| Tracing                 | Zipkin, Sleuth                | n/a                     |

#### Architecture of the Dummy System
For the sake of demonstration, imagine a simple system:
- API: exposed to the outside world, ideally a frontend
- Controller: polls the database for certain work to be done
- Worker: Comes and goes, gets killed when no work needs to be done
- Database: A Postgres database tha we will initially include in the kubernetes cluster, we will throw this away when we go to prod 
```
Mini Architecture:
                                    |-------------> Worker
API ---------> [Database] <-----Controller -------> Worker
                                    |-------------> Worker
```

#### Roadmap
If you fail to plan, you plan to fail.
- [ ] Deploy a Postgres Image on the local cluster, match GCP's Cloud SQL version for Postgres
- [ ] Deploy a Spring Data + REST Repository Spring Boot Application (API)
- [ ] Expose API locally and try out some test entities using an embedded database
- [ ] Configure it to connect to a Postgres node
- [ ] Deploy the configuration into multi-zone kubernetes cluster
- [ ] Connect to a Google Cloud SQL instance
- [ ] Automate GCP resource creation and termination
- [ ] Implement CI/CD

#### Resources
- [Github: Spring Cloud Kubernetes](https://github.com/spring-cloud/spring-cloud-kubernetes)
- [DZone: Quick Guide to Microservices With Kubernetes, Spring Boot 2.0, and Docker](https://dzone.com/articles/quick-guide-to-microservices-with-kubernetes-sprin)
- [Youtube: Spring Cloud Kubernetes Example](https://www.youtube.com/watch?v=EWcgTub32dw&t=135s)
