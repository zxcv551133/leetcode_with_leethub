# Write your MySQL query statement below
with seat_joined as (
    select
        a.id as f_id, b.id as s_id, a.student as student
    from
        Seat a
        left join
        Seat b
        on cast((a.id)/2 as signed) = cast((b.id ) / 2 as signed) and a.id <> b.id
)
select coalesce(s_id, f_id) as id, student from seat_joined
order by id asc