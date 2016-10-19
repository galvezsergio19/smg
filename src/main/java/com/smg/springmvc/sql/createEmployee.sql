CREATE TABLE EMPLOYEE(
    id SERIAL PRIMARY KEY, 
    full_name VARCHAR(250) NOT NULL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(15) NOT NULL,
    register_date TIMESTAMP,
    last_logon_date TIMESTAMP
);