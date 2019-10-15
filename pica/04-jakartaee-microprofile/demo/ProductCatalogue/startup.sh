#!/bin/bash
docker build . -t product-catalogue-img:1.0.0
docker run -d -p 8080:8080 -p 4848:4848 --name product-catalogue product-catalogue-img:1.0.0