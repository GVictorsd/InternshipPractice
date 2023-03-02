
-- view sample data 
select * from car LIMIT 10;

-- using group by
SELECT
    make,
    AVG(price)
FROM car
GROUP BY make;

-- Using window function
SELECT
    make,
    AVG(price) over (PARTITION BY make) as make_avg
FROM car;

-- Rank

-- Global Ranking
SELECT
    make, model,
    rank() over(order by price asc) as price_rank
FROM
    car;

-- Ranking for each make
SELECT
    make,
    model,
    rank() over(order by price asc) as global_rank,
    rank() over(partition by make order by price asc) as make_rank
FROM
    car
order by make;