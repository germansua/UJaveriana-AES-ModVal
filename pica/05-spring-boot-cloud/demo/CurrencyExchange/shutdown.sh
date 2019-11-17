#!/bin/bash
docker stop currency-exchange-sbc
docker rm currency-exchange-sbc
docker rmi javeriana-aes-pica/currency-exchange-sbc:1.0.0