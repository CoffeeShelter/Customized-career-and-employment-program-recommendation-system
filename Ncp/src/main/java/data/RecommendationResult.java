package data;

public class RecommendationResult {
	private String preparationDegree;
	private String programCode;
	private String largeCategory;
	private String middleCategory;
	private String programName;
	private String openTerm;
	private String completationTime;
	private String operatingState;
	private String recommendationDegree;

	
	
	public RecommendationResult(String preparationDegree, String programCode, String largeCategory, String middleCategory, String programName,
			String openTerm, String completationTime, String operatingState, String recommendationDegree) {
		this.preparationDegree = preparationDegree;
		this.programCode = programCode;
		this.largeCategory = largeCategory;
		this.middleCategory = middleCategory;
		this.programName = programName;
		this.openTerm = openTerm;
		this.completationTime = completationTime;
		this.operatingState = operatingState;
		this.recommendationDegree = recommendationDegree;
	}

	public String getPreparationDegree() {
		return preparationDegree;
	}

	public void setPreparationDegree(String preparationDegree) {
		this.preparationDegree = preparationDegree;
	}

	public String getProgramCode() {
		return programCode;
	}

	public void setProgramCode(String programCode) {
		this.programCode = programCode;
	}

	public String getLargeCategory() {
		return largeCategory;
	}

	public void setLargeCategory(String largeCategory) {
		this.largeCategory = largeCategory;
	}

	public String getMiddleCategory() {
		return middleCategory;
	}

	public void setMiddleCategory(String middleCategory) {
		this.middleCategory = middleCategory;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getOpenTerm() {
		return openTerm;
	}

	public void setOpenTerm(String openTerm) {
		this.openTerm = openTerm;
	}

	public String getCompletationTime() {
		return completationTime;
	}

	public void setCompletationTime(String completationTime) {
		this.completationTime = completationTime;
	}

	public String getOperatingState() {
		return operatingState;
	}

	public void setOperatingState(String operatingState) {
		this.operatingState = operatingState;
	}

	public String getRecommendationDegree() {
		return recommendationDegree;
	}

	public void setRecommendationDegree(String recommendationDegree) {
		this.recommendationDegree = recommendationDegree;
	}

	@Override
	public String toString() {
		return "RecommendationResult [programCode=" + programCode + ", largeCategory=" + largeCategory
				+ ", middleCategory=" + middleCategory + ", programName=" + programName + ", openTerm=" + openTerm
				+ ", completationTime=" + completationTime + ", operatingState=" + operatingState
				+ ", recommendationDegree=" + recommendationDegree + "]";
	}

}
