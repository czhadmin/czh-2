<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
	<style type="text/css">
		.head{background-color: #EFF4FA;border-bottom: 1px solid #D6DFEA;height: 62px;}
		body{margin: 0;}
		a{text-decoration: none;}
		.head_bt{font-size: 12px;height: 100%;width: 94%;margin: 0 auto;text-align: right;color: #C9BBB6;line-height: 60px;}
		.head_bt a{color: #1D5494;padding-right: 3px;}
		.body_div{height: 570px;display: flex;}
		.body_div_left{height: 100%;width: 55%;background-image: url(img/qqlogin.PNG);}
		.body_div_left ul{list-style:none ;padding: 0;line-height: 25px;font-size: 14px;}
		.body_div_left div{margin-left: 30%;margin-top: 15%;}
		.body_div_right{height: 100%;width: 45%;}
		.title_p{color: #6F95C8;font-size: 24px;}
		.body_div_right_div{border: 1px solid #A0B1C4;width: 334px;height: 450px;margin-top: 70px;margin-left: 50px;border-radius:1%;}
		.login_fs{border-bottom: 1px solid #C0CDD9;background-color: #F9FBFE;}
		
		.login_fs div:last-child a{color: black;font-size: 24px; margin-left: 100px;}
		.login_fs div:last-child{flex-grow: 1;padding: 15px 30px 15px 30px;}
		.user_div{border:1px solid #96A5B4 ;height:40px ;text-align: center;margin-bottom: 15px;border-radius:2%;}
		.user_div input{font-size:15px;border: none;height: 50%;margin-top: 10px;width: 90%;}
		.pwd_div{border:1px solid #4892E7 ;height:40px ;text-align: center;margin-bottom: 15px;border-radius:2%;}
		.pwd_div input{font-size:15px;border: none;height: 50%;margin-top: 10px;width: 90%;}
		.body_div_right_div_bot a{font-size: 12px;color: #225592;}
		.body_div_right_div_bot{text-align: right;width: 90%;color: #D5C5BF;}
		.bot{background-color: #EFF4FA;border-top: 1px solid #D6DFEA;height: 36px;font-size: 12px;text-align: center;color: #868686;margin-top: 76px;}
		.bot a{color: #1D5494;}
		.bot div{margin-top: 10px;}
		#login:hover{background-color: #6AA2E0;}
		#login{width: 100%;height:40px ;background-color: #5A98DE;border: none;color: white;font-size: 20px;border-radius:2%;}
		.name_div{border:1px solid #4892E7 ;height:40px ;text-align: center;margin-bottom: 15px;border-radius:2%;}
		.name_div input{font-size:15px;border: none;height: 50%;margin-top: 10px;width: 90%;}
	</style>
	<body>
		<header class="head">
			<div class="head_bt">
				<a href="javascript:">基本版</a> | <a href="javascript:">English</a> | <a href="javascript:">手机版</a> | <a href="javascript:">企业邮箱</a>
			</div>
		</header>
		<div class="body_div">
			<div class="body_div_left">
				<div>
				<p class="title_p">QQ邮箱，常联系！</p>
				<ul>
					<li>2500年前，人们飞鸽传书</li>
					<li>182年前，莫尔斯发明了电报</li>
					<li>49年前，第一封电子邮件发出</li>
					<li>今天，QQ邮箱联系你、我、他</li>
				</ul>
				</div>
			</div>
			<div class="body_div_right">
				<div class="body_div_right_div">
					<div class="login_fs">
						
						<div>
							<a href="javascript:">注册</a>
						</div>
					</div>
					<form action="qq?type=dozc" method="post">
					<div style="width: 80%;margin: 0 auto;padding-top: 40px;height: 65%;">
						<div class="user_div"><input name="email" placeholder="邮箱"></div>
						<div class="name_div"><input name="nickName" placeholder="名称"></div>
						<div class="pwd_div"><input class="pwd1" type="password" placeholder="密码"></div>
						<div class="pwd_div"><input name="password" class="pwd2" type="password" placeholder="再次输入密码"></div>
						<input id="login" type="button" value="注册" />
					</div>
					</form>
					<div class="body_div_right_div_bot">
						 <a href="qq">登录</a>| <a href="javascript:">意见反馈</a>
					</div>
				</div>
			</div>
		</div>
		<div class="bot">
			<div>
			<a href="javascript:">关于腾讯</a> | 
			<a href="javascript:">服务条款</a> | 
			<a href="javascript:">客服中心</a> | 
			<a href="javascript:">联系我们</a> | 
			<a href="javascript:">帮助中心</a> | 
				©1998 - 2018 Tencent Inc. All Rights Reserved.
			</div>
		</div>
	</body>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#login").click(function() {
				if($(".pwd1").val()!=$(".pwd2").val()){
					alert("两次密码不一致");
					return false;
				}
				$.get("qq?type=yzemail",{email:$("[name=email]").val()},function(data){
				if(data=="有"){
					alert("此邮箱已被注册");
					return false;
				}
					$("form").submit();
				})
				
			})
		})
	</script>
</html>