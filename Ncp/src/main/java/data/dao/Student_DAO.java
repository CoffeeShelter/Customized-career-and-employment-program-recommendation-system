package data.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.Preference_Information_VO;
import data.vo.Student_VO;

public class Student_DAO {
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

	public Preference_Information_VO getPreferenceInformation(String university_number) {
		Preference_Information_VO data = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		Map<String, Object> parameter = new HashMap<>();

		parameter.put("university_number", university_number);

		data = session.selectOne("mapper.preference_information.selectOne", parameter);

		return data;
	}

	public Student_VO getStudent(String university_number) {
		Student_VO data = null;

		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();

		Map<String, Object> parameter = new HashMap<>();

		parameter.put("university_number", university_number);

		data = session.selectOne("mapper.student.selectOne", parameter);

		return data;
	}
}
