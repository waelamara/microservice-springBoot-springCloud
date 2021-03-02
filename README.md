<<<<<<< HEAD
# microservice-springBoot-springCloud

## 1. Project architecture
=======
## 1. Project architecture
Our sample microservices-based system consists of the following modules:
- **gateway-service** - a module that uses the Spring Cloud Gateway to get routes in order to process requests to downstream services.
- **config-service** - a module that uses Spring Cloud Config Server for running configuration server. The configuration source git uri: https://github.com/waelamara/config-properties.git.
- **registry-service** - a module that uses Spring Cloud Netflix Eureka as an embedded discovery server depending on the example.
- **user-service** - a module containing the first of our sample microservices (user management).
- **product-service** - a module containing the second of our sample microservices (product management). 
- **billing-service** - a module containing the third of our sample microservices (billing management). It communicates with both user-service and product-service.


The following picture illustrates the architecture described above.
>>>>>>> 02240be2c4453950563837efcf323200f8a35da9

![](project_architecture.jpg)

