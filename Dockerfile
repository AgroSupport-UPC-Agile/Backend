FROM maven:3.9.6-eclipse-temurin-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:22-jdk
COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar agrosupport.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/agrosupport.jar"]