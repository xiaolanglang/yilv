$.fn.autoHeight = function(max_height) {

	function autoHeight(elem) {
		if (elem.scrollHeight >= max_height) {
			return;
		}
		elem.style.height = 'auto';
		elem.scrollTop = 0; //防抖动
		elem.style.height = elem.scrollHeight + 'px';
	}

	this.each(function() {
		autoHeight(this);
		$(this).on('keyup', function() {
			autoHeight(this);
		});
	});

}
$('textarea').autoHeight(70);

function Method() {
	var data = {};
	this.getData = function() {
		return data;
	}
	this.setImgs = function(images) {
		data.images = images;
		return this;
	}
	this.setPosition = function(position) {
		data.position = position;
		return this;
	}
	this.setContent = function(content) {
		data.content = content;
		return this;
	}
	this.setRange = function(range) {
		data.range = range;
		return this;
	}
}

jsMethod = new Method();
$(function() {

	$("#send").click(function() {
		var url = "";
		var data = {};
		jsMethod.setContent($("#content").val());
		jsMethod.setRange($("#range").attr("range"))
		data = jsMethod.getData();
		console.log(data);
		// $.post(url, data, function(data) {});
	});

	new jBox('Modal', {
		attach: $('#range'),
		content: $("#modal-content"),
		closeButton: "none"
	});

	$(".select-range").click(function() {
		var range = $(this).attr("range");
		var conetnt=$(this).html();
		$('#range').attr("range", range).empty().append(conetnt).click();
	});
})