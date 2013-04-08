#!/bin/bash

echo Building lab1...
javac -classpath ./lib/javax.servlet.jar:./lab1/war/WEB-INF/classes/ ./lab1/war/WEB-INF/classes/CheckingServlet.java
