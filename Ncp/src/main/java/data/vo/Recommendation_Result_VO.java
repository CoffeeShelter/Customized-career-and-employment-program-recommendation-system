package data.vo;

public class Recommendation_Result_VO {
	private String code;
	private String start_day;
	private String end_day;
	private String university_number;
	private String capability_category;
	private float recommendation_degree;

	public Recommendation_Result_VO() {
	}

	public Recommendation_Result_VO(String code, String start_day, String end_day, String university_number,
			String capability_category, float recommendation_degree) {
		this.code = code;
		this.start_day = start_day;
		this.end_day = end_day;
		this.university_number = university_number;
		this.capability_category = capability_category;
		this.recommendation_degree = recommendation_degree;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStart_day() {
		return start_day;
	}

	public void setStart_day(String start_day) {
		this.start_day = start_day;
	}

	public String getEnd_day() {
		return end_day;
	}

	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}

	public String getUniversity_number() {
		return university_number;
	}

	public void setUniversity_number(String university_number) {
		this.university_number = university_number;
	}

	public String getCapability_category() {
		return capability_category;
	}

	public void setCapability_category(String capability_category) {
		this.capability_category = capability_category;
	}

	public float getRecommendation_degree() {
		return recommendation_degree;
	}

	public void setRecommendation_degree(float recommendation_degree) {
		this.recommendation_degree = recommendation_degree;
	}

	@Override
	public String toString() {
		return "Recommendation_Result_VO [code=" + code + ", start_day=" + start_day + ", end_day=" + end_day
				+ ", university_number=" + university_number + ", capability_category=" + capability_category
				+ ", recommendation_degree=" + recommendation_degree + "]";
	}

}
