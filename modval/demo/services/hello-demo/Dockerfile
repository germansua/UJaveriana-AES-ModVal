FROM openjdk:11.0.6-jdk-slim-buster
WORKDIR /app
COPY target/hello-demo-1.0.0-SNAPSHOT-runner.jar .
COPY target/lib ./lib
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "hello-demo-1.0.0-SNAPSHOT-runner.jar"]