
CREATE DATABASE IF NOT EXISTS shopping_portal;
USE shopping_portal;

CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    price DOUBLE
);

TRUNCATE TABLE products;

INSERT INTO products (name, price) VALUES
('Gaming Laptop', 12000.00),
('iPhone 15', 99990.00),
('Bluetooth Speaker', 755.00),
('Smart Watch', 1500.00),
('Tablet', 40000.00),
('Wireless Mouse', 255.00),
('Office Chair', 1800.00),
('Monitor 24 inch', 22000.00),
('USB Pendrive 64GB', 1500.00),
('Power Bank', 3005.00),
('DSLR Camera', 88050.00),
('LED TV 42 inch', 6000.00),
('Air Conditioner', 45000.00),
('Refrigerator', 70000.00),
('Washing Machine', 15550.00),
('Microwave Oven', 2000.00),
('Ceiling Fan', 660.00),
('Water Purifier', 1400.00),
('Printer', 12000.00),
('Gaming Console', 39999.00);

SELECT * FROM products;

USE shopping_portal;
SELECT COUNT(*) FROM products;

USE shopping_portal;

