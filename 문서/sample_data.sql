use ncp;

show tables;

select * from student;

insert into student (university_number, name) values ('201910823', '신민예');
insert into student (university_number, name) values ('202011346', '장리');

# 학번, 역량 영역, 준비도, 준비 수준, 준비도 순위
insert into Preparation_Level values ("201910823", "자기이해", 20.2, "보통", 5);
insert into Preparation_Level values ("201910823", "진로탐색", 16.5, "낮음", 8);
insert into Preparation_Level values ("201910823", "진로결정", 18.2, "낮음", 6);
insert into Preparation_Level values ("201910823", "진로설계", 17.3, "낮음", 7);
insert into Preparation_Level values ("201910823", "경력개발", 20.7, "낮음", 4);
insert into Preparation_Level values ("201910823", "실무역량", 21.0, "낮음", 3);
insert into Preparation_Level values ("201910823", "맞춤취업", 22.1, "낮음", 2);
insert into Preparation_Level values ("201910823", "구직활동", 22.2, "낮음", 1);

insert into Preparation_Level values ("202011346", "자기이해", 23.9, "높음", 2);
insert into Preparation_Level values ("202011346", "진로탐색", 22.9, "보통", 7);
insert into Preparation_Level values ("202011346", "진로결정", 21.3, "낮음", 8);
insert into Preparation_Level values ("202011346", "진로설계", 23.3, "보통", 4);
insert into Preparation_Level values ("202011346", "경력개발", 23.0, "낮음", 5);
insert into Preparation_Level values ("202011346", "실무역량", 23.4, "낮음", 3);
insert into Preparation_Level values ("202011346", "맞춤취업", 22.9, "낮음", 6);
insert into Preparation_Level values ("202011346", "구직활동", 23.9, "낮음", 1);

insert ignore into Preference_Information
values (201910823, '11', '2022-06-01', '2022-07-31', '0'),
		(202011346, '19', '0000-01-01', '9999-01-01', '2');


select * from Preference_Information;

select * 
from Preparation_Level 
where university_number = '201910823'
order by preparation_degree asc
limit 3;