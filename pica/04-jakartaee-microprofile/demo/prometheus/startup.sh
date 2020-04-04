#!/bin/bash
docker run --rm -d -p9393:9090 --network product-catalogue-net --name mp-prometheus -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus:v2.14.0