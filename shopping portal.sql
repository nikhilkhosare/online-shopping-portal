-- Create the database
CREATE DATABASE IF NOT EXISTS shopping_portal;
USE shopping_portal;

-- Create users table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);
-- Create products table
CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Create cart_items table
CREATE TABLE IF NOT EXISTS cart_items (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE CASCADE
);

-- Insert sample data into users table
INSERT IGNORE INTO users (username, password) VALUES 
('user1', 'pass123'), 
('user2', 'pass456');

-- Insert sample data into products table
INSERT IGNORE INTO products (name, price) VALUES 
('Laptop', 800.00), 
('Smartphone', 500.00), 
('Headphones', 50.00), 
('Keyboard', 30.00);

-- Insert sample data into cart_items table
INSERT IGNORE INTO cart_items (user_id, product_id, quantity) VALUES
(1, 1, 1),  -- User 1 added Laptop
(1, 3, 2),  -- User 1 added 2 Headphones
(2, 2, 1);  -- User 2 added Smartphone

-- Query to verify the data
SELECT * FROM users;
SELECT * FROM products;
SELECT 
    cart_items.id AS cart_item_id,
    users.username,
    products.name AS product_name,
    cart_items.quantity,
    (cart_items.quantity * products.price) AS total_price
FROM cart_items
INNER JOIN users ON cart_items.user_id = users.id
INNER JOIN products ON cart_items.product_id = products.id;
