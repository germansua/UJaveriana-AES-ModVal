#!/bin/bash
docker build . -t javeriana-aes-pica/spring-product-catalogue:1.0
docker run -d -p 8081:8081 --net product-catalogue-net --name product-catalogue javeriana-aes-pica/spring-product-catalogue:1.0