"use strict";


let occupationCategoryName = document.getElementsByName("occupationCategoryName");
occupationCategoryName.selectedIndex = -1;
occupationCategoryName.forEach(function(element) {
	element.addEventListener("change", function() {
		let occupationCategoryId = document.getElementById("occupationCategoryId");
		let selectedIndex = element.selectedIndex;
		occupationCategoryId.options[selectedIndex].selected = true;
	});
});

let inquiryCategoryName = document.getElementsByName("inquiryCategoryName");
inquiryCategoryName.selectedIndex = -1;
inquiryCategoryName.forEach(function(element) {
	element.addEventListener("change", function() {
		let inquiryCategoryId = document.getElementById("inquiryCategoryId");
		let selectedIndex = element.selectedIndex;
		inquiryCategoryId.options[selectedIndex].selected = true;
	});
});
