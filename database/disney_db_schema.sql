CREATE DATABASE disney_database; -- Create a database to store the project's data

USE disney_database;

-- Create the `characters` table to store character information
CREATE TABLE characters (
    characterId BIGINT AUTO_INCREMENT PRIMARY KEY, -- Primary key, auto-incremented
    image VARCHAR(255), -- Store image URL
    charName VARCHAR(255), -- Name of the character
    age INT, -- Age of the character
    weight FLOAT, -- Weight of the character
    history TEXT -- History or background information about the character
);

-- Create the `Production` table to store production information
CREATE TABLE Production (
    productionId BIGINT AUTO_INCREMENT PRIMARY KEY, -- Primary key, auto-incremented
	image VARCHAR(255), -- Store image URL
    title VARCHAR(255), -- Title of the production
    cration_date DATE, -- Creation date of the production
    score INT -- Score or rating of the production

);

-- Create the `character_production` table to manage the many-to-many relationship between characters and productions
CREATE TABLE character_production (
    characterId BIGINT, -- Foreign key referring to `characters` table
    productionId BIGINT, -- Foreign key referring to `Production` table
    PRIMARY KEY (characterId, productionId), -- Composite primary key for the join table
    FOREIGN KEY (characterId) REFERENCES characters(characterId), -- Foreign key constraint for `characterId`
    FOREIGN KEY (productionId) REFERENCES Production(productionId) -- Foreign key constraint for `productionId`
);