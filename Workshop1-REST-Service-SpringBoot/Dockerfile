FROM gersua/openjdk8-ubuntu:latest
MAINTAINER German Alonso Suarez Guerrero - gersua@gmail.com
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/w1-rest-service-sb.jar .
ENTRYPOINT java -jar w1-rest-service-sb.jar