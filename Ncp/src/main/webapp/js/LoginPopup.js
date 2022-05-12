const loginBody = document.querySelector("login_popup_body");
const loginPopup = document.querySelector(".login_popup");
const btnOpenLoginPopup = document.querySelector(".btn_login");
const btnCloseLoginPopup = document.querySelector(".login_popup_close");

btnOpenLoginPopup.addEventListener("click", () => {
  loginPopup.classList.toggle("show");

  if (loginPopup.classList.contains("show")) {
    loginBody.style.overflow = "hidden";
  }
});

loginPopup.addEventListener("click", (event) => {
  if (event.target === loginPopup) {
    loginPopup.classList.toggle("show");

    if (!loginPopup.classList.contains("show")) {
      loginBody.style.overflow = "auto";
    }
  }
});

btnCloseLoginPopup.addEventListener("click", () => {
  loginPopup.classList.toggle("show");
});
