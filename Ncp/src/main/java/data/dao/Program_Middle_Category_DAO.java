package data.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Preparation_Level_VO;
import data.vo.Program_Middle_Category_VO;

public class Program_Middle_Category_DAO {
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
	
	// 전체 상품 정보 조회
	public List<Program_Middle_Category_VO> selectAll() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		List<Program_Middle_Category_VO> program_middle_category_list = null;
		program_middle_category_list = session.selectList("mapper.program_middle_category.selectAll");
		
		return program_middle_category_list;
	}

}
