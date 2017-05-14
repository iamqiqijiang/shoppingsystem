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
	</style>
	<script language="JavaScript" type="text/javascript">
		$(document).ready(function () {
			  $.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "WareHouse.ashx",
			    dataType: "json",
			    data: {
			      catedata: $("#selectcate").val(),
			    },
			    success: function (data) {
			      for (var i = 0; i < data.length; i++) {
			        $("#selectcate").append("<option>" + data[i].Name + "</option>");
			      }
			    }
			  });
			});
	</script>

  </head>
  
  <body>
    <div class="a" >
    	<img src="images/shop3.png" style="width:20%;height:100%;"/>
    	<div class="a1">
    	店铺名：<br/>
    	掌柜：<br/>                  
    	店铺等级：
    	</div>
    </div>
    <div class="b" align="center">
		<form>
			<input type="text" name="search" autocomplete="off" style="top:30%; width:50%; height:45%; position:absolute; left: 10%;"><input type="submit" value="搜索" style="width:20%; height:45%; position:absolute; left: 60%; top: 30%;background:#EE0000;color:#F5FFFA;">
		</form>	
	</div>
	<div class="c">
		<select id="selectcate" name="selectcate"></select>
	</div>
	<div class="d">
		dasdsadas<br/>
		dasdsadas<br/>
		dasdsadas<br/>
		dasdsadas<br/>
		dasdsadas<br/>
		dasdsadas<br/>
	</div>
  </body>
</html>
