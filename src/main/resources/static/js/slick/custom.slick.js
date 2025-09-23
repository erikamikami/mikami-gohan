"use strict";

$(function() {
  let picturesNo = 2;
  if (window.matchMedia('(max-width: 767px)').matches) {
    //スマホ処理
    picturesNo = 1;
  }
  $(".slider").slick({
    arrows: false,
    autoplay: true,
    adaptiveHeight: true,
    dots: true,

    slidesToShow: picturesNo,
    responsive: [
      {
        breakpoint: 600, // 600px以下のサイズに適用
        settings: {
          slidesToShow: 1,
        },
      },
    ],
  });
});
