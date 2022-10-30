# Write your MySQL query statement below
with cnt_email as (
    select count(*) as cnt, email from Person
    group by email
    having cnt > 1
)
select distinct a.email as `Email`
from
    Person a
    join
    cnt_email b
    on
    a.email = b.email
