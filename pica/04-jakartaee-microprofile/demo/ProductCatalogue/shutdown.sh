#!/bin/bash
docker stop product-catalogue
docker rm product-catalogue
docker rmi javeriana-aes-pica/product-catalogue-img:1.0.0