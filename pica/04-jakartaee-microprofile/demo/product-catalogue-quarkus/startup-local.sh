#!/bin/bash
export CURRENCY_EXCHANGE_URL='currency-exchange'
export CURRENCY_EXCHANGE_HOSTNAME=currency-exchange
export CURRENCY_EXCHANGE_PORT=8080
mvn clean package -Dmaven.test.skip=true
