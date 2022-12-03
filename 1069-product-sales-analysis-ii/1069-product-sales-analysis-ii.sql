# Write your MySQL query statement below
select p.product_id, sum(quantity) as total_quantity
from 
Product p
join 
Sales s
on p.product_id = s.product_id
group by p.product_id