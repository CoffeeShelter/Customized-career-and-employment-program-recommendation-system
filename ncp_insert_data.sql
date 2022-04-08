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