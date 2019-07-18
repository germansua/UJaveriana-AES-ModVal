# Build Stage
FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /GasService
COPY pom.xml .
COPY ./src ./src
RUN mvn clean package

# Run Stage
FROM payara/server-full:5.183
LABEL maintainer="German Alonso Suarez Guerrero - german.suarez@javeriana.edu.co"

ENV MARIADB_HOST domiciliaciondb
ENV LIBS /opt/payara5/glassfish/domains/domain1/lib
ENV MARIADB_DRIVER mariadb-java-client-2.3.0.jar
ENV JDBC_CONNECTION_POOL_CMD "create-jdbc-connection-pool --datasourceclassname org.mariadb.jdbc.MariaDbDataSource --restype javax.sql.ConnectionPoolDataSource --property user=root:password=my-secret-pw:DatabaseName=Domiciliacion:ServerName=${MARIADB_HOST}:port=3306 mariadb-pool"
ENV JDBC_RESOURCE_CMD "create-jdbc-resource --connectionpoolid mariadb-pool jdbc/mariadb-pool"

RUN wget --quiet https://bit.ly/2Or4ltp -O ${MARIADB_DRIVER} && mv ${MARIADB_DRIVER} ${LIBS}
RUN echo ${JDBC_CONNECTION_POOL_CMD} > ${POSTBOOT_COMMANDS} && \ 
    echo ${JDBC_RESOURCE_CMD} >> ${POSTBOOT_COMMANDS}

COPY --from=builder /GasService/target/gas-service.war ${DEPLOY_DIR}

ENTRYPOINT  ${PAYARA_PATH}/generate_deploy_commands.sh && \
            ${PAYARA_PATH}/bin/startInForeground.sh \
            --passwordfile=/opt/pwdfile \
            --postbootcommandfile ${POSTBOOT_COMMANDS} ${PAYARA_DOMAIN}