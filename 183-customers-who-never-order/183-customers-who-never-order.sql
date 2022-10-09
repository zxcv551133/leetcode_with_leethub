# Write your MySQL query statement below
with joined as (
    select a.id as customer_id, b.id as order_id, a.name
    from
        Customers a
    left join
        Orders b
    on
        b.customerId = a.id
)
select name as Customers from joined
where order_id is null