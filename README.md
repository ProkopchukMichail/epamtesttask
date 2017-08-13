# EPAM test task

This is multimodule java project, consist of 3 module: rest service, web application and model. Rest service and web application include model as dependency (maven build jar file from there). Program implements the work with departments and employees.

# Instruments and tecnologies:
Maven, Spring MVC, Spring jdbc, Jackson, Junit, Log4j, MySQL and HSQL.

# Build information

# MySQL database:
  login and password configuration in mysql.properties
  
  scripts:
  initialize: epamtesttask\testtask-restservice\src\main\resources\database\initDB_mysql
  population: epamtesttask\testtask-restservice\src\main\resources\database\populateDB_mysql
  
# Maven build:
mvn install -DskipTests (Junit tests don't work because project uses MySQL for deploy while tests use HSQL)

# Deploy:
run deploy.bat

# URL example:
# Web:
http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/

# REST
 http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments









