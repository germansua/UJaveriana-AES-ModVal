#!/bin/bash
docker build . -t javeriana-aes-pica/catalogue-mariadb-img:1.0.0
docker run -d -e MYSQL_ROOT_PASSWORD=my-secret-pw -p 3306:3306 --network product-catalogue-net -v $HOME/data/mariadb/cataloguedb:/var/lib/mysql --name catalogue-mariadb javeriana-aes-pica/catalogue-mariadb-img:1.0.0