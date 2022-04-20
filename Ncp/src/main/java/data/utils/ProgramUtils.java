package data.utils;

import java.util.List;

import data.dao.Program_DAO;
import data.vo.Program_Information_VO;
import data.vo.Program_Instance_VO;

public class ProgramUtils {

	private static Program_DAO program_DAO = null;
	private static List<Program_Information_VO> program_information_list = null;
	private static List<Program_Instance_VO> program_instance_list = null;

	public ProgramUtils() {
		if (program_information_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
			program_information_list = program_DAO.getProgram_Inforamtion();
		}

		if (program_instance_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
			program_instance_list = program_DAO.getProgram_Instance();
		}
	}

	public static List<Program_Information_VO> getProgramInformation() {
		if (program_information_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
			program_information_list = program_DAO.getProgram_Inforamtion();
		}
		return program_information_list;
	}

	public static List<Program_Instance_VO> getProgramInstance() {
		if (program_instance_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
			program_instance_list = program_DAO.getProgram_Instance();
		}
		return program_instance_list;
	}

	public Program_Information_VO getProgram_Inforamtion(String code) {
		Program_Information_VO data = null;

		if (program_instance_list == null) {
			if (program_DAO == null) {
				program_DAO = new Program_DAO();
			}
		}
		
		data = program_DAO.getProgram_Inforamtion(code);

		return data;
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

}
