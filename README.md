# Logging_Java
This repository provides a method to automatically log all method calls. 
A log statement contains a timestamp, method name, argument names, types, and values, and return type and value.
We implement automated logging using AspectJ, which is an aspect-oriented programming solution for Java.
To weave aspects into code, we use the AspectJ compiler ajc and define the dependencies over maven.

To build project with maven:
```mvn -DskipTests package```

Run project  
```mvn exec:java```

