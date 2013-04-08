@echo off

echo Building lab1...
javac -classpath .\lib\javax.servlet.jar -sourcepath .\lab1\war\WEB-INF\classes\ .\lab1\war\WEB-INF\classes\CheckingServlet.java
jar cvf lab1.war .\lab1\war\
