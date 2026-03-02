#  Smart Expense Tracker

A secure backend application built using Spring Boot for managing personal expenses.  
Implements JWT-based authentication, PostgreSQL integration, and stateless security.

---

##  Tech Stack

- Java 24
- Spring Boot 4
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- PostgreSQL
- Maven
- Postman (API Testing)

---

##  Architecture

Monolithic layered architecture:

Controller → Service → Repository → PostgreSQL

Security handled via:
- JWT Authentication Filter
- Stateless session management
- BCrypt password encoding

---

##  Features

- User Registration
- User Login with JWT
- Secure Expense Creation
- View User-specific Expenses
- Stateless Authentication
- Global Security Configuration
- Encrypted Password Storage

---

##  API Endpoints

### 🔹 Register User
POST `/users`

```json
{
  "name": "Aman",
  "email": "aman@gmail.com",
  "password": "1234"
}

🔹 Login

POST /auth/login

{
  "email": "aman@gmail.com",
  "password": "1234"
}

Response:

{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
🔹 Create Expense (Protected)

POST /expenses/user/{userId}

Authorization: Bearer TOKEN

{
  "title": "Lunch",
  "amount": 200,
  "category": "Food",
  "date": "2026-02-26"
}
🔹 Get Expenses (Protected)

GET /expenses/user/{userId}
Authorization: Bearer TOKEN

⚙️ How To Run

Clone repository

Configure PostgreSQL in application.properties

Run:

mvn clean install
mvn spring-boot:run

Server runs at:

http://localhost:8080
** Security Flow

User registers

User logs in

Server generates JWT token

Client sends token in Authorization header

JWT Filter validates token

Access granted to protected endpoints

** Learning Highlights

Implemented JWT-based stateless authentication

Built custom authentication filter

Configured Spring Security filter chain

Managed secure password encryption

Designed layered monolithic architecture

** Next Phase

Planned upgrade:

Convert into Microservices Architecture

Add Eureka Service Discovery

Add API Gateway

Dockerize services


---

#  After Pasting

Run:

```bash
git add README.md
git commit -m "Added project README"
git push
