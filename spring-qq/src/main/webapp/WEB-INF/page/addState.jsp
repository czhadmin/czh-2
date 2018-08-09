<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-3.2.1.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		<script type="text/javascript" src="js/remstyle.js" ></script>
	</head>
	<style type="text/css">
		body{
			font-size: 1.8rem;
			background-color: #F4F5F8;
		}
		body>*{
			background-color: white;
		}
		:focus{outline: 0;}
		.head-div{
			display: flex;
			justify-content: space-between;
			padding: 0.7rem;
			border-bottom: 1px solid #eee;
		}
		.head-div>span{
			width: 4rem;
			text-align: center;
			line-height: 2.5rem;
		}
		.head-div>.publish{
			border: none;
			background-color: #F4F5F8;
			color: #AEAEAE;
		}
		
		[name='text']{
			width: 100%;
			height: 8rem;
			border: none;
			resize:none;
			
		}
		.fileImg-list{
			font-size: 0;
			display: flex;
			flex-wrap: wrap;
			
		}
		.fileImg-list img,.fileImg-list>button{
			width: 9.4rem;
			height: 9.4rem;
			margin: 2px;
			vertical-align:middle;
		}
		.fileImg-btn{
			border: none;
			background-color: #F4F5F8;
			color: #7C7D7E;
			font-size: 1.4rem;
		}
		.fileImg-btn>span{
			color: #AEAEAE;
		}
		.body-div{
			padding: 1rem;
		}
		.glyphicon-camera{
			font-size: 4rem;
		}
		.image-container{
			position: fixed;
			top:0;
			bottom: 0;
			left:0;
			right: 0;
			background: rgba(0,0,0,0.8);
			display: flex;
			align-items: center;/*这个很重要，没有它，图片将拉伸，不会在屏幕垂直居中显示*/
		}
		.image-container>img{
			min-width: 100%;/*保证img能基于width满屏显示，高度自动*/
			max-height: 100%;
			border: 5px solid rgba(0,0,0,0);
		}
	</style>
	<input  name="indexType" />
<body>
		<div class="head-div">
			<span><b>取消</b></span>
			<span><b>说说</b></span>
			<button class="publish">发表</button>
		</div>
		<div class="body-div">
			<textarea name="text" placeholder="分享新鲜事..."></textarea>
			<div>
				<div class="fileImg-list">
					<!--<div class="imgo">
						
					</div>-->
					<button class="fileImg-btn">
						<span class="glyphicon glyphicon-camera"></span>
						<p>照片/视频</p>
					</button>
				</div>
				<input style="display: none;" type="file" multiple="multiple" name="file"/>
			</div>
		</div>
		<div class="image-container" id="image-container" style="display: none;">
		</div>
		<script type="text/javascript" src="js/jquery-1.12.4.js" ></script>
		<script type="text/javascript">
		$(function(){
			alert("${aaa}")
			$("[name=indexType]").val("${aaa}");
			$(".fileImg-list").on("tap","img",function(){
				var index=$(".image-container>img[data-index='"+$(this).data("index")+"']").index();
				image_count = $(".image-container>img").size();
				$(".image-container>img:first-of-type").css({
						marginLeft : -(index*$(".image-container").width())
						
				});
				current_image_index=index;
				$(".image-container").fadeIn(500);
			})
			
			$(".image-container").on("tap",function(e){
				$(this).fadeOut(500);
			})
			var current_image_index = 0;//当前显示第几张图片
//			获得图片的个数
			var image_count = $(".image-container>img").size();
			var x_start = 0;//每次点击的x初始坐标
			var margin_left = 0;
			//为图片容器添加touch事件
			$(".image-container").on("touchstart",function(){
				var touch = event.changedTouches[0];
				x_start = touch.pageX;//
				margin_left = parseInt($(".image-container>img:first-of-type").css("margin-left"));
			});
			$(".image-container").on("touchmove",function(){
				event.preventDefault();//阻止屏幕默认滑动事件
				var touch = event.changedTouches[0];
				var x_current = touch.clientX;
				//计算移动距离
				var len = Math.abs(x_current - x_start);
				
//				x_current < x_start：当前的x小于起始的x，表示向左
//				current_image_index < image_count -1:如果当前显示的图片的下标小于图片的总数-1，则可以向左滑动
				if(x_current < x_start && current_image_index < image_count -1 ){//向左
					$(".image-container>img:first-of-type").css({
						marginLeft : margin_left - len /*起始的位置-移动的距离*/
					});
				}else if(x_current > x_start && current_image_index > 0){ //向右
					$(".image-container>img:first-of-type").css({
						marginLeft : margin_left + len
					});
				}
			});
				
			$(".image-container").on("touchend",function(){
				var touch = event.changedTouches[0];
				var x_current = touch.clientX;
				//计算滑动的距离
				var len = x_current - x_start;
				
				//获得屏幕的宽度
				var w = $(window).width();
//				len < 0 :表示向左
//				current_image_index < image_count -1：当前不是显示最后一张图片，可以向左滑
				if(len < 0 &&  current_image_index < image_count -1){//向左
					//如果滑动距离大于窗口距离的1/4，则自动滚动到下一张图片
					if(Math.abs(len) > w/4){
//						current_image_index=0;滑动之后 left1=-100%;
//						current_image_index=1;滑动之后 left1=-200%;
//						根据上面的逻辑,计算left值
						var left = (-current_image_index - 1)*100+"%";
//						改变第一个img的marginLeft,后面的img会自动跟随移动
						$(".image-container>img:first-of-type").animate({
							marginLeft : left
						},200);
						current_image_index++;  //改变当前显示的图片
					}else{//不超过1/4，当前图片退回去
						var left = (-current_image_index)*100+"%";
//						改变第一个img的marginLeft,后面的img会自动跟随移动
						$(".image-container>img:first-of-type").animate({
							marginLeft : left
						},200);
					}
				}else if(current_image_index > 0 && len > 0 ){//向右
					//如果滑动距离大于1/4,则自动滑动到下一张图片
					if(Math.abs(len) > w/4){
//						current_image_index=1;滑动之后 left1=-0%;
//						current_image_index=2;滑动之后 left1=-100%;
						var left = -(current_image_index - 1)*100+"%";
//						改变第一个img的marginLeft,后面的img会自动跟随移动
						$(".image-container>img:first-of-type").animate({
							marginLeft : left
						},200);
						current_image_index--;//改变当前图片的下标
					}else{
						//滑动距离不足1/4，则自动退回去
						var left = -(current_image_index)*100+"%";
//						改变第一个img的marginLeft,后面的img会自动跟随移动
						$(".image-container>img:first-of-type").animate({
							marginLeft : left
						},200);
					}
				}
			});
		});
	</script>
	</body>
	<script type="text/javascript" src="js/zepto.js" ></script>
	<script type="text/javascript" src="js/fastclick.js" ></script>
	<script>
		$(".fileImg-btn").on("touchend",function(){
			$("[name=file]").trigger("click");
		});
		
		var filelist = new Array();
		var file=new FormData();
		$("[name=file]").bind('change',filter);
		
		// 将图片加载至浏览器中,并且显示出来
		function addImage(file,index){
		    // 创建 一个FileReader对象
		    var reader = new FileReader();
		    // 读取文件作为URL可访问地址
		    reader.readAsDataURL(file);
		
		    // 监控读取加载过程 
		    reader.onprogress =function(e){
			
			    //异步加载文件成功
			    reader.onload = function(e){
			       // this 对象为reader
			       // reader.result 表示图片地址
//			       reader.uploadBox.wrapInner('<img style="width:100%;height:100%; padding:.2rem;" src="'+reader.result+'" alt="'+file.name+'" />');
			    	var img=$('<img data-index="'+index+'" src="'+reader.result+'" alt="'+file.name+'" />');
			    	$(".fileImg-btn").before(img);
					$(".image-container").append(img.clone())
			    }
			
			}
		}
		
		function filter(e){
			    var files = e.target.files;   // 获取本地文件File对象集合
			    for (var i =0; i <files.length;i++){
			    	filelist.push(files[i]);  //添加至文件列表
			        addImage(files[i],filelist.length-1);
			    }
			    newformdata();
		}
		
		$(".fileImg-list").on("longTap","img",function(){
			var index=$(this).data("index");
			filelist[index]=null;
			$("img[data-index='"+index+"']").remove();
			newformdata();
		});
		
		$(".publish").on("touchend",function(){
			
			 $.ajax({
			      type: "post",
			      url: "qqajax/upload?aaa="+$("[name=indexType]").val(),
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
			       location="todotai";
			      },
			      error: function(err) {//提交出错
			        $("#msg").html(JSON.stringify(err));//打出响应信息
			        alert("服务器无响应");
			      }
			 });
			
		})
		
		function newformdata(){
			file=new FormData();
			$.each(filelist,function(){
				if(this!=null)
		    	file.append("file",this);
		    })
		    file.append("text",$("[name=text]").val())
		}
		
		</script>
</html>