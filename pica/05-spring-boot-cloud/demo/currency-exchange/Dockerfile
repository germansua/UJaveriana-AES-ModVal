FROM openjdk:11.0.6-jdk-slim-buster
COPY target/currency-exchange-0.0.1-SNAPSHOT.jar currency-exchange.jar
ENTRYPOINT ["java", "-jar", "currency-exchange.jar"]
EXPOSE 8082