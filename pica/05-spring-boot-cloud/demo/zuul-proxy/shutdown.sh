#!/bin/bash
docker stop zuul-proxy-gw
docker rm zuul-proxy-gw
docker rmi javeriana-aes-pica/spring-zuul-proxy-gw:1.0
