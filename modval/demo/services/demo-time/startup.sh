#!/bin/bash
docker build . -t javeriana-aes-modval/demo-time:1.0
docker run -d -p 8990:8080 --name demo-time-01 --net javeiana-aes-modval-net javeriana-aes-modval/demo-time:1.0

