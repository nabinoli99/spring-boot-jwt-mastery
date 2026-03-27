# 🔐 JWT Mastery

> Learning JWT Authentication in Spring Boot — one concept at a time, one commit at a time.

## 📚 Key concepts learned:

JWT — token based auth, no sessions, stateless
JwtService — generates and validates tokens
JwtAuthFilter — intercepts every request, validates token
SecurityConfig — configures which endpoints need auth
CustomUserDetailsService — loads user from DB for Spring Security
@AuthenticationPrincipal — pulls logged in user from SecurityContext
BCrypt — hashes passwords before saving to DB
DTOs — never expose password in response

## 🗂️ Project Structure
```
jwt-mastery/
└── src/
    └── main/
        └── java/
            └── com/learn/
                ├── controller/
                │   ├── AuthController.java
                │   └── UserController.java
                ├── dto/
                │   ├── request/
                │   │   ├── LoginRequestDTO.java
                │   │   └── RegisterRequestDTO.java
                │   └── response/
                │       ├── AuthResponseDTO.java
                │       └── UserResponseDTO.java
                ├── entity/
                │   ├── Role.java
                │   └── User.java
                ├── exception/
                │   └── ConflictException.java
                ├── repository/
                │   └── UserRepository.java
                ├── security/
                │   ├── CustomUserDetailsService.java
                │   ├── JwtAuthFilter.java
                │   ├── JwtService.java
                │   └── SecurityConfig.java
                ├── service/
                │   └── AuthService.java
                └── JwtMasteryApplication.java
```

## 🛠️ Tech Stack

| Tech | Version |
|------|---------|
| Java | 17 |
| Spring Boot | 4.0.4 |
| Spring Security | Latest |
| PostgreSQL | 14+ |
| JWT (jjwt) | 0.12.x |
| Lombok | Latest |

## 📌 Commit Convention
```
feat:     → new feature
config:   → configuration
refactor: → code improvement
```

> 🎯 Goal: Implement production-ready JWT Authentication from scratch.
