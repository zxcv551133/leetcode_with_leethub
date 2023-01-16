# Write your MySQL query statement below


with salesPersionJoined as (
    select s.name, c.name as `company_name`
    from 
    SalesPerson s
    join Company c
    join Orders o
    on s.sales_id = o.sales_id and o.com_id = c.com_id
)
select s.name from SalesPerson s
where s.name not in (
    select name from salesPersionJoined j 
    where company_name = 'RED'
)