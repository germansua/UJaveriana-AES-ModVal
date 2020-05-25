#!/bin/bash
docker build . -t javeriana-aes-pica/spring-eureka-server:1.0
docker run -d -p 8761:8761 --name eureka-server --net product-catalogue-net javeriana-aes-pica/spring-eureka-server:1.0