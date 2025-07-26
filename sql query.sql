-- STEP 1: Create the database
CREATE DATABASE reservation_db;

-- STEP 2: Use the new database
USE reservation_db;

-- STEP 3: Create the users table
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

-- STEP 4: Create the reservations table
CREATE TABLE reservations (
    pnr INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    train_no VARCHAR(10),
    train_name VARCHAR(100),
    class_type VARCHAR(20),
    doj DATE,
    from_station VARCHAR(50),
    to_station VARCHAR(50),
    booked_on TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- STEP 5: Insert a test user
INSERT INTO users (username, password) VALUES ('testuser', 'testpass');
SELECT * FROM users;
