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
\d <database> (describes the entire database)
```

### Deleting a database
```
DROP DATABASE <databaseName>;
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