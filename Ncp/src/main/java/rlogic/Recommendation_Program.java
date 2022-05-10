package rlogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data.RecommendationResult_Program;
import data.dao.Student_DAO;
import data.utils.CategoryUtils;
import data.utils.ProgramUtils;

public class Recommendation_Program {

	private Student_DAO studentDAO = null;
	private CategoryUtils categoryUtils = null;
	private ProgramUtils programUtils = null;
	
	public Recommendation_Program() {
		studentDAO = new Student_DAO();
		categoryUtils = new CategoryUtils();
		programUtils = new ProgramUtils();
	}

	public List<RecommendationResult_Program> getRecommendation(String code) {
		List<RecommendationResult_Program> datum = null;

		datum = studentDAO.getRecommendationResult_Program(code);
		
		return datum;
	}
	
	public List<Map<String, String>> getPrettyRecommendation(String code){
		List<Map<String, String>> results = new ArrayList<>();
		
		List<RecommendationResult_Program> datum = null;
		datum = studentDAO.getRecommendationResult_Program(code);
		
		for (RecommendationResult_Program data : datum) {
			Map<String, String> result = new HashMap<>();
			
			String programName = programUtils.getProgramName(code);
			String name =  data.getName();
			String major_number = data.getMajor_number();
			String major = categoryUtils.getMajorName(major_number);
			String university_number = data.getUniversity_number();
			String grade = data.getGrade();
			String sex = categoryUtils.getStudentSexName(data.getSex());
			String ncp = categoryUtils.getStudentNCS(university_number);
			String degree = data.getRecommendation_degree();
			
			result.put("programName", programName);
			result.put("name", name);
			result.put("major_number", major_number);
			result.put("major", major);
			result.put("university_number", university_number);
			result.put("grade", grade);
			result.put("sex", sex);
			result.put("ncp", ncp);
			result.put("degree", degree);
			
			results.add(result);
		}
		
		return results;
	}

}
