# Prometheus and Grafana Monitoring Service

## Project Overview
This project implements a monitoring solution for a Spring Boot application using Prometheus and Grafana. The service tracks application performance and provides real-time metrics using Micrometer. This system helps in monitoring critical business operations and understanding the application's health and performance.

## Key Features
- **Prometheus Integration**: The application uses Micrometer to collect metrics, which are then exposed to Prometheus for monitoring.
- **Grafana Dashboards**: Metrics collected by Prometheus are visualized using Grafana dashboards for better insights into system health.
- **Metrics Types**: Includes counters and timers for tracking the number of requests and their execution times.

## Project Structure
- **config/MonitoringConfig.java**
  - Contains the Spring configuration for Prometheus monitoring.
  - Defines beans for `CountedAspect` and `TimedAspect` to collect metrics such as request counts and execution times.
  - These metrics are sent to Prometheus for collection and can be visualized in Grafana.
- **pom.xml**
  - Maven configuration including dependencies for Prometheus integration (`micrometer-core`) and Spring Boot setup.
- **docker/**
  - Contains Docker configurations for running Prometheus, Grafana, and the application in a containerized environment.
- **src/**
  - Source code for the application, including controllers, services, and models.

## Accessing Grafana
- Once the containers are running, navigate to `http://localhost:3000` to view the Grafana dashboards.
- Default credentials for Grafana: `admin` / `admin`

## Monitoring Metrics
- Prometheus collects metrics from the Spring Boot application.
- Grafana visualizes the data for easy tracking and alerting.

## Sharding and Routing in the Application
The application scales horizontally by distributing data across multiple database shards. It uses dynamic routing to ensure that each user’s data is efficiently stored and retrieved from the appropriate shard based on their user UUID.

## Advantages
- **Real-time Monitoring**: Continuous performance tracking using Prometheus and Grafana.
- **Scalability**: Easily add new shards as the application grows.
- **Fault Isolation**: Issues in one shard do not affect others.
- **Comprehensive Visualizations**: Grafana dashboards provide in-depth insights into system health.
##Prometheus
![image](https://github.com/user-attachments/assets/f8716b2b-f3f9-40da-92cd-2ff8b8677fc5)

##Grafana
![image](https://github.com/user-attachments/assets/1f840551-29cc-49cd-a939-586c9ab00535)
