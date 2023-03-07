
-- Create product table
CREATE TABLE product(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price INT NOT NULL
);

-- Create orders table
CREATE TABLE orders(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    status VARCHAR(50) NOT NULL,
    orderDate DATE NOT NULL,
    delivaryDate DATE NOT NULL,
    customerName VARCHAR(50) NOT NULL,
    productId BIGINT REFERENCES product(id)
);

-- Insert few entries into the table
INSERT INTO product(name, category, price) VALUES ('book1', 'Books', 100);
INSERT INTO product(name, category, price) VALUES ('book2', 'Books', 200);
INSERT INTO product(name, category, price) VALUES ('toy1', 'Toys', 50);
INSERT INTO product(name, category, price) VALUES ('toy2', 'Toys', 25);
INSERT INTO product(name, category, price) VALUES ('prod1', 'Baby', 75);
INSERT INTO product(name, category, price) VALUES ('prod2', 'Baby', 150);

INSERT INTO orders(status, orderDate, delivaryDate, customerName, productId) VALUES ('delivered', DATE '2021-02-05', DATE '2021-05-09', 'c1', 1);
INSERT INTO orders(status, orderDate, delivaryDate, customerName, productId) VALUES ('shipped', DATE '2021-09-09', DATE '2021-10-09', 'c2', 5);
INSERT INTO orders(status, orderDate, delivaryDate, customerName, productId) VALUES ('delivered', DATE '2021-01-05', DATE '2021-05-09', 'c3', 3);
INSERT INTO orders(status, orderDate, delivaryDate, customerName, productId) VALUES ('delivered', DATE '2021-04-01', DATE '2021-05-09', 'c1', 2);
INSERT INTO orders(status, orderDate, delivaryDate, customerName, productId) VALUES ('delivered', DATE '2021-03-05', DATE '2021-05-09', 'c6', 6);
INSERT INTO orders(status, orderDate, delivaryDate, customerName, productId) VALUES ('delivered', DATE '2021-10-25', DATE '2021-05-09', 'c5', 4);

-- List of products of category books and price > 100;
SELECT *
FROM product
WHERE category = 'Books'
AND price > 100;

-- List of orders with products belong to 'Baby' category
SELECT *
FROM orders
JOIN product
ON product.id = orders.productId
WHERE product.category = 'Baby';

-- List products with category = 'Toys' and apply 10% discount on it
Select
    name,
    price, (price * 0.1) AS Discount,
    price-(price * 0.1) AS discountedPrice
FROM product
WHERE category = 'Toys';

-- List of products ordered between 01-Feb-2021 and 01-Apr-2021
SELECT *
FROM orders
WHERE orderDate
BETWEEN DATE '2021-02-01' AND '2021-04-01';

-- get cheapest products of 'Books' category
SELECT id, name, price
FROM product
ORDER BY price ASC
LIMIT 5;