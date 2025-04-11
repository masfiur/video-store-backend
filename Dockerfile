# Stage 1: Use Maven to build the app
FROM maven:3.9.4-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy pom.xml and source files
COPY pom.xml .
COPY src ./src

# Build the app (skip tests to speed up)
RUN mvn clean install -DskipTests

# Stage 2: Use JDK to run the built JAR
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR from the build stage
COPY --from=builder /app/target/*.jar app.jar

# Expose Spring Boot's default port
EXPOSE 8085

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
