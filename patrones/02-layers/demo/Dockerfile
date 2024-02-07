# docker pull gradle:8.5-jdk17-alpine
FROM gradle:8.5-jdk17-alpine AS builder
WORKDIR /app
COPY ./src ./src
COPY build.gradle build.gradle
RUN gradle build

# docker pull amazoncorretto:17.0.10-al2023
FROM amazoncorretto:17.0.10-al2023 AS shirnk 
WORKDIR /app
RUN jlink --add-modules java.base,java.desktop,java.logging,java.management,java.naming,java.security.jgss,java.instrument,java.sql --no-header-files --no-man-pages -v --output jvm

# docker pull debian:trixie-slim
FROM debian:trixie-slim
WORKDIR app
COPY --from=builder /app/monsters-0.0.1.jar .
COPY --from=shirnk /app/jvm ./jvm
RUN jvm/bin/java -jar monsters-0.0.1.jar
