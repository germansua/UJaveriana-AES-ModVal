mvn clean package && docker build -t helloworld . && docker run -d --net service-compose -p 8080:8080 --name helloworld helloworld
