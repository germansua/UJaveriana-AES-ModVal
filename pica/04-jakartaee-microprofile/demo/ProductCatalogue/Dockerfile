FROM maven:3.6.1-jdk-8 AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package

FROM payara/server-web:5.193.1

ENV MARIADB_HOST catalogue-mariadb
ENV LIBS ${PAYARA_DIR}/glassfish/domains/production/lib
ENV MARIADB_DRIVER mariadb-java-client-2.3.0.jar
ENV JDBC_CONNECTION_POOL_CMD "create-jdbc-connection-pool --datasourceclassname org.mariadb.jdbc.MariaDbDataSource --restype javax.sql.ConnectionPoolDataSource --property user=root:password=my-secret-pw:DatabaseName=PRODUCT_CATALOGUE:ServerName=${MARIADB_HOST}:port=3306 mariadb-pool"
ENV JDBC_RESOURCE_CMD "create-jdbc-resource --connectionpoolid mariadb-pool jdbc/mariadb-pool"

RUN wget --quiet https://bit.ly/2Or4ltp -O ${MARIADB_DRIVER} && mv ${MARIADB_DRIVER} ${LIBS}
RUN echo ${JDBC_CONNECTION_POOL_CMD} > ${POSTBOOT_COMMANDS} && \
    echo ${JDBC_RESOURCE_CMD} >> ${POSTBOOT_COMMANDS}

COPY --from=builder /build/target/ProductCatalogue.war ${DEPLOY_DIR}