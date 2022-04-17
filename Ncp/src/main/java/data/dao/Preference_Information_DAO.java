package data.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Preference_Information_VO;

public class Preference_Information_DAO {
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
	public List<Preference_Information_VO> selectAll() {
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		List<Preference_Information_VO> preference_information_list = null;
		preference_information_list = session.selectList("mapper.preference_information.selectAll");
		
		return preference_information_list;
	}

}
