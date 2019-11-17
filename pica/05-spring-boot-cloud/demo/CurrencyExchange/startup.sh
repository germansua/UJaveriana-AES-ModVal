#!/bin/bash
docker build . -t javeriana-aes-pica/currency-exchange-sbc:1.0.0
docker run -d --network product-catalogue-net -p 9070:8080 --name currency-exchange-sbc javeriana-aes-pica/currency-exchange-sbc:1.0.0