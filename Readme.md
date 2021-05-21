# Sales Spring-boot app

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven 3.2+](https://maven.apache.org/download.cgi)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.pedroso.sales.SalesApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

### Linux
```shell
mvn spring-boot:run
```

### Windows
```shell
mvnw spring-boot:run
```