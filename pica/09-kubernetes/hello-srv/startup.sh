#!/bin/bash
docker build . -t javeriana-aes-pica/kubernetes-hello:1.0
kubectl create -f kubernetes/hello-deployment.yml
kubectl create -f kubernetes/hello-service.yml