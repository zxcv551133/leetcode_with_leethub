# Write your MySQL query statement below
select a.country_name,
case when avg(weather_state)<=15 then "Cold"
when avg(weather_state)>=25 then "Hot"
else "Warm" end as weather_type from Countries as a
join Weather as b
on a.country_id=b.country_id
where b.day between "2019-11-01" and "2019-11-30"
group by a.country_id;