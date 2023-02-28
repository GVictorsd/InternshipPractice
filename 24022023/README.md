# PostgreSQL

## Setting up
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

## Inserting data
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

# In
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

# Alias (AS)
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