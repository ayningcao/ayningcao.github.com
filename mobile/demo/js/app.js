/**
 * 
 */
$(document).on("pageinit", "#foo", function() {

	$(document).on("scrollstart", function(event) {
		console.log(event);
		$("#mypopup").popup("open", (4, 3));
	});

});