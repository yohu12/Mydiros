<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext +"/"; %>   

		<div class="top">
		  <div class="top_center">
		    <div class="top_center_d"><img src="<%=basePath %>images/pic01.jpg" /></div>
			<div class="top_center_main">
			  <div class="top_center_logo">
			    <a href=""><img src="<%=basePath %>images/logo.png" /></a>
				<span>
				  rdj123 　�丝六级<br />
				  <a href="">个人中心</a> | <a href="">同城</a>
				</span>
			  </div>
			  <div class="nav">
			    <ul>
				  <li><a href="">首页</a></li><li id="nav_li"></li>
				  <li><a href="">I'M Diors</a></li><li id="nav_li"></li>
				  <li><a href="">Diors发烧友</a></li><li id="nav_li"></li>
				  <li><a href="">创业屋</a></li>
				</ul>
				<span>
				  <a href="">发现</a>  |
				  <a href="">发帖</a>
				</span>
			  </div>
			</div>
			<div class="top_center_ad"><img src="<%=basePath %>images/pic02.jpg" /></div>
			<div style="clear:both"></div>
		  </div>
		</div>


