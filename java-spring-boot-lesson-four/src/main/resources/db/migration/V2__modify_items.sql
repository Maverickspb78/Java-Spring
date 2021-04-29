ALTER TABLE items ADD COLUMN cost INT;

UPDATE items SET cost = id * 20;

INSERT INTO products (title, description, price)
VALUES
('MacBook(VeryBig)', 'Ultra low and Great Power', 5000),
('iPhone(VeryBig)', 'The most expensive phone by credit', 3000),
('iPad(VeryBig)', 'More size - more cost', 3500),
('iMac(VeryBig)', 'More size - more cost', 6000),
('MacBook(small)', 'Ultra low and Great Power', 2000),
('iPhone(small)', 'The most expensive phone by credit', 200),
('iPad(small)', 'More size - more cost', 500),
('iMac(small)', 'More size - more cost', 3000),
('MacBook(medium)', 'Ultra low and Great Power', 3000),
('iPhone(medium)', 'The most expensive phone by credit', 1000),
('iPad(medium)', 'More size - more cost', 1500),
('iMac(medium)', 'More size - more cost', 4000),
('MacBook(Big)', 'Ultra low and Great Power', 3500),
('iPhone(Big)', 'The most expensive phone by credit', 1500),
('iPad(Big)', 'More size - more cost', 2000),
('iMac(Big)', 'More size - more cost', 4500);