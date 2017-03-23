FROM ubuntu:16.10
MAINTAINER gersua@gmail.com

# Update repositories
RUN apt-get update -y && apt-get upgrade -y
# Install OpenJDK8 and other utilities
RUN apt-get install openjdk-8-jdk -y && \
    apt-get install curl -y && \
    apt-get install unzip

ENV WORKSPACE /opt
ENV PAYARA_HOME ${WORKSPACE}/payara41/glassfish
ENV PAYARA_BIN ${PAYARA_HOME}/bin

WORKDIR ${WORKSPACE}

RUN curl -o payara.zip -L http://bit.ly/2nDuLPc
RUN unzip payara.zip
COPY target/worshop1-soap-service.war .

ENTRYPOINT  ${PAYARA_BIN}/asadmin start-domain domain1 && \
            ${PAYARA_BIN}/asadmin deploy ${WORKSPACE}/worshop1-soap-service.war && \
            tail -f ${PAYARA_HOME}/domains/domain1/logs/server.log

EXPOSE 8080 4848