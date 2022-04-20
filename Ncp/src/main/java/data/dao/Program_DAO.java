package data.dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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

	public List<Program_Instance_VO> getProgram_Instance() {
		List<Program_Instance_VO> datum = new ArrayList<Program_Instance_VO>();
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		datum = session.selectList("mapper.program_instance.selectAll");
		
		return datum;
	}

}
