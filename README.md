# EPAM test task

This is multimodule java project, consist of 3 module: rest service, web application and model. Rest service and web application include model as dependency injection (maven build jar file from there). Programm implements the work with departments and employees.

# Instruments and tecnologies: Maven, Spring MVC, Spring jdbc, Jackson, Junit, Log4j, MySQL and HSQL.

# Build information

# MySQL database:
  login:  root
  password:  password
  
# Maven build:
mvn install -DskipTests (Junit tests don't work because project uses MySQL for deploy while tests use HSQL)

# Deploy:
run deploy.bat

# URL example:
# Web:
Departments: 
get all http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments
create http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/create
update http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/update?id=1
delete http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/delete?id=1
Employees:
get all for department: http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/2/employees
create http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/2/employees/create
update http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/2/employees/update?id=3
delete http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/?/employees/delete?id=3
find by date http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/2/find
find between dates http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/2/between

# REST
Departments:
get by id http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1
get all http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments
create http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/create
update http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1/update
delete http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1/delete
Employees:
get by id http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1/employe/1
get all for department: http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1/employees
create http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1/employees/create
update http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1/employees/update
delete http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1/employees/{id}/delete
find by date http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1/employees/find/{?}
find between dates http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/1/employees/from/1900-01-01T00:00/to/2000-01-01T00:00








