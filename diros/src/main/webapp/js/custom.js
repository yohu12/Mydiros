// 滑动特效
$(function() {
	$(".discovery a").hover(function(){
		$(this).find(".p").stop().animate({
			top:-0
		}, 100);
		}, function(){
		$(this).find(".p").stop().animate({
			top:80
		}, 600);
	});
});
