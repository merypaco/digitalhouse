# Digital House

## Requisitos Previos
Asegúrate de tener instaladas las siguientes herramientas antes de comenzar:

- [Java](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/install/)
- [Spring Boot](https://spring.io/projects/spring-boot)

## Ejecución
1. Clona el repositorio:

   ```shell
   git clone https://github.com/merypaco/digitalhouse.git

2. Ejecuta la aplicación Spring Boot desde tu IDE o mediante el siguiente comando:
  
   ```shell
   ./gradlew bootRun

3. Para ejecutar las pruebas, usa el siguiente comando:

   ```shell
   ./gradlew test

4. Puedes visualizar el Swagger en:

   ```shell   
   http://localhost:9000/api/v1/swagger-ui/index.html

## Docker
1. Descargar la imagen

    ```shell
    docker pull mirakel14/digital-house-test

2. Ejecutar con el siguiente comando:
    
   ```shell
    docker run -p 9000:9000 mirakel14/digital-house-test
