#!/bin/bash
docker stop mp-rest-app-1
docker rm mp-rest-app-1
docker rmi mp-rest-app-img:1.0.0