<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
	<script type="text/javascript" src="js/remstyle.js" ></script>
	
</head>  
	<style>
		*{
			margin: 0px;
		}
		.backDiv{
			margin: 2rem;
			margin-bottom: 0rem;
			color: darkgrey;
		}
		span{
			color: darkgrey;
		}
		.BtDiv{
			margin-top: 1rem;
			margin-left: 3rem; 
		}
		.blue{
			color: deepskyblue;
		}
		.NrkDiv{
			margin-top: 2rem;
			margin-left: 0.5rem;
		}
		.Dhtex{
			margin-left: 1rem;
			border:none;
			outline: none;
			border-bottom: 1px solid darkgray;
		}

		.ButHq{
			background-color: rgba(000,111,166,0.6);
			outline: none;
			border:none;
			margin: 10%;
			width: 80%;
			height: 3rem;
			color: white;
		}
		.YzmDiv{
			margin: 2rem;
			margin-top: -0.5rem;

		}
		.YzmDiv span{
			font-size: 1rem;
		}
		.Yzm{
			margin-left: 1rem;
		}
		.Cxfs{
			background-color: rgba(000,111,166,0.6);
			outline: none;
			border:none;
		}
		.ZcBut{
			background-color: rgba(000,111,166,0.6);
			outline: none;
			border:none;
			margin-top: 1rem;
			width: 100%;
		}
		.schuandiv{
			margin-left: 4rem;
			margin-bottom: 2rem;
		}
		.nicdiv{
			margin-left: 4rem;
			margin-bottom: 2rem;
		}
		.ycimgdiv{
			margin-left: 4rem;
			margin-bottom: 2rem;
		}
		.ycimgdiv img{
			width: 5rem;
			height: 5rem;
		}
		.mimacdiv{
		margin-left: 4rem;
			margin-bottom: 2rem;
		}
	</style>
	<body>
		<div class="backDiv">
			<a>返回</a>
		</div>
		<div class="BtDiv">
			<span style="font-size: 3rem;color: black;">输入手机号</span><br />
			<span>注册代表阅读并同意</span><span class="blue">使用条框</span><span>和</span><span class="blue">隐私政策</span>
			<div class="NrkDiv">
				<span style="color: black;">+86</span><input class="Dhtex" type="text" />
			</div>
		</div>
		<div>
				<button class="ButHq" />获取</button>
		</div>
		
		<div>

		    <div class="nicdiv">
		    	<span id="nicspan">
		      	请输入您的昵称:
		      </span>
		      <input name="nicinput" />
		    </div>
		   
		   	<div class="mimacdiv">
		    	<span id="mimaspan">
		      	请输入您的密码:
		      </span>
		      <input name="mimainput" />
		    </div>

			
		</div>
		<div class="YzmDiv">
			<span style="font-size: 2rem;color: black;">输入短信验证码</span><br />
			<span>我们以给手机号码：</span><span style="color: chocolate;">+86</span>&nbsp;<span style="color: chocolate;">15073317005</span>&nbsp;<span>发送了一个短信验证码</span>
			<br /><br />
			<input type="text" class="Yzm" /><button class="Cxfs">重新发送</button><br />
			<button class="ZcBut">注册</button>
		</div>
	</body>
	
	 <script>
    	$(function(){
    		$(".ZcBut").click(function(){
    			
    			zcajax($("[name=nicinput]").val(),$("[name=mimainput]").val());
    		})
    	})
    	function zcajax(nickname,password){
    		
    		$.post("qqajax/dozc",{nickname:nickname,password:password},function(data){
    				alert("请您记住您的QQ号:"+data);
    				location="todl";
    		})
    	}
    	

    </script>
</html>