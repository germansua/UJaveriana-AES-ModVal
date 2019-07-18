#!/bin/bash
docker build -t new-service-rest:1.0 .
docker run -d -p 9090:8080 --name new-service new-service-rest:1.0