#!/bin/bash
./mvnw clean package
java -Xms100m -Xmx100m -jar target/resource-performance-test-sb-0.0.1-SNAPSHOT.jar

echo "Starting test 1 ..."
wrk -t10 -c100 -d30s http://localhost:8080

echo "Starting test 2 ..."
wrk -t10 -c100 -d30s http://localhost:8080

echo "Starting test 3 ..."
wrk -t10 -c100 -d30s http://localhost:8080