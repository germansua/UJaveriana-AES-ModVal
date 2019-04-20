# Building stage
#FROM maven:3.5.3-jdk-8 as builder
#COPY src /usr/src/etb-mobile
#COPY pom.xml /usr/src/etb-mobile
#RUN mvn -f /usr/src/etb-mobile/pom.xml clean package

# Deployment stage
FROM payara/server-web:5.183
COPY target/etb-mobile.war ${DEPLOY_DIR}
#COPY --from=builder /usr/src/etb-mobile/target/etb-mobile.war ${DEPLOY_DIR}