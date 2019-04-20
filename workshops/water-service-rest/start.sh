#!/bin/bash
docker build -t water-service-rest:1.0 .
docker run -d -p 9090:8080 --name water-service water-service-rest:1.0