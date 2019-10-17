#!/bin/bash
docker build . -t catalogue-mariadb-img:1.0.0
docker run -d -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 --network product-catalogue-net -v $HOME/data/mariadb/cataloguedb:/var/lib/mysql --name catalogue-mariadb catalogue-mariadb-img:1.0.0