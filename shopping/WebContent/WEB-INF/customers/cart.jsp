<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <style type="text/css">
		body{
			margin:0;
			padding:0;
		}
		a{text-decoration:none;}

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
			float:left;
		}
		#logo_sou dl{
			
			padding:0;margin:0;
		}
		#logo_sou dd{
			line-height:20px;
			margin-left:-120px;
		}
		#logo_sou dd h2{
			margin:7px;
		}
		.mbb{
			margin-right:150px;
			float:left;
		}
		.gou{
			padding-top:5px;
			float:right:
			margin-right:20px;
			width:350px;
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
			width:920px;
			padding:20px;
		}
		#container table{
			width:920px;font-size:13px;
		}
		#container table .td3{
			width:10%;
			text-align:center;
		}
		#container table .td3 img{
			width:90%;
		}
		#container table .td2{
			width:40%;
			text-align:left;
		}
		#container table .td2 p{
			margin:0;
			line-height:20px;
			
		}
		#container table .input{
			text-align:center;
			width:30px;
		}
		#container table th,#container table td{
			border-spacing:0;
			border-collapse : collapse ;
			line-height:20px;
			padding:10px 0;
		}
		#container table th{
			border-bottom:2px solid #222;
		}

		#container table tbody td{
			border-bottom:1px dashed #999;
		}

		#container table tfoot td{
			text-align:right;
			padding:20px 0;
			border-bottom:2px solid #222;
		}
		#container table tfoot td span.price{
			font-size:30px;
			color:#ff0000;
			font-weight:bold;
			
		}
		#container .tijiao{
			text-align:right;
		}
		#container .tijiao a{
			color:#fff;
			display:inline-block;
			width:150px;
			height:40px;
			line-height:40px;
			font-weight:bold;
			background:#f53810;
			text-align:center;
		}
		#container .tijiao a:active{
			background:#d53810;
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
			<dl>
				<dd><h2>购物车</h2></dd>
				<dd>您好，欢迎光临!</dd>
			</dl>
		</div>
		<div id="" class="gou">
			<img src="images/1.png" width="335" height="30" alt="" />
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
	<table cellspacing="0">
		<thead>
			<tr>
				<th class="td3"></th>
				<th class="td2">商品名称</th>
				<th class="td3">麦包价</th>
				<th class="td3">数量</th>
				<th class="td3">优惠</th>
				<th class="td3">小计</th>
				<th class="td3">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${lis }" var="lis">
				<tr>
				<td class="td3"><img src="${lis.image }"/></td>
				<td  class="td2">
					<p>[${lis.goodstype }]${lis.descrption } ${lis.color }</p>
					<p>${lis.goodsid }</p>
				</td> 
				<td class="td3" id="jiage">￥<a>${lis.price }</a></td>
				<td class="td3">
					<a class="jian" id="${lis.orid }" href="javascript:">-</a>
					<input onclick="" class="input" value="${lis.qty }"/>
					<a style="display: none;" class="zoj">${lis.orderId }</a>
					<a class="jia" id="${lis.orid }" href="javascript:">+</a>
				</td>
				<td class="td3">-￥0.00</td>
				<td class="td3" id="xxj">￥${lis.orprice }</td>
				<td class="td3"><a class="spsc" id="${lis.orid}" href="javascript:">删除</a></td>
			</tr>
		</c:forEach>
		
		</tbody>
		<tfoot>
			<tr>
				<td colspan="7" class="jj">
					<span class="">应付金额:</span>
					<span class="price">￥${olis.price }</span>
				</td>
			</tr>
		</tfoot>
	</table>
	<p class="tijiao">
		<a href="gw?type=totijiao" class="tj">提交订单</a>
	</p>
  </div>
   <!-- 页面底部 -->
  <div id="footer" class="">
	<img src="images/footer.PNG" width="960" height="162" alt="" />
  </div>
 </body>
  <script type="text/javascript" src="js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
  	$(function() {
  		jiajian();
  		$(".jia,.jian").click(function() {
  			var xj=parseInt($(this).siblings(".input").val())*parseInt($(this).parent().siblings("#jiage").find("a").html());
  			
  			xiaoji(xj,$(this).attr("id"),$(this).siblings(".input").val(),$(this));
  		    
  			zojia($(this).siblings(".zoj").html(),$(this));
		})
		$(".spsc").click(function(){
			sc($(this).attr("id"),$(this));
			
		})
		$(".tj").click(function() {
			var orderId=$(".zoj").html();
			$.get("gw?type=spzosc&orderId="+orderId,function(){
				
				
			});
		})
	});
 	function xiaoji(xj,orid,sl,a) {
  		$.post("gw?type=xgxiaoji&xj="+xj+"&orid="+orid+"&sl="+sl,function(data){
  			$("tr").has(a.parent()).find("#xxj").html("￥"+data);
  		});
		
	}
  	function jiajian() {
		$(".jia").click(function() {
	var a=	parseInt($(this).siblings(".input").val())+1;
	$(this).siblings(".input").val(a);
		})
		$(".jian").click(function() {
	var a=	parseInt($(this).siblings(".input").val())-1;
	$(this).siblings(".input").val(a);
		})
	}
  	function zojia(orderId,a) {
  		$.post("gw?type=xgzojia&orderId="+orderId,function(data){
  			a.parent().parent().parent().siblings("tfoot").find(".price").html("￥"+data)
  		});
		
	}
  	function sc(orid,a) {
		$.get("gw?type=spsc&orid="+orid,function(){
			a.parent().parent().remove();
			
		});
	}
  </script>
</html>