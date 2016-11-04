SOAP Payment Service

In order to build and run this project, please:

1. Checkout the project
2. Download a JavaEE7 application server that supports WebProfile (Code here was tested using Payara http://www.payara.fish/downloads)
3. Go to the Project folder and run: mvn clean install
4. Go to the AppServer folder and run it (For Payara): bin/asadmin start-domain domain1
5. Deploy de App (For Payara): bin/asadmin deploy $PATH_TO_APP/UJaveriana-AES-ModVal/Workshop1-SOAP-Service/target/Workshop1-SOAP-Service-1.0-SNAPSHOT.war 
6. Verify the application has been deployed (For Payara): bin/asadmin list-applications
7. Go to http://localhost:8080/Workshop1-SOAP-Service-1.0-SNAPSHOT/PagosServiceService?wsdl in your browser to see resulting the WSDL
8. Open the soapUI attached project
9. Run your tests!!! 

-----

The WSDL and XSD used in this project were generated with the "contract first" strategy in mind. If you want to generate your own artifacts from Java you can:

1. Go to the Project Forder
2. Run the following command: wsimport src/main/resources/co/edu/javeriana/aes/modval/pagos.wsdl -keep -Xnocompile -extension -p co.edu.javeriana.aes.modval.pagos.artifacts -d src/main/java/

That's gonna generate all the requeried artifacts that are referenced in the co.edu.javeriana.aes.modval.pagos.artifacts package
