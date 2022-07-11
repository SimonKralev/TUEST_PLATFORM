(function ($) {
    'use strict';

    $(document).on('ready', function () {
        // -----------------------------
        //  Goto Link
        // -----------------------------
        $("body").click(function() {
		    $('html, body').animate({
		        scrollTop: $("body").offset().top
		    }, 500);
		});

    });







})(jQuery);


