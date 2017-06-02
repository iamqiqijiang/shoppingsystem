<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%@ include file="Navigation.jsp" %>
	<style type="text/css">
		body
	        {
	            margin: 0px;
			}
		.b{
			width:1200px;
			height:60px;
			font-size:20px;
			}
		.c{
			width:1200px;
			height:800px;
			}
		.d1{
			width:250px;
			height:190px;
			float:left;
			margin:8px 15px;
			border:1px solid #C5C1AA;
			}
		}	
	</style>
	<script src="jquery.min.js"></script>
	<script language="JavaScript" type="text/javascript">
		$(document).ready(function () {
			  $.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "./servlet/SearchOneCtrl",
			    //dataType:"json",
			    data: {
			    	good:"${param.goodname}",
			    },
			    success: function (data) {
				    $("#c").empty();
					var d =$.parseJSON(data);
			      	for (var i = 0; i < d.length; i++) {
			       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<a style='float:right;' href='shop.jsp?shoppname="+d[i].shop+"'>"+d[i].shop+"</a><br/>"+d[i].salesvolume+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'></a>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></a></div>";
						$("#c").append(html);
			      }
			    }
			  });
			});
			
			function search(){
				$.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/SearchOneCtrl",
				    //dataType:"json",
				    data: {
				    	good:$("#search").val(),
				    },
				    success: function (data) {
					    $("#c").empty();
						var d =$.parseJSON(data);
				      	for (var i = 0; i < d.length; i++) {
				       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<a style='float:right;' href='shop.jsp?shoppname="+d[i].shop+"'>"+d[i].shop+"</a><br/>"+d[i].salesvolume+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'></a>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></a></div>";
							$("#c").append(html);
				      }
				    }
				  });
			}
			
			function shopsearch(shop){
				$.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/ShopCtrl",
				    //dataType:"json",
				    data: {
				    	shoppname:shop,
				    },
				    success: function (data) {
					    $("#c").empty();
						var d =$.parseJSON(data);
				      	for (var i = 0; i < d.length; i++) {
				       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<a style='float:right;' href='shop.jsp?shoppname="+d[i].shop+"'>"+d[i].shop+"</a><br/>"+d[i].salesvolume+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'></a>&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></a></div>";
							$("#c").append(html);
				      }
				    }
				  });
			}
			
			function catesearch(cate1,cate2){
				$.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/TwoCateSearchCtrl",
				    //dataType:"json",
				    data: {
				    	cate1:cate1,
				    	cate2:cate2,
				    },
				    success: function (data) {
					    $("#c").empty();
						var d =$.parseJSON(data);
				      	for (var i = 0; i < d.length; i++) {
				       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<a style='float:right;' href='shop.jsp?shoppname="+d[i].shop+"'>"+d[i].shop+"</a><br/>"+d[i].salesvolume+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'></a>&#8195;<a href='${pageContext.request.contextPath}/BuyServlet?id="+d[i].id+"' onclick='return check();'><input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></a></div>";
							$("#c").append(html);
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
  
  <body>
    <div align="center" class="a"><input type="text" name="search" id="search" autocomplete="off" style="width:400px;height:30px"><input type="button" value="搜索" onclick="search()" style="width:80px;height:30px;background:#EE7942;color:#F5FFFA;"></div>
    <div class="b">
    	宝贝分类：<a href="#" onclick="catesearch('电脑','主机')">电脑/主机</a>|<a href="#" onclick="catesearch('MP3','MP4')">MP3/MP4</a>|<a href="#" onclick="catesearch('纸巾','水壶')">纸巾/水壶</a>|<a href="#" onclick="catesearch('机甲','机器人')">机甲/机器人</a>|<a href="#" onclick="catesearch('手机','平板')">手机/平板</a><br/>
    	店铺：<a href="#" onclick="shopsearch('斯塔克工业')">斯塔克工业</a>|<a href="#" onclick="shopsearch('翔哥私人店')">翔哥私人店</a>|<a href="#" onclick="shopsearch('苹果旗舰店')">苹果旗舰店</a><br/>
    </div>
    <div class="c" id="c"></div>
  </body>
</html>
