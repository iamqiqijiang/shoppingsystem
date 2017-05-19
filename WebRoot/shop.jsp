<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>店铺页面喔</title>
  	<style type="text/css">
		.a{
			position:absolute;
			background:#F00;
			left:30%;
			width:20%;
			height:55px;
		}
		.a1{
			position:absolute;
			width:70%;
			height:55px;
			left:25%;
			background:#836FFF;
			top: 0px;
		}
		.b{
			position:absolute;
			width:20%;
			left:50%;
			background:#F4A460;
			height:55px;
		}
		.c{
			position:absolute;
			background:#1C86EE;
			width:40%;
			left:30%;
			top:63px;
		}
		.d{
			position:absolute;
			width:40%;
			left:30%;
			background:#9E9E9E;
			height:auto;
			top:81px;
		}
		.d1{
			background:#6495ED;
			
			float:left;
			width:31.5%;
			height:180px;
			margin:5px 5px;
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
			       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<br/>"+d[i].num+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'>&#8195;<input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></div>";
						$("#display").append(html);
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
				       		var html = "<div class='d1'><img src='images/goods.png' style='width:100%;height:55%;'/>"+d[i].goodname+"<br/>"+d[i].price+"<br/>"+d[i].num+"已付款"+"<font style='float:right;'>"+d[i].address+"</font><br/>&#8195;&#8195;<input type='button' name='buy' value='购买' style='background:#F4A460;color:#EE4000;'>&#8195;<input type='button' name='cart' value='加入购物车' style='background:#EE7942;color:#FCFCFC;'></div>";
							$("#display").append(html);
				      }
				    }
			  });
	         });
	    });
	</script>

  </head>
  
  <body>
    <div class="a" >
    	<img src="images/shop3.png" style="width:20%;height:100%;"/>
    	<div class="a1">
    	店铺名：${param.shoppname}<br/>
    	<% String a=(String)request.getAttribute("shopkeeper"); %>
    	掌柜：<%=a %><br/>                 
    	店铺等级：★★★★
    	</div>
    </div>
    <div class="b" align="center">
		<form>
			<input type="text" name="search" id="search" autocomplete="off" style="top:30%; width:50%; height:45%; position:absolute; left: 10%;"><input type="submit" id="search1" value="搜索" style="width:20%; height:45%; position:absolute; left: 60%; top: 30%;background:#EE0000;color:#F5FFFA;">
		</form>	
	</div>
	<div class="c">
		<select id="selectcate" name="selectcate"></select>
	</div>
	<div class="d" id="display">
		<div class="d1">
			<img src="images/goods.png" style="width:100%;height:55%;"/>
			名字<br/>
			钱<br/>
			销量<font style="float:right;">aa</font><br/>
			&#8195;&#8195;<input type="button" name="buy" value="购买" style="background:#F4A460;color:#EE4000;">&#8195;<input type="button" name="cart" value="加入购物车" style="background:#EE7942;color:#FCFCFC;">
		</div>
	</div>
  </body>
</html>
