<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext; %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>I'm ds!</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
		<meta name="description" content="站点简要介绍" />
		<meta name="Copyright" content="版权申明" />
		<meta content="关键字" name="keywords" /> 
		<link rel="icon" href="images/favicon.ico" type="image/x-icon" />
		<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
		<script src="js/jquery-1.8.3.js" type="text/javascript"></script>
		<script src="js/slideshow.js" type="text/javascript"></script>
		<script src="js/user/user.js" type="text/javascript"></script>
		<style type="text/css">
			.skin ul{float:right;height:40px;margin-top:20px;margin-right:20px;}
			.skin ul li{list-style-type:none;float:left;width:20px;height:20px;margin-left:10px;cursor:pointer;}
			.skin{height:40px;position: relative;border-bottom:solid 1px #cccc;top:0;left:0;width:100%;}
			.co1{background: url(images/51c5048348d5b9208ab164f4.jpg) no-repeat}/*01*/
			.co2{background: url(images/51bac3da48d5b920ec3a72da.jpg) no-repeat;}/*02*/
			.co3{background: url(images/51c4162048d5b920ec3a7ef1.jpg) no-repeat;}/*03*/
			.co4{background: url(images/51b9541148d5b969af2cf618.jpg) no-repeat;}/*04*/
		</style>
		<script language=javaScript>
			 $(document).ready(function(){
            //为了安全 google chrome 等浏览器是禁止本地文件写Cookie的即file:///F:/Lord%20community/lrtk/Untitled-2.html这样的以file开头的是不能写本地文件的
				var cookieClass = getCookie('class');//读取需要缓存的对象。
				$("body").attr("class",cookieClass);//
				$(".skin_list li").each(function(){
						$(this).click(function(){                          
								var className=$(this).attr("class");//保存当前选择的类名
								$("body").attr("class",className,30);//把选中的类名给body
								function SetCookie(name,value,day)//两个参数，一个是cookie的名子，一个是值
								{
									var exp  = new Date();    //new Date("December 31, 9998");
									exp.setTime(exp.getTime() + day*24*60*60*1000);
									document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
								}
								SetCookie("class",className,30);
						})
					});
				});
            function getCookie(name)//取cookies函数       
            {
                var nameEQ = name + "=";
                var ca = document.cookie.split(';');
                for(var i=0;i < ca.length;i++) {
                    var c = ca[i];
                    while (c.charAt(0)==' ') c = c.substring(1,c.length);
                    if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
                }
                return null;
            }
			
		</script>

	</head>
	<body>
		<div class="main">
			<div class="top">
				<div class="skin"><ul class="skin_list"><li style="width:100px;text-align:right;"></li></li><li class="co1"></li><li class="co2"></li><li class="co3"></li><li class="co4"></li></ul></div>

				<div class="t1">
					<img src="images/字母D-NO.1.jpg" width="80" height="80" title="logo或者头像"/>
					<h2 class="hello">哟嚯，diors</h2>
				</div>
				<div class="t2"  style=" display:none;">
					<div class="tp">
						<a class="selec">成都</a>
						<div class="tp2"><h1 class="weath">阴</h2><h1 class="wind">风</h2></div>
					</div>
					<div class="weather">
						<ul>
							<li>
								<p>今天</p>
								<p>20-100</p>
								<img src="images/ript01.png" />
							</li>
							<li>
								<p>明天</p>
								<p>20-100</p>
								<img src="images/ript01.png" />
							</li>
							<li>
								<p>后天</p>
								<p>20-100</p>
								<img src="images/ript01.png" />
							</li>
						</ul>
					</div>
					<div class="weatherbg trans"></div>
				</div>
				
				<div class="t3">
					<div id="bgclockshade"  class="bc1 trans04"></div>
					<div id="bgclocknoshade" class="bc2 trans04"></div>
					<div id="mainbody" style="position:absolute; visibility:visible">
					</div>
				<div>
			</div>
			<div class="content">
				<div class="left"><br/>
					<ul class="clist">
						<li class="cu">
							<ul class="clu" id="slideshow">
								<li class="cli red"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli orange"><img src=""><p class="des">青葱小测试</p></li>
								<li class="wli green"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli grey"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli skyblue"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli orange"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli Purple"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli dered"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli blue"><img src=""><p class="des">青葱小测试</p></li>
								<li class="wli grey"><img src=""><p class="des">青葱小测试</p></li>
								<li class="wli green"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli orange"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli skyblue"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli blue"><img src=""><p class="des">青葱小测试</p></li>
								<li class="cli green"><img src=""><p class="des">青葱小测试</p></li>
							</ul>
						</li>	
					</ul>
				</div>
				<div class="right">
					<div class="login">
						<div class="lri"><img src="images/thumb6.jpg" width="80" height="90" border="1"/></div>
						<div class="lle">
						<form id="loginFormId" action="<%=basePath %>/user/login" method="post">
							<p><input id="name_text" class="input" name="name" type="text"/></p>
							<p><input id="pword_text" class="input" name="pword" type="password"/></p>
							<p><input type="checkbox" />自动登陆 <input type="checkbox" checked="checked"/> 
							记住密码<input id="loginBtnId" class="submit" type="button" value="走你"/></p>
						</form>
						</div>
					
					</div>
					<div class="links">
						<ul>
							<li><a href="#"><img src="images/growcase_the_social_gunman_icons.png" width="60" height="60" /></a></li>
							<li><a href="#"><img src="images/growcase_gunman_icons.png"width="60" height="60" /></a></li>
							<li><a href="#"><img src="images/growcase_the_social_gunman_icons.png"width="60" height="60" /></a></li>
							<li><a href="#"><img src="images/growcase_the_social_gunman_icons.png"width="60" height="60" /></a></li>
							<li><a href="#"><img src="images/growcase_the_social_gunman_icons.png"width="60" height="60" /></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="foot" style=" display:none;">
			<a>丝筹之路</a>
			<p><span>进展</span><img src="images/heart.gif"><a>有1000位屌丝结伴</a><button>去看看</button></p>
		</div>
	</body>
</html>