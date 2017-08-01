#                                                               EPAM test 

  This is multimodule java project, consist of 3 module: rest service, web application and model. Rest service and web application include model as dependency injection (maven build jar file from there). Programm implements the work with departments and employees.
  
  Instruments and tecnologies: Maven, Spring MVC, Spring jdbc, Jackson, Junit, Log4j, MySQL and HSQL.
  
 #                                                           Build information
 
# MySQL database:
    login:  root
    password:  password
 
# Maven build:
mvn install -DskipTests (Junit tests don't work because project uses MySQL for deploy while tests use HSQL)
 
# Deploy:
run deploy.bat
