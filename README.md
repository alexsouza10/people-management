# Project Management People API

The Project Management People API is a RESTful service built with Spring Boot that allows for managing people and their addresses. It follows SOLID principles and provides endpoints for CRUD operations on people and their addresses.

## Features

- CRUD operations for managing people
- CRUD operations for managing addresses associated with people
- Setting a primary address for a person
- Retrieving a list of people and their addresses

## Prerequisites

Before running this project, make sure you have the following installed:

- Java Development Kit (JDK) 11 or higher
- Apache Maven
- PostgreSQL (optional, if you want to use a database)

## Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/alexsouza10/people-management.git
   ```

2. **Navigate to the project directory:**

   ```bash
   cd people-management-project
   ```

3. **Build the project using Maven:**

   ```bash
   mvn clean install
   ```

4. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

The application will start and be accessible at `http://localhost:8080`.

## Endpoints

The following endpoints are available:

- `POST /api/people`: Create a new person
- `PUT /api/people/{id}`: Update an existing person
- `GET /api/people`: Get a list of all people
- `GET /api/people/{id}`: Get details of a specific person
- `DELETE /api/people/{id}`: Delete a person
- `POST /api/people/{id}/addresses`: Add a new address for a person
- `PUT /api/people/{id}/addresses/{addressId}`: Update an existing address for a person
- `GET /api/people/{id}/addresses`: Get a list of all addresses for a person
- `DELETE /api/people/{id}/addresses/{addressId}`: Delete an address for a person
- `PUT /api/people/{id}/addresses/{addressId}/primary`: Set an address as primary for a person

## Usage

You can interact with the API using any HTTP client, such as cURL, Postman, or HTTPie. Here are some example requests:

1. **Create a new person:**

   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"fullName":"John Doe","dateOfBirth":"1990-01-01"}' http://localhost:8080/api/people
   ```

2. **Add an address for a person:**

   ```bash
   curl -X POST -H "Content-Type: application/json" -d '{"street":"123 Main St","zipCode":"12345","number":10,"city":"New York","state":"NY"}' http://localhost:8080/api/people/{personId}/addresses
   ```

3. **Get details of a person:**

   ```bash
   curl http://localhost:8080/api/people/{personId}
   ```

4. **Update an existing person:**

   ```bash
   curl -X PUT -H "Content-Type: application/json" -d '{"fullName":"Jane Doe","dateOfBirth":"1995-01-01"}' http://localhost:8080/api/people/{personId}
   ```

## Testing

Unit tests are included in the project to ensure its correctness. You can run the tests using Maven:

```bash
mvn test
```

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these guidelines:

1. Fork the repository
2. Create a new branch (`git checkout -b feature/yourfeature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/yourfeature`)
5. Create a new Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
