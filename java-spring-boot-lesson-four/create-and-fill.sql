BEGIN;

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products(
    id serial PRIMARY KEY,
    name VARCHAR(255),
    price numeric(8, 2)
);

INSERT INTO products (name, price)
VALUES ('Tomato', 150),
       ('Potato', 100),
       ('Onion', 60),
       ('Cucumber', 75);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (
    id serial PRIMARY KEY,
    name VARCHAR(255)
);
INSERT INTO customers (name)
VALUES ('Superman'),
       ('Batman'),
       ('Spiderman'),
       ('Captain America');

DROP TABLE IF EXISTS purchases CASCADE;
CREATE TABLE purchases (
    customers_id int,
    FOREIGN KEY (customers_id) REFERENCES customers(id),
    product_id int,
    FOREIGN KEY (product_id) REFERENCES products(id),
    product_price numeric(8, 2)

);

INSERT INTO purchases (customers_id, product_id, product_price)
VALUES (1,1,150), (1,4,75), (2,2,100), (2,3,60), (3,3,60), (4,4,75);

