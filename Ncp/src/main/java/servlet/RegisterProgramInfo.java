package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/registerProgramInfo")
public class RegisterProgramInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterProgramInfo() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String query = request.getParameter("code");

		Program_Information_VO program = Program_DAO.getProgram_Inforamtion(query);
		String[] TALENT_capability = program.getTALENT_capability().split("/");

		request.setAttribute("program", program);
		request.setAttribute("TALENT_capability", TALENT_capability);

		request.setAttribute("ncsList", CategoryUtils.ncsList);
		request.setAttribute("middleCategoryList", CategoryUtils.middleCategoryList);
		request.setAttribute("largeCategoryList", CategoryUtils.largeCategoryList);
		request.setAttribute("operatingTypeList", CategoryUtils.operatingTypeList);
		request.setAttribute("programList", ProgramUtils.program_information_list);

		System.out.println(CategoryUtils.operatingTypeList.toString());
		System.out.println(program.getOperating_type());

		RequestDispatcher dispatcher = request.getRequestDispatcher("RegisterProgramInfo.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doDelete(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPut(request, response);
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

}
