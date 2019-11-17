#!/bin/bash
docker build . -t javeriana-aes-pica/currency-exchange-sbc-shrinking:1.0.0
docker run -d --network product-catalogue-net -p 8070:8080 --name currency-exchange-sbc-shrinking javeriana-aes-pica/currency-exchange-sbc-shrinking:1.0.0