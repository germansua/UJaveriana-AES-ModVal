#!/bin/bash
docker build . -t javeriana-aes-pica/spring-currency-exchange:1.0
docker run -d -p 8082:8082 --net product-catalogue-net --name currency-exchange-01 javeriana-aes-pica/spring-currency-exchange:1.0
docker run -d -p 8182:8082 --net product-catalogue-net --name currency-exchange-02 javeriana-aes-pica/spring-currency-exchange:1.0