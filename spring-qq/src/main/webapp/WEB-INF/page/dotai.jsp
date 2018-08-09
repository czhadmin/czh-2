<%@ page isELIgnored="false" language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<title>Insert title here</title>
</head>
	 <link href="css/bootstrap.min.css" rel="stylesheet">
	 <style>
	 	#fanhui{
	 	}
	 	.xfuto{
	 		display: flex;
	 		justify-content: space-between;
	 		padding-top: 1rem;
	 			position:fixed; left:0px; top:0px; width:100%;height: 6rem; z-index:9999;
	 	}
	 	.xfuto span{
	 		color: white;
	 	}
	 	.bj{
	 		background-color: black;
	 		width: 37.5rem;
	 		height: 25rem;
	 		background-image: url(img/kayn-the-shadow-reaper-1920x1200.jpg);
	 		background-size:40rem;
	 	}
	 	.huifuls{
	 		margin-right: 0.5rem;
	 		font-size: 2rem;
	 	}
	 	.addss{
	 		font-size: 2rem;
	 	}
	 .rr{
	 	padding-top: 11.5rem;
	 	padding-left: 2.5rem;
	 }
	 .tbb{
	 	color: white;
	 }
	 .liull{
	 	padding-left: 20rem;
	 }
	 .fg{
	 	border-left: 1px solid white;
	 	padding-left: 1rem;
	 	font-size: 1.3rem;
	 	font-family:"楷体";
	 }
	 .eys{
	 	padding-right: 1rem;
	 	font-size: 3rem;
	 }
	 .di{
	 	margin-top: 2rem;
	 }
	 .di a{
	 	font-family:"楷体";
	 	color: white;
	 	margin-left: 3rem;
	 }
	 .ssname{
	 	font-family:"楷体";
	 	font-size: 1.8rem;
	 }
	.ssnrto{
			display: flex;
	 		justify-content: space-between;
	}
	.czjt{
		margin-right: 1rem;
		margin-top: 1rem;
	}
	.sssj{
		font-size: 1rem;
	}
	.ssnrzidiv{
		margin-left: 1rem;
		margin-right: 1rem;
		width: 35rem;
		word-wrap:break-word;
	}
	.ssnrtudiv{
		margin-left: 1rem;
		width: 35rem;
		margin-top: 1rem;
	}
	.ssnrtudiv img{
		max-width:11rem;
　　		height:auto;
		height: 11rem;
		margin: 1px;
	}
	.ssgl{
		display: flex;
		justify-content: flex-end;
		margin-top: 2rem;
	}
	.ssgl>span{
		margin-left: 5rem;
	}
	.dianzdiv{
		margin-left: 1rem;
		
		
	}
		#bg{
		position: fixed;
		z-index:10000;
		top:0;  /*满屏效果*/
		bottom: 0;
		left: 0;
		right: 0;
		background:rgba(0,0,0,0.5);/*半透明*/
		display: none;/*隐藏*/
	}
	.caozuo{
		position: relative;
			
		padding: 50px 0;
		display: flex;
		flex-wrap: wrap;
		background: #FFFFFF;
		height: 200px;
		top:-240px;
		width:0;
		/*height: 0;*/
		/*justify-content: center;*/
	}
	.caozuo>div{
		width: 25%;
		height: 50px;
		text-align: center;
	}
	.plinput{
		height: 2rem;
	}
	.plinputdiv{
		margin-left: 1rem;
		margin-bottom: 1rem;
		margin-top: 1rem;
	}
	.fengediv{
		height: 1.5rem;
		width: 98%;
		background-color: gainsboro;
		margin-left: 0.3rem;
	}
		.ycimgdiv{
		position: fixed;
		z-index:10001;
		top:0;  /*满屏效果*/
		bottom: 0;
		left: 0;
		right: 0;
		background:rgba(0,0,0,1);/*半透明*/
		display: none;/*隐藏*/
	}
	.image-container{
		position: relative;
		background: #FFFFFF;
		height: 40rem;
		top:0;
		bottom: 0;
		left:0;
		right: 0;
		display: flex;
		align-items: center;/*这个很重要，没有它，图片将拉伸，不会在屏幕垂直居中显示*/
	}
	.image-container>img{
		min-width: 100%;/*保证img能基于width满屏显示，高度自动*/
		height: 100%;
		border: 1px solid black;
		
	}
	.ckpldiv{
		margin-left: 1rem;
	}
	.zhenpldiv{
		position: fixed;
		z-index:10005;
		top:0;  /*满屏效果*/
		bottom:0;
		left: 0;
		right: 0;
		display: none;/*隐藏*/
	}
	.xzhenpldiv{
		border-top: 1px solid black;
		position: relative;
		padding: 20px 0;
		display: flex;
		flex-wrap: wrap;
		background: #FFFFFF;
		height: 170px;
		margin-top: 50rem;
		width:0;
	}
	.zhenplinput{
		width: 25rem;
		margin-left: 1rem;
		margin-right: 0.5rem;
	}
	.huifuinput{
	width: 25rem;
	}
	.fbplbut{
		width: 10rem;
		height: 3.5rem;
	}
	[v-cloak] {
    display: none;
}
	 </style>
	<body>
		<header class="xfuto">
			<div style="margin-left: 0.5rem;">
				<span class="glyphicon glyphicon-menu-left" id="fanhui"></span>
				<span style="font-family:楷体"><a style="color: white;" href="toindex">动态</a></span>
			</div>
			<div class="">
				<span style="font-family:楷体;font-size: 1.6rem;">好友动态</span>
			</div>
			<div style="margin-right: 0.5rem;" class="ppdiv">
				<span class="glyphicon glyphicon-list-alt huifuls"></span>
				<span class="glyphicon glyphicon-plus-sign addss"></span>
			</div>
		</header>
		<div id="bg"><!--添加说说的隐藏div-->
		<div class="caozuo">
			<div class="fass">发说说</div>
			<div>说说</div>
			<div>说说</div>
			<div>说说</div>
			<div>说说</div>
			<div>说说</div>
			<div>说说</div>
			<div>说说</div>
		</div>
		
	</div>
	<div class="dadada">
	
		<div class="bj">
			<div class="rr">
				<img id="hytx" width="50rem" height="50rem" src="img/5054867_191937095316_2.jpg" class="img-circle">
			</div>
			<div class="liull">
				<table class="tbb">
					<tr>
						<td rowspan="2"><span class="glyphicon glyphicon-eye-open eys" ></span></td>
						<td class="fg">今日访客</td>
					</tr>
					<tr>
						<td class="fg">总浏览量</td>
					</tr>
				</table>
			</div>
			
			<div class="di">
				<p>
				<a>相册</a>
				<a>说说</a>
				<a>个性化</a>
				<a>小游戏</a>
				<a>小视频</a></p>
			</div>
		</div>
		<div class="xyidian" v-bind:data-kjlisindex="index"  v-bind:data-spaceId="kjlis.spaceid"  v-for="(kjlis,index) in hyff" v-cloak>
		<div class="ssnr" v-bind:data-dtlisindex="dtlisindex"  v-for="(dtlis,dtlisindex) in kjlis.dynamicStates">
			<div class="ssnrto"><!--描述：说说的头像,发布人,时间 -->
				<table class="ssnrtable">
					<tr>
						<td rowspan="2" style="padding: 1rem;"><img id="sstox" width="40rem" height="40rem" src="img/5054867_191937095316_2.jpg" class="img-circle"></td>
						<td class="ssname">{{dtlis.dtuserTab.nickname}}</td>
					</tr>
					<tr>
						<td class="sssj">{{dtlis.statetime}}</td>
					</tr>
				</table>
				<div class="dropdown"><!--下拉菜单 -->
					<span class="glyphicon glyphicon-menu-down czjt dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"></span>
					  <ul class="dropdown-menu pull-right" style="margin-top: -2rem;"  aria-labelledby="dropdownMenu1">
					    <li><a href="#">Action</a></li>
					    <li><a href="#">Another action</a></li>
					    <li><a href="#">Something else here</a></li>
					    <li role="separator" class="divider"></li>
					    <li><a href="#">Separated link</a></li>
					  </ul>
					</div>
			</div>
			<div class="ssnrzj"> <!--描述：说说的内容 -->
				<div class="ssnrzidiv"> <!--说说文字内容-->
					  <span>{{dtlis.statetext}}</span>
				</div>
                 <div class="ssnrtudiv" v-for="(imglis,imglisindex) in dtlis.imglis"><!--说说内容的图片-->
                 	<img v-bind:src="imglis.url"/>
                 	
                 	
                 </div>            
			</div>
			<div class="ssgl"><!--说说的爱心评论等功能-->
				<span class="glyphicon glyphicon-heart"></span>
				<span class="glyphicon glyphicon-comment"></span>
				<span class="glyphicon glyphicon-share" style="margin-right: 2.5rem;"></span>
			</div>
			<hr width="350rem"/>
			<div style="display: flex;margin-bottom: 1rem" >
			
			<div class="dadianzan" style="display: flex;">
				<span style="margin-left: 1rem" class="glyphicon glyphicon-thumbs-up" v-on:click="dianzan" :data-dtid="dtlis.stateid" ></span>
				<div class="dianzdiv" ><!--点赞-->
				<span v-bind:data-dzlisindex="dzlisindex" v-for="(dzlis,dzlisindex) in dtlis.praiseRecords">{{dzlis.dzuslist.nickname}} </span>
				</div>
			</div>
			</div>
			
			<div class="ckpldiv"  v-for="(pllis,pllisindex) in dtlis.commentlis" ><!--说说下的评论-->
			<p  data-toggle="modal" data-target="#myModal">
			<b>
			<span v-on:click="bdhuifu"  v-bind:data-plusiddd="pllis.plus.userid" v-bind:data-huifuname="pllis.plus.nickname" v-bind:data-plbbid="pllis.commentid">
			{{pllis.plus.nickname}}</span>
			:<span>{{pllis.commenttext}}</span>
			</b>
			</p>
			
			<p v-for="(huifulis,huifulisindex) in pllis.replies">
			<span>{{huifulis.replyuserTabs.nickname}}</span>回复<span>{{huifulis.replyuserTabspas.nickname}}:{{huifulis.replytext}}</span>
			</p>
			
			</div>

			<div class="input-group plinputdiv"><!--说说下的假的评论input-->
			  <input type="text" size="40" class="form-control plinput"   v-on:tap="plinput"  placeholder="评论" aria-describedby="basic-addon2">
			</div>
			
			<div class="zhenpldiv" ><!--说说下的真的评论input的div-->
				<div class="xzhenpldiv" v-on:tap="xzhenpldiv1">
					
					 <input type="text" size="40" class="form-control zhenplinput" placeholder="说点想说的1" aria-describedby="basic-addon2">
					<button type="button" class="btn btn-info fbplbut" :data-dtid="dtlis.stateid" v-on:click="addpl">发表</button><br/>
					<button class="btn btn-info" style="margin-left: 1rem" v-on:tap="zhenpldiv1">关闭</button>
				</div>
			</div>
			<div class="ycimgdiv"><!--点击说说的图片详细的隐藏div-->
			<div class="image-container" id="image-container">
				<img src="img/5054867_191937095316_2.jpg"/>
				<img src="img/kayn-the-shadow-reaper-1920x1200.jpg"/>
				<img src="img/V@3V(IIAC210}VRT$W)B}JF.jpg"/>
				<img src="img/捕获.PNG"/>
			</div>
		</div>

			<!-- 回复Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title huifushui" id="myModalLabel">回复</h4>
			      </div>
			      <div class="modal-body">
			         <input type="text" size="40" class="form-control huifuinput" placeholder="说点想说的" aria-describedby="basic-addon2">
			      </div>
			      <input class="ychuifuinput">
			      <input class="ychuifuinput2">
			      <div class="modal-footer">
			        <button type="button" class="btn btn-primary" v-on:click="addhuifu">回复</button>
			         <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			      </div>
			    </div>
			  </div>
			</div>
			
		</div>
		<div class="fengediv"></div><!--用来间隔每条说说的div-->

		</div>
		</div>
	</body>
	<script src="js/jquery-1.12.4.js"></script>
		<script src="js/bootstrap.js"></script>
	 <script type="text/javascript" src="js/zepto.js" ></script>
    <script src="js/remstyle.js" type="text/javascript" charset="utf-8"></script>
    	<script src="js/vue.js"></script>
    
    <script>
    	$(function(){
    		$(".caozuo").on("click","div",function(){
    		})
    		$(".czjt").click(function(){
    			if($(this).attr("class")=="glyphicon glyphicon-menu-down czjt dropdown-toggle"){
    				$(this).attr("class","glyphicon glyphicon-menu-up czjt dropdown-toggle");
    			}else{
    				$(this).attr("class","glyphicon glyphicon-menu-down czjt dropdown-toggle");
    			}
    		})
    			$(".addss").on("tap",function(){
				$("#bg").css({"display":"block"});
				$(".caozuo").animate({
					top:0,
					width:"100%"
				},200)
			});
			
			$("#bg").on("tap",function(){
				$(this).animate({
					"background":"rgba(0,0,0,0)"//变白
				},200,function(){
					$(this).css("display","none")//消失
					.css("background","rgba(0,0,0,0.5)");//变回原来的颜色 	
				});
				$(".caozuo",this).animate({
					top:"-240px"
				},200);
			});
			
			$(".caozuo").on("tap",function(){
				//阻止事件冒泡(它的父元素的click事件不会被触发)
				return false;
			});
			tapimg()
			aaa();
	//		gundo();
		//	plinput();
		if("${uuuid}"==""){
			chadotai();			
		}else{
			anidchadotai("${uuuid}");			
		}
		
    	})
    	var bbb = null;
    	var kjvm = new Vue({
						el:'.dadada',
						data : {
							hyff : []
						},
						methods:{
							plinput:function(e){
								$(e.target).parent().siblings(".zhenpldiv").css({"display":"block"});
								$(e.target).parent().siblings(".zhenpldiv").find(".xzhenpldiv").animate({
									top:0,
									width:"100%"
								},200)
							},
							zhenpldiv1:function(e){
								
								$(e.target).parent().parent(".zhenpldiv").animate({
									"background":"rgba(0,0,0,0)"//变白
								},200,function(){
									$(e.target).parent().parent(".zhenpldiv").css("display","none")//消失
									.css("background","rgba(0,0,0,0)");//变回原来的颜色 	
								});
							},
							xzhenpldiv1:function(e){
								//阻止事件冒泡(它的父元素的click事件不会被触发)
								return false;
							},
							addpl:function(e){//添加评论
								//alert($(e.target).siblings(".zhenplinput").val())
								//alert($(e.target).data("dtid"));
							var commentText=$(e.target).siblings(".zhenplinput").val();
							var stateId=$(e.target).data("dtid");
							var aa=kjvm;
								$.post("qqajax/addpl",{stateId:stateId,commentText:commentText},function(data){
									console.log(JSON.stringify(data));
										
									aa.hyff[$(".xyidian").has($(e.target)).data("kjlisindex")].dynamicStates[$(".ssnr").has($(e.target)).data("dtlisindex")].commentlis.push(data);
									//console.log($(".xyidian").has($(e.target)).data("kjlisindex")+"kj");
									//console.log($(".ssnr").has($(e.target)).data("dtlisindex")+"dt");
									//console.log(aa.hyff[$(".xyidian").has($(e.target)).data("kjlisindex")].dynamicStates[$(".ssnr").has($(e.target)).data("dtlisindex")].commentlis);
									
								})
							},
							dianzan:function(e){//点赞
							var stateId=$(e.target).data("dtid");
							var aa=kjvm;
							if($(e.target).attr("class")=="glyphicon glyphicon-thumbs-up"){
								$.post("qqajax/adddianzan",{stateId:stateId},function(data){
									aa.hyff[$(".xyidian").has($(e.target)).data("kjlisindex")].dynamicStates[$(".ssnr").has($(e.target)).data("dtlisindex")].praiseRecords.push(data);
									$(e.target).attr("class","glyphicon glyphicon-thumbs-up qbpd")
									
								})
							}else if($(e.target).attr("class")=="glyphicon glyphicon-thumbs-up qbpd"){
								$.post("qqajax/deletedianzan",{stateId:stateId},function(){
									aa.hyff[$(".xyidian").has($(e.target)).data("kjlisindex")].dynamicStates[$(".ssnr").has($(e.target)).data("dtlisindex")].praiseRecords.splice(-1,1);
									console.log(aa.hyff[$(".xyidian").has($(e.target)).data("kjlisindex")].dynamicStates[$(".ssnr").has($(e.target)).data("dtlisindex")].praiseRecords);
									$(e.target).attr("class","glyphicon glyphicon-thumbs-up")
							   })
							}
								
							
							},
							bdhuifu:function(e){//绑定id
								
								$(".ychuifuinput").val($(e.target).data("plusiddd"));//把被回复人id存到隐藏域
								$(".ychuifuinput2").val($(e.target).data("plbbid"));//把评论id存到隐藏域
								$(".huifushui").html("回复"+$(e.target).data("huifuname"));
							},
							addhuifu:function(e){//新增回复
								var aa=kjvm;
								
								var pasvUserId=$(".ychuifuinput").val();
								var replyText=$(".huifuinput").val();
								var commentId=$(".ychuifuinput2").val();
								$.post("qqajax/addhuifu",{pasvUserId:pasvUserId,replyText:replyText,commentId:commentId},function(data){
									console.log(JSON.stringify(data))
									//aa.hyff[$(".xyidian").has($(e.target)).data("kjlisindex")].dynamicStates[$(".ssnr").has($(e.target)).data("dtlisindex")]
									//.commentlis[$(".ckpldiv").has($(e.target)).data("pllisxb")].replies.push(data);
									//console.log(aa.hyff[$(".xyidian").has($(e.target)).data("kjlisindex")].dynamicStates[$(".ssnr").has($(e.target)).data("dtlisindex")]
									//.commentlis[$(".ckpldiv").has($(e.target)).data("pllisxb")])
									location="todotai";
								})
							}
						}
    				})
    	
    	$(".fass").click(function(){
    		location="toaddState?spaceId="+$(".xyidian").data("spaceid");
    	})
    	
    	function chadotai() {//查自己和好友的动态
			$.getJSON("qqajax/chadotai",{},function(data){
				kjvm.hyff=eval("("+data+")");
				
			})
		}
    	function anidchadotai(userId) {//查好友的动态
			$.getJSON("qqajax/anidchadotai",{userId:userId},function(data){
				kjvm.hyff=eval("("+data+")");
			})
		}
    	
    	
    	function plinput(){//点击评论input弹出真正的评论div
    			$(".plinputdiv").on("tap",".plinput",function(){
				$(this).parent().siblings(".zhenpldiv").css({"display":"block"});
				$(this).parent().siblings(".zhenpldiv").find(".xzhenpldiv").animate({
					top:0,
					width:"100%"
				},200)
			});
			$(".zhenpldiv").on("tap",function(){
				$(this).animate({
					"background":"rgba(0,0,0,0)"//变白
				},200,function(){
					$(this).css("display","none")//消失
					.css("background","rgba(0,0,0,0)");//变回原来的颜色 	
				});
				$(".xzhenpldiv",this).animate({
					bottom:"-240px"
				},200);
			});
			
			$(".xzhenpldiv").on("tap",function(){
				//阻止事件冒泡(它的父元素的click事件不会被触发)
				return false;
			});
    	}
    	
    //	function gundo(){//滚动变色
    //		  var h3_height = $(".di").offset().top;
    //		  var fg=$(".fg").offset().top;
    //		  var hytx=$("#hytx").offset().top;
    //		  $(window).scroll(function(){
	//	        var this_scrollTop = $(this).scrollTop();
	//	        if(this_scrollTop>h3_height ){
	//	        		$(".xfuto").css("background-color","rgba(90,116,182, 1)");
	//	        	$(".ppdiv span").css("color","white")
	//	        }else if(this_scrollTop>fg){
	//	        	$(".xfuto").css("background-color","rgba(90,116,182, 0.5)");	
	//	        	$(".ppdiv span").css("color","black")
	//	        }else if (this_scrollTop>hytx){
	//	        	$(".xfuto").css("background-color","rgba(90,116,182, 0.25)");
	//	        	$(".ppdiv span").css("color","white")
	//	        }else{
	//	        	$(".xfuto").css("background-color","rgba(0,0,0,0)");
	//	        	$(".ppdiv span").css("color","white")
	//	        }
		        
   		// });
    //	}
    	
    	function tapimg(){//图片挪动
    		$(".ssnrtudiv img").each(function(){
    			$(this).on("tap",function(){
				$(this).parent().parent().siblings(".ycimgdiv").css({"display":"block"});
				$(this).parent().parent().siblings(".ycimgdiv").find(".image-container").animate({
					top:150,
					width:"100%"
				},200)
			});	
    		})
    			
			
			$(".ycimgdiv").on("tap",function(){
				$(this).animate({
					"background":"rgba(0,0,0,0)"//变白
				},200,function(){
					$(this).css("display","none")//消失
					.css("background","rgba(0,0,0,1)");//变回原来的颜色 	
				});
				$(".image-container",this).animate({
					top:"-240px"
				},200);
			});
			
			$(".image-container").on("tap",function(){
				//阻止事件冒泡(它的父元素的click事件不会被触发)
				return false;
			});
    	}
    	function aaa(){
    		$(".ssnrtudiv img").each(function(){
    		$(this).on("tap",function(){
    		var current_image_index = 0;//当前显示第几张图片
//			获得图片的个数
			var image_count = $(this).parent().parent().siblings(".ycimgdiv").find(".image-container>img").size();
			var x_start = 0;//每次点击的x初始坐标
			var margin_left = 0;
			//为图片容器添加touch事件
			$(this).parent().parent().siblings(".ycimgdiv").find(".image-container").on("touchstart",function(){
				var touch = event.changedTouches[0];
				x_start = touch.pageX;//
				console.log("===="+x_start);
				margin_left = parseInt($(this).find("img:first-of-type").css("margin-left"));
			});
			$(this).parent().parent().siblings(".ycimgdiv").find(".image-container").on("touchmove",function(){
				event.preventDefault();//阻止屏幕默认滑动事件
				var touch = event.changedTouches[0];
				var x_current = touch.clientX;
				//计算移动距离
				var len = Math.abs(x_current - x_start);
				
//				x_current < x_start：当前的x小于起始的x，表示向左
//				current_image_index < image_count -1:如果当前显示的图片的下标小于图片的总数-1，则可以向左滑动
				if(x_current < x_start && current_image_index < image_count -1 ){//向左
					$(this).find("img:first-of-type").css({
						marginLeft : margin_left - len /*起始的位置-移动的距离*/
					});
				}else if(x_current > x_start && current_image_index > 0){ //向右
					$(this).find("img:first-of-type").css({
						marginLeft : margin_left + len
					});
				}
			});
				
			$(this).parent().parent().siblings(".ycimgdiv").find(".image-container").on("touchend",function(){
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
						$(this).find("img:first-of-type").stop().animate({
							marginLeft : left
						},200);
						current_image_index++;  //改变当前显示的图片
					}else{//不超过1/4，当前图片退回去
						var left = (-current_image_index)*100+"%";
//						改变第一个img的marginLeft,后面的img会自动跟随移动
						$(this).find("img:first-of-type").stop().animate({
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
						$(this).find("img:first-of-type").stop().animate({
							marginLeft : left
						},200);
						current_image_index--;//改变当前图片的下标
					}else{
						//滑动距离不足1/4，则自动退回去
						var left = -(current_image_index)*100+"%";
//						改变第一个img的marginLeft,后面的img会自动跟随移动
						$(this).find("img:first-of-type").stop().animate({
							marginLeft : left
						},200);
					}
				}
			});
			
			});
			})
    	}
    </script>
</html>