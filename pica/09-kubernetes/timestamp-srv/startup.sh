#!/bin/bash
docker build . -t javeriana-aes-pica/kubernetes-timestamp:1.0
# docker run --name delete-me -p:8080:8080 javeriana-aes-pica/kubernetes-timestamp:1.0
kubectl create -f kubernetes/timestamp-deployment.yml
kubectl create -f kubernetes/timestamp-service.yml