<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<base href="/qqemail/">
		<style>
			* {padding: 0;margin: 0;}
			section{margin:8px;}
			a{font-size: 12px;color: #1E5494 ;}
			p{font-size: 13px;}
			
			#menu-list span{display: inline-block;background: #c1d9f3;width: 110px;line-height: 30px;
			text-align: center;border-radius: 4px 4px 0 0;color: #093665;font-weight: 600;font-size: 14px;}
			
			#blue-box {background: #c1d9f3;height: 35px;line-height:33px;padding: 0 8px;}
			#blue-box input{padding: 0 10px;outline: 1px solid;-moz-outline-radius: 3px;outline-color: #96A5B4;}
			
			#email-con {padding: 10px 0;background: #eff5fb;}
			#email-con p{line-height: 28px;}
			#email-con p span:first-of-type{display: inline-block;width: 60px;padding-right: 7px;text-align: right;font-size: 12px;color: #1E5494;}
			#email-con p input{width: 90%;padding: 2px 3px;}
			#email-con p textarea{width: 90%;height: 290px;resize: none;padding: 4px;}
			
			#copy-box,#secret-box {display: none;}
		</style>
		
	<body>
		<section>
			<div id="blue-box">
				<input type="button" value="删除" name="delete"/>
				<input type="button" value="彻底删除" name="Zdelete"/>
				<input type="button" value="标记为" name="biaoji"/>
				<input type="button" value="移动到" name="yidong"/>
			</div>
			<div id="email-con">
				<h3>${email.title }</h3>
				<p>发件人：${email.senEmail }</p>    	
				<p>时   间：${email.createTime }</p> 
				<p>收件人：${email.normalEmail }</p>
				<p style="display: ${email.copyEmail==''?'none':'' }">抄   送：${email.copyEmail }</p>
				<div id="email-con-text" style="background-color: white;border-top: 1px solid #C1D9F3;">
					${email.recContent }
					<div id="fujian_div" style="height: 100px;width:300px;">
					</div>
				</div>
			</div>
			<div id="blue-box">
				<input type="button" value="删除" name="delete"/>
				<input type="button" value="彻底删除" name="Zdelete"/>
				<input type="button" value="标记为" name="biaoji"/>
				<input type="button" value="移动到" name="yidong"/>
			</div>
		</section>
		
		
	</body>
</html>