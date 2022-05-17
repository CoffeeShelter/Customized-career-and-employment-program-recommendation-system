package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.utils.CategoryUtils;
import data.utils.ProgramUtils;

@WebServlet("/registerProgramInfo")
public class RegisterProgramInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterProgramInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setAttribute("ncsList", CategoryUtils.ncsList);
		request.setAttribute("middleCategoryList", CategoryUtils.middleCategoryList);
		request.setAttribute("largeCategoryList", CategoryUtils.largeCategoryList);
		request.setAttribute("operatingTypeList", CategoryUtils.operatingTypeList);
		request.setAttribute("programList", ProgramUtils.program_information_list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterProgramInfo.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
