#!/bin/bash
docker build . -t javeriana-aes-patrones/client-server-demo:1.0
docker run -d -p 8080:8080 --name simple-http-server javeriana-aes-patrones/client-server-demo:1.0