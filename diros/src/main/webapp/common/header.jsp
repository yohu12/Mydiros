<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext +"/"; %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
		<div class="top">
		  <div class="top_center">
		    <div class="top_center_d"><img src="<%=basePath %>images/pic01.jpg" /></div>
			<div class="top_center_main">
			  <div class="top_center_logo">
			    <a href=""><img src="<%=basePath %>images/logo.png" /></a>
				<span>
				  <%-- <c:if test='${!empty sessionScope.basicUser}'>
				   　${sessionScope.basicUser.name}<br />
				   </c:if>
				 <c:otherwise>
				  <a href="">请登录</a>
				 </c:otherwise> --%>
				 
				 <c:choose>
						<c:when test='${!empty sessionScope.basicUser}'>
							${sessionScope.basicUser.name}<br />
							<a href="<%=basePath %>/user/logout">退出</a>
						</c:when>
						<c:otherwise>
							 <a href="<%=basePath %>">请登录</a>
						</c:otherwise>
					</c:choose> 
					<a href="">个人中心</a> | <a href="">同城</a>
				</span>
			  </div>
			  <div class="nav">
			    <ul>
				  <li><a href="<%=basePath %>">首页</a></li><li id="nav_li"></li>
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


