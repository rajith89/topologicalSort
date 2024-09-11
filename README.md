# Spring Boot 3 Project to demonstrate Topological Sorting

## Overview

This is a simple Spring Boot 3 project designed to demonstrate Topological Sorting.

## Features

-Topological sorting to find an order of nodes (scripts). This application will return the exection plan for the scripts.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or later
- [Maven 3.8.4](https://maven.apache.org/download.cgi) or later (if not using Gradle)
- [Git](https://git-scm.com/) (optional, for version control)

## Getting Started

To get a local copy of the project up and running, follow these steps:

### 1. Clone the Repository

```bash
git clone https://github.com/rajith89/topologicalSort.git
cd topologicalSort

### 2. Build the project using maven

mvn clean install

### 3. Run the Application

You can run the application using the command below:

mvn spring-boot:run

Alternatively, you can run the JAR file created in the target or build/libs directory:

java -jar target/topologicalsort-0.0.1-SNAPSHOT.jar

### 4. Running Tests

mvn test

