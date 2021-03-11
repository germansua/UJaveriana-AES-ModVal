#!/bin/bash

# Compiling all the projects in parallel
# mvn clean package -T4 -Dmaven.test.skip=true

# Creates the required network
source docker-network.sh

# Runs one by one every startup.sh script
cd database
sh startup.sh

cd ../jaeger
sh startup.sh

cd ../prometheus
sh startup.sh

cd ../grafana
sh startup.sh

cd ../currency-exchange-quarkus
sh startup.sh

cd ../product-catalogue-quarkus
sh startup.sh