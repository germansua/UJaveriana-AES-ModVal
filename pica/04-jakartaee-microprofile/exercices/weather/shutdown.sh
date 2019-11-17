#!/bin/bash
docker stop weather-1
docker rm weather-1
docker rmi pica/weather:1.0.0