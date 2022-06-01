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
ALTER TABLE Program_Instance MODIFY COLUMN participation_number INT;
desc program_instance;

CREATE TABLE IF NOT EXISTS `TEMP` SELECT * FROM `Program_Instance`;
CREATE TABLE IF NOT EXISTS `Program_Instance` SELECT * FROM `TEMP`;
select * from Program_Instance;
DESC Program_Instance;

#비교과 프로그램 개설 이력 기본 키 수정
ALTER TABLE Program_Instance ADD PRIMARY KEY(code, start_day, end_day);
ALTER TABLE Program_Instance ADD FOREIGN KEY(code) REFERENCES Program_Information (code);
ALTER TABLE Program_Instance ADD foreign key(operating_method) references Program_Operating_Method (code);
ALTER TABLE Program_Instance ADD foreign key(college_number) references College_Information (code);
ALTER TABLE Program_Instance ADD foreign key(department_number) references Department_Information (code);
ALTER TABLE Program_Instance ADD foreign key(major_number) references Major_Information (code);
ALTER TABLE Program_Instance ADD foreign key(target_grade) references Student_Grade (code);
ALTER TABLE Program_Instance ADD foreign key(target_sex) references Student_Sex (code);
ALTER TABLE Program_Instance ADD foreign key(manager) references Manager_Information (staff_id);
ALTER TABLE Program_Instance ADD foreign key(operating_state) references Operating_State (code);

DROP TABLE Program_Instance;

drop table Program_Participation_History;
drop table Recommendation_Result;
select * from Program_Participation_History;

SELECT * FROM Major_Information;
SELECT * FROM Student;
SELECT * FROM USERS;
SELECT * FROM Preparation_Level WHERE university_number = '201910823';

INSERT IGNORE INTO Student VALUES
('201711245', '이주훈', '30001', '4', '1'),
('201711246', '홍길동', '33101', '2', '1'),
('201711247', '이순신', '22203', '4', '2');

INSERT IGNORE INTO Users VALUES
('201711245', '3'),
('201711246', '3'),
('201711247', '3');

INSERT IGNORE INTO Preparation_Level VALUES
('201711245', '자기이해', '20.1', '보통', '5'),
('201711245', '진로탐색', '22.1', '보통', '5'),
('201711245', '진로결정', '22.3', '보통', '5'),
('201711245', '진로설계', '16.1', '보통', '5'),
('201711245', '경력개발', '15.1', '보통', '5'),
('201711245', '실무역량', '17.0', '보통', '5'),
('201711245', '맞춤취업', '22.2', '보통', '5'),
('201711245', '구직활동', '14.1', '보통', '5'),