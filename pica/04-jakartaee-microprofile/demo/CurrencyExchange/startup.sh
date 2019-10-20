#!/bin/bash
docker build . -t javeriana-aes-pica/currency-exchange:1.0.0
docker run -d --network product-catalogue-net -p 8090:8080 -p 4858:9990 --name currency-exchange javeriana-aes-pica/currency-exchange:1.0.0