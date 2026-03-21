"use strict";

document.addEventListener("DOMContentLoaded", function() {
  const toggles = document.querySelectorAll(".tag2_category");

  toggles.forEach(toggle => {
    toggle.addEventListener("click", () => {
      // クリックされた toggle の親 li
      const parentLi = toggle.closest(".search_recipe_tag1");
      if (!parentLi) return;

      // ul.search_recipe_ul2 を取得
      const ul = parentLi.querySelector(".search_recipe_ul2");
      if (ul) ul.classList.toggle("open");

      // fa-caret-down を取得
      const caretDown = parentLi.querySelector(".fa-caret-down");
      if (caretDown) caretDown.classList.toggle("close");

      // fa-caret-right を取得
      const caretRight = parentLi.querySelector(".fa-caret-right");
      if (caretRight) caretRight.classList.toggle("close");
    });
  });
});

// 全てのsearch_recipe_headにイベントを追加
document.querySelectorAll('.search_recipe_head').forEach(head => {
  head.addEventListener('click', () => {
    // クリックされたheadの直後のsearch_recipe_content
    const content = head.nextElementSibling;
    if (!content || !content.classList.contains('search_recipe_content')) return;

    // openクラスのトグル
    const isOpen = content.classList.toggle('open');

    // アイコンを取得
    const downIcon = head.querySelector('.fas.fa-caret-down.sponly');
    const rightIcon = head.querySelector('.fas.fa-caret-right.sponly');

    if (downIcon && rightIcon) {
      if (isOpen) {
        downIcon.classList.remove('close'); // downのclose外す
        rightIcon.classList.add('close');   // rightにcloseつける
      } else {
        downIcon.classList.add('close');    // downにcloseつける
        rightIcon.classList.remove('close');// rightのclose外す
      }
    }
  });
});