# Write your MySQL query statement below
with fcnt as (
select user_id, count(*) as followers_count
from
Followers f
group by user_id
    )
    
select distinct f.user_id, coalesce(followers_count, 0) as followers_count
from
Followers f
left join
fcnt fc
on fc.user_id = f.user_id
order by f.user_id asc
