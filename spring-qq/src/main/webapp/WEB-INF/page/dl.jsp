<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>Insert title here</title>
</head>
<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
<script type="text/javascript" src="js/remstyle.js" ></script>
	<style>
		*{ 
			margin: 0px;
		}
		body{
			background-image: url(img/w10.png);
		}
		.Tex{
			background:transparent;
			border:none;
			outline: none;
			color: white;
			/*border-bottom: 1px solid darkgray;
			width: 8rem;
			height: 4rem;
			font-size: 4rem;*/
		}
		.ZhTex{
			margin: 2rem;
			color: white;
			
		}
		.MmTex{
			margin: 2rem;
			color: white;
		}
		.ButDl{
			background-color: rgba(000,111,166,0.6);
			outline: none;
			border:none;
			margin: 10%;
			width: 80%;
			height: 3rem;
			color: white;
		}
		
		.divButDl{
			
		}
		.logoimg{
			margin: 2rem;
		}
		.ToxDiv{
			margin: 0rem;
			text-align: center;
			height: 15rem;
			width: 100%;
		}
		.Tox{
			max-width: 100%;
			max-height: 100%;
			border-radius:50%;
			width: 13rem;
			height: 13rem;
				}
	</style>
	<body>
		<div class="logoimg">
			<img src="" />
			<span style="font-size: 3rem;color: white;">QQ</span>
		</div>
		<div class="ToxDiv">
			<img class="Tox" src="img/w10.png" />
		</div>
		<form action="dodl" method="post">
		<div class="Nr">
			<div class="ZhTex">
				<input class="Tex" name="zh" id="Zh" type="text" value="70560342"/>
				<hr style="margin-top: 0.5rem;" />
			</div>
			<div class="MmTex">
				<input class="Tex" name="mm" id="Mm" type="text" value="123"/>
				<hr style="margin-top: 0.5rem;" />
			</div>
			<div divButDl>
				<button type="submit" class="ButDl" />登陆</button>
				<a style="margin-left: 3rem;color: #6495ED;">新用户注册</a>
			</div>
		</div>
			</form>

		<script type="text/javascript" src="js/zepto.js" ></script>
		<script>
			document.querySelector(".ButDl").addEventListener("touchstart",function(){//触摸事件
				
			});
			
		</script>
	</body>
</html>