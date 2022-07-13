package servlet.student;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.Student_DAO;
import data.vo.Student_VO;

@WebServlet("/swp")
public class StudentWithPro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentWithPro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String professor = request.getParameter("professor");
		
		List<Student_VO> students = Student_DAO.getStudentForProf(professor);
		
		Map<String, Object> mapData = new HashMap<>();
		
		// List<Map<String, String>> datum = new ArrayList<>();
		for(Student_VO student : students) {
			Map<String, String> studentData = new HashMap<>();
			studentData.put("university_number", student.getUniversity_number());
			studentData.put("name", student.getName());
			studentData.put("major_number", student.getMajor());
			studentData.put("grade", student.getGrade());
			studentData.put("sex", student.getSex());
			studentData.put("Professor_number", student.getProfessor_number());
			
		}
	}

}
