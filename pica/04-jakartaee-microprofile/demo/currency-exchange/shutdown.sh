#!/bin/bash
docker stop currency-exchange
docker rm currency-exchange
docker rmi javeriana-aes-pica/currency-exchange:1.0.0