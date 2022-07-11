package data.vo;

public class Student_VO {
	private String university_number;
	private String name;
	private String major_number;
	private String major;
	private String grade;
	private String sex;
	private String Professor_number;

	public String getProfessor_number() {
		return Professor_number;
	}

	public void setProfessor_number(String professor_number) {
		Professor_number = professor_number;
	}

	public String getUniversity_number() {
		return university_number;
	}

	public void setUniversity_number(String university_number) {
		this.university_number = university_number;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor_number() {
		return major_number;
	}

	public void setMajor_number(String major_number) {
		this.major_number = major_number;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [university_number=" + university_number + ", name=" + name + ", major_number=" + major_number
				+ ", grade=" + grade + ", sex=" + sex + "]";
	}

}
