FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean package

FROM payara/server-web:5.193.1
COPY --from=builder /build/target/ProductCatalogue.war ${DEPLOY_DIR}