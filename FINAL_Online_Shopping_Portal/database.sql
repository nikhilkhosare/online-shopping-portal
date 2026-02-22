
CREATE DATABASE IF NOT EXISTS shopping_portal;
USE shopping_portal;

CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE
);

TRUNCATE TABLE products;

INSERT INTO products (name, price) VALUES
('Gaming Laptop', 1200.00),
('iPhone 15', 999.00),
('Bluetooth Speaker', 75.00),
('Smart Watch', 150.00),
('Tablet', 400.00),
('Wireless Mouse', 25.00),
('Office Chair', 180.00),
('Monitor 24 inch', 220.00),
('USB Pendrive 64GB', 15.00),
('Power Bank', 35.00),
('DSLR Camera', 850.00),
('LED TV 42 inch', 600.00),
('Air Conditioner', 450.00),
('Refrigerator', 700.00),
('Washing Machine', 500.00),
('Microwave Oven', 200.00),
('Ceiling Fan', 60.00),
('Water Purifier', 140.00),
('Printer', 120.00),
('Gaming Console', 399.00);

SELECT * FROM products;

USE shopping_portal;
SELECT COUNT(*) FROM products;

USE shopping_portal;

