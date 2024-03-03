CREATE TABLE user(
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(45) NOT NULL,
    last_name varchar(45) NOT NULL,
    date_of_birth date,
    address json not null,
    email varchar(256) NOT NULL,
    password varchar(45) NOT NULL,
    PRIMARY KEY (id)
);