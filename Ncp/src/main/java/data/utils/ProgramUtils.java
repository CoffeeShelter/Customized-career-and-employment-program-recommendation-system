package data.utils;

import java.util.List;

import data.dao.Program_DAO;
import data.vo.Program_Information_VO;
import data.vo.Program_Instance_VO;

public class ProgramUtils {

	private static Program_DAO program_DAO = null;
	public static List<Program_Information_VO> program_information_list = null;
	public static List<Program_Instance_VO> program_instance_list = null;

	static {
		if (program_information_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
			program_information_list = Program_DAO.getProgram_Inforamtion();
		}

		if (program_instance_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
			program_instance_list = Program_DAO.getProgram_Instance();
		}
	}

	public ProgramUtils() {

	}

	public static List<Program_Information_VO> getProgramInformation() {
		if (program_information_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
			program_information_list = Program_DAO.getProgram_Inforamtion();
		}
		return program_information_list;
	}

	public static List<Program_Instance_VO> getProgramInstance() {
		if (program_instance_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
			program_instance_list = Program_DAO.getProgram_Instance();
		}
		return program_instance_list;
	}

	public Program_Information_VO getProgram_Inforamtion(String code) {
		if (program_instance_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
		}

		for (Program_Information_VO obj : program_information_list) {
			if (obj.getCode().equals(code)) {
				return obj;
			}
		}

		return null;
	}

	public static Program_DAO getProgram_DAO() {
		return program_DAO;
	}

	public static List<Program_Information_VO> getProgram_information_list() {
		return program_information_list;
	}

	public static List<Program_Instance_VO> getProgram_instance_list() {
		return program_instance_list;
	}

	public static String getProgramName(String code) {
		for (Program_Information_VO obj : program_information_list) {
			if (obj.getCode().equals(code)) {
				return obj.getProgram_name();
			}
		}
		return null;
	}

	public static String getProgramCode(String programName) {
		for (Program_Information_VO obj : program_information_list) {
			if (obj.getProgram_name().equals(programName)) {
				return obj.getCode();
			}
		}
		return null;
	}
}
