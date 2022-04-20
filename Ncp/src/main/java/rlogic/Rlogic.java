package rlogic;

import java.util.List;

import data.dao.Preparation_Level_DAO;
import data.dao.Program_Middle_Category_DAO;
import data.dao.Student_DAO;
import data.utils.ProgramUtils;
import data.vo.Preference_Information_VO;
import data.vo.Preparation_Level_VO;
import data.vo.Program_Information_VO;
import data.vo.Program_Instance_VO;
import data.vo.Program_Middle_Category_VO;
import data.vo.Recommendation_Result_VO;

public class Rlogic {

	private Preparation_Level_DAO preparation_level_DAO = null;
	private Program_Middle_Category_DAO program_middle_category_DAO = null;
	private static ProgramUtils programUtils = null;

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
	}

	public Recommendation_Result_VO getReccomendationResult(String student_number) {
		Recommendation_Result_VO result = null;

		List<Program_Instance_VO> program_instance_list = ProgramUtils.getProgram_instance_list();

		if (program_instance_list == null) {
			System.out.println("null");
			return null;
		}

		for (Program_Instance_VO pInst : program_instance_list) {
			Program_Information_VO pInfo = programUtils.getProgram_Inforamtion(pInst.getCode());
			int score = getRecommendedScore(student_number, pInst);

			System.out.println(pInfo.getProgram_name() + " : " + score + "점");
		}

		return result;
	}

	public int getRecommendedScore(String university_number, Program_Instance_VO pInst) {
		boolean middleCheck = false;
		boolean ncsCheck = false;
		boolean majorCheck = false;

		int score = 0;

		Program_Information_VO pInfo = programUtils.getProgram_Inforamtion(pInst.getCode());

		// 1. 학생의 역량별 진단 수준 결과 하위 3개
		List<Preparation_Level_VO> preLevel = null;
		preLevel = preparation_level_DAO.selectAll(university_number);

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
		Student_DAO studentDAO = new Student_DAO();
		Preference_Information_VO preferenceInfo = studentDAO.getPreferenceInformation(university_number);
		if (preferenceInfo == null) {
			return -1;
		}

		if (pInfo.getRelated_NCS_part().equals(preferenceInfo.getNCS_part())
				|| preferenceInfo.getNCS_part().equals("00")) {
			score += 20;
			ncsCheck = true;
		}

		if (pInst.getMajor_number().equals("00000")) {
			score += 10;
			majorCheck = true;
		}

		if ((ncsCheck || majorCheck) == false) {
			return -1;
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
