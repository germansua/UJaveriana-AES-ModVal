#!/bin/bash
docker build . -t javeriana-aes-patrones/layers-demo:1.0
docker run -d -p 8080:8080 --name monsters-service javeriana-aes-patrones/layers-demo:1.0