<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <% String appContext = request.getContextPath(); 
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+ request.getServerPort() + appContext + "/"; %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>发烧60s</title>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/style.css" />
</head>
<body>
<jsp:include page="/common/header.jsp" />

<div class="fs_ds">
  <ul>
    <li><a href="" style="border-bottom:5px solid #ce4242;">发烧60S</a></li>
	<li style="margin-left:110px;"><a href="">�丝同城</a></li>
  </ul>
</div>

<div class="position"><a href="<%=basePath %>">首页</a>><!-- <a href="">I'M Diors</a> > <a href="">Diors 发烧友</a> > -->  <a href="<%=basePath %>/fastThought/showList">发烧60S</a> > <a href="<%=basePath %>/fastThought/showDetail?Id=${fastThought.id}">${fastThought.thoughtTitle }</a> </div>

<div class="content">
  <div class="content_left">
    <div class="tongcheng">
	  <span>发烧60S</span>
	  <a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a><a href="">日剧</a><a href="">美剧</a>
	</div>
  
    <div class="news">
	  <div class="bg_fir_news"></div>
	  <div class="news_center">
	    <div class="news_center_top"></div>
		<div class="news_center_detail">
		  <div class="tongcheng_title">
		    <ul>
			  <li style=" font-size:24px; color:#313131;">${fastThought.thoughtTitle }</li>
			  <li>${fastThought.user.name }  ${fastThought.createDt } <span style="float:right;"><a href="">评论</a> | <a href="">赞</a> | <a href="">收藏</a></span></li>
			</ul> 
		  </div>
		  <div class="tongcheng_detail_center">
		    <img src="<%=basePath %>images/pic05.jpg" />
			${fastThought.context }
		  </div>
		  <div class="write">

			<div class="ds-thread" data-thread-key="${fastThought.id }"data-title="${fastThought.thoughtTitle }"></div>
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
		  </div>
		</div>
		<div class="news_center_bot"></div>
	  </div>
	  <div class="bg_sen_news">28/10</div>
	</div>
	
	<div class="page">
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