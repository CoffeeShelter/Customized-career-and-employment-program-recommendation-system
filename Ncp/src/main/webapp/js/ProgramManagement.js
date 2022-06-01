const request = new XMLHttpRequest();

window.onload = searchPrograms();

function searchPrograms() {
	let spinner = document.getElementById("spinner");
	spinner.classList.remove("show");
	
	let keyword = document.getElementById("keyword").value;
	
	request.open("Get", "./programs?keyword=" + keyword, true);
	request.onreadystatechange = searchProcess;
	request.send(null);
}

function searchProcess() {
	const spinner = document.getElementById("spinner");
	const accordion = document.getElementById("accordion");
	
	if (request.readyState == 4 && request.status == 200) {
		spinner.classList.remove("show");
		accordion.classList.add("show");
		
		let result = request.responseText;
		result = JSON.parse(result);

		accordion.innerHTML = "";
		for (var i = 0; i < result.length; i++) {
			createList(accordion, result[i]);
		}

		console.log(result.length);

	} else {
		accordion.classList.remove("show");
		spinner.classList.add("show");
		console.log("로딩즁");
	}
}

function createList(accordion, data) {
	let inputCheckbox = document.createElement("input");
	inputCheckbox.setAttribute("type", "checkbox");
	inputCheckbox.setAttribute("id", "pro" + data["code"]);

	let label = document.createElement("label");
	label.setAttribute("for", "pro" + data["code"]);
	label.innerText = data["program_name"];

	let i = document.createElement("i");
	i.setAttribute("class", "fa-solid fa-circle-arrow-down");
	label.appendChild(i);

	let div = document.createElement("div");
	let table = document.createElement("table");
	let tbody = document.createElement("tbody");

	let tr01 = document.createElement("tr");
	let th01 = document.createElement("th");
	let td01 = document.createElement("td");
	th01.innerHTML = "프로그램 코드";
	td01.innerHTML = data["code"];
	tr01.appendChild(th01);
	tr01.appendChild(td01);

	let tr02 = document.createElement("tr");
	let th02 = document.createElement("th");
	let td02 = document.createElement("td");
	th02.innerHTML = "프로그램 명";
	td02.innerHTML = data["program_name"];
	tr02.appendChild(th02);
	tr02.appendChild(td02);

	let tr03 = document.createElement("tr");
	let th03 = document.createElement("th");
	let td03 = document.createElement("td");
	th03.innerHTML = "운영 유형";
	td03.innerHTML = data["operating_type_name"];
	tr03.appendChild(th03);
	tr03.appendChild(td03);

	let tr04 = document.createElement("tr");
	let th04 = document.createElement("th");
	let td04 = document.createElement("td");
	th04.innerHTML = "연계 직무";
	td04.innerHTML = data["related_NCS_part_name"];
	tr04.appendChild(th04);
	tr04.appendChild(td04);

	tbody.appendChild(tr01);
	tbody.appendChild(tr02);
	tbody.appendChild(tr03);
	tbody.appendChild(tr04);

	table.appendChild(tbody);

	let inputButtonUpdate = document.createElement("a");
	inputButtonUpdate.setAttribute("href", "./registerProgramInfo?code=" + data['code']);
	inputButtonUpdate.innerText = "수정";

	let inputButtonCreate = document.createElement("a");
	inputButtonCreate.setAttribute("href", "./programInstanceManagement?code=" + data['code']);
	inputButtonCreate.innerText = "개설";
	
	let inputButtonReco = document.createElement("a");
	inputButtonReco.setAttribute("href", "./recoList?code=" + data['code']);
	inputButtonReco.innerText = "추천 학생";

	div.appendChild(table);
	div.appendChild(inputButtonUpdate);
	div.appendChild(inputButtonCreate);
	div.appendChild(inputButtonReco);

	accordion.appendChild(inputCheckbox);
	accordion.appendChild(label);
	accordion.appendChild(div);
}

function onkeyupEvent(e){
	if(e.keyCode == 13) {
		searchPrograms();
	}
}