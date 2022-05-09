# DROP DATABASE IF EXISTS NCP;

CREATE DATABASE IF NOT EXISTS NCP;

USE ncp;

USE NCP;
#########################################################################################
#                                     학생 정보 (임시)                                     #
#########################################################################################

# 학생 정보 테이블
# 학생의 기본 정보를 저장
CREATE TABLE IF NOT EXISTS Student (
	university_number varchar(9) NOT NULL,
    name varchar(20) NOT NULL,
    major_number varchar(5) NOT NULL,
    grade varchar(3) NOT NULL,
    sex varchar(1) NOT NULL,
    primary key(university_number)
);

#########################################################################################
#                                     역량준비 수준 (임시)                                     #
#########################################################################################

# 학생 정보 테이블
# 학생의 기본 정보를 저장
CREATE TABLE IF NOT EXISTS Preparation_Level (
	university_number varchar(9) NOT NULL,
    capability_category varchar(20) NOT NULL,
    preparation_degree float NOT NULL,
    preparation_level varchar(10) NOT NULL,
    preparation_rank int NOT NULL
);

#########################################################################################
#                                     비교과 프로그램                                       #
#########################################################################################

# 비교과 프로그램 대분류
# 비교과 프로그램 대분류 정보를 저장
CREATE TABLE Program_Large_Category (
	code varchar(3) NOT NULL,
    category_name varchar(30) NOT NULL,
    primary key(code)
);

# 비교과 프로그램 중분류
# 비교과 프로그램 중분류 정보를 저장
CREATE TABLE Program_Middle_Category (
	code varchar(3) NOT NULL,
    category_name varchar(30) NOT NULL,
    primary key(code)
);

# 비교과 프로그램 운영 유형
# 비교과 프로그램의 운영 정보를 저장
CREATE TABLE Program_Operating_Type (
	code varchar(3) NOT NULL,
    category_name varchar(30) NOT NULL,
    primary key(code)
);

# 연계 직무
# 우리 대학에서 정의한 비교과 프로그램과 연계된 NCS 직무 정보를 저장
CREATE TABLE NCS_Part (
	code varchar(3) NOT NULL,
    category_name varchar(30) NOT NULL,
    primary key(code)
);

# TALENT 역량 정보
# 우리 대학에서 정의한 TALENT 역량 정보를 저장
CREATE TABLE TALENT_Capability (
	code varchar(3) NOT NULL,
    category_name varchar(30) NOT NULL,
    primary key(code)
);

# 비교과 프로그램 운영 방식
# 비교과 프로그램의 운영 방식 정보를 저장
CREATE TABLE Program_Operating_Method (
	code varchar(3) NOT NULL,
    category_name varchar(30) NOT NULL,
    primary key(code)
);

# 단과 대학 정보
# 우리대학의 단과대학을 분류하는 코드 정보를 저장
CREATE TABLE College_Information (
	code varchar(3) NOT NULL,
    category_name varchar(30) NOT NULL,
    primary key(code)
);

# 학부 정보
# 우리대학의 단과대학별 학부를 분류하는 코드 정보를 저장
CREATE TABLE Department_Information (
	code varchar(3) NOT NULL,
    category_name varchar(20) NOT NULL,
    primary key(code)
);

# 학과전공 정보
# 우리대학의 학과 및 전공을 분류하는 코드 정보를 저장
CREATE TABLE Major_Information (
	code varchar(5) NOT NULL,
    category_name varchar(30) NOT NULL,
    primary key(code)
);

# 학년 정보
# 모집 대상 학년을 분류하는 코드를 저장
CREATE TABLE Student_Grade (
	code varchar(3) NOT NULL,
    category_name varchar(30) NOT NULL,
    primary key(code)
);

# 성별 정보
# 모집 대상 성별을 분류하는 코드를 저장
CREATE TABLE Student_Sex (
	code varchar(1) NOT NULL,
    category_name varchar(10) NOT NULL,
    primary key(code)
);

# 프로그램 운영 담당자 정보
# 프로그램 운영을 담당하는 교직원 정보를 저장
CREATE TABLE Manager_Information (
	staff_id varchar(6) NOT NULL,
    staff_name varchar(10) NOT NULL,
    primary key(staff_id)
);

# 프로그램 운영 상황 정보
# 프로그램을 운영하고 있는 상황을 정의하는 정보를 저장
CREATE TABLE Operating_State (
	code varchar(2) NOT NULL,
    status_name varchar(30) NOT NULL,
    primary key(code)
);

# 비교과 프로그램 정보
# 등록(개발)된 비교과 프로그램에 대한 기본 정보를 저장
CREATE TABLE Program_Information (
	code varchar(10) NOT NULL,
    program_name varchar(200) NOT NULL,
    category_large varchar(3) NOT NULL,
    category_middle varchar(3) NOT NULL,
    operating_type varchar(3) NOT NULL,
    related_NCS_part varchar(100) NOT NULL,
    completation_time int NOT NULL,
    TALENT_capability varchar(100),
    # TALENT_reflection_rate int,
    previous_program varchar(210),
    after_program varchar(210),
    program_goal text NOT NULL,
    grogram_detail text,
    primary key(code, TALENT_capability),
    foreign key(category_large) references Program_Large_Category (code),
    foreign key(category_middle) references Program_Middle_Category (code),
    foreign key(operating_type) references Program_Operating_Type (code)
    # foreign key(related_NCS_part) references NCS_Part (code),
    # foreign key(TALENT_capability) references TALENT_Capability (code),
    # foreign key(previous_program) references Program_Information (code),
    # foreign key(after_program) references Program_Information (code)
);

# use ncp;
# alter table Program_Information drop period;
# desc Program_Information;

# 비교과 프로그램 수행이력 정보
# 등록(개발)된 비교과 프로그램에 대한 기본 정보를 저장
CREATE TABLE IF NOT EXISTS Program_Instance (
	code varchar(10) NOT NULL,
    open_type int NOT NULL,
    open_year year NOT NULL,
    open_term int NOT NULL,
    start_day date NOT NULL,
    end_day date NOT NULL,
    training_time time NOT NULL,
    operating_method varchar(3) NOT NULL,
    recuiting_number int NOT NULL,
    participation_number int NOT NULL,
    college_number varchar(3) NOT NULL,
    department_number varchar(3) NOT NULL,
    major_number varchar(5) NOT NULL,
    target_grade varchar(3) NOT NULL,
    target_sex varchar(1) NOT NULL,
    manager varchar(6)NOT NULL,
    operating_state varchar(2) NOT NULL,
    operating_result int NOT NULL,
    operating_department varchar(20) NOT NULL,
    primary key(code, open_year, open_term),
    foreign key(code) references Program_Information (code),
    foreign key(operating_method) references Program_Operating_Method (code),
    foreign key(college_number) references College_Information (code),
    foreign key(department_number) references Department_Information (code),
    foreign key(major_number) references Major_Information (code),
    foreign key(target_grade) references Student_Grade (code),
    foreign key(target_sex) references Student_Sex (code),
    foreign key(manager) references Manager_Information (staff_id),
    foreign key(operating_state) references Operating_State (code)
);

desc Program_Instance;

#########################################################################################
#                              학생 정보 (프로그램 수강 선호 조건)                              #
#########################################################################################

# 비교과 프로그램 선호 조건 정보
# 학생의 기본 정보 및 비교과 프로그램 수강 선호 조건 정보를 저장(SEMS + 사이트에 선호 조건 입력 필요)
CREATE TABLE IF NOT EXISTS Preference_Information (
	university_number varchar(9) NOT NULL,
    NCS_part varchar(3) NOT NULL,
    start_day date NOT NULL,
    end_day date NOT NULL,
    operating_method varchar(3) NOT NULL,
	primary key(university_number),
    foreign key(university_number) references Student (university_number),
    foreign key(NCS_part) references NCS_Part (code),
    foreign key(operating_method) references Program_Operating_Method (code)
);

# 비교과 프로그램 참여 평가 결과 정보
# 비교과 프로그램 참여 결과에 대한 카테고리 정보를 저장
CREATE TABLE IF NOT EXISTS Evaluation_Result_Category (
	code varchar(2) NOT NULL,
    category_name varchar(20) NOT NULL,
    primary key(code)
);

# 비교과 참여 이력 정보
# 학생이 현재까지 비교과 프로그램 참여 이력 및 수료한 정보를 저장
CREATE TABLE IF NOT EXISTS Program_Participation_History (
	university_number varchar(9) NOT NULL,
    code varchar(10) NOT NULL,
    open_year year NOT NULL,
    end_term int NOT NULL,
    evaluation_result varchar(2) NOT NULL,
	foreign key(university_number) references Student (university_number),
    foreign key(code) references Program_Instance (code),
    foreign key(evaluation_result) references Evaluation_Result_Category (code)
);

#########################################################################################
#                                  추천 프로그램 관련 정보                                    #
#########################################################################################

# 비교과 프로그램 추천 결과 정보
# Rlogic에 의해 모집 중에 있는 프로그램에 대한 추천 적합 도를 계산한 결과를 저장(알고리즘 단계별 적합 도는 View로 처리)
CREATE TABLE IF NOT EXISTS Recommendation_Result (
	code varchar(10) NOT NULL,
    open_year year NOT NULL,
    open_term int NOT NULL,
    university_number varchar(9) NOT NULL,
    capability_category varchar(3) NOT NULL,
    recommendation_degree float NOT NULL,
    primary key(code, university_number, open_year, open_term, capability_category),
	foreign key(code, open_year, open_term) references Program_Instance (code, open_year, open_term),
	foreign key(university_number) references Student (university_number),
	foreign key(capability_category) references Program_Middle_Category (code)
);