# hexprojects - Billing Module
Module to handle billing operations.

## How to compile
Run:
```
mvn clean install
```

## How to run
With remote debug:
```
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 --enable-preview"
```
## External dependencies
### Docker
MongoDB
```
docker-compose -f deps-docker-compose.yml up
```
### Maven Dependencies
<ul>
<li>Lombok</li>
</ul>