package servlet.student;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.dao.Student_DAO;
import data.vo.Preference_Information_VO;

@WebServlet("/student/preferenceinformation")
public class PreferenceInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = null;

	public PreferenceInformation() {
		this.gson = new Gson();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String university_number = request.getParameter("university_number");

		Preference_Information_VO data = null;
		Map<String, String> mapData = new HashMap<>();
		data = Student_DAO.getPreferenceInformation(university_number);

		String result = null;

		if (data != null) {
			mapData.put("status", "success");

			mapData.put("university_number", data.getUniversity_number());
			mapData.put("NCS_part", data.getNCS_part());
			mapData.put("start_day", data.getStart_day());
			mapData.put("end_day", data.getEnd_day());
			mapData.put("operating_method", data.getOperating_method());

		} else {
			mapData.put("status", "bad");
		}

		result = gson.toJson(mapData);
		response.getWriter().write(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String university_number = request.getParameter("university_number");
		String NCS_part = request.getParameter("NCS_part");
		String start_day = request.getParameter("start_day");
		String end_day = request.getParameter("end_day");
		String operating_method = request.getParameter("operating_method");

		Preference_Information_VO data = new Preference_Information_VO(university_number, NCS_part, start_day, end_day,
				operating_method);

		int result = Student_DAO.insertPreferenceInformation(data);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");

		String university_number = request.getParameter("university_number");
		String NCS_part = request.getParameter("NCS_part");
		String start_day = request.getParameter("start_day");
		String end_day = request.getParameter("end_day");
		String operating_method = request.getParameter("operating_method");

		Preference_Information_VO data = new Preference_Information_VO(university_number, NCS_part, start_day, end_day,
				operating_method);

		Preference_Information_VO temp = Student_DAO.getPreferenceInformation(university_number);

		int result = -1;
		if (temp == null) {
			doPost(request, response);
			result = 1;
		} else {
			System.out.println(temp.getUniversity_number());
			result = Student_DAO.updatePreferenceInformation(data);
		}

		if (result >= 0) {
			doGet(request, response);
		} else {
			response.getWriter().write("");
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
