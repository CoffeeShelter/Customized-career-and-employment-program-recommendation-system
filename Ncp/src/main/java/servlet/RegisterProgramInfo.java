package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.Program_DAO;
import data.utils.CategoryUtils;
import data.utils.ProgramUtils;
import data.vo.Program_Information_VO;

@WebServlet("/RegisterProgramInfo")
public class RegisterProgramInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterProgramInfo() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("code");
		
		Program_Information_VO program = Program_DAO.getProgram_Inforamtion(query);
		
		request.setAttribute("program", program);
		
		request.setAttribute("ncsList", CategoryUtils.ncsList);
		request.setAttribute("middleCategoryList", CategoryUtils.middleCategoryList);
		request.setAttribute("largeCategoryList", CategoryUtils.largeCategoryList);
		request.setAttribute("operatingTypeList", CategoryUtils.operatingTypeList);
		request.setAttribute("programList", ProgramUtils.program_information_list);
		
		System.out.println(CategoryUtils.operatingTypeList.toString());
		System.out.println(program.getOperating_type());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterProgramInfo.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
