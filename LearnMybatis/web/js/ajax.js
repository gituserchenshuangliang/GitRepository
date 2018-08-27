$(function() {
	
	$("#sub").click(function() {
		$.post($("#uri").val(),{'query':getParam('jsonstr')}, function(data) {
			var t = '';
			for (var i = 0; i < data.length; i++) {
				t += "<P>" + JSON.stringify(data[i]) + "</p>";
			}
			$("#content").html(t);
		});
	});
	
	function getParam(format){
		var planner = $("#planner").val();
		var contents = $("#contents").val();
		var start = $("#start").val();
		var limit = $("#limit").val();
		var jsons = {'planner':planner,'contents':contents,'start':start,'limit':limit};
		if(format == 'jsonstr'){
			return JSON.stringify(jsons);
		}else {
			var str = 'planner='+jsons.planner+'contents='+jsons.contents+'limit='+jsons.limit+'start='+jsons.start;
			return str;
		}
	}
	
});