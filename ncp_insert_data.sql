use ncp;

# 비교과 프로그램 대분류
insert into program_large_category values ('1', 'Start-Up');
insert into program_large_category values ('2', 'Grow-Up');
insert into program_large_category values ('3', 'Built-Up');
insert into program_large_category values ('4', 'Jump-Up');
insert into program_large_category values ('0', '전체');
select * from program_large_category;

# 비교과 프로그램 중분류
insert into program_middle_category values ('1', '자기이해');
insert into program_middle_category values ('2', '진로탐색');
insert into program_middle_category values ('3', '진로결정');
insert into program_middle_category values ('4', '진로설계');
insert into program_middle_category values ('5', '경력개발');
insert into program_middle_category values ('6', '실무역량');
insert into program_middle_category values ('7', '맞춤취업');
insert into program_middle_category values ('8', '구직활동');
insert into program_middle_category values ('0', '전체');
select * from program_middle_category;

# 비교과 프로그램 운영 유형 테이블
insert into program_operating_type values ('1', '진단검사');
insert into program_operating_type values ('2', '진로교육');
insert into program_operating_type values ('3', '집단상담');
insert into program_operating_type values ('4', '취업교육');
insert into program_operating_type values ('5', '자격증취득지원');
insert into program_operating_type values ('6', '구직기술향상');
insert into program_operating_type values ('7', '구직정보탐색');
insert into program_operating_type values ('8', '자기설계형');
insert into program_operating_type values ('9', '공모전(경진대회)');
insert into program_operating_type values ('10', '경력개발지원');
insert into program_operating_type values ('0', '전체');
select * from program_operating_type;

# 연계 직무
insert into NCS_Part values ('00', '해당 없음');
insert into NCS_Part values ('01', '기획/전략');
insert into NCS_Part values ('02', '마케팅/홍보');
insert into NCS_Part values ('03', '회계/세무/재무');
insert into NCS_Part values ('04', '인사/노무/HRD');
insert into NCS_Part values ('05', '총부/법무/사무');
insert into NCS_Part values ('06', 'IT개발/데이터관리');
insert into NCS_Part values ('07', '디자인');
insert into NCS_Part values ('08', '영업/판매/무역');
insert into NCS_Part values ('09', '고객상담/TM');
insert into NCS_Part values ('10', '구매/자재/물류');
insert into NCS_Part values ('11', '상품기획/MD');
insert into NCS_Part values ('12', '운송/배송/운전');
insert into NCS_Part values ('13', '서비스');
insert into NCS_Part values ('14', '생산/품질');
insert into NCS_Part values ('15', '건설/건축');
insert into NCS_Part values ('16', '바이오/의료');
insert into NCS_Part values ('17', '연구/R&D');
insert into NCS_Part values ('18', '교육(비교직)');
insert into NCS_Part values ('19', '미디어/문화/스포츠');
insert into NCS_Part values ('20', '금융/보험');
insert into NCS_Part values ('21', '공공/복지');
insert into NCS_Part values ('22', '교직');
insert into NCS_Part values ('23', '기타');
select * from ncs_part;

# TALENT 역량 정보 테이블
insert into talent_capability values ('1', '의사소통');
insert into talent_capability values ('2', '리더쉽');
insert into talent_capability values ('3', '자기관리');
insert into talent_capability values ('4', '글로컬');
insert into talent_capability values ('5', '문제해결');
insert into talent_capability values ('6', '현장실무');
insert into talent_capability values ('0', '전체');
select * from talent_capability;

# 비교과 프로그램 운영 방식
insert into program_operating_method values ('1', '대면');
insert into program_operating_method values ('2', '비대면(실시간)');
insert into program_operating_method values ('3', '비대면(LMS)');
insert into program_operating_method values ('4', '비대면(자율)');
insert into program_operating_method values ('5', '대면+비대면 혼합');
insert into program_operating_method values ('0', '전체');
select * from program_operating_method;

# 단과대학 정보
insert into college_information values ('0', '전체대상');
insert into college_information values ('1', '사범대학');
insert into college_information values ('2', '글로벌경영대학');
insert into college_information values ('3', '공공서비스대학');
insert into college_information values ('4', '바이오융합대학');
insert into college_information values ('5', '미디어융합대학');
insert into college_information values ('6', '휴먼서비스대학');
insert into college_information values ('7', '미래대학');
select * from college_information;

# 학부 정보
insert into department_information values ('00', '전체학부');
insert into department_information values ('21', '경영학부');
insert into department_information values ('22', '국제학부');
insert into department_information values ('31', '경찰학부');
insert into department_information values ('32', '사회복지학부');
insert into department_information values ('41', '제약식품공학부');
insert into department_information values ('51', '미디어콘텐츠학부');
insert into department_information values ('52', '소프트웨어학부');
insert into department_information values ('61', '호텔외식조리학부');
insert into department_information values ('62', '레저스포츠학부');
insert into department_information values ('71', '비전학부');
select * from department_information;

# 학과전공 정보
insert into Major_Information values ('00000', '전체학과');
insert into Major_Information values ('10001', '국어교육과');
insert into Major_Information values ('10002', '영어교육과');
insert into Major_Information values ('22203', '영어전공');
insert into Major_Information values ('33101', '경찰행정전공');
insert into Major_Information values ('33102', '범죄수사전공');
insert into Major_Information values ('30001', '소방행정학과');
select * from Major_Information;

# 학년 정보
insert into Student_Grade values ('0', '전학년');
insert into Student_Grade values ('1', '1학년');
insert into Student_Grade values ('2', '2학년');
insert into Student_Grade values ('3', '3학년');
insert into Student_Grade values ('4', '4학년');
insert into Student_Grade values ('5', '저학년');
insert into Student_Grade values ('6', '고학년');
insert into Student_Grade values ('7', '졸업유예자');
insert into Student_Grade values ('8', '졸업자');
select * from Student_Grade;

# 성별 정보
insert into Student_Sex values ('0', '전체');
insert into Student_Sex values ('1', '남학생');
insert into Student_Sex values ('2', '여학생');
select * from Student_Sex;

# 프로그램 운영 담당자 정보
insert into Manager_information values ('223099', '장미정');
insert into Manager_information values ('223100', '조혜련');
insert into Manager_information values ('223101', '이미예');
insert into Manager_information values ('223102', '박경의');
insert into Manager_information values ('223103', '김동윤');
select * from Manager_information;

# 프로그램 운영 상황 정보
insert into Operating_State values ('1', '모집중');
insert into Operating_State values ('2', '운영중');
insert into Operating_State values ('3', '운영완료');
insert into Operating_State values ('4', '결과분석중');
insert into Operating_State values ('5', '결과보고완료');
insert into Operating_State values ('0', '전체');
select * from Operating_State;

# 비교과 프로그램
insert ignore into Program_Information ( code, program_name, category_large, category_middle, operating_type, related_NCS_part, completation_time, TALENT_capability, TALENT_reflection_rate, program_goal, grogram_detail )
values ( '11001', '진로취업 SEOCH 진로진단검사', '1', '1', '1', '00', 1, '1', 0, 
		'진로진단검사를 통한 진로수준 파악', 
		'전학년 대상 진로개발준비도검사 실시' ),
        ( '11001', '진로취업 SEOCH 진로진단검사', '1', '1', '1', '00', 1, '2', 0, 
		'진로진단검사를 통한 진로수준 파악', 
		'전학년 대상 진로개발준비도검사 실시' ),
        ( '11001', '진로취업 SEOCH 진로진단검사', '1', '1', '1', '00', 1, '3', 70, 
		'진로진단검사를 통한 진로수준 파악', 
		'전학년 대상 진로개발준비도검사 실시' ),
        ( '11001', '진로취업 SEOCH 진로진단검사', '1', '1', '1', '00', 1, '4', 0, 
		'진로진단검사를 통한 진로수준 파악', 
		'전학년 대상 진로개발준비도검사 실시' ),
        ( '11001', '진로취업 SEOCH 진로진단검사', '1', '1', '1', '00', 1, '5', 30, 
		'진로진단검사를 통한 진로수준 파악', 
		'전학년 대상 진로개발준비도검사 실시' ),
        ( '11001', '진로취업 SEOCH 진로진단검사', '1', '1', '1', '00', 1, '6', 0, 
		'진로진단검사를 통한 진로수준 파악', 
		'전학년 대상 진로개발준비도검사 실시' ),
        
        ( '11002', 'E-DISC 진단검사', '1', '1', '1', '00', 1, '1', 0, 
		'E-DISC 검사를 통한 행동유형별 직무매칭 검사', 
		'전학년 대상 E-DISC 검사 실시' ),
        ( '11002', 'E-DISC 진단검사', '1', '1', '1', '00', 1, '2', 0, 
		'E-DISC 검사를 통한 행동유형별 직무매칭 검사', 
		'전학년 대상 E-DISC 검사 실시' ),
        ( '11002', 'E-DISC 진단검사', '1', '1', '1', '00', 1, '3', 70, 
		'E-DISC 검사를 통한 행동유형별 직무매칭 검사', 
		'전학년 대상 E-DISC 검사 실시' ),
        ( '11002', 'E-DISC 진단검사', '1', '1', '1', '00', 1, '4', 0, 
		'E-DISC 검사를 통한 행동유형별 직무매칭 검사', 
		'전학년 대상 E-DISC 검사 실시' ),
        ( '11002', 'E-DISC 진단검사', '1', '1', '1', '00', 1, '5', 30, 
		'E-DISC 검사를 통한 행동유형별 직무매칭 검사', 
		'전학년 대상 E-DISC 검사 실시' ),
        ( '11002', 'E-DISC 진단검사', '1', '1', '1', '00', 1, '6', 0, 
		'E-DISC 검사를 통한 행동유형별 직무매칭 검사', 
		'전학년 대상 E-DISC 검사 실시' ),
        
        ( '11004', 'E-DISC 워크숍', '1', '1', '2', '00', 3, '1', 40, 
		'E-DISC 검사 해석을 통한 개인별 성향 이해 및 직무매칭', 
		'E-DISC 검사 결과 해석을 통해 성향에 따른 직무매칭 워크숍 프로그램' ),
        ( '11004', 'E-DISC 워크숍', '1', '1', '2', '00', 3, '2', 20, 
		'E-DISC 검사 해석을 통한 개인별 성향 이해 및 직무매칭', 
		'E-DISC 검사 결과 해석을 통해 성향에 따른 직무매칭 워크숍 프로그램' ),
        ( '11004', 'E-DISC 워크숍', '1', '1', '2', '00', 3, '3', 20, 
		'E-DISC 검사 해석을 통한 개인별 성향 이해 및 직무매칭', 
		'E-DISC 검사 결과 해석을 통해 성향에 따른 직무매칭 워크숍 프로그램' ),
        ( '11004', 'E-DISC 워크숍', '1', '1', '2', '00', 3, '4', 20, 
		'E-DISC 검사 해석을 통한 개인별 성향 이해 및 직무매칭', 
		'E-DISC 검사 결과 해석을 통해 성향에 따른 직무매칭 워크숍 프로그램' ),
        ( '11004', 'E-DISC 워크숍', '1', '1', '2', '00', 3, '5', 0, 
		'E-DISC 검사 해석을 통한 개인별 성향 이해 및 직무매칭', 
		'E-DISC 검사 결과 해석을 통해 성향에 따른 직무매칭 워크숍 프로그램' ),
        ( '11004', 'E-DISC 워크숍', '1', '1', '2', '00', 3, '6', 0, 
		'E-DISC 검사 해석을 통한 개인별 성향 이해 및 직무매칭', 
		'E-DISC 검사 결과 해석을 통해 성향에 따른 직무매칭 워크숍 프로그램' );

# 개설 유형
# 1: 기존
# 2: 신규
insert into Program_Instance
values ('11001', 1, '2022', 1, '2021-03-01', '2022-02-01', '01:00:00', '2', -1, 0, '0', '00', '00000', '0', '0', '223099', '1', 0, '서원대학교');

select * from Program_Instance;

desc Program_information;