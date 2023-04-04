![Header](src/main/resources/pictures/movie_time.jpeg)

##  Description
A server application that implements the logic of the service for booking based on **Hibernate** and **Spring** frameworks using **REST** common principles. 
The application supports the function of authentication and authorization thanks to **Spring Security**, provides **validation** of input data, and returns objects in **JSON** format.

---

##  Project structure
Project based on Three-Tier architecture:
- **Presentation tier** (controllers) - provides user interaction with the application
- **Logic tier** (services) - establishes the set of available operations and coordinates the program's response to each operation.
- **Data tier** (DAO) - represents interaction with the database

---

## List of endpoints

**Functions that are available for any role**

- Register (the user will be assigned the _USER_ role) `GET /register`
- Login as a USER (this page will be opened on startup) `POST /login`
- Login as an ADMIN (you can use existing account) `POST /login`

**Depending on the role of the authenticated user, the following functions are available**

*For users with **USER** role:*
- Get all movies `GET /movies`
- Get all cinema Halls `GET /cinema-halls`
- Find available movie sessions `GET /movie-sessions/available`
- Add tickets to shopping cart `PUT /shopping-carts/movie-sessions/{movieSessionId}`
- View their shopping cart `GET /shopping-carts/by-user`
- Complete an order `POST /orders/complete`
- View order history `GET /orders`

*For users with **ADMIN** role:*
- Create movie `POST /movies`
- Get all movies `GET /movies`
- Create cinema hall `POST /cinema-halls`
- Get all cinema halls `GET /cinema-halls`
- Create movie session `POST /movie-session`
- Update information about movie session `PUT /movie-session/{movieSessionId}`
- Delete movie session `DELETE /movie-session/{movieSessionId}`
- Find available movie sessions `GET /movie-sessions/available`
- Find user by email `GET /users/by-email`

---

## Technologies
- Java 11
- Maven 4
- MySQL 8
- Hibernate 5.4.27
- Hibernate validator 6.1.6
- Spring Framework 5.2.2
- Spring Web MVC 5.2.2
- Spring Security 5.2.2
- Apache Tomcat 9
- JSON

---
## Implemenation details
- **Entities** represent a set of columns in the database
- **DTOs** represent communication with the user
- **DTO mappers** for converting DTOs to entities and vice versa
- All interaction with the database occurs at the **DAO** level
- **Config package** is responsible for Spring settings and beans creation
- All operations are available at the **Service**
- All interaction client-server occurs through **Controllers**
- **BCryptPasswordEncoder** is used for password encryption
- **Hibernate annotations** are used for field validation
- **Custom annotations** are used for email and password validation
- **CustomGlobalExceptionHandler** handles these errors and returns objects
- **Jackson API** is responsible for converting objects to **JSON**

---

## Quickstart
1. Fork this repository
2. Clone the project to your computer
3. Install MySQL
4. A terminal can be used to manage the database and send queries:

   `mysql -u root -p` *and enter your password*

5. Run next commands to create new schema and set a timezone:

    `CREATE SCHEMA movie_time DEFAULT CHARACTER SET utf8`

    `SET GLOBAL time_zone = '+3:00'`

6. Add you DB credentials to **db.properties** file

``` java
    db.driver=com.mysql.cj.jdbc.Driver
    db.url=YOUR_DATABASE_URL
    db.user=YOUR_DATABASE_USERNAME
    db.password=YOUR_DATABASE_USERNAME
```
7. Download and Install <a href="https://tomcat.apache.org/download-90.cgi">Apache Tomcat 9</a>
8. Configure Apache Tomcat:
- ***Artifact***: `war-exploded artifact`
- ***Application context***: `"/"`
9. Run project
10. You will have 2 users in your DB after running:

   **ADMIN: master@gmail.com, password: 12345678**

   **USER: slave@gmail.com, password: 87654321**
    
    You can change these users in **DataInitializer**
11. For testing, you can use **Postman** or another utility at your discretion
    
   *Use following headers:*

    *key*: **Content-Type**, *value*: **application/json** - for sending data in JSON

    *key*: **Authorization**, *value*: **Basic** ***username:password*** ***encoded in Base64*** - for authorization

---

## Author

[Vitalii Shkliarskyi](https://github.com/VitaliiShkliarskyi)

---