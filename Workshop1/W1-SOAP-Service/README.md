###_SOAP Payment Service a.k.a. Gas Natural Payment Service_

This service represents the functionality for one of the third party services for the workshop challenge.
The service has been updated to support new features like storing in a database the invoices and manage their states.
Moreover, all the infrastructure requirements have been updated as well, updating the docker images among other things.

#####_Feature updates_
- Invoices are now stored in a MariaDB database, which can keep the status of each one
- New business logic that supports a more realistic operations on the invoices  

#####_Infrastructure updates_
- Dockerfile updates for using official **Payara Server** images
- MariaDB as a Database

#####_How to run the project_

-----

###SOAP Payment Service (Legacy Doc)

In order to build and run this project, please:

1. Checkout the project
2. Download a JavaEE7 application server that supports WebProfile. Code here was tested using [Payara Server](http://www.payara.fish/downloads)
3. Go to the Project folder and run: `mvn clean install`
4. Go to the AppServer folder and run it (For Payara): `bin/asadmin start-domain domain1`
5. Deploy de App (For Payara): `bin/asadmin deploy $PATH_TO_APP/UJaveriana-AES-ModVal/Workshop1-SOAP-Service/target/Workshop1-SOAP-Service-1.0-SNAPSHOT.war` 
6. Verify the application has been deployed (For Payara): `bin/asadmin list-applications`
7. Go to the [WSDL Contract](http://localhost:8080/Workshop1-SOAP-Service-1.0-SNAPSHOT/PagosServiceService?wsdl) in your browser to see resulting the WSDL
8. Open the soapUI attached project
9. Run your tests!!! 

The WSDL and XSD used in this project were generated with the **_"contract first"_** strategy in mind. If you want to generate your own artifacts from Java you can:

1. Go to the Project Folder
2. Run the following command: `wsimport src/main/resources/co/edu/javeriana/aes/modval/pagos.wsdl -keep -Xnocompile -extension -p co.edu.javeriana.aes.modval.pagos.artifacts -d src/main/java/`

That's gonna generate all the requeried artifacts that are referenced in the `co.edu.javeriana.aes.modval.pagos.artifacts` package