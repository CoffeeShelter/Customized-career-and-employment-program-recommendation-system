const request = new XMLHttpRequest();

const listItem = document.getElementById("instList-item");
const programCode = document.getElementById("programCode").value;

listItem.ondblclick = function() {
	let start_day = listItem.children[1].innerText;
	let end_day = listItem.children[2].innerText;

	let parameter = "code=" + programCode + "&" +
		"start_day=" + start_day + "&" +
		"end_day=" + end_day;

	location.href="./registerProgramInst?" + parameter;
}
