
CREATE OR REPLACE PROCEDURE pproc(
    car_id BIGINT,
)
LANGUAGE plpgsql AS
$$
    BEGIN
        select * from car where id = car_id
        RETURNING make INTO res;
    END
$$;

CALL pproc(10);

select * from car limit 10;
