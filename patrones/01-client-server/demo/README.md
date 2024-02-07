# Aplicación demo para mostrar la utilización del patrón client-server
Esta aplicación está escrita en Spring Boot, utilizando Java 17 y gradle 8.5.
La intención del proyecto es mostrar como se puede se puede implementar un servidor HTTP sencillo que siempre retorna la misma respuesta `it works!`

### Estructura del proyecto
- Main: Clase principal que ejecuta el programa
- SimpleHttpServer: Representa el servidor, crear un server socket para aceptar conexiones y hace submit de una nueva tarea que la procesa en su propio thread de ejecución haciendo uso de un Thread Pool Executor
- RequestHandler: Representa la tarea que se hace cargo de manejar la comunicación con el cliente y dar la respuetsa al request

### Dependencias para ejecución desde el código
- Java 17
- Gradle 8.5

### Cómo ejecucutarlo desde el código
Se deben ejecutar el siguientes comandos:
- Compilar y build: `gradle build`
- Ejecutar: `java -jar app/build/libs/app.jar`
- Detener: `ctr + c`

### Dependencias para ejecución desde contenedores
- Docker o Podman

### Cómo ejecucutarlo desde contenedores
- Ejecutar: `sh startup.sh`
- Detener: `sh teardown.sh`