#!/bin/bash
docker run --rm -d -p9411:9411 --network product-catalogue-net --name spring-opentracing openzipkin/zipkin:2