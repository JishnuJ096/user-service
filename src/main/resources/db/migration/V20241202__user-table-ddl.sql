CREATE TABLE user(
    id int NOT NULL AUTO_INCREMENT,
    first_name varchar(45) NOT NULL,
    last_name varchar(45) NOT NULL,
    date_of_birth date,
    email varchar(256) NOT NULL,
    password varchar(45) NOT NULL,
    roles varchar(256),
    country varchar(255),
    district varchar(255),
    houseNumber varchar(255),
    locality varchar(255),
    pin bigint,
    state varchar(255),
    PRIMARY KEY (id)
);