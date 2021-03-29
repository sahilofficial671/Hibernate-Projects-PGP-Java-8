CREATE Database book_publishing_house;
use book_publishing_house;

CREATE TABLE books (
	id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
	authorId int NOT NULL,
	edition varchar(100) NOT NULL,
	category enum('technical', 'novel', 'history', 'science')
	publisher varchar(100) NOT NULL,
	publishingYear int NOT NULL,
	price int not null,
	quantity int not null,
)

insert into books (name, authorId, edition, category, publisherm publishingYear, price, quantity) values ("Twilight Saga", 1, "2.0", "science", "Sahil Bhatia", 2021, 1000, 12)
insert into books (name, authorId, edition, category, publisherm publishingYear, price, quantity) values ("Breaking Bad", 1, "2.0", "science", "Sahil Bhatia", 2021, 1000, 12)

CREATE TABLE author (
    id int AUTO_INCREMENT PRIMARY KEY,
    name varchar(100) NOT NULL,
    email varchar(80) NOT NULL,
    phone int DEFAULT NULL,
    age TINYINT DEFAULT NULL,
    UNIQUE(email),
)
