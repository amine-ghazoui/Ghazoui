FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
RUN apk add --no-cache curl
COPY target/*.jar app.jar
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "app.jar"]

# RUN apk add --no-cache curl : est fait toujour dans le Dockerfile de parent (ex : discovery, config, conference )