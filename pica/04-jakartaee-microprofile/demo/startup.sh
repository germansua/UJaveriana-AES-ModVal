#!/bin/bash
cd database
sh startup.sh
cd ../jaeger
sh startup.sh
cd ../prometheus
sh startup.sh
cd ../currency-exchange-quarkus
sh startup.sh
cd ../product-catalogue-quarkus
sh startup.sh