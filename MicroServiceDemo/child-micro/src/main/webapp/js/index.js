function test(){
	var url = $('#act').val();
	$.post(url,function(response){
		$('#result').val(response);
	});
}