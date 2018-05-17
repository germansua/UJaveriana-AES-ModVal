FROM gersua/openjdk8-ubuntu:latest
MAINTAINER German Alonso Suarez Guerrero - gersua@gmail.com
ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/w1-rest-svr-swarm.jar .
ENTRYPOINT java -Djava.net.preferIPv4Stack=true -jar w1-rest-svr-swarm.jar