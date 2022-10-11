# Write your MySQL query statement below
with first_join as (
    select a.id as first_id, a.num as first_num, b.id as second_id, b.num as second_num
    from Logs a
    join
    Logs b
    on a.id + 1 = b.id
), second_join as (
    select first_id, first_num, second_id, second_num, b.id as third_id, b.num as third_num
    from first_join a
    join
    Logs b
    on a.second_id + 1 = b.id
)

select distinct third_num as ConsecutiveNums from second_join
where first_num = second_num and second_num = third_num