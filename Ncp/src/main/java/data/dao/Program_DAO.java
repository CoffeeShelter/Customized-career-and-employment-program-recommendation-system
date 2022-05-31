package data.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Program_Information_VO;
import data.vo.Program_Instance_VO;

public class Program_DAO {
	private static SqlSessionFactory sqlMapper = null;

	private static SqlSessionFactory getInstance() {
		if (sqlMapper == null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}

	public static List<Program_Instance_VO> getProgram_Instance() {
		List<Program_Instance_VO> datum = new ArrayList<Program_Instance_VO>();

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.program_instance.selectAll");

		return datum;
	}
	
	public static List<Program_Instance_VO> getProgram_Instance(String code) {
		List<Program_Instance_VO> datum = new ArrayList<Program_Instance_VO>();
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		datum = session.selectList("mapper.program_instance.searchInst", code);
		
		return datum;
	}
	
	public static Program_Instance_VO getProgram_Instance(String code, String start_day, String end_day) {
		Program_Instance_VO data = null;
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		Map<String, Object> parameter = new HashMap<>();
		parameter.put("code", code);
		parameter.put("start_day", start_day);
		parameter.put("end_day", end_day);		
		data = session.selectOne("mapper.program_instance.searchOneInst", parameter);
		
		return data;
	}

	public static int insertProgram_Instance(Program_Instance_VO programInstance) {
		int result = -1;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		result = session.insert("mapper.program_instance.insertInst", programInstance);
		if (result > 0) {
			session.commit();
		}

		return result;
	}
	
	public static int updateProgram_Instance(Map<String, Object> parameter) {
		int result = -1;
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		result = session.update("mapper.program_instance.updateInst", parameter);
		if (result > 0) {
			session.commit();
		}
		
		return result;
	}
	
	public static List<Program_Information_VO> getProgram_Inforamtion() {
		List<Program_Information_VO> datum = new ArrayList<Program_Information_VO>();

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.program_information.selectAll");

		return datum;
	}

	public static Program_Information_VO getProgram_Inforamtion(String code) {
		Program_Information_VO data = null;
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		Map<String, Object> programMap = new HashMap<>();

		programMap.put("code", code);

		data = session.selectOne("mapper.program_information.selectOne", programMap);

		return data;
	}
	
	public static List<Program_Information_VO> searchProgram_Inforamtion(String program_name) {
		List<Program_Information_VO> datum = new ArrayList<Program_Information_VO>();
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		Map<String, Object> programMap = new HashMap<>();
		
		programMap.put("program_name", program_name);
		
		datum = session.selectList("mapper.program_information.searchPrograms", programMap);
		
		return datum;
	}

	public static int insertProgram_Information(Program_Information_VO programInformationVO) {
		int result = -1;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		result = session.insert("mapper.program_information.insertOne", programInformationVO);
		if (result > 0) {
			session.commit();
		}

		return result;
	}
	
	public static int updateProgram_Information(Program_Information_VO programInformationVO) {
		int result = -1;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		result = session.update("mapper.program_information.updateProgram", programInformationVO);
		if (result > 0) {
			session.commit();
		}

		return result;
	}
	
	public static int deleteProgram_Information(String code) {
		int result = -1;
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		result = session.delete("mapper.program_information.deleteProgram", code);
		if (result > 0) {
			session.commit();
		}
		
		return result;
	}
	
	public static String getProgramMaxCode(String code) {
		String result = null;
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		result = session.selectOne("mapper.program_information.maxProgramsCode", code);
		
		return result;
	}

}
