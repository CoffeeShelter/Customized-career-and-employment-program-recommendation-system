package servlet.programs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.Program_DAO;
import data.vo.Program_Information_VO;

@WebServlet("/programs")
public class Programs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Program_DAO programDAO = null;

	public Programs() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		programDAO = new Program_DAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int result = -1;
		
		String code = request.getParameter("code");
		String program_name = request.getParameter("program_name");
		String category_large = request.getParameter("category_large");
		String category_middle = request.getParameter("category_middle");
		String operating_type = request.getParameter("operating_type");
		String related_NCS_part = request.getParameter("related_NCS_part");
		String completation_time = request.getParameter("completation_time");
		
		String TALENT_capability = request.getParameter("TALENT_capability_01") + "/" +
									request.getParameter("TALENT_capability_02") + "/" +
									request.getParameter("TALENT_capability_03") + "/" +
									request.getParameter("TALENT_capability_04") + "/" +
									request.getParameter("TALENT_capability_05") + "/" +
									request.getParameter("TALENT_capability_06");
		
		String previous_program = request.getParameter("previous_program");
		String after_program = request.getParameter("after_program");
		String program_goal = request.getParameter("program_goal");
		String program_detail = request.getParameter("program_detail");

		Program_Information_VO programInformationVO = new Program_Information_VO(code, program_name, category_large,
				category_middle, operating_type, related_NCS_part, completation_time, TALENT_capability,
				previous_program, after_program, program_goal, program_detail);

		result = programDAO.insertProgram_Information(programInformationVO);
		
		System.out.println("추가 완료 " + result);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterProgramInfo.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
