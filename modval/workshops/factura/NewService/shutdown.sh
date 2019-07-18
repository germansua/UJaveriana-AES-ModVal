#!/bin/bash
docker stop new-service
docker rm new-service
docker rmi new-service-rest:1.0