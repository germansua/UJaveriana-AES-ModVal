FROM maven:3.6.3-openjdk-11-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY ./src ./src
RUN mvn clean package -Dmaven.test.skip=true

# $(jdeps --print-module-deps timestamp-srv-1.0.0-SNAPSHOT-runner.jar)
# jlink --no-header-files --no-man-pages --add-modules $(jdeps --print-module-deps timestamp-srv-1.0.0-SNAPSHOT-runner.jar) --output jvm
FROM openjdk:11.0.8-jdk-slim-buster AS shrink
WORKDIR /app
RUN jlink --no-header-files --no-man-pages --add-modules java.base,java.compiler,java.desktop,java.logging,java.management,java.naming,java.rmi,java.transaction.xa,jdk.unsupported --output jvm

FROM debian:stretch-20200803-slim
WORKDIR /app
# COPY --from=builder /app/target/lib ./lib
COPY --from=builder /app/target/timestamp-srv-1.0.0-SNAPSHOT-runner.jar timestamp.jar
COPY --from=shrink /app/jvm ./jvm
ENTRYPOINT ["jvm/bin/java", "-jar", "timestamp.jar"]
USER 1001
EXPOSE 8080