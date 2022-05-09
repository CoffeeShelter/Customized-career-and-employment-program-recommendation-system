package config;

import java.util.List;

import data.dao.Student_DAO;
import data.vo.Recommendation_Result_VO;
import rlogic.Rlogic;

public class Preference_Information_Test {

	public static void main(String[] args) {
		Rlogic rLogic = new Rlogic();
		rLogic.getReccomendationResult("202011346");

		Student_DAO dao = new Student_DAO();

		List<Recommendation_Result_VO> datum = dao.getRecommendationResult("201910823");
		if (datum != null) {
			for (Recommendation_Result_VO obj: datum) {
				System.out.println(obj.toString());
			}
		}

		
	}
}