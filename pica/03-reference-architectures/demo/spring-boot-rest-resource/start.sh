#!/bin/bash
docker build . -t sb-rest-app-img:1.0.0
docker run -d -p 8080:8080 --name sb-rest-app-1 sb-rest-app-img:1.0.0