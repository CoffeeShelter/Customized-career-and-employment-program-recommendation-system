use ncp;

select * from recommendation_result;

select * from student;

select *
from recommendation_result r join student s on r.university_number = s.university_number
where code = "12001"
order by recommendation_degree desc;

select * from student_sex;

select * from Preference_Information;