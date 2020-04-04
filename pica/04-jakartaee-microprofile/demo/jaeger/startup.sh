#!/bin/bash
docker run -d --rm -p 6831:6831/udp -p 16686:16686 --network product-catalogue-net --name mp-jaeger jaegertracing/all-in-one:1.17.1 