package rlogic;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import data.RecommendationResult;
import data.dao.Preparation_Level_DAO;
import data.dao.Program_Middle_Category_DAO;
import data.dao.Student_DAO;
import data.utils.CategoryUtils;
import data.utils.ProgramUtils;
import data.vo.Preference_Information_VO;
import data.vo.Preparation_Level_VO;
import data.vo.Program_Information_VO;
import data.vo.Program_Instance_VO;
import data.vo.Program_Middle_Category_VO;
import data.vo.Student_VO;

public class Rlogic {

	private Preparation_Level_DAO preparation_level_DAO = null;
	private Program_Middle_Category_DAO program_middle_category_DAO = null;
	private ProgramUtils programUtils = null;
	private CategoryUtils categoryUtils = null;
	
	private List<Program_Middle_Category_VO> middle_category_list = null;

	public Rlogic() {
		this.preparation_level_DAO = new Preparation_Level_DAO();
		this.program_middle_category_DAO = new Program_Middle_Category_DAO();

		if (program_middle_category_DAO != null) {
			middle_category_list = program_middle_category_DAO.selectAll();
		}

		if (programUtils == null) {
			programUtils = new ProgramUtils();
		}
		
		if (categoryUtils == null) {
			categoryUtils = new CategoryUtils();
		}
	}

	public Vector<Vector<RecommendationResult>> getReccomendationResult(String university_number) {
		Student_DAO studentDAO = new Student_DAO();
		Student_VO student = studentDAO.getStudent(university_number);
		
		List<Preparation_Level_VO> preLevel = null;
		preLevel = preparation_level_DAO.selectAll(university_number);
		
		Preference_Information_VO preferenceInfo = studentDAO.getPreferenceInformation(university_number);
		
		Vector<Vector<RecommendationResult>> result = new Vector<>();
		
		Preparation_Level_DAO preLevelDAO = new Preparation_Level_DAO();
		
		List<Preparation_Level_VO> preLevelList = preLevelDAO.selectAll(university_number);
		List<Program_Instance_VO> program_instance_list = ProgramUtils.getProgram_instance_list();

		if (program_instance_list == null) {
			System.out.println("null");
			return null;
		}
		
		Vector<RecommendationResult> result1 = new Vector<>();
		Vector<RecommendationResult> result2 = new Vector<>();
		Vector<RecommendationResult> result3 = new Vector<>();
		for (Program_Instance_VO pInst : program_instance_list) {
			Program_Information_VO pInfo = programUtils.getProgram_Inforamtion(pInst.getCode());
			int score = getRecommendedScore(student, preLevel, preferenceInfo, pInst, pInfo);
			
			Vector<RecommendationResult> temps = new Vector<>();
			if (score != -1) {
				RecommendationResult recoResult = new RecommendationResult(
					pInfo.getCode(), 
					categoryUtils.getLargeCategoryName(pInfo.getCategory_large()),
					categoryUtils.getMiddleCategoryName(pInfo.getCategory_middle()),
					pInfo.getProgram_name(),
					pInst.getOpen_term(),
					pInfo.getCompletation_time(),
					pInst.getOperating_state(),
					Integer.toString(score)
				);
				
				temps.add(recoResult);
				// System.out.println(recoResult.toString());
			}
			
			for (RecommendationResult obj : temps) {
				if (preLevelList.get(0).getCapability_category().equals(obj.getMiddleCategory())) {
					result1.add(obj);
				} else if (preLevelList.get(1).getCapability_category().equals(obj.getMiddleCategory())) {
					result2.add(obj);
				} else if (preLevelList.get(2).getCapability_category().equals(obj.getMiddleCategory())) {
					result3.add(obj);
				}
			}
			
			System.out.println(result1.size() + " " + result2.size() + " " + result3.size());
			
			// System.out.println("[" + categoryUtils.getMiddleCategoryName(pInfo.getCategory_middle()) + "]: " + pInfo.getProgram_name() + " : " + score + "점");
		}

		result.add(result1);
		result.add(result2);
		result.add(result3);
		
		return result;
	}

	public int getRecommendedScore(Student_VO student, List<Preparation_Level_VO> preLevel, Preference_Information_VO preferenceInfo, Program_Instance_VO pInst, Program_Information_VO pInfo) {
		boolean middleCheck = false;
		boolean ncsCheck = false;
		boolean majorCheck = false;

		int score = 0;

		// Program_Information_VO pInfo = programUtils.getProgram_Inforamtion(pInst.getCode());

		// 1. 학생의 역량별 진단 수준 결과 하위 3개
		// List<Preparation_Level_VO> preLevel = null;
		// preLevel = preparation_level_DAO.selectAll(university_number);

		if (preLevel != null) {
			// 2. 비교과 프로그램 중 카테고리 일치 여부 검사 ( +30 )
			for (Preparation_Level_VO obj : preLevel) {
				String category_code = convertMiddleCategoryCode(obj.getCapability_category());

				if (pInfo.getCategory_middle().equals(category_code)) {
					score += 30;
					middleCheck = true;
					break;
				}
			}
		}
		if (middleCheck == false) {
			return -1;
		}

		// 3. 비교과 프로그램 NCS 일치 여부 확인
		// Preference_Information_VO preferenceInfo = studentDAO.getPreferenceInformation(university_number);
		if (preferenceInfo == null) {
			return -1;
		}
		
		if (pInfo.getRelated_NCS_part().equals("00")) {
			score += 20;
			ncsCheck = true;
		}else {
			if (pInfo.getRelated_NCS_part().equals(preferenceInfo.getNCS_part())) {
				score += 20;
				ncsCheck = true;
			}
		}

		// 4. 대상 학과(전공) 일치 여부 확인
		if (pInst.getMajor_number().equals("00000")) {
			score += 10;
			majorCheck = true;
		} else {
			if (pInst.getMajor_number().equals(student.getMajor_number())) {
				score += 10;
				majorCheck = true;
			}
		}

		if ((ncsCheck || majorCheck) == false) {
			return -1;
		}

		// 5. 선수 프로그램 참여 여부
		String preProgram = pInfo.getPrevious_program();
		if (preProgram != null) {

		} else {
			score += 8;
		}

		// 6. 운영방식 만족 여부
		String openMethod = pInst.getOperating_method();
		String preOpenMethod = preferenceInfo.getOperating_method();
		if (preOpenMethod.equals("0")) {
			score += 8;
		} else {
			if (openMethod.equals(preOpenMethod)) {
				score += 8;
			}
		}

		// 7. 운영기간 만족 여부
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date proStartDay = simpleDate.parse(pInst.getStart_day());
			Date proEndDay = simpleDate.parse(pInst.getEnd_day());

			Date preStartDay = simpleDate.parse(preferenceInfo.getStart_day());
			Date preEndDay = simpleDate.parse(preferenceInfo.getStart_day());

			if (preStartDay.after(proStartDay) || preEndDay.before(proEndDay)) {
				score += 8;
			} else if (preStartDay.equals(proStartDay) || preEndDay.before(proEndDay)) {
				score += 8;
			} else if (preStartDay.after(proStartDay) || preEndDay.equals(proEndDay)) {
				score += 8;
			} else if (preStartDay.equals(proStartDay) || preEndDay.equals(proEndDay)) {
				score += 8;
			}
		} catch (Exception e) {
			System.out.println("[운영기간 만족 여부 체크] errors...");
		}

		// 8. 대상 학년 만족 여부
		String studentGrade = student.getGrade();
		String targetGrade = pInst.getTarget_grade();
		if (targetGrade.equals("0")) {
			score += 8;
		} else {
			if (targetGrade.equals(studentGrade)) {
				score += 8;
			}
		}

		// 9. 대상 성별 만족 여부
		String studentSex = student.getSex();
		String targetSex = pInst.getTarget_sex();
		if (targetSex.equals("0")) {
			score += 8;
		} else {
			if (targetSex.equals(studentSex)) {
				score += 8;
			}
		}

		return score;
	}

	// 카테고리 명을 코드로 변환
	public String convertMiddleCategoryCode(String category_name) {
		for (Program_Middle_Category_VO obj : middle_category_list) {
			if (obj.getCategory_name().equals(category_name)) {
				return obj.getCode();
			}
		}
		return null;
	}

}
