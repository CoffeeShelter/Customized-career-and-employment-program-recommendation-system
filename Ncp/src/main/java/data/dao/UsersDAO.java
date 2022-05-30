package data.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Manager_Information_VO;
import data.vo.Users_VO;

public class UsersDAO {
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

	public static Users_VO getUser(String number) {
		Users_VO user = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		user = session.selectOne("mapper.users.selectOne", number);

		return user;
	}

	public static List<Manager_Information_VO> getManager() {
		List<Manager_Information_VO> managers = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		managers = session.selectList("mapper.manager_information.selectAll");

		return managers;
	}

}
