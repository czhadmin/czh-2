<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/remstyle.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<style type="text/css">
.tou {
	display: flex;
	justify-content: space-between;
	height: 5rem;
	top: 0;
	line-height: 5rem;
	background-color: rgba(252, 252, 254, 0.7);
	color: black;
	position: fixed;
	width: 100%;
	padding-left: 0.7rem;
}

.tou span {
	font-size: 1.5rem;
	width: 6rem;
}

.dz {
	background-color: rgb(243, 243, 252);
	height: 50rem;
	margin-top: 5.1rem;
}

.dz-reply-img {
	border-radius: 50%;
	margin-right: 1rem;
	width: 5rem;
	height: 5rem;
}

.reply {
	display: flex;
	padding-top: 1rem;
	margin: 1rem;
}

.dz-reply-img img {
	width: 100%;
	height: 100%;
	border-radius: 50%;
}

.reply-p {
	font-size: 1.8rem;
	font-weight: bolder;
	margin-bottom: 0.5rem;
}

.group {
	font-size: 1.6rem;
	background-color: white;
	margin-bottom: 1rem;
	width: 100%;
	padding: 1rem;
}

.group input {
	height: 2.5rem;
	border: 0px solid;
}

.group span {
	margin-right: 1rem;
}
</style>

</head>
<body>
	<div class="tou">
		<span style="line-height: 4.5rem;"
			class="glyphicon glyphicon-menu-left"><a href="tosearchFriend">取消</a></span>

		<span>添加好友</span> <span style="line-height: 5rem;" class="fasonbut">完成</span>



	</div>
	<div class="dz">
		<div class="friend">
			<div class="reply">
				<div class="dz-reply-img">
					<img src="img/a.jpg" />
				</div>
				<div>
					<p class="reply-p">${userTab.nickname}</p>
					<p class="reply-p">${userTab.username}</p>
				</div>

			</div>

		</div>
	
		
		<div style="margin: 1rem;">
			<p>设置备注与分组</p>
		</div>
		<div class="group">
			<span>备注</span> <input class="beizhu" type="text" style="width: 70%;" />
		</div>
		<div class="group">
			<a href="toselectGrouptoyi?userid=${uu.userid}&hhid=${userTab.userid}"> <span>分组</span>
			<span>${fzname}</span><span class="glyphicon glyphicon-chevron-right"></span>
			</a>
		</div>

	</div>


	<script src="js/zepto.js"></script>
	<script>
		$(function () {
			$(".fasonbut").click(function () {
				if("${groupingId}"==""){
					alert("您还没有选择分组哦");
					return;
				}else{
					
				}
			})
		})
		$(".fasonbut").click(function () {
			addfriend($(".beizhu").val(),"${userTab.userid}","${groupingId}");
			alert("${userTab.userid}");
			})
		function addfriend(zijibeizu,frienduserid,groupingId) {
			
			$.post("qqajax/addfriend",{zijibeizu:zijibeizu,frienduserid:frienduserid,groupingId:groupingId},function(){
				
			})
		}
	</script>
</body>
</html>