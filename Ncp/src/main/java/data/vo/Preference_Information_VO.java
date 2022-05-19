package data.vo;

public class Preference_Information_VO {
	private String university_number;
	private String NCS_part;
	private String start_day;
	private String end_day;
	private String operating_method;

	public Preference_Information_VO() {
	}

	public Preference_Information_VO(String university_number, String NCS_part, String start_day, String end_day,
			String operating_method) {
		this.university_number = university_number;
		this.NCS_part = NCS_part;
		this.start_day = start_day;
		this.end_day = end_day;
		this.operating_method = operating_method;
	}

	public String getUniversity_number() {
		return university_number;
	}

	public void setUniversity_number(String university_number) {
		this.university_number = university_number;
	}

	public String getNCS_part() {
		return NCS_part;
	}

	public void setNCS_part(String nCS_part) {
		NCS_part = nCS_part;
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

	public String getOperating_method() {
		return operating_method;
	}

	public void setOperating_method(String operating_method) {
		this.operating_method = operating_method;
	}

}
