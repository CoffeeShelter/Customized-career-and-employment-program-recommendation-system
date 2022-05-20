const navContentsInfoList = document.querySelector(".l-info")
const navContentsSettingList = document.querySelector(".l-setting")
const contentsInfo = document.querySelector(".contents-info")
const contentsSetting = document.querySelector(".contents-setting")

const btnInfo = document.querySelector(".btnInfo")
const btnSetting = document.querySelector(".btnSetting")
const btnRegister = document.getElementById("btnRegister")

const ncsSelect = document.getElementById("ncs")
const operatingMethodSelect = document.getElementById("operatingMethod")

const universityNumberInput = document.getElementById("universityNumber")

const startDay = document.getElementById("start_day");
const endDay = document.getElementById("end_day");

var request = new XMLHttpRequest();

btnInfo.addEventListener("click", () => {
	contentsSetting.classList.remove("show");
	navContentsSettingList.classList.remove("select-list");

	if (!contentsInfo.classList.contains("show")) {
		contentsInfo.classList.add("show");
	}
	if (!navContentsInfoList.classList.contains("select-list")) {
		navContentsInfoList.classList.add("select-list");
	}
});

btnSetting.addEventListener("click", () => {
	searchPreferenceInformation();

	contentsInfo.classList.remove("show");
	navContentsInfoList.classList.remove("select-list");

	if (!contentsSetting.classList.contains("show")) {
		contentsSetting.classList.add("show");
	}
	if (!navContentsSettingList.classList.contains("select-list")) {
		navContentsSettingList.classList.add("select-list");
	}
});

function searchPreferenceInformation() {
	request.open("Get", "./student/preferenceinformation?university_number=" + "201910823", true);
	request.onreadystatechange = searchProcess;
	request.send(null);
}

function updatePreferenceInformation() {
	var university_number = universityNumberInput.value;
	var NCS_part = ncsSelect.options[ncsSelect.selectedIndex].value
	var start_day = startDay.value;
	var end_day = endDay.value;
	var operating_method = operatingMethodSelect.options[operatingMethodSelect.selectedIndex].value

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

function searchProcess() {
	if (request.readyState == 4 && request.status == 200) {
		var result = request.responseText;
		result = JSON.parse(result);

		startDay.value = result.start_day;
		endDay.value = result.end_day;

		for (var i = 0; i < ncsSelect.options.length; i++) {
			if (ncsSelect.options[i].value == result.NCS_part) {
				ncsSelect.options[i].selected = true;
			}
		}

		for (var i = 0; i < operatingMethodSelect.options.length; i++) {
			if (operatingMethodSelect.options[i].value == result.operating_method) {
				operatingMethodSelect.options[i].selected = true;
			}
		}

		console.log(result);
		btnRegister.style.backgroundColor = "#5F86D6";
		btnRegister.disabled = false;

	} else {
		console.log("로딩즁");
		btnRegister.style.backgroundColor = "#D94D4D";
		btnRegister.disabled = true;
	}
}