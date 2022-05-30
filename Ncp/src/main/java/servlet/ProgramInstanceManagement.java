package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.Program_DAO;
import data.vo.Program_Information_VO;
import data.vo.Program_Instance_VO;

@WebServlet("/programInstanceManagement")
public class ProgramInstanceManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProgramInstanceManagement() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		Program_Information_VO program = Program_DAO.getProgram_Inforamtion(code);
		List<Program_Instance_VO> programInst = Program_DAO.getProgram_Instance(code);
		
		request.setAttribute("program", program);
		request.setAttribute("programInst", programInst);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ProgramInstanceManagement.jsp");
		dispatcher.forward(request, response);
	}

}
