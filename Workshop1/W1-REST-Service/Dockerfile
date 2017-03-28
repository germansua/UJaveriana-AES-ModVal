FROM gersua/openjdk8-ubuntu:latest
MAINTAINER German Alonso Suarez Guerrero - gersua@gmail.com
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/workshop1-rest-service-swarm.jar .
ENTRYPOINT java -jar workshop1-rest-service-swarm.jar