# Spring Boot

## Getting Started

### Spring Initializer

Download the required files for starting a spring project on [Spring Initializer](https://start.spring.io/).

###  JDBC

Java Database Connectivity is a specification that provides a standard API for java applications to communicate with various databases.
Interacting with a database requires efficient database connectivity which can be achieved by using the ODBC (Open DataBase Connectivity) driver. This driver is used with JDBC to interact or communicate with various kinds of databases such as Oracle, MS Access and MySQL.

### Components of JDBC

1. **JDBC API**: Provides various methods and interfaces for easy communication with the database.
2. **JDBC Driver Manager**: Loads a database specific driver in a application to establish a connection with a database.
3. **JDBC Test Suite**: Used to test CRUD operations being performed by JDBC drivers
4.**JDBC-ODBC Bridge Drivers**: Connects database drivers to the database by translateing the JDBC method call to the ODBC function call.

## IoC Container

### Inversion of Control

IoC, also known as Dependency Injection, is a process whereby objects define their dependencies only through
constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method.

### Beans

The objects that form the backbone of your aplication and that are managed by the Spring IoC container are called **beans**. A bean is an object that is instantiated, assembled, and managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your applications.

The container then injects those dependencies when it creates the bean. This process is the IoC of the bean itself controlling the instantiation or location for its dependencies by using direct construction of classes or a mechanism such as the Service locator pattern.

### Bean Factory

The `BeanFactory` interface provides an advanced configuration mechanism capable of managing any type of object.

### Application Context

The `ApplicationContext` is a sub-interface of the `BeanFactory`. It adds:
- easier integration with Spring's AOP (Aspect Oriented Programming)  features
- message resource handling
- event publication
- application layer specific contexts such as the `WebApplicationContext` for use in web applications.

The `ApplicationContext` adds more enterprise-specific functionality.

## Annotations

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

```java
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="/path")
public class UserController {}
```

```java
import org.springframework.context.annotation.Bean;
@Bean
```

```java
import org.springframework.beans.factory.annotation.Autowired;
@Autowired
```

```java
import org.spring.framework.web.bind.annotation.GetMapping;
@GetMapping(path="/resource")
```

```java
import org.spring.framework.web.bind.annotation.ResponseBody;
@PatchMapping
```


```java
import org.spring.framework.web.bind.annotation.PostMapping;
@PostMapping
```

```java
import org.spring.framework.web.bind.annotation.PutMapping;
@PutMapping
```

```java
import org.spring.framework.web.bind.annotation.PathVariable;
@PathVariable
```

```java
import org.spring.framework.web.bind.annotation.RequestBody;
@RequestBody
```

```java
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="table_")
public class Location {
    @Id
    private integer;
    // other column definitions
}
```

```java
import jakarta.persistence.Entity;

@Entity

}
```

```java
```

```java
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    // code ...
}
```

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, String> {
    // code ...
}
```


```java
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GeneratedType;
@GeneratedValue(strategy=GenerationType.AUTO)
```


## Endpoints

```java
@RestController("")
public class UserController {
    @GetMapping("/healthcheck")
    public String health() {
        return "{status: healthy}";
    }
}
```

## Database Connection


### MongoDB

### PostgreSQL

**src/main/resources/application.properties**

```properties
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://<host>:<port>/<database>
spring.datasource.username=postgres
spring.datasource.password=my-awesome-password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

**pom.xml**

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
```
## Authentication

## AWS SDK

### S3

### SQS

### SNS

## Eureka

## Feign

## Configuration

## Dockerfile

Run `./mvnw clean install` to obtain the JAR file in `target/` directory.

```bash
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY ./target/server-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD ["java", "-jar", "server-0.0.1-SNAPSHOT.jar"]
```
