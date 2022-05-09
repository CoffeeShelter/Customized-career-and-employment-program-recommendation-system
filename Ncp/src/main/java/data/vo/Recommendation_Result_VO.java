package data.vo;

public class Recommendation_Result_VO {
	private String code;
	private String open_year;
	private int open_term;
	private String university_number;
	private String capability_category;
	private float recommendation_degree;
	
	public Recommendation_Result_VO() {}

	public Recommendation_Result_VO(String code, String open_year, int open_term, String university_number,
			String capability_category, float recommendation_degree) {
		this.code = code;
		this.open_year = open_year;
		this.open_term = open_term;
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

	public String getOpen_year() {
		return open_year;
	}

	public void setOpen_year(String open_year) {
		this.open_year = open_year;
	}

	public int getOpen_term() {
		return open_term;
	}

	public void setOpen_term(int open_term) {
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

	public float getRecommendation_degree() {
		return recommendation_degree;
	}

	public void setRecommendation_degree(float recommendation_degree) {
		this.recommendation_degree = recommendation_degree;
	}

	@Override
	public String toString() {
		return "Recommendation_Result_VO [code=" + code + ", open_year=" + open_year + ", open_term=" + open_term
				+ ", university_number=" + university_number + ", capability_category=" + capability_category
				+ ", recommendation_degree=" + recommendation_degree + "]";
	}

}
