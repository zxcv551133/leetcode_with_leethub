# Write your MySQL query statement below
select problem_id from Problems
where 10000 * likes / (likes + dislikes) < 6000
order by problem_id