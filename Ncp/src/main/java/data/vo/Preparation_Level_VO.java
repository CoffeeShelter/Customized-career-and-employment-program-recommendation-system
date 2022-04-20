package data.vo;

public class Preparation_Level_VO {
	private String university_number;
	private String capability_category;
	private String preparation_degree;
	private String preparation_level;
	private String preparation_rank;

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

	public String getPreparation_degree() {
		return preparation_degree;
	}

	public void setPreparation_degree(String preparation_degree) {
		this.preparation_degree = preparation_degree;
	}

	public String getPreparation_level() {
		return preparation_level;
	}

	public void setPreparation_level(String preparation_level) {
		this.preparation_level = preparation_level;
	}

	public String getPreparation_rank() {
		return preparation_rank;
	}

	public void setPreparation_rank(String preparation_rank) {
		this.preparation_rank = preparation_rank;
	}

	@Override
	public String toString() {
		return "Preparation_Level_VO [university_number=" + university_number + ", capability_category="
				+ capability_category + ", preparation_degree=" + preparation_degree + ", preparation_level="
				+ preparation_level + ", preparation_rank=" + preparation_rank + "]";
	}

}
