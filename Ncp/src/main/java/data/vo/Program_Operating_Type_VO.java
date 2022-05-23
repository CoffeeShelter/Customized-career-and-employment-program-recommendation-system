package data.vo;

public class Program_Operating_Type_VO {
	private String code;
	private String category_name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "Program_Operating_Type_VO [code=" + code + ", category_name=" + category_name + "]";
	}

}
