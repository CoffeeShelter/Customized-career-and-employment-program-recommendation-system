package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.dao.UsersDAO;
import data.vo.Users_VO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");

		String number = request.getParameter("number");
		
		Users_VO user = UsersDAO.getUser(number);

		if (user == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 정보 입니다.'); location.href='index.jsp';</script>");
			out.flush();
		} else {		
			Cookie cookie1 = new Cookie("number", user.getNumber());
			Cookie cookie2 = new Cookie("power", user.getPower());

			cookie1.setMaxAge(60 * 30);
			cookie2.setMaxAge(60 * 30);

			response.addCookie(cookie1);
			response.addCookie(cookie2);

			response.sendRedirect("index.jsp");
			// RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			// dispatcher.forward(request, response);
		}

	}

}
