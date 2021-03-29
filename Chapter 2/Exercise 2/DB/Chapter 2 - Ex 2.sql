CREATE Database book_publishing_house;
use book_publishing_house;

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
