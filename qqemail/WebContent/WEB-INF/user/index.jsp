<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style type="text/css">
		.base_div{display: flex;}
		.left_head ul{list-style: none;width: 841px;}
		.xzai{display: flex;}
		.body_tuijian{background-color: #E2E5E4;border-bottom: 1px solid #969B99;}
		.body_img{border-bottom: 1px solid #969B99;}
		.left_body{border: 1px solid #969B99;height: 230px;border-radius: 3px;}
		.tishi{background-color: #CFD4D1;border-radius: 3px;}
		.tishi span{font-size: 13px;color: #818281;}
		.right_div{width: 300px;line-height: 23px;}
		.right_div>p{margin: 0;font-size: 13px;}
		.tishi h4{margin: 0;}
		.left_div{margin-right: 10px;}
		.bot_div{font-size: 13px;}
	</style>
	<body>
		<div class="base_div">
			<div class="left_div">
				<div class="left_head">
					<h3>中午好，${user.nickName }。</h3>
					<ul>
						<li>邮件：<strong>${wd }</strong> 封未读邮件</li>
						<li><h4 style="margin: 0;">收件箱(${sj })</h4></li>
					</ul>
				</div>
				<div class="left_body">
					<div class="body_tuijian">邮箱推荐 </div>
					<div class="body_img"><a href="javascript:"><img src="img/20160218_mailapp01.png"/></a></div>
					<div class="xzai">
						<ul>
							<li>iPhone版</li>
							<li>iPad版</li>
							<li>Android版</li>
						</ul>
						<ul>
							<li>明信片 - 贺卡</li>
							<li>记事本 - 日历</li>
							<li>文件中转站</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="right_div">
				<p>长沙</p>
				<p>今：16℃～27℃   明：19℃～28℃</p>
				<div class="tishi">
					<h4>推荐使用QQ邮箱英文帐号</h4>
					<span>QQ邮箱英文帐号，不仅保护QQ号码安全，更适合用于发送正式邮件。点击前往设置</span>
				</div>
				<div><img src="img/sr.PNG"/></div>
			</div>
		</div>
		<div class="bot_div">
			<p>2017年8月31日更新 | 暖灯行动 | 企业邮箱 | 开放平台 | 体验室 | 邮箱助手 | 自助查询 | 团队博客 | 加入我们</p>
			<p style="color: #818281;">标准版 - 基本版 | © 1998 - 2018 Tencent Inc. All Rights Reserved</p>
		</div>
	</body>
</html>