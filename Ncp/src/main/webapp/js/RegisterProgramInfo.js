const code_doc = document.getElementById("code");
const program_name_doc = document.getElementById("program_name");
const category_large_doc = document.getElementById("category_large");
const category_middle_doc = document.getElementById("category_middle");
const operating_type_doc = document.getElementById("operating_type");
const related_NCS_part_doc = document.getElementById("related_NCS_part");
const completation_time_doc = document.getElementById("completation_time");
const previous_program_doc = document.getElementById("previous_program");
const after_program_doc = document.getElementById("after_program");
const program_goal_doc = document.getElementById("program_gaol");
const program_detail_doc = document.getElementById("program_detail");

const TALENT_capability_01 = document.getElementById("TALENT_capability_01");
const TALENT_capability_02 = document.getElementById("TALENT_capability_02");
const TALENT_capability_03 = document.getElementById("TALENT_capability_03");
const TALENT_capability_04 = document.getElementById("TALENT_capability_04");
const TALENT_capability_05 = document.getElementById("TALENT_capability_05");
const TALENT_capability_06 = document.getElementById("TALENT_capability_06");

var request = new XMLHttpRequest();

function insertProgramInformation() {
	var code = code_doc.value;
	var program_name = program_name_doc.value;
	var category_large = category_large_doc.options[category_large_doc.selectedIndex].value;
	var category_middle = category_middle_doc.options[category_middle_doc.selectedIndex].value;
	var operating_type = operating_type_doc.options[operating_type_doc.selectedIndex].value;
	var related_NCS_part = related_NCS_part_doc.options[related_NCS_part_doc.selectedIndex].value;
	var completation_time = completation_time_doc.value;
	var TALENT_capability = TALENT_capability_01.value + "/" +
		TALENT_capability_02.value + "/" +
		TALENT_capability_03.value + "/" +
		TALENT_capability_04.value + "/" +
		TALENT_capability_05.value + "/" +
		TALENT_capability_06.value;
	var previous_program = previous_program_doc.options[previous_program_doc.selectedIndex].value;
	var after_program = after_program_doc.options[after_program_doc.selectedIndex].value;
	var program_goal = program_goal_doc.value;
	var program_detail = program_detail_doc.value;

	var parameter = "code=" + code + "&" +
		"program_name=" + program_name + "&" +
		"category_large=" + category_large + "&" +
		"category_middle=" + category_middle + "&" +
		"operating_type=" + operating_type + "&" +
		"related_NCS_part=" + related_NCS_part + "&" +
		"completation_time=" + completation_time + "&" +
		"TALENT_capability=" + TALENT_capability + "&" +
		"previous_program=" + previous_program + "&" +
		"after_program=" + after_program + "&" +
		"program_goal=" + program_goal + "&" +
		"program_detail=" + program_detail;

	console.log("./programs?" + parameter);

	request.open("Post", "./programs?" + parameter, true);
	request.onreadystatechange = insertProcess;
	request.send(null);
}

function updateProgramInformation() {
	var code = code_doc.value;
	var program_name = program_name_doc.value;
	var category_large = category_large_doc.options[category_large_doc.selectedIndex].value;
	var category_middle = category_middle_doc.options[category_middle_doc.selectedIndex].value;
	var operating_type = operating_type_doc.options[operating_type_doc.selectedIndex].value;
	var related_NCS_part = related_NCS_part_doc.options[related_NCS_part_doc.selectedIndex].value;
	var completation_time = completation_time_doc.value;
	var TALENT_capability = TALENT_capability_01.value + "/" +
		TALENT_capability_02.value + "/" +
		TALENT_capability_03.value + "/" +
		TALENT_capability_04.value + "/" +
		TALENT_capability_05.value + "/" +
		TALENT_capability_06.value;
	var previous_program = previous_program_doc.options[previous_program_doc.selectedIndex].value;
	var after_program = after_program_doc.options[after_program_doc.selectedIndex].value;
	var program_goal = program_goal_doc.value;
	var program_detail = program_detail_doc.value;

	var parameter = "code=" + code + "&" +
		"program_name=" + program_name + "&" +
		"category_large=" + category_large + "&" +
		"category_middle=" + category_middle + "&" +
		"operating_type=" + operating_type + "&" +
		"related_NCS_part=" + related_NCS_part + "&" +
		"completation_time=" + completation_time + "&" +
		"TALENT_capability=" + TALENT_capability + "&" +
		"previous_program=" + previous_program + "&" +
		"after_program=" + after_program + "&" +
		"program_goal=" + program_goal + "&" +
		"program_detail=" + program_detail;

	console.log("./programs?" + parameter);

	request.open("Put", "./programs?" + parameter, true);
	request.onreadystatechange = searchProcess;
	request.send(null);
}

function deleteProgramInformation() {
	var code = code_doc.value;

	var parameter = "code=" + code;

	if (confirm("비교과 프로그램 기본 정보를 삭제 하시겠습니까?")) {
		console.log("./programs?" + parameter);

		request.open("Delete", "./programs?" + parameter, true);
		request.onreadystatechange = deleteProcess;
		request.send(null);
	} else {
		console.log("취소");
	}

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

function insertProcess() {
	const spinner = document.getElementById("spinner");
	const tableArea = document.getElementById("tableArea");

	if (request.readyState == 4 && request.status == 200) {
		spinner.classList.remove("show");
		tableArea.classList.add("show");

		let result = request.responseText;
		if (result.length == "") {
			alert("추가 완료");
			window.open("./ProgramManagement.jsp");
		}
	} else {
		tableArea.classList.remove("show");
		spinner.classList.add("show");
		console.log("로딩즁");
	}
}

function deleteProcess() {
	const spinner = document.getElementById("spinner");
	const tableArea = document.getElementById("tableArea");

	if (request.readyState == 4 && request.status == 200) {
		spinner.classList.remove("show");
		tableArea.classList.add("show");

		let result = request.responseText;
		if (result.length == "") {
			alert("삭제 완료");
			window.open("./ProgramManagement.jsp");
		}
	} else {
		tableArea.classList.remove("show");
		spinner.classList.add("show");
		console.log("로딩즁");
	}
}

let code = 0;
function onChange() {
	code = Number(category_large_doc.options[category_large_doc.selectedIndex].value) * 10000;
	code += Number(category_middle_doc.options[category_middle_doc.selectedIndex].value) * 1000;

	request.open("Get", "./programs/code?code=" + String(code), true);
	request.onreadystatechange = codeProcess;
	request.send(null);
}

function codeProcess() {
	if (request.readyState == 4 && request.status == 200) {
		let result = request.responseText;
		result = JSON.parse(result);
		
		console.log(Number(result['maxCode']));
		console.log(code + Number(result['maxCode']) +1);
		
		code_doc.value = code + Number(result['maxCode']) +1;
	} else {
		console.log("로딩즁");
	}
}