# 🎓 Course Enrollment Management System

A complete RESTful web application built using **Java 21**, **Spring Boot 3**, and **PostgreSQL**, allowing administrators to manage courses, students, and their enrollments.

---

## 📚 Table of Contents

- [Project Overview](#project-overview)
- [Tech Stack](#tech-stack)
- [Features](#features)
- [Folder Structure](#folder-structure)
- [How to Run](#how-to-run)
- [API Endpoints](#api-endpoints)
- [Sample JSON Data](#sample-json-data)
- [Postman Collection](#postman-collection)
- [Database Schema](#database-schema)
- [Screenshots](#screenshots)
- [Future Enhancements](#future-enhancements)
- [Contributing](#contributing)
- [FAQ](#faq)
- [Author](#author)
- [License](#license)

---

## 🧠 Project Overview

This project simulates an academic course management system:

- 🎓 Add, edit, view, and delete **courses**  
- 👨‍🎓 Manage **students** and their details  
- 🔁 Enroll students in multiple courses  
- 📊 Retrieve lists of courses a student is enrolled in or students enrolled in a course  
- 💾 All data is persisted in a PostgreSQL database  

Designed with clean 3-layer architecture:
- Controller → Service → Repository

---

## 🛠️ Tech Stack

| Category       | Technology             |
|----------------|------------------------|
| Language        | Java 21               |
| Framework       | Spring Boot 3.x       |
| ORM             | Spring Data JPA       |
| Database        | PostgreSQL            |
| Build Tool      | Maven                 |
| Dev Tools       | Lombok, Postman       |
| IDE             | IntelliJ IDEA         |

---

## ✅ Features

- ➕ Add / 🔄 Update / ❌ Delete courses & students
- 📥 Enroll students into multiple courses
- 📤 Fetch all enrollments or per student/course
- 🧩 Many-to-Many mapping using a join table (`Enrollment`)
- 🌐 REST APIs with clear and consistent structure
- 🔐 Easily extendable to support authentication, frontend, etc.

---

## 📦 Folder Structure

```
course-enrollment-system/
├── controller/         → Handles HTTP requests
├── service/            → Business logic interfaces
├── service/impl/       → Logic implementations
├── entity/             → JPA entity models
├── repository/         → JPA interfaces
├── resources/
│   ├── application.properties → DB config
├── CourseEnrollementApplication.java → Main class
```

---

## 🚀 How to Run

1. **Clone the project**
```bash
git clone https://github.com/bhanuprakash0017/course-enrollment-system.git
cd course-enrollment-system
```

2. **Configure PostgreSQL DB**
- DB name: `course_enrollment`
- Update the `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/course_enrollment
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

3. **Run the app**
```bash
./mvnw spring-boot:run
```

4. **Test with Postman**
- Use endpoints like `/students`, `/courses`, `/enrollments`

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
| POST   | `/students`      | Create student       |
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

### ➕ Student
```json
{
  "name": "Sneha Verma",
  "email": "sneha@example.com",
  "contactNumber": "9123456789",
  "address": "MG Road, Pune"
}
```

### ➕ Course
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

You can create a Postman collection like:
- `POST /students` → Add student
- `POST /courses` → Add course
- `POST /enrollments` → Enroll student
- `GET /enrollments/students/1/courses` → Courses by student
- `GET /enrollments/courses/2/students` → Students in course

*Optionally export and attach your Postman collection JSON in the repo.*

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

## 🖼️ Screenshots

You can attach:
- Postman test results
- pgAdmin tables
- IntelliJ project structure
- DB schema diagram

Example:
![API Test Screenshot](screenshots/postman-test.png)

---

## 🌱 Future Enhancements

- Add Swagger/OpenAPI docs
- Add role-based user login (admin vs student)
- Export to Excel/PDF
- Deploy on AWS/GCP or Render
- Add unit tests using JUnit + Mockito
- Add frontend in React/Angular

---

## 🤝 Contributing

1. Fork this repository
2. Create your feature branch (`git checkout -b feature/my-feature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/my-feature`)
5. Create a pull request

---

## ❓ FAQ

**Q: Is the DB schema auto-generated?**  
A: Yes, using `spring.jpa.hibernate.ddl-auto=update`.

**Q: Can I switch to MySQL?**  
A: Yes, just change the dialect and driver.

**Q: What if I get connection errors?**  
A: Ensure PostgreSQL is running and credentials are correct.

---

## 👨‍💻 Author

**Bhanu Prakash**  
📧 bhanuprakash0017@gmail.com  
🔗 [GitHub Profile](https://github.com/bhanuprakash0017)

---

## 📄 License

This project is for educational and demonstration purposes only.
