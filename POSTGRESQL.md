# PostgreSQL

### Setting up
- Make sure the server is running
```
sudo systemctl start postgresql
sudo systemctl enable postgresql
```

- Login as Postgres user and run psql
```
sudo su - postgres
psql

psql --help :for help
```

### Creating user and database
```
CREATE DATABASE test;
> \l - list all databases

# creating user and database in psql prompt
> CREATE USER <username> WITH PASSWORD '<password>';
> CREATE DATABASE <databaseName> WITH OWNER <ownername>;

# as postgres user without entering psql
createuser --help
createuser -P <username> : prompts to enter password for the user
createdb <dbName> -O <ownerName>
```

### Connecting to the database
```
# In normal shell
psql -h <host ip> -p <portNumber> -U <username> <databaseName>
psql -h 127.0.0.1 -U <userName> <databasename>
psql -h localhost -p 5432 -U <userName> <databaseName>

# from within the psql shell
> \c <databaseName> - switch between databases with same current user
```

## Database Operations

## Notes
```
- \c <databaseName> - switch between databases with same current user
- \l - list all databases
- \d : describe(lists all tables in a database)
- \d <database> :(describes the structure of the database)
```

### Deleting a database
```
DROP DATABASE <databaseName>;
```
### Deleting a table
```
DROP TABLE <tableName>;
```

### Creating database
```
CREATE TABLE table_name (
    Column_name data_type constraints(if any)
)

CREATE TABLE person (
    id int,
    name VARCHAR(50),
    gender VARCHAR(6),
    date_of_birth date
)
```

### Constrains
- NOT
- NULL

```
# BIGSERIAL is autoincrementing data type
CREATE TABLE person (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    gender VARCHAR(7) NOT NULL,
    email VARCHAR(20)
);
```

### Inserting data
```
INSERT INTO person (
    name,
    gender,
    data_of_birth)
VALUES ('Adem', 'MALE', DATE '1999-01-09');

# (look for specifying date format also nullable email field not specified
```

### SELECT FROM
```
SELECT * FROM person;
SELECT first_name FROM person;
SELECT first_name, last_name FROM person;

```

### Order By
Sorts output in ascending or descending order

```
SELECT * FROM person ORDER BY country; <-ASCending order
SELECT * FROM person ORDER BY country DESC; <- DESCending order
```

### Distinct
Select unique entries from the output
```
SELECT DISTINCT country FROM person ORDER BY country;
```

### Where
Conditional filtering based on columns of the table

```
SELECT * FROM person WHERE gender = 'FEMALE';
SELECT * FROM person WHERE gender = 'FEMALE' AND country = 'China';
SELECT * FROM person WHERE gender = 'FEMALE' AND (country = 'China' OR country = 'Poland');
```

### Comparison Operators
```
=, >, <, >=, <=
<> - not equal
```

### Limit, Offset and Fetch

```
SELECT * FROM person LIMIT 10; <- Select first 10 persons from the table
SELECT * FROM person OFFSET 10; <- Select every person starting from index 5 ( [5:] )
SELECT * FROM person OFFSET 5 LIMIT 10; <- Select 10 people from index 5 ( [5: 15] )

# Fetch is a Sql standard, works just like limit
SELECT * FROM person FETCH FIRST 5 ROW ONLY;
similar to 
SELECT * FROM person LIMIT 5;
```

### In
Querying from a list

```
# instead of
SELECT * FROM person WHERE country = 'china'
OR country = 'Brazil'
OR country = 'France';

# using In
SELECT * FROM country WHERE country IN ('China', 'Brazil', 'France');
```

### Between
Quering within a range

```
SELECT * FROM person
WHERE date_of_birth 
BETWEEN DATE '2000-01-01' AND '2015-01-01'; 
```

### Like and iLike
pattern matching

```
SELECT * FROM person
WHERE email 
LIKE '%.com'; <- % is wildcard character(emails ending with .com)

LIKE '%@google.%'; <- starting with anything followed by '@google.' ending with anything

# '_' specifies single character
LIKE '_______@%'; <- starting with 7 characters followed by '@' ending with anything
```

'ILike' is case insensitive unlike 'like'

### Group By
Groups people based on a column

```
# reeturns unique countries
SELECT country FROM person
GROUP BY country;

# returns countries and count of occurance of each country
SELECT country, COUNT(*) FROM person
GROUP BY country;
```

### Group By Having
- Filtering after group by
- Followed by an Aggrigate function

```
# Output of groupBy command with countries having atleast 6 people
SELECT country, COUNT(*) FROM person
GROUP BY country
HAVING COUNT(*) > 5;
```

### MIN, MAX, Average, SUM
```
SELECT MAX(price) FROM car;
SELECT MIN(price) FROM car;
SELECT AVG(price) FROM car;
SELECT SUM(price) FROM car;

SELECT make, model, MIN(price), MAX(price), AVG(price) FROM car
GROUP BY make;
```

### Arithmetic operations

```
SELECT 10 + 2;
SELECT 10 - 2;
SELECT 10 * 2;
SELECT 10 / 2;
SELECT 10^2;    // power
SELECT 5!;      // factorial
SELECT 10 % 2;  // modulo

# round half the price of each entry to 2 places
SELECT id, make, model , price, ROUND(price * 0.5, 2)
FROM car;
```

### Alias (AS)
give name to the column name
```
SELECT id, make, model , price, ROUND(price * 0.5, 2) AS new_price
FROM car;
```

## Handling nulls

### Coalesce
allows to have default value
Function returns the first non Null value from the parameters
```
SELECT COALESCE(1) AS number; -> op: 1
SELECT COALESCE(null, 1) AS number; -> op: 1
SELECT COALESCE(null, null, 1, 10) AS number; -> op: 1

# returns emails and 'noMail' if email is null
SELECT COALESCE(email, 'noMail') FROM person;
```

### Nullif
takes two args a, b. Returns a if a != b or returns null
```
SELECT NULLIF(2, 9) -> returns 2
SELECT NULLIF(2, 2) -> returns null

# prevention of divide by zero
SELECT 10/null -> returns null
SELECT 10 / NULLIF(var, 0) -> returns null if var is 0
```

### Droping/adding constraints
```
ALTER TABLE person DROP CONSTRAINT <constraint>;
note: constraint is obtained with \d <table name>

# Drop primary key constraint on key
ALTER TABLE person DROP CONSTRAINT person_pkey;

# Adding the constraint back
# works if all the id data are unique
ALTER TABLE person ADD PRIMARY KEY(<column_name>);
ALTER TABLE person ADD PRIMARY KEY(id);
```

### Unique constraint
primary keys are used to identify a record in the table
while unique constraint is used to maintain unique records

```
ALTER TABLE person ADD CONSTRAINT <constraint_name> UNIQUE(<constraint field>);
ALTER TABLE person ADD CONSTRAINT unique_email_address UNIQUE(email);

# or 
ALTER TABLE person ADD UNIQUE(email);    <- postgres defines the name

# Droping
ALTER TABLE person DROP <constrant name(obtained by \d <table_name>)>
```

### DISTINCT
returns distinct output from the query
```
SELECT DISTINCT name FROM person;
```

### Check constraint
Checks if the value matches an expression before inserting

```
# allow only 'Male' and 'Female' values to the gender field
ALTER TABLE person ADD CONSTRAINT gender_constraint CHECK(gender = 'Female' OR gender = 'Male');

# or let postgres assign name to the constraint
ALTER TABLE person ADD CHECK(gender = 'Female' OR gender = 'Male');
```

### DELETEing Records
```
# delete all the entries
DELETE FROM person;

DELETE FROM person WHERE id = 1;
```

### UPDATEing Records
```
UPDATE person SET email = 'hello@123.com' WHERE id = 5;

# update multiple entries
UPDATE person SET first_name = 'Mini', last_name = 'Mouse', email = 'minimouse@clubhouse.com' 
WHERE id = 7;
```

### On conflict, do nothing
on confilict can only be used on fields with unique or exclusive constraints like primary key

```
(...)
ON CONFLICT (conflicting field) DO NOTHING;

INSERT INTO person (id, name)
VALUES (3, 'PINK')
ON CONFLICT (id) DO NOTHING;
```

### Do Update
when a conflict happens, update the desired fields with the new ones
ex, consider a user submitting their details twice... id would be same for both the queries
but we'd like to update other fields with new ones

```
# if id already exists, the entry is updated with new data

INSERT INTO person(id, first_name, last_name, email)
VALUES(9, 'micky', 'mouse', 'micky@mouse.com)
ON CONFLICT (id) DO UPDATE SET email = EXCLUDED.mail,
first_name = EXCLUDED.first_name, last_name = EXCLUDED.last_name;

# EXCLUDED.data is the new data from the query
```

## Foreign key and joins

### Foreign key
A key in the current table which references the primary key of other table.

```
car_id BIGINT REFERENCES id(car)

# example
create table car(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    ...
)
create table person(
    id BIGSERIAL NOT NULL PRIMARY KEY,
    first_name varchar(20) not null,
    ...
    car_id BIGINT REFERENCES id(car),
    UNIQUE(car_id)
);

```

## Joins

### INNER Join
Joins the records present in both the tables ie, in the actual table and the other table
as foreign key

```
SELECT * FROM <tableA>
JOIN <tableB> ON <columns to use for join>;

SELECT * FROM person
JOIN car ON person.car_id = car.id;

# get few columns from the tables
SELECT person.first_name, car.make, car.model, car.price
FROM person
JOIN car ON person.car_id = car.id;
```

### LEFT Join
Joins the records with common relation between two tables and every record of first table

```
SELECT * FROM <tableA>
LEFT JOIN <tableB> ON <columns to use for join>;

SELECT * FROM person
LEFT JOIN car ON person.car_id = car.id;

```

### Deleting Records with Foreign Keys
Deleting an entry which is references by a foreign key in other table doesnt work
In order to delete such entry, all the references to the current entry must be removed
either by deleting all the entries that reference it or updating all the fodbuserdb=> update bikeowner set bike_id = NULL where bike_id = 4;reign key values to other value

```
dbuserdb=> select * from bike;dbuserdb=> update bikeowner set bike_id = NULL where bike_id = 4;
 id |   make    |   model    |  price   
----+-----------+------------+----------
  2 | Pontiac   | Grand Prix | 13136.48
  4 | Ford      | F-Series   | 11707.60

dbuserdb=> select * from bikeowner;
 id | first_name | last_name | gender | bike_id 
----+------------+-----------+--------+---------
  1 | Camellia   | Gilli     | Female |       2
  3 | Berkeley   | Lawling   | Male   |       4

dbuserdb=> Delete from bike where id = 4;
ERROR:  update or delete on table "bike" violates foreign key constraint "bikeowner_bike_id_fkey" on table "bikeowner"
DETAIL:  Key (id)=(4) is still referenced from table "bikeowner".

# TO delete
dbuserdb=> update bikeowner set bike_id = NULL where bike_id = 4;
dbuserdb=> Delete from bike where id = 4;
```

## Importing data as CSV

```
\copy (<SQL query>) TO '<path to output file>' DELIMITER ',' CSV HEADER
```

## Serial and Sequences
Sequence tables define the next value of the autoincrementing types like BIGSERIAL

```
# reset the sequence value to new value
ALTER SEQUENCE <sequence_name> RESTART WITH <new value>
```

## Extensions

```
# see available extensions
SELECT * FROM pg_available_extensions;
```


## Timestamps and Dates

```
SELECT NOW(); <- gives timestamp
SELECT NOW()::DATE; <- cast to date(returns date)
SELECT NOW()::TIME(); <- cast to time(returns time)

```

Data types for data and time
- timestamp
- date
- time
- interval

### Adding and subtracting time
```
# Subtract 1 year from now
SELECT NOW() - INTERVAL '1 YEAR'; 

# add 10 months from now
SELECT NOW() + INTERVAL '1 MONTHS'; 

# can be casted to date
SELECT (NOW() + INTERVAL '1 MONTHS')::DATE; 
```

### Extract
get specific field from the timestamp

```
SELECT EXTRACT(YEAR FROM NOW())
SELECT EXTRACT(MONTH FROM NOW())
SELECT EXTRACT(DAY FROM NOW())
SELECT EXTRACT(DOW FROM NOW()) <- Day of the week
SELECT EXTRACT(CENTUARY FROM NOW())
```

### Age
```
AGE(NOW(), <reference date>)

Select date_of_birth, AGE(NOW(), date_of_birth) AS age FROM person;
```

## Indexing
Used to reduce the access time of a query

### Analyze
```
EXPLAIN ANALYZE <query>;

EXPLAIN ANALYZE SELECT id FROM person WHERE id = 20;
```

### Indexing need
```
# BAD queries

# since unlike id, name is not indexed, it takes longer to search the entire table
SELECT * FROM mytable WHERE name = 'NAME';
SELECT * FROM mytable WHERE name like '%NAME%';
```

### Creating index
```
CREATE INDEX <index name> ON <TableName>(<columnName>);

CREATE INDEX employees_name on employees(name);
DROP INDEX <index_name>;
```

This doesnt help `SELECT * FROM mytable WHERE name like '%NAME%';` and still need sequential search;


## Normalization and normal forms

### First Normal Form 1NF
- Remove repeating groups of data
- create saperate tables for each group of related data
- each table should have a primary key.

### Second Normal Form 2NF
- remove data that doesnt depend on the table's primary key(move to appropriate table or create new one)
- Foreign keys are used to identify table relationships

### Third Normal Form 3NF
- Remove attributes that rely on other non-key attributes (i.e. remove columns that depend on columns that aren’t foreign or primary keys)

## Combining Queries

### UNION and UNION ALL
Used to combine the results of two or more `SELECT` statements
- Every select statement in union must have same number of columns and similar datatypes and in similar order

Union selects only distinct values by default. `UNION ALL` allows duplicate values as well.

```
SELECT * FROM table1
UNION
SELECT * FROM table2;

SELECT * FROM table1
UNION ALL
SELECT * FROM table2;
```

### INTERSECT
Used to combine the results of two or more `SELECT` statements
- Every select statement in union must have same number of columns and similar datatypes and in similar order

```
SELECT * FROM table1
INTERSECT
SELECT * FROM table2;
```

## CTE - Common Table Expression
The queries are not stored anywhere and the lookup is performed eachtime the cte is run

```
WITH <CTE name> AS
(
    <sql query>
)
SELECT entities from the CTE query

WITH CTE_Employee AS
(
    SELECT FirstName, lastName, Gender,
    COUNT(Gender) OVER (PARTITION by Gender) as TotalGender,
    AVG(Salary) OVER (PARTITION by Gender) as AvgSalary

    FROM emp
    JOIN sal
    ON emp.id = sal.empid
)
SELECT FirstName, AvgSalary
FROM CTE_Employee;
```

## Views
- Virtual table
- Only Select can be performed on Views

```
CREATE VIEW <ViewNAme> AS
<query for data to be included in the view>;

CREATE VIEW companydetails AS
SELECT name, age, address
From company;

SELECT * FROM companydetails;
```

## Window Functions
Window functions perform aggregate operations on groups of rows but they produce a result for EACH Row
(Unlike GROUP by which reduces to single group)

OVER specifies which groups to run aggregate function on. partition by department divides the entire table
as depertments(each called windows) and runs aggregate on each of them

```
SELECT department, AVG(salary)
FROM employees
GROUP BY department;

| department (each department once) | avg (and their avg) |



SELECT emp_no, department, salary, 
    AVG(salary) OVER(PARTITION BY department) AS dept_avg
    FROM employees;

|emp_no | department | salary | dept_avg |
(entry of each employee )
```

### RANK()
Find Rank of current row within it's partition

```
# calculating overall rank of each employee across every department
SELECT
RANK() OVER(ORDER BY salary DESC) AS overall_rank
FROM
employees;

# calculating rank of each employee within each department for each department
SELECT
RANK() OVER(
    PARTITION BY department
    ORDER BY 
        salary DESC
) AS dept_rank
FROM
    employees;
 
```

## Functions and Procedures

### Functions
- System and Userdefined functions
- can have multiple sql statements
- Can return any type of results like table or a single value

Can't use transactions inside the function

```
CREATE (or REPLACE) FUNCTION <function_name>(<parameters-list>)
RETURNS <return_type>
LANGUAGE plpgsql
AS
$$
    DECLARE
        <variables>
    BEGIN
        <sql statements>
    END
$$
```

### Procedure
- Can perform transactions
- Can't return a result like table. can only return INOUT parameters.

```
CREATE (or REPLACE) PROCEDURE <procedure_name> (<parameters-list>)
LANGUAGE plpgsql
AS
$$
DECLARE
    <variables>
BEGIN
    <sql statements>
END
$$
```

### Parameter types
- IN
- OUT
- INOUT

### Example procedure

```
CREATE OR REPLACE PROCEDURE AddEmployee
(
    EmpId INOUT INT,
    EmpName VARCHAR(100),
    EmpDob DATE,
    EmpCity VARCHAR(100)
)
LANGUAGE plpgsql AS
$$
BEGIN
    INSERT INTO Employees(name, dob, city)
    VALUES (EmpId,
        EmpDob,
        EmpCity
    ) RETURNING Id INTO EmpId;
END
$$;


CALL AddEmployee(null, 'Tom', '2000-03-02:)
```

## Arrays Datatype
Arrays start at index 1

### cardinality
count of elements in an array

```
create table(
    colors text[],
    (or)
    colors text ARRAY,
)

insert into (...)
values
(ARRAY['red', 'white', 'green'])

(OR)

insert into (...)
values('{"yelow", "green", "blue"}');

-- Acessing
select color[1]
from table;

-- returns each row with the count of elements in color array
select 
    cardinality(color)
from table;

(or)

select 
    array_length(color, 1)
from table;

-- get entry where first element is red
select rowname
from tablename
where color[1] = 'red';

-- get all entries where there is a red color
select rowname
from tablename
where 'red' = ANY (color)

-- get the position of 'red' where there is red in the color array else null
select
    array_position(color, 'red')
from tablename;

-- contains
select
    rownames
from tablename
where color @> '{"black"}'  <- @> is contains

-- select a range of elements
select 
    color[1:2]
from tablename;
```

## Backup and restoring database

```
pg_dump --help

pg_dump -<format> -h <host> -U <user> <database> -f <outputfile>
# custom format
pg_dump -Fc -h localhost -U dbuser dbuserdb -f backup.dump

## restoring
# create new database
sudo su - postgres
createdb restoreddb -O dbuser
logout

pg_restore -d <database name to restore to> -h <host> -U <user> <path to backup file>
pg_restore -d restoreddb -h localhost -U dbuser backup.dump
```