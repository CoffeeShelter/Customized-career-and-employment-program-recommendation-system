package servlet.programs.instance;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import data.dao.Program_DAO;
import data.vo.Program_Instance_VO;

@WebServlet("/programs/instance")
public class Instance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Gson gson = null;

	public Instance() {
		super();
		if(gson == null) {
			gson = new GsonBuilder().serializeNulls().create();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String open_type = request.getParameter("open_type");
		String open_year = request.getParameter("open_year");
		String open_term = request.getParameter("open_term");
		String start_day = request.getParameter("start_day");
		String end_day = request.getParameter("end_day");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String operating_method = request.getParameter("operating_method");
		String recuiting_number = request.getParameter("recuiting_number");
		String participation_number = request.getParameter("participation_number");
		String college_number = request.getParameter("college_number");
		String department_number = request.getParameter("department_number");
		String major_number = request.getParameter("major_number");
		String target_grade = request.getParameter("target_grade");
		String target_sex = request.getParameter("target_sex");
		String manager = request.getParameter("manager");
		String operating_state = request.getParameter("operating_state");
		String operating_result = request.getParameter("operating_result");
		String operating_department = request.getParameter("operating_department");

		Program_Instance_VO programInstance = new Program_Instance_VO();
		programInstance.setCode(code);
		programInstance.setOpen_type(open_type);
		programInstance.setOpen_year(open_year);
		programInstance.setOpen_term(open_term);
		programInstance.setStart_day(start_day);
		programInstance.setEnd_day(end_day);
		programInstance.setStart_time(start_time);
		programInstance.setEnd_time(end_time);
		programInstance.setOperating_method(operating_method);
		programInstance.setRecuiting_number(recuiting_number);
		programInstance.setParticipation_number(participation_number);
		programInstance.setCollege_number(college_number);
		programInstance.setDepartment_number(department_number);
		programInstance.setMajor_number(major_number);
		programInstance.setTarget_grade(target_grade);
		programInstance.setTarget_sex(target_sex);
		programInstance.setManager(manager);
		programInstance.setOperating_state(operating_state);
		programInstance.setOperating_result(operating_result);
		programInstance.setOperating_department(operating_department);
		
		System.out.println(programInstance.toString());
		
		int result = Program_DAO.insertProgram_Instance(programInstance);
		if (result >= 0) {
			System.out.println(result + "개 추가");
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String open_type = request.getParameter("open_type");
		String open_year = request.getParameter("open_year");
		String open_term = request.getParameter("open_term");
		String start_day = request.getParameter("start_day");
		String end_day = request.getParameter("end_day");
		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String operating_method = request.getParameter("operating_method");
		String recuiting_number = request.getParameter("recuiting_number");
		String participation_number = request.getParameter("participation_number");
		String college_number = request.getParameter("college_number");
		String department_number = request.getParameter("department_number");
		String major_number = request.getParameter("major_number");
		String target_grade = request.getParameter("target_grade");
		String target_sex = request.getParameter("target_sex");
		String manager = request.getParameter("manager");
		String operating_state = request.getParameter("operating_state");
		String operating_result = request.getParameter("operating_result");
		String operating_department = request.getParameter("operating_department");
		String before_start_day = request.getParameter("before_start_day");
		String before_end_day = request.getParameter("before_end_day");

		Program_Instance_VO programInstance = new Program_Instance_VO();
		programInstance.setCode(code);
		programInstance.setOpen_type(open_type);
		programInstance.setOpen_year(open_year);
		programInstance.setOpen_term(open_term);
		programInstance.setStart_day(start_day);
		programInstance.setEnd_day(end_day);
		programInstance.setStart_time(start_time);
		programInstance.setEnd_time(end_time);
		programInstance.setOperating_method(operating_method);
		programInstance.setRecuiting_number(recuiting_number);
		programInstance.setParticipation_number(participation_number);
		programInstance.setCollege_number(college_number);
		programInstance.setDepartment_number(department_number);
		programInstance.setMajor_number(major_number);
		programInstance.setTarget_grade(target_grade);
		programInstance.setTarget_sex(target_sex);
		programInstance.setManager(manager);
		programInstance.setOperating_state(operating_state);
		programInstance.setOperating_result(operating_result);
		programInstance.setOperating_department(operating_department);
		
		String jsonString = gson.toJson(programInstance);
		Map<String, Object> parameter = new HashMap<>();
		parameter = gson.fromJson(jsonString, HashMap.class);
		parameter.put("before_start_day", before_start_day);
		parameter.put("before_end_day", before_end_day);
		
		System.out.println(parameter);
		
		int result = Program_DAO.updateProgram_Instance(parameter);
		if (result >= 0) {
			System.out.println(result + "개 수정");
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
