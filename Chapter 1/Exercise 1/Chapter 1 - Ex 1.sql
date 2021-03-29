CREATE Database TechBook;

CREATE TABLE books (
	id int AUTO_INCREMENT NOT NULL,
    name varchar(100) NOT NULL,
	author varchar(100) NOT NULL,
	edition varchar(100) NOT NULL,
	category enum('technical', 'novel', 'history', 'science')
	publisher varchar(100) NOT NULL,
	publishingYear tinyint NOT NULL,
	price int not null,
	quantity int not null,
    PRIMARY KEY (id)
)

CREATE TABLE customers (
    id int AUTO_INCREMENT NOT NULL,
    name varchar(100) NOT NULL,
    email varchar(80) NOT NULL,
    phone int DEFAULT NULL,
    age TINYINT DEFAULT NULL,
    UNIQUE(id, email),
    PRIMARY KEY (id)
)
