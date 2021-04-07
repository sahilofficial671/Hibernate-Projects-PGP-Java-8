CREATE Database TechBook;

CREATE TABLE books (
	id int AUTO_INCREMENT NOT NULL,
    name varchar(100) NOT NULL,
	author varchar(100) NOT NULL,
	edition varchar(100) NOT NULL,
	category enum('course', 'fiction', 'non_fiction')
	publisher varchar(100) NOT NULL,
	publishingYear tinyint NOT NULL,
	price int not null,
	quantity int not null,
    PRIMARY KEY (id)
)
CREATE TABLE student_books (
	bookId int NOT NULL,
	bookName varchar(100) NOT NULL,
	studentId int NOT NULL,
	studentName varchar(100) NOT NULL,
	issuedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
	returnedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    updatedAt DATETIME ON UPDATE CURRENT_TIMESTAMP
)
