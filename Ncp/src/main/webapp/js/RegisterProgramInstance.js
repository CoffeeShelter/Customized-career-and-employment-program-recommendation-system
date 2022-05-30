const code_doc = document.getElementById("code");
const open_type_doc = document.getElementsByName("program_type");
const open_year_doc
const open_term_doc
const start_day_doc = document.getElementById("start_day");
const end_day_doc = document.getElementById("end_day");
const training_time_doc
const operating_method_doc = document.getElementsByName("operating_method");
const recuiting_number_doc = document.getElementById("recuiting_number");
const participation_number_doc = document.getElementById("participation_number");
const college_number_doc = document.getElementById("college_information");
const department_number_doc = document.getElementById("department_information");
const major_number_doc = document.getElementById("major_information");
const target_grade_doc = document.getElementsByName("target_grade");
const target_sex_doc = document.getElementById("target_sex");
const manager_doc = document.getElementById("manager");
const operating_state = '0';
const operating_result_doc
const operating_department_doc = document.getElementById("operating_department");

function insertProgramInformation() {
	

	request.open("Post", "./programs?" + parameter, true);
	request.onreadystatechange = insertProcess;
	request.send(null);
}

function updateProgramInformation() {


	request.open("Put", "./programs?" + parameter, true);
	request.onreadystatechange = searchProcess;
	request.send(null);
}

function searchProcess() {
	const spinner = document.getElementById("spinner");
	const tableArea = document.getElementById("tableArea");

	if (request.readyState == 4 && request.status == 200) {
		spinner.classList.remove("show");
		tableArea.classList.add("show");

		let result = request.responseText;
		result = JSON.parse(result);

		alert("수정 완료");
	} else {
		tableArea.classList.remove("show");
		spinner.classList.add("show");
		console.log("로딩즁");
	}
}