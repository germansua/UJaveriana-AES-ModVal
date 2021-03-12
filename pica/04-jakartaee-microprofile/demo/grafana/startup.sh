#!/bin/bash
docker run -d --rm --name=mp-grafana -p 3000:3000 --network product-catalogue-net grafana/grafana:master-ubuntu