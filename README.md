# MS
This project's main aims is to have understanding of frameworks, tools for Microservice development & deployment.

The business functionality of the project is to expose APIs to list down Orders & Customers.  Order data is having Order Id ,Customer Id, Transaction Amount. Customer data is having Customer Id, Name, Age.</br>

### Base Framework & Tools

 - Open JDK 11    
 - Spring Boot Framework   
 - Maven 
 - Docker 
 - H2 (InMemory DB)
 
### Project Modules

 - service_config - Centralised Configuration Server
 - service_registry - Service Registry
 - service_gateway - API Gateway
 - customer_service - Customer Service
 - order_service - Order Service
 
## 0.0.1

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

#### 0.0.2 *[Only Changed sections are mentioned]*

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

