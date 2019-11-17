#!/bin/bash
docker build -t pica/weather:1.0.0 .
docker run -d -p 9090:8080 --name weather-1 pica/weather:1.0.0