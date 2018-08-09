<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/remstyle.js" ></script>
	</head>
	<style>
		body{
			background-image: url(img/20150308190319_ddBNF.jpeg);
			background-size: cover;
			color: white;
		}
		:focus{outline: 0;}
		#head-div{
			position: fixed;
			width: 100%;
			top: 0;
			display: flex;
			justify-content: space-between;
			background:-webkit-linear-gradient(left,rgba(73, 100, 254, 0.5), rgba(49, 190, 254, 0.5));
			line-height: 5rem;
			font-size: 2rem;
		}   
		#bottom-div{
			position: fixed;
			width: 100%;
			bottom: 0;
			display: flex;
			justify-content: space-between;
			background-color: rgba(0, 0, 0, 0.5);
			font-size: 2.5rem;
		}
		#bottom-div>button{
			background-color: rgba(0,0,0,0);
			border: none;
			padding: 0 2rem;
			margin-top: 0.5rem;
		}
		#bottom-div>button>p{font-size: 0.5rem;}
		#head-div #dropdownMenu1{background-color: rgba(0,0,0,0);border: none;color: white;outline: none;}
		#head-div #dropdownMenu1>.glyphicon{font-size: 2.5rem;}
		.head-img>img{
			width: 4rem;
			height: 4rem;
			border-radius: 50%;
		}
		.head-img{margin: 0.2rem 0.2rem 0.2rem 0.4rem;}
		/*#seek-div>button{height: 3rem;width:100%;background-color: rgba(0,0,0,0);border: 1px solid #eee;border-radius: 2px;}
		#seek-div{margin-bottom: 0.5rem;}*/
		/*.news-list li{
			height: 6rem;
			display: flex;
			position: initial;
			padding-left: 0;
			background-color: rgba(0,0,0,0.1);
			border-bottom: 1px solid #eee;
			border-top: none;
		}*/
		/*.usernameAndShuoShuo{width: 100%;line-height: 2rem;font-size: 1.3rem;}
		.usernameAndShuoShuo b{font-size:1.5rem ;}*/
		/*.badge-danger{background-color: red;border: none;}*/
		button.selected{color: #29AEE1;}
		#web{height: 55.2rem;}
		.imgbut{display:none;}
		.ycimgdiv{
			margin-left: 4rem;
			margin-bottom: 2rem;
		}
		.ycimgdiv img{
			width: 5rem;
			height: 5rem;
		}
		.schuandiv{
			margin-left: 4rem;
			margin-bottom: 2rem;
		}
		.mmtt{color: black;}
	</style>
	<input type="hidden" name="indexType" />
	<body>
		<div id="head-div">
			<div class="head-img">
				<img class="toximg" src="img/20150308190319_ddBNF.jpeg"/>
			</div>
			<span id="">
				消息
			</span>
			<div class="dropdown">
			  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			    <span class="glyphicon glyphicon-menu-hamburger"></span>
			  </button>
			  <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu1">
			    <li><a href="javascript:"><span class="glyphicon glyphicon-home"></span>创建群聊</a></li>
			    <li><a href="tosearchFriend"><span class="glyphicon glyphicon-plus"></span>加好友</a></li>
			    <li><a href="javascript:"><span class="glyphicon glyphicon-qrcode"></span>扫一扫</a></li>
			    <li><a href="javascript:"><span class="glyphicon glyphicon-paste"></span>面对面快传</a></li>
			    <li><a href="javascript:"><span class="glyphicon glyphicon-usd"></span>收付款</a></li>
			  </ul>
			</div>
		</div>
		<button type="button" class="btn btn-primary btn-lg imgbut" data-toggle="modal" data-target="#myModal">
			  Launch demo modal
			</button>
			
			<!-- Modal -->
			<div class="modal fade mmtt" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">请选择您的头像</h4>
			      </div>
			      <div class="modal-body">
			        <div class="schuandiv">
					 <input style="display: none;" type="file" multiple="multiple" name="file" id="file1"/>
							<span onclick="fun()" style="cursor: pointer;border:1px solid #ddd;font-size: 40px;display: inline-block;width: 50px;height: 50px;text-align: center;line-height: 50px; ">+</span>
					    </div>
					    <div class="ycimgdiv">
					    	
					    </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-primary sctox">确定</button>
			        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			      </div>
			    </div>
			  </div>
			</div>
		<div id="body-div">
			<iframe id="web" frameborder="0" width="100%" src="toNewsList">
			</iframe>
		</div>
		<div id="bottom-div" class="container-fluid">
			<button data-src="toNewsList" class="ction selected"><span class="glyphicon glyphicon-comment"></span><p>消息</p></button>
			<button data-src="toFriendsList" class="ction"><span class="glyphicon glyphicon-user"></span><p>联系人</p></button>
			<button data-src="NewsList.html" class="ction"><span class="glyphicon glyphicon-eye-open"></span><p>看点</p></button>
			<button  class="ction"><a href="todotai" style="color: white;"><span class="glyphicon glyphicon-asterisk"></span></a><p>动态</p></button>
		</div>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script>
		$(".ction").on("touchend",function(){
			$("[name=indexType]").val($(this).data("src")).change();
			if($(this).is(".selected"))
				return false;
			$(this).find("span").animate({"font-size":"1.8rem"},1,function(){
				$("button").has($(this)).addClass("selected");
				$(this).animate({"font-size":"2.5rem"},150)
			})
			$(this).siblings().removeClass("selected");
		})
		
		$("[name=indexType]").on("change",function(){
			$("#web").attr("src",$(this).val());
		})
		$(function() {
			$(".toximg").click(function () {
				$(".imgbut").click();
			})
		//	sctox();
		})
		function fun(){
    		//触发文件域的click时间，相当于你点了它
    		document.querySelector('#file1').click();
    	}
    	
        document.querySelector('#file1').onchange = function () {
            var fileReader = new FileReader();
            fileReader.onload = function (e) {
                if (fileReader.readyState == FileReader.DONE) {
                    var img = document.createElement('img');
                    img.src = this.result;
                    document.querySelector('.ycimgdiv').appendChild(img); //示例只是简单插入body
                }
            }
            //一次加载多个文件
            var i = 0, src = this.files;
            fileReader.readAsDataURL(src[i]);
            fileReader.onloadend = function () {
                i++;
                if (i < src.length) fileReader.readAsDataURL(src[i]);
            }
        }
    	var filelist = new Array();
		var file=new FormData();
        function filter(e){
		    var files = e.target.files;   // 获取本地文件File对象集合
		    for (var i =0; i <files.length;i++){
		    	filelist.push(files[i]);  //添加至文件列表
		        addImage(files[i],filelist.length-1);
		    }
		    newformdata();
	}
        
        function sctox() {//上传头像按钮
			$(".sctox").click(function () {
				 $.ajax({
				      type: "post",
				      url: "qqajax/uploadtox",
				      dataType: "json",
				      data: file,
				      /*
				       *必须false才会自动加上正确的Content-Type  
				       */
				      contentType : false, 
				      /**  
				       * 必须false才会避开jQuery对 formdata 的默认处理  
				       * XMLHttpRequest会对 formdata 进行正确的处理  
				       */
				      processData : false,
				      success: function(data){//从后端返回数据进行处理
				       location="toindex";
				      },
				      error: function(err) {//提交出错
				        $("#msg").html(JSON.stringify(err));//打出响应信息
				        alert("服务器无响应");
				      }
				 });
			})
		}
        
        function newformdata(){
			file=new FormData();
			$.each(filelist,function(){
				if(this!=null)
		    	file.append("file",this);
		    })
		}
	</script>
</html>