$( document ).ready(function() {
	
	$( ".row1" ).scroll( function(){
		if( $(".row1").scrollTop() >= ($(window).height() - 100) ){
			$(".guide-wrapper").fadeIn();
		}
		else{
			$(".guide-wrapper").fadeOut();
		}
	});

	$(".next").click(function(){
		var currentIndex = $(".current").data("order");
		var nextIndex = currentIndex + 1;
		var currentContent = $(".speech-content").find("[data-order='" + currentIndex + "']");
		var nextContent = $(".speech-content").find("[data-order='" + nextIndex + "']");
		
		if( nextContent && !(currentContent.hasClass("last")) ){
			currentContent.removeClass("current");
			nextContent.addClass("current");
		}
		if( nextIndex >= 1){
			$(".prev").show();
		}
		if( nextContent.hasClass("last") ){
			$(".next").hide();
		}
	});
	$(".prev").click(function(){
		var currentIndex = $(".current").data("order");
		var prevIndex = currentIndex - 1;
		var currentContent = $(".speech-content").find("[data-order='" + currentIndex + "']");
		var prevContent = $(".speech-content").find("[data-order='" + prevIndex + "']");
		
		if( prevContent && !(currentContent.hasClass("first")) ){
			currentContent.removeClass("current");
			prevContent.addClass("current");
		}
		if( prevIndex === 0){
			$(".prev").hide();
		}
		if( currentContent.hasClass("last") ){
			$(".next").show();
		}
	});


	//TODO: tähän jotain järkevämpää
	var targets = ["target1", "target2", "target3", "target4", "target5", "target6"];
	var current = -1;

	$("#nextBtn").click(function() {
		if(current < targets.length - 1) {
			if(current == -1) {
				current = 0;
			} else {
				current++;
			}
			var target = $("#" + targets[current]);
			$("#row1").animate({
				scrollTop: target.position().top
			}, 1000);
		}
	});

	$("#prevBtn").click(function() {
		if(current > 0) {
			current--;
			var target = $("#" + targets[current]);
			$("#row1").animate({
				scrollTop: target.position().top
			}, 1000);
		}
	});
	
	
	
	
	
});