package servlet;

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

@WebServlet("/recoList")
public class RecoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Recommendation_Program recoProgram = new Recommendation_Program();

	public RecoList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("code");
		String programName = ProgramUtils.getProgramName(code);

		List<Map<String, String>> datum = recoProgram.getPrettyRecommendation(code);

		request.setAttribute("recoList", datum);
		request.setAttribute("programName", programName);

		RequestDispatcher dispatcher = request.getRequestDispatcher("RecoList.jsp");
		dispatcher.forward(request, response);

	}

}
