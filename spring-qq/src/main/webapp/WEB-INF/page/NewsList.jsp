<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>Insert title here</title>
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
		.news-list li:first-child{
			border-top: 1px solid rgba(255,255,255,0.3);
		}
		.news-list li{
			color: rgba(255,255,255,0.8);
			height: 6rem;
			position: initial;
			padding: 0;
			display: flex;
			background-color: rgba(0,0,0,0.4);
			border: none;
			border-bottom: 1px solid rgba(255,255,255,0.3);
			overflow: hidden;
			border-radius: initial !important;
		}
		.list-div{
			display: flex;
			min-width: 100%;
			padding-top: 0.6rem;
		}
		.usernameAndShuoShuo{width: 100%;line-height: 2rem;}
		.head-img>img{
			width: 4rem;
			height: 4rem;
			border-radius: 50%;
		}
		.head-img{margin: 0.2rem 0.2rem 0.2rem 0.4rem;}
		.badge-danger{background-color: red;border: none;}
		.set-list{
			display: flex;
			color: white;
			min-width: 40%;
			text-align: center;
		}
		.set-list>.del-btn{
			background-color: rgba(255,0,0,0.8);
			flex-grow: 1;
			line-height: 5.7rem;
		}
		.set-list>.read-btn{
			background-color: rgba(255,157,0,0.8);
			flex-grow: 1;
			line-height: 5.7rem;
		}
	</style>
	<body>
		<div id="body-div">
			<div id="seek-div" class="container">
				<button><span class="glyphicon glyphicon-search" style="position: initial;"></span>搜索</button>
			</div>
			<div class="news-list">
				<ul class="list-group">
				<c:forEach items="${lis }" var="lis">
					 <li class="list-group-item list-group-item-success news-list-val dali">
					  	<div class="list-div">
					  		<div class="head-img"><img src="${lis.hyuser.headimg }"/></div>
						  	<div class="usernameAndShuoShuo container-fluid">
						  		<p><b>${lis.hyuser.nickname }</b><span class="pull-right">${lis.hyuser.dtstate.statetime }</span></p>
						  		<p class="xpp" data-lisid=${lis.hyuser.userid }>${lis.hyuser.dtstate.statetext }</p>
						  	</div>
						</div>
						<div class="set-list">
						  		<div class="read-btn">
						  		已读
								</div>
								<div class="del-btn">
						  		删除
								</div>
						</div>
					  </li>
				</c:forEach>
				</ul>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script>
		jQuery.fn.isChildAndSelfOf = function(b){
			return (this.closest(b).length > 0);
		};
	
		$(document).on("touchstart",function(e){
			if(!$(e.target).isChildAndSelfOf(".standOut")){
				animateList($(".standOut"),0,300);
			}
		})
	
		var marginLeft;
		var beginIndex;
		var endIndex;
		var delWidth=$(".set-list").width();
		
		$(".news-list-val").on("touchstart",function(e){
			marginLeft=parseInt($(".list-div",this).css("margin-left"));
			beginIndex=e.changedTouches[0].clientX;
			
			
		})
		$(".news-list-val").on("touchmove",function(e){
			var newIndex=e.changedTouches[0].clientX-beginIndex;
			
			if(parseInt($(".list-div",this).css("margin-left"))>=0){
				if(newIndex>0){
					return false;
				}
			}else if(parseInt($(".list-div",this).css("margin-left"))<=-delWidth){
				if(newIndex<0){
					return false;
				}
			}
			animateList(this,marginLeft+(newIndex),0);
		})
		$(".news-list-val").on("touchend",function(e){
			var newIndex=e.changedTouches[0].clientX-beginIndex;
			var left=marginLeft;
			var one5=delWidth/5;
			if(Math.abs(newIndex)>=one5){
				if(newIndex>0)
					left=0;
				else
					left=-delWidth;
			}
			animateList(this,left,300);
		})
		
		function animateList(u,val,time){
			$(".list-div",u).stop().animate({"margin-left":val},time,function(){
				if(val==-delWidth)
					$(u).addClass("standOut");
				else if(val==0)
					$(u).removeClass("standOut");
			});
		}
		
		$(".dali").click(function(){
			alert($(this).find(".xpp").data("lisid"));
			parent.location="todotai?uuuid="+$(this).find(".xpp").data("lisid");
		})
	</script>
</html>