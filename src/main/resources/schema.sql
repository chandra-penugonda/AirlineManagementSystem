CREATE TABLE airport (
    id number not null auto_increment,
    code varchar(10) not null,
    name varchar(100) not null,
    location varchar,
    PRIMARY KEY (id)
);