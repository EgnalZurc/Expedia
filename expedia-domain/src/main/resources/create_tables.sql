CREATE TABLE location
(
    id   VARCHAR(36) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    date DATE         NOT NULL
);

CREATE TABLE review
(
    id       VARCHAR(36) PRIMARY KEY,
    rating   FLOAT        NOT NULL,
    comment  VARCHAR(500) NOT NULL,
    user     VARCHAR(100) NOT NULL,
    date     DATE         NOT NULL,
    hotel_id VARCHAR(36)  NOT NULL,
    FOREIGN KEY (hotel_id) REFERENCES hotel (id)
);

CREATE TABLE hotel
(
    id                    VARCHAR(36) PRIMARY KEY,
    name                  VARCHAR(100) NOT NULL,
    description           VARCHAR(500) NOT NULL,
    totalPrice            FLOAT        NOT NULL,
    image                 VARCHAR(500) NOT NULL,
    swimmingPoolAvailable BOOLEAN      NOT NULL,
    location_id           VARCHAR(36)  NOT NULL,
    FOREIGN KEY (location_id) REFERENCES location (id)
);