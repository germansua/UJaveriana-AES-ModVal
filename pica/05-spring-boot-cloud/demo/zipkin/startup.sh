#!/bin/bash
docker run --rm -d -p9411:9411 --network product-catalogue-net --name mp-opentracing openzipkin/zipkin:2