cd %CATALINA_HOME%\webapps
DEL %CATALINA_HOME%\webapps\testtask-restservice-1.0-SNAPSHOT.war
rd %CATALINA_HOME%\webapps\testtask-restservice-1.0-SNAPSHOT /s /q
DEL %CATALINA_HOME%\webapps\testtask-webapplication-1.0-SNAPSHOT.war
rd %CATALINA_HOME%\webapps\testtask-webapplication-1.0-SNAPSHOT /s /q
move %CD%\\testtask-restservice\target\testtask-restservice-1.0-SNAPSHOT.war %CATALINA_HOME%\webapps
move %CD%\\testtask-webapplication\target\testtask-webapplication-1.0-SNAPSHOT.war %CATALINA_HOME%\webapps
cd %CATALINA_HOME%\bin
%CATALINA_HOME%\bin\startup.bat
