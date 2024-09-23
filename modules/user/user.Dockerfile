FROM openjdk:23-ea-21-jdk-slim-bookworm
WORKDIR /app
COPY target/user-service-0.1.jar /app/user-service.jar
ENTRYPOINT ["java", "-jar", "user-service.jar"]
