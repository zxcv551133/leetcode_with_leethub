# Please write a DELETE statement and DO NOT write a SELECT statement.
# Write your MySQL query statement below
with min_id_person as (
    select min(id) as `min_id`, email from Person
    group by email
), joined as (
    select min_id, id, p.email from 
    min_id_person a
    left join
    Person p
    on a.email = p.email
    where min_id != id
)
delete from Person where id in (select id from joined)




