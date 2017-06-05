cd RMIServer
mvn clean package
cd ../RMIClient
mvn clean package
docker-compose up --build