# Building stage
FROM maven:3.6.2-jdk-11-slim AS builder
WORKDIR /build
COPY pom.xml .
# RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package

# Shrinking JVM stage
FROM openjdk:11.0.5-jdk-slim-buster AS shrinking
WORKDIR /workspace
COPY --from=builder /build/target/resource-performance-test-quarkus-1.0-SNAPSHOT-runner.jar .
RUN jlink --no-header-files --no-man-pages --add-modules $(jdeps --print-module-deps resource-performance-test-quarkus-1.0-SNAPSHOT-runner.jar),jdk.unsupported --output jvm

# Running stage
FROM debian:stretch-slim
WORKDIR /app
COPY --from=builder /build/target/resource-performance-test-quarkus-1.0-SNAPSHOT-runner.jar .
COPY --from=shrinking /workspace/jvm ./jvm

EXPOSE 8080
USER 1001
ENTRYPOINT ["jvm/bin/java", "-jar", "resource-performance-test-quarkus-1.0-SNAPSHOT-runner.jar"]