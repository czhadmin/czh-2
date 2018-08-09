<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<style>
			* {padding: 0;margin: 0;}
			section{margin:8px;}
			a{font-size: 12px;color: #1E5494 ;}
			p{font-size: 13px;}
			
			#menu-list span{display: inline-block;background: #c1d9f3;width: 110px;line-height: 30px;
			text-align: center;border-radius: 4px 4px 0 0;color: #093665;font-weight: 600;font-size: 14px;}
			
			#blue-box {background: #c1d9f3;height: 35px;line-height:33px;padding: 0 8px;}
			#blue-box input{padding: 0 10px;outline: 1px solid;-moz-outline-radius: 3px;outline-color: #96A5B4;}
			
			#email-con {height: 455px;padding: 10px 0;background: #eff5fb;}
			#email-con p{line-height: 28px;}
			#email-con p span:first-of-type{display: inline-block;width: 60px;padding-right: 7px;text-align: right;font-size: 12px;color: #1E5494;}
			#email-con p input{width: 90%;padding: 2px 3px;}
			#email-con p textarea{width: 90%;height: 290px;resize: none;padding: 4px;}
			
			#copy-box,#secret-box {display: none;}
		</style>
		
		
	</head>
	<body>
		<section>
			<div id="menu-list">
				<span>普通邮件</span>
			</div>
			<div id="blue-box">
				<input type="button" value="发送" name="send"/>
				<input type="button" value="存草稿" name="draft"/>
				<input type="button" value="关闭" name="index"/>
			</div>
			<div id="email-con">
			<form class="youjian">
				<p><span>收件人</span><input type="text" name="normalMail"/></p>
				<div id="copy-box">
					<p><span>抄送</span><input type="text" name="copyEmail"/></p>
				</div>
				<div id="secret-box">
					<p><span>密送</span><input type="text" name="secretEmail"/></p>
				</div>
				<p><span></span><a id="copy-btn">添加抄送</a> - <a id="secret-btn">添加密送</a></p>
				<p style="margin-top: 10px;"><span>主题</span><input type="text" name="title"/></p>
				<p><span></span><a>添加附件</a></p>
				<p><span style="float: left;">正文</span><textarea name="recContent"></textarea></p>
				<p><span></span>发件人： <label style="font-weight: 600;">${user.nickName }</label> <label>&lt;${user.email }&gt;</label></p>
				<input  class="userid" type="hidden" value="${user.userId }">
			</form>
			
			</div>
			<div id="blue-box">
			<input class="RecFlag" type="checkbox">是否回执
				<input type="button" value="发送" name="send"/>
				<input type="button" value="存草稿" name="draft"/>
				<input type="button" value="关闭" name="index"/>
			</div>
		</section>
		
		
	</body>
	
	<script src="js/jquery-1.12.4.js" ></script>
	<script>
		$(function(){
			$("#copy-btn").on("click",function(){
				var state = $("#copy-box").css("display");
				
				if(state=="none"){
					$(this).text("删除抄送");
				}else{
					$(this).text("添加抄送");
				}
				$("#copy-box").slideToggle(100);
				textareaHeight();
			})
			
			$("#secret-btn").on("click",function(){
				var state = $("#secret-box").css("display");
				if(state=="none"){
					$(this).text("删除密送");
				}else{
					$(this).text("添加密送");
				}
				$("#secret-box").slideToggle(100);
				textareaHeight();
			})
			
			$("[name=send]").click(function () {
				var RecFlag;
				if(document.querySelector(".RecFlag").checked){
					RecFlag=1;
				}else{
					RecFlag=0;
				}
				addMailInfo(RecFlag);
			
				//收件人
				var normalMail=$("[name=normalMail]").val();
				//抄送人
				var copyEmail=$("[name=copyEmail]").val();
				//密送人
				var secretEmail=$("[name=secretEmail]").val();
				addMailAndUserRelation(normalMail,copyEmail,secretEmail,RecFlag);
			})
				
			$("[name=draft]").click(function () {
				var RecFlag;
				if(document.querySelector(".RecFlag").checked){
					RecFlag=1;
				}else{
					RecFlag=0;
				}
				addcaogao(RecFlag);
			})
		})
		
		function textareaHeight(){
			var height = parseInt($("textarea").css("height"));
			var copy_state = $("#copy-btn").text();
			var secret_state = $("#secret-btn").text();
			if(copy_state == "添加抄送" && secret_state=="添加密送"){
				$("textarea").css("height","290px");
			}else if(copy_state == "删除抄送" && secret_state=="删除密送"){
				$("textarea").css("height","230px");
			}else{
				$("textarea").css("height","260px");
			}
		}
		
		function addMailInfo(RecFlag) {//添加邮件
			$.get("qq?type=addMailInfo&"+$(".youjian").serialize(),{RecFlag:RecFlag},function(data){
			
			})
		}
		function addcaogao(RecFlag) {//添加草稿
			$.get("qq?type=addcaogao&"+$(".youjian").serialize(),{RecFlag:RecFlag},function(data){
					alert("发送成功");
			})
		}
		function addMailAndUserRelation(normalMail,copyEmail,secretEmail,RecFlag) {//添加邮件关系
			$.get("qq?type=addMailAndUserRelation",{normalMail:normalMail,copyEmail:copyEmail,secretEmail:secretEmail,RecFlag:RecFlag},function(data){
					alert("发送成功");
			})
		}
	</script>
</html>