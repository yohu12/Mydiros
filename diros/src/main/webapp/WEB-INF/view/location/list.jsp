<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext + "/"; %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css" />
 <!-- Duoshuo Comment BEGIN -->
			<script type="text/javascript">
				var duoshuoQuery = {
					short_name : "diros"
				};
				(function() {
					var ds = document.createElement('script');
					ds.type = 'text/javascript';
					ds.async = true;
					ds.src = 'http://static.duoshuo.com/embed.js';
					ds.charset = 'UTF-8';
					(document.getElementsByTagName('head')[0] || document
							.getElementsByTagName('body')[0]).appendChild(ds);
				})();
			</script>
			<!-- Duoshuo Comment END -->
</head>
<body>
<jsp:include page="/common/header.jsp" /> 	
<div class="hi"><img src="<%=basePath %>images/pic03.jpg" /></div>
<div class="position"><a href="">I'M Diors</a> > <a href="">Diors 发烧友</a> > <a href="">�丝同城</a> > </div>


<div class="content">
  <div class="content_left">
    <div class="tongcheng">
	  <span>同城</span>
	  <a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a>
	</div>
  
      <form action="<%=basePath%>loc/list" method="get">
	     <c:forEach items="${lists}" var="location">
	<div class="news" style="margin-top:10px;">
	  <div class="bg_fir_news"></div>
	  <div class="news_center">
	    <div class="news_center_top"></div>     
		<div class="news_center_detail">
		  <div class="tongcheng_title">
		    <ul>
		    	
			  <li style=" font-size:24px; color:#313131;"><a href="<%=basePath%>loc/${location.id}">${location.title }</a><span style="font-size:24px; color:#e70050; float:right; clear:both; position:absolute; top:10px; right:10px;">#1</span>
			  </li>
			  <li>章蔚玮  ${location.createTime} <span><a href=""><span class="ds-thread-count" data-thread-key="${location.id}"></span></a></span></li>
				
			</ul> 
		  </div>
		  <div class="tongcheng_detail">
		    <img src="<%=basePath%>images/pic05.jpg" align="left" />
					${location.details}
		  </div>
		</div>		
		<div class="news_center_bot"></div>
		
	  </div>
	  <div class="bg_sen_news">同城 <font>29/10</font></div>
	</div>	
		</c:forEach>
		<div class="page">
			<jsp:include page="/common/pagemodel.jsp"/>
		</div>
		</form>
  </div>
  <div class="content_right">
    <div class="hot">
	  <h3>最新测试</h3>
	  <ul>
	    <li><span>1、</span>用户<span>arden</span>测试评为<span>初级�丝</span>10-28 21:41:40</li>
		<li><span>1、</span>用户<span>arden</span>测试评为<span>初级�丝</span>10-28 21:41:40</li>
		<li><span>1、</span>用户<span>arden</span>测试评为<span>初级�丝</span>10-28 21:41:40</li>
		<li><span>1、</span>用户<span>arden</span>测试评为<span>初级�丝</span>10-28 21:41:40</li>
		<li><span>1、</span>用户<span>arden</span>测试评为<span>初级�丝</span>10-28 21:41:40</li>
		<li><span>1、</span>用户<span>arden</span>测试评为<span>初级�丝</span>10-28 21:41:40</li>
		<li><span>1、</span>用户<span>arden</span>测试评为<span>初级�丝</span>10-28 21:41:40</li>
	  </ul>
	</div>
	
	<div class="hot">
	  <h3>热门标签</h3>
	  <a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">谢耳朵</a><a href="">日剧</a><a href="">美剧</a>
	</div>
	
	<div class="ad" style="margin-top:15px;">广告</div>
	
	<div class="talk">
	  <h3>最新评论</h3>
	 	<ul class="ds-recent-comments" data-num-items="10"></ul>
	</div>
	
  </div>
  <div style="clear:both"></div>
</div>

<div class="footer">
	<jsp:include page="/common/footer.jsp" /> 
</div>
</body>
</html>
