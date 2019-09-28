# Logging_Java
Automated logging of all function calls using AspectJ to implement crosscutting concern of logging.
We log name, argument name, argument value, return value and return type.
We provide various cases to test the logging aspect. The goal is to log every function call.
To weave aspects into code, we use the AspectJ compiler ajc and definde the dependencies over maven.

Build project  
```mvn -DskipTests package```

Run project  
```mvn exec:java```

