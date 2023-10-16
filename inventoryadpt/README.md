# hexprojects - Inventory Module
Module to handle inventory

## How to compile
Run:
```
mvn clean install
```

## How to run
With remote debug:
```
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
```
## External dependencies
### Docker
MySQL
```
docker-compose -f mysql-docker-compose.yml up -d
```
### Maven Dependencies
<ul>
<li>Lombok</li>
</ul>