# Write your MySQL query statement below
with spent as (
   select s.user_id, s.product_id, sum(p.price * s.quantity) as pvalue
    from
    Sales s
    join
    Product p
    on s.product_id = p.product_id
    group by s.user_id, s.product_id
    ), max_spent as (
    select user_id, max(pvalue) as max_sp
    from spent
    group by user_id
)
-- select * from spent

select s.user_id, s.product_id from max_spent m
 join spent s
 on s.pvalue = m.max_sp and s.user_id = m.user_id
