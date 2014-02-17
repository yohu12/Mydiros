<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext; %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="UEditor在线编辑器"/>
    <meta name="description" content="UEditor是百度的一个javascript编辑器的开源项目，能带给您良好的富文本使用体验">
    <title>UEditor - 示例</title>   
    <link rel="stylesheet" href="<%=basePath %>/css/onlinedemo.css" type="text/css"> 
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "/diros/ueditor/";
    </script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath %>/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath %>/ueditor/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="<%=basePath %>/js/jquery-1.8.3.js"></script>
</head>
<body>
<div >
    <div id="editContent" class="w900 border-style1 bg">
        <form class="section" id="form" action="<%=basePath %>/edit/add" method="post">
            <h3>增加内容</h3>
            <p class="note"></p>
            <div class="forum">
            	<select id="forum" name="forum" >
					<option value="-1" selected="selected">选择主题分类</option>
					<option value="1">新闻</option>
					<option value="2">论坛</option>
				</select><input type="text" name="title" size="50"/>
            </div>
            <div class="details">
                <div>
                    <textarea name="context" id="editor"></textarea>	
						<script type="text/javascript">
		 					UE.getEditor('editor');
							</script>                
                </div>
            </div>
            <div class="details" >
            	<span>验证码:</span><input type="text" name="code" size="5">
            	<img src="<%=basePath %>/random/code" alt="点击图片，刷新验证码" id="randCode"><p/>
            	<input type="submit" value="提交" class="btn">        	
            </div>           
   	 	</form>
        </div>
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