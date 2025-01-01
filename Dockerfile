# Use a base image with Java
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven build artifact (JAR file) into the container
COPY target/*.jar app.jar

# Expose the port that your Spring Boot application runs on (default: 8080)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
