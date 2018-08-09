<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<script src="js/jquery-1.12.4.js" ></script>
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
			.trr td{border-bottom: 1px solid black;}
		</style>
		
		
	</head>
	<body>
		<section>
			<div id="menu-list">
				<span>以删除</span>
			</div>
			<div id="blue-box">


				
				<input type="button" value="彻底删除" name="cdsc"/>
				<input type="button" value="转发" name="zf"/>
				<input type="button" value="全部标为已读" name="yd"/>
				标记为:<select>
					<option></option>
				</select>
				移动到:<select>
					<option>1</option>
				</select>
				<a class="fenyea">
				
				</a>
			</div>
	
			<div id="email-con">
			<form>
			<div style="background-color: #f2f4f6; display: flex; border-bottom: 1px solid gray; margin-top: -15px;">
					<div style="margin-left: 20px; padding-top: 3px;"><input type="checkbox"></div>
					<div style="margin-left:20px;">图</div>
					<div style="margin-left:20px;">发件人</div>
					<div style="margin-left:200px;">主题</div>
					<div style="margin-left:800px;">时间</div>
				</div>	
			</form>
			</div>
			<script>
				$(function () {
					query(1);
				});
				function query(dqy) {
				
					$.getJSON("qq?type=queryysc",{dqy:dqy},function(data){
						$("#email-con .gg").remove();
						$(".fenyea a").remove();
						$.each(data.mylis,function(){
							$("#email-con").append('<div class="gg" style="background-color: #f2f4f6; display: flex; border-bottom: 1px solid gray; ">\
									<div style="margin-left: 20px; padding-top: 3px;"><input type="checkbox"></div>\
									<div style="margin-left:20px;">图</div>\
									<div style="margin-left:20px;">'+this.senEmail+'</div>\
									<div class="aaa" style="margin-left:200px;">'+this.title+'</div>\
									<div style="margin-left:800px;">'+this.createTime+' </div>\
									<a class="relId" style="display: none;">'+this.relId+'</a>\
								</div>');
						});
						$(".fenyea").append('<a style="margin-left: 700px;">'+data.dqy+'/'+data.pagesize+'</a><a  aa='+data.shangpage +'>上一页</a> <a aa='+data.xiayiye+'>下一页</a>');
						$(".fenyea a").click(function () {
							var dqy=$(this).attr("aa");
							query(dqy);
						
						})
							$("[name=sc]").click(function () {
							$.each($(".gg"),function(){
								if($(this).find("[type=checkbox]").get(0).checked==true){
									sc($(this).find(".relId").html());
								}
								
							});
						})
						$("[name=cdsc]").click(function () {
							$.each($(".gg"),function(){
								if($(this).find("[type=checkbox]").get(0).checked==true){
									cdsc($(this).find(".relId").html());
								}
								
							});
						}) 
						$(".gg .aaa").click(function () {
							window.location.href="qq?type=tofolder_cont&relId="+$(this).siblings(".relId").html();
						})
					});
				}
				function sc(relId) {
					alert(relId);
					$.post("qq?type=dofjsc",{relId:relId},function(){
						query(1);
					});
				}
				function cdsc(relId) {
					$.post("qq?type=dofjcdsc",{relId:relId},function(){
						query(1);
					});
				}
				
			</script>
		<div id="blue-box">
		
				<input type="button" value="彻底删除" name="cdsc"/>
				<input type="button" value="转发" name="zf"/>
				<input type="button" value="全部标为已读" name="yd"/>
				<select>
					<option>1</option>
				</select>
				<select>
					<option>1</option>
				</select>
			</div>
		</section>
		
		
	</body>
	

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
	</script>
</html>