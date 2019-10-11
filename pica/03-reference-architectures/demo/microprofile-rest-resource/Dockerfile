FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package

FROM open-liberty:webProfile8-java8-openj9
LABEL maintainer='German Alonso Suarez Guerrero - german.suarez@javeriana.edu.com'
COPY --from=builder /build/target/microprofile-rest-resource.war /opt/ol/wlp/usr/servers/defaultServer/dropins