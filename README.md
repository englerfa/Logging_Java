# Logging_Java
This repository provides a method to log all method calls automatically. 
A log statement contains a timestamp, method name, argument names, types, and values, and return type and value.
The logs are available in a human-readable and machine-readable (JSON) format.
We implement automated logging using AspectJ, which is an aspect-oriented programming solution for Java.
To weave aspects into code, we use the AspectJ compiler ajc and define the dependencies over maven.

To build project with maven

```mvn -DskipTests package```

Run project  

```mvn exec:java```

## Limitations
- We cannot limit the depth of function calls.
