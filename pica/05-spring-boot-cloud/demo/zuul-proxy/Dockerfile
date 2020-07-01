FROM openjdk:11.0.6-jdk-slim-buster
WORKDIR /app
COPY target/zuul-proxy-0.0.1-SNAPSHOT.jar zuul-proxy.jar
ENTRYPOINT ["java", "-jar", "zuul-proxy.jar"]
EXPOSE 8765