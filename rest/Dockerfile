# Use a base image with Java 17 support
FROM openjdk:17

# Create a directory in the container
RUN mkdir /zoostoreapp

# Set the working directory inside the container
WORKDIR /zoostoreapp

# Copy the .jar file from the local directory to the container
COPY target/tinqin-zoostore.jar /zoostoreapp/

# Command to run when the container starts
CMD ["java", "-jar", "/zoostoreapp/tinqin-zoostore.jar"]

# Expose port 8080 (optional, only if your application uses this port)
EXPOSE 8080