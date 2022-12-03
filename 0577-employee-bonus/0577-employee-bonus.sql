# Write your MySQL query statement below
with bonus_joined as (
    select e.name, b.bonus
    from Employee e
    left join Bonus b
    on b.empId = e.empId
    )
    
select * from bonus_joined
where bonus is null or bonus < 1000