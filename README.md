# 🎓 Course Enrollment Management System

A complete RESTful web application built using **Java 21**, **Spring Boot 3**, and **PostgreSQL**, allowing administrators to manage courses, students, and their enrollments with clean architecture and API design.

---

## 📚 Table of Contents

- [🧠 Project Overview](#-project-overview)
- [🛠️ Tech Stack](#️-tech-stack)
- [✅ Features](#-features)
- [📦 Folder Structure](#-folder-structure)
- [🚀 How to Run](#-how-to-run)
- [🔌 API Endpoints](#-api-endpoints)
- [📄 Sample JSON Data](#-sample-json-data)
- [📥 Postman Collection](#-postman-collection)
- [🧠 Database Schema](#-database-schema)
- [🤝 Contributing](#-contributing)
- [❓ FAQ](#-faq)
- [👨‍💻 Author](#-author)
- [📄 License](#-license)

---

## 🧠 Project Overview

This project simulates an academic course management system with:

- 🎓 Add, edit, view, and delete **courses**  
- 👨‍🎓 Manage **students** and their details  
- 🔁 Enroll students in multiple courses  
- 📊 Retrieve lists of courses a student is enrolled in or students enrolled in a course  
- 💾 Data persisted in PostgreSQL using JPA/Hibernate  

Follows clean 3-layer architecture:
**Controller → Service → Repository**

---

## 🛠️ Tech Stack

| Category       | Technology             |
|----------------|------------------------|
| Language        | Java 21               |
| Framework       | Spring Boot 3.x       |
| ORM             | Spring Data JPA       |
| Database        | PostgreSQL            |
| Build Tool      | Maven                 |
| Boilerplate     | Lombok                |
| Testing         | Postman               |
| IDE             | IntelliJ IDEA         |

---

## ✅ Features

- Full CRUD for Students and Courses
- Many-to-Many mapping via Enrollment table
- Fetch enrolled courses/students with filter APIs
- PostgreSQL database integration
- RESTful endpoints with clean URI naming

---

## 📦 Folder Structure

```
course-enrollment-system/
├── controller/         → REST controllers
├── service/            → Interfaces
├── service/impl/       → Service implementations
├── entity/             → JPA entities
├── repository/         → JPA repositories
├── resources/
│   └── application.properties
└── CourseEnrollementApplication.java
```

---

## 🚀 How to Run

1. **Clone the repository**
```bash
git clone https://github.com/bhanuprakash0017/course-enrollment-system.git
cd course-enrollment-system
```

2. **Set up PostgreSQL database**
- Create a DB named: `course_enrollment`
- Update your credentials in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/course_enrollment
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
```

3. **Run the application**
```bash
./mvnw spring-boot:run
```

4. **Test the APIs using Postman or cURL**

---

## 🔌 API Endpoints

### 📘 Courses
| Method | Endpoint         | Description          |
|--------|------------------|----------------------|
| POST   | `/courses`       | Create a course      |
| GET    | `/courses`       | Get all courses      |
| GET    | `/courses/{id}`  | Get course by ID     |
| PUT    | `/courses/{id}`  | Update course        |
| DELETE | `/courses/{id}`  | Delete course        |

### 👨‍🎓 Students
| Method | Endpoint         | Description          |
|--------|------------------|----------------------|
| POST   | `/students`      | Create a student     |
| GET    | `/students`      | Get all students     |
| GET    | `/students/{id}` | Get student by ID    |
| PUT    | `/students/{id}` | Update student       |
| DELETE | `/students/{id}` | Delete student       |

### 🔗 Enrollments
| Method | Endpoint                                      | Description                          |
|--------|-----------------------------------------------|--------------------------------------|
| POST   | `/enrollments?studentId=1&courseId=2`         | Enroll student in a course           |
| GET    | `/enrollments`                                | Get all enrollments                  |
| GET    | `/enrollments/students/{studentId}/courses`   | Get courses by student ID            |
| GET    | `/enrollments/courses/{courseId}/students`    | Get students by course ID            |

---

## 📄 Sample JSON Data

### 👨‍🎓 Student
```json
{
  "name": "Sneha Verma",
  "email": "sneha@example.com",
  "contactNumber": "9123456789",
  "address": "MG Road, Pune"
}
```

### 📘 Course
```json
{
  "name": "Java 21 Bootcamp",
  "description": "Advanced Java course with Spring Boot",
  "duration": "6 weeks",
  "fees": 2500.0
}
```

---

## 📥 Postman Collection

You can create a Postman collection that includes:

- `POST /students` – Add student
- `POST /courses` – Add course
- `POST /enrollments?studentId=1&courseId=2` – Enroll student
- `GET /enrollments/students/1/courses` – Get courses by student
- `GET /enrollments/courses/2/students` – Get students by course

*(Tip: Export and upload your Postman collection JSON to the repo if needed.)*

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

## 🤝 Contributing

1. Fork this repository
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to your branch: `git push origin feature/your-feature-name`
5. Open a pull request

---

## ❓ FAQ

**Q: Is the database schema auto-generated?**  
Yes — it is auto-generated via Hibernate using `spring.jpa.hibernate.ddl-auto=update`.

**Q: Can this project be extended to support a frontend?**  
Absolutely! It can be paired with Angular, React, or Vue.

**Q: Can I deploy this to a cloud service like AWS or Render?**  
Yes. It's production-ready with minimal tweaks for cloud deployment.

---

## 👨‍💻 Author

**Bhanu Prakash**  
📧 kopparapubhanuprakash017@gmail.com  
🔗 [GitHub](https://github.com/bhanuprakash0017)

---

## 📄 License

This project is licensed for educational and demonstration purposes only.
