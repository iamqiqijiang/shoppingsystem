<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>店铺页面喔</title>
  <%@ include file="Navigation.jsp" %>
  	<style type="text/css">
  		body
	        {
	            margin: 0px;
			}
		.a{
			position:absolute;
			left:30%;
			width:20%;
			height:55px;
		}
		.a1{
			position:absolute;
			width:70%;
			height:55px;
			left:25%;
			top: 0px;
		}
		.b{
			position:absolute;
			width:20%;
			left:50%;
			height:55px;
		}
		.c{
			position:absolute;
			background-image: url(images/white.jpg);
			width:40%;
			height:auto;
			left:30%;
			top:84px;

		}
		.d{
			position:absolute;
			width:40%;
			left:30%;
			background-image: url(images/bluefuly.jpg);
			height:auto;
			top:102px;

		}
		.d1{
			background-image: url(images/prinkful.jpg);
			
			float:left;
			width:31.5%;
			height:180px;
			margin:5px 5px;
		}
		.e{
			position:absolute;
			width:6%;
			left:24%;
			top:84px;
		}
	</style>
	<script src="jquery.min.js"></script>
	<script language="JavaScript" type="text/javascript">
		$(document).ready(function () {
			  $.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "./servlet/ShopCtrl",
			    //dataType:"json",
			    data: {
			      shoppname: "${param.shoppname}",
			    },
			    success: function (data) {
				    $("#display").empty();
					var d =$.parseJSON(data);
			      	for (var i = 0; i < d.length; i++) {
			       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<br/>"+d[i].salesvolume+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'></a>&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></a></div>";
						$("#display").append(html);
			      }
			    }
			  });
			});
			
			$(document).ready(function () {
			  $.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "./servlet/CateSearchCtrl",
			    //dataType:"json",
			    data: {
			      shoppname: "${param.shoppname}",
			    },
			    success: function (data) {
				    $("#cate").empty();
					var d =$.parseJSON(data);
			      	for (var i = 0; i < d.length; i++) {
						var html1 = "<a href='#' onclick='triggera(\""+d[i].cate+"\")'><span>"+d[i].cate+"</span></a><hr/>";
						$("#cate").append(html1);
			      }
			    }
			  });
			});
			
		$(function(){
	        //按钮单击时执行
	        $("#search1").click(function(){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/SearchCtrl",
				    //dataType:"json",
				    data: {
				      shoppname: "${param.shoppname}",
				      gooddname: $("#search").val()
				    },
				    success: function (data) {
					    $("#display").empty();
						var d =$.parseJSON(data);
				      	for (var i = 0; i < d.length; i++) {
				       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<br/>"+d[i].num+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'></a>&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></a></div>";
							$("#display").append(html);
				      }
				    }
			  });
	         });
	    });
	    //导航栏搜索功能
	    function triggera(cate){
	    	$.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/SearchCateShopCtrl",
				    //dataType:"json",
				    data: {
				      shoppname: "${param.shoppname}",
				      cate: cate
				    },
				    success: function (data) {
					    $("#display").empty();
						var d =$.parseJSON(data);
				      	for (var i = 0; i < d.length; i++) {
				       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<br/>"+d[i].num+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'></a>&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></a></div>";
							$("#display").append(html);
				      }
				    }
			  });
	    }
	    //返回首页功能
	    function triggerstart(){
	    	$.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "./servlet/ShopCtrl",
			    //dataType:"json",
			    data: {
			      shoppname: "${param.shoppname}",
			    },
			    success: function (data) {
				    $("#display").empty();
					var d =$.parseJSON(data);
			      	for (var i = 0; i < d.length; i++) {
			       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<br/>"+d[i].salesvolume+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'></a>&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></a></div>";
						$("#display").append(html);
			      }
			    }
			  });
	    }
	    
	    function check(){
				var user = "<%=session.getAttribute("logincate")%>";
				if(user=="null"){
					alert("请先登录您的账号，然后进行购买！");
					return false;
				}
				return true;
			}
	</script>
	
  </head>
  
  <body style="background-image: url(images/prink-black.jpg);">
    <div class="a" >
    	<img src="images/shop3.png" style="width:20%;height:100%;"/>
    	<div class="a1">
    	<font style="color:#B22222;font-size:19px;">${param.shoppname}</font><br/>
    	<% String a=(String)request.getAttribute("shopkeeper"); %>
    	掌柜：<%=a %><br/>                 
    	店铺等级：★★★★
    	</div>
    </div>
    <div class="b" align="center">
		<form>
			<input type="text" name="search" id="search" autocomplete="off" style="top:30%; width:50%; height:45%; position:absolute; left: 10%;"><input type="button" id="search1" value="搜索" style="width:20%; height:45%; position:absolute; left: 60%; top: 30%;background:#EE0000;color:#F5FFFA;">
		</form>	
	</div>
	<div class="c">
		<a style=" font-size:16px" href="#" onclick="triggerstart()">首页</a>
	</div>
	<div class="d" id="display">
		
	</div>
	<div class="e" id="cate">
		
	</div>
  </body>
</html>
