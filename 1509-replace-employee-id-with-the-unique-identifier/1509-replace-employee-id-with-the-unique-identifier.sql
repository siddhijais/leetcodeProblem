# Write your MySQL query statement below
select (E2.unique_id),E.name
from Employees E left join
EmployeeUNI E2 on E.id=E2.id

