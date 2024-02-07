#!/bin/bash
docker stop monsters-service
docker rm monsters-service
docker rmi javeriana-aes-patrones/layers-demo:1.0