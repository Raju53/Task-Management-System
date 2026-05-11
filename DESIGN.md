Design Decisions & Assumptions

This document outlines the architectural choices and assumptions made during the development of the Task Management System API.

1. Architectural Pattern

    I adopted a Layered Architecture to ensure a clean separation of concerns:

      * **Controller Layer:** Handles HTTP mapping and request validation.

      * **Service Layer:** Contains business logic and manages transactional boundaries.

      * **Repository Layer:** Abstracts data persistence using Spring Data JPA.

      * **DTO Layer:** Decouples the internal database schema from the external API contract.

2. Data Transfer Objects (DTOs)

    The system uses `TaskRequest` and `TaskResponse` objects.

    Why? By directly exposing JPA entities to the API can lead to security vulnerabilities and tightly couples the database to the API. DTOs allow us to evolve the internal database structure without breaking the public API.

3. Storage Strategy

    I chose **H2 (In-Memory)** over a persistent database like MySQL for this case study.

   * **Reasoning:** It ensures the application is "portable." An evaluator can run the project immediately without configuring local database instances or managing connection strings.

   * **Data Seeding:** I implemented `schema.sql` and `data.sql` to ensure the database is pre-populated with meaningful sample data upon startup.

4. Security Implementation

    I implemented **Spring Security with Basic Authentication** as requested in the bonus requirements.

   * **Password Safety:** Even for this demo, I utilized `BCryptPasswordEncoder` to demonstrate the industry standard for hashing credentials.

   * **H2 Access:** The configuration was specifically tuned to allow the H2 console to run within frames while keeping the rest of the API strictly authenticated.

5. Automated Auditing

    To satisfy the requirement for `created_at` and `updated_at` timestamps, I utilized **Spring Data JPA Auditing** (`@CreatedDate` and `@LastModifiedDate`).

    * **Benefit:** This removes the need for manual timestamp setting in the service layer, reducing human error and keeping the business logic focused on task management.

6. Assumptions

   * **User Roles:** For the scope of this assignment, a single `USER` role is assigned to the evaluator.

   * **Task Status:** Default status is set to `PENDING` upon creation if not specified.

   * **Timezone:** The system defaults to UTC for all timestamp generations to ensure consistency across different environments.