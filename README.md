# B-Ball-Brain Platform: Backend Microservices

## Overview
The B-Ball-Brain platform is a cutting-edge solution for basketball coaches to analyze player matches and obtain statistics related to various schemas. This project focuses on the backend microservices architecture developed using Java Enterprise Edition (JEE) technologies along with DevOps practices.

## Features
- **Microservices Architecture**: Utilizing Spring Boot framework to implement microservices for improved scalability and maintainability.
- **RESTful API**: Designing and implementing RESTful APIs to facilitate communication between microservices and client applications.
- **Data Management**: Efficient management of player matches, statistics, and schemas data using PostgreSQL.
- **Containerization**: Employing Docker containers for packaging microservices, ensuring consistency across different environments.

## Getting Started
To run the backend microservices of the B-Ball-Brain platform locally, follow these steps:

1. **Clone the Repository**: 
   ```bash
   git clone https://github.com/Ahmed-YassineElm/B-Ball-Brain/tree/main
   ```
2. **Build Docker Images**:
   ```
   docker-compose build
   ```
3. **Run Docker Containers**:
     ```
     docker-compose up
     ```
**Note**: If you need to modify database credentials, ports, or other configurations for each microservice, please refer to the application.properties file in the respective microservice's directory.
