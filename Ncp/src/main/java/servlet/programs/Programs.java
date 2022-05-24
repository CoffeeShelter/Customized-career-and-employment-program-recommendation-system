package servlet.programs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import data.dao.Program_DAO;
import data.utils.CategoryUtils;
import data.utils.ProgramUtils;
import data.vo.Program_Information_VO;

@WebServlet("/programs")
public class Programs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Programs() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Gson gson = new Gson();
		CategoryUtils categoryUtils = new CategoryUtils();

		String keyword = request.getParameter("keyword");
		System.out.println(keyword);
		
		// List<Program_Information_VO> programs = ProgramUtils.program_information_list;
		List<Program_Information_VO> programs = Program_DAO.searchProgram_Inforamtion(keyword);
		List<Map<String, String>> datum = new ArrayList<>();

		for (Program_Information_VO program : programs) {
			Map<String, String> data = new HashMap<>();
			data.put("code", program.getCode());
			data.put("program_name", program.getProgram_name());
			data.put("category_large", program.getCategory_large());
			data.put("category_middle", program.getCategory_middle());
			data.put("operating_type", program.getOperating_type());
			data.put("operating_type_name", categoryUtils.getOperatingTypeName(program.getOperating_type()));
			data.put("related_NCS_part", program.getRelated_NCS_part());
			data.put("related_NCS_part_name", categoryUtils.getNcsName(program.getRelated_NCS_part()));
			data.put("completation_time", program.getCompletation_time());
			data.put("TALENT_capability", program.getTALENT_capability());
			data.put("previous_program", program.getPrevious_program());
			data.put("after_program", program.getAfter_program());
			data.put("program_goal", program.getProgram_goal());
			data.put("program_detail", program.getProgram_detail());
			
			datum.add(data);
		}
		
		String jsonData = gson.toJson(datum);
		response.getWriter().write(jsonData);
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

		String TALENT_capability = request.getParameter("TALENT_capability_01") + "/"
				+ request.getParameter("TALENT_capability_02") + "/" + request.getParameter("TALENT_capability_03")
				+ "/" + request.getParameter("TALENT_capability_04") + "/"
				+ request.getParameter("TALENT_capability_05") + "/" + request.getParameter("TALENT_capability_06");

		String previous_program = request.getParameter("previous_program");
		String after_program = request.getParameter("after_program");
		String program_goal = request.getParameter("program_goal");
		String program_detail = request.getParameter("program_detail");

		Program_Information_VO programInformationVO = new Program_Information_VO(code, program_name, category_large,
				category_middle, operating_type, related_NCS_part, completation_time, TALENT_capability,
				previous_program, after_program, program_goal, program_detail);

		result = Program_DAO.insertProgram_Information(programInformationVO);
		
		if (result > 0) {
			System.out.println("추가 완료 " + result);
		} else {
			System.out.println("추가 실패 ...");
		}
		
		// RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterProgramInfo.jsp");
		// dispatcher.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String program_name = request.getParameter("program_name");
		String category_large = request.getParameter("category_large");
		String category_middle = request.getParameter("category_middle");
		String operating_type = request.getParameter("operating_type");
		String related_NCS_part = request.getParameter("related_NCS_part");
		String completation_time = request.getParameter("completation_time");
		String TALENT_capability = request.getParameter("TALENT_capability");
		String previous_program = request.getParameter("previous_program");
		String after_program = request.getParameter("after_program");
		String program_goal = request.getParameter("program_goal");
		String program_detail = request.getParameter("program_detail");

		Program_Information_VO program = new Program_Information_VO(code, program_name, category_large, category_middle,
				operating_type, related_NCS_part, completation_time, TALENT_capability, previous_program, after_program,
				program_goal, program_detail);

		int result = Program_DAO.updateProgram_Information(program);
		if(result >= 0) {
			System.out.println(result + "개 수정");
		}
		
		Map<String, String> data = new HashMap<>();
		data.put("code", program.getCode());
		data.put("program_name", program.getProgram_name());
		data.put("category_large", program.getCategory_large());
		data.put("category_middle", program.getCategory_middle());
		data.put("operating_type", program.getOperating_type());
		data.put("related_NCS_part", program.getRelated_NCS_part());
		data.put("completation_time", program.getCompletation_time());
		data.put("TALENT_capability", program.getTALENT_capability());
		data.put("previous_program", program.getPrevious_program());
		data.put("after_program", program.getAfter_program());
		data.put("program_goal", program.getProgram_goal());
		data.put("program_detail", program.getProgram_detail());
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(data);
		
		response.getWriter().write(jsonData);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");

		int result = Program_DAO.deleteProgram_Information(code);
		if(result >= 0) {
			System.out.println(result + "개 삭제");
		}
	}

}
