# Write your MySQL query statement below

with left_table as (
    select a.employee_id as empa, b.employee_id as empb, name, salary
    from
    Employees a
    left join
    Salaries b
    on a.employee_id = b.employee_id
), right_table as (
    select a.employee_id as empa, b.employee_id as empb, name, salary
    from
    Employees a
    right join
    Salaries b
    on a.employee_id = b.employee_id
), unioned as (
select * from left_table
union
select * from right_table
)

select
case 
    when empa is null then empb
    when empb is null then empa
    else null 
end as `employee_id`
from
unioned
having employee_id is not null
order by employee_id

