<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
  	<style type="text/css">
  		body{
	            margin: 0px;
			}
		.a{
			position:absolute; 
			left: 80px;  
			top: 240px;
		}
	</style>
  	<%@ include file="Navigation.jsp" %>
  	<script src="jquery.min.js"></script>
	<script language="JavaScript" type="text/javascript">
		$(document).ready(function () {
			  $.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "./servlet/PersonalCtrl",
			    //dataType:"json",
			    data: {
			    	username: "${param.user}",
			    },
			    success: function (data) {
				    $("#b").empty();
					var d =$.parseJSON(data);
			      	for (var i = 0; i < d.length; i++) {
			       		var html = "用户名："+d[i].username+"<br/><input type='button' value='修改密码' onclick='modify()'><br/>性别："+d[i].sex+"<br/>邮箱："+d[i].email+"<br/>账户类别："+d[i].cate+"<br/>余额："+d[i].money+"<input type='button' value='充值' onclick='recharge()'><br/>真实姓名："+d[i].name+"<hr/>联系电话："+d[i].phone+"<br/>收货地址："+d[i].address+"<hr/>店铺名："+d[i].shopname+"<br/>身份证号："+d[i].id;
						$("#b").append(html);
			      }
			    }
			  });
			});
			
			function modify(){
				$("#b").empty();
				var html = "旧密码：<input type='text' id='ps1'><br/>新密码：<input type='text' id='ps2'><br/><input type='button' value='修改' onclick='modifydo()'>";
				$("#b").append(html);
			}
			
			function modifydo(){
				$.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "./servlet/ModifyPassCtrl",
			    //dataType:"json",
			    data: {
			    	username: "${param.user}",
			    	ps1: $("#ps1").val(),
			    	ps2: $("#ps2").val(),
			    },
			    success: function (data) {
				    alert("修改密码成功！");
				    window.location.reload();
			      }
			  });
			}
			
			function recharge(){
				$("#b").empty();
				var html = "请输入想要充值的金额：<br/><input type='text' id='mon'><br/><input type='button' value='充值' onclick='rechargedo()'>";
				$("#b").append(html);
			}
			
			function rechargedo(){
				$.ajax({
			    timeout: 3000,
			    async: false,
			    type: "POST",
			    url: "./servlet/RechargeCtrl",
			    //dataType:"json",
			    data: {
			    	username: "${param.user}",
			    	money: $("#mon").val(),
			    },
			    success: function (data) {
				    alert("充值成功,请尽情购买吧！");
				    window.location.reload();
			      }
			  });
			}
	</script>
  </head>
  
  <body style="background-image: url(images/white-black.jpg);">
  	<div class="a">
	   <h2 align="center">个人中心</h2>
	   <div class="b" id="b">
	   		
	   </div>
   	</div>
  </body>