<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<base href="/qqemail/">
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
		.body_div_right_div{border: 1px solid #A0B1C4;width: 334px;height: 387px;margin-top: 70px;margin-left: 50px;border-radius:1%;}
		.login_fs{display: flex;border-bottom: 1px solid #C0CDD9;background-color: #F9FBFE;}
		.login_fs div:first-child{flex-grow: 1;padding: 15px 30px 15px 50px;}
		.login_fs div:first-child a{color: #A2A2A3;}
		.login_fs div:last-child a{color: black;}
		.login_fs div:last-child{flex-grow: 1;padding: 15px 30px 15px 30px;}
		.user_div{border:1px solid #96A5B4 ;height:40px ;text-align: center;margin-bottom: 15px;border-radius:2%;}
		.user_div input{font-size:15px;border: none;height: 50%;margin-top: 10px;width: 90%;}
		.pwd_div{border:1px solid #4892E7 ;height:40px ;text-align: center;margin-bottom: 30px;border-radius:2%;}
		.pwd_div input{font-size:20px;border: none;height: 50%;margin-top: 10px;width: 90%;}
		.body_div_right_div_bot a{font-size: 12px;color: #225592;}
		.body_div_right_div_bot{text-align: right;width: 90%;color: #D5C5BF;}
		.bot{background-color: #EFF4FA;border-top: 1px solid #D6DFEA;height: 36px;font-size: 12px;text-align: center;color: #868686;margin-top: 76px;}
		.bot a{color: #1D5494;}
		.bot div{margin-top: 10px;}
		#login:hover{background-color: #6AA2E0;}
		#login{width: 100%;height:40px ;background-color: #5A98DE;border: none;color: white;font-size: 20px;border-radius:2%;}
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
							<a href="javascript:">快速登录</a>
						</div>
						<div>
							<a href="javascript:">账号密码登录</a>
						</div>
					</div>
					<div style="width: 80%;margin: 0 auto;padding-top: 40px;height: 65%;">
						<form action="qq?type=dologin" method="post">
						<div class="user_div"><input name="email"  value="1"></div>
						<div class="pwd_div"><input name="password" type="password" value="1"></div>
						<input id="login" type="submit" value="登录" />
						</form>
					</div>
					<div class="body_div_right_div_bot">
						<a href="javascript:">忘了密码？</a>| <a href="qq?type=tozc">注册新帐号</a>| <a href="javascript:">意见反馈</a>
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
</html>