## _SOAP Payment Service a.k.a. Gas Natural Payment Service_

This service represents the functionality for one of the third party services for the workshop challenge.
The service has been updated to support new features like storing in a database the invoices and managing their states.
Moreover, all the infrastructure requirements have been updated as well, updating the docker images among other things.

#### _Feature updates_
- Invoices are now stored in a MariaDB database, which can keep the status of each one
- New business logic that supports a more realistic operations on the invoices  

#### _Infrastructure updates_
- Dockerfile updates for using official **Payara Full Server** images
- MariaDB as a Database Engine
- All docker images wrapped into a `docker-compose.yml` file
- `startup.sh` and `shutdown.sh` scripts for starting and ending the docker processes

#### _How to run the project_
Just go to your terminal and run `startup.sh`. That script will perform all the necessary steps to run the docker images.

Please bear in mind the requiriments describe below to run the project locally.

[**Docker multi-stage builds**](https://docs.docker.com/develop/develop-images/multistage-build/) will be supported soon.
 
  

#### _Important Things to Consider_
- In order to build the project locally, make sure JDK8 and Maven are installed and configured in the path.
- Both `pagos.wsdl` and `pagos.xml` schema are under the **_contract_** folder. These are the governance elements used to create the web service artifacts  
- The server generated WSLD base on above artifacts can be found at [**http://localhost:8080/gas-natural/PagosService?wsdl**](http://localhost:8080/gas-natural/PagosService?wsdl). This way the SOAP Web Service consumers can be created
- The application is running on top of [**Payara Full Server**](https://www.payara.fish/) Application Server  
- [**MariaDB**](https://mariadb.org/) is exposed externally for access at `localhost:3306`. User and password information can be find in the docker files. [**MySQLWorkbench**](https://www.mysql.com/products/workbench/) can be used for connecting and querying the data.
- The Database is full filled by a script at startup with about 10K records
- A [**soapUI**](https://www.soapui.org/downloads/soapui.html) project called `gas-natural-soapui-project.xml` has been added for testing pruposes  

-----
The WSDL and XSD used in this project were generated with the **_"contract first"_** strategy in mind. If you want to generate your own artifacts from Java you can:

1. Go to the Project Folder
2. Run the following command: `wsimport src/main/resources/co/edu/javeriana/aes/modval/pagos.wsdl -keep -Xnocompile -extension -p co.edu.javeriana.aes.modval.pagos.artifacts -d src/main/java/`

That's gonna generate all the requeried artifacts that are referenced in the `co.edu.javeriana.aes.modval.pagos.artifacts` package