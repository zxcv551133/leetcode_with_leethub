# Write your MySQL query statement below
with department_joined as (
    select b.name as `Department`, a.name as `Employee`, salary as `Salary`
    from
        Employee a
        join
        Department b
        on
        a.departmentId = b.id
), max_salary as (
    select Department, max(Salary) as maxSal
    from department_joined
    group by Department
), max_salary_employee as (
    select a.Department, Employee, Salary
    from
        department_joined a
        join
        max_salary b
        on
        a.Salary = b.maxSal and a.Department = b.Department
)

select * from max_salary_employee

