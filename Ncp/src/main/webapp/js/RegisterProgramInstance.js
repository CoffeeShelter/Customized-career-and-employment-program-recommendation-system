function getOpenTerm(month) {
	if (month >= 3 && month < 7) {
		return '1';
	} else if (month >= 7 && month < 9) {
		return '3';
	} else if (month >= 9 && month < 12) {
		return '2';
	} else {
		return '4';
	}
}

const code_doc = document.getElementById("code");
const open_type_doc = document.getElementsByName("program_type");
const start_day_doc = document.getElementById("start_day");
const end_day_doc = document.getElementById("end_day");
const operating_method_doc = document.getElementsByName("operating_method");
const recuiting_number_doc = document.getElementById("recuiting_number");
const participation_number_doc = document.getElementById("participation_number");
const college_number_doc = document.getElementById("college_information");
const department_number_doc = document.getElementById("department_information");
const major_number_doc = document.getElementById("major_information");
const target_grade_doc = document.getElementsByName("target_grade");
const target_sex_doc = document.getElementById("target_sex");
const manager_doc = document.getElementById("manager");
const operating_result_doc = document.getElementById("operating_result");
const operating_department_doc = document.getElementById("operating_department");
const start_time_doc = document.getElementById("start_time");
const end_time_doc = document.getElementById("end_time");

const before_start_day = start_day.value;
const before_end_day = end_day.value;
const before_open_year = start_day_doc.value.substring(0, 4);
const before_open_term = getOpenTerm(Number(start_day_doc.value.substring(5, 2)));

var request = new XMLHttpRequest();

function updateProgramInstance() {
	var code = code_doc.value;
	var open_type = '';
	for (i = 0; i < open_type_doc.length; i++) {
		if (open_type_doc[i].checked == true) {
			open_type = open_type_doc[i].value;
		}
	}
	var open_year = start_day_doc.value.substring(0, 4);
	var open_term = "";
	var month = Number(start_day_doc.value.substring(5, 2));
	if (month >= 3 && month < 7) {
		open_term = '1';
	} else if (month >= 7 && month < 9) {
		open_term = '3';
	} else if (month >= 9 && month < 12) {
		open_term = '2';
	} else {
		open_term = '4';
	}
	var start_day = start_day_doc.value;
	var end_day = end_day_doc.value;
	var start_time = start_time_doc.value;
	var end_time = end_time_doc.value;
	var operating_method = "";
	for (i = 0; i < operating_method_doc.length; i++) {
		if (operating_method_doc[i].checked == true) {
			operating_method = operating_method_doc[i].value;
		}
	}
	var recuiting_number = recuiting_number_doc.value;
	var participation_number = participation_number_doc.value;
	var college_number = college_number_doc.options[college_number_doc.selectedIndex].value;
	var department_number = department_number_doc.options[department_number_doc.selectedIndex].value;
	var major_number = major_number_doc.options[major_number_doc.selectedIndex].value;
	var target_grade = "";
	for (i = 0; i < target_grade_doc.length; i++) {
		if (target_grade_doc[i].checked == true) {
			target_grade = target_grade_doc[i].value;
		}
	}
	var target_sex = target_sex_doc.options[target_sex_doc.selectedIndex].value;
	var manager = manager_doc.value;
	var operating_state = "0";
	var operating_result = operating_result_doc.value;
	var operating_department = operating_department_doc.value;

	let parameter = "code=" + code + "&" +
					 "open_type=" + open_type + "&" +
					 "open_year=" + open_year + "&" +
					 "open_term=" + open_term + "&" +
					 "start_day=" + start_day + "&" +
					 "end_day=" + end_day + "&" +
					 "start_time=" + start_time + "&" +
					 "end_time=" + end_time + "&" +
					 "operating_method=" + operating_method + "&" +
					 "recuiting_number=" + recuiting_number + "&" +
					 "participation_number=" + participation_number + "&" +
					 "college_number=" + college_number + "&" +
					 "department_number=" + department_number + "&" +
					 "major_number=" + major_number + "&" +
					 "target_grade=" + target_grade + "&" +
					 "target_sex=" + target_sex + "&" +
					 "manager=" + manager + "&" +
					 "operating_state=" + operating_state + "&" +
					 "operating_result=" + operating_result + "&" +
					 "operating_department=" + operating_department + "&" +
					 "before_start_day=" + before_start_day + "&" +
					 "before_end_day=" + before_end_day;

	request.open("Put", "/programs/instance?" + parameter, true);
	request.onreadystatechange = updateProcess;
	request.send(null);
}

function insertProgramInstance() {
	var code = code_doc.value;
	var open_type = '';
	for (i = 0; i < open_type_doc.length; i++) {
		if (open_type_doc[i].checked == true) {
			open_type = open_type_doc[i].value;
		}
	}
	var open_year = start_day_doc.value.substring(0, 4);
	var open_term = "";
	var month = Number(start_day_doc.value.substring(5, 2));
	if (month >= 3 && month < 7) {
		open_term = '1';
	} else if (month >= 7 && month < 9) {
		open_term = '3';
	} else if (month >= 9 && month < 12) {
		open_term = '2';
	} else {
		open_term = '4';
	}
	var start_day = start_day_doc.value;
	var end_day = end_day_doc.value;
	var start_time = start_time_doc.value;
	var end_time = end_time_doc.value;
	var operating_method = "";
	for (i = 0; i < operating_method_doc.length; i++) {
		if (operating_method_doc[i].checked == true) {
			operating_method = operating_method_doc[i].value;
		}
	}
	var recuiting_number = recuiting_number_doc.value;
	var participation_number = participation_number_doc.value;
	var college_number = college_number_doc.options[college_number_doc.selectedIndex].value;
	var department_number = department_number_doc.options[department_number_doc.selectedIndex].value;
	var major_number = major_number_doc.options[major_number_doc.selectedIndex].value;
	var target_grade = "";
	for (i = 0; i < target_grade_doc.length; i++) {
		if (target_grade_doc[i].checked == true) {
			target_grade = target_grade_doc[i].value;
		}
	}
	var target_sex = target_sex_doc.options[target_sex_doc.selectedIndex].value;
	var manager = manager_doc.value;
	var operating_state = "0";
	var operating_result = operating_result_doc.value;
	var operating_department = operating_department_doc.value;

	let parameter = "code=" + code + "&" +
					 "open_type=" + open_type + "&" +
					 "open_year=" + open_year + "&" +
					 "open_term=" + open_term + "&" +
					 "start_day=" + start_day + "&" +
					 "end_day=" + end_day + "&" +
					 "start_time=" + start_time + "&" +
					 "end_time=" + end_time + "&" +
					 "operating_method=" + operating_method + "&" +
					 "recuiting_number=" + recuiting_number + "&" +
					 "participation_number=" + participation_number + "&" +
					 "college_number=" + college_number + "&" +
					 "department_number=" + department_number + "&" +
					 "major_number=" + major_number + "&" +
					 "target_grade=" + target_grade + "&" +
					 "target_sex=" + target_sex + "&" +
					 "manager=" + manager + "&" +
					 "operating_state=" + operating_state + "&" +
					 "operating_result=" + operating_result + "&" +
					 "operating_department=" + operating_department;

	console.log(parameter);

	request.open("Post", "/programs/instance?" + parameter, true);
	request.onreadystatechange = insertProcess;
	request.send(null);
}

function updateProcess() {
	const btnRegister = document.getElementById("btnRegister");
	var code = code_doc.value;

	if (request.readyState == 4 && request.status == 200) {
		location.href = "./programInstanceManagement?code=" + code;
	} else {
		btnRegister.disabled = true;
		btnRegister.style.backgroundColor = "#D94D4D";
	}
}

function insertProcess() {
	const btnRegister = document.getElementById("btnRegister");
	var code = code_doc.value;

	if (request.readyState == 4 && request.status == 200) {
		location.href = "./programInstanceManagement?code=" + code;
	} else {
		btnRegister.disabled = true;
		btnRegister.style.backgroundColor = "#D94D4D";
	}
}