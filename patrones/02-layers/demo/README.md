# Aplicación demo para mostrar la utilización del patrón layers y el estilo de arquitectura n-tiers
Esta aplicación está escrita en Spring Boot, utilizando Java 17 y gradle 8.5.
La intención del proyecto es mostrar como se puede estructura una aplicaicón basado en capas lógicas (layers).
La aplicaicón utuliza para la persistencia de datos SQLite, una biblioteca que se embebe para realizar operaciones de bases de datos sobre un archivo simple.

### Estructura del proyecto
El enfoque es closed-layers a excepción de la capa de entity, que por definición es abierta.
El paquete/namespace principal es `co.edu.javeriana.aes.patrones` del cual se observan las siguientes capas:
- *controller:* Representa el resurso REST en el cual se exponen la funcionalidad del servicio al mundo exterior
- *service:* Representa la lógica y funciones principales de dominio
- *entity:* Representa las entidades de dominio y de persistecia de datos
- *repository:* Representa el objeto que permite realizar operación de persistencia de datos, en este caso hacia SQLite

### Dependencias para ejecución desde el código
- Java 17
- Gradle 8.5

### Cómo ejecucutarlo desde el código
Se deben ejecutar el siguientes comandos:
- Compilar y build: `gradle build`
- Ejecutar: `java -jar monsters-0.0.1.jar`
- Detener: `ctr + c`
- Limpiar la base de datos: `rm monsters.db`

### Dependencias para ejecución desde contenerdores
- Docker o Podman

### Cómo ejecucutarlo desde el código
- Ejecutar: `sh startup.sh`
- Detener: `sh teardown.sh`