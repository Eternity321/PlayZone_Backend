CREATE TABLE users
(
    id         UUID PRIMARY KEY,
    email      VARCHAR(255) NOT NULL,
    phone      VARCHAR(50),
    first_name VARCHAR(100),
    last_name  VARCHAR(100)
);
