FROM gersua/openjdk8-ubuntu:latest
MAINTAINER German Alonso Suárez Guerrero - gersua@gmail.com
ENV WORKSPACE /opt
ENV CLIENT_APP rmi-client.jar
WORKDIR ${WORKSPACE}
COPY target/${CLIENT_APP} .
ENTRYPOINT java -jar ${CLIENT_APP}