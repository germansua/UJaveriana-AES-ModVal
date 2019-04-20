#!/bin/bash
mvn clean package
cp target/etb-mobile.war Payara
docker-compose up --build
rm Payara/etb-mobile.war