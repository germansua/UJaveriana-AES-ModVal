#!/bin/bash
docker stop currency-exchange-sbc-shrinking
docker rm currency-exchange-sbc-shrinking
docker rmi javeriana-aes-pica/currency-exchange-sbc-shrinking:1.0.0