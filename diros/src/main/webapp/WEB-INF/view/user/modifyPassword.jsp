<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext; %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户密码</title>
<style type="text/css">
	#modifyPasswordForm { margin:0; padding:5px 10px; }
	#modifyPasswordForm .red { color:red; }
	#modifyPasswordForm ol { margin:0; padding:0; list-style:none; }
	#modifyPasswordForm li { margin:0; padding:0; background:none; border:none; display:block; }
	#modifyPasswordForm li.buttons { margin:5px 0 5px 0; }
	#modifyPasswordForm label { margin:0; width:110px; display:block; padding:5px 0; font:bold 12px Georgia, "Times New Roman", Times, serif; color:#656565; text-transform:capitalize; }
	#modifyPasswordForm label span { font:normal 10px Arial, Helvetica, sans-serif; }
	#modifyPasswordForm label.radioCls { margin-left:8px ; width:110px; display:inline;}
	#modifyPasswordForm input.text { width:440px; border:1px solid #dcdcdc; margin:5px 0; padding:5px 2px; height:16px; background:#f5f5f5; }
	#modifyPasswordForm textarea { width:440px; border:1px solid #dcdcdc; margin:10px 0; padding:2px; background:#f5f5f5; }
	#modifyPasswordForm li.buttons input { padding:3px 0; margin:0; border:0; color:#FFF; }
	p.response { text-align:center; color:#2c2c2c; font: bold 11px Arial, Helvetica, sans-serif; line-height:1.8em; width:auto; }
	
	#modifyPasswordForm input.error { border: 1px solid red; }
	#modifyPasswordForm label.error {
		display:none;
		padding-left: 16px;
		margin-left: .3em;
	}
	
</style>
<script src="../js/jquery-1.8.3.js" type="text/javascript"></script>
<script src="../js/jquery.validate.js" type="text/javascript"></script>
<script src="../js/jquery.validate.messages_zh.js" type="text/javascript"></script>

<script type="text/javascript">
	
	//验证是否允许包含空白字符
	jQuery.validator.addMethod("noSpace", function(value, element, param) {
		return (value.indexOf(' ') == -1);
	}, "请去掉字符串中的空格");

	$(document).ready(function() {
		$("#modifyPasswordForm").validate({
			rules : {
				oldPassword : {
					required : true,
					minlength : 6,
					maxlength : 32
				},
				newPassword : {
					required : true,
					minlength : 6,
					maxlength : 32
				},
				repword : {
					required : true,
					minlength : 6,
					maxlength : 32,
					equalTo : "#newPassword"
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
<form action="<%=basePath%>/user/modifyPassword" method="post" id="modifyPasswordForm">
	<ol>
		<li><label for="oldPassword">原密码 <span class="red">*</span></label>
			<input id="oldPassword" type="password" name="oldPassword" class="text" /></li>
		<li><label for="newPassword">新密码 <span class="red">*</span></label>
			<input id="newPassword" type="password" name="newPassword" class="text" /></li>
		<li><label for="repword">确认密码 <span class="red">*</span></label>
			<input id="repword" type="password" name="repword" class="text" /></li>
		<li class="buttons"><input type="image" name="imageField"
			id="imageField" src="../images/send.gif" /></li>
	</ol>
</form>

</body>
</html>
