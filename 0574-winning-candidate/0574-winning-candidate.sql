# Write your MySQL query statement below
with votes as (
    select candidateId, count(*) as cnt
    from Vote
    group by candidateId
), candidate_joined as (
    select c.name, v.cnt
    from 
        Candidate c
        join
        votes v
        on v.candidateId = c.id
)
select name from candidate_joined
order by cnt desc
limit 1