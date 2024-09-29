# Etapa 1: Construcción
FROM gradle:latest AS build

WORKDIR /app

# Copia los archivos necesarios
COPY . .

# Asegúrate de que gradlew tiene permisos de ejecución
RUN chmod +x gradlew

# Compila la aplicación usando Gradle
RUN ./gradlew bootJar --no-daemon

# Etapa 2: Crear la imagen de ejecución
FROM openjdk:21-slim

WORKDIR /app

# Copia el JAR construido
COPY --from=build /app/build/libs/*.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
