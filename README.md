# Expedia Hotel API

This project provides an API endpoint to query hotels in rating descending order. It uses a MySQL database to store hotel and review data, and exposes a RESTful API endpoint using the JAX-RS specification.

## Getting Started

### Prerequisites

To build and run this project, you'll need:

- JDK 8 or higher (It was tested with JDK 16)
- Apache Maven
- MySQL server

### Installation

1. Clone this repository to your local machine.
2. Create a new MySQL database called `expedia`.
3. Create the `location`, `review` and `hotel` tables in the `expedia` database by executing the SQL script located at `expedia-domain/src/main/resources/create_tables.sql`.
4. Build the project by running the following command in the project root directory:

    ```
    mvn clean install
    ```

5. Start the application by running the following command:

    ```
    mvn spring-boot:run
    ```
NOTE: The database configuration is in the following file: expedia-endpoints/src/main/resources/application.properties

## API Endpoint

The API endpoint for querying hotels is located at `/expedia-endpoints/hotels`. It accepts HTTP GET requests and returns a JSON array of hotels sorted by rating in descending order.

### Example Request

```
GET /expedia-endpoints/hotels HTTP/1.1
Host: localhost:8080
Content-Type: application/json
```

### Example Response

```
HTTP/1.1 200 OK
Content-Type: application/json

[
  {
    "id": "2",
    "name": "Gran Via Hotel",
    "description": "A luxurious hotel close to Gran Via",
    "location": {
      "id": "3",
      "name": "London"
    },
    "totalPrice": 250,
    "image": "https://example.com/hotel_002.jpg",
    "reviews": [
      {
        "id": "2",
        "rating": 4.9,
        "comment": "Great hotel with excellent service!",
        "user": "John Smith"
      }
    ]
  },
  {
    "id": "1",
    "name": "Bull Hotel",
    "description": "A luxurious hotel close to Wall Street",
    "location": {
      "id": "3",
      "name": "London"
    },
    "totalPrice": 250,
    "image": "https://example.com/hotel_001.jpg",
    "reviews": [
      {
        "id": "1",
        "rating": 4.5,
        "comment": "Great hotel with excellent service!",
        "user": "John Smith"
      }
    ]
  },
  {
    "id": "3",
    "name": "Eye Hotel",
    "description": "A luxurious hotel close to London Eye",
    "location": {
      "id": "3",
      "name": "London"
    },
    "totalPrice": 250,
    "image": "https://example.com/hotel_003.jpg",
    "reviews": [
      {
        "id": "3",
        "rating": 4.1,
        "comment": "Great hotel with excellent service!",
        "user": "John Smith"
      }
    ]
  }
]
```
