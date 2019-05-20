# Build Stage
FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /NewService
COPY pom.xml .
COPY ./src ./src
RUN mvn clean package

# Run Stage
FROM openjdk:8u201-jdk-alpine3.9
LABEL maintainer="German Alonso Suarez Guerrero - german.suarez@javeriana.edu.co"
WORKDIR WORKSPACE /NewService
COPY --from=builder /NewService/target/new-service-thorntail.jar .
ENTRYPOINT java -Djava.net.preferIPv4Stack=true -jar new-service-thorntail.jar