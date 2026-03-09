# Smart Expense Tracker — Microservices Version

This branch contains the **microservices architecture implementation** of the Smart Expense Tracker project.

The original **monolithic implementation** is available in the `main` branch.  
This branch demonstrates how the system was redesigned into **independent microservices using Spring Cloud and Docker**.

---

# Architecture Overview

The application is split into multiple independent services that communicate using **REST APIs** and **service discovery**.

Client requests are routed through an **API Gateway**, which communicates with backend services discovered through **Eureka Server**.
Client
│
API Gateway (8080)
│
├── Auth Service (8081)
└── Expense Service (8082)
│
PostgreSQL Database
│
Eureka Server (8761)
---

# Microservices

## 1. Eureka Server
Service discovery server where all services register themselves.

Port:

8761


Purpose:
- Keeps track of all running services
- Enables dynamic service discovery
- Allows services to communicate without hardcoded URLs

---

## 2. Auth Service

Handles authentication and user management.

Port:

8081


Features:
- User registration
- User login
- Password encryption using **BCrypt**
- JWT token generation
- Spring Security integration
- PostgreSQL database

---

## 3. Expense Service

Handles expense management operations.

Port:

8082


Features:
- Create expenses
- View expenses
- Expense tracking per user
- JWT token validation
- PostgreSQL database

---

## 4. API Gateway

Acts as the **single entry point** for all client requests.

Port:
8080
Routes requests to appropriate services:
/auth/** → Auth Service
/expenses/** → Expense Service


Features:
- Request routing
- Load balancing
- Service discovery integration

---

# Tech Stack

Backend:
- Java 17
- Spring Boot
- Spring Cloud
- Spring Security
- Spring Data JPA
- Maven

Microservices:
- Eureka Server
- API Gateway

Security:
- JWT Authentication
- BCrypt Password Hashing

Database:
- PostgreSQL

Containerization:
- Docker
- Docker Compose

---

# Key Concepts Implemented

Microservices Architecture  
Service Discovery (Eureka)  
API Gateway Pattern  
JWT Authentication  
RESTful APIs  
DTO Pattern  
Dependency Injection  
Docker Containerization  

---

# Running the Project

## 1. Build Services

Navigate to each service directory and build the jar:
mvn clean package -DskipTests
Services:
eureka-server
auth-service
expense-service
api-gateway


---

## 2. Run using Docker

From the project root:
docker compose up --build
This will start all containers:
- Eureka Server
- Auth Service
- Expense Service
- API Gateway

---

# Access the Services

Eureka Dashboard:
http://localhost:8761
API Gateway:
http://localhost:8080


---

# Example API Endpoints

Register user:
POST /auth/register
Login:
POST /auth/login
Create Expense:
POST /expenses
Get Expenses:
GET /expenses


---

# Project Evolution

Phase 1:
Monolithic Spring Boot application

Phase 2:
Migrated to Microservices architecture

Phase 3:
Added Service Discovery using Eureka

Phase 4:
Implemented API Gateway routing

Phase 5:
Added JWT Authentication

Phase 6:
Containerized services using Docker


---

# Learning Goals of This Project

This project was built to understand:

- Migration from **monolithic architecture to microservices**
- Service discovery patterns
- Secure authentication using JWT
- API Gateway routing
- Docker-based deployment of microservices

---
