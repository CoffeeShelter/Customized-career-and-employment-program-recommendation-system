const navContentsInfoList = document.querySelector(".l-info")
const navContentsSettingList = document.querySelector(".l-setting")
const contentsInfo = document.querySelector(".contents-info")
const contentsSetting = document.querySelector(".contents-setting")
const btnInfo = document.querySelector(".btnInfo")
const btnSetting = document.querySelector(".btnSetting")

btnInfo.addEventListener("click", () => {
	contentsSetting.classList.remove("show");
	navContentsSettingList.classList.remove("select-list");
	
	if (!contentsInfo.classList.contains("show")) {
		contentsInfo.classList.add("show");
	}
	if (!navContentsInfoList.classList.contains("select-list")) {
		navContentsInfoList.classList.add("select-list");
	}
	
	navCon
});

btnSetting.addEventListener("click", () => {
	contentsInfo.classList.remove("show");
	navContentsInfoList.classList.remove("select-list");

	if (!contentsSetting.classList.contains("show")) {
		contentsSetting.classList.add("show");
	}
	if (!navContentsSettingList.classList.contains("select-list")) {
		navContentsSettingList.classList.add("select-list");
	}
});