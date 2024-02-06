CREATE DATABASE demo_jdbc;

USE demo_jdbc;

CREATE TABLE IF NOT EXISTS persons(
id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(200),
last_name VARCHAR(200)
);

DROP table persons;
SELECT * FROM persons;