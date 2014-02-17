<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String appContext = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ appContext;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>中国屌丝网</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
<script src="js/slideshow.js" type="text/javascript"></script>
<style type="text/css">
.skin ul {
	float: right;
	height: 40px;
	margin-top: 10px;
	margin-right: 50px;
	_margin-right: 20px;
}

.skin ul li {
	list-style-type: none;
	float: left;
	width: 30px;
	height: 30px;
	border: 1px solid #FFFFFF;
	margin-left: 10px;
	cursor: pointer;
}

.skin {
	height: 40px;
	position: relative;
	border-bottom: solid 1px #cccc;
	top: 0;
	left: 0;
	width: 100%;
}

.co1 {
	background-color: #00bff3;
} /*01*/
.co2 {
	background-color: #f36e00;
} /*02*/
.co3 {
	background-color: #8500f3;
} /*03*/
.co4 {
	background-color: #3cb878;
} /*04*/
.submit{
	border:none;
	background:url('images/yes.gif') left top no-repeat;
	width:99px; 
	height:60px;
}
</style>
<script language=javaScript>
	$(document).ready(
			function() {
				//为了安全 google chrome 等浏览器是禁止本地文件写Cookie的即file:///F:/Lord%20community/lrtk/Untitled-2.html这样的以file开头的是不能写本地文件的
				var cookieClass = getCookie('class');//读取需要缓存的对象。
				$("body").attr("class", cookieClass);//
				$(".skin_list li").each(
						function() {
							$(this).click(
									function() {
										var className = $(this).attr("class");//保存当前选择的类名
										$("body").attr("class", className, 30);//把选中的类名给body
										function SetCookie(name, value, day)//两个参数，一个是cookie的名子，一个是值
										{
											var exp = new Date(); //new Date("December 31, 9998");
											exp.setTime(exp.getTime() + day
													* 24 * 60 * 60 * 1000);
											document.cookie = name + "="
													+ escape(value)
													+ ";expires="
													+ exp.toGMTString();
										}
										SetCookie("class", className, 30);
									});
						});

		$("#name_text").click(function(){	
			$(this).val("");
		});	
		$("#name_text").blur(function(){			
			if($(this).val().length == 0){
				$(this).val("用户名/邮箱");
			}
		});	

		$("#pword_text").click(function(){			
			$(this).val("");
		});	
		$("#pword_text").blur(function(){			
			if($(this).val().length == 0){
				$(this).val("在此键入密码");
			}
		});	

	});
	function getCookie(name)//取cookies函数       
	{
		var nameEQ = name + "=";
		var ca = document.cookie.split(';');
		for ( var i = 0; i < ca.length; i++) {
			var c = ca[i];
			while (c.charAt(0) == ' ')
				c = c.substring(1, c.length);
			if (c.indexOf(nameEQ) == 0)
				return c.substring(nameEQ.length, c.length);
		}
		return null;
	}


</script>
<style>
body {
	background-color: #00bff3;
}
</style>
</head>

<body>
	<div class="main_top">
		<div class="skin">
			<ul class="skin_list">
				<li class="co1"></li>
				<li class="co2"></li>
				<li class="co3"></li>
				<li class="co4"></li>
			</ul>
		</div>
	</div>
	<div class="main">
		<div class="main_content">
			<div class="weather">
				<!-- <div class="city">
					<div class="city_name">
						<a href="" class="cd">成都</a> <a href="" class="citymore"><img
							src="images/city_more.gif" /></a>
					</div>
					<div class="wind">
						<ul>
							<li>阴</li>
							<li>南风</li>
						</ul>
					</div>
				</div>
				<div class="today_weather">
					<div class="today_wd">
						<span class="today_pic"><img src="images/weather_1.png" /></span>
						<ul>
							<li class="wendu">15~26℃ <span>今天</span></li>
							<li class="zhiliang">空气质量：84<span class="zl">良</span></li>
						</ul>
					</div>
					<div class="tomorrow">
						<ul>
							<li><span><img src="images/weather_2.png"
									align="left" /> 13~20℃</span> 明天 12月5日 周四</li>
							<li><span><img src="images/weather_3.png"
									align="left" /> 13~20℃</span> 明天 12月5日 周四</li>
						</ul>
					</div>
				</div> -->
				<iframe width="500" scrolling="no" height="120" frameborder="0" allowtransparency="true" src="http://i.tianqi.com/index.php?c=code&id=19&bgc=%23&icon=1&temp=1&num=2"></iframe>
				<div style="clear: both"></div>
			</div>
			<div class="main_content_left">
				<ul>
					<li class="dis"><a href="">I'm Diors</a></li>
					<li class="dis dis_cs"><a href="<%=basePath %>/news/list">�丝测试</a></li>
					<li class="dis_new"><a href="">News</a></li>
					<li class="dis_show"><a href="">�丝秀</a></li>
					<li class="dis dis_fs"><a href="">�丝发烧</a></li>
					<li class="dis dis_fss"><a href="<%=basePath %>/fastThought/showList">发烧60S</a></li>
					<li class="dis dis_tc"><a href="">屌丝同城</a></li>
					<li class="dis dis_chy"><a href="">创业屋</a></li>
					<li class="dis dis_que"><a href="">创业问</a></li>
					<li class="dis_new dis_cy"><a href="">创意</a></li>
					<li class="dis_show dis_wr"><a href="">万融</a></li>
				</ul>
			</div>
		</div>


		<div class="denglu">
			<div class="time">
				<span>12:00</span> 2013年6月6日
			</div>

			<div class="huiyuan_denglu">
				<div class="huiyuan_tx">
					<img src="images/pic10.jpg" /> 雕王
				</div>
				<div class="huiyuan_dl">
					<form id="loginFormId" action="<%=basePath %>/user/login" method="post">
						<div class="search_text">
							<div class="ser_tex">
								<input type="text" class="h_dl" value="用户名/邮箱" name="name" id="name_text" />
								<input name="pword" id="pword_text" type="text" class="h_dl" value="在此键入密码"
									style="margin-top: 20px; margin-bottom: 10px;" />
							</div>
							<div class="go">
								<!-- <a href=""><img src="images/yes.gif" /></a> -->
								<input id="loginBtnId" class="submit" type="submit" value=""/>
							</div>
						</div>
						<div class="choose">
							<input type="checkbox" class="h_che" /> <span>自动登录</span> <input
								name="" type="checkbox" value="" class="h_che" /> <span>记住密码</span>
						</div>
					</form>
				</div>
				<div style="clear: both"></div>
			</div>
			<div class="zc_dl">
				<a href="<%=basePath %>/user/showRegister" style="background: url(images/icon-12.gif) no-repeat;">注册</a>
				<a href="<%=basePath %>/user/showModifyPassword" style="background: url(images/icon-13.gif) no-repeat;">忘记密码？</a>
			</div>
		</div>
	</div>

</body>
</html>