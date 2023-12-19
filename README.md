# Todolist API
This repository contains a todo list project built using Java and Spring Boot.
The goal of this project is to learn the basic concepts of Java Spring and REST APIs.


## Table of Contents
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
- [Database](#database)
- [Technologies](#database)

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/luciofer/todolist-java.git
    ```

2. Install dependencies with Maven

## Usage

1. Start the application with Maven
2. The API will be accessible at http://localhost:8080


## API Endpoints
The API provides the following endpoints:

```markdown
User registration

POST users/ - Create a new user

Request :
         {
         "username": "example_user",
         "name": "user",
         "password": "examplePassword123"
         }
---

Tasks
     *** Authorization: Basic base64(username:password) ***

GET tasks/ - Retrieve a list of all tasks.

POST tasks/create - Create a new task.

    Request:
         {
         "title": "Test title ",
         "description":" Todolist application project.",
         "priority":"Normal",
         "startAt":"2023-10-25T11:30:00",
         "endAt":"2023-10-25T12:00:00"
         }

PUT tasks/{task_id} - Update a task.

DELETE - Coming soon

```

## Database
The database used for this project is [PostgresSQL](https://www.postgresql.org/download/) running on [Docker](https://www.docker.com/).


## 👩🏾‍💻 Technologies

- Java 17
- Spring Boot
- Maven
- PostgreSQL
- Docker
- Git and Github

## ✉ Contact

contatolucioaraujo@gmail.com

[Linkedin](https://www.linkedin.com/in/lucioaraujo30/)