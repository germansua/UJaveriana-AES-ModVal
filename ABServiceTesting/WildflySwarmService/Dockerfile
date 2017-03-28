FROM gersua/openjdk8-ubuntu:latest
MAINTAINER German Alonso Suarez Guerrero - gersua@gmail.com
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/wildfly-service-swarm.jar .
ENTRYPOINT java -jar wildfly-service-swarm.jar