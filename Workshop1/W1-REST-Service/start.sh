mvn clean package
docker build -t w1-rest-svr .
docker run -d -p 9090:8080 --name w1-rest-svr w1-rest-svr