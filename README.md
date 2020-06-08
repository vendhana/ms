# MS
This project's main aims is to have understanding of frameworks, tools for Microservice development & deployment.

The business functionality of the project is to expose APIs to list down Orders & Customers.  Order data is having Order Id ,Customer Id, Transaction Amount. Customer data is having Customer Id, Name, Age.</br>

This project is updated to deprecate/add tools, farmeworks, packages in favour of making project more cloud native, performant and  feature rich. Each version captures description of the changes from previous version.</br>

### Base Framework & Tools

 - Open JDK 11    
 - Spring Boot Framework   
 - Maven 
 - Docker 
 - Kubernetes *[Added in 0.0.2]*
 - Nginx *[Added in 0.0.3]*
 - H2 (InMemory DB)
 
### Project Modules

 - service_config - Centralised Configuration Server
 - ~~service_registry - Service Registry~~ *[Removed in 0.0.3 - Replaced  by Kubernetes Service]*
 - ~~service_gateway - API Gateway~~ *[Removed in 0.0.3 - Replaced by Kubernetes Ingress]*
 - customer_service - Customer Service
 - order_service - Order Service
 
## 0.0.3 - Microservices using Spring Boot & Kubernetes , Deployment by Kubernetes

- Kubernetes is used instead of Spring components for below  
    - Registry & Discovery using Service instead of Eureka
    - Nginx as Ingress Controller for API Gateway instead Spring Gateway
- Rest Client using RestTemplate instead of Openfiegn
- Namespace ms is used for kubernetes  

### Microservice Components
|| Spring Component | Reference|
|--|--|--|
| Service | Spring Web |customer_service, order_service|
| Config Server | Spring Config Server |service_config|
| Config Client | Spring Config Client |customer_service, order_service|
| Service Registry | Kubernetes Service |kubernetes.yml *[Project Specific]*|
| Service Discovery  | Kubernetes |kubernetes.yml *[Project Specific]*, ms-ingress.yml|
| Fault Tolerence   | Spring Hystrix |order_service|
| API Gateway | Kubernetes Ingress (Nginx) |ms-ingress.yml|
| Service Client  | Spring Rest Template |order_service|
| Trace Logging  | Spring Sleuth |service_config, customer_service, order_service|
| Health Monitor  | Spring Actuator |service_config, customer_service, order_service|

### Containerisation
|| Component | Reference|
|--|--|--|
| Image Build | Spring Maven |service_config, customer_service, order_service|
| Orchestration | Kubernetes | kubernetes.yml *[Project Specific]* |

### Performance 
|| Jar Size (mB) | Image Size (MB) | Start up Time (s)|
|--|--|--|--|
| service_config | 34 | 282 | 29 |
| customer_service | 47 | 294  | 64 |
| order_service | 53 | 301  | 64 |


## 0.0.2 - Microservices using Spring Boot, Deployment by Kubernetes *[Only Changed sections are mentioned]*

- Removed Instance Size (MB) in Performance Observation
- Orchestration using Kubernetes
- Usage of IPAddress for Eureka Client Instance

### Containerisation
|| Component | Reference|
|--|--|--|
| Image Build | Spring Maven |service_config, service_registry, service_gateway, customer_service, order_service|
| Orchestration | Kubernetes | kubernetes.yml *[Project Specific]* |

### Performance 
|| Jar Size (mB) | Image Size (MB) | Start up Time (s)|
|--|--|--|--|
| service_config | 34 | 282 | 83 |
| service_registry | 50 | 297  | 115 |
| service_gateway | 48 | 295  | 95 |
| customer_service | 64 | 311  | 140 |
| order_service | 64 | 313  | 139 |


## 0.0.1 - Microservices using Spring Boot, Deployment by Docker Compose

### Microservice Components
|| Spring Component | Reference|
|--|--|--|
| Service | Spring Web |customer_service, order_service|
| Config Server | Spring Config Server |service_config|
| Config Client | Spring Config Client |service_registry, service_gateway, customer_service, order_service|
| Service Registry | Spring Netflix Eureka Server |service_registry|
| Service Discovery  | Spring Netflix Eureka Client |service_gateway, customer_service, order_service|
| Fault Tolerence   | Spring Hystrix |order_service|
| API Gateway | Spring Gateway |service_gateway|
| Service Client  | Spring Feign |order_service|
| Trace Logging  | Spring Sleuth |service_config, service_registry, service_gateway, customer_service, order_service|
| Health Monitor  | Spring Actuator |service_config, service_registry, service_gateway, customer_service, order_service|

### Containerisation
|| Component | Reference|
|--|--|--|
| Image Build | Spring Maven |service_config, service_registry, service_gateway, customer_service, order_service|
| Orchestration | Docker Compose | docker-compose.yml |

### Performance 
|| Jar Size (mB) | Image Size (MB) | Start up Time (s)|
|--|--|--|--|
| service_config | 34 | 282 | 25 |
| service_registry | 50 | 297  | 33 |
| service_gateway | 48 | 295  | 33 |
| customer_service | 64 | 311  | 44 |
| order_service | 64 | 313  | 49 |


