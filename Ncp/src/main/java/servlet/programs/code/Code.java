package servlet.programs.code;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.dao.Program_DAO;

@WebServlet("/programs/code")
public class Code extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Code() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String code = request.getParameter("code");
		
		String maxCode = Program_DAO.getProgramMaxCode(code);
		if (maxCode == null) {
			maxCode = "0";
		}
		
		System.out.println(maxCode);
		
		Map<String, String> data = new HashMap<>();
		data.put("maxCode", maxCode);
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(data);
		
		response.getWriter().write(jsonData);
	}

}
