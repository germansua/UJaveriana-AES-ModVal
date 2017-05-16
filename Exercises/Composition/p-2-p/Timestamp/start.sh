mvn clean install && docker build -t timestamp . && docker run -d --net service-compose -p 9090:8080 --name timestamp timestamp
