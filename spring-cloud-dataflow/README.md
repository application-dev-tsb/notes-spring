# Spring Cloud Dataflow
Microservice flow control for streaming or long-running jobs.

#### Basically Composed of the following
- [Spring Cloud Dataflow](https://cloud.spring.io/spring-cloud-dataflow/)
- [Spring Cloud Stream](https://cloud.spring.io/spring-cloud-stream/)
- [Spring Cloud Task](https://spring.io/projects/spring-cloud-task)
- [SCDF Kubernetes](https://docs.spring.io/spring-cloud-dataflow-server-kubernetes/docs/current/reference/htmlsingle/#kubernetes-getting-started)

#### Other Technologies Involved
- [Helm](https://github.com/helm/helm)/[Charts](https://github.com/helm/charts): preconfigured Kubernetes resources
- [Skipper](https://github.com/zalando/skipper): routing resources

#### Workflow
- Create task or stream processor (unless its one of the built-in ones)
