package servlet.recommendation;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.utils.ProgramUtils;
import rlogic.Recommendation_Program;

/**
 * Servlet implementation class RecommendationResultSBP
 */
@WebServlet("/sbp")
public class RecommendationResultSBP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecommendationResultSBP() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		ProgramUtils programUtils = new ProgramUtils();
		Recommendation_Program recoProgram = new Recommendation_Program();
		
		String programName = request.getParameter("programName");
		String code = programUtils.getProgramCode(programName);
		
		List<Map<String, String>> datum = recoProgram.getPrettyRecommendation(code);
		
		request.setAttribute("recoList", datum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("RecoList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
