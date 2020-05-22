#!/bin/bash
docker build . -t javeriana-aes-modval/demo-hello:1.0
docker run -d -p 9080:8080 --name demo-hello-01 --net javeiana-aes-modval-net  javeriana-aes-modval/demo-hello:1.0