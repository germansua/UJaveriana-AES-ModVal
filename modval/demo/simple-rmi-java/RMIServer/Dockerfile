FROM gersua/openjdk8-ubuntu:latest
MAINTAINER German Alonso Suárez Guerrero - gersua@gmail.com
ENV WORKSPACE /opt
ENV SERVER_APP rmi-server.jar
WORKDIR ${WORKSPACE}
COPY target/${SERVER_APP} .
ENTRYPOINT java -jar ${SERVER_APP}
EXPOSE 7875