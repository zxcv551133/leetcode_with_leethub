select
  S.score,
  count(distinct T.score) as 'rank'
from
  Scores S
  join Scores T on S.score <= T.score
group by
  S.id,
  S.score
order by
  S.score desc;