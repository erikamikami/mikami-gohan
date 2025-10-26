"use strict";

document.addEventListener("DOMContentLoaded", function() {
  const toc = document.querySelector(".table_content");
  const title = toc.querySelector("h1");

  title.addEventListener("click", () => {
    toc.classList.toggle("open");
  });
});