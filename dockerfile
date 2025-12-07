FROM eclipse-temurin:25
ADD target/spring-ai-app.jar spring-ai-app.jar
ENTRYPOINT [ "java", "-jar", "/spring-ai-app.jar" ]