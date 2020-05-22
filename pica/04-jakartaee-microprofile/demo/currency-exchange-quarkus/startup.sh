#!/bin/bash
docker build . -t javeriana-aes-pica/currency-exchange-quarkus:1.0.0
docker run -d --network product-catalogue-net -p 9090:8080 --name currency-exchange-quarkus javeriana-aes-pica/currency-exchange-quarkus:1.0.0