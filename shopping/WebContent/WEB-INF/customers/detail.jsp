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
			height:20px;
			width:260px;
			border:none;/*去掉文本框的边框*/
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
			margin:0 auto;
			width:960px;
		}
		.location{
			line-height:40px;
			border-bottom:2px solid #222;
			font-size:14px;
		}
		#container .detail{
			margin-top:30px;
			
		}
		#container .img{
			width:479px;
			float:left;
			border-right:1px solid #d1d1d1;
			height:500px;
		}
		#container .info{
			display:inline;
			float:left;
			width:480px;
			
		}
		#container .info ul{
			padding:0;
			margin:0 0 0 10px;
			list-style:none;
		}
		#container .info h2{
			font-size:18px;
		}
		.info .gouto{
			border:1px solid #c3c3c3;
			background:#e7e7e7;
			height:200px;
			margin-top:100px;
			position:relative;
		}
		.gouto a.buy{
			display:block;
			position:absolute;
			bottom:20px;
			left:10px;
		}
		/*页面底部 */
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
			<a href="javascript:void(0)" class="sousuo">搜索</a>
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
  <!-- 显示商品详情 -->
  <div id="container" class="">
	<div id="" class="location">
		<span class="left">当前位置:麦包包> 好漂亮的包啊</span>
	</div>
	<div id="" class="detail">
		<div id="" class="img">
			<img src="${lis.image }" />
		</div>
		<div id="" class="info">
			<ul>
				<li><h2>[${lis.goodstype}]${lis.descrption} ${lis.color}</h2></li>
				<li><span class="">编号：${lis.id}</span></li>
				<li><span class="">价格:￥${lis.price}</span></li>
				<li class="gouto">
					<a href="gw?type=addgwc&price=${lis.price}&id=${lis.id}" class="buy"><img src="images/gouto.PNG" /></a>
				</li>
			</ul>
		</div>
	</div>
  </div><div style="clear:both"></div>
   <!-- 页面底部 -->
  <div id="footer" class="">
	<img src="images/footer.PNG" width="960" height="162" alt="" />
  </div>
 </body>
</html>