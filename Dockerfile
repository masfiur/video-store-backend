# Use OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the Maven build output JAR (update the JAR name if needed)
COPY target/movieapi-0.0.1-SNAPSHOT.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8085

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
