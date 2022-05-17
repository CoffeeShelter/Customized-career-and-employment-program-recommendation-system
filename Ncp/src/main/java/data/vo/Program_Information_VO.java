package data.vo;

public class Program_Information_VO {
	private String code;
	private String program_name;
	private String category_large;
	private String category_middle;
	private String operating_type;
	private String related_NCS_part;
	private String completation_time;
	private String TALENT_capability;
	// private String TALENT_reflection_rate;
	private String previous_program;
	private String after_program;
	private String program_goal;
	private String program_detail;
	

	public Program_Information_VO()	{
		
	}

	public Program_Information_VO(String code, String program_name, String category_large, String category_middle,
			String operating_type, String related_NCS_part, String completation_time, String TALENT_capability,
			String previous_program, String after_program, String program_goal, String program_detail) {
		this.code = code;
		this.program_name = program_name;
		this.category_large = category_large;
		this.category_middle = category_middle;
		this.operating_type = operating_type;
		this.related_NCS_part = related_NCS_part;
		this.completation_time = completation_time;
		this.TALENT_capability = TALENT_capability;
		this.previous_program = previous_program;
		this.after_program = after_program;
		this.program_goal = program_goal;
		this.program_detail = program_detail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public String getCategory_large() {
		return category_large;
	}

	public void setCategory_large(String category_large) {
		this.category_large = category_large;
	}

	public String getCategory_middle() {
		return category_middle;
	}

	public void setCategory_middle(String category_middle) {
		this.category_middle = category_middle;
	}

	public String getOperating_type() {
		return operating_type;
	}

	public void setOperating_type(String operating_type) {
		this.operating_type = operating_type;
	}

	public String getRelated_NCS_part() {
		return related_NCS_part;
	}

	public void setRelated_NCS_part(String related_NCS_part) {
		this.related_NCS_part = related_NCS_part;
	}

	public String getCompletation_time() {
		return completation_time;
	}

	public void setCompletation_time(String colpletation_time) {
		this.completation_time = colpletation_time;
	}

	public String getTALENT_capability() {
		return TALENT_capability;
	}

	public void setTALENT_capability(String tALENT_capability) {
		TALENT_capability = tALENT_capability;
	}
/*
	public String getTALENT_reflection_rate() {
		return TALENT_reflection_rate;
	}

	public void setTALENT_reflection_rate(String tALENT_reflection_rate) {
		TALENT_reflection_rate = tALENT_reflection_rate;
	}
*/
	public String getPrevious_program() {
		return previous_program;
	}

	public void setPrevious_program(String previous_program) {
		this.previous_program = previous_program;
	}

	public String getAfter_program() {
		return after_program;
	}

	public void setAfter_program(String after_program) {
		this.after_program = after_program;
	}

	public String getProgram_goal() {
		return program_goal;
	}

	public void setProgram_goal(String program_goal) {
		this.program_goal = program_goal;
	}

	public String getProgram_detail() {
		return program_detail;
	}

	public void setProgram_detail(String program_detail) {
		this.program_detail = program_detail;
	}

	@Override
	public String toString() {
		return "Program_Information_VO [code=" + code + ", program_name=" + program_name + ", category_large="
				+ category_large + ", category_middle=" + category_middle + ", operating_type=" + operating_type
				+ ", related_NCS_part=" + related_NCS_part + ", colpletation_time=" + completation_time
				+ ", TALENT_capability=" + TALENT_capability + ", previous_program=" + previous_program
				+ ", after_program=" + after_program + ", program_goal=" + program_goal + ", program_detail="
				+ program_detail + "]";
	}

	
	
}
