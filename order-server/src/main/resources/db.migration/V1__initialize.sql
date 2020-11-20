CREATE TABLE orders (
    id bigserial PRIMARY KEY,
    customer_name VARCHAR(255),
    customer_phone VARCHAR(255),
    customer_address VARCHAR(255) ,
    price INT);

CREATE TABLE order_items (
    id bigserial PRIMARY KEY,
    product_id bigint,
    order_id bigint REFERENCES orders(id),
    quantity INT,
    price INT);