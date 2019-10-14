#!/bin/bash
docker stop sb-rest-app-1
docker rm sb-rest-app-1
docker rmi sb-rest-app-img:1.0.0