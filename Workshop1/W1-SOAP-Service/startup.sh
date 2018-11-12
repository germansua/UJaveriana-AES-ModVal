#!/bin/bash
mvn clean package
cp target/gas-natural.war Payara/
docker-compose up --build -d
rm Payara/gas-natural.war