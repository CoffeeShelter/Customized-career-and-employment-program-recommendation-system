package data.dao;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import data.vo.College_Information_VO;
import data.vo.Department_Information_VO;
import data.vo.Major_Information_VO;
import data.vo.Manager_Information_VO;
import data.vo.NCS_Part_VO;
import data.vo.Operating_State_VO;
import data.vo.Preparation_Level_VO;
import data.vo.Program_Large_Category_VO;
import data.vo.Program_Middle_Category_VO;
import data.vo.Program_Operating_Method_VO;
import data.vo.Program_Operating_Type_VO;
import data.vo.Student_Grade_VO;
import data.vo.Student_Sex_VO;
import data.vo.TALENT_Capability_VO;

public class BaseData_DAO {
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

	public Map<String, Object> loadData() {
		Map<String, Object> datum = new HashMap<String, Object>();
		
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		
		List<Program_Large_Category_VO> program_large_category_list = null;
		program_large_category_list = session.selectList("mapper.program_large_category.selectAll");
		datum.put("Program_Large_Category", program_large_category_list);
		
		List<Program_Middle_Category_VO> program_middle_category_list = null;
		program_middle_category_list = session.selectList("mapper.program_middle_category.selectAll");
		datum.put("Program_Middle_Category", program_middle_category_list);
		
		List<Program_Operating_Type_VO> program_operating_type_list = null;
		program_operating_type_list = session.selectList("mapper.program_operating_type.selectAll");
		datum.put("Program_Operating_Type", program_operating_type_list);
		
		List<NCS_Part_VO> ncs_part_list = null;
		ncs_part_list = session.selectList("mapper.ncs_part.selectAll");
		datum.put("NCS_Part", ncs_part_list);
		
		List<TALENT_Capability_VO> talent_capability_list = null;
		talent_capability_list = session.selectList("mapper.talent_capability.selectAll");
		datum.put("TALENT_Capability", talent_capability_list);
		
		List<Program_Operating_Method_VO> program_operating_method_list = null;
		program_operating_method_list = session.selectList("mapper.program_operating_method.selectAll");
		datum.put("Program_Operating_Method", program_operating_method_list);
		
		List<College_Information_VO> college_information_list = null;
		college_information_list = session.selectList("mapper.college_information.selectAll");
		datum.put("College_Information", college_information_list);
		
		List<Department_Information_VO> department_information_list = null;
		department_information_list = session.selectList("mapper.department_information.selectAll");
		datum.put("Department_Information", department_information_list);
		
		List<Major_Information_VO> major_information_list = null;
		major_information_list = session.selectList("mapper.major_information.selectAll");
		datum.put("Major_Information", major_information_list);
		
		List<Student_Grade_VO> student_grade_list = null;
		student_grade_list = session.selectList("mapper.student_grade.selectAll");
		datum.put("Student_Grade", student_grade_list);
		
		List<Student_Sex_VO> student_sex_list = null;
		student_sex_list = session.selectList("mapper.student_sex.selectAll");
		datum.put("Student_Sex", student_sex_list);
		
		List<Manager_Information_VO> manager_information_list = null;
		manager_information_list = session.selectList("mapper.manager_information.selectAll");
		datum.put("Manager_Information", manager_information_list);
		
		List<Operating_State_VO> operating_state_list = null;
		operating_state_list = session.selectList("mapper.operating_state.selectAll");
		datum.put("Operating_State", operating_state_list);
		
		return datum;
	}

}
