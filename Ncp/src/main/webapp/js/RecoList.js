var request = new XMLHttpRequest();

function searchSBP() {
	var targetProgramName = document.getElementById("programName").value;
	var targetProgram = document.getElementById("targetProgram");
	targetProgram.innerText = targetProgramName;
	request.open("Post", "./sbp?programName=" + targetProgramName, true);
	request.onreadystatechange = searchProcess;
	request.send(null);
}

function searchProcess() {
	var table = document.getElementById("sbpTable");
	table.innerHTML = "";
	if (request.readyState == 4 && request.status == 200) {
		var result = request.responseText;
		result = JSON.parse(result);

		if (result.length == 0) {
			var row = table.insertRow(-1);
			var cell = row.insertCell(0);
			cell.colSpan = 9;
			cell.innerHTML = "검색 결과가 없습니다.";
		} else {
			for (var i = 0; i < result.length; i++) {
				var row = table.insertRow(-1);
				var cell = row.insertCell(0);
				cell.innerHTML = i + 1;
				var cell = row.insertCell(1);
				cell.innerHTML = result[i].name;
				var cell = row.insertCell(2);
				cell.innerHTML = result[i].major_number;
				var cell = row.insertCell(3);
				cell.innerHTML = result[i].major;
				var cell = row.insertCell(4);
				cell.innerHTML = result[i].university_number;
				var cell = row.insertCell(5);
				cell.innerHTML = result[i].grade;
				var cell = row.insertCell(6);
				cell.innerHTML = result[i].sex;
				var cell = row.insertCell(7);
				cell.innerHTML = result[i].ncp;
				var cell = row.insertCell(8);
				cell.innerHTML = result[i].degree;
			}
		}
	}
}