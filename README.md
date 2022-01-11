# Books (Spring Boot example)

This is a simple CRUD for a list of books in memory.

This project uses JDK 17.

To run this, run `./mvnw spring-boot:run` or `docker-compose up` if you have docker installed and running.

You can access the api in `http://localhost:8090/books`

Endpoints:

### GET `books`:
Returns a list of books.

### POST `books`:
Receives a JSON in the body with a name and a isbn properties (strings) and adds a book to the list. An id is assigned automatically.

### PUT `books/{id}`
Receives an id as a url param and a JSON in the body equal to the one use in the POST endpoint, and fully replaces the book with the provided id with the data provided in the body.

### DELETE `books/{id}`
Deletes the book with the provided id.