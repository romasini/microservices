CREATE TABLE products (
    id bigserial PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    price INT
    );
INSERT INTO products (title, price)
VALUES
('Prod 1', 100),
('Prod 2', 200),
('Prod 3', 300),
('Prod 4', 400),
('Prod 5', 500);