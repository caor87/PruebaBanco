# Multi Stage build

# Base Image and name stage as "builder"
FROM maven:3-openjdk-11 AS builder

# Create App Directory inside our container
WORKDIR /carlos/app/src/

# Copy files
COPY src ./
COPY pom.xml ../

RUN mvn -f /carlos/app/pom.xml clean package

#### 2nd Stage ####

FROM openjdk:11.0.3

WORKDIR /carlos/lib/

# Copy the Jar from the first Stage (builder) to the 2nd stage working directory
COPY --from=builder /carlos/app/target/employes-docker-0.0.1-SNAPSHOT.jar ./sb-dockerized.jar

# Expose the port to the inner container communication network
EXPOSE 3100

# Run the Java Application
ENTRYPOINT [ "java","-jar","/carlos/lib/sb-dockerized.jar"]

