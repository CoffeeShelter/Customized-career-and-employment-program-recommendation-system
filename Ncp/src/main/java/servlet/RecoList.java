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

import rlogic.Recommendation_Program;

@WebServlet("/recoList")
public class RecoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecoList() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Recommendation_Program recoProgram = new Recommendation_Program();
		List<Map<String, String>> datum = recoProgram.getPrettyRecommendation("12001");
		
		request.setAttribute("recoList", datum);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("RecoList.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}