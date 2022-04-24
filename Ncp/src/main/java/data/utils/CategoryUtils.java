package data.utils;

import java.util.List;

import data.dao.Program_Large_Category_DAO;
import data.dao.Program_Middle_Category_DAO;
import data.vo.Program_Large_Category_VO;
import data.vo.Program_Middle_Category_VO;

public class CategoryUtils {
	private static List<Program_Large_Category_VO> largeCategoryList;
	private static List<Program_Middle_Category_VO> middleCategoryList;

	static {
		Program_Middle_Category_DAO middleCategoryDAO = new Program_Middle_Category_DAO();
		middleCategoryList = middleCategoryDAO.selectAll();
		Program_Large_Category_DAO largeCategoryDAO = new Program_Large_Category_DAO();
		largeCategoryList = largeCategoryDAO.selectAll();
	}

	public List<Program_Middle_Category_VO> getMiddleCategoryList() {
		return middleCategoryList;
	}
	
	public List<Program_Large_Category_VO> getLargeCategoryList() {
		return largeCategoryList;
	}

	// 비교과 프로그램 중 카테고리 반환
	public String getMiddleCategoryName(String code) {
		for (Program_Middle_Category_VO obj : middleCategoryList) {
			if (obj.getCode().equals(code)) {
				return obj.getCategory_name();
			}
		}
		return null;
	}
	
	// 비교과 프로그램 대 카테고리 반환
	public String getLargeCategoryName(String code) {
		for (Program_Large_Category_VO obj : largeCategoryList) {
			if (obj.getCode().equals(code)) {
				return obj.getCategory_name();
			}
		}
		return null;
	}
}
