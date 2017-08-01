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

# URL:
# Web:
Departments: 
get all http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments
create http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/create
update http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/update?id=?
delete http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/delete?id=?
Employees:
get all for department: http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/?/employees?id=?
create http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/?/employees/create
update http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/?/employees/update?id=?
delete http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/?/employees/delete?id=?
find by date http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/?/find?date=?
find between dates http://localhost:8080/testtask-webapplication-1.0-SNAPSHOT/departments/?/between?start=?&end=?

# REST
Departments:
get by id http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}
get all http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments
create http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/create
update http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}/update
delete http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}/delete
Employees:
get by id http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}/employe/{?}
get all for department: http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}/employees
create http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}/employees/create
update http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}/employees/update
delete http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}/employees/{id}/delete
find by date http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}/employees/find/{?}
find between dates http://localhost:8080/testtask-restservice-1.0-SNAPSHOT/rest/departments/{?}/employees/from/{?}/to/{?}








