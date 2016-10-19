CREATE TABLE todolist (
    id SERIAL PRIMARY KEY,
    orderid int,
    title VARCHAR(250) NOT NULL,
    create_date TIMESTAMP,
    due_date TIMESTAMP,
    priority int,
    status int,
    username VARCHAR(50)
);