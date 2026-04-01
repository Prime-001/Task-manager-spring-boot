# 📝 Task Manager — Spring Boot

A production-style RESTful Task Management API built with **Spring Boot 3.2**, featuring JWT authentication, role-based authorization, and a clean layered architecture.

---

## 🚀 Tech Stack

| Layer | Technology |
|-------|-----------|
| Backend | Java, Spring Boot 3.2 |
| Security | Spring Security, JWT |
| Database | MySQL, JPA/Hibernate |
| Validation | Bean Validation (@Valid) |
| Testing | Postman |
| Build Tool | Maven |

---

## ✅ Features

- 🏗️ **Layered Architecture** — Controller → Service → Repository pattern
- 🔐 **JWT Authentication** — Secure login & registration with token-based auth
- 🛡️ **Role-Based Authorization** — Endpoint access control per user role
- 🗄️ **User-Task Relationships** — JPA/Hibernate with custom queries for filtering by status & ownership
- ✔️ **Input Validation** — `@Valid` annotations with global exception handling
- 📦 **Standardized Responses** — Consistent JSON structure across all endpoints
- 🧪 **Postman Tested** — All endpoints verified including 403 on missing token

---

## 📡 API Endpoints

| Method | Endpoint | Description | Auth Required |
|--------|----------|-------------|---------------|
| POST | `/api/auth/register` | Register new user | ❌ |
| POST | `/api/auth/login` | Login & get JWT token | ❌ |
| GET | `/api/tasks` | Get all tasks | ✅ |
| POST | `/api/tasks` | Create a task | ✅ |
| GET | `/api/tasks/{id}` | Get task by ID | ✅ |
| PUT | `/api/tasks/{id}` | Update a task | ✅ |
| DELETE | `/api/tasks/{id}` | Delete a task | ✅ |

---

## ⚙️ Getting Started

### Prerequisites
- Java 21
- MySQL
- Maven

### Setup

#Clone the repository
git clone https://github.com/Prime-001/Task-manager-spring-boot.git
cd Task-manager-spring-boot

# Configure your database in src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskmanager
spring.datasource.username=your_username
spring.datasource.password=your_password

# Run the application
./mvnw spring-boot:run


### Test with Postman
1. Register → `POST /api/auth/register`
2. Login → `POST /api/auth/login` → copy the JWT token
3. Add token to Authorization header: `Bearer <token>`
4. Access task endpoints

---

## 📁 Project Structure

src/
└── main/
    ├── java/
    │   └── com/example/taskmanager/
    │       ├── controller/   # REST Controllers
    │       ├── service/      # Business Logic
    │       ├── repository/   # JPA Repositories
    │       ├── model/        # Entity Classes
    │       ├── dto/          # Request/Response DTOs
    │       └── security/     # JWT & Spring Security config
    └── resources/
        └── application.properties



## 📄 License
MIT
