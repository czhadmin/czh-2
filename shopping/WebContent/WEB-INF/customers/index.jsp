<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

</head>
<style type="text/css">
		body{
			margin:0;
			padding:0;
		}
		#header{
			height:60px;
			padding:30px 0 10px 0;
			border-bottom:0px solid #339933;
		}
		#logo{
			width:960px;
			margin:0 auto;
		}
		
		#logo_sou{
			
			/*border:0px solid red;*/
			float:left;
			background:url(images/sou.png) no-repeat left center;
			width:337px;
			height:33px;
			line-height:51px;
			padding:8px 0 0 30px;/*控制搜索框的位置*/
		}
		#logo_sou input{
			position:relative;
			top:2px; /*往下移动2px*/
			height:20px;
			width:260px;
			border:none;/*去掉文本框的边框*/
			outline:none;/*在Chrome浏览器中去掉外边框*/
		}
	
		.sousuo{
			float:right;
			width:70px;
			height:30px;
			line-height:100px;/*让字体偏移到下面很远的地方，目的是不显示出来*/
			overflow:hidden;/*多出的部分不显示*/
		}
		.mbb{
			margin-right:150px;
			float:left;
		}
		.gou{
			padding-top:5px;
			float:right:
			margin-right:20px;
			width:150px;
			float:right;
			padding-top:10px;
		}
		img{border:0;}
		/*菜单*/
		#menu{
			background:#f53810;
			line-height:35px;
			clear:both;
			border:0px solid #000;
		}
		.nav{
			margin:0 auto;
			width:960px;
		}
		.nav ul{
			margin:0;
			padding:0;
			list-style:none;
		}
		.nav li{
			float:left;
			text-align:center;
		}
		.nav a{
			display:block;
			padding:0 20px;
			color:#fff;
			text-decoration:none;
		}
		.nav a:hover{
			background:#b5442d;
			
		}
		/*商品列表部分*/
		#container{
			clear:both;
			margin:10px auto 10px auto;
			border:1px solid #797979;
			width:958px;
			
		}

		.product{
			width:237px;
			padding:1px;
			float:left;
		}
		.product img{
			width:210px;
		}
		.product dd{
			line-height:20px;
			font-size:13px;
			margin:0;
		}
		.product dd.text{
			
			height:42px;
			
		}
		#pager{
			text-align:center;
		}
		#pager a{
			text-decoration:none;
			color:#222;
			display:inline-block;
			width:24px;
			height:24px;
			line-height:24px;
			border:1px solid #d00;
			text-align:center;
			
		}
		#pager a:hover{
			background:#d00;
			color:#fff;
		}
		#footer{
			clear:both;
			width:960px;
			margin:20px auto;
		}
	</style>
 </head>
	
 <body>
 <!-- 头部logo -->
  <div id="header" class="">
	<div id="logo" class="">
		<div id="" class="mbb">
			<img src="images/logo.png" alt="" />
		</div>
		<div id="logo_sou" class="">
			<input type="text" id="" />
			<a href="#" class="sousuo">搜索</a>
		</div>
		<div id="" class="gou">
			<a href=""><img src="images/cart.PNG" width="121" height="32" alt="" /></a>
		</div>
	</div>
  </div>
  <!-- 导航菜单 -->
  <div id="menu" class="">
	<div id="" class="nav">
		<ul>
			<li><a href="gw?type=toindex">首页</a></li>
			<li><a href="gw?type=dlquery">登陆</a></li>
			<li><a href="gw?type=tozc">注册</a></li>
		</ul>
		<div style="clear:both"></div>
	</div>
  </div>
  <!-- 显示商品列表 -->
  <div id="container" class="">
  <c:forEach items="${lis }" var="lis">
  <dl class="product">
		<dt><a href="gw?type=toxq&goodsid=${lis.id }"><img src="${lis.image }" alt="" /></a></dt>
		<dd class="text">[${lis.goodstype }]${lis.descrption }</dd>
		<dd >价格:￥${lis.price }</dd>
	</dl>
  </c:forEach>
	
	<div style="clear:both"></div><!-- 清除浮动 -->
  </div>
  <div id="pager">
	<a href="">1</a>
	<a href="">2</a>
	<a href="">3</a>
	<a href="">4</a>
  </div>
  <!-- 页面底部 -->
  <div id="footer" class="">
	<img src="images/footer.PNG" width="960" height="162" alt="" />
  </div>
 </body>
</html>