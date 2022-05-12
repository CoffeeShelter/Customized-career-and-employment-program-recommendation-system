const body = document.querySelector("body");
const modal = document.querySelector(".sitemap_popup");
const btnOpenPopup = document.querySelector(".btn_sitemap");
const btnClosePopup = document.querySelector(".sitemap_close");

btnOpenPopup.addEventListener("click", () => {
  modal.classList.toggle("show");

  if (modal.classList.contains("show")) {
    body.style.overflow = "hidden";
  }
});

modal.addEventListener("click", (event) => {
  if (event.target === modal) {
    modal.classList.toggle("show");

    if (!modal.classList.contains("show")) {
      body.style.overflow = "auto";
    }
  }
});

btnClosePopup.addEventListener("click", () => {
  modal.classList.toggle("show");
});
