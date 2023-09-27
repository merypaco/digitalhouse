FROM openjdk:8-jdk

COPY build/libs/digitalhouse-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 9000
entrypoint ["java","-jar","app.jar"]