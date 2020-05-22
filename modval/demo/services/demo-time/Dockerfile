FROM openjdk:11.0.6-jdk-slim-buster
WORKDIR /app
COPY target/demo-time-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo-time-0.0.1-SNAPSHOT.jar"]