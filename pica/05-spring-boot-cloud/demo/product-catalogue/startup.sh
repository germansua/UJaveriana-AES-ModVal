#!/bin/bash
docker build . -t javeriana-aes-modval/spring-product-catalogue:1.0
docker run -d -p 8181:8080 --net product-catalogue-net --name spring-product-catalogue javeriana-aes-modval/spring-product-catalogue:1.0