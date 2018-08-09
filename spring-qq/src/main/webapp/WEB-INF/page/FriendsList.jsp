<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/remstyle.js" ></script>
	</head>
	<style type="text/css">
		body{background: transparent;padding: 6rem 0 3.7rem 0;}
		:focus{outline: 0;}
		#seek-div>button{
			height: 3rem;
			width:100%;
			background-color: rgba(0,0,0,0);
			border: 1px solid rgba(255,255,255,0.3);
			border-radius: 2px;
			color: rgba(255,255,255,0.8);
		}
		#seek-div{margin-bottom: 0.5rem;}
		
		.nav-tabs{
			border: 1px solid rgba(255,255,255,0.3);
		}
		
		.nav-tabs li{
			width: 7rem;
		}
		
		.nav-tabs li a{
			border: none !important;
			color: rgba(255,255,255,0.5);
		}
		
		.head-img>img{
			width: 4rem;
			height: 4rem;
			border-radius: 50%;
		}
		.head-img{margin: 0.2rem 0.6rem 0.2rem 0.4rem;}
		
		.list-div{
			display: flex;
			min-width: 100%;
			padding-top: 0.6rem;
		}
		
		.friend-list{
			margin: 0;
		}
		.friend-list li,.grouping-list .grouping-friend{
			padding: 0;
		}
		.nav-tabs .active{
			border-bottom: 4px solid white;
		}
		.nav-tabs .active a{
			color:white !important;
		}
		
		.group-div,.newfriend{
			color: rgba(255,255,255,0.8);
		}
		.newfriend li{
			background-color: rgba(0,0,0,0.4);
			border: 1px solid rgba(255,255,255,0.3);
			padding: 1rem;
		}
		.group-div{
			background-color: rgba(0,0,0,0.4);
		}
		.group-div *{
			background-color: rgba(0,0,0,0) !important;
		}
		.tab-content li{
			border: none;
			border-bottom: 1px solid rgba(255,255,255,0.3);
		}
		.grouping-list .grouping-friend{
			border: none !important;
		}
	</style>
	<body>
		<div id="body-div">
			<div id="seek-div" class="container">
				<button><span class="glyphicon glyphicon-search" style="position: initial;"></span>搜索</button>
			</div>
			<div class="newfriend">
				<ul class="list-group">
				  <li class="list-group-item cjfz">创建分组<span class="glyphicon glyphicon-chevron-right pull-right"></span></li>
				</ul>
			</div>
			<div class="group-div">
				  <ul class="nav nav-tabs text-center" role="tablist">
				    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">好友</a></li>
				    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">群聊</a></li>
				    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">设备</a></li>
				    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">通讯录</a></li>
				  </ul>
				
				  <!-- Tab panes -->
				  <div class="tab-content">
				    <div role="tabpanel" class="tab-pane active" id="home">
				    	<ul class="list-group grouping-list">
						  <c:forEach var="gg" items="${gg}">
						   <li class="list-group-item grouping-list-li">
						  	<span><span class="glyphicon glyphicon-triangle-right"></span>${gg.groupingname }</span><span class="pull-right">0/0</span>
						  </li>
						  <c:forEach var="hy" items="${gg.friendlis}">
						  	  <li class="list-group-item grouping-friend">
						  		<ul class="list-group friend-list">
									<li class="list-group-item">
										<div class="list-div">
									  		<div class="head-img"><img src="img/20150308190319_ddBNF.jpeg"/></div>
										  	<div class="usernameAndShuoShuo">
										  		<p><b>${hy.friendname }</b></p>
										  		<p>[在线]</p>
										  	</div>
										</div>
									</li>
								</ul>
						  </li>
						  </c:forEach>
						  </c:forEach>
						</ul>
				    </div>
				    <div role="tabpanel" class="tab-pane" id="profile">2</div>
				    <div role="tabpanel" class="tab-pane" id="messages">3</div>
				    <div role="tabpanel" class="tab-pane" id="settings">4</div>
				  </div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script>
		$(".grouping-list-li").on("touchend",function(){
			if($(this).find(".glyphicon").is(".glyphicon-triangle-bottom"))
				$(this).find(".glyphicon").removeClass("glyphicon-triangle-bottom").addClass("glyphicon-triangle-right");
			else
				$(this).find(".glyphicon").removeClass("glyphicon-triangle-right").addClass("glyphicon-triangle-bottom");
			$(this).next(".grouping-friend").stop().slideToggle();
		});
		$(".cjfz").click(function(){
			var value = prompt("请输入分组名");
			if(value == "" || value == null) {// 如果取消输入则会返回null
				return;
			}
			addfenzu(value);
		})
		function addfenzu(groupingName) {
			$.post("qqajax/addfenzu",{groupingName:groupingName},function(data){
				if(data>0){
					location="toFriendsList";
				}
			})
		}
	</script>
</html>