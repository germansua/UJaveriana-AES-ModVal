#!/bin/bash

docker stop product-catalogue-quarkus
docker rm product-catalogue-quarkus

docker stop currency-exchange-quarkus
docker rm currency-exchange-quarkus

docker stop mp-jaeger

docker stop mp-prometheus

docker stop catalogue-mariadb
docker rm catalogue-mariadb