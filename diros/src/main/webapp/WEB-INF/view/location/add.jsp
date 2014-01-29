<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext +"/"; %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css" />
 <link rel="stylesheet" href="<%=basePath %>/css/onlinedemo.css" type="text/css"/> 
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "<%=basePath %>/ueditor/";
    </script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath %>/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath %>/ueditor/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath %>/js/jquery-1.8.3.js"></script>
</head>

<body>
	
<jsp:include page="/common/header.jsp" /> 	
		
<div class="hi"><img src="<%=basePath %>images/pic03.jpg" /></div>

<div class="position"><a href="">I'M Diors</a> > <a href="">Diors 发烧友</a> >  <a href="<%=basePath %>news/list">NEWS</a> > <a href="javascript:;">添加新闻</a> </div>

	<div class="content">
		<div class="tongcheng" style="width:100%">
			<span>NEWS</span> <a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a
				href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a
				href="">美剧</a><a href="">日剧</a><a href="">美剧</a>
		</div>
				<div id="editContent" class="w900 border-style1 bg">
					<form class="section" id="form" action="<%=basePath%>/edit/add"
						method="post">
						<h3>增加内容</h3>
						<p class="note"></p>
						<div class="forum">
							<input type="hidden"  id="forum" name="forum" value="1"></input>
							<input type="text" name="title" size="50" />
						</div>
						<div class="details">
							<div>
								<textarea name="content" id="editor"></textarea>
								<script type="text/javascript">
									UE.getEditor('editor');
								</script>
							</div>
						</div>
						<div class="details">
							<span>验证码:</span><input type="text" name="code" size="5" /> <img
								src="<%=basePath%>/random/code" alt="点击图片，刷新验证码" id="randCode" />
							<p />
							<input type="submit" value="提交" class="btn" />
						</div>
					</form>
				</div>
			</div>
	<div class="footer">
	<jsp:include page="/common/footer.jsp" /> 
</div>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$("#randCode").click(function(){
    			$("#randCode").attr("src","<%=basePath %>/random/code?d="+Math.random());
    		});   		
    	});
    
    </script>

</body>
</html>
