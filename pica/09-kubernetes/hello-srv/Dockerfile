FROM maven:3.6.3-openjdk-11-slim AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY ./src ./src
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:11.0.8-jdk-slim-buster AS shrink
WORKDIR /app
COPY --from=builder /app/target/hello-srv-0.0.1-SNAPSHOT.jar hello-srv.jar
RUN jlink --no-header-files --no-man-pages --add-modules $(jdeps --print-module-deps hello-srv.jar),java.naming,java.desktop,java.management,java.security.jgss,java.instrument --output jvm

FROM debian:stretch-20200803-slim
WORKDIR /app
COPY --from=builder /app/target/hello-srv-0.0.1-SNAPSHOT.jar hello.jar
COPY --from=shrink /app/jvm ./jvm
ENTRYPOINT ["jvm/bin/java", "-jar", "hello.jar"]
USER 1001
EXPOSE 8080