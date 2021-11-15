CREATE DATABASE to_do_app;
USE to_do_app;
CREATE TABLE to_do
(
    id      INT          NOT NULL,
    content VARCHAR(255) NULL,
    done    BIT(1)       NULL,
    CONSTRAINT pk_todo PRIMARY KEY (id)
);

CREATE TABLE hibernate_sequence
(
    next_val BIGINT NULL
);

INSERT INTO to_do_app.to_do (id, content, done)
VALUES (1, 'todo_1', TRUE),
       (2, 'todo_2', FALSE),
       (3, 'todo_3', TRUE);

INSERT INTO to_do_app.hibernate_sequence (next_val)
VALUES (4);