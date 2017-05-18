mvn clean package
docker build -t w1-soap-svr .
docker run -d -p 7070:8080 --name w1-soap-svr w1-soap-svr