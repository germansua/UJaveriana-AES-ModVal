#!/bin/bash
docker build . -t javeriana-aes-pica/spring-zuul-proxy-gw:1.0
docker run -d -p 8765:8765 --net product-catalogue-net --name zuul-proxy-gw javeriana-aes-pica/spring-zuul-proxy-gw:1.0