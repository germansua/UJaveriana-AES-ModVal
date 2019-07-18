# Build Stage
FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /WaterService
COPY pom.xml .
COPY ./src ./src
RUN mvn clean package

# Run Stage
FROM openjdk:8u201-jdk-alpine3.9
LABEL maintainer="German Alonso Suarez Guerrero - german.suarez@javeriana.edu.co"
WORKDIR WORKSPACE /WaterService
COPY --from=builder /WaterService/target/water-service-thorntail.jar .
ENTRYPOINT java -Djava.net.preferIPv4Stack=true -jar water-service-thorntail.jar