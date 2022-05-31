package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.Program_DAO;
import data.dao.UsersDAO;
import data.utils.CategoryUtils;
import data.vo.Program_Information_VO;
import data.vo.Program_Instance_VO;

@WebServlet("/registerProgramInst")
public class RegisterProgramInstance extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterProgramInstance() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("operating_method_list", CategoryUtils.operatingMethodList);
		request.setAttribute("college_information_list", CategoryUtils.collegeInformationList);
		request.setAttribute("department_information_list", CategoryUtils.departmentInformationList);
		request.setAttribute("major_information_list", CategoryUtils.majorInformationList);
		request.setAttribute("student_sex_list", CategoryUtils.studentSexList);
		request.setAttribute("managers", UsersDAO.getManager());

		String code = request.getParameter("code");
		String start_day = request.getParameter("start_day");
		String end_day = request.getParameter("end_day");
		
		Program_Instance_VO programInst = Program_DAO.getProgram_Instance(code, start_day, end_day);
		Program_Information_VO program = Program_DAO.getProgram_Inforamtion(code);
		
		if (program != null) {
			String[] TALENT_capability = program.getTALENT_capability().split("/");
			request.setAttribute("TALENT_capability", TALENT_capability);
		}
		
		request.setAttribute("programCode", code);
		request.setAttribute("program", program);
		request.setAttribute("programInst", programInst);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterProgramInstance.jsp");
		dispatcher.forward(request, response);

	}

}
