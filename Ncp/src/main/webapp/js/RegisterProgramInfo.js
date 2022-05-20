const code_doc = document.getElementById("code")
const program_name_doc = document.getElementById("program_name")
const category_large_doc = document.getElementById("category_large")
const category_middle_doc = document.getElementById("category_middle")
const operating_type_doc = document.getElementById("operating_type")
const related_NCS_part_doc = document.getElementById("related_NCS_part")
const completation_time_doc = document.getElementById("completation_time")
const previous_program_doc = document.getElementById("previous_program")
const after_program_doc = document.getElementById("after_program")
const program_goal_doc = document.getElementById("program_goal")
const program_detail_doc = document.getElementById("program_detail")

const TALENT_capability_01 = document.getElementById("TALENT_capability_01")
const TALENT_capability_02 = document.getElementById("TALENT_capability_02")
const TALENT_capability_03 = document.getElementById("TALENT_capability_03")
const TALENT_capability_04 = document.getElementById("TALENT_capability_04")
const TALENT_capability_05 = document.getElementById("TALENT_capability_05")
const TALENT_capability_06 = document.getElementById("TALENT_capability_06")

function insertProgramInformation() {
	var code = code_doc.value;
	var program_name = program_name_doc
	var category_large = category_large_doc.options[category_large_doc.selectedIndex].value
	var category_middle = category_middle_doc.options[category_middle_doc.selectedIndex].value
	var operating_type = operating_type_doc.options[operating_type_doc.selectedIndex].value
	var related_NCS_part = related_NCS_part_doc.options[related_NCS_part_doc.selectedIndex].value
	var completation_time = completation_time_doc.options[completation_time_doc.selectedIndex].value
	var TALENT_capability = TALENT_capability_01.value + "/" + 
							TALENT_capability_02.value + "/" + 
							TALENT_capability_03.value + "/" + 
							TALENT_capability_04.value + "/" + 
							TALENT_capability_05.value + "/" + 
							TALENT_capability_06.value;
	var previous_program = previous_program_doc.options[previous_program_doc.selectedIndex].value
	var after_program = after_program_doc.options[after_program_doc.selectedIndex].value
	var program_goal = program_goal_doc.value;
	var program_detail = program_detail_doc.value;

	var parameter = "university_number=" + university_number + "&" +
		"NCS_part=" + NCS_part + "&" +
		"start_day=" + start_day + "&" +
		"end_day=" + end_day + "&" +
		"operating_method=" + operating_method;

	console.log("./student/preferenceinformation?" + parameter);

	request.open("Put", "./student/preferenceinformation?" + parameter, true);
	request.onreadystatechange = searchProcess;
	request.send(null);
}