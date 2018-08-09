<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

	<style>
			*{padding: 0;margin: 0;}
			font{font-family: "微软雅黑";}
			a{text-decoration: none;color: #1e5494;font-size: 12px;}
			a:hover{text-decoration: underline;}
			ul{list-style: none;}
			li{font-size: 13px;cursor:pointer;}
			
			header{height: 64px;background: url(img/background.png) 1150px no-repeat ;background-size: 30%;}
			#logo{float: left;margin: 13px 0 0 15px;}
			#user-box{height: 40px;float: left;margin: 12px 0 0 20px;font-size: 12px;color: #96A5B4;}
			#user-box p{font-size: 12px;font-weight: 600;color: black;}
			#user-box p span{font-size: 12px;font-weight: 400;}
			#user-box a{margin-top: 2px;display: inline-block;}
			#other-page {float: right;margin: 2px 10px 0 0;}
			#other-page p{color: #96A5B4;font-size: 12px;text-align: right;padding-top: 5px;}
			#other-page input{margin-top: 16px;width: 280px;height: 18px;padding-left: 3px;}
			
			#center{background-color: #89b5e9;width: 99%;height: 590px;border-radius: 5px 0 0 5px;margin-left: 0.5%;padding: 0.5% 0 0.5% 0.5%;overflow: hidden;}
			
			#nav {width: 10%;height: 590px;float: left;}
			#nav #mail-box{height: 90px;background: white url(img/nav_bg1e9c5d.gif) -10px 0px;border-radius: 5px;}
			#nav #mail-box ul{padding-top: 2px;}
			#nav #mail-box li a{line-height: 28px;padding-left: 25px;font-size: 14px;font-weight: 600;color: #1E5494;}
			#nav #mail-menu{height: 493px;border-radius: 5px;background-color: white;margin-top: 7px;}
			#nav #mail-menu ul{padding-top: 8px;}
			#nav #mail-menu li{line-height: 25px;padding-left: 15px;width: 128px;margin: 0 auto;color: #1E5494;}
			#nav #mail-menu li:hover{background: #e0ecf9;}
			#nav #mail-menu #fold-box {width: auto;padding: 15px 5px;display: none;}
			
			#con-frame {width: 89.5%;height: 590px;background: white;float: left;margin-left: 0.5%;border-radius: 5px 0 0 5px;}
			#con-frame iframe{width: 100%;height: 590px; border: 0;border-radius: 5px 0 0 5px;}
			
		</style>
	</head>
	<body>
		<header>
			<div id="logo">
				<a href="qq?type=tosendindex"><img src="img/qqmail_logo_default_35h206ff1.png" /></a>
			</div>
			<div id="user-box">
				<p>${user.nickName }<span> &lsaquo; ${user.email } &rsaquo;</span></p>
				<a>邮箱首页</a> |
				<a>设置</a> -
				<a>换肤</a> 
			</div>
			<div id="other-page">
				<p>
					<a>反馈意见</a> |
					<a>帮助中心</a> |
					<a href="qq?type=tologin">退出</a>
				</p>
				<input type="text" placeholder="邮件搜索...">
			</div>
			
			
		</header>
		<div id="center">
			<div id="nav">
				<div id="mail-box">
					<ul>
						<li><a href="qq?type=tosetEmail">写信</a></li>
						<li><a href="qq?type=tosendtsj">收信</a></li>
						<li><a>通讯录</a></li>
					</ul>
				</div>
				<div id="mail-menu">
					<ul>
						<li style="font-weight: 600;"><a href="qq?type=tosendtsj">收件箱</a></li>
						<li>星级邮件</li>
						<li style="font-weight: 600;">群邮件</li>
						<li><a href="qq?type=tosendcaogao">草稿箱</a></li>
						<li><a href="qq?type=tosendtfj">已发送</a></li>
						<li><a href="qq?type=tosendysc">已删除</a></li>
						<li style="font-weight: 600;">垃圾箱</li>
						<li style="font-weight: 600;">QQ邮件订阅</li>
						<hr style="width: 90%;margin: 10px auto;color: #D6DFDA;"/>
						<li class="fold-box-btn">邮件夹</li>
					</ul>
					<div id="fold-box">
						<ul>
							<li>自定义邮件夹1</li>
							<li>自定义邮件夹1</li>
							<li>自定义邮件夹1</li>
							<li>自定义邮件夹1</li>
							<li>自定义邮件夹1</li>
							<li>自定义邮件夹1</li>
						</ul>
					</div>
				</div>
			</div>
			<div id="con-frame">
				<iframe src="qq?type=tosendEmail" scrolling="no">
					
				</iframe>
			</div>
		</div>
	</body>
	
	<script src="js/jquery-1.12.4.js"></script>
	<script>
		$(function(){
			fold_button();
		})
		function fold_button(){
			$(".fold-box-btn").on("click",function(){
				$("#fold-box").slideToggle(500);
			})
		}
	</script>
</html>