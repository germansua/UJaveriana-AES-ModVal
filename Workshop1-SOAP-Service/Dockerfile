FROM ubuntu:16.10
MAINTAINER gersua@gmail.com

# Update repositories
RUN apt-get update -y && apt-get upgrade -y
# Install OpenJDK8
RUN apt-get install openjdk-8-jdk -y && apt-get install curl -y && apt-get install unzip

ENV PAYARA_HOME /opt/payara41/glassfish
ENV PAYARA_BIN ${PAYARA_HOME}/bin

WORKDIR /opt
RUN mkdir to_depoy

RUN curl -o payara.zip -L http://bit.ly/2nDuLPc
RUN unzip payara.zip

ENTRYPOINT  ${PAYARA_BIN}/asadmin start-domian domain1 && \
            ${PAYARA_BIN}/asadmin depoy /opt/to_deploy && \
            tail -f ${PAYARA_HOME}/domains/domain1/logs/server.log

EXPOSE 8080 4848