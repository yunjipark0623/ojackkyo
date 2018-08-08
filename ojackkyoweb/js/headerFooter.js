$("#footer").offset({top:$(document).scrollTop() + $(window).height()-convertRemToPixels(3)})
$(window).scroll(function(){
    $("#footer").offset({top:$(document).scrollTop() + $(window).height()-convertRemToPixels(3)})
})

$("#header").offset({top:$(document).scrollTop()});
$(window).scroll(function(){
  $("#header").offset({top:$(document).scrollTop()});
})

function convertRemToPixels(rem) {
    return rem * parseFloat(getComputedStyle(document.documentElement).fontSize);
}



$("#footer").html('\
<div class="ranking_img">\
  주간랭킹 <img src="../img/medal.svg">\
</div>\
<div class="senior">\
  졸업생 00학번 000\
</div>\
<span class="blank"></span>\
<div class="junior">\
  재학생 00학번 000\
</div>\
<span></span>\
<div class="btn_more">\
  <button type="button" name="more"><img src="../img/arrow-up.svg"></button>\
</div>')

$("#header").html('\
<div class="logo">\
  <a href="#">오 작 교</a>\
</div>\
<div class="user">\
  <div class="search">\
    <textarea class="search_bar" type="search"></textarea>\
    <button class="btn" type="button" name="submit"><img class="btn_img" src="../img/search.svg"></button>\
  </div>\
  <button type="button" name="message"><img src="../img/message.svg"></button>\
  <button type="button" name="alarm"><img src="../img/alarm.svg"></button>\
  <button type="button" name="user"><img src="../img/user.svg"></button>\
</div>')