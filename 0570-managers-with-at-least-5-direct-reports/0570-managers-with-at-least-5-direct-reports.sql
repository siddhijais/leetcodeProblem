# Write your MySQL query statement below
select e.name from Employee e
where e.id in (
    select managerId 
    from Employee 
    group by  managerId 
    having count(*) >=5
);