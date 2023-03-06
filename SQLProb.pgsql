
-- create customer table 
CREATE TABLE customer(
    c_id BIGSERIAL NOT NULL PRIMARY KEY,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50),
    age INT,
    country VARCHAR(10) NOT NULL
);

-- create orders table
CREATE TABLE orders (
    order_id BIGSERIAL NOT NULL PRIMARY KEY,
    product VARCHAR(50) NOT NULL,
    total INT NOT NULL,
    c_id BIGINT REFERENCES Customer(c_id) NOT NULL
)

-- print the contents of the table
select * from orders;
select * from customer;

-- insert values into customer table
INSERT INTO customer(fname, lname, age, country)
VALUES('Ram', 'A', 25, 'IND');
INSERT INTO customer(fname, age, country)
VALUES('Bob', 19, 'US');
INSERT INTO customer(fname, lname, age, country)
VALUES('alice', 'P', 20, 'UK');

-- insert values into orders table
INSERT INTO orders(product, total, c_id)
VALUES ('Bread', 20, 3);
INSERT INTO orders(product, total, c_id)
VALUES ('Milk', 40, 1);
INSERT INTO orders(product, total, c_id)
VALUES ('Butter', 60, 3);

-- perform inner join
SELECT * FROM customer
JOIN orders
ON customer.c_id = orders.c_id;

-- perform left join
SELECT * FROM customer
LEFT JOIN orders
ON customer.c_id = orders.c_id;
