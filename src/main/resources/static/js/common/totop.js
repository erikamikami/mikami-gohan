$(window).load(function() {
    $("#toTop").click(function() {
        $("body, html").animate({
            scrollTop: 0
        }, 50);
        return false
    })
});
