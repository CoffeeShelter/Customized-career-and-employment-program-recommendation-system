const request = new XMLHttpRequest();

// const listItem = document.getElementById("instList-item");
const listItems = document.querySelectorAll("#instList-item tbody tr");
const programCode = document.getElementById("programCode").value;

/*
listItem.ondblclick = function() {
	let start_day = this.children[1].innerText;
	let end_day = this.children[2].innerText;

	let parameter = "code=" + programCode + "&" +
		"start_day=" + start_day + "&" +
		"end_day=" + end_day;

	location.href="./registerProgramInst?" + parameter;
}
*/

function updateInstance(item) {
	let start_day = item.children[1].innerText;
	let end_day = item.children[2].innerText;

	let parameter = "code=" + programCode + "&" +
		"start_day=" + start_day + "&" +
		"end_day=" + end_day;

	location.href = "./registerProgramInst?" + parameter;
}

function createInstance() {
	let parameter = "code=" + programCode;

	location.href = "./registerProgramInst?" + parameter;
}
