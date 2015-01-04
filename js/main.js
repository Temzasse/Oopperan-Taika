$( document ).ready(function() {
	

	// määrittele mitä ohjekuplassa näkyy
	var triggers = $(".guide-trigger");
	var all_guide_content = $(".guide-content");
	var vh = $(window).height();
	var of;
	var old = $("section").first();

	$( ".row1" ).scroll( function(){
		
		if( $(".row1").scrollTop() >= (vh-70) ){
			$(".guide-wrapper").fadeIn();

			triggers.each(function(i){

				of = Math.abs( $(this).offset().top );
				
				if ( of < Math.abs(old.offset().top) ){
					showGuideContent(i);
					old = $(this);
				}
			});			
			
		}
		else{
			$(".guide-wrapper").fadeOut();
		}
	});

	function showGuideContent( index ){
		all_guide_content.each(function(j){
			if (j === index){
				$(this).fadeIn()
			}
			else{
				$(this).hide()
			}
		});
	}



	$(".next span, .prev span").css({ top: ($(".speech-main").height() / 2) - 10 });
	
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
			$(".prev span").show();
		}
		if( nextContent.hasClass("last") ){
			$(".next span").hide();
		}
		$(".next span, .prev span").css({ top: ($(".speech-main").height() / 2) - 10 });
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
			$(".prev span").hide();
		}
		if( currentContent.hasClass("last") ){
			$(".next span").show();
		}
		$(".next span, .prev span").css({ top: ($(".speech-main").height() / 2) - 10 });
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