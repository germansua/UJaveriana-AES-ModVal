cd W1-REST-Service
mvn clean package
cd ../W1-SOAP-Service
mvn clean package
docker-compose up -d --build