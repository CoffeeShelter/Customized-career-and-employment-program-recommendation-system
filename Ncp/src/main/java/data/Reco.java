package data;

public class Reco {
	private String code;
	private String category_large;
	private String category_large_name;
	private String category_middle;
	private String category_middle_name;
	private String program_name;
	private String day;
	private String completation_time;
	private String operating_state;
	private String operating_state_name;
	private String recommendation_degree;

	public Reco() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory_large() {
		return category_large;
	}

	public void setCategory_large(String category_large) {
		this.category_large = category_large;
	}

	public String getCategory_large_name() {
		return category_large_name;
	}

	public void setCategory_large_name(String category_large_name) {
		this.category_large_name = category_large_name;
	}

	public String getCategory_middle() {
		return category_middle;
	}

	public void setCategory_middle(String category_middle) {
		this.category_middle = category_middle;
	}

	public String getCategory_middle_name() {
		return category_middle_name;
	}

	public void setCategory_middle_name(String category_middle_name) {
		this.category_middle_name = category_middle_name;
	}

	public String getProgram_name() {
		return program_name;
	}

	public void setProgram_name(String program_name) {
		this.program_name = program_name;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getCompletation_time() {
		return completation_time;
	}

	public void setCompletation_time(String completation_time) {
		this.completation_time = completation_time;
	}

	public String getOperating_state() {
		return operating_state;
	}

	public void setOperating_state(String operating_state) {
		this.operating_state = operating_state;
	}

	public String getOperating_state_name() {
		return operating_state_name;
	}

	public void setOperating_state_name(String operating_state_name) {
		this.operating_state_name = operating_state_name;
	}

	public String getRecommendation_degree() {
		return recommendation_degree;
	}

	public void setRecommendation_degree(String recommendation_degree) {
		this.recommendation_degree = recommendation_degree;
	}

	@Override
	public String toString() {
		return "Reco [code=" + code + ", category_large=" + category_large + ", category_large_name="
				+ category_large_name + ", category_middle=" + category_middle + ", category_middle_name="
				+ category_middle_name + ", program_name=" + program_name + ", day=" + day + ", completation_time="
				+ completation_time + ", operating_state=" + operating_state + ", operating_state_name="
				+ operating_state_name + ", recommendation_degree=" + recommendation_degree + "]";
	}

}
