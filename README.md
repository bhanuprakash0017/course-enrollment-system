# 🎓 Course Enrollment Management System

A robust, modular, and scalable RESTful backend application developed using **Java 21**, **Spring Boot 3**, and **PostgreSQL**.  
This project models a real-world academic system where students can be registered, enrolled in courses, and tracked efficiently with clean API design and a maintainable architecture.

---

## 💼 Executive Summary

> This project demonstrates mastery in designing and implementing a well-layered backend application using modern Java technologies.  
It includes CRUD operations, relational data modeling, RESTful design principles, proper use of JPA relationships, and clean separation of concerns — making it ideal for showcasing enterprise-grade development practices.

---

## 🧠 System Overview

### 🏛 Modules:
- **Student Management**: CRUD operations on student records
- **Course Management**: CRUD operations on courses
- **Enrollment System**: Many-to-Many relational logic with timestamping

### 🧩 Core Concepts:
- Multi-entity design with real-world relationships
- DTO-ready service layer (can be extended for validation/mapping)
- Repository abstraction with Spring Data JPA
- Domain-centric design

---

## 🛠️ Tech Stack

| Layer           | Tech                            |
|----------------|----------------------------------|
| Language        | Java 21                         |
| Framework       | Spring Boot 3.x                 |
| ORM             | Spring Data JPA                 |
| Database        | PostgreSQL                      |
| Build Tool      | Maven                           |
| Boilerplate     | Lombok                          |
| Testing         | Postman (manual testing)        |
| Future-ready    | Swagger, JUnit5, Docker         |

---

## 📦 Project Structure

```
com.bhanu.courseenrollment
├── controller         → REST Controllers
├── service            → Interfaces
├── service.impl       → Business Logic
├── entity             → JPA Entities
├── repository         → Spring Data JPA Repos
└── resources
    └── application.properties
```

---

## 🚀 Setup Instructions

1. **Clone the Repository**
```bash
git clone https://github.com/bhanuprakash0017/course-enrollment-system.git
cd course-enrollment-system
```

2. **Database Configuration**
- Create PostgreSQL DB: `course_enrollment`
- Update the following in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/course_enrollment
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. **Run the Project**
```bash
./mvnw spring-boot:run
```

4. **API Testing**
- Import endpoints into Postman
- Use sample data for Students, Courses, and Enrollments

---

## 📊 API Overview

### 👨‍🎓 Students
| Verb | Endpoint          | Description         |
|------|-------------------|---------------------|
| GET  | `/students`       | Get all students    |
| POST | `/students`       | Create new student  |
| PUT  | `/students/{id}`  | Update student      |
| DELETE | `/students/{id}`| Delete student      |

### 📘 Courses
| Verb | Endpoint         | Description         |
|------|------------------|---------------------|
| GET  | `/courses`       | Get all courses     |
| POST | `/courses`       | Create new course   |
| PUT  | `/courses/{id}`  | Update course       |
| DELETE | `/courses/{id}`| Delete course       |

### 🔗 Enrollments
| Verb | Endpoint                                              | Description                          |
|------|-------------------------------------------------------|--------------------------------------|
| POST | `/enrollments?studentId=1&courseId=2`                | Enroll student to course             |
| GET  | `/enrollments`                                       | Get all enrollments                  |
| GET  | `/enrollments/students/{studentId}/courses`          | Courses by student                   |
| GET  | `/enrollments/courses/{courseId}/students`           | Students by course                   |

---

## 📄 Sample JSON

### ➕ Student
```json
{
  "name": "Rahul Mehta",
  "email": "rahul.mehta@example.com",
  "contactNumber": "9876543210",
  "address": "Bangalore, India"
}
```

### ➕ Course
```json
{
  "name": "Spring Boot & Microservices",
  "description": "Build real-world APIs using Spring Boot",
  "duration": "6 weeks",
  "fees": 2999.00
}
```

---

## 🧠 Database Schema

```
STUDENT
- student_id (PK)
- name
- email
- contact_number
- address

COURSE
- course_id (PK)
- name
- description
- duration
- fees

ENROLLMENT
- enrollment_id (PK)
- student_id (FK)
- course_id (FK)
- enrollment_date
```

---

## 📸 Optional Screenshots

<details>
  <summary>Postman Test Screenshot</summary>
  <img src="screenshots/postman-demo.png" width="600"/>
</details>

<details>
  <summary>pgAdmin Table View</summary>
  <img src="screenshots/db-view.png" width="600"/>
</details>

---

## 🌟 Future Enhancements

- Add Swagger/OpenAPI documentation
- Role-based authorization (Admin vs User)
- Integration with frontend (React/Angular)
- Dockerize for container-based deployment
- CI/CD pipeline with GitHub Actions

---

## 🙋 FAQ

> **Q: Why a separate `Enrollment` entity instead of direct ManyToMany?**  
> A: This allows for richer relationship metadata like `enrollmentDate`.

> **Q: Can this be deployed to cloud (AWS/GCP)?**  
> A: Yes. App is stateless and DB-ready — Docker + RDS can handle it.

---

## ✍️ Author

**Bhanu Prakash**  
📧 bhanuprakash0017@gmail.com  
🔗 [GitHub](https://github.com/bhanuprakash0017)

---

## 📄 License

This repository is licensed for educational and open-source usage. Feel free to fork, enhance, and contribute.

