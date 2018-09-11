// JavaScript Document
function navList(id) {
    var $obj = $("#menuDiv"), $item = $("#menu_nav_" + id) , $item2 = $("#menu_h_nav_" + id);
    $item.addClass("on").parent().removeClass("none").parent().addClass("selected");
    $item2.addClass("selected");
    $obj.find("h4").hover(function () {
        $(this).addClass("hover");
    }, function () {
        $(this).removeClass("hover");
    });
    $obj.find("p").hover(function () {
        if ($(this).hasClass("on")) { return; }
        $(this).addClass("hover");
    }, function () {
        if ($(this).hasClass("on")) { return; }
        $(this).removeClass("hover");
    });
    $obj.find("h4").click(function () {
        var $div = $(this).siblings(".list-item");
        if ($(this).parent().hasClass("selected")) {
            $div.slideUp(600);
            $(this).parent().removeClass("selected");
        }
        if ($div.is(":hidden")) {
            $("#menuDiv li").find(".list-item").slideUp(600);
            $("#menuDiv li").removeClass("selected");
            $(this).parent().addClass("selected");
            $div.slideDown(300);

        } else {
            $div.slideUp(300);
        }
    });
}