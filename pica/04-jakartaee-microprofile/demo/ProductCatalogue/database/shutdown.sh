#!/bin/bash
docker stop catalogue-mariadb
docker rm catalogue-mariadb
docker rmi catalogue-mariadb-img:1.0.0