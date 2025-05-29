# DAF-EurekaDetails Service

A Spring Boot service that allows clients to query Eureka server instances and retrieve detailed information about registered services. This service can itself register with the Eureka instance it is querying.

## Features

- Query Eureka server instances for service details
- Group results by servers or services
- RESTful API endpoints
- Comprehensive error handling
- Metrics and health monitoring via Spring Boot Actuator
- Secure communication over HTTPS
- Transaction tracking and logging

## Technical Stack

- Java 17
- Spring Boot 3.1.0
- Spring Cloud Netflix Eureka Client
- Maven
- Spring Boot Actuator
- Lombok

## Prerequisites

- JDK 17 or higher
- Maven 3.6 or higher
- A running Eureka Server instance to query

## Getting Started

### Building the Service

```bash
mvn clean install
```

### Running the Service

```bash
mvn spring-boot:run
```

Or run the JAR file directly:

```bash
java -jar target/daf-eureka-details-1.0.0.jar
```

### Configuration

The service can be configured through `application.properties`. Key properties include:

```properties
# Application name
spring.application.name=daf-eureka-details

# Server port
server.port=8080

# Eureka client configuration
eureka.client.register-with-eureka=true
eureka.client.fetch-registry=true
```

## API Documentation

### Query Eureka Applications

Retrieves information about applications registered with a Eureka server.

**Endpoint:** `GET /cdi-eureka-service/v1/eureka/apps`

**Headers:**
- Content-Type: application/json

**Request Body:**
```json
{
    "eurekaServerURL": "http://eureka.example.com/eureka",
    "groupBy": "servers"  // or "services"
}
```

**Response Structure:**

For groupBy: "servers":
```json
{
    "returnCode": "SUCCESS",
    "message": "Request completed successfully",
    "httpStatusCode": 200,
    "transactionId": "uuid",
    "elapsedTime": 0.123,
    "servers": [
        {
            "hostName": "host1.example.com",
            "services": [
                {
                    "serviceName": "service1",
                    "ipAddr": "192.168.1.1",
                    "port": "8080",
                    "status": "UP",
                    ...
                }
            ]
        }
    ]
}
```

For groupBy: "services":
```json
{
    "returnCode": "SUCCESS",
    "message": "Request completed successfully",
    "httpStatusCode": 200,
    "transactionId": "uuid",
    "elapsedTime": 0.123,
    "services": [
        {
            "serviceName": "service1",
            "servers": [
                {
                    "hostName": "host1.example.com",
                    "ipAddr": "192.168.1.1",
                    "port": "8080",
                    "status": "UP",
                    ...
                }
            ]
        }
    ]
}
```

### Error Codes

| HTTP Status | Error Code | Message |
|------------|------------|---------|
| 200 | SUCCESS | Request completed successfully |
| 400 | INVALID_REQUEST | The query is badly formatted |
| 400 | INVALID_TOKEN | Invalid or expired JWT token |
| 401 | AUTH_REQUIRED | Authentication failed |
| 403 | ACCESS_DENIED | Valid credentials but insufficient permissions |
| 500 | UNKNOWN | Unexpected internal error |
| 502 | SERVICE_DOWN | System unavailable |
| 504 | TIMEOUT | Operation timed out |

## Testing

### Running Tests

```bash
mvn test
```

The project includes:
- Unit tests
- Integration tests
- Error handling tests
- Performance tests

## Security

The service implements several security measures:
- HTTPS communication
- Input validation and sanitization
- Error handling
- Logging of requests and responses


## Support

For support and questions, please contact:

COMPU-DATA INTERNATIONAL, LLC  
14610 Falling Creek Dr.  
Houston, Texas 77068  
(281) 292-1333  
Fax (281) 966-1598
