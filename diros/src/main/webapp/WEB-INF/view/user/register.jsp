<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<style type="text/css">
	#registerForm { margin:0; padding:5px 10px; }
	#registerForm .red { color:red; }
	#registerForm ol { margin:0; padding:0; list-style:none; }
	#registerForm li { margin:0; padding:0; background:none; border:none; display:block; }
	#registerForm li.buttons { margin:5px 0 5px 0; }
	#registerForm label { margin:0; width:110px; display:block; padding:5px 0; font:bold 12px Georgia, "Times New Roman", Times, serif; color:#656565; text-transform:capitalize; }
	#registerForm label span { font:normal 10px Arial, Helvetica, sans-serif; }
	#registerForm label.radioCls { margin-left:8px ; width:110px; display:inline;}
	#registerForm input.text { width:440px; border:1px solid #dcdcdc; margin:5px 0; padding:5px 2px; height:16px; background:#f5f5f5; }
	#registerForm textarea { width:440px; border:1px solid #dcdcdc; margin:10px 0; padding:2px; background:#f5f5f5; }
	#registerForm li.buttons input { padding:3px 0; margin:0; border:0; color:#FFF; }
	p.response { text-align:center; color:#2c2c2c; font: bold 11px Arial, Helvetica, sans-serif; line-height:1.8em; width:auto; }
	
	#registerForm input.error { border: 1px solid red; }
	#registerForm label.error {
		display:none;
		padding-left: 16px;
		margin-left: .3em;
	}
	
</style>
<script src="../js/jquery-1.8.3.js" type="text/javascript"></script>
<script src="../js/jquery.validate.js" type="text/javascript"></script>
<script src="../js/jquery.validate.messages_zh.js" type="text/javascript"></script>

<script type="text/javascript">

	/* $.validator.setDefaults({
		submitHandler : function() {
			alert("submitted!");
		}
	}); */
	
	//验证是否允许包含空白字符
	jQuery.validator.addMethod("noSpace", function(value, element, param) {
		return (value.indexOf(' ') == -1);
	}, "请去掉字符串中的空格");

	$(document).ready(function() {
		$("#registerForm").validate({
			rules : {
				name : {
					required : true,
					minlength : 3,
					maxlength : 32,
					noSpace : true
				},
				pword : {
					required : true,
					minlength : 6,
					maxlength : 32
				},
				repword : {
					required : true,
					minlength : 6,
					maxlength : 32,
					equalTo : "#pword"
				},
				nickName : {
					maxlength : 32
				},
				location : {
					maxlength : 32
				},
				email : {
					required : true,
					email : true
				}
			},
			messages : {
				repword : {
					equalTo : "确认密码与密码不一致！"
				}
			}
		});
	});
</script>

</head>
<body>
<p/>
<form action="<%=basePath%>/user/register" method="post" id="registerForm">
	<ol>
		<li><label for="name">用户名 <span class="red">*</span></label>
			<input id="name" name="name" class="text" /></li>
		<li><label for="sex">性别 </label>
			<input type="radio" id="sex_male" value="M" name="sex" /><label for="sex_male" class="radioCls">男 </label>
			<input type="radio" id="sex_female" value="F" name="sex"/><label for="sex_female" class="radioCls">女 </label></li>
		<li><label for="pword">密码 <span class="red">*</span></label>
			<input id="pword" type="password" name="pword" class="text" /></li>
		<li><label for="repword">确认密码 <span class="red">*</span></label>
			<input id="repword" type="password" name="repword" class="text" /></li>
		<li><label for="nickName">昵称 <span class="red">*</span></label>
			<input id="nickName" name="nickName" class="text" /></li>
		<li><label for="location">地址</label>
			<input id="location" name="location" class="text" /></li>
		<!-- 
		<li><label for="photo">照片 <span class="red">*</span></label>
			<input id="photo" name="photo" class="text" /></li>
		 -->	
		<li><label for="email">邮箱 <span class="red">*</span></label>
			<input id="email" name="email" class="text" /></li>
		<li class="buttons"><input type="image" name="imageField"
			id="imageField" src="../images/send.gif" /></li>
	</ol>
</form>

</body>
</html>
