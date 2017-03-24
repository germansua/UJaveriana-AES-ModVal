FROM gersua/openjdk8-ubuntu:latest
MAINTAINER German Alonso Suarez Guerrero - gersua@gmail.com

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