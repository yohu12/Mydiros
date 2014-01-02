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
<div class="position"><a href="">I'M Diors</a> > <a href="">HI 屌丝</a> > <a href="">NEWS</a></div>
<div class="ceshi">
  <div class="bg_fir"></div>
  <div class="ceshi_mainbox">
    <div class="ceshi_top"></div>
	<div class="ceshi_mainbox_detail">
	  <img src="<%=basePath %>images/pic09.jpg" />
	</div>
	<div class="ceshi_bot"></div>
  </div>
  <div class="bg_sen"><span>最新</span>动态</div>
  <div style="clear:both"></div>
</div>

<div class="content">
  <div class="content_left">
    <div class="news">
	  <div class="bg_fir_news"></div>
	  <div class="news_center">
	    <div class="news_center_top"></div>
		<div class="news_center_detail">
		  <div class="news_centersort">
		    <a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">谢耳朵</a><a href="">日剧</a><a href="">美剧</a>
		  </div>
		  <div class="news_centerbox">
		  		<c:forEach items="${lists}" var="news">
		    <dl>
			  <dt><a href=""><img src="<%=basePath%>images/pic04.jpg" /></a></dt>
			  <dd><a href="<%=basePath%>news/content/${news.id}">${news.title}</a><span class="one_floot">#1</span></dd>
			  <dd>如果你结婚的那天新娘不是我，我就会把我们的那些暧昧的聊天记录、短信...</dd>
			  <dd>arden <font style="color:#a0a0a0;">${news.createTime}</font> <span><a href=""><span class="ds-thread-count" data-thread-key="${news.id}"></span></a></span></dd>
			</dl>
			</c:forEach>
		  </div>
		  <div class="news_page">
		    <a href="">首页</a> <a href="">上一页</a>
	  <a href="">1</a>
	  <a href="">2</a>
	  <a href="">3</a>
	  <a href="">4</a>
	  <a href="">5</a>
	  <a href="">6</a>
	  <a href="">7</a>
	  <a href="">8</a>
	  <a href="">9</a>
	  <a href="">10</a>
	  <a href="">......</a>
	  <a href="">103</a><a href="">104</a>
	  <a href="">下一页</a><a href="">尾页</a>共<a href="">104</a>页 第<a href="" style="color:#057c08;">5</a>页 <a href="">跳转</a>
		  </div>
		  
		</div>
		<div class="news_center_bot"></div>
	  </div>
	  <div class="bg_sen_news">NEWS</div>
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
	  <!--  
	  <dl>
	    <dt><img src="images/pic04.jpg" /></dt>
		<dd>rdj123 <font>回复语2013-10-26 03:41:18</font> <span>#1</span></dd>
		<dd><a href="">我是被“富士康”吸引来的。富士康是什么东西？</a></dd>
	  </dl>
	  <dl>
	    <dt><img src="images/pic04.jpg" /></dt>
		<dd>rdj123 <font>回复语2013-10-26 03:41:18</font> <span>#1</span></dd>
		<dd><a href="">我是被“富士康”吸引来的。富士康是什么东西？</a></dd>
	  </dl>
	  <dl>
	    <dt><img src="images/pic04.jpg" /></dt>
		<dd>rdj123 <font>回复语2013-10-26 03:41:18</font> <span>#1</span></dd>
		<dd><a href="">我是被“富士康”吸引来的。富士康是什么东西？</a></dd>
	  </dl>
	  <dl>
	    <dt><img src="images/pic04.jpg" /></dt>
		<dd>rdj123 <font>回复语2013-10-26 03:41:18</font> <span>#1</span></dd>
		<dd><a href="">我是被“富士康”吸引来的。富士康是什么东西？</a></dd>
	  </dl>-->
	
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
