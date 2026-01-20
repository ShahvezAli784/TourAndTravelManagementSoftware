CREATE DATABASE IF NOT EXISTS travelagency;
USE travelagency;

CREATE TABLE account (
    username VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    security VARCHAR(200) NOT NULL,
    answer VARCHAR(200) NOT NULL
);

select * from account;

CREATE TABLE customer (
    username VARCHAR(50) PRIMARY KEY,
    id VARCHAR(50),
    number VARCHAR(50),
    name VARCHAR(100),
    gender VARCHAR(20),
    country VARCHAR(50),
    address VARCHAR(200),
    phone VARCHAR(20),
    email VARCHAR(100),

    CONSTRAINT fk_customer_account 
    FOREIGN KEY (username) REFERENCES account(username)
    ON DELETE CASCADE
);

CREATE TABLE bookhotel (
    username VARCHAR(50),
    hotel VARCHAR(100),
    persons INT,
    days INT,
    ac VARCHAR(20),
    food VARCHAR(20),
    id VARCHAR(50),
    number VARCHAR(50),
    phone VARCHAR(20),
    price VARCHAR(50),

    CONSTRAINT fk_bookhotel_account
    FOREIGN KEY (username) REFERENCES account(username)
    ON DELETE CASCADE
);

CREATE TABLE bookpackage (
    username VARCHAR(50),
    package VARCHAR(100),
    persons INT,
    id VARCHAR(50),
    number VARCHAR(50),
    phone VARCHAR(20),
    price VARCHAR(50),

    CONSTRAINT fk_bookpackage_account
    FOREIGN KEY (username) REFERENCES account(username)
    ON DELETE CASCADE
);
