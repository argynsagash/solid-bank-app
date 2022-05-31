-- resources/schema.sql
CREATE TABLE Student (
                         id IDENTITY NOT NULL PRIMARY KEY,
                         first_name TEXT,
                         last_name TEXT,
                         email TEXT
);

-- resources/data.sql
INSERT INTO Student (first_name, last_name, email) values ('a', 'b', 'w@a.com'), ('s', 's', 'w2@a.com');