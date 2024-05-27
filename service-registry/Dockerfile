# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Eureka Server JAR file into the container
COPY target/*.jar /app/eureka-server.jar

# Expose the port that the Eureka Server will run on
EXPOSE 8761

# Specify the command to run the Eureka Server when the container starts
ENTRYPOINT ["java", "-jar", "/app/eureka-server.jar"]
