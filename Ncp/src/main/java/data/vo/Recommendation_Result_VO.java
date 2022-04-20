package data.vo;

public class Recommendation_Result_VO {
	private String code;
	private String open_year;
	private String open_term;
	private String university_number;
	private String capability_category;
	private String recommendation_degree;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOpen_year() {
		return open_year;
	}

	public void setOpen_year(String open_year) {
		this.open_year = open_year;
	}

	public String getOpen_term() {
		return open_term;
	}

	public void setOpen_term(String open_term) {
		this.open_term = open_term;
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

	public String getRecommendation_degree() {
		return recommendation_degree;
	}

	public void setRecommendation_degree(String recommendation_degree) {
		this.recommendation_degree = recommendation_degree;
	}

	@Override
	public String toString() {
		return "Recommendation_Result_VO [code=" + code + ", open_year=" + open_year + ", open_term=" + open_term
				+ ", university_number=" + university_number + ", capability_category=" + capability_category
				+ ", recommendation_degree=" + recommendation_degree + "]";
	}
	
	

}
