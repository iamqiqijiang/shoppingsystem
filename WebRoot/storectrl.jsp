<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>卖家管理页面喔</title>
	<style type="text/css">
		.a{
			background-image: url(images/prink2.jpg);
			width:100%;
			min-width:150px;
		}
		.b{
			background-image: url(images/blue-prink.jpg);
			float:left;
			width:1000px;
		}
		font{
			font-size: 20px;
		}
		*{margin: 0;padding: 0}
		body{font-size: 12px;font-family: "宋体","微软雅黑";}
		ul,li{list-style: none;}
		a:link,a:visited{text-decoration: none;}
		.list{width: 180px;border-bottom:solid 1px #316a91;margin:0px 0 0 0;float:left;}
		.list ul li{background-color:#467ca2; border:solid 1px #316a91; border-bottom:0;}
		.list ul li a{padding-left: 10px;color: #fff; font-size:15px; display: block; font-weight:bold; height:36px;line-height: 36px;position: relative;}
		.list ul li .inactive{ background:url(images/off.png) no-repeat 155px center;}
		.list ul li .inactives{background:url(images/on.png) no-repeat 155px center;} 
		.list ul li ul{display: none;}
		.list ul li ul li { border-left:0; border-right:0; background-color:#6196bb; border-color:#467ca2;}
		.list ul li ul li ul{display: none;}
		.list ul li ul li a{ padding-left:20px;}
		.list ul li ul li ul li { background-color:#d6e6f1; border-color:#6196bb; }
		.last{ background-color:#d6e6f1; border-color:#6196bb; }
		.list ul li ul li ul li a{ color:#316a91; padding-left:30px;}
	</style>
	<script src="jquery.min.js"></script>
	<script type="text/javascript" src="storectrl.js" charset=UTF-8></script>
	<script language="JavaScript" type="text/javascript">	
	       function triggera(){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/ShopInfoCtrl",
				    //dataType:"json",
				    data: {
				      shoppname: "${param.shoppname}"
				    },
				    success: function (data) {
					    $("#b").empty();
						var d =$.parseJSON(data);
				      	for (var i = 0; i < d.length; i++) {
				       		var html = "<div align='center'><h2 align='center'>修改店铺信息</h2><table><tr><th>店铺名字：</th><td><input type='text' id='shopname' value='"+d[i].shopname+"'></td></tr><tr><th>店主名字：</th><td><input type='text' id='name' value='"+d[i].name+"'></td></tr><tr><th>身份证号：</th><td><input type='text' id='id' value='"+d[i].id+"'></td></tr><tr><th>店铺简介：</th><td><textarea id='introduction' style='width:160px;height:50px'>"+d[i].introduction+"</textarea></td></tr><tr><td colspan='2' align='center'><input type='button' id='submit1' value='修改' onclick='triggera1()' style='width:60px;'></td></tr></table></div>";
							$("#b").append(html);
				      }
				    }
			  });
	         }
	         
			function triggera1(){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/InsertInofCtrl",
				    //dataType:"json",
				    data: {
				      shopname: $("#shopname").val(),
				      name: $("#name").val(),
				      id:$("#id").val(),
				      introduction:$("#introduction").val()
				    },
				    success: function (data) {
					  alert("修改成功！");
					  $("#b").empty();
				    }
			  });
	         }
	         
	         function triggerb1(){
	         	$("#b").empty();
	         	var shopname="${param.shoppname}";
				var html = "<h2 align='center'>添加商品信息</h2><div align='center'><table border='1'><tr><th>商品名字：</th><td><input type='text' id='goodname'></td><th>商品编号：</th><td><input type='text' id='id'></td></tr><tr><th>价格：</th><td><input type='text' id='price'></td><th>地址：</th><td><input type='text' id='address'></td></tr><tr><th>销量：</th><td><input type='text' id='salevol' value='0' readOnly='true'></td><th>店铺名：</th><td><input type='text' id='shop' readOnly='true' value='"+shopname+"'></td></tr><tr><th>库存量：</th><td><input type='text' id='num'></td><th>类别：</th><td><input type='text' id='cate'></td></tr><tr><td colspan='4' align='center'><input type='button' id='submit2' value='添加' onclick='triggerb11()' style='width:60px;'></td></tr></table></div>";
				$("#b").append(html);
	         }
	         
	         function triggerb11(){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/InsertShopInfoCtrl",
				    //dataType:"json",
				    data: {
				      goodname: $("#goodname").val(),
				      address: $("#address").val(),
				      id: $("#id").val(),
				      price:$("#price").val(),
				      salevol:$("#salevol").val(),
				      num:$("#num").val(),
				      shopname:$("#shop").val(),
				      category:$("#cate").val()
				    },
				    success: function (data) {
					  alert("添加成功！");
					  $("#b").empty();
				    }
			  });
	         }
	         
	       function triggerb2(){
	       		$.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/SearchShopCtrl",
				    //dataType:"json",
				    data: {
				      shoppname: "${param.shoppname}"
				    },
				    success: function (data) {
					  	$("#b").empty();
						var d =$.parseJSON(data);
						var html1="<h2 align='center'>商品信息</h2><table><tr><th width='160px'>商品名字</th><th width='80px'>商品编号</th><th width='100px'>价格</th><th width='100px'>地址</th><th width='50px'>销量</th><th width='160px'>店铺名</th><th width='50px'>库存量</th><th width='120px'>类别</th><th width='120px'>操作</th></tr></table>";
						$("#b").append(html1);
				      	for (var i = 0; i < d.length; i++) {
				       		var html = "<table><tr><td width='160px' align='center'>"+d[i].goodname+"</td><td width='80px' align='center'>"+d[i].id+"</td><td width='100px' align='center'>"+d[i].price+"</td><td width='100px' align='center'>"+d[i].address+"</td><td width='50px' align='center'>"+d[i].salesvolume+"</td><td width='160px' align='center'>"+d[i].shop+"</td><td width='50px' align='center'>"+d[i].num+"</td><td width='120px' align='center'>"+d[i].category+"</td><td width='120px' align='center'><a href='#' onclick='triggerb21(\""+d[i].goodname+"\",\""+d[i].price+"\",\""+d[i].address+"\",\""+d[i].salevol+"\",\""+d[i].shop+"\",\""+d[i].num+"\",\""+d[i].category+"\",\""+d[i].id+"\")'>修改</a>|<a href='#' onclick='triggerb22(\""+d[i].goodname+"\")'>删除</a></td></tr></table>";
							$("#b").append(html);
					    }
				 }
			  });
	       }
	       
	       function triggerb21(goodname,price,address,salevol,shop,num,cate,id){
	         	$("#b").empty();
				var html = "<h2 align='center'>修改商品信息</h2><div align='center'><table border='1'><tr><th>商品名字：</th><td><input type='text' id='goodname' readOnly='true' value='"+goodname+"'></td><th>商品编号：</th><td><input type='text' id='id' value='"+id+"'></td></tr><tr><th>价格：</th><td><input type='text' id='price' value='"+price+"'></td><th>地址：</th><td><input type='text' id='address' value='"+address+"'></td></tr><tr><th>销量：</th><td><input type='text' id='salevol' value='0' readOnly='true' value='"+salevol+"'></td><th>店铺名：</th><td><input type='text' id='shop' readOnly='true' value='"+shop+"'></td></tr><tr><th>库存量：</th><td><input type='text' id='num' value='"+num+"'></td><th>类别：</th><td><input type='text' id='cate' value='"+cate+"'></td></tr><tr><td colspan='4' align='center'><input type='button' id='submit2' value='修改' onclick='triggerb211()' style='width:60px;'></td></tr></table></div>";
				$("#b").append(html);
	         }
	         
	        function triggerb211(){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/ModifyShopCtrl",
				    //dataType:"json",
				    data: {
				      goodname: $("#goodname").val(),
				      price: $("#price").val(),
				      id: $("#id").val(),
				      address: $("#address").val(),
				      salevol: $("#salevol").val(),
				      shop: $("#shop").val(),
				      num: $("#num").val(),
				      category: $("#cate").val(),
				    },
				    success: function (data) {
					  alert("修改成功！");
					  $("#b").empty();
				    }
			  });
	         }
	         
	          function triggerb22(goodname){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/DeleteShopCtrl",
				    //dataType:"json",
				    data: {
				      goodname: goodname,
				    },
				    success: function (data) {
					  alert("删除成功！");
					  $("#b").empty();
				    }
			  });
	         }
	         
	          function triggerc1(){
	         	$("#b").empty();
	         	var shopname="${param.shoppname}";
				var html = "<h2 align='center'>添加宝贝分类</h2><div align='center'><table border='1'><tr><th>商品名字：</th><td><input type='text' id='category'></td></tr><tr><th>店铺名：</th><td><input type='text' id='shop' readOnly='true' value='"+shopname+"'></td></tr><tr><td colspan='2' align='center'><input type='button' value='添加' onclick='triggerc11()' style='width:60px;'></td></tr></table></div>";
				$("#b").append(html);
	         }
	         
	          function triggerc11(){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/InsertCateCtrl",
				    //dataType:"json",
				    data: {
				      cate: $("#category").val(),
				      shopname: $("#shop").val()
				    },
				    success: function (data) {
					  alert("添加成功！");
					  $("#b").empty();
				    }
			  });
	         }
	         
	         function triggerc2(){
	       		$.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/CateSearchCtrl",
				    //dataType:"json",
				    data: {
				      shoppname: "${param.shoppname}"
				    },
				    success: function (data) {
					  	$("#b").empty();
						var d =$.parseJSON(data);
						var html1="<table><tr><th colspan='2' width='340px'>宝贝分类信息</th></tr><tr><th width='220px'>宝贝分类</th><th width='120px'>操作</th></tr></table>";
						$("#b").append(html1);
				      	for (var i = 0; i < d.length; i++) {
				       		var html = "<table><tr><td width='220px' align='center'>"+d[i].cate+"</td><td width='120px' align='center'><a href='#' onclick='triggerc21(\""+d[i].cate+"\")'>修改</a>|<a href='#' onclick='triggerc22(\""+d[i].cate+"\")'>删除</a></td></tr></table>";
							$("#b").append(html);
					    }
				 }
			  });
	       }
	       
	       function triggerc21(cate){
	         	$("#b").empty();
	         	var shopname="${param.shoppname}";
				var html = "<h2 align='center'>修改宝贝分类</h2><div align='center'><table border='1'><tr><th>分类名字：</th><td><input type='text' id='category' value='"+cate+"'></td></tr><tr><td colspan='2' align='center'><input type='button' value='修改' onclick='triggerc211(\""+shopname+"\",\""+cate+"\")' style='width:60px;'></td></tr></table></div>";
				$("#b").append(html);
	         }
	         
	         function triggerc211(shopname,cate){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/ModifyCateCtrl",
				    //dataType:"json",
				    data: {
				      shop: shopname,
				      category: $("#category").val(),
				      category1: cate,
				    },
				    success: function (data) {
					  alert("修改成功！");
					  $("#b").empty();
				    }
			  });
	         }
	         
	          function triggerc22(cate){
	            $.ajax({
				    timeout: 3000,
				    async: false,
				    type: "POST",
				    url: "./servlet/DeleCateCtrl",
				    //dataType:"json",
				    data: {
				      cate: cate,
				    },
				    success: function (data) {
					  alert("删除成功！");
					  $("#b").empty();
				    }
			  });
	         }
	</script>
	<%@ include file="Navigation.jsp" %>
  </head>
  
  <body >
    <div class="a">
    	<font style="font-size:35px;color:#97FFFF;">店铺管理后台</font><br/>
    	<font style="color:#9400D3;">店铺名：</font><font style="color:#54FF9F;">${param.shoppname}</font>&nbsp;&nbsp;&nbsp; 
    	<% String a=(String)request.getAttribute("shopkeeper"); %>
    	<font style="color:#9400D3;">掌柜：</font><font style="color:#54FF9F;"><%=a %> </font>&nbsp;&nbsp;&nbsp;               
    	<font style="color:#9400D3;">店铺等级：</font><font style="color:#54FF9F;">★★★★</font>
    </div>
    <div class="list">
		<ul class="yiji">
			<li><a href="#">店铺管理中心</a></li>
			<li><a href="#" class="inactive">店铺信息管理</a>
				<ul style="display: none">
					<li class="last"><a href="#" onclick="triggera()">修改店铺信息</a></li>
				</ul>
			</li>
			<li><a href="#" class="inactive">商品管理</a>
				<ul style="display: none">
					<li><a href="#" class="inactive active">商品</a>
						<ul>
							<li><a href="#" onclick="triggerb1()">添加</a></li>
							<li><a href="#" onclick="triggerb2()">修改/删除</a></li>
						</ul>
					</li> 
					<li><a href="#" class="inactive active">宝贝分类</a>
						<ul>
							<li><a href="#" onclick="triggerc1()">添加</a></li>
							<li><a href="#" onclick="triggerc2()">修改/删除</a></li>
						</ul>
					</li>
				</ul>
			</li>
			<li><a href="#" class="inactive">订单管理</a>
				<ul style="display: none">
					<li class="last"><a href="#">查看订单</a></li>
					<li class="last"><a href="#">处理订单</a></li>
					<li class="last"><a href="#">删除订单</a></li>   
				</ul>
			</li>
		</ul>
	</div>
	<div class="b" id="b">
	</div>
  </body>
</html>
