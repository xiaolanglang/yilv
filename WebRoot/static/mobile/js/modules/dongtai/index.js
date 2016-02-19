$(function() {
	function showImageView(num) {
		var height = window.screen.height + "px";
		$(".swiper-container").css("height", height);
		$("#swiperView").css("display","inherit");
		$("body").css(height,height).addClass("swipe-body");
		var swiper = new Swiper('.swiper-container', {
			pagination : '.swiper-pagination',
			paginationClickable : false,
			spaceBetween : 30,
			initialSlide : num
		});
	}
	
	showImageView(1);

})