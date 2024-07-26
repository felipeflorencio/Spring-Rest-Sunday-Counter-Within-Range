# Sunday Counter API

This Spring Boot application provides an API to find months starting on a Sunday within a given date range.

## Building And Running the Application

To build the application, run the following command:

```bash
mvn clean install
```

```bash
mvn spring-boot:run
```

## Testing

To all run all test class use:
```bash
mvn test
```

The application will start on http://localhost:8080.

## Request data Range using cURL

```bash
curl -G 'http://localhost:8080/sundays' --data-urlencode 'from=1998-01-01' --data-urlencode 'to=2024-12-31'
```

## OpenAPI Spec

You can also check the OpenAPI Spec 

For browser:
```bash
http://localhost:8080/swagger-ui/index.html
```

For Json Data:
```shell
http://localhost:8080/v3/api-docs
```