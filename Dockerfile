FROM openjdk:21-slim

WORKDIR /app

COPY pom.xml ./
RUN mvn clean package -DskipTests

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]