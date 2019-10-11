#!/bin/bash
docker build . -t mp-rest-app-img:1.0.0
docker run -d -p 9080:9080 --name mp-rest-app-1 mp-rest-app-img:1.0.0