package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.utils.CategoryUtils;

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

		RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterProgramInstance.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
