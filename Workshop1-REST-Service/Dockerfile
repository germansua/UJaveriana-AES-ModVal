FROM ubuntu:16.10
MAINTAINER gersua@gmail.com

# Update repositories
RUN apt-get update -y && apt-get upgrade -y
# Install OpenJDK8 and other utilities
RUN apt-get install openjdk-8-jdk -y && \
    apt-get install curl -y && \
    apt-get install unzip

ENV WORKSPACE /opt
WORKDIR ${WORKSPACE}
COPY target/workshop1-rest-service-swarm.jar .

ENTRYPOINT java -jar workshop1-rest-service-swarm.jar