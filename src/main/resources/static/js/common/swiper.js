const breakPoint = 480;

// PC表示の時の初期化（1度に見せる枚数が異なる）
if (window.innerWidth >= 991) {
  const swiper = new Swiper(".swiper", {
    loop: true,
    autoplay: {
      delay: 1000,
      disableOnInteraction: false,
    },
    pagination: { //ページネーション（ドット）
      el: '.swiper-pagination',
      clickable: true,
    },
    scrollbar: {
      el: '.swiper-scrollbar',
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
    speed: 3000,
    slideToClickedSlide: true,
    slidesPerView: 3.5, // 1度に何枚見せるか
    spaceBetween: 30, // スライド間の距離
    centeredSlides: true, // アクティブなスライドを中央にする
  });
// SP表示の時の初期化（1度に見せる枚数が異なる）
} else {
  const swiper = new Swiper(".swiper", {
    loop: true,
    autoplay: {
      delay: 1000,
      disableOnInteraction: false,
    },
    pagination: { //ページネーション（ドット）
      el: '.swiper-pagination',
      clickable: true,
    },
    scrollbar: {
      el: '.swiper-scrollbar',
    },
    navigation: {
      nextEl: ".swiper-button-next",
      prevEl: ".swiper-button-prev",
    },
    speed: 3000,
    slideToClickedSlide: true,
    slidesPerView: 1.5, // 1度に何枚見せるか
    spaceBetween: 30, // スライド間の距離
    centeredSlides: true, // アクティブなスライドを中央にする
  });
}
const swiper_main = new Swiper('.swiper_main', {
  loop: true,
  autoplay: {
    delay: 2000,
  },
  pagination: {
    el: '.swiper-pagination',
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
})