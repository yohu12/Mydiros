<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext +"/"; %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css" />
</head>

<body>
	
<jsp:include page="/common/header.jsp" /> 	

<div class="fs_ds">
  <ul>
    <li><a href="">发烧60S</a></li>
	<li style="margin-left:110px;"><a href="" style="border-bottom:5px solid #ce4242;">�丝同城</a></li>
  </ul>
</div>

<div class="position"><a href="">I'M Diors</a> > <a href="">Diors 发烧友</a> > <a href="<%=basePath%>loc/list">吊丝同城</a> > <a href="">${location.title }</a> </div>

<div class="content">
  <div class="content_left">
    <div class="tongcheng">
	  <span>同城</span>
	  <a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a>
	</div>
  
    <div class="news">
	  <div class="bg_fir_news"></div>
	  <div class="news_center">
	    <div class="news_center_top"></div>
		<div class="news_center_detail">
		  <div class="tongcheng_title">
		    <ul>
			  <li style=" font-size:24px; color:#313131;">${location.title }</li>
			  <li>章蔚玮  ${location.createTime } <span style="float:right;"><a href="">评论</a> | <a href="">赞</a> | <a href="">收藏</a></span></li>
			</ul> 
		  </div>
		  <div class="tongcheng_detail_center">
		    <img src="<%=basePath %>images/pic05.jpg" />
				${location.details}
		  </div>
		  <div class="write">					
			<!-- Duoshuo Comment BEGIN -->
			<div class="ds-thread" data-thread-key="${location.id }"data-title="${location.title }"></div>
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
		  </div>
		</div>
		<div class="news_center_bot"></div>
	  </div>
	  <div class="bg_sen_news">同城<fmt:formatDate value="${startTime}" pattern="MM/dd" /></div>
	</div>	
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

<div class="footer"></div>

</body>
</html>
