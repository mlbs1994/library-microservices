FROM openjdk:17-jdk-slim

WORKDIR /app

# Copia o .jar da pasta target para o diretório /app
COPY ./target/books-api.jar /app/books-api.jar

EXPOSE 8080

# Comando para executar o .jar
CMD ["java", "-jar", "/app/books-api.jar"]