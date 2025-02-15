# 📚 SpringBooks Application

## 📖 Project Overview

The **SpringBooks Application** is a Java Spring Boot web application designed to manage books, publishers, and categories with robust CRUD functionalities. The application includes user authentication powered by Spring Security to ensure secure access to features based on user roles.

---

## 🚀 Features

### 🔐 Authentication & Authorization
- User login/logout using Spring Security.
- Role-based access control.

### 📘 Book Management
- Create, read, update, and delete books.

### 🏢 Publisher Management
- Create, read, update, and delete publishers.

### 🏷️ Category Management
- Create, read, update, and delete categories.

---

## 🏗️ Tech Stack

- **Java Spring Boot** - Backend framework.
- **Spring Security** - Authentication and authorization.
- **PostgreSQL** - Database for storing application data.
- **Thymeleaf** - Server-side template engine for rendering views.
- **HTML, CSS, JavaScript** - Frontend technologies.
- **Maven** - Dependency management.

---

## 🛠️ System Architecture

- **MVC Pattern**: Follows the Model-View-Controller architecture.
- **Spring Security**: User authentication and access control.
- **CRUD Operations**: Comprehensive functionality for managing books, publishers, and categories.

---

## ⚙️ Installation Guide

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Barbarossa01/SpringBooks.git
cd SpringBooks
```

### 2️⃣ Configure the Database
Ensure you have PostgreSQL installed and create a database:
```sql
CREATE DATABASE springbooks;
```
Update `application.properties` with your database credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/springbooks
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run the Application
```bash
mvn spring-boot:run
```

The application will be accessible at:  
**[http://localhost:8080](http://localhost:8080)**

---

## 🔑 Default User Credentials (For Testing)

| Role         | Email             | Password  |
|---------------|--------------------|-----------|
| **Admin**     | user1              | password  |

---

## 🛡️ Security Measures

- **Password Encryption**: User passwords are securely hashed using BCrypt.
- **Role-Based Access Control**: Admins manage books, publishers, and categories.
- **Input Validation**: Client and server-side validation to prevent malicious inputs.

---

## 🔮 Future Improvements (Roadmap)

- 📌 Implement user registration.
- 📌 Enhance UI/UX with a more dynamic frontend framework.
- 📌 Add book search and filtering functionality.
- 📌 Implement pagination for large datasets.

---

## 🧑‍💻 Contributors

- **Zain Din** *(Project Owner/Developer)*  
  GitHub: [Barbarossa01](https://github.com/Barbarossa01)
---

📚 **Happy Reading and Managing!** 📖

Feel free to contribute, fork, and share! 😊

