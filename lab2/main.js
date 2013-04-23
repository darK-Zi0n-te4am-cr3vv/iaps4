var lab2 = (function () {

	var imgR = 80;
	var submitNoCheck = false;
	
	/* adding listeners on page load */
	$(function() {
		$('#img1').click(function (e) {
			var offset = $(this).offset();
			
			var imgX = e.clientX - offset.left;
			var imgY = e.clientY - offset.top;
			
			/* translate coordinates */
			imgX -= 109;
			imgY = 108 - imgY;
			
			$('input[name="xselect"]').val(parseFloat(imgX) / imgR);
			$('input[name="yselect"]').val(parseFloat(imgY) / imgR);
			$('input[name="rselect"]').val(1);
			
			submitNoCheck = true;
			$('form[name="subForm"]').submit();
			submitNoCheck = false;
		});
	});
	
	return {
		preSendForm: function() {
			if (submitNoCheck)
				return true;
		
			var x = $('input[name="x"]:checked').val();
			var y = $('input[name="y"]').val();
			var r = $('input[name="r"]:checked').val();
			
			if (!y.match(/^-?\d+(\.\d+)?$/)) {
				$('input[name="y"]').css("border-color", "red");
				return false;
			}
			
			$('input[name="xselect"]').val(x);
			$('input[name="yselect"]').val(y);
			$('input[name="rselect"]').val(r);
			
			return true;
		}
	};
})();