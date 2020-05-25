#FROM openjdk:11.0.6-jdk-slim-buster AS shrink
#WORKDIR /app
#COPY target/product-catalogue-0.0.1-SNAPSHOT.jar .
#RUN jlink --no-header-files --no-man-pages \
#    --add-modules $(jdeps --print-module-deps product-catalogue-0.0.1-SNAPSHOT.jar),java.naming,java.desktop,java.management,java.security.jgss,java.instrument,java.sql \
#    --output jvm
#
#FROM debian:buster-slim AS runner
#WORKDIR /app
#COPY --from=shrink /app/product-catalogue-0.0.1-SNAPSHOT.jar product-catalogue.jar
#COPY --from=shrink /app/jvm ./jvm
#ENTRYPOINT ["jvm/bin/java", "-jar", "product-catalogue.jar"]
#EXPOSE 8080

FROM openjdk:11.0.6-jdk-slim-buster
WORKDIR /app
COPY target/product-catalogue-0.0.1-SNAPSHOT.jar product-catalogue.jar
ENTRYPOINT ["java", "-jar", "product-catalogue.jar"]
EXPOSE 8081