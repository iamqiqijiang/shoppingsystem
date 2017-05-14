<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>卖家管理页面喔</title>
	<style type="text/css">
		.a{
			background:#F4A460;
			width:20%;
			min-width:150px;
		}
		.b{
			background:#CD2626;
		}
		.c{
			background:#CD1076;
		}
	</style>
	<script language="JavaScript" type="text/javascript">
		$(document).ready(function () {
			  $.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "servlet/BackManagCtrl",
			    dataType: "json",
			    data: {
			      catedata: $("#accshop").val(),
			    },
			    success: function (data) {
				    $("#accshop").empty();
					var d = eval('(' + data + ')');
			      	for (var i = 0; i < d.length; i++) {
			       		var html = "<tr><td>" + d[i].goodname + "</td><td>" + d[i].price+ "</td><td>" + d[i].address + "</td><td>" + d[i].salesvolume + "</td><td>" + d[i].shop + "</td><td>" + d[i].num + "</td><td>" + d[i].category + "</td></tr>";
						$("#accshop").append(html);
			      }
			    }
			  });
			});
	</script>
  </head>
  
  <body>
    <div class="a">
    	<font style="font-size:30px">店铺信息</font><br/>
    	店铺名：<br/>
    	掌柜：<br/>                  
    	店铺等级：
    </div>
    <a href="./servlet/BackManagCtrl">ggggg</a>
    <h2>店铺商品管理</h2>
    <div class="b">
    	<table>
    		<thead>
		    	<tr>
				   	<th>商品名</th>
				   	<th>价格</th>
				   	<th>地址</th>
				   	<th>销量</th>
				   	<th>数量</th>
				   	<th>商品类型</th>
				   	<th>管理</th>
			   	</tr>
		   	</thead>
		   	<tbody id="accshop"></tbody>
	   	</table>
    </div>
    <h2>店铺订单管理</h2>
    <div class="c">
    	asd<br/>
    	asd<br/>
    	asd<br/>
    	asd<br/>
    	asd<br/>
    </div>
  </body>
</html>
