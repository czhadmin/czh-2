<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
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
				width:6rem;
			}
			.nav{
				margin-top: 5rem;
				display: flex;
				justify-content: space-between;
				background-color: rgb(252, 252, 254);
			}
			.nav li{
				width: 30%;
				text-align: center;
			}
			.dz{
				background-color: rgb(243, 243, 252);
				height: 50rem;
			}
			.dz-reply-img{
				border-radius: 50%;
				margin-right: 1rem;
				width: 5rem;
				height: 5rem;
			}
			.reply{
				display: flex;
				
				margin: 1rem;
			}
			.dz-reply-img img{
				width: 100%;
    			height: 100%;
				
				border-radius: 50%;
			}
			.reply-p{
				font-size: 1.8rem;
				font-weight: bolder;
				margin-bottom: 0.5rem;
			}
			.hytzhi{
			color: gray;
			margin-left: 1rem;
			margin-top: 0.5rem;
			font-family: "楷体";
			}
			.head-img>img{
			width: 4rem;
			height: 4rem;
			border-radius: 50%;
		}
		.head-img{margin: 0.2rem 0.2rem 0.2rem 0.4rem;}
		</style>
		
	</head>
	<body>
		<div class="tou">
			<a  href="toindex"><span style="line-height: 4.5rem;" class="glyphicon glyphicon-menu-left">联系人</span></a>
			
			<span>添加</span>
			<span style="line-height: 5rem;" class="glyphicon glyphicon-option-horizontal"></span>
			
			
			
		</div>
		
		
		
		<div class="dz">
			
			<div>
				<div>
				  <!-- Nav tabs -->
				  <ul class="nav nav-tabs" role="tablist">
				    <li role="presentation" class="zhaor"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">找人</a></li>
				    <li role="presentation" class="sqjlu"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">申请记录</a></li>
				   
				  </ul>

				</div>
				
			</div>
			
			
			<div class="dz-2">
				<div class="input-group input-group-lg ">
				  <input type="text" class="form-control hyzh" placeholder="QQ号/手机号/群/公众号" aria-describedby="sizing-addon1">
				  <span class="input-group-addon glyphicon glyphicon-search ssFri" id="sizing-addon1" data-pd="1"></span>
				</div>
				
				<div class="friend">
					<div class="reply" v-for="lis in ff">
						<div class="dz-reply-img">
							<img src="img/a.jpg" />
						</div>
						<div>
							<p class="reply-p">{{lis.nickname}}</p>
							<p class="reply-p">{{lis.username}}</p>
						</div>
						<div>
							<a :href="'toaddFriend?userid='+(lis.userid)"><button class="btn btn-danger" style="margin-left: 10rem;margin-top: 1rem;">添加</button></a>
						</div>
					</div>
				
				</div>

		</div>
		
				<div class="dierye">
				<p class="hytzhi">好友通知</p>
				<div class="tozhinr">
				
				<div class="head-img" v-for="lis in hyff">
				<img src="img/20150308190319_ddBNF.jpeg"/>
				<b  v-if="${userTab.userid}==lis.pasvuserid" >
				<span style="font-size: 1.5rem" :data-dd="(lis.pasvuserid)" :data-ok="(lis.isok)">{{lis.userentity.nickname}}:</span>
				<span style="font-size: 1rem" :data-dd="(lis.pasvuserid)">{{lis.remark}}</span>
				<button v-if="lis.isok==0" style="margin-left: 10rem;margin-right: 1rem">
				<a :href="'toyiaddFriend?userid='+(lis.userentity.userid)+'&hygroupingId='+(lis.groupingid)+'&beizhu='+(lis.beizhu)">同意<a>
				</button>
				<button v-if="lis.isok==0" v-on:tap="gaibianisOkff(lis.userid)" class="gaibianisOk">
				<a :data-bb="(lis.userid)" >拒绝</a>
				</button>
				<span style="margin-left: 10rem;margin-right: 1rem" v-if="lis.isok==1">已同意</span>
				
				<span style="margin-left: 10rem;margin-right: 1rem" v-if="lis.isok==2">已拒绝</span>
				</b>
				<b v-if="${userTab.userid}==lis.userid">
				<span style="margin-right: 15rem;" :data-dd="(lis.pasvuserid)">{{lis.userentitytwo.nickname}}</span>
				<span v-if="lis.isok==0">等待验证</span>
				<span v-if="lis.isok==1">已同意</span>
				<span v-if="lis.isok==2">已拒绝</span>
				</b>
				
				</div>
				
				</div>
				</div>
	
		<script src="js/zepto.js"></script>
		<script src="js/vue.js"></script>
		<script>
			$(function(){
				$(".friend").hide()
				$(".ssFri").on("touchstart",function(){
					if($(this).attr("data-pd")=="1"){
						$(".friend").show()
						$(this).attr("data-pd","2")
					}else{
						$(".friend").hide()
						$(this).attr("data-pd","1")
					}
					
				})
				
				
			$(".dierye").hide();
				$(".zhaor").on("tap",function () {
					$(".dierye").hide();
					$(".dz-2").show();
				})
				
				$(".sqjlu").on("tap",function () {
					$(".dierye").show();
					$(".dz-2").hide();
					selectfriendApplfor();
				})
				
				
			})
			
			//查询好友申请的vm
				var hyvm = new Vue({
						el:'.tozhinr',
						data : {
							hyff : []
						},
						methods:{
							gaibianisOkff:function(userid){
								$.post("qqajax/gaibianisOkff",{userid:userid},function(){
									
								})
							}
							
						}
					})
			function selectfriendApplfor() {
				$.getJSON("qqajax/selectfriendApplfor",{},function(data){
					
					hyvm.hyff=data;
					console.log(data);
				})
			}
			
			
				$(".dz-2").on("tap",".ssFri",function () {
					chahaoyou($(".hyzh").val());
				})
				//查询用户的vm
				var vm = new Vue({
						el:'.friend',
						data : {
							ff : []
						}
					})
			function chahaoyou(username) {//查询用户
				$.getJSON("qqajax/chahaoyou",{username:username},function(data){
					console.log(data);
					vm.ff=data;
				})
			}
		</script>
	</body>
</html>