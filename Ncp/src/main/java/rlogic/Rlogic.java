package rlogic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.Reco;
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
import data.vo.Recommendation_Result_VO;
import data.vo.Student_VO;

public class Rlogic {
	private Program_Middle_Category_DAO program_middle_category_DAO = null;
	private ProgramUtils programUtils = null;
	private CategoryUtils categoryUtils = null;

	private List<Program_Middle_Category_VO> middle_category_list = null;

	public Rlogic() {
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

	public List<List<Reco>> getReco(String university_number) {
		List<Reco> recommendationResults = Student_DAO.getReco(university_number);
		List<List<Reco>> results = null;
		if (recommendationResults != null) {
			if (recommendationResults.size() == 0) {
				results = getReccomendationResult(university_number);
			} else {
				results = convert(recommendationResults, university_number);
			}
		} else {
			results = getReccomendationResult(university_number);
		}
		return results;
	}

	public List<List<Reco>> getReccomendationResult(String university_number) {
		Student_VO student = Student_DAO.getStudent(university_number);

		List<Preparation_Level_VO> preLevel = null;
		preLevel = Preparation_Level_DAO.selectAll(university_number);
		Preference_Information_VO preferenceInfo = Student_DAO.getPreferenceInformation(university_number);
		List<Program_Instance_VO> program_instance_list = ProgramUtils.getProgram_instance_list();

		if (program_instance_list == null) {
			System.out.println("null");
			return null;
		}

		List<Reco> temps = new ArrayList<>();
		List<Recommendation_Result_VO> insertData = new ArrayList<>();
		for (Program_Instance_VO pInst : program_instance_list) {
			Program_Information_VO pInfo = programUtils.getProgram_Inforamtion(pInst.getCode());
			float score = getRecommendedScore(student, preLevel, preferenceInfo, pInst, pInfo);

			if (score != -1) {
				Reco reco = new Reco();
				reco.setCode(pInfo.getCode());
				reco.setCategory_large(pInfo.getCategory_large());
				reco.setCategory_large_name(CategoryUtils.getLargeCategoryName(pInfo.getCategory_large()));
				reco.setCategory_middle(pInfo.getCategory_middle());
				reco.setCategory_middle_name(CategoryUtils.getMiddleCategoryName(pInfo.getCategory_middle()));
				reco.setProgram_name(pInfo.getProgram_name());
				reco.setDay(pInst.getStart_day() + "~" + pInst.getEnd_day());
				reco.setCompletation_time(pInfo.getCompletation_time());
				reco.setOperating_state(pInst.getOperating_state());
				reco.setOperating_state_name(CategoryUtils.getOperatingStateName(pInst.getOperating_state()));
				reco.setRecommendation_degree(Float.toString(score));

				temps.add(reco);

				Recommendation_Result_VO data = new Recommendation_Result_VO();
				data.setCode(pInfo.getCode());
				data.setStart_day(pInst.getStart_day());
				data.setEnd_day(pInst.getEnd_day());
				data.setUniversity_number(university_number);
				data.setCapability_category(pInfo.getCategory_middle());
				data.setRecommendation_degree(score);

				insertData.add(data);
			}
		}

		List<List<Reco>> results = convert(temps, university_number);

		if (insertData.size() > 0) {
			int insert_result = Student_DAO.insertRecommendedResult(insertData);
			if (insert_result >= 0) {
				System.out.println("추천 결과 " + insert_result + "개 추가");
			}
		}
		return results;
	}

	public float getRecommendedScore(Student_VO student, List<Preparation_Level_VO> preLevel,
			Preference_Information_VO preferenceInfo, Program_Instance_VO pInst, Program_Information_VO pInfo) {
		boolean middleCheck = false;
		boolean ncsCheck = false;
		boolean majorCheck = false;

		float score = 0.0f;
		if (preLevel != null) {
			// 2. �񱳰� ���α׷� �� ī�װ� ��ġ ���� �˻� ( +30 )
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

		if (preferenceInfo == null) {
			return -1;
		}

		if (pInfo.getRelated_NCS_part().equals("00")) {
			score += 20;
			ncsCheck = true;
		} else {
			if (pInfo.getRelated_NCS_part().equals(preferenceInfo.getNCS_part())) {
				score += 20;
				ncsCheck = true;
			}
		}

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

		String preProgram = pInfo.getPrevious_program();
		if (preProgram != null) {

		} else {
			score += 8;
		}

		String openMethod = pInst.getOperating_method();
		String preOpenMethod = preferenceInfo.getOperating_method();
		if (preOpenMethod.equals("0")) {
			score += 8;
		} else {
			if (openMethod.equals(preOpenMethod)) {
				score += 8;
			}
		}

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
			System.out.println("[��Ⱓ ���� ���� üũ] errors...");
		}

		String studentGrade = student.getGrade();
		String targetGrade = pInst.getTarget_grade();
		if (targetGrade.equals("0")) {
			score += 8;
		} else {
			if (targetGrade.equals(studentGrade)) {
				score += 8;
			}
		}

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

	public String convertMiddleCategoryCode(String category_name) {
		for (Program_Middle_Category_VO obj : middle_category_list) {
			if (obj.getCategory_name().equals(category_name)) {
				return obj.getCode();
			}
		}
		return null;
	}

	public List<List<Reco>> convert(List<Reco> recommendationResults, String university_number) {
		List<List<Reco>> results = new ArrayList<>();
		List<Preparation_Level_VO> levels = Preparation_Level_DAO.selectAll(university_number);

		List<Reco> temp1 = new ArrayList<>();
		List<Reco> temp2 = new ArrayList<>();
		List<Reco> temp3 = new ArrayList<>();

		for (Reco result : recommendationResults) {
			if (levels.get(0).getCapability_category().equals(result.getCategory_middle_name())) {
				temp1.add(result);
			} else if (levels.get(1).getCapability_category().equals(result.getCategory_middle_name())) {
				temp2.add(result);
			} else if (levels.get(2).getCapability_category().equals(result.getCategory_middle_name())) {
				temp3.add(result);
			}
		}

		results.add(temp1);
		results.add(temp2);
		results.add(temp3);

		return results;
	}

}
