# Spring Boot and Kubernetes
Here we are going to use create a simple microservice application that uses the spring-cloud and kubernetes. I am testing out the waters for the feasibility of GCP's Kubernetes Engine for my project: [Kwler.NET](https://github.com/kwler)

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
- Controller: polls the database for certain work to be done, use [Spring Cloud DataFlow](https://cloud.spring.io/spring-cloud-dataflow/) to orchestrate workers
- Worker: Comes and goes, gets killed when no work needs to be done, performs a unit of work, then dumps the result in the queue
- Database: A Postgres database tha we will initially include in the kubernetes cluster, we will throw this away when we go to prod 
```
Mini Architecture:

                                    Kubernetes (controls the number of workers)
                                       |
                                       |               |--------------> Worker1
API ---------> [Database] <-----Controller <--------> [Queue] <-------> Worker2
                                                       |--------------> WorkerX
```

#### Roadmap
*If you fail to plan, you plan to fail.* -L.Bibera, Solutions Architect
- [ ] Deploy a Postgres Image on the local cluster, match GCP's Cloud SQL version for Postgres
- [ ] Deploy a Spring Data + REST Repository Spring Boot Application (API)
- [ ] Expose API locally and try out some test entities using an embedded database
- [ ] Configure it to connect to a Postgres node
- [ ] Deploy the configuration into multi-zone kubernetes cluster
- [ ] Connect to a Google Cloud SQL instance
- [ ] Automate GCP resource creation and termination
- [ ] Implement CI/CD
- [ ] Implement Controller using [Spring Cloud Dataflow](https://cloud.spring.io/spring-cloud-dataflow/)
- [ ] Implement Worker
- [ ] Integrate worker-controller

#### Learning Goals
- [ ] Scaling: from zero to 60, and vice-versa
- [ ] Resiliency: figure out the behaviour of spring apps when faced with accidental terminations
- [ ] Automation: how to automate complicated systems, from deployment to rollbacks, with ideally zero downtime
- [ ] API evolution: avoiding issues with updated APIs of system dependencies

#### Resources
- [Github: Spring Cloud Kubernetes](https://github.com/spring-cloud/spring-cloud-kubernetes)
- [DZone: Quick Guide to Microservices With Kubernetes, Spring Boot 2.0, and Docker](https://dzone.com/articles/quick-guide-to-microservices-with-kubernetes-sprin)
- [Youtube: Spring Cloud Kubernetes Example](https://www.youtube.com/watch?v=EWcgTub32dw&t=135s)
