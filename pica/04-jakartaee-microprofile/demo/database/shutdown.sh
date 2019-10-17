#!/bin/bash
docker stop catalogue-mariadb
docker rm catalogue-mariadb
docker rmi javeriana-aes-pica/catalogue-mariadb-img:1.0.0