mvn clean package
docker build -t echo-rmi-java-server .
docker run -d -p 7875:7875 --name echo-rmi-java-server echo-rmi-java-server