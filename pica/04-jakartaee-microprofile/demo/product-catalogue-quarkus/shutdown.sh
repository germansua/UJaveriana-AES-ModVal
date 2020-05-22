#!/bin/bash
docker stop product-catalogue-quarkus
docker rm product-catalogue-quarkus
docker rmi javeriana-aes-pica/product-catalogue-quarkus-img:1.0.0