# Use a imagem base do OpenJDK
FROM openjdk:11-jre-slim

# Copie o arquivo JAR da sua aplicação para o contêiner
COPY target/kaizen-0.0.1-SNAPSHOT.jar /app.jar

# Defina a porta em que a aplicação irá escutar
EXPOSE 8080

# Comando para iniciar a aplicação quando o contêiner for executado
CMD ["java", "-jar", "/app.jar"]
