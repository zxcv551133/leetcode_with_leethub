# Write your MySQL query statement below
with buyer_orders as (
    select buyer_id, 
        sum(case 
            when year(order_date) = 2019 then 1
            else 0 
        end) as `orders_in_2019`

    from Orders
    group by buyer_id
)

select user_id as buyer_id, join_date,
    case when orders_in_2019 is null then 0
        else orders_in_2019 
    end as orders_in_2019
from
    buyer_orders a
    right join
    Users b
    on
    a.buyer_id = b.user_id

