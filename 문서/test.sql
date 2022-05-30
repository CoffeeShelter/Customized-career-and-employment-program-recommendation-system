use ncp;

select * from recommendation_result;

select * from student;

select *
from recommendation_result r join student s on r.university_number = s.university_number
where code = "12001"
order by recommendation_degree desc;

select * from student_sex;

select * from Preference_Information;
select * from Program_Information;
select * from Program_Operating_Type;

ALTER TABLE Program_Instance CHANGE open_time start_time TIME;
ALTER TABLE Program_Instance MODIFY operating_result TEXT;

ALTER TABLE Program_Instance
ADD end_time TIME NOT NULL;

ALTER TABLE Program_Instance DROP training_time;

set sql_safe_updates=0;


UPDATE Program_Instance
SET recuiting_number = 100
where code > 0;

SELECT * FROM Program_Instance;