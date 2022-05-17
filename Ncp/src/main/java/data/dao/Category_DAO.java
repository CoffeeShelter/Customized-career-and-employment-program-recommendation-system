package data.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Major_Information_VO;
import data.vo.NCS_Part_VO;
import data.vo.Program_Operating_Type_VO;
import data.vo.Student_Sex_VO;

public class Category_DAO {
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

	public List<Major_Information_VO> majorSelectAll() {
		List<Major_Information_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.major_information.selectAll");

		return datum;
	}
	
	public List<Student_Sex_VO> sexSelectAll() {
		List<Student_Sex_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.student_sex.selectAll");

		return datum;
	}
	
	public List<NCS_Part_VO> ncsSelectAll(){
		List<NCS_Part_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.ncs_part.selectAll");

		return datum;
	}
	
	public List<Program_Operating_Type_VO> operatingTypeSelectAll(){
		List<Program_Operating_Type_VO> datum = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		datum = session.selectList("mapper.program_operating_type.selectAll");

		return datum;
	}
	
}
