CREATE Database new_tech_book_store;

use new_tech_book_store;

CREATE TABLE customers (
    id int AUTO_INCREMENT,
	userName varchar(20) NOT NULL,
    firstName varchar(100) NOT NULL,
	lastName varchar(100) Default NULL,
	gender enum('Male', 'Female'),
	dob varchar(10) Default NULL,
    email varchar(80) NOT NULL,
    phone varchar(10) DEFAULT NULL,
	password varchar(25) NOT NULL,
    UNIQUE(email, userName),
    PRIMARY KEY (id)
)

create table addresses(
	customerId int NOT NULL,
	line_1 varchar(100) NOT NULL,
	line_2 varchar(100) Default NULL,
	pincode MEDIUMINT(6) UNSIGNED DEFAULT NULL,
	city varchar(100) DEFAULT NULL,
	state varchar(100) DEFAULT NULL,
	country varchar(100) DEFAULT NULL,
	PRIMARY KEY (customerId),
	FOREIGN KEY (customerId) REFERENCES customers(id)
)

CREATE TABLE books (
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
	authorId int NOT NULL,
	edition varchar(100) NOT NULL,
	category enum('technical', 'novel', 'history', 'science'),
	publisher varchar(100) NOT NULL,
	publishingYear int NOT NULL,
	price int not null,
	quantity int not null
)

CREATE TABLE author (
    id int AUTO_INCREMENT,
    name varchar(100) NOT NULL,
    email varchar(80) NOT NULL,
    phone varchar(12) DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE(email, userName),
    FOREIGN KEY (id) REFERENCES books(authorId)
)

