#!/bin/bash
docker build . -t catalogue-mariadb-img:1.0.0
docker run -d -p 3306:3306 --name catalogue-mariadb catalogue-mariadb-img:1.0.0 -v $HOME/data/mariadb/cataloguedb:/var/lib/mysql