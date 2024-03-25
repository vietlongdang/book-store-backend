# Book Store Back End

This is a Spring Boot application designed for managing a book library. It leverages Spring Boot, JPA, REST APIs, and Okta for OAuth 2.0 security, making it a comprehensive solution for React-based frontend applications.

## Features

- RESTful API for book and user management
- Data persistence using Spring Data JPA with MySQL
- Secure authentication and authorization with Okta
- Development tools for hot reloading and enhanced development experience

## Prerequisites

Before you start, make sure you have installed:

- Java JDK 17 or higher
- Maven 3.6 or higher
- MySQL Server (version compatible with Connector/J)
- An Okta Developer Account (for OAuth 2.0 features)

## Configuration

1. **Database Setup**: Ensure your MySQL server is running. Create a database for this application.

2. **Run SQL Scripts**: Navigate to the `scripts` folder and run the SQL scripts to set up your database schema:

    ```sh
    mysql -u yourUsername -p yourDatabase < path/to/your/script.sql
    ```

   Replace `yourUsername`, `yourDatabase`, and `path/to/your/script.sql` with your MySQL username, the name of your database, and the path to your SQL script, respectively.

## Running the Application

To run the application, navigate to the root directory of the project and execute the following command:

```sh
mvn spring-boot:run
