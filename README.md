Task Management System API

A robust RESTful API built with Java and Spring Boot for managing tasks. This system supports full CRUD operations, status tracking, and basic authentication, utilizing an in-memory H2 database for a frictionless evaluation experience.

Features

* **Full CRUD Operations:** Create, Read, Update, and Delete tasks.

* **Task Completion:** Dedicated endpoint to mark tasks as complete.

* **Security:** Basic Authentication implemented with BCrypt password hashing.

* **Data Integrity:** Input validation using Jakarta Validation and automated JPA auditing for timestamps.

* **In-Memory Storage:** Uses H2 database with pre-populated sample data.

**Tech Stack**

* Java 17

* Spring Boot 3.x (Web, Data JPA, Security, Validation)

* Lombok (to reduce boilerplate code)

* H2 Database (In-memory)

* JUnit 5 & Mockito (Unit Testing)

**Prerequisites**

* JDK 17 or higher

* Maven 3.6+ (or use the included `./mvnw` wrapper)

**Getting Started**

1. Clone the repository:

```
git clone https://github.com/Raju53/Task-Management-System.git
```

2. Build the project:

```
./mvnw clean install
```
3. Run the application:

```
./mvnw spring-boot:run
```

The server will start at http://localhost:8080.

**Authentication & Credentials**

The API is secured with Basic Authentication. Please use the following credentials for all API requests:

* Username: `admin`

* Password: `password123`

**API Endpoints**

Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/tasks` | Retrieve all tasks |
| `GET` | `/tasks/{id}` | Retrieve a specific task |
| `POST` | `/tasks` | Create a new task |
| `PUT` | `/tasks/{id}` | Update an existing task |
| `DELETE` | `/tasks/{id}` | Delete a task |
| `PATCH` | `/tasks/{id}/complete` | Mark task as complete |

**Example cURL Request (Get All Tasks)**

```
curl -u admin:password123 -X GET http://localhost:8080/tasks
```

**Database Console (H2)**

You can view the database structure and data in real-time through the browser:

* URL: http://localhost:8080/h2-console

* JDBC URL: jdbc:h2:mem:taskdb

* User: task

* Password: task123

**Running Tests**

To execute the unit tests for the service layer:

```
./mvnw test
```
