$.CommonComponent = $.CommonComponent ? $.CommonComponent : {};

(function($) {
	$.extend(true, $.CommonComponent, {
		Validation : function(sParam, otherFn) {
			var newArr = [];
			$('#' + sParam.content + " .required").each(function() {
				var id = $(this).attr('id');
				var newItem = {
					input : "#" + id,
					message : $.i18nManager('error.' + id),
					action : "select, keyup, blur",
					rule : function(input, commit) {
						if (nullCheck(id)) {
							if (id in otherFn) {
								return otherFn[id](id, commit);
							}
							return true;
						}
						return false;
					}
				};
				newArr.push(newItem);
			});
			$('#' + sParam.content).jqxValidator({
				rules : newArr
			});
		},
		NullCheck : function(sParam) {
			return nullCheck(sParam);
		},
		RedirectPost : function(location, args) {
			var form = '';
			$.each(args, function(key, value) {
				form += '<input type="hidden" name="' + key + '" value="'
						+ value + '">';
			});
			$(
					'<form modelAttribute="params" enctype="multipart/form-data" action="'
							+ location + '" method="POST">' + form + '</form>')
					.appendTo('body').submit();
		},
		serializeObject : function(id) {
			var o = {};
			var a = $('#' + id +' :input').serializeArray();
			console.log(a);
			$.each(a, function() {
				if (o[this.name]) {
					if (!o[this.name].push) {
						o[this.name] = [ o[this.name] ];
					}
					o[this.name].push(this.value || '');
				} else {
					o[this.name] = this.value || '';
				}
			});
			return o;
		}
	});

	var nullCheck = function(id) {
		return $('#' + id).val() != null && $('#' + id).val() != '';
	};	

})(jQuery);

$.i18nManagerInit = function(pSettings) {
	var mSettings;

	var mDefaultSettings = {
		name : 'messages',
		path : 'resources/locale/',
		mode : 'map',
		language : 'en'
	};

	// Deep copy the passed parameters with default parameters
	mSettings = $.extend({}, mDefaultSettings, pSettings || {});

	jQuery.i18n.properties(mSettings);
};

$.i18nManagerInit({
	name : [ 'messages', 'errorMessages' ]
});

$.i18nManager = function(pKey) {
	return $.i18n.prop(pKey);
};

/** Numeric Validation: Accept only numeric values ( numbers ) in TextBox using jQuery **/
var specialKeys = new Array();
specialKeys.push(8); //Backspace
$(function () {
    $(".numeric").bind("keypress", function (e) {
        var keyCode = e.which ? e.which : e.keyCode
        var ret = ((keyCode >= 48 && keyCode <= 57) || specialKeys.indexOf(keyCode) != -1);
        $(".error").css("display", ret ? "none" : "inline");
        return ret;
    });
    $(".numeric").bind("paste", function (e) {
        return false;
    });
    $(".numeric").bind("drop", function (e) {
        return false;
    });
});
/** Numeric Validation **/

$(document).ready(function() {
	$('.required').each(function(){
		$(this).wrap($('<span>').attr({style: "float:left"}));
		$('<span>').attr({class: "req"}).text('*').insertAfter($(this).parent());
	});
});