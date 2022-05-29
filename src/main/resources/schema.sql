SET
MODE MYSQL;

DROP TABLE IF EXISTS movie;

CREATE TABLE movie
(
    movieName   varchar(30) PRIMARY KEY,
    hero        varchar(30) NULL,
    release     varchar(30) NULL,
    likes       NUMERIC(30) NULL
);





