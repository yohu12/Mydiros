$(document).ready(function() {
	$("#loginBtnId").click(function(){
		var name_text = $("#name_text").val();
		var pword_text = $("#pword_text").val();
		
		if(name_text==""){
//			if(name_text=="" || name_text.length<6){
			//TODO 
			alert("用户名不能为空！");
			return false;
		}
		if(pword_text.value==""){
			alert("密码不能为空！");
			return false;
		}
		
		$("#loginFormId").submit();
	});
});