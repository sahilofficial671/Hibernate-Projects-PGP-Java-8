CREATE Database academia_press;

use academia_press;

CREATE TABLE authors (
    id int AUTO_INCREMENT,
    firstName varchar(100) NOT NULL,
	lastName varchar(100) Default NULL,
	gender enum('Male', 'Female'),
	dob varchar(10) Default NULL,
    email varchar(80) NOT NULL,
    phone varchar(10) DEFAULT NULL,
    UNIQUE(email),
    PRIMARY KEY (id)
)

create table author_addresses(
	authorId int NOT NULL,
	line_1 varchar(100) NOT NULL,
	line_2 varchar(100) Default NULL,
	pincode MEDIUMINT(6) UNSIGNED DEFAULT NULL,
	city varchar(100) DEFAULT NULL,
	state varchar(100) DEFAULT NULL,
	country varchar(100) DEFAULT NULL,
	PRIMARY KEY (authorId),
	FOREIGN KEY (authorId) REFERENCES authors(id)
)