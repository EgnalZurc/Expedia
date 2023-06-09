CREATE TABLE location
(
    id   VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
);

CREATE TABLE hotel
(
    id                      VARCHAR(36) PRIMARY KEY,
    name                    VARCHAR(100) NOT NULL,
    description             VARCHAR(500) NOT NULL,
    total_price             FLOAT        NOT NULL,
    image                   VARCHAR(500) NOT NULL,
    location_id             VARCHAR(36)  NOT NULL,
    checkin_date            DATE         NOT NULL,
    checkout_date           DATE         NOT NULL,
    FOREIGN KEY (location_id) REFERENCES location (id)
);

CREATE TABLE review
(
    id       VARCHAR(36) PRIMARY KEY,
    rating   FLOAT        NOT NULL,
    comment  VARCHAR(500) NOT NULL,
    user     VARCHAR(100) NOT NULL,
    hotel_id VARCHAR(36)  NOT NULL,
    FOREIGN KEY (hotel_id) REFERENCES hotel (id)
);