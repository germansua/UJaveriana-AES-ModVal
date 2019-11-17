FROM openjdk:11.0.5-jdk-slim-buster
COPY target/weather-thorntail.jar .
ENTRYPOINT java -Djava.net.preferIPv4Stack=true -jar weather-thorntail.jar