package config;

import java.util.ArrayList;
import java.util.List;

import data.dao.Preference_Information_DAO;
import data.dao.Preparation_Level_DAO;
import data.dao.Program_Middle_Category_DAO;
import data.vo.Preference_Information_VO;
import data.vo.Preparation_Level_VO;
import data.vo.Program_Middle_Category_VO;

public class Preference_Information_Test {

	public static void main(String[] args) {
		// Preference_Information_DAO pInfo_DAO = new Preference_Information_DAO();
		Preparation_Level_DAO pLevel_DAO = new Preparation_Level_DAO();
		Program_Middle_Category_DAO middle_category_DAO = new Program_Middle_Category_DAO();

		// List<Preference_Information_VO> list = new
		// ArrayList<Preference_Information_VO>();
		List<Preparation_Level_VO> list = new ArrayList<Preparation_Level_VO>();
		List<Program_Middle_Category_VO> middle_category_list = new ArrayList<Program_Middle_Category_VO>();

		// list = pInfo_DAO.selectAll();
		list = pLevel_DAO.selectAll();
		middle_category_list = middle_category_DAO.selectAll();

		for (Program_Middle_Category_VO middle_category : middle_category_list) {
			for (Preparation_Level_VO obj : list) {
				if (middle_category.getCategory_name().equals(obj.getCapability_category())) {
					System.out.println(obj.getCapability_category() + " : " + middle_category.getCode());
				}
			}
		}

	}

}
