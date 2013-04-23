var lab2 = (function () {
	/* adding listeners on page load */
	$(function() {
		
	});
	
	return {
		preSendForm: function() {
			var x = $('input[name="x"]:checked').val();
			var y = $('input[name="y"]').val();
			var r = $('input[name="r"]:checked').val();
			
			if (!y.match(/^-?\d+(\.\d+)?$/)) {
				$('input[name="y"]').css("border-color", "red");
				return false;
			}
			
			$('input[name="xselect"]').val(x);
			$('input[name="yselect"]').val(y);
			$('input[name="zselect"]').val(z);
			
			return true;
		}
	};
})();