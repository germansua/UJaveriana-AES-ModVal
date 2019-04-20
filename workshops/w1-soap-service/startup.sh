#!/bin/bash
mvn clean package -Dmaven.test.skip=true
cp target/gas-natural.war Payara/
docker-compose up --build -d
rm Payara/gas-natural.war