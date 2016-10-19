CREATE TABLE message (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    message VARCHAR(1024) NOT NULL,
    createDate TIMESTAMP
);