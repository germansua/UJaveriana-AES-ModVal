#!/bin/bash
docker build . -t javeriana-aes-pica/product-catalogue-quarkus-img:1.0.0
docker run -d -e CURRENCY_EXCHANGE_URL='currency-exchange-quarkus' \
 -e CURRENCY_EXCHANGE_HOSTNAME=currency-exchange-quarkus \
 -e CURRENCY_EXCHANGE_PORT=8080 \
 --network product-catalogue-net -p 8080:8080 \
 --name product-catalogue-quarkus javeriana-aes-pica/product-catalogue-quarkus-img:1.0.0