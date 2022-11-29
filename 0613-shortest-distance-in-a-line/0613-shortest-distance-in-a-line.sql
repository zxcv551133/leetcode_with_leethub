# Write your MySQL query statement below
with joined as (
    select abs(a.x - b.x) as distance
    from Point a
        join
        Point b
        on a.x <> b.x
    
)

select min(distance) as shortest
from joined