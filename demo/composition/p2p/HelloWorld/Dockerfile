FROM gersua/openjdk8-ubuntu
MAINTAINER German Alonso Suárez Guerrero - gersua@gmail.com
ENV DIR HelloWorld
ENV JAR hello-world.jar
RUN mkdir ${DIR}
WORKDIR ${DIR}
COPY target/${JAR} .
ENTRYPOINT java -jar ${JAR}