(function($){
	

	//modal
	//login modal
	$('.ui.modal').modal();
	$('.modal.login').modal('attach events','.ui.login.button')

	.modal({
	inverted:true,
	transition:'fade',
	});

	//add project modal
	$('.modal.project').modal('attach events','.ui.add.project.button')
		.modal({
			inverted:true,
			transition:'fade',
		});
	//add history modal
	$('.modal.history').modal('attach events','.ui.add.history.button')
		.modal({
			inverted:true,
			transition:'fade',
		});

})(jQuery);