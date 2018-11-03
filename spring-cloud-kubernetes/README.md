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
```
                                    |-------------> Worker
API ---------> [Database] <-----Controller -------> Worker
                                    |-------------> Worker
```

#### Resources
- [Github: Spring Cloud Kubernetes](https://github.com/spring-cloud/spring-cloud-kubernetes)
- [DZone: Quick Guide to Microservices With Kubernetes, Spring Boot 2.0, and Docker](https://dzone.com/articles/quick-guide-to-microservices-with-kubernetes-sprin)
- [Youtube: Spring Cloud Kubernetes Example](https://www.youtube.com/watch?v=EWcgTub32dw&t=135s)
