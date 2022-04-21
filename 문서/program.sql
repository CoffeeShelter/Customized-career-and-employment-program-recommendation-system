insert ignore into Program_Information ( code, program_name, category_large, category_middle, operating_type, related_NCS_part, completation_time, TALENT_capability, previous_program, after_program, program_goal, grogram_detail )
values ( '11001', '진로취업 SEOCH 진로진단검사', '1', '1', '1', '00', 1, '0/0/70/0/30/0', null, null, 
		'진로진단검사를 통한 진로수준 파악', 
		'전학년 대상 진로개발준비도검사 실시' ),
        
        ( '11002', 'E-DISC 진단검사', '1', '1', '1', '00', 1, '0/0/70/0/30/0', null, null, 
		'E-DISC 검사를 통한 행동유형별 직무매칭 검사', 
		'전학년 대상 E-DISC 검사 실시' ),
        
        ( '11004', 'E-DISC 워크숍', '1', '1', '2', '00', 3, '40/20/20/20/0/0', null, null, 
		'E-DISC 검사 해석을 통한 개인별 성향 이해 및 직무매칭', 
		'E-DISC 검사 결과 해석을 통해 성향에 따른 직무매칭 워크숍 프로그램' ),
        
        ( '12001', '인 더 딕싯(심화)', '1', '2', '1', '00', 3, '40/20/20/20/0/0', null, null, 
		'보드게임을 통해 자신의 강점, 가치 등에 기반한 진로 정보 찾기', 
		'인 더 딕싯의 후속 프로그램으로 보드게임 및 카드를 활용하여 전공 기반 진로 정보 찾기' );
        
# 개설 유형
# 1: 기존
# 2: 신규
insert ignore into Program_Instance (code, open_type, open_year, open_term, start_day, end_day, training_time, operating_method, recuiting_number, participation_number, college_number, department_number, major_number, target_grade, target_sex, manager, operating_state, operating_result, operating_department)
values ('11001', 1, '2022', 1, '2021-03-01', '2022-02-01', '01:00:00', '2', -1, 0, '0', '00', '00000', '0', '0', '223099', '1', 0, '서원대학교'),
		('12001', 1, '2022', 1, '2021-03-01', '2022-02-01', '01:00:00', '2', -1, 0, '0', '00', '00000', '0', '0', '223099', '1', 0, '서원대학교');

desc Program_Instance;

select * from Program_Information;
select * from Program_Instance;