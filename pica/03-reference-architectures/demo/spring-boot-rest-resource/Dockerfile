FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package

FROM openjdk:8u222-jdk-slim-buster
COPY --from=builder /build/target/spring-boot-rest-resource.jar .
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "spring-boot-rest-resource.jar"]