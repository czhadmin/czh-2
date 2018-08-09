<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>Insert title here</title>
<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/remstyle.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<style type="text/css">
			
			.tou{
				display: flex;
				justify-content: space-between;
				height: 5rem;
				top:0;
				line-height: 5rem;
				background-color: rgba(252, 252, 254,0.7);
				color: black;
				position: fixed;
				width: 100%;
				padding-left: 2.5rem;
			}
			.tou span{
				font-size: 1.5rem;
				width:8rem;
			}
			.dz{
				padding-top: 8rem;
				background-color: rgb(238, 243, 282);
				height: 50rem;
			}
			.group{
				font-size: 1.6rem;
				background-color: white;
				margin-bottom: 0.5rem;
				width: 100%;
				height: 4rem;
				line-height: 2rem;
				padding: 1rem;
			}
			.group1{
				font-size: 1.6rem;
				background-color: white;
				margin-bottom: 3.5rem;
				width: 100%;
				height: 4rem;
				line-height: 2rem;
				padding: 1rem;
			}
			.group input{
				height: 2.5rem;
				border: 0px solid;
			
			}
			.group span{
				margin-right: 1rem;
			}
		</style>
		
	</head>
	<body>
		<div class="tou">
			<span style="line-height: 4.5rem;" class="glyphicon glyphicon-menu-left">添加好友</span>
			
			<span>选择分组</span>
			<span style="line-height: 5rem;">    </span>
		</div>
		<div class="dz">
				<div class="group1 addGroclick">
					<span class="">添加到新分组</span>
				</div>
				
				<div class="group" v-for="lis in ff">
				
				  	<span class="fzuname">{{lis.groupingname}}</span>
				  	<span  class="glyphicon glyphicon-ok lastspan" :data-idd="(lis.groupingid)" :data-userid="(lis.userid)" style="float: right;display: none"></span>
				</div>
				
				<button class="btn qrenbut" style="width: 60%;margin-left:20%;margin-top: 3rem;">确认</button>
		</div>
				
	
		<script src="js/zepto.js"></script>
		<script src="js/vue.js"></script>
		<script>
			$(function(){
				$(".addGroclick").on("touchend",function(){
					
					var groname = prompt("请输入分组名")
					
				})
			
				

				selectfenzu()
				
					$(".dz").on("touchend",".group",function(){
					if($(this).find(".lastspan").is(".glyphicon glyphicon-ok")){
						$(".lastspan").removeClass("glyphicon glyphicon-ok")
						
					}else{
						$(".lastspan").removeClass("glyphicon glyphicon-ok")
						$(this).find(".lastspan").addClass("glyphicon glyphicon-ok")
						$(".lastspan").show();
					}
					
				})
				
				qren() 
			})
			var vm = new Vue({
						el:'.dz',
						data : {
							ff : []
						}
					})
			function selectfenzu() {
				$.getJSON("qqajax/selectfenzu",{},function(data){
					vm.ff=data;
				})
			}
			
			function qren() {//点击确认
				$(".qrenbut").click(function() {
					$(".group").each(function () {
						if($(this).find(".lastspan").attr("class")=="lastspan glyphicon glyphicon-ok"){
							alert($(this).find(".fzuname").html());
							location="toaddFriend?groupingId="+$(this).find(".lastspan").data("idd")+"&userid=${hyid}"+"&fzname="+$(this).find(".fzuname").html();
						}
					})
					
				})
			}
		</script>
	</body>
</html>