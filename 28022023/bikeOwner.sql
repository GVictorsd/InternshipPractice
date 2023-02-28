
CREATE TABLE bike (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    make VARCHAR(20) NOT NULL,
    model VARCHAR(20),
    price NUMERIC(19, 2) NOT NULL
);

CREATE TABLE bikeOwner (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    gender VARCHAR(7) NOT NULL,
    bike_id BIGINT REFERENCES bike (id),
    UNIQUE(bike_id) -- bike is uniquely owned by a person
);

insert into bikeOwner (first_name, last_name, gender) values ('Camellia', 'Gilli', 'Female');
insert into bikeOwner (first_name, last_name, gender) values ('Tommy', 'Ogers', 'Female');
insert into bikeOwner (first_name, last_name, gender) values ('Berkeley', 'Lawling', 'Male');
insert into bikeOwner (first_name, last_name, gender) values ('Caprice', 'Zannuto', 'Male');

insert into bike (make, model, price) values ('Chevrolet', 'Beretta', '81606.17');
insert into bike (make, model, price) values ('Pontiac', 'Grand Prix', '13136.48');
insert into bike (make, model, price) values ('Audi', 'RS6', '62695.27');
insert into bike (make, model, price) values ('Ford', 'F-Series', '11707.60');
insert into bike (make, model, price) values ('Lexus', 'SC', '18259.06');