#!/bin/bash
docker stop water-service
docker rm water-service
docker rmi water-service-rest:1.0