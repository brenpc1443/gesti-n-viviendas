# Etapa 1: Construcción de la aplicación
FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y

# Copiar el código fuente al contenedor
COPY . .

# Compilar la aplicación usando Gradle
RUN ./gradlew bootJar --no-daemon

# Etapa 2: Crear la imagen de ejecución
FROM openjdk:21-jdk-slim
EXPOSE 8080

# Copiar el archivo JAR de la etapa de compilación
COPY --from=build /build/libs/*.jar app.jar

# Definir el punto de entrada para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
