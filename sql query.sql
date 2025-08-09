
CREATE DATABASE reservation_db;


USE reservation_db;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

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

INSERT INTO users (username, password) VALUES ('testuser', 'testpass');
SELECT * FROM users;
