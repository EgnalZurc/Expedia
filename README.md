# Expedia Hotel API

This project provides an API endpoint to query hotels in rating descending order. It uses a MySQL database to store hotel and review data, and exposes a RESTful API endpoint using the JAX-RS specification.

## Getting Started

### Prerequisites

To build and run this project, you'll need:

- JDK 8 or higher
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
    mvn jetty:run
    ```
NOTE: In this version of the app the database connection is not configurable, it's expected the database to be created on localhost, port 3306 with username "user", paswsword "password"

## API Endpoint

The API endpoint for querying hotels is located at `/expedia-endpoints/hotel`. It accepts HTTP GET requests and returns a JSON array of hotels sorted by rating in descending order.

### Example Request

```
GET /expedia-endpoints/hotel HTTP/1.1
Host: localhost:8080
Content-Type: application/json
```

### Example Response

```
HTTP/1.1 200 OK
Content-Type: application/json

[
  {
    "id": 1,
    "name": "Hotel A",
    "address": "123 Main St",
    "reviews": [
      {
        "id": 1,
        "rating": 4.5,
        "comment": "Great hotel"
      },
      {
        "id": 2,
        "rating": 3.5,
        "comment": "Decent hotel"
      }
    ]
  },
  {
    "id": 2,
    "name": "Hotel B",
    "address": "456 Oak St",
    "reviews": [
      {
        "id": 3,
        "rating": 5,
        "comment": "Amazing hotel"
      },
      {
        "id": 4,
        "rating": 4,
        "comment": "Nice hotel"
      }
    ]
  }
]
```
