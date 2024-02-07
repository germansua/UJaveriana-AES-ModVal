# builds the project
FROM gradle:8.5-jdk17-alpine AS builder
WORKDIR /app
COPY ./app/src ./src
COPY ./app/build.gradle build.gradle
RUN gradle build

# custom jvm
FROM amazoncorretto:17.0.10-al2023 AS shirnk 
WORKDIR /app
RUN jlink --add-modules java.base --no-header-files --no-man-pages -v --output jvm

# final image
FROM debian:trixie-slim
WORKDIR app
COPY --from=builder /app/app/build/libs/app.jar .
COPY --from=shirnk /app/jvm ./jvm
ENTRYPOINT ["jvm/bin/java", "-jar", "app.jar"]