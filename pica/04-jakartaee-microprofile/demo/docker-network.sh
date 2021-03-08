#!/bin/bash
docker network create -d bridge product-catalogue-net
docker network inspect product-catalogue-net