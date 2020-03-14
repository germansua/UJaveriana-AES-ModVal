# Building stage
FROM maven:3.6.2-jdk-11-slim AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package

# Shrinking JVM stage
FROM openjdk:11.0.5-jdk-slim-buster AS shrinking
WORKDIR /workspace
COPY --from=builder /build/target/currency-exchange.jar .
RUN jlink --no-header-files --no-man-pages --add-modules $(jdeps --print-module-deps currency-exchange.jar),java.naming,java.desktop,java.sql,java.security.jgss,java.instrument --output currency-exchange-jvm

# Running stage
FROM debian:stretch-slim
WORKDIR /currency-exchange
COPY --from=builder /build/target/currency-exchange.jar .
COPY --from=shrinking /workspace/currency-exchange-jvm ./jvm
ENTRYPOINT ["jvm/bin/java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "currency-exchange.jar"]