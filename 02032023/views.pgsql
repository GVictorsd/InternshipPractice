
-- print car table
select * from car;

-- create view called carview
create view carview as
SELECT id, make 
FROM car;

-- print view
select * from carview;

-- change data in the view
INSERT INTO carview(id, make)
VALUES(2, 'car2');

DELETE FROM carview WHERE id = 2;

-- delete the view
DROP VIEW carview;