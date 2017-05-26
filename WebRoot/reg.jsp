<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面耶</title>
    <style type="text/css">
  		body
	        {
	            margin: 0px;
			}
	</style>
  	<%@ include file="Navigation.jsp" %>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="reg.js" charset=UTF-8></script> 
    <script language="JavaScript" type="text/javascript">
		function changecus()
			{
			   	document.getElementById("cus").style.display="block";  
				document.getElementById("shop").style.display="none";
			}
		     
		function changeshop()
			{
			    document.getElementById("cus").style.display="none";  
				document.getElementById("shop").style.display="block";
			}
	</script>
	<style type="text/css">
		div.shop{
			display: none;
		}
	</style>
  </head>
  
  <body style="background-image: url(images/white-black.jpg);">
  	<div style="position:absolute; left: 43px; top: 157px;">
	    <h2 align="center">注册</h2>
	    <form method="post" action="./servlet/RegCtrl" name="form1" onSubmit="return check()">
	      <table align="center">
	    	<tr><td align="right">用户名：</td><td><input type="text" name="username" autocomplete="off"><font color="red">*</font></td></tr>
	   		<tr><td align="right">密码：</td><td><input type="text" name="password" autocomplete="off"><font color="red">*</font></td></tr>
	   		<tr><td align="right">确认密码：</td><td><input type="text" name="password1" autocomplete="off"><font color="red">*</font></td></tr>
	   		<tr><td align="right">性别：</td><td><input type="radio" name="sex" value="男">男<input type="radio" name="sex" value="女">女</td></tr>
	   		<tr><td align="right">电子邮件：</td><td><input type="text" name="email" autocomplete="off"></td></tr>
	   		<tr><td align="right">账号类别：</td><td><input type="radio" name="cate" value="顾客" checked onClick="changecus()">顾客<input type="radio" name="cate" value="店主" onClick="changeshop()">店主</td></tr>
	   		<tr><td colspan="2">————————————————</td></tr>
	   		</table>
	   		<div id="cus" class="cus" align="center">
	   		收  货  人：<input type="text" name="name" autocomplete="off"><font color="red">*</font><br/>
	   		联系电话：<input type="text" name="phone" autocomplete="off"><font color="red">*</font><br/>
	   		所在省份：&#8197;
		   		<SELECT name="province" onChange="getCity()">  
		           <OPTION VALUE="">请选择所在省份</OPTION>  
		           <OPTION VALUE="直辖市">直辖市</OPTION>  
		           <OPTION VALUE="江苏省">江苏省</OPTION>  
		           <OPTION VALUE="福建省">福建省</OPTION>  
		           <OPTION VALUE="广东省">广东省</OPTION>    
		           <OPTION VALUE="甘肃省">甘肃省</OPTION>
		           <OPTION VALUE="河北省">河北省</OPTION>
		           <OPTION VALUE="湖南省">湖南省</OPTION>  
		        </SELECT><br/>  
		        所在城市：&#8195;<SELECT name="city">    
		           <OPTION VALUE="">请选择所在城市</OPTION>    
		        </SELECT><br/>
		   		详细地址：<textarea type="text" name="address" rows="3"></textarea><font color="red">*</font>
		   	</div>
		   	<div id="shop" class="shop" align="center">
		   	店铺名：&#8195;<input type="text" name="shopname" autocomplete="off"><font color="red">*</font><br/>
		   	店主姓名：<input type="text" name="name" autocomplete="off"><font color="red">*</font><br/>
		   	身份证号：<input type="text" name="id" autocomplete="off"><font color="red">*</font><br/>
		   	请仔细阅读诚信经营承诺书！<font color="red">*</font><br/>
		   	<input type="radio" name="agree" valeu="同意">同意<input type="radio" name="agree" valeu="不同意" onClick="agree()">不同意<br/>
		  </div>
		   	<div align="center">
	   		<input type="submit" value="注册"><input type="reset" value="重置"><br/>
	   		注意：<font color="red">*</font>为必填内容！
	   	  	</div>
   		</form> 
   	</div> 		
  </body>
</html>
