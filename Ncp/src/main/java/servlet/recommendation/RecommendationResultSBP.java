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

import com.google.gson.Gson;

import data.utils.ProgramUtils;
import rlogic.Recommendation_Program;

@WebServlet("/sbp")
public class RecommendationResultSBP extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecommendationResultSBP() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		ProgramUtils programUtils = new ProgramUtils();
		Recommendation_Program recoProgram = new Recommendation_Program();

		String programName = request.getParameter("programName");
		String code = programUtils.getProgramCode(programName);

		List<Map<String, String>> datum = recoProgram.getPrettyRecommendation(code);

		String result = getJSON(datum);
		response.getWriter().write(result);

		request.setAttribute("recoList", datum);
		RequestDispatcher dispatcher = request.getRequestDispatcher("RecoList.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		ProgramUtils programUtils = new ProgramUtils();
		Recommendation_Program recoProgram = new Recommendation_Program();

		String programName = request.getParameter("programName");
		String code = programUtils.getProgramCode(programName);

		List<Map<String, String>> datum = recoProgram.getPrettyRecommendation(code);

		String result = getJSON(datum);
		System.out.println(programName);
		response.getWriter().write(result);
	}

	public String getJSON(List<Map<String, String>> data) {
		Gson gson = new Gson();
		String result = "";

		result = gson.toJson(data);
		System.out.println(result);

		return result;
	}
}
