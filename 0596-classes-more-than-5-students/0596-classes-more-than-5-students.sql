# Write your MySQL query statement below
with count_student as (
select class, count(*) as cnt from Courses
group by class
)

select class from count_student
where cnt >= 5
