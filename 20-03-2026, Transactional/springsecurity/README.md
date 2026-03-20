# Spring Security JWT Authentication System

## Overview

This project is a production-style Spring Boot application that demonstrates secure authentication and authorization using Spring Security and JSON Web Tokens (JWT). It implements a stateless security architecture with role-based access control and a custom authentication flow.

The system is designed to progressively cover multiple levels of Spring Security concepts, ranging from basic authentication to advanced JWT-based authorization and custom filters.

---

## Features

### Authentication

* Custom login API (`/login`)
* Authentication using `AuthenticationManager`
* User credentials stored in database (H2)

### Authorization

* Role-based access control (USER, ADMIN)
* Endpoint-level security using `SecurityFilterChain`
* Method-level security support via `@PreAuthorize`

### JWT Security

* JWT token generation upon successful login
* JWT validation using a custom filter
* Stateless session management
* Roles embedded inside JWT claims

### Password Security

* Password hashing using `BCryptPasswordEncoder`

### Exception Handling

* Custom handling for:

    * Unauthorized access (401)
    * Forbidden access (403)
* Global exception handler for consistent API responses

### Logging & Debugging

* Custom logging filter
* Security context debugging support

---

## Tech Stack

* Java 21
* Spring Boot 3
* Spring Security
* Spring Data JPA
* H2 Database
* JJWT (Java JWT Library)
* Maven

---

## Project Structure

```
com.training.springsecurity
│
├── config/                  # Configuration classes
│   ├── SecurityConfig.java
│   ├── JwtConfig.java
│   └── PasswordConfig.java
│
├── controller/              # REST Controllers
│   ├── AuthController.java
│   └── TestController.java
│
├── dto/                     # Data Transfer Objects
│   ├── LoginRequest.java
│   ├── LoginResponse.java
│   └── ErrorResponse.java
│
├── entity/                  # JPA Entities
│   └── UserEntity.java
│
├── repository/              # Database layer
│   └── UserRepository.java
│
├── security/
│   ├── jwt/                 # JWT logic
│   │   ├── JwtService.java
│   │   └── JwtFilter.java
│   │
│   ├── handler/             # Exception handlers
│   │   ├── CustomAuthenticationEntryPoint.java
│   │   └── CustomAccessDeniedHandler.java
│   │
│   └── service/             # Security services
│       └── CustomerUserDetailsService.java
│
├── service/                 # Business logic
│   └── UserService.java
│
├── filter/                  # Custom filters
│   └── LoggingFilter.java
│
├── exception/               # Global exception handling
│   └── GlobalExceptionHandler.java
│
├── constants/               # Constants
│   └── AppConstants.java
│
├── util/                    # Utility classes
│   └── SecurityUtils.java
│
└── SpringsecurityApplication.java
```

---

## Application Flow

### Authentication Flow

1. Client sends credentials to `/login`
2. `AuthenticationManager` authenticates user
3. `UserDetailsService` loads user from database
4. Password is validated using `BCryptPasswordEncoder`
5. JWT token is generated and returned

---

### Authorization Flow

1. Client sends request with JWT in `Authorization` header
2. `JwtFilter` intercepts the request
3. Token is extracted and validated
4. User details are loaded
5. `SecurityContext` is populated
6. Request proceeds to controller if authorized

---

## API Endpoints

### Public Endpoint

```
GET /public
```

* Accessible without authentication

---

### Authentication

```
POST /login
```

Request Body:

```json
{
  "username": "user",
  "password": "password"
}
```

Response:

```json
{
  "token": "jwt-token"
}
```

---

### Protected Endpoints

```
GET /user
```

* Requires ROLE_USER

```
GET /admin
```

* Requires ROLE_ADMIN

---

## JWT Structure

The JWT contains:

* Subject: username
* Claims:

    * roles
* Issued time
* Expiration time

---

## Security Configuration

* CSRF disabled (stateless API)
* Session policy: STATELESS
* Custom JWT filter added before `UsernamePasswordAuthenticationFilter`
* Exception handling customized

---

## Database

* H2 in-memory database
* Table: `users`

### Sample Data Initialization

Users are inserted at startup using `CommandLineRunner`:

* user / password → ROLE_USER
* admin / password → ROLE_ADMIN

---

## Running the Application

### Prerequisites

* Java 21
* Maven

### Steps

1. Clone the repository
2. Run:

```
mvn spring-boot:run
```

3. Application starts on:

```
http://localhost:8080
```

---

## Testing

### Step 1: Login

```
POST /login
```

Copy the JWT from response.

---

### Step 2: Use Token

Add header:

```
Authorization: Bearer <token>
```

---

### Step 3: Access APIs

* `/user` → requires USER role
* `/admin` → requires ADMIN role

---

## Key Concepts Implemented

* Stateless authentication
* JWT-based security
* Custom authentication flow
* Role-based authorization
* Spring Security filter chain
* Security context management

---

## Future Improvements

* Refresh token mechanism
* Token blacklisting for logout
* Role hierarchy
* OAuth2 / OpenID Connect integration
* Rate limiting on authentication endpoints
* Externalized configuration for secrets

---

## Conclusion

This project demonstrates a complete end-to-end implementation of secure authentication and authorization using Spring Security and JWT. It follows production-level practices and provides a strong foundation for building scalable and secure backend systems.
