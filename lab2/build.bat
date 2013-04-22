@echo off

echo Building lab2...
javac -classpath ..\lib\javax.servlet.jar -sourcepath .\WEB-INF\classes\classes\ .\WEB-INF\classes\classes\*.java
jar cvf ..\lab2.war .\
