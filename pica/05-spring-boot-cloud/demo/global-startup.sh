#!/bin/bash

# Compiling all the projects in parallel
mvn clean package -T4 -Dmaven.test.skip=true

# Creates the required network
sh docker-network.sh

# Runs one by one every startup.sh script
cd database
sh startup.sh
cd ../zipkin
sh startup.sh
cd ../eureka-server
sh startup.sh
cd ../zuul-proxy
sh startup.sh
cd ../currency-exchange
sh startup.sh
cd ../product-catalogue
sh startup.sh
cd ..

# Shows that everything is running properly
docker ps