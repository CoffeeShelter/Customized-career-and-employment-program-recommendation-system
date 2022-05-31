package data.utils;

import java.util.List;

import data.dao.Category_DAO;
import data.dao.Program_Large_Category_DAO;
import data.dao.Program_Middle_Category_DAO;
import data.dao.Student_DAO;
import data.vo.College_Information_VO;
import data.vo.Department_Information_VO;
import data.vo.Major_Information_VO;
import data.vo.NCS_Part_VO;
import data.vo.Operating_State_VO;
import data.vo.Preference_Information_VO;
import data.vo.Program_Large_Category_VO;
import data.vo.Program_Middle_Category_VO;
import data.vo.Program_Operating_Method_VO;
import data.vo.Program_Operating_Type_VO;
import data.vo.Student_Sex_VO;

public class CategoryUtils {
	public static List<Program_Large_Category_VO> largeCategoryList;
	public static List<Program_Middle_Category_VO> middleCategoryList;
	public static List<Student_Sex_VO> studentSexList;
	public static List<Preference_Information_VO> preferenceList;
	public static List<NCS_Part_VO> ncsList;
	public static List<Program_Operating_Type_VO> operatingTypeList;
	public static List<Program_Operating_Method_VO> operatingMethodList;
	public static List<College_Information_VO> collegeInformationList;
	public static List<Department_Information_VO> departmentInformationList;
	public static List<Major_Information_VO> majorInformationList;
	public static List<Operating_State_VO> operatingStateList;

	// private static Category_DAO categoryDAO = null;
	private static Student_DAO studentDAO = null;
	private static Program_Middle_Category_DAO middleCategoryDAO = null;
	private static Program_Large_Category_DAO largeCategoryDAO = null;

	static {
		/*
		if (categoryDAO == null) {
			categoryDAO = new Category_DAO();
		}
		*/
		if (studentDAO == null) {
			studentDAO = new Student_DAO();
		}
		if (middleCategoryDAO == null) {
			middleCategoryDAO = new Program_Middle_Category_DAO();
		}
		if (largeCategoryDAO == null) {
			largeCategoryDAO = new Program_Large_Category_DAO();
		}

		middleCategoryList = middleCategoryDAO.selectAll();
		largeCategoryList = largeCategoryDAO.selectAll();
		studentSexList = Category_DAO.sexSelectAll();
		preferenceList = studentDAO.getPreferenceInformation();
		ncsList = Category_DAO.ncsSelectAll();
		operatingTypeList = Category_DAO.operatingTypeSelectAll();
		operatingMethodList = Category_DAO.operatingMethodSelectAll();
		collegeInformationList = Category_DAO.collegeInformationSelectAll();
		departmentInformationList = Category_DAO.departmentInformationSelectAll();
		majorInformationList = Category_DAO.majorSelectAll();
		operatingStateList = Category_DAO.operatingStateSelectAll();
	}

	public static List<Program_Middle_Category_VO> getMiddleCategoryList() {
		return middleCategoryList;
	}

	public static List<Program_Large_Category_VO> getLargeCategoryList() {
		return largeCategoryList;
	}

	public static String getMiddleCategoryName(String code) {
		for (Program_Middle_Category_VO obj : middleCategoryList) {
			if (obj.getCode().equals(code)) {
				return obj.getCategory_name();
			}
		}
		return null;
	}

	public static String getLargeCategoryName(String code) {
		for (Program_Large_Category_VO obj : largeCategoryList) {
			if (obj.getCode().equals(code)) {
				return obj.getCategory_name();
			}
		}
		return null;
	}

	public static String getMajorName(String code) {
		for (Major_Information_VO obj : majorInformationList) {
			if (obj.getCode().equals(code)) {
				return obj.getCategory_name();
			}
		}
		return null;
	}

	public static String getStudentSexName(String code) {
		for (Student_Sex_VO obj : studentSexList) {
			if (obj.getCode().equals(code)) {
				return obj.getCategory_name();
			}
		}
		return null;
	}

	public static String getNcsName(String code) {
		for (NCS_Part_VO obj : ncsList) {
			if (obj.getCode().equals(code)) {
				return obj.getCategory_name();
			}
		}
		return null;
	}

	public static String getStudentNCS(String university_number) {
		Preference_Information_VO preLevel = null;
		preLevel = studentDAO.getPreferenceInformation(university_number);

		String ncsCode = preLevel.getNCS_part();
		String ncsName = getNcsName(ncsCode);

		return ncsName;
	}

	public static String getOperatingTypeName(String code) {
		for (Program_Operating_Type_VO obj : operatingTypeList) {
			if (obj.getCode().equals(code)) {
				return obj.getCategory_name();
			}
		}
		return null;
	}
	
	public static String getOperatingStateName(String code) {
		for (Operating_State_VO obj : operatingStateList) {
			if (obj.getCode().equals(code)) {
				return obj.getCategory_name();
			}
		}
		return null;
	}
}
