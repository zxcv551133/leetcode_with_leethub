# Write your MySQL query statement below
with tree_joined as (
    select a.id, a.p_id, b.id as c_id
    from
        Tree a
        left join
        Tree b
        on
        a.id = b.p_id
), value_data as (
    select distinct id, p_id, 
    case 
        when c_id is null then false
        else true 
    end
        as `has_child`
    from tree_joined
)
select id, 
case
    when p_id is null then "Root"
    when has_child then "Inner"
    else "Leaf"
end as `type`
from value_data
