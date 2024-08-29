CREATE DATABASE disney_database;

USE disney_database;

CREATE TABLE productions (
	id INT AUTO_INCREMENT PRIMARY KEY,
    image LONGBLOB,
    title VARCHAR(50),
    creation_date DATE,
    score VARCHAR(5)
);

CREATE TABLE characters (
	id INT AUTO_INCREMENT PRIMARY KEY,
    image LONGBLOB,
    char_name VARCHAR(50),
    age INT,
    weight FLOAT(7,2),
    history MEDIUMTEXT
);

CREATE TABLE char_prod (
	id INT AUTO_INCREMENT PRIMARY KEY,
	character_id INT,
    producction_id INT
);