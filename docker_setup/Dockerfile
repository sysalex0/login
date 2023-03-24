# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim AS build

# Set the working directory to /app
WORKDIR /app

# Copy the .mvn directory to the container at /app
COPY .mvn /app/.mvn

# Copy the mvnw file to the container at /app
COPY mvnw /app

# Copy the pom.xml file to the container at /app
COPY pom.xml /app

# Download and cache the Maven dependencies
RUN ./mvnw dependency:go-offline -B

# Copy the src files to the container at /app
COPY src /app/src

# Build the Spring Boot application
RUN ./mvnw clean package

# Use a smaller base image for runtime
FROM openjdk:17-jdk-alpine

# Set the working directory to /app
WORKDIR /app

# Copy the JAR file from the build container to the runtime container
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Define the command to run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]