package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.RecommendationResult;
import data.dao.Preparation_Level_DAO;
import data.vo.Preparation_Level_VO;
import rlogic.Rlogic;

@WebServlet("/mypage")
public class MyPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyPage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Preparation_Level_DAO preparation_level_DAO = new Preparation_Level_DAO();
		List<Preparation_Level_VO> preLevel = null;
		preLevel = preparation_level_DAO.selectAll("201910823");

		Rlogic rLogic = new Rlogic();

		Vector<Vector<RecommendationResult>> results = rLogic.getReccomendationResult("201910823");

		request.setAttribute("results", results);
		request.setAttribute("preLevels", preLevel);

		RequestDispatcher dispatcher = request.getRequestDispatcher("MyPage.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
