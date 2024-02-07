#!/bin/bash
docker stop simple-http-server
docker rm simple-http-server
docker rmi javeriana-aes-patrones/client-server-demo:1.0