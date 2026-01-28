# P-40_FreshLog_Back-End
FreshLog is a specialized inventory management system designed to solve the critical challenges of handling perishable goods. Unlike generic stock systems, FreshLog focuses on batch-level traceability and shelf-life optimization.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Maven](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-bc0404?style=for-the-badge&logo=lombok&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![H2](https://img.shields.io/badge/H2_Database-004088?style=for-the-badge&logo=databricks&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=black)
![JUnit](https://img.shields.io/badge/Junit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
![Mockito](https://img.shields.io/badge/Mockito-7ad131?style=for-the-badge&logo=mockito&logoColor=white)

## 🎇 Key Features

Here it's where we got all the Freshlog features:

| Feature | Description |
|---------|-------------|
| **Batch Traceability** | Full management of product batches, allowing precise control over entry and exit of stock. |
| **RESTful API** | Clean and documented endpoints for Categories, Products, and Batches. |
| **Shelf-life focus** | Specialized logic for perishable goods to minimize waste and optimize stock rotation. |
| **Interactive Docs** | Real-time API testing and exploration through **Swagger UI.** |

## 🧱 Project Structure

Now going to the project structure, explaining all the folders and it's purpose.

| Layer | Responsibility | Components |
|----|----|---|
| **Config** | Infrastructure and third-party library settings. | ``CorsConfig`` |
| **Controller** | REST entry points & Swagger documentation. | ``BatchController``, ``CategoryController``, ``ProductController``. |
| **DTO** | Secure and optimized data transfer between layers | ``BatchDTO``, ``CategoryDTO``, ``ProductDTO``, ``ErrorMessage``.
| **Entity** | Database models and ORM mapping. | ``Batch``, ``Category``, ``Product``. |
| **Exception** | Error handlers for specific business rules | ``BatchAlreadyExistsException``, ``BatchNotFoundException``,  ``GlobalExceptionHandler``, etc.
| **Mapper** | Transform the Entity format to the DTO format. | ``BatchMapper``, ``CategoryMapper``, ``ProductMapper``. |
| **Repository** | Data persistence and database communication. | ``BatchRepo``, ``CategoryRepo``, ``ProductRepo``. |
| **Service** | Core business logic and validations | ``BatchService``, ``CategoryService``, ``ProductService``. |

## 🧪 Testing strategy 
| Test Type | Objective | Tools |
|----------|-----------|-|
| ``Unit testing`` | Validation of business rules by isolating services and mocking dependencies. | **JUnit5**, **Mockito**. |
| ``Data Integation`` | Ensuring correct ORM mapping and repository queries using an in-memory database. | **H2 Database** |