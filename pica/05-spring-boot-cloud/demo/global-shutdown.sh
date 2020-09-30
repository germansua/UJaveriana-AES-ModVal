#!/bin/bash
sh database/shutdown.sh
sh zipkin/shutdown.sh
sh eureka-server/shutdown.sh
sh zuul-proxy/shutdown.sh
sh currency-exchange/shutdown.sh
sh product-catalogue/shutdown.sh
docker network rm product-catalogue-net