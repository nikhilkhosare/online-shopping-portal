# online-shopping-portal
🛒 Online Shopping Portal
Full-Stack E-Commerce Web Application (Java + MySQL)

A full-stack online shopping system built using Core Java (HTTP Server), MySQL, and HTML/CSS/JavaScript.

This project demonstrates backend API development, database connectivity using JDBC, and frontend integration — simulating a basic Flipkart-style shopping platform.

📌 Overview

The Online Shopping Portal is a lightweight e-commerce web application where users can:

Browse products
Search items
Filter by category
Add/remove items from cart
View total price
Simulate payment checkout
All product data is dynamically fetched from a MySQL database using a custom-built Java HTTP server.

🏗 Architecture
Frontend (HTML, CSS, JS)
        ↓
Java HTTP Server (Port 8080)
        ↓
JDBC Connection
        ↓
MySQL Database
🚀 Features
🛍 Product Management
Dynamic product listing from database
Category filtering
Search functionality
Product rating & stock display

🛒 Cart System

Add to cart
Remove from cart
Live cart counter
Total price calculation
Checkout simulation

⚙ Backend

REST-style API endpoint (/products)

JSON response generation

JDBC connectivity

UTF-8 response handling

🛠 Tech Stack
Layer	Technology
Backend	Core Java (HttpServer)
Database	MySQL
Frontend	HTML, CSS, JavaScript
Connectivity	JDBC (MySQL Connector J 9.6.0)
Server Port	8080

📂 Project Structure
FINAL_Online_Shopping_Portal/
│
├── OnlineShoppingServer.java
├── mysql-connector-j-9.6.0.jar
├── index.html
├── script.js
├── styles.css
├── database.sql
└── README.md

⚙️ Installation & Setup
1️⃣ Prerequisites

Java JDK 17+

MySQL Server

MySQL Workbench

VS Code (recommended)

2️⃣ Database Setup

Run the following SQL:

CREATE DATABASE shopping_portal;
USE shopping_portal;

CREATE TABLE products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    category VARCHAR(100),
    price DOUBLE,
    rating DOUBLE,
    stock INT
);

Insert sample data or import CSV dataset.

3️⃣ Compile Backend
javac -cp ".;mysql-connector-j-9.6.0.jar" OnlineShoppingServer.java
4️⃣ Run Server
java -cp ".;mysql-connector-j-9.6.0.jar" OnlineShoppingServer
5️⃣ Access Application

Open browser:

http://localhost:8080

🎯 Key Learning Highlights

Building REST APIs using Core Java

JDBC database connectivity

JSON response creation manually

Frontend–Backend integration

Handling CORS & UTF-8 encoding

Full-stack project workflow

📈 Future Enhancements

User Authentication System

Admin Dashboard

Order Management System

Cart stored in Database

Product Image Upload

Pagination & Sorting

Payment Gateway Integration

Migration to Spring Boot

Deployment to Cloud (Render / Railway / AWS)

👨‍💻 Developer

Nikhil Khosare

📜 License

This project is for educational and portfolio purposes.
