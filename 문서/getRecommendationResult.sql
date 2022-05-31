USE ncp;

# 비교과 프로그램 추천 결과 조회
SELECT DISTINCT info.code, info.category_large, large.category_name as category_large_name, info.category_middle, middle.category_name as category_middle_name,
	state.status_name as operating_state_name, info.program_name, concat(inst.start_day,'~' ,inst.end_day) as day, 
	info.completation_time, inst.operating_state, reco.recommendation_degree
FROM (program_large_category large, program_middle_category middle, operating_state state,recommendation_result reco join program_instance inst on reco.code = inst.code) 
	join program_information info on inst.code = info.code AND info.category_large = large.code AND info.category_middle = middle.code AND inst.operating_state = state.code
WHERE reco.university_number='202011346'
ORDER BY info.category_middle DESC, reco.recommendation_degree DESC;