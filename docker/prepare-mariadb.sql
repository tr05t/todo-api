CREATE DATABASE to_do_app;
USE to_do_app;
CREATE TABLE to_do
(
    id      INT          NOT NULL,
    content VARCHAR(255) NULL,
    done    BIT(1)       NULL,
    CONSTRAINT pk_todo PRIMARY KEY (id)
);