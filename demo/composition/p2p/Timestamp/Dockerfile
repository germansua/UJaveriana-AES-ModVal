FROM gersua/openjdk8-ubuntu
MAINTAINER German Alonso Suárez Guerrero - gersua@gmail.com
ENV DIR TimestampService
ENV JAR timestamp-swarm.jar
RUN mkdir ${DIR}
WORKDIR ${DIR}
COPY target/${JAR} .
ENTRYPOINT java -jar ${JAR}